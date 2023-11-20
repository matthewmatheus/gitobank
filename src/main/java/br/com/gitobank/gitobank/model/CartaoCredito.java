package br.com.gitobank.gitobank.model;

import java.util.Date;
import java.util.UUID;

public class CartaoCredito {

    private UUID idCliente;
    private int idCartao;
    private double vlLimite;
    private Date dtVencimento;
    private String instituicaoFinanceira;
    private int numeroCartao;


    public CartaoCredito(UUID idCliente, double vlLimite, Date dtVencimento, String instituicaoFinanceira, int numeroCartao) {
        this.idCliente = idCliente;
        this.vlLimite = vlLimite;
        this.dtVencimento = dtVencimento;
        this.instituicaoFinanceira = instituicaoFinanceira;
        this.numeroCartao = numeroCartao;
    }




    public double getVlLimite() {
        return vlLimite;
    }

    public Date getDtVencimento() {
        return dtVencimento;
    }

    public String getInstituicaoFinanceira() {
        return instituicaoFinanceira;
    }

    public int getNumeroCartao() {
        return numeroCartao;
    }

    public void setVlLimite(double vlLimite) {
        this.vlLimite = vlLimite;
    }

    public void setDtVencimento(Date dtVencimento) {
        this.dtVencimento = dtVencimento;
    }





}
