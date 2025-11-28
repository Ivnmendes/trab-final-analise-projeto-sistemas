package com.anaproj.bar.factory;

/**
 * Classe criadora (Creator) abstrata específica para bebidas.
 * Estende ProdutoCriadora e adiciona comportamento específico para bebidas.
 */
public abstract class Bebida extends ProdutoCriadora {
    
    /**
     * Operação que usa o resultado da fábrica.
     * Demonstra como a classe criadora trabalha com o produto retornado pelo método fábrica.
     * 
     * @return descrição formatada da bebida criada
     */
    public String preparar() {
        Produto bebida = criar();
        return "Bebida preparada: " + bebida.getDescricao() + " - R$" + bebida.getPreco();
    }
}
