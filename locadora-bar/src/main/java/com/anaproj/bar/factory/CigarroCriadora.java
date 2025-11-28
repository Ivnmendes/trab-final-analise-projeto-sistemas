package com.anaproj.bar.factory;

/**
 * Criadora concreta (Concrete Creator) para Cigarro.
 * Implementa o método fábrica para criar produtos do tipo Cigarro.
 */
public class CigarroCriadora extends Tabaco {
    private final String descricao;
    private final double preco;

    public CigarroCriadora(String descricao, double preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    /**
     * Implementação do método fábrica que cria um produto Cigarro.
     * 
     * @return uma nova instância de Cigarro com os dados armazenados
     */
    @Override
    public Produto criar() {
        return new Cigarro(descricao, preco);
    }
}
