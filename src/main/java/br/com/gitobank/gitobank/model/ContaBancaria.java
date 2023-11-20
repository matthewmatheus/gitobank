package br.com.gitobank.gitobank.model;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class ContaBancaria {

    private UUID idCliente;
    private String nrConta;
    private String tipoConta;
    private double saldo;
    private LocalDate dtAbertura;


    public ContaBancaria(UUID idCliente, String nrConta, String tipoConta, double saldo, LocalDate dtAbertura) {
        this.idCliente = idCliente;
        this.nrConta = nrConta;
        this.tipoConta = tipoConta;
        this.saldo = saldo;
        this.dtAbertura = dtAbertura;
    }

    public double consultaSaldoConta() {
        return saldo;
    }


    public String getNrConta() {
        return nrConta;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public LocalDate getDtAbertura() {
        return dtAbertura;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }
}
