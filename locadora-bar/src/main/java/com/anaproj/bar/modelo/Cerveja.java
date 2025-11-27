package com.anaproj.bar.modelo;

public class Cerveja implements Bebida {
    private final String id;
    private final String descricao;
    private final double preco;

    public Cerveja(String id, String descricao, double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo");
        }
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getId() {
        return this.id;
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
        return String.format("Cerveja{id='%s', descricao='%s', preço=R$%.2f}", id, descricao, preco);
    }
}
