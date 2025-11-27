package com.anaproj.bar.strategy;

import com.anaproj.bar.factory.Produto;

public interface EstrategiaPreco {
    double calcular(Produto produto);
}
