package br.com.gitobank.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.gitobank.gitobank.model.PessoaCliente;
import br.com.gitobank.dao.PessoaClienteDAO;
import br.com.gitobank.exception.DBException;
import br.com.gitobank.singleton.ConnectionManager;

public class OraclePessoaClienteDAO implements PessoaClienteDAO {

    private Connection conexao;

    @Override
    public void cadastrarPessoaCliente(PessoaCliente pessoaCliente) throws DBException {
        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO TB_PESSOA_CLIENTE (idCliente, NOME, SOBRENOME, EMAIL) VALUES (SEQ_CLIENTE_ID.NEXTVAL, ?, ?, ?)";

            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, pessoaCliente.getNome());
            stmt.setString(2, pessoaCliente.getSobrenome());
            stmt.setString(3, pessoaCliente.getEmail());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao cadastrar.");
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public PessoaCliente obterPessoaCliente(Long idCliente) throws DBException {
        PessoaCliente pessoa = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            stmt = conexao.prepareStatement("SELECT * FROM TB_PESSOA_CLIENTE WHERE IDCLIENTE = ?");
            stmt.setObject(1, idCliente);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Long idCLiente = (Long) rs.getObject("IDCLIENTE");
                String nome = rs.getString("NOME");
                String sobrenome = rs.getString("SOBRENOME");
                String email = rs.getString("EMAIL");

                pessoa = new PessoaCliente(idCLiente, nome, sobrenome, email);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return pessoa;
    }

    @Override
    public void removerPessoaCliente(Long idCliente) throws DBException {
        PreparedStatement stmt = null;

        try {
            conexao =  ConnectionManager.getInstance().getConnection();
            String sql = "DELETE FROM TB_PESSOA_CLIENTE WHERE IDCLIENTE = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setObject(1, idCliente);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DBException("Erro ao remover");
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
