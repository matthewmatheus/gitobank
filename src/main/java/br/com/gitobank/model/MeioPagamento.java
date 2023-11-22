package br.com.gitobank.model;

public class MeioPagamento {
    private Long idMeioPagamento;
    private String descricao;

    // Construtor
    public MeioPagamento(Long idMeioPagamento, String descricao) {
        this.idMeioPagamento = idMeioPagamento;
        this.descricao = descricao;
    }

    // Getters e Setters
    public Long getIdMeioPagamento() {
        return idMeioPagamento;
    }

    public void setIdMeioPagamento(Long idMeioPagamento) {
        this.idMeioPagamento = idMeioPagamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


}
