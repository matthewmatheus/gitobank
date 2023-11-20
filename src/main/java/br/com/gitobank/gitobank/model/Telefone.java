package br.com.gitobank.gitobank.model;

import java.util.UUID;

public class Telefone {

        private UUID idCliente;
        private int ddd;
        private String nrTelefone;

    public Telefone(int ddd, String nrTelefone) {
        this.ddd = ddd;
        this.nrTelefone = nrTelefone;
    }
}
