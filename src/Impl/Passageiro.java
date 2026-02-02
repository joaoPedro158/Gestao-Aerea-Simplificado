package Impl;

import java.util.Random;

public class Passageiro {
    private String nome;
    private String documento;
    private String voo;
    private int prioridade;
    private int ordemChegada;

    public Passageiro() {
        Random random = new Random();

        String[] nomes = {"Ana", "Bruno", "Carla", "Diego", "Elena"};
        this.nome = nomes[random.nextInt(nomes.length)];
        this.documento = "DOC-" + (random.nextInt(9000) + 1000);
        this.voo = "V-100" + random.nextInt(9);
        this.prioridade = random.nextInt(3);
    }

    @Override
    public String toString() {
        return "Passageiro{" +
                "nome='" + nome + '\'' +
                ", documento='" + documento + '\'' +
                ", voo='" + voo + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getVoo() {
        return voo;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public int getOrdemChegada() {
        return ordemChegada;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setVoo(String voo) {
        this.voo = voo;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public void setOrdemChegada(int ordemChegada) {
        this.ordemChegada = ordemChegada;
    }
}
