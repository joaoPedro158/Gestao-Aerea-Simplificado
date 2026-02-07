package Interface;

import Impl.Voo;

public interface GerenciarVoo {
    public void CadastrarVoo(Voo voo);
    public Voo procuraVoo(String codigoVoo);
    public boolean verificarDisponibilidade(String codigoVoo);
    public void listarVoos();
    public boolean cancelarVoo(String codigoVoo);
}
