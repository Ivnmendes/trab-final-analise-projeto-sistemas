package com.anaproj.bar.modelo;

import com.anaproj.bar.factory.Produto;

public class Gerente implements ObservadorEstoque{
    @Override
    public void atualizar(Produto produto, int quantidadeRestante) {
        System.out.println("[ALERTA GERENTE] O estoque de " + produto + " está baixo! Restam apenas: " + quantidadeRestante);
    }
}
