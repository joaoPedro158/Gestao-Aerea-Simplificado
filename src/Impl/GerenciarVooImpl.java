package Impl;

import Interface.GerenciarVoo;

import java.util.LinkedList;

public class GerenciarVooImpl implements GerenciarVoo {

    private LinkedList<Voo> listaVoos = new LinkedList<>();
    @Override
    public void CadastrarVoo(Voo voo) {
        listaVoos.add(voo);
        System.out.println("Voo cadastrado com sucesso! \n" + voo);
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
