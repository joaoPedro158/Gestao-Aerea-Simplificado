package Impl;

import Comparador.ComparadorPrioridade;
import Interface.Embarque;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class EmbarqueImpl implements Embarque {

    LinkedList<Passageiro> filaPassageiro = new LinkedList<>();
    PriorityQueue<Passageiro> filaPrioridade = new PriorityQueue<>(new ComparadorPrioridade());
    LinkedList<Passageiro> ListaPassageiroCadastrado =  new LinkedList<>();
    Stack<Passageiro> historicoEmbarque = new Stack<>();

    @Override
    public void venderPassagem(Passageiro passageiro) {
        ListaPassageiroCadastrado.addLast(passageiro);
        System.out.println("Passagem vendida para: " + passageiro);
    }

    @Override
    public void listarPassageiroCadastrado() {
        for (Passageiro p :  ListaPassageiroCadastrado) {
            System.out.println(p);
        }
    }


    @Override
    public void cancelarPassagem(String documento) {
        Passageiro p = buscarPassageiro(documento);
        if (p != null) {
            ListaPassageiroCadastrado.remove(p);
            System.out.println("Passagem cancelada com sucesso.");
        }
    }


    @Override
    public void inserirFilaComum(String documento) {
       Passageiro p = buscarPassageiro(documento);
       if(p != null) {
           ListaPassageiroCadastrado.remove(p);
           filaPassageiro.add(p);
       }

    }

    private Passageiro buscarPassageiro(String documento) {
        for (Passageiro passageiro : ListaPassageiroCadastrado) {
            if (passageiro.getDocumento().equals(documento)) {
                return passageiro;
            }
        }
        System.out.println("Passageiro nao encontrado na lista de passagem do sistema");
        return null;
    }

    @Override
    public void inserirFilaPrioridade(String documento) {
        Passageiro p = buscarPassageiro(documento);
        if (p != null) {
            ListaPassageiroCadastrado.remove(p);
            filaPrioridade.add(p);
        }

    }

    @Override
    public void embacarPassageiro() {
       if (!filaPrioridade.isEmpty()) {
           Passageiro p = filaPrioridade.poll();
           System.out.println("Embarque de prioridade " + p.getNome());
           historicoEmbarque.push(p);
       } else if (!filaPassageiro.isEmpty()) {
           Passageiro p = filaPassageiro.removeFirst();
           System.out.println("Embarque  comum " + p.getNome());
           historicoEmbarque.push(p);
       } else {
           System.out.println("Passageiro nao encontrado");
       }
    }



    @Override
    public void exibirFilaEmbarque() {
        System.out.println("Fila de passageiros embarcados:");
        for (Passageiro passageiro : historicoEmbarque) {
            System.out.println(passageiro.getNome());
        }
    }
}
