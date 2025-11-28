package com.anaproj.bar.factory;

/**
 * Produto concreto: Whisky
 * Implementa a interface Produto com seus dados específicos.
 */
public class Whisky implements Produto {
    private final String descricao;
    private final double preco;

    public Whisky(String descricao, double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo");
        }
        this.descricao = descricao;
        this.preco = preco;
    }

    @Override
    public String getDescricao() {
        return this.descricao;
    }

    @Override
    public double getPreco() {
        return this.preco;
    }

    @Override
    public String toString() {
        return String.format("Whisky{descricao='%s', preço=R$%.2f}", descricao, preco);
    }
}
