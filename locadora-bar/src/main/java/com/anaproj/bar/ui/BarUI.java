package com.anaproj.bar.ui;

import java.util.Scanner;
import com.anaproj.bar.decorator.Gelo;
import com.anaproj.bar.decorator.Limao;
import com.anaproj.bar.factory.*;
import com.anaproj.bar.singleton.Estoque;
import com.anaproj.bar.strategy.Caixa;
import com.anaproj.bar.strategy.DescontoUniversitario;
import com.anaproj.bar.strategy.HappyHour;
import com.anaproj.bar.strategy.PrecoNormal;

public class BarUI {
    private final Caixa caixa;
    private final Scanner scanner;
    
    private final ProdutoCriadora fabricaAgua = new AguaCriadora();
    private final ProdutoCriadora fabricaCerveja = new CervejaCriadora("Cerveja Pilsen", 10.00);
    private final ProdutoCriadora fabricaWhisky = new WhiskyCriadora("Whisky Importado", 25.00);
    private final ProdutoCriadora fabricaCigarro = new CigarroCriadora("Marlboro", 12.00);

    public BarUI() {
        this.caixa = new Caixa(new PrecoNormal());
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        boolean rodando = true;
        while (rodando) {
            System.out.println("\n=== MENU BAR ===");
            System.out.println("1. Realizar Venda");
            System.out.println("2. Configurar Cobrança");
            System.out.println("3. Ver Estoque");
            System.out.println("4. Fechamento de Caixa");
            System.out.println("5. Repor Estoque");
            System.out.println("6. Registrar Perda/Quebra");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");

            int opcao = lerInteiro();

            switch (opcao) {
                case 1:
                    realizarVenda();
                    break;
                case 2:
                    alterarEstrategia();
                    break;
                case 3:
                    verificarEstoqueSimples();
                    break;
                case 4:
                    caixa.imprimirFechamentoCaixa();
                    break;
                case 5:
                    reporEstoque();
                    break;
                case 6:
                    registrarPerda();
                    break;
                case 0:
                    rodando = false;
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void registrarPerda() {
        System.out.println("\n--- REGISTRAR PERDA/QUEBRA ---");
        System.out.println("1. Água");
        System.out.println("2. Cerveja");
        System.out.println("3. Whisky");
        System.out.println("4. Cigarro");
        System.out.print("Selecione o produto avariado: ");

        int selecao = lerInteiro();
        Produto produto = null;

        switch (selecao) {
            case 1: produto = fabricaAgua.criar(); break;
            case 2: produto = fabricaCerveja.criar(); break;
            case 3: produto = fabricaWhisky.criar(); break;
            case 4: produto = fabricaCigarro.criar(); break;
            default:
                System.out.println("Produto inválido.");
                return;
        }

        System.out.print("Quantidade perdida: ");
        int qtd = lerInteiro();

        if (qtd > 0) {
            Estoque.INSTANCIA.darBaixa(produto, qtd);
            System.out.println(">> Perda registrada. O estoque foi atualizado.");
        } else {
            System.out.println("Quantidade inválida.");
        }
    }

    private void reporEstoque() {
        System.out.println("\n--- REPOSIÇÃO DE ESTOQUE ---");
        System.out.println("1. Água");
        System.out.println("2. Cerveja");
        System.out.println("3. Whisky");
        System.out.println("4. Cigarro");
        System.out.print("Selecione o produto para repor: ");

        int selecao = lerInteiro();
        Produto produto = null;

        switch (selecao) {
            case 1: produto = fabricaAgua.criar(); break;
            case 2: produto = fabricaCerveja.criar(); break;
            case 3: produto = fabricaWhisky.criar(); break;
            case 4: produto = fabricaCigarro.criar(); break;
            default:
                System.out.println("Produto inválido.");
                return;
        }

        System.out.print("Quantidade a adicionar: ");
        int qtd = lerInteiro();

        if (qtd > 0) {
            Estoque.INSTANCIA.adicionar(produto, qtd);
        } else {
            System.out.println("Quantidade inválida. Deve ser maior que zero.");
        }
    }

    private void realizarVenda() {
        System.out.println("\n--- NOVA VENDA ---");
        System.out.println("1. Água");
        System.out.println("2. Cerveja");
        System.out.println("3. Whisky");
        System.out.println("4. Cigarro");
        System.out.print("Selecione o produto: ");
        
        Produto produtoBase = null;
        int selecao = lerInteiro();

        switch (selecao) {
            case 1: produtoBase = fabricaAgua.criar(); break;
            case 2: produtoBase = fabricaCerveja.criar(); break;
            case 3: produtoBase = fabricaWhisky.criar(); break;
            case 4: produtoBase = fabricaCigarro.criar(); break;
            default: 
                System.out.println("Produto inválido.");
                return;
        }

        if (Estoque.INSTANCIA.getQuantidade(produtoBase) <= 0) {
            System.out.println("ERRO: Produto sem estoque!");
            return;
        }

        Produto produtoFinal = produtoBase;

        boolean adicionando = true;
        while (adicionando) {
            System.out.println("Adicionar extra? (1-Gelo, 2-Limão, 0-Finalizar): ");
            int extra = lerInteiro();
            
            try {
                if (extra == 1) {
                    produtoFinal = new Gelo(produtoFinal);
                    System.out.println("> Gelo adicionado.");
                } else if (extra == 2) {
                    produtoFinal = new Limao(produtoFinal);
                    System.out.println("> Limão adicionado.");
                } else {
                    adicionando = false;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("ERRO: " + e.getMessage());
            }
        }

        caixa.cobrar(produtoFinal);

        Estoque.INSTANCIA.darBaixa(produtoBase, 1);
    }

    private void alterarEstrategia() {
        System.out.println("\n--- CONFIGURAR COBRANÇA (Strategy) ---");
        System.out.println("1. Preço Normal");
        System.out.println("2. Happy Hour (50% desc, exceto tabaco)");
        System.out.println("3. Universitário (20% desc total)");
        System.out.print("Escolha a regra: ");

        int regra = lerInteiro();
        switch (regra) {
            case 1: caixa.setEstrategia(new PrecoNormal()); break;
            case 2: caixa.setEstrategia(new HappyHour()); break;
            case 3: caixa.setEstrategia(new DescontoUniversitario()); break;
            default: System.out.println("Regra inválida.");
        }
    }
    
    private void verificarEstoqueSimples() {
        System.out.println("--- ESTOQUE ATUAL ---");
        System.out.println("Água: " + Estoque.INSTANCIA.getQuantidade(fabricaAgua.criar()));
        System.out.println("Cerveja: " + Estoque.INSTANCIA.getQuantidade(fabricaCerveja.criar()));
        System.out.println("Whisky: " + Estoque.INSTANCIA.getQuantidade(fabricaWhisky.criar()));
        System.out.println("Cigarro: " + Estoque.INSTANCIA.getQuantidade(fabricaCigarro.criar()));
    }

    private int lerInteiro() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}