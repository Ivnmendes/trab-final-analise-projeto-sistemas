package com.anaproj.bar.modelo;

public class Caixa {
    private EstrategiaPreco estrategia;

    public Caixa(EstrategiaPreco estrategiaInicial) {
        this.estrategia = estrategiaInicial;
    }

    public void setEstrategia(EstrategiaPreco estrategia) {
        this.estrategia = estrategia;
        System.out.println("--- CAIXA: Regra de preço alterada ---");
    }

    public void cobrar(Produto produto) {
        double valorFinal = estrategia.calcular(produto.getPreco());
        System.out.println(String.format("CAIXA: Cobrando '%s'. Valor Final: R$ %.2f", 
            produto.getDescricao(), valorFinal));
    }
}