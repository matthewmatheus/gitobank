package br.com.gitobank.dao;

import br.com.gitobank.exception.DBException;
import br.com.gitobank.gitobank.model.PessoaCliente;

import java.util.UUID;

public interface PessoaClienteDAO {
    void cadastrarPessoaCliente(PessoaCliente pessoaCliente) throws DBException;
    PessoaCliente obterPessoaCliente(Long idCliente) throws DBException;
    void removerPessoaCliente(Long idCliente) throws DBException;

}
