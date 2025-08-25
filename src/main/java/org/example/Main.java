// src/main/java/dio/padroes/projeto/Main.java
package dio.padroes.projeto;

import java.util.Scanner;

import dio.padroes.projeto.facade.Facade;
import dio.padroes.projeto.singleton.SingletonEager;
import dio.padroes.projeto.singleton.SingletonLazy;
import dio.padroes.projeto.singleton.SingletonLazyHolder;
import dio.padroes.projeto.strategy.Comportamento;
import dio.padroes.projeto.strategy.ComportamentoAgressivo;
import dio.padroes.projeto.strategy.ComportamentoDefensivo;
import dio.padroes.projeto.strategy.ComportamentoNormal;
import dio.padroes.projeto.strategy.Robo;

/**
 * Classe Main - Ponto de entrada principal da aplicação
 * Demonstra todos os padrões de projeto implementados com menu interativo
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n" + "=".repeat(50));
            System.out.println("    DEMONSTRAÇÃO DOS PADRÕES DE PROJETO");
            System.out.println("=".repeat(50));
            System.out.println("1 - Demonstrar Padrão Singleton");
            System.out.println("2 - Demonstrar Padrão Strategy");
            System.out.println("3 - Demonstrar Padrão Facade");
            System.out.println("4 - Executar todos os padrões");
            System.out.println("0 - Sair");
            System.out.println("=".repeat(50));
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    demonstrarSingleton();
                    break;
                case 2:
                    demonstrarStrategy();
                    break;
                case 3:
                    demonstrarFacade();
                    break;
                case 4:
                    executarTodosOsPadroes();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

            if (opcao != 0) {
                System.out.println("\nPressione Enter para continuar...");
                scanner.nextLine(); // Consumir quebra de linha
                scanner.nextLine(); // Aguardar Enter
            }

        } while (opcao != 0);

        scanner.close();
    }

    /**
     * Demonstra o funcionamento do padrão Singleton
     */
    private static void demonstrarSingleton() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("DEMONSTRAÇÃO DO PADRÃO SINGLETON");
        System.out.println("=".repeat(40));

        System.out.println("\n1. Singleton Lazy (Criação sob demanda):");
        SingletonLazy lazy1 = SingletonLazy.getInstancia();
        SingletonLazy lazy2 = SingletonLazy.getInstancia();
        System.out.println("   Instância 1: " + lazy1.hashCode());
        System.out.println("   Instância 2: " + lazy2.hashCode());
        System.out.println("   São iguais? " + (lazy1 == lazy2));

        System.out.println("\n2. Singleton Eager (Criação na inicialização):");
        SingletonEager eager1 = SingletonEager.getInstancia();
        SingletonEager eager2 = SingletonEager.getInstancia();
        System.out.println("   Instância 1: " + eager1.hashCode());
        System.out.println("   Instância 2: " + eager2.hashCode());
        System.out.println("   São iguais? " + (eager1 == eager2));

        System.out.println("\n3. Singleton LazyHolder (Thread-safe):");
        SingletonLazyHolder holder1 = SingletonLazyHolder.getInstancia();
        SingletonLazyHolder holder2 = SingletonLazyHolder.getInstancia();
        System.out.println("   Instância 1: " + holder1.hashCode());
        System.out.println("   Instância 2: " + holder2.hashCode());
        System.out.println("   São iguais? " + (holder1 == holder2));

        System.out.println("\n✅ Padrão Singleton: Garante uma única instância por classe!");
    }

    /**
     * Demonstra o funcionamento do padrão Strategy
     */
    private static void demonstrarStrategy() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("DEMONSTRAÇÃO DO PADRÃO STRATEGY");
        System.out.println("=".repeat(40));

        System.out.println("\nCriando um robô que pode alterar seu comportamento:");

        Comportamento normal = new ComportamentoNormal();
        Comportamento defensivo = new ComportamentoDefensivo();
        Comportamento agressivo = new ComportamentoAgressivo();

        Robo robo = new Robo();

        System.out.println("\n1. Definindo comportamento NORMAL:");
        robo.setComportamento(normal);
        robo.mover();

        System.out.println("\n2. Alterando para comportamento DEFENSIVO:");
        robo.setComportamento(defensivo);
        robo.mover();

        System.out.println("\n3. Alterando para comportamento AGRESSIVO:");
        robo.setComportamento(agressivo);
        robo.mover();

        System.out.println("\n✅ Padrão Strategy: Permite alterar algoritmos em tempo de execução!");
    }

    /**
     * Demonstra o funcionamento do padrão Facade
     */
    private static void demonstrarFacade() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("DEMONSTRAÇÃO DO PADRÃO FACADE");
        System.out.println("=".repeat(40));

        System.out.println("\nSem o padrão Facade, seria necessário:");
        System.out.println("1. Consultar API de CEP para obter cidade e estado");
        System.out.println("2. Integrar com sistema CRM para salvar cliente");
        System.out.println("3. Coordenar essas operações manualmente");

        System.out.println("\nCom o padrão Facade, basta uma chamada:");

        Facade facade = new Facade();

        System.out.println("\n→ Migrando cliente 'João Silva':");
        facade.migrarCliente("João Silva", "14801788");

        System.out.println("\n→ Migrando cliente 'Maria Santos':");
        facade.migrarCliente("Maria Santos", "01234567");

        System.out.println("\n✅ Padrão Facade: Simplifica interfaces complexas!");
    }

    /**
     * Executa demonstração de todos os padrões sequencialmente
     */
    private static void executarTodosOsPadroes() {
        demonstrarSingleton();
        demonstrarStrategy();
        demonstrarFacade();

        System.out.println("\n" + "=".repeat(50));
        System.out.println("🎉 DEMONSTRAÇÃO COMPLETA DOS PADRÕES CONCLUÍDA!");
        System.out.println("=".repeat(50));
    }
}