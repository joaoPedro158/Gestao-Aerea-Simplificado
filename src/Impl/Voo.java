package Impl;

import java.time.LocalDateTime;
import java.util.Random;

public class Voo {
    private String destinoPartida;
    private  Aviao aviao;
    private String destinoFinal;
    private LocalDateTime dataVoo;
    private String codigoVoo;

    public Voo(Aviao aviao) {
        Random random = new Random();
        String[] cidades = {"São Paulo", "Rio de Janeiro", "Curitiba", "Salvador", "Lisboa", "Nova York", "Paris"};
        this.destinoPartida = cidades[random.nextInt(cidades.length)];
        String destino;
        do {
            destino = cidades[random.nextInt(cidades.length)];
        } while (destino.equals(this.destinoPartida));

        this.destinoFinal = destino;
        this.aviao = aviao;
        this.codigoVoo = "CV-" + (random.nextInt(100) + 1);
        this.dataVoo = LocalDateTime.now().plusDays(random.nextInt(30))
                .plusHours(random.nextInt(24))
                .plusMinutes(random.nextInt(60));
    }

    @Override
    public String toString() {
        return "Voo{" +
                "destinoPartida='" + destinoPartida + '\'' +
                ", aviao=" + aviao +
                ", destinoFinal='" + destinoFinal + '\'' +
                ", dataVoo=" + dataVoo +
                ", codigoVoo='" + codigoVoo + '\'' +
                '}';
    }

    public void setDestinoPartida(String destinoPartida) {
        this.destinoPartida = destinoPartida;
    }

    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }

    public void setDestinoFinal(String destinoFinal) {
        this.destinoFinal = destinoFinal;
    }

    public void setDataVoo(LocalDateTime dataVoo) {
        this.dataVoo = dataVoo;
    }

    public void setCodigoVoo(String codigoVoo) {
        this.codigoVoo = codigoVoo;
    }

    public String getDestinoPartida() {
        return destinoPartida;
    }

    public Aviao getAviao() {
        return aviao;
    }

    public String getDestinoFinal() {
        return destinoFinal;
    }

    public LocalDateTime getDataVoo() {
        return dataVoo;
    }

    public String getCodigoVoo() {
        return codigoVoo;
    }
}
