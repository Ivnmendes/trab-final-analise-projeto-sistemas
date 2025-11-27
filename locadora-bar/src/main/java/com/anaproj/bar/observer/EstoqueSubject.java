package com.anaproj.bar.observer;

import java.util.ArrayList;
import java.util.List;

import com.anaproj.bar.factory.Produto;

public class EstoqueSubject {
    private final List<ObservadorEstoque> observadores = new ArrayList<>();

    public void registrarObservador(ObservadorEstoque obs) {
        observadores.add(obs);
    }

    protected void notificarObservadores(Produto produto, int qtd) {
        for (ObservadorEstoque obs : observadores) {
            obs.atualizar(produto, qtd);
        }
    }
}
