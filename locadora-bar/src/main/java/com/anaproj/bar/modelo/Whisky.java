package com.anaproj.bar.modelo;

public class Whisky implements Bebida {
    private final String descricao;
    private final double preco;

    public Whisky(String descricao, double preco) {
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
