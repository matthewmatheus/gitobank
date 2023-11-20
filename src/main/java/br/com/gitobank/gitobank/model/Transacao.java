package br.com.gitobank.gitobank.model;

import java.util.Date;
import java.util.UUID;

public class Transacao {

    private UUID idTransacao;
    private int nrConta;
    private int idMeioPagamento;
    private Date dtTransacao;
    private String descricao;

    public Transacao(int nrConta, int meioPagamento, Date dtTransacao, String descricao) {
        this.nrConta = nrConta;
        this.idMeioPagamento = meioPagamento;
        this.dtTransacao = dtTransacao;
        this.descricao = descricao;
    }

    public Transacao(UUID idTransacao) {
        this.idTransacao = idTransacao;
    }

    public int getIdMeioPagamento() {
        return idMeioPagamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public Date getDtTransacao() {
        return dtTransacao;
    }

    public int getNrConta() {
        return nrConta;
    }
}
