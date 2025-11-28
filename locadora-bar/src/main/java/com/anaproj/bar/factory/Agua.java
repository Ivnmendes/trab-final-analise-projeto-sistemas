package com.anaproj.bar.factory;

/**
 * Produto concreto: Água
 * Implementa a interface Produto com seus dados específicos.
 */
public class Agua implements Produto {
    private static final String DESCRICAO = "Água Filtrada";
    private static final double PRECO = 2.0;

    @Override
    public String getDescricao() {
        return DESCRICAO;
    }

    @Override
    public double getPreco() {
        return PRECO;
    }

    @Override
    public String toString() {
        return String.format("Agua{descricao='%s', preço=R$%.2f}", DESCRICAO, PRECO);
    }
}
