package com.anaproj.bar.modelo;

import com.anaproj.bar.factory.Produto;

public interface ObservadorEstoque {
    void atualizar(Produto produto, int quantidadeRestante);
}
