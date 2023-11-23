package br.com.gitobank.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class ClientePessoaJuridica extends PessoaCliente{

    private Long idCliente;
    private String razaoSocial;
    private String cpnj;
    private String inscricaoEstadual;
    private String inscricaoMunicipal;
    private LocalDate dataAbertura;


    public ClientePessoaJuridica(String nome, String sobrenome, String email, List<Telefone> telefone, String razaoSocial, String cpnj, String inscricaoEstadual, String inscricaoMunicipal, LocalDate dataAbertura) {
        super(nome, sobrenome, email, telefone);
        this.razaoSocial = razaoSocial;
        this.cpnj = cpnj;
        this.inscricaoEstadual = inscricaoEstadual;
        this.inscricaoMunicipal = inscricaoMunicipal;
        this.dataAbertura = dataAbertura;
    }

    public ClientePessoaJuridica(String nome, String sobrenome, String email, String razaoSocial, String cpnj, String inscricaoEstadual, String inscricaoMunicipal, LocalDate dataAbertura) {
        super(nome, sobrenome, email);
        this.razaoSocial = razaoSocial;
        this.cpnj = cpnj;
        this.inscricaoEstadual = inscricaoEstadual;
        this.inscricaoMunicipal = inscricaoMunicipal;
        this.dataAbertura = dataAbertura;
    }

    public ClientePessoaJuridica(Long idCliente, String nome, String sobrenome, String email, String razaoSocial, String cpnj, String inscricaoEstadual, String inscricaoMunicipal, LocalDate dataAbertura) {
        super(nome, sobrenome, email);
        this.razaoSocial = razaoSocial;
        this.cpnj = cpnj;
        this.inscricaoEstadual = inscricaoEstadual;
        this.inscricaoMunicipal = inscricaoMunicipal;
        this.dataAbertura = dataAbertura;
        this.idCliente = idCliente;
    }



    public Long getIdCliente() {
        return idCliente;
    }

    @Override
    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCpnj() {
        return cpnj;
    }

    public void setCpnj(String cpnj) {
        this.cpnj = cpnj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }
}
