package dio.padroes.projeto;

import dio.padroes.projeto.facade.Facade;
import dio.padroes.projeto.singleton.*;
import dio.padroes.projeto.strategy.*;

public class Test {
    public static void main(String[] args) {
        System.out.println("=== TESTES PADRÃO SINGLETON ===");

        // Singleton
        SingletonLazy lazy = SingletonLazy.getInstancia();
        System.out.println("Singleton Lazy: " + lazy);
        lazy = SingletonLazy.getInstancia();
        System.out.println("Singleton Lazy: " + lazy);

        System.out.println("\n=== TESTES PADRÃO STRATEGY ===");

        // Strategy
        Comportamento defensivo = new ComportamentoDefensivo();
        Comportamento normal = new ComportamentoNormal();
        Comportamento agressivo = new ComportamentoAgressivo();

        Robo robo = new Robo();
        robo.setComportamento(normal);
        robo.mover();
        robo.setComportamento(defensivo);
        robo.mover();
        robo.setComportamento(agressivo);
        robo.mover();

        System.out.println("\n=== TESTES PADRÃO FACADE ===");

        // Facade
        Facade facade = new Facade();
        facade.migrarCliente("João Silva", "14801788");
    }
}