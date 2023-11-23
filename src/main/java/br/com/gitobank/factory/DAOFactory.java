package br.com.gitobank.factory;

import br.com.gitobank.dao.PessoaClienteDAO;
import br.com.gitobank.dao.PessoaFisicaDAO;
import br.com.gitobank.dao.PessoaJuridicaDAO;
import br.com.gitobank.dao.implement.OraclePessoaClienteDAO;
import br.com.gitobank.dao.implement.OraclePessoaFisicaDAO;
import br.com.gitobank.dao.implement.OraclePessoaJuridicaDAO;

public class DAOFactory {

    public static PessoaClienteDAO getPessoaaDAO(){
        return new OraclePessoaClienteDAO();
    }

    public static PessoaFisicaDAO getPessoaFisicaDAO(){
        return new OraclePessoaFisicaDAO();
    }

    public static PessoaJuridicaDAO getPessoaJuridicaDAO() {
        return new OraclePessoaJuridicaDAO();
    }
}
