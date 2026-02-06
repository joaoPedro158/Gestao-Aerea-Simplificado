package Impl;

import java.util.Random;
import Enum.Prioridade;

public class Passageiro {
    private String nome;
    private String documento;
    private Voo voo;
    private Prioridade prioridade;
    private static int contador = 0;
    private int ordemChegada;

    public Passageiro(Prioridade prioridade, Voo voo) {
        Random random = new Random();

        String[] nomes = {"Ana", "Bruno", "Carla", "Diego", "Elena"};
        this.nome = nomes[random.nextInt(nomes.length)];
        this.documento = "DOC-" + (random.nextInt(9000) + 1000);
        this.voo = voo;
        this.prioridade = prioridade;
        contador++;
        this.ordemChegada = contador;
    }

    @Override
    public String toString() {
        return "Passageiro{" +
                "nome='" + nome + '\'' +
                ", documento='" + documento + '\'' +
                ", voo=" + voo +
                ", prioridade=" + prioridade +
                ", ordemChegada=" + ordemChegada +
                '}';
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public static void setContador(int contador) {
        Passageiro.contador = contador;
    }

    public void setOrdemChegada(int ordemChegada) {
        this.ordemChegada = ordemChegada;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public Voo getVoo() {
        return voo;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public static int getContador() {
        return contador;
    }

    public int getOrdemChegada() {
        return ordemChegada;
    }
}
