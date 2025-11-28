package com.anaproj.bar.factory;

/**
 * Classe criadora (Creator) abstrata base para o Factory Method Pattern.
 * Define o método fábrica abstrato que todas as subclasses devem implementar.
 */
public abstract class ProdutoCriadora {
    
    /**
     * Método fábrica abstrato que retorna um produto específico.
     * Subclasses devem sobrescrever este método para criar tipos específicos de produtos.
     * 
     * @return um objeto do tipo Produto
     */
    public abstract Produto criar();
}
