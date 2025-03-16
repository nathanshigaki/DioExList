package org.compras;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> itemLista;

    public CarrinhoDeCompras(){
        this.itemLista = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        itemLista.add(new Item(nome, preco, quantidade));
        System.out.println("Item adicionado com sucesso");
    }

    public void removerItem(String nome){
        if (!itemLista.isEmpty()){
            List<Item> remover = new ArrayList<>();
            for (Item item : itemLista) {
                if (item.getNome().equalsIgnoreCase(nome)) {
                    remover.add(item);
                }
            }
            itemLista.removeAll(remover);
        } else {
            System.out.println("Lista vazia.");
        }
    }

    public double calcularValorTotal(){
        if (!itemLista.isEmpty()){
            double valorTotal = 0;
            for (Item item : itemLista) {
                double valor = item.getPreco() * item.getQuantidade();
                valorTotal += valor;
            }
            return valorTotal;
        } else {
            System.out.println("Lista vazia");
            return 0;
        }
    }

    public void exibirItens(){
        if (!itemLista.isEmpty()) {
            for (Item item : itemLista) {
                System.out.println(item.getNome() +" R$"+ item.getPreco() +" Quantidade: "+ item.getQuantidade());
            }
        } else {
            System.out.println("Lista vazia");
        }
    }
}
