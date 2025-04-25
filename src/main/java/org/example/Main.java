package org.example;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ContaBancaria conta = new ContaExecutiva(1000);

        char opcao;
        do {
            // Exibe o saldo atual
            System.out.println("\nSaldo atual: R$" + conta.getSaldo());

            // Pergunta ao usuário o que deseja fazer
            System.out.print("Escolha uma opção (D = depositar, S = sacar, F = fim): ");
            opcao = scanner.next().toUpperCase().charAt(0);

            try {
                switch (opcao) {
                    case 'D' -> {
                        System.out.print("Digite o valor para depositar: R$");
                        double valorDeposito = scanner.nextDouble();
                        conta.depositar(valorDeposito);
                    }
                    case 'S' -> {
                        System.out.print("Digite o valor para sacar: R$");
                        double valorSaque = scanner.nextDouble();
                        conta.sacar(valorSaque);
                    }
                    case 'F' -> System.out.println("Fim do programa.");
                    default -> System.out.println("Opção inválida.");
                }
            } catch (IllegalArgumentException e) {
                // Captura a exceção e exibe a mensagem
                System.out.println("Erro: " + e.getMessage());
            }

        } while (opcao != 'F');

        scanner.close();
    }
}