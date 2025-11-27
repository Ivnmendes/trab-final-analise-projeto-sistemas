package com.anaproj.bar.singleton;

import java.util.HashMap;
import java.util.Map;

import com.anaproj.bar.factory.Produto;
import com.anaproj.bar.observer.EstoqueSubject;
import com.anaproj.bar.observer.ObservadorEstoque;

public enum Estoque {
    INSTANCIA;

    private final Map<String, Integer> quantidades = new HashMap<>();
    private final EstoqueSubject subject = new EstoqueSubject();

    public void registrarObservador(ObservadorEstoque obs) {
        subject.registrarObservador(obs);
    }

    public void adicionar(Produto produto, int qtd) {
        String descricaoProduto = produto.getDescricao();
        quantidades.put(descricaoProduto, quantidades.getOrDefault(descricaoProduto, 0) + qtd);
        System.out.println("Estoque: Adicionado " + qtd + " de " + descricaoProduto);
    }

    public void darBaixa(Produto produto, int qtd) {
        String descricaoProduto = produto.getDescricao();
        if (!quantidades.containsKey(descricaoProduto)) {
            System.out.println("Erro: Produto " + descricaoProduto + " não existe no estoque.");
            return;
        }

        int atual = quantidades.get(descricaoProduto);
        if (atual >= qtd) {
            int novaQtd = atual - qtd;
            quantidades.put(descricaoProduto, novaQtd);
            System.out.println("Estoque: Baixa de " + qtd + " em " + descricaoProduto);

            if (novaQtd < 5) {
                subject.notificarObservadores(produto, novaQtd);
            }
        } else {
            System.out.println("Erro: Estoque insuficiente de " + descricaoProduto);
        }
    }

    public int getQuantidade(Produto produto) {
        return quantidades.getOrDefault(produto.getDescricao(), 0);
    }
}
