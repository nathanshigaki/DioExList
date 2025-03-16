package org.compras;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
        Item item = new Item(null, 0, 0);
        Scanner scanner = new Scanner(System.in);
        
        int n = 0;
        
        while (n != 5){
            System.out.println("""
                Escolha uma opção:

                [ 0 ] Adicionar item automaticamente.
                [ 1 ] Adicionar item manualmente.
                [ 2 ] Exibir itens.
                [ 3 ] Remover item.
                [ 4 ] Finalizar compra.
            """);
            
            n = scanner.nextInt();

            switch (n) {
                case 0: 
                    carrinhoDeCompras.adicionarItem("Lápis", 2, 3);
                    carrinhoDeCompras.adicionarItem("Lápis", 2, 3);
                    carrinhoDeCompras.adicionarItem("Caderno", 35, 1);
                    carrinhoDeCompras.adicionarItem("Borracha", 2, 2);
                    break;
                case 1: //preguiça de por as exceptions
                    System.out.print("Digite o nome do item: ");
                    String nome = scanner.nextLine();
                    item.setNome(nome);
                    System.out.print("Digite o valor do item: ");
                    double valor = scanner.nextDouble();
                    item.setPreco(valor);
                    System.out.print("Digite a quantidade do item: ");
                    int quantidade = scanner.nextInt();
                    item.setQuantidade(quantidade);

                default:
                    break;
            }
        
            carrinhoDeCompras.exibirItens();
        
            carrinhoDeCompras.removerItem("Lápis");
        
            carrinhoDeCompras.exibirItens();
        
            System.out.println("O valor total da compra é = " + carrinhoDeCompras.calcularValorTotal());
        }
        scanner.close();
      }
}
