package br.com.gitobank.model;

import java.time.LocalDate;

public class ContaBancaria {

    private Long idCliente;
    private String nrConta;
    private String tipoConta;
    private double saldo;
    private LocalDate dtAbertura;


    public ContaBancaria(Long idCliente, String nrConta, String tipoConta, double saldo, LocalDate dtAbertura) {
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
