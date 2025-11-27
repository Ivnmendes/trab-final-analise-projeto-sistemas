package com.anaproj.bar.modelo;

import com.anaproj.bar.factory.Produto;

public interface EstrategiaPreco {
    double calcular(Produto produto);
}
