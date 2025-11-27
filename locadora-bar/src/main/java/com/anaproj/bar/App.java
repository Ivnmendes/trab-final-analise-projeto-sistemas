package com.anaproj.bar;

import com.anaproj.bar.modelo.Agua;
import com.anaproj.bar.modelo.Cerveja;
import com.anaproj.bar.modelo.Cigarro;
import com.anaproj.bar.modelo.Produto;
import com.anaproj.bar.modelo.Whisky;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("--- Testando Instanciação de Produtos ---");

        Produto heineken = new Cerveja("Cerveja Heineken", 7.50);
        Produto brahma = new Cerveja("Cerveja Brahma", 5.00);

        Produto jackDaniels = new Whisky("Whisky Jack Daniel's", 110.00);

        Produto marlboro = new Cigarro("Cigarro Marlboro", 12.00);
        Produto luckyStrike = new Cigarro("Cigarro Lucky Strike", 12.00);

        Produto agua = new Agua();

        System.out.println("Produto: " + heineken.getDescricao() + " | Preço: R$ " + heineken.getPreco());
        System.out.println("Produto: " + brahma.getDescricao() + " | Preço: R$ " + brahma.getPreco());
        System.out.println("Produto: " + jackDaniels.getDescricao() + " | Preço: R$ " + jackDaniels.getPreco());
        System.out.println("Produto: " + marlboro.getDescricao() + " | Preço: R$ " + marlboro.getPreco());
        System.out.println("Produto: " + luckyStrike.getDescricao() + " | Preço: R$ " + luckyStrike.getPreco());
        System.out.println("Produto: " + agua.getDescricao() + " | Preço: R$ " + agua.getPreco());

    }
}
