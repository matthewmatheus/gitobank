package br.com.gitobank.gitobank.model;


import java.time.LocalDate;

public class ExtratoBancario {

    private Long idExtrato;
    private String nrConta;
    private double valorGasto;
    private LocalDate dtGasto;
    private int idMeioPagamento;
    private String nomeLocal;
    private String moedaUtilizada;

    private String nomeCliente;

    public ExtratoBancario(String nrConta, double valorGasto, LocalDate dtGasto, int idMeioPagamento, String nomeLocal, String moedaUtilizada, String nomeCliente) {
        this.nrConta = nrConta;
        this.valorGasto = valorGasto;
        this.dtGasto = dtGasto;
        this.idMeioPagamento = idMeioPagamento ;
        this.nomeLocal = nomeLocal;
        this.moedaUtilizada = moedaUtilizada;
        this.nomeCliente = nomeCliente;
    }




    public Long getIdExtrato() {
        return idExtrato;
    }

    public String getNrConta() {
        return nrConta;
    }

    public double getValorGasto() {
        return valorGasto;
    }

    public LocalDate getDtGasto() {
        return dtGasto;
    }

    public int getIdMeioPagamento() {
        return idMeioPagamento;
    }

    public String getNomeLocal() {
        return nomeLocal;
    }

    public String getMoedaUtilizada() {
        return moedaUtilizada;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }



}
