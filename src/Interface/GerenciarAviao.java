package Interface;
import Impl.Aviao;
public interface GerenciarAviao {
    public void cadastraAviao(Aviao aviao);
    public boolean excluirAviao(String codigo);
    public void listarAviaos();
    public Aviao buscarAviao(String codigo);
}
