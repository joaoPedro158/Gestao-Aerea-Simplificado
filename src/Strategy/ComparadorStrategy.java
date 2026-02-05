package Strategy;

import Impl.Passageiro;
import java.util.Comparator;

public class ComparadorStrategy implements Comparator<Passageiro> {
    private EstrategiaPrioridade estrategia;

    public ComparadorStrategy(EstrategiaPrioridade estrategia) {
        this.estrategia = estrategia;
    }

    @Override
    public int compare(Passageiro p1, Passageiro p2) {
        return estrategia.comparar(p1, p2);
    }
}
