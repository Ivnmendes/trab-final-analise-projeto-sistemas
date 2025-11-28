package com.anaproj.bar.factory;

/**
 * Criadora concreta (Concrete Creator) para Água.
 * Implementa o método fábrica para criar produtos do tipo Água.
 */
public class AguaCriadora extends Bebida {

    /**
     * Implementação do método fábrica que cria um produto Água.
     * 
     * @return uma nova instância de Água
     */
    @Override
    public Produto criar() {
        return new Agua();
    }
}
