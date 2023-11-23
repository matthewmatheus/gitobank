package br.com.gitobank.model;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class ClientePessoaFisica extends PessoaCliente {


    private Long idCliente;
    private String rg;
    private String cpf;
    private LocalDate dtNascimento;
    private String sexo;

    private int idade;



    public ClientePessoaFisica(String nome, String sobrenome, String email, List<Telefone> telefone, String rg, String cpf, LocalDate dtNascimento, String sexo, int idade) {
        super(nome, sobrenome, email, telefone);
        this.rg = rg;
        this.cpf = cpf;
        this.dtNascimento = dtNascimento;
        this.sexo = sexo;
        this.idade = idade;
    }

    public ClientePessoaFisica(String nome, String sobrenome, String email, String rg, String cpf, LocalDate dtNascimento, String sexo, int idade) {
        super(nome, sobrenome, email);
        this.rg = rg;
        this.cpf = cpf;
        this.dtNascimento = dtNascimento;
        this.sexo = sexo;
        this.idade = idade;
    }

    public ClientePessoaFisica(Long idCliente,String nome, String sobrenome, String email, String rg, String cpf, LocalDate dtNascimento, String sexo, int idade) {
        super(nome, sobrenome, email);
        this.rg = rg;
        this.cpf = cpf;
        this.dtNascimento = dtNascimento;
        this.sexo = sexo;
        this.idade = idade;
        this.idCliente = idCliente;
    }



    public String getRg() {
        return rg;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public int getIdade() {
        return idade;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    @Override
    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
}


