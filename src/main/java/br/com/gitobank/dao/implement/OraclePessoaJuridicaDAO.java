package br.com.gitobank.dao.implement;

import br.com.gitobank.dao.PessoaJuridicaDAO;
import br.com.gitobank.exception.DBException;
import br.com.gitobank.model.ClientePessoaFisica;
import br.com.gitobank.model.ClientePessoaJuridica;
import br.com.gitobank.singleton.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OraclePessoaJuridicaDAO implements PessoaJuridicaDAO {

    private Connection conexao;

    @Override
    public ClientePessoaJuridica cadastrarPessoaJuridica(ClientePessoaJuridica pessoaJuridica) throws DBException {
        PreparedStatement stmtCliente = null;
        PreparedStatement stmtPessoaJuridica = null;
        ResultSet rsKeys = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            conexao.setAutoCommit(false);

            String sqlInsertCliente = "INSERT INTO TB_PESSOA_CLIENTE (IDCLIENTE, NOME, SOBRENOME, EMAIL) VALUES (SEQ_CLIENTE_ID.NEXTVAL,?, ?, ?)";
            stmtCliente = conexao.prepareStatement(sqlInsertCliente, new String[]{"IDCLIENTE"});
            stmtCliente.setString(1, pessoaJuridica.getNome());
            stmtCliente.setString(2, pessoaJuridica.getSobrenome());
            stmtCliente.setString(3, pessoaJuridica.getEmail());
            int linhasAfetadas = stmtCliente.executeUpdate();

            if (linhasAfetadas > 0) {
                rsKeys = stmtCliente.getGeneratedKeys();
                long idCliente = 0;
                if (rsKeys.next()) {
                    idCliente = rsKeys.getLong(1);

                    String sqlInsertPJ = "INSERT INTO TB_CLIENTE_PJ (IDCLIENTE, RAZAOSOCIAL, CNPJ, INSCRICAOESTADUAL, INSCRICAOMUNICIPAL, DATAABERTURA) " +
                            "VALUES(?, ?, ?, ?, ?, ?)";

                    stmtPessoaJuridica = conexao.prepareStatement(sqlInsertPJ);
                    stmtPessoaJuridica.setLong(1, idCliente);
                    stmtPessoaJuridica.setString(2, pessoaJuridica.getRazaoSocial());
                    stmtPessoaJuridica.setString(3, pessoaJuridica.getCpnj());
                    stmtPessoaJuridica.setString(4, pessoaJuridica.getInscricaoEstadual());
                    stmtPessoaJuridica.setString(5, pessoaJuridica.getInscricaoMunicipal());
                    stmtPessoaJuridica.setDate(6, java.sql.Date.valueOf(pessoaJuridica.getDataAbertura()));

                    stmtPessoaJuridica.executeUpdate();

                    pessoaJuridica.setIdCliente(idCliente);
                    conexao.commit();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();

            try {
                if (conexao != null) {
                    conexao.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            throw new DBException("Erro ao cadastrar Pessoa Juridica.");
        } finally {
            try {
                if (stmtCliente != null) {
                    stmtCliente.close();
                }
                if (stmtPessoaJuridica != null) {
                    stmtPessoaJuridica.close();
                }
                if (rsKeys != null) {
                    rsKeys.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return pessoaJuridica;
    }

    @Override
    public ClientePessoaJuridica obterPessoaJuridica(Long idCliente) throws DBException {
        return null;
    }

    @Override
    public void removerPessoaJuridica(Long idCliente) throws DBException {

    }
}