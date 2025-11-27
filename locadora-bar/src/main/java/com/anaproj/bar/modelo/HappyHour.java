package com.anaproj.bar.modelo;

public class HappyHour implements EstrategiaPreco {
    @Override
    public double calcular(double valorOriginal) {
        return valorOriginal * 0.5;
    }
}