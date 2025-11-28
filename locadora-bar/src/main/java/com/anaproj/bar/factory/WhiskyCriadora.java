package com.anaproj.bar.factory;

/**
 * Criadora concreta (Concrete Creator) para Whisky.
 * Implementa o método fábrica para criar produtos do tipo Whisky.
 */
public class WhiskyCriadora extends Bebida {
    private final String descricao;
    private final double preco;

    public WhiskyCriadora(String descricao, double preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    /**
     * Implementação do método fábrica que cria um produto Whisky.
     * 
     * @return uma nova instância de Whisky com os dados armazenados
     */
    @Override
    public Produto criar() {
        return new Whisky(descricao, preco);
    }
}
