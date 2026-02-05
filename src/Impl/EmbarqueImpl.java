package Impl;

import Strategy.EstrategiaPrioridadePadrao;
import Strategy.ComparadorStrategy;
import Interface.Embarque;
import Enum.Operacao;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

public class EmbarqueImpl implements Embarque {

    LinkedList<Passageiro> filaPassageiro = new LinkedList<>();
    PriorityQueue<Passageiro> filaPrioridade = new PriorityQueue<>(new ComparadorStrategy(new EstrategiaPrioridadePadrao()));
    LinkedList<Passageiro> ListaPassageiroCadastrado =  new LinkedList<>();
    Stack<RegistroOperacao> historicoOperacoes = new Stack<>();
    Stack<Passageiro> historicoEmbarque = new Stack<>();

    @Override
    public void venderPassagem(Passageiro passageiro) {
        ListaPassageiroCadastrado.addLast(passageiro);
        historicoOperacoes.push(new RegistroOperacao(Operacao.VENDER_PASSAGEM, passageiro));
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
            historicoOperacoes.push(new RegistroOperacao(Operacao.CANCELAR_PASSAGEM, p));
            System.out.println("Passagem cancelada com sucesso.");
        }
    }


    @Override
    public void inserirFilaComum(String documento) {
       Passageiro p = buscarPassageiro(documento);
       if(p != null) {
           ListaPassageiroCadastrado.remove(p);
           filaPassageiro.add(p);
           historicoOperacoes.push(new RegistroOperacao(Operacao.INSERIR_FILA_COMUM, p));
           System.out.println(" passageiro inserido \n" + p);
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
            historicoOperacoes.push(new RegistroOperacao(Operacao.INSERIR_FILA_PRIORIDADE, p));
        }

    }

    @Override
    public void embacarPassageiro() {
       if (!filaPrioridade.isEmpty()) {
           Passageiro p = filaPrioridade.poll();
           System.out.println("Embarque de prioridade " + p.getNome());
           historicoEmbarque.push(p);
           historicoOperacoes.push(new RegistroOperacao(Operacao.EMBARCAR_PASSAGEIRO, p));
       } else if (!filaPassageiro.isEmpty()) {
           Passageiro p = filaPassageiro.removeFirst();
           System.out.println("Embarque  comum " + p.getNome());
           historicoEmbarque.push(p);
           historicoOperacoes.push(new RegistroOperacao(Operacao.EMBARCAR_PASSAGEIRO, p));
       } else {
           System.out.println("Passageiro nao encontrado");
       }
    }



    @Override
    public void exibirFilaEmbarque() {
        System.out.println("Fila de passageiros embarcados:");
        for (Passageiro passageiro : historicoEmbarque) {
            System.out.println(passageiro);
        }
    }

    @Override
    public void exibirHistoricoOperacoes() {
        System.out.println("Histórico de operações de embarque:");
        for (Passageiro passageiro : historicoEmbarque) {
            System.out.println("Embarcado: " + passageiro);
        }
    }

    @Override
    public void desfazerUltimaOperacao() {
        if (historicoOperacoes.isEmpty()) {
            System.out.println("Não há operações para desfazer.");
            return;
        }

        RegistroOperacao ultimaOperacao = historicoOperacoes.pop();
        
        switch (ultimaOperacao.getOperacao()) {
            case VENDER_PASSAGEM:
                Passageiro p = (Passageiro) ultimaOperacao.getDados();
                ListaPassageiroCadastrado.remove(p);
                System.out.println("Passagem de " + p.getNome() + " desfeita.");
                break;
            case CANCELAR_PASSAGEM:
                Passageiro p2 = (Passageiro) ultimaOperacao.getDados();
                ListaPassageiroCadastrado.addLast(p2);
                System.out.println("Cancelamento de passagem de " + p2.getNome() + " desfeito.");
                break;
            case INSERIR_FILA_COMUM:
                Passageiro p3 = (Passageiro) ultimaOperacao.getDados();
                filaPassageiro.remove(p3);
                ListaPassageiroCadastrado.addLast(p3);
                System.out.println(p3.getNome() + " removido da fila comum.");
                break;
            case INSERIR_FILA_PRIORIDADE:
                Passageiro p4 = (Passageiro) ultimaOperacao.getDados();
                filaPrioridade.remove(p4);
                ListaPassageiroCadastrado.addLast(p4);
                System.out.println(p4.getNome() + " removido da fila prioritária.");
                break;
            case EMBARCAR_PASSAGEIRO:
                Passageiro p5 = (Passageiro) ultimaOperacao.getDados();
                historicoEmbarque.pop();
                if (p5.getPrioridade().getValor() > 0) {
                    filaPrioridade.add(p5);
                } else {
                    filaPassageiro.addFirst(p5);
                }
                System.out.println("Embarque de " + p5.getNome() + " desfeito.");
                break;
            default:
                System.out.println("Operação não pode ser desfeita.");
        }
    }
}
