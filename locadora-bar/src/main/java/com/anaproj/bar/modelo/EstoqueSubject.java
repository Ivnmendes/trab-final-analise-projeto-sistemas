package com.anaproj.bar.modelo;

import java.util.ArrayList;
import java.util.List;

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
