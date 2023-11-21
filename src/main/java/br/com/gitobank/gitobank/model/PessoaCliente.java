package br.com.gitobank.gitobank.model;

import java.util.ArrayList;
import java.util.List;

public class PessoaCliente {

    private Long idCliente;

    private String nome;
    private String sobrenome;
    private String email;

    private List<Telefone> telefone;
    private List<CartaoCredito> cartoesCredito;

    public PessoaCliente(Long idCLiente, String nome, String sobrenome, String email) {
    }

    public PessoaCliente(String nome, String sobrenome, String email, List<Telefone> telefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.telefone = telefone;
    }


    public PessoaCliente(String nome, String sobrenome, String email) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
    }

    public PessoaCliente(String nome, String sobrenome, String email, List<Telefone> telefone, List<CartaoCredito> cartoesCredito) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.telefone = telefone;
        this.cartoesCredito = cartoesCredito;
    }

    public void adicionarTelefone(int ddd, String numeroTelefone) {
        if (telefone == null) {
            telefone = new ArrayList<>();
        }
        Telefone novoTelefone = new Telefone(ddd, numeroTelefone);
        telefone.add(novoTelefone);
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public List<Telefone> getTelefone() {
        return telefone;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;

    }
}


