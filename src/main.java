import Impl.Aviao;
import Impl.GerenciarAviaoImpl;
import Interface.*;

public class main {
    public static void main(String[] args) {
        GerenciarAviaoImpl g = new GerenciarAviaoImpl();

        Aviao aviao1 = new Aviao();
        Aviao aviao2 = new Aviao();
        Aviao aviao3 = new Aviao();

        g.cadastraAviao(aviao1);
        g.cadastraAviao(aviao2);

        g.listarAviaos();
    }
}
