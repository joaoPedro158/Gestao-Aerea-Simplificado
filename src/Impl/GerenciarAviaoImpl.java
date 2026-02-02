package Impl;

import Interface.GerenciarAviao;

import java.util.LinkedList;

public class GerenciarAviaoImpl implements GerenciarAviao {

    private LinkedList<Aviao> listaAviao = new LinkedList<>();

    @Override
    public void cadastraAviao(Aviao aviao) {
        listaAviao.add(aviao);
        System.out.println("Aviao cadastrado  " + aviao.toString());
    }

    @Override
    public boolean excluirAviao(String codigo) {
        Aviao aviaoExcluir = buscarAviao(codigo);
        if (aviaoExcluir != null) {
            listaAviao.remove(aviaoExcluir);
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
            } else {
                System.out.println("Erro em encontra aviao");
            }
        }
        return null;
    }
}
