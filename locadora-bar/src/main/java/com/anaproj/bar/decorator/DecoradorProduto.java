package com.anaproj.bar.decorator;

import com.anaproj.bar.factory.Produto;

public abstract class DecoradorProduto implements Produto {
    protected Produto produtoDecorado;

    public DecoradorProduto(Produto produto) {
        this.produtoDecorado = produto;
    }

    @Override
    public String getDescricao() {
        return produtoDecorado.getDescricao();
    }

    @Override
    public double getPreco() {
        return produtoDecorado.getPreco();
    }
}