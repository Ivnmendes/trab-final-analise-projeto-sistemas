package com.anaproj.bar.factory;

/**
 * Criadora concreta (Concrete Creator) para Cerveja.
 * Implementa o método fábrica para criar produtos do tipo Cerveja.
 */
public class CervejaCriadora extends Bebida {
    private final String descricao;
    private final double preco;

    public CervejaCriadora(String descricao, double preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    /**
     * Implementação do método fábrica que cria um produto Cerveja.
     * 
     * @return uma nova instância de Cerveja com os dados armazenados
     */
    @Override
    public Produto criar() {
        return new Cerveja(descricao, preco);
    }
}
