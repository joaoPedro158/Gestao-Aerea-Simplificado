package Iterator;

import Impl.Passageiro;
import java.util.Iterator;
import java.util.List;

public class PassageiroIterator implements Iterator<Passageiro> {
    private List<Passageiro> passageiros;
    private int posicao;

    public PassageiroIterator(List<Passageiro> passageiros) {
        this.passageiros = passageiros;
        this.posicao = 0;
    }

    @Override
    public boolean hasNext() {
        return posicao < passageiros.size();
    }

    @Override
    public Passageiro next() {
        if (hasNext()) {
            return passageiros.get(posicao++);
        }
        return null;
    }
}
