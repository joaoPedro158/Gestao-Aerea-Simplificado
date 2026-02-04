package Enum;

public enum Prioridade {
    IDOSO(3),
    GESTANTE(2),
    DEFICIENTE(1),
    COMUM(0);

    private final int valor;

    Prioridade(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return name().substring(0, 1) + name().substring(1).toLowerCase();
    }
}
