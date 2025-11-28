package com.anaproj.bar.factory;

/**
 * Classe criadora (Creator) abstrata específica para produtos de tabaco.
 * Estende ProdutoCriadora para criar produtos do tipo Tabaco.
 */
public abstract class Tabaco extends ProdutoCriadora {
    
    /**
     * Operação que usa o resultado da fábrica.
     * Demonstra como a classe criadora trabalha com o produto retornado pelo método fábrica.
     * 
     * @return descrição formatada do tabaco criado
     */
    public String vender() {
        Produto tabaco = criar();
        return "Tabaco vendido: " + tabaco.getDescricao() + " - R$" + tabaco.getPreco();
    }
}
