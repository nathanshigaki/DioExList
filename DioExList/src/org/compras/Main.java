package org.compras;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
        Item item = new Item(null, 0, 0);
        Scanner scanner = new Scanner(System.in);
        
        int n = 0;
        
        while (n != 4){
            System.out.println("""

            [ 1 ] Adicionar item manualmente.
            [ 2 ] Exibir itens.
            [ 3 ] Remover item.
            [ 4 ] Finalizar compra.

            Escolha uma opção: """);
            
            n = scanner.nextInt();
            scanner.nextLine();

            switch (n) {
                case 1 -> {
                    try{
                        System.out.print("\nDigite o nome do item: ");
                        String nome = scanner.nextLine().trim();
                        if (nome.isBlank()) throw new IllegalArgumentException("Obrigatório ter um nome.");
                        item.setNome(nome);
                        System.out.print("Digite o valor do item: ");
                        double valor = scanner.nextDouble();
                        if (valor <= 0) throw new IllegalArgumentException("O valor do item não pode ser negativo.");
                        item.setPreco(valor);
                        System.out.print("Digite a quantidade do item: ");
                        int quantidade = scanner.nextInt();
                        if (quantidade <= 0) throw new IllegalArgumentException("O valor do item não pode ser negativo.");
                        item.setQuantidade(quantidade);
                        System.out.println(" ");
                        carrinhoDeCompras.adicionarItem(item.getNome(), item.getPreco(), item.getQuantidade());
                    } catch (InputMismatchException e){
                        System.out.println("Erro: Entrada inválida! " + e.getMessage());
                    } catch (IllegalArgumentException e){
                        System.out.println("Erro: " + e.getMessage());
                    }
                }
                case 2 -> carrinhoDeCompras.exibirItens();
                case 3 -> {
                    System.out.print("\nDigite o nome do item que deseja retirar: ");
                    String nome = scanner.nextLine();
                    item.setNome(nome);
                    carrinhoDeCompras.removerItem(item.getNome());
                }
                case 4 -> System.out.println("O valor total da compra é = " + carrinhoDeCompras.calcularValorTotal());
                default -> System.out.println("Opção inválida, tente novamente.");
            }
        }
        scanner.close();
      }
}
