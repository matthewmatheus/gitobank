package br.com.gitobank.dao;

import br.com.gitobank.exception.DBException;
import br.com.gitobank.model.ClientePessoaFisica;
import br.com.gitobank.model.ClientePessoaJuridica;

public interface PessoaJuridicaDAO {

    void cadastrarPessoaJuridica(ClientePessoaJuridica pessoaJuridica) throws DBException;
    ClientePessoaJuridica obterPessoaJuridica(Long idCliente) throws DBException;
    void removerPessoaJuridica(Long idCliente) throws DBException;
}
