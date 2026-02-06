package Impl;

import java.util.Random;

public class Aviao {

    private String codigoIdentificador;
    private String modelo;
    private int capacidadeMaxima;

    public Aviao() {
        Random gerador = new Random();

        this.codigoIdentificador = "AV-" + (gerador.nextInt(900) + 100);

        String[] modelosDisponiveis = {"Boeing 737", "Airbus A320", "Embraer 195"};
        this.modelo = modelosDisponiveis[gerador.nextInt(modelosDisponiveis.length)];

        this.capacidadeMaxima = gerador.nextInt(1) + 10;

    }

    @Override
    public String toString() {
        return "Aviao{" +
                "codigoIdentificador='" + codigoIdentificador + '\'' +
                ", modelo='" + modelo + '\'' +
                ", capacidadeMaxima=" + capacidadeMaxima +
                '}';
    }

    public String getCodigoIdentificador() {
        return codigoIdentificador;
    }

    public String getModelo() {
        return modelo;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCodigoIdentificador(String codigoIdentificador) {
        this.codigoIdentificador = codigoIdentificador;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }
}
