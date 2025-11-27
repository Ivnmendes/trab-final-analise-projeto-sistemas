package com.anaproj.bar.modelo;

public class Cerveja implements Bebida {
    private final String descricao;
    private final double preco;

    public Cerveja(String descricao, double preco) {
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
}
