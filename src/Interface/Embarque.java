package Interface;

import Impl.Passageiro;

public interface Embarque {
    public void venderPassagem(Passageiro passageiro);
    public void cancelarPassagem(String documento);
    public void inserirFilaComum(String documento);
    public void inserirFilaPrioridade(String documento);
    public void embacarPassageiro();
    public  void exibirFilaEmbarque();
}
