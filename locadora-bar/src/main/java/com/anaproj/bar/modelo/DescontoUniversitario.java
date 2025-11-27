package com.anaproj.bar.modelo;

public class DescontoUniversitario implements EstrategiaPreco {
    @Override
    public double calcular(Produto produto) {
        return produto.getPreco() * 0.8;
    }
}
