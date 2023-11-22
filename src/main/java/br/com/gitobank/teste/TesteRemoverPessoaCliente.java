package br.com.gitobank.teste;

import br.com.gitobank.dao.PessoaClienteDAO;
import br.com.gitobank.exception.DBException;
import br.com.gitobank.factory.DAOFactory;
import br.com.gitobank.model.PessoaCliente;

public class TesteRemoverPessoaCliente {

    public static void main(String[] args) throws DBException {

        PessoaClienteDAO dao = DAOFactory.getPessoaaDAO();

        //cadastrar pessoa

        try {
            dao.removerPessoaCliente(49L);
            System.out.println("Pessoa excluida!");
        } catch (DBException e) {
            e.printStackTrace();
        }



    }
}

