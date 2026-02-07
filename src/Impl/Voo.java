package Impl;

import java.time.LocalDateTime;
import java.util.Random;

public class Voo {
    private String destinoPartida;
    private  Aviao aviao;
    private String destinoFinal;
    private LocalDateTime dataVoo;
    private String codigoVoo;
    private int passageirosCadastrados;

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

    public boolean temVaga() {
        return passageirosCadastrados < aviao.getCapacidadeMaxima();
    }

    public void incrementarPassageiro() {
        this.passageirosCadastrados++;
    }

    @Override
    public String toString() {
        int vagasRestantes = aviao.getCapacidadeMaxima() - passageirosCadastrados;
        return String.format(
                "-------------------------------------------------------+" +
                        "\n| VOO: %-8s | AERONAVE: %-22s | VAGAS: %-3d | " +
                        "\n+-------------------------------------------------------+" +
                        "\n| ORIGEM:  %-20s                 |" +
                        "\n| DESTINO: %-20s                 |" +
                        "\n| DATA/HORA: %-18s                 |" +
                        "\n+-------------------------------------------------------+",
                codigoVoo,
                aviao.getCodigoIdentificador(),
                vagasRestantes,
                destinoPartida,
                destinoFinal,
                dataVoo.toString().substring(0, 16).replace("T", " ")
        );
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
