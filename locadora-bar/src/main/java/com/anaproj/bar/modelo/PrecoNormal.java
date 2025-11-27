package com.anaproj.bar.modelo;

public class PrecoNormal implements EstrategiaPreco {
    @Override
    public double calcular(Produto produto) {
        return produto.getPreco();
    }
}