package com.anaproj.bar.modelo;

public class Agua implements Bebida {
    private static final String ID = "agua";
    private static final String DESCRICAO = "Água Filtrada";
    private static final double PRECO = 2.0;

    public String getId() {
        return ID;
    }

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
        return String.format("Agua{id='%s', descricao='%s', preço=R$%.2f}", ID, DESCRICAO, PRECO);
    }
}
