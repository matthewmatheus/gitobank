package br.com.gitobank.teste;

import br.com.gitobank.dao.PessoaClienteDAO;
import br.com.gitobank.exception.DBException;
import br.com.gitobank.factory.DAOFactory;
import br.com.gitobank.gitobank.model.PessoaCliente;

public class TestePessoaClienteDAO {

    public static void main(String[] args) throws DBException {
        PessoaClienteDAO dao = DAOFactory.getPessoaaDAO();

        //cadastrar pessoa
        PessoaCliente pessoaCliente = new PessoaCliente("Fulano", "De tal", "2@email.com");

        try {
            dao.cadastrarPessoaCliente(pessoaCliente);
            System.out.println("Pessoa Cadastrada!");
        } catch (DBException e) {
           e.printStackTrace();
        }

        //Buscar pelo id e atualizar
        System.out.println(pessoaCliente.getNome());

    }

}
