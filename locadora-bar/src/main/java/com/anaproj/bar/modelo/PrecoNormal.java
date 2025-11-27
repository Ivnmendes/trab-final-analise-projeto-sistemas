package com.anaproj.bar.modelo;

import com.anaproj.bar.factory.Produto;

public class PrecoNormal implements EstrategiaPreco {
    @Override
    public double calcular(Produto produto) {
        return produto.getPreco();
    }
}