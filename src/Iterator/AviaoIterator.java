package Iterator;

import Impl.Aviao;
import java.util.Iterator;
import java.util.List;

public class AviaoIterator implements Iterator<Aviao> {
    private List<Aviao> avioes;
    private int posicao;

    public AviaoIterator(List<Aviao> avioes) {
        this.avioes = avioes;
        this.posicao = 0;
    }

    @Override
    public boolean hasNext() {
        return posicao < avioes.size();
    }

    @Override
    public Aviao next() {
        if (hasNext()) {
            return avioes.get(posicao++);
        }
        return null;
    }
}
