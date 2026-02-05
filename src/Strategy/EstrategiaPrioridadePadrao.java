package Strategy;

import Impl.Passageiro;

public class EstrategiaPrioridadePadrao implements EstrategiaPrioridade {
    @Override
    public int comparar(Passageiro p1, Passageiro p2) {
        int prioridade1 = p1.getPrioridade().getValor();
        int prioridade2 = p2.getPrioridade().getValor();

        if (prioridade1 != prioridade2) {
            return Integer.compare(prioridade2, prioridade1);
        }
        return Integer.compare(p1.getOrdemChegada(), p2.getOrdemChegada());
    }
}
