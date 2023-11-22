package br.com.gitobank.dao;

import br.com.gitobank.exception.DBException;
import br.com.gitobank.model.PessoaCliente;

public interface PessoaClienteDAO {
    void cadastrarPessoaCliente(PessoaCliente pessoaCliente) throws DBException;
    PessoaCliente obterPessoaCliente(Long idCliente) throws DBException;
    void removerPessoaCliente(Long idCliente) throws DBException;

}
