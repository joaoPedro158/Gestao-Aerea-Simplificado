package Impl;

import Interface.GerenciarAviao;
import Interface.GerenciarVoo;
import Strategy.EstrategiaVoo;

import java.util.LinkedList;



public class GerenciarVooImpl implements GerenciarVoo {

    private LinkedList<Voo> listaVoos = new LinkedList<>();

    private GerenciarAviao gestorAviao = new GerenciarAviaoImpl();

    @Override
    public void CadastrarVoo(Voo voo) {
       String codigoAviao = voo.getAviao().getCodigoIdentificador();

       boolean aviaoOcupado = false;
       for (Voo v : listaVoos) {
           if (v.getAviao().getCodigoIdentificador().equals(codigoAviao)) {
               aviaoOcupado = true;
               System.out.println("Esse aviao ja esta cadastrado em um voo ");
               break;
           }
       }
       listaVoos.add(voo);

    }

    @Override
    public Voo procuraVoo(String codigoVoo) {
        for (Voo v : listaVoos) {
            if (v.getCodigoVoo().equals(codigoVoo)) {
                return v;
            }
        }
        return null;
    }

    @Override
    public boolean verificarDisponibilidade(String codigoVoo) {
        Voo voo = procuraVoo(codigoVoo);
        if (voo != null) {
            if (voo.temVaga()) {
                return true;
            } else {
                System.out.println("[LOTADO] O voo " + codigoVoo + " já atingiu a capacidade máxima!");
                return false;
            }
        }
        return false;
    }

    @Override
    public void listarVoos() {
        for (Voo v : listaVoos) {
            System.out.println(v);
        }
    }

    @Override
    public boolean cancelarVoo(String codigoVoo) {
        Voo v = procuraVoo(codigoVoo);
        if (v != null) {
            listaVoos.remove(v);
            System.out.println("Voo cancelado com sucesso! \n" + v);
            return true;
        }
       return false;
    }
}
