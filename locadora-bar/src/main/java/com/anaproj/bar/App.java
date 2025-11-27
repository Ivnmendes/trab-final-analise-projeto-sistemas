package com.anaproj.bar;

import com.anaproj.bar.modelo.Agua;
import com.anaproj.bar.modelo.Cerveja;
import com.anaproj.bar.modelo.Cigarro;
import com.anaproj.bar.modelo.Produto;
import com.anaproj.bar.modelo.Whisky;
import com.anaproj.bar.modelo.Estoque;
import com.anaproj.bar.modelo.Gerente;

public class App {
    public static void main(String[] args) {
        System.out.println("--- Testando Instanciação de Produtos ---");

        Produto heineken = new Cerveja("cerveja", "Cerveja Heineken", 7.50);
        Produto brahma = new Cerveja("cerveja", "Cerveja Brahma", 5.00);

        Produto jackDaniels = new Whisky("whisky", "Whisky Jack Daniel's", 110.00);

        Produto marlboro = new Cigarro("cigarro", "Cigarro Marlboro", 12.00);
        Produto luckyStrike = new Cigarro("cigarro", "Cigarro Lucky Strike", 12.00);

        Produto agua = new Agua();

        System.out.println("Produto: " + heineken.getDescricao() + " | Preço: R$ " + heineken.getPreco());
        System.out.println("Produto: " + brahma.getDescricao() + " | Preço: R$ " + brahma.getPreco());
        System.out.println("Produto: " + jackDaniels.getDescricao() + " | Preço: R$ " + jackDaniels.getPreco());
        System.out.println("Produto: " + marlboro.getDescricao() + " | Preço: R$ " + marlboro.getPreco());
        System.out.println("Produto: " + luckyStrike.getDescricao() + " | Preço: R$ " + luckyStrike.getPreco());
        System.out.println("Produto: " + agua.getDescricao() + " | Preço: R$ " + agua.getPreco());
        
        System.out.println("\n--- Testando Estoque (Singleton & Observer) ---");

        Estoque estoque = Estoque.INSTANCIA;
        Gerente gerente = new Gerente();
        estoque.registrarObservador(gerente);

        estoque.adicionar(heineken, 20);
        estoque.adicionar(jackDaniels, 5);

        System.out.println("\n>> Vendendo 1 Heineken (Estoque vai para 19 - OK)");
        estoque.darBaixa(heineken, 1);

        System.out.println("\n>> Vendendo 2 Jack Daniels (Estoque vai para 3 - ALERTA)");
        estoque.darBaixa(jackDaniels, 2); 
    }
}
