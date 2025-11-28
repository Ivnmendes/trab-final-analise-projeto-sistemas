package com.anaproj.bar.factory;

public class Agua implements Bebida {
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
