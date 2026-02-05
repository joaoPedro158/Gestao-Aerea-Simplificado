package Strategy;

import Impl.Passageiro;

public interface EstrategiaPrioridade {
    int comparar(Passageiro p1, Passageiro p2);
}
