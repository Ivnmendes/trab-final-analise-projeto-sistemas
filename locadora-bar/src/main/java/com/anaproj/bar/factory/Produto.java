package com.anaproj.bar.factory;

/**
 * Interface comum para todos os produtos (bebidas e não-bebidas)
 * Define os métodos que fazem sentido em todos os produtos.
 */
public interface Produto {
    /**
     * Retorna a descrição do produto
     * @return descrição do produto
     */
    String getDescricao();
    
    /**
     * Retorna o preço do produto
     * @return preço em reais
     */
    double getPreco();
}