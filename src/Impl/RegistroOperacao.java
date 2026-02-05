package Impl;

import Enum.Operacao;

public class RegistroOperacao {
    private Operacao operacao;
    private Object dados;
    private String timestamp;

    public RegistroOperacao(Operacao operacao, Object dados) {
        this.operacao = operacao;
        this.dados = dados;
        this.timestamp = java.time.LocalDateTime.now().toString();
    }

    public Operacao getOperacao() {
        return operacao;
    }

    public Object getDados() {
        return dados;
    }

    public String getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "[" + timestamp + "] " + operacao + ": " + dados;
    }
}
