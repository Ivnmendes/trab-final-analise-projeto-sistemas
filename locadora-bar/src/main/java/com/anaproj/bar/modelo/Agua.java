package com.anaproj.bar.modelo;

public class Agua implements Bebida {
    @Override
    public String getDescricao() {
        return "Água";
    }

    @Override
    public double getPreco() {
        return 2.0;
    }
}
