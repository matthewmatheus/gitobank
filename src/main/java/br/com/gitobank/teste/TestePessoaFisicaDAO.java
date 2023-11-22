package br.com.gitobank.teste;

import br.com.gitobank.dao.PessoaFisicaDAO;
import br.com.gitobank.exception.DBException;
import br.com.gitobank.factory.DAOFactory;
import br.com.gitobank.model.ClientePessoaFisica;

import java.time.LocalDate;

public class TestePessoaFisicaDAO {

    public static void main(String[] args) {
        PessoaFisicaDAO dao = DAOFactory.getPessoaFisicaDAO();

        //cadastrar pessoa
        ClientePessoaFisica pessoaFisica = new ClientePessoaFisica("Fulanou", "De Tall", "fulano@email.com", "3423423", "232132332", LocalDate.now(), "HS", 23);


        try {
            dao.cadastrarPessoaFisica(pessoaFisica);
            System.out.println("Pessoa Cadastrada!");
        } catch (DBException e) {
            e.printStackTrace();
        }

        //Buscar pelo id e atualizar
        System.out.println(pessoaFisica.getNome());
        System.out.println(pessoaFisica.getIdCliente());

    }
}
