package br.com.gitobank.dao;

import br.com.gitobank.exception.DBException;
import br.com.gitobank.model.ClientePessoaFisica;

public interface PessoaFisicaDAO {

    ClientePessoaFisica cadastrarPessoaFisica(ClientePessoaFisica pessoaFisica) throws DBException;
    ClientePessoaFisica obterPessoaFisica(Long idCliente) throws DBException;
    void removerPessoaFisica(Long idCliente) throws DBException;


}
