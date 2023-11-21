package br.com.gitobank.gitobank.model;

import java.util.Date;
import java.util.List;

public class ClientePessoaJuridica extends PessoaCliente{

    private Long idCliente;
    private String razaoSocial;
    private String cpnj;
    private String inscricaoEstadual;
    private String inscricaoMunicipal;
    private Date dataAbertura;


    public ClientePessoaJuridica(String nome, String sobrenome, String email, List<Telefone> telefone, String razaoSocial, String cpnj, String inscricaoEstadual, String inscricaoMunicipal, Date dataAbertura) {
        super(nome, sobrenome, email, telefone);
        this.razaoSocial = razaoSocial;
        this.cpnj = cpnj;
        this.inscricaoEstadual = inscricaoEstadual;
        this.inscricaoMunicipal = inscricaoMunicipal;
        this.dataAbertura = dataAbertura;
    }

    public void cadastrarPessoaJuridica() {

    }




}
