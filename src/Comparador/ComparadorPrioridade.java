package Comparador;

import Impl.Passageiro;
import java.util.Comparator;

public class ComparadorPrioridade implements Comparator<Passageiro> {
    @Override
    public int compare(Passageiro p1, Passageiro p2) {
        if (p1.getPrioridade() != p2.getPrioridade()) {
            return Integer.compare(p2.getPrioridade(), p1.getPrioridade());
        }
        return Integer.compare(p1.getOrdemChegada(), p2.getOrdemChegada());
    }
}
