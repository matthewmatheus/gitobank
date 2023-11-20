package br.com.gitobank.gitobank.model;

import java.util.UUID;

public class MeioPagamento {
    private UUID idMeioPagamento;
    private String descricao;

    // Construtor
    public MeioPagamento(UUID idMeioPagamento, String descricao) {
        this.idMeioPagamento = idMeioPagamento;
        this.descricao = descricao;
    }

    // Getters e Setters
    public UUID getIdMeioPagamento() {
        return idMeioPagamento;
    }

    public void setIdMeioPagamento(UUID idMeioPagamento) {
        this.idMeioPagamento = idMeioPagamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


}
