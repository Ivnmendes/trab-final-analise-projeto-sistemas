package com.anaproj.bar.modelo;

public class HappyHour implements EstrategiaPreco {
    @Override
    public double calcular(Produto produto) {
        if (produto instanceof Cigarro) {
            System.out.println("   (Aviso: Cigarro não tem desconto de Happy Hour)");
            return produto.getPreco();
        }
        
        return produto.getPreco() * 0.5;
    }
}