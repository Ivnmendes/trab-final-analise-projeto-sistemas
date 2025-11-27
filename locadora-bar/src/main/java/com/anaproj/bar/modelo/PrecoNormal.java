package com.anaproj.bar.modelo;

public class PrecoNormal implements EstrategiaPreco {
    @Override
    public double calcular(double valorOriginal) {
        return valorOriginal;
    }
}