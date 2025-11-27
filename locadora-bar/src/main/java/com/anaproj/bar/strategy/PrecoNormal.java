package com.anaproj.bar.strategy;

import com.anaproj.bar.factory.Produto;

public class PrecoNormal implements EstrategiaPreco {
    @Override
    public double calcular(Produto produto) {
        return produto.getPreco();
    }
}