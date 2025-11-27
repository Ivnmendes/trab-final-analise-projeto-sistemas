# Padrões de Projeto - Simulação de Bar (Versão Corrigida)

## 📋 Índice
1. [SINGLETON](#singleton)
2. [FACTORY METHOD](#factory-method)
3. [DECORATOR](#decorator)
4. [STRATEGY](#strategy)
5. [OBSERVER](#observer)

---

## SINGLETON

### O que é?
Um padrão criacional que **garante que uma classe tenha apenas uma instância** e fornece um ponto global de acesso a ela.

### Problema que resolve
Evita inconsistências no estado compartilhado (ex: contagem de estoque) causadas por múltiplos objetos manipulando os mesmos dados sem sincronia.

### Solução 1: Thread-Safe Otimizada (Double-Checked Locking)
Esta é a implementação clássica para garantir performance e segurança em ambientes multithread.

```java
public class Estoque {
    // 'volatile' garante que a variável seja lida corretamente por todas as threads
    private static volatile Estoque instancia;
    private final Map<String, Integer> quantidades = new HashMap<>();

    private Estoque() {}

    public static Estoque obterInstancia() {
        if (instancia == null) { // 1ª verificação (sem bloqueio)
            synchronized (Estoque.class) {
                if (instancia == null) { // 2ª verificação (com bloqueio)
                    instancia = new Estoque();
                }
            }
        }
        return instancia;
    }
    
    public void adicionar(String item, int qtd) {
        quantidades.put(item, quantidades.getOrDefault(item, 0) + qtd);
    }
}
```

### Solução 2: Enum (Recomendada pelo 'Effective Java')
A maneira mais concisa e segura contra ataques de serialização e reflection.

```java
public enum EstoqueEnum {
    INSTANCIA;
    
    private final Map<String, Integer> quantidades = new HashMap<>();
    
    public void adicionar(String item, int qtd) {
        quantidades.put(item, quantidades.getOrDefault(item, 0) + qtd);
    }
}

// Uso:
EstoqueEnum.INSTANCIA.adicionar("cerveja", 10);
```

---

## FACTORY METHOD

### O que é?
Um padrão criacional que define uma interface para criar um objeto, mas **deixa as subclasses decidirem qual classe instanciar**. O Factory Method permite adiar a instanciação para subclasses.

*(Nota: A versão anterior com `if/else` era uma "Simple Factory". A versão abaixo é o padrão GoF real).*

### Problema que resolve
O código cliente não deve saber a classe exata do objeto que precisa ser criado, nem a lógica complexa de sua construção. Também evita condicionais gigantes (`if tipo == 'a' ...`).

### Solução

**1. O Produto (Interface comum)**
```java
public interface Bebida {
    void servir();
}
```

**2. O Criador (A Fábrica Abstrata)**
```java
public abstract class BebidaFactory {
    // Este é o Factory Method
    public abstract Bebida criarBebida();

    // Método que usa o produto (opcional, mas comum)
    public void prepararEntrega() {
        Bebida b = criarBebida();
        System.out.println("--- Iniciando Pedido ---");
        b.servir();
    }
}
```

**3. Criadores Concretos**
```java
public class CervejaFactory extends BebidaFactory {
    @Override
    public Bebida criarBebida() {
        // Lógica específica de criação da Cerveja
        return new Cerveja("Brahma", 8.50);
    }
}

public class WhiskyFactory extends BebidaFactory {
    @Override
    public Bebida criarBebida() {
        return new Whisky("Red Label", 45.00);
    }
}
```

### Uso no Projeto
```java
// O cliente trabalha com a abstração da fábrica
BebidaFactory fabrica = new CervejaFactory();
fabrica.prepararEntrega(); 

// Se quiser mudar para Whisky, troca apenas a instância da fábrica
fabrica = new WhiskyFactory();
fabrica.prepararEntrega();
```

### Vantagens
- ✅ Segue o Princípio Open/Closed: Adiciona novas bebidas criando novas fábricas, sem tocar no código existente.
- ✅ Elimina condicionais grandes na criação.

---

## DECORATOR

### O que é?
Um padrão estrutural que **anexa responsabilidades adicionais a um objeto dinamicamente**. Os decoradores fornecem uma alternativa flexível à submissão para estender funcionalidades.

### Problema que resolve
Explosão de subclasses ao tentar combinar características (ex: `CervejaComGelo`, `CervejaComLimao`, `CervejaComGeloELimao`).

### Solução
```java
// Componente
public interface Bebida {
    String getDescricao();
    double getPreco();
}

// Concreto
public class Cerveja implements Bebida {
    public String getDescricao() { return "Cerveja"; }
    public double getPreco() { return 10.0; }
}

// Decorador Base
public abstract class DecoradorBebida implements Bebida {
    protected Bebida bebidaDecorada;
    
    public DecoradorBebida(Bebida bebida) {
        this.bebidaDecorada = bebida;
    }
}

// Decoradores Concretos
public class Gelo extends DecoradorBebida {
    public Gelo(Bebida b) { super(b); }
    
    public String getDescricao() { return bebidaDecorada.getDescricao() + " + Gelo"; }
    public double getPreco() { return bebidaDecorada.getPreco() + 1.0; }
}

public class Limao extends DecoradorBebida {
    public Limao(Bebida b) { super(b); }
    
    public String getDescricao() { return bebidaDecorada.getDescricao() + " + Limão"; }
    public double getPreco() { return bebidaDecorada.getPreco() + 0.50; }
}
```

### Uso no Projeto
```java
Bebida minhaBebida = new Cerveja();
minhaBebida = new Gelo(minhaBebida);  // Adiciona Gelo
minhaBebida = new Limao(minhaBebida); // Adiciona Limão

System.out.println(minhaBebida.getDescricao()); // Cerveja + Gelo + Limão
System.out.println(minhaBebida.getPreco());     // 11.50
```

---

## STRATEGY

### O que é?
Um padrão comportamental que **define uma família de algoritmos, encapsula cada um deles e os torna intercambiáveis**. O Strategy permite que o algoritmo varie independentemente dos clientes que o utilizam.

### Problema que resolve
Muitos `if/else` dentro de uma classe para decidir regras de negócio (ex: cálculo de preço em Happy Hour vs Normal).

### Solução
```java
// A Estratégia (Interface)
public interface EstrategiaPreco {
    double calcular(double precoBase);
}

// Estratégias Concretas
public class PrecoNormal implements EstrategiaPreco {
    public double calcular(double precoBase) { return precoBase; }
}

public class HappyHour implements EstrategiaPreco {
    public double calcular(double precoBase) { return precoBase * 0.5; } // 50% off
}

// Contexto
public class Caixa {
    private EstrategiaPreco estrategia;

    public Caixa(EstrategiaPreco estrategia) {
        this.estrategia = estrategia;
    }
    
    // Permite troca em tempo de execução
    public void setEstrategia(EstrategiaPreco estrategia) {
        this.estrategia = estrategia;
    }

    public double cobrar(double valor) {
        return estrategia.calcular(valor);
    }
}
```

### Uso no Projeto
```java
Caixa caixa = new Caixa(new PrecoNormal());
System.out.println(caixa.cobrar(100)); // 100.0

caixa.setEstrategia(new HappyHour());
System.out.println(caixa.cobrar(100)); // 50.0
```

---

## OBSERVER

### O que é?
Um padrão comportamental que define uma dependência um-para-muitos entre objetos, de modo que **quando um objeto muda de estado, todos os seus dependentes são notificados e atualizados automaticamente**.

### Problema que resolve
Necessidade de componentes reagirem a eventos (ex: Gerente precisa saber quando estoque acaba) sem criar um acoplamento rígido entre as classes.

### Solução
```java
// Interface Observador (Quem escuta)
public interface ObservadorEstoque {
    void atualizar(String produto, int quantidade);
}

// O Sujeito (Quem é observado)
public class EstoqueSubject {
    private List<ObservadorEstoque> observadores = new ArrayList<>();
    
    public void registrar(ObservadorEstoque obs) {
        observadores.add(obs);
    }
    
    public void notificar(String produto, int qtd) {
        for (ObservadorEstoque obs : observadores) {
            obs.atualizar(produto, qtd);
        }
    }
    
    public void darBaixa(String produto, int novaQtd) {
        // Lógica de baixa...
        if (novaQtd < 5) {
            notificar(produto, novaQtd);
        }
    }
}

// Implementação do Observador
public class Gerente implements ObservadorEstoque {
    public void atualizar(String produto, int quantidade) {
        System.out.println("GERENTE: Atenção! Repor " + produto + ". Restam: " + quantidade);
    }
}
```

### Uso no Projeto
```java
EstoqueSubject estoque = new EstoqueSubject();
Gerente gerente = new Gerente();

estoque.registrar(gerente);

estoque.darBaixa("Vodka", 3);
// Output: GERENTE: Atenção! Repor Vodka. Restam: 3
```

---

## 📝 Resumo Visual Atualizado

| Padrão | Categoria | Problema | Solução Resumida |
|--------|-----------|----------|------------------|
| **SINGLETON** | Criacional | Instâncias duplicadas de recursos únicos | Construtor privado + Método estático |
| **FACTORY METHOD** | Criacional | Acoplamento com classes concretas (`new`) | Delegar criação para subclasses (polimorfismo) |
| **DECORATOR** | Estrutural | Explosão de subclasses para combinações | "Embrulhar" objetos em runtime |
| **STRATEGY** | Comportamental | Excesso de condicionais de regras | Algoritmos intercambiáveis (injeção) |
| **OBSERVER** | Comportamental | Componentes precisam monitorar outros | Assinatura de eventos (Publish/Subscribe) |
