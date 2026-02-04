package Comparador;

import Impl.Passageiro;
import java.util.Comparator;

public class ComparadorPrioridade implements Comparator<Passageiro> {
    @Override
    public int compare(Passageiro p1, Passageiro p2) {
        int passageiroInt = p1.getPrioridade().getValor();
        int passageiroInt2 = p2.getPrioridade().getValor();

        if (passageiroInt != passageiroInt2) {
            return Integer.compare(passageiroInt2, passageiroInt);
        }
        return Integer.compare(p1.getOrdemChegada(), p2.getOrdemChegada());
    }
}
