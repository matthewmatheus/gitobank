package br.com.gitobank.dao;

import br.com.gitobank.exception.DBException;
import br.com.gitobank.model.ClientePessoaFisica;
import br.com.gitobank.model.PessoaCliente;

public interface PessoaFisicaDAO {

    void cadastrarPessoaFisica(ClientePessoaFisica pessoaFisica) throws DBException;
    ClientePessoaFisica obterPessoaFisica(Long idCliente) throws DBException;
    void removerPessoaFisica(Long idCliente) throws DBException;


}
