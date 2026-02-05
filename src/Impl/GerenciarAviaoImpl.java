package Impl;

import Interface.GerenciarAviao;
import Enum.Operacao;

import java.util.LinkedList;
import java.util.Stack;

public class GerenciarAviaoImpl implements GerenciarAviao {

    private LinkedList<Aviao> listaAviao = new LinkedList<>();
    Stack<RegistroOperacao> historicoOperacoes = new Stack<>();

    @Override
    public void cadastraAviao(Aviao aviao) {
        listaAviao.add(aviao);
        historicoOperacoes.push(new RegistroOperacao(Operacao.CADASTRAR_AVIAO, aviao));
        System.out.println("Aviao cadastrado  " + aviao.toString());
    }

    @Override
    public boolean excluirAviao(String codigo) {
        Aviao aviaoExcluir = buscarAviao(codigo);
        if (aviaoExcluir != null) {
           historicoOperacoes.push(new RegistroOperacao(Operacao.REMOVER_AVIAO, aviaoExcluir));
           return listaAviao.remove(aviaoExcluir);
        }
        return false;
    }

    @Override
    public void listarAviaos() {
        for (Aviao aviao : listaAviao) {
            System.out.println(aviao);
        }
    }

    @Override
    public Aviao buscarAviao(String codigo) {
        for (Aviao a : listaAviao) {
            if (a.getCodigoIdentificador().equals(codigo)) {
                return a;
            }
        }
        return null;
    }
}
