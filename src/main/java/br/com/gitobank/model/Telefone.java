package br.com.gitobank.model;

public class Telefone {

        private Long idCliente;
        private int ddd;
        private String nrTelefone;

    public Telefone(int ddd, String nrTelefone) {
        this.ddd = ddd;
        this.nrTelefone = nrTelefone;
    }
}
