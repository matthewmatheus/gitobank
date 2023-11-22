package br.com.gitobank.dao.implement;

import br.com.gitobank.dao.PessoaFisicaDAO;
import br.com.gitobank.exception.DBException;
import br.com.gitobank.model.ClientePessoaFisica;
import br.com.gitobank.singleton.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OraclePessoaFisicaDAO implements PessoaFisicaDAO {

    private Connection conexao;

    @Override
    public ClientePessoaFisica cadastrarPessoaFisica(ClientePessoaFisica pessoaFisica) throws DBException {
        PreparedStatement stmtCliente = null;
        PreparedStatement stmtPessoaFisica = null;
        ResultSet rsKeys = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            conexao.setAutoCommit(false);

            String sqlInsertCliente = "INSERT INTO TB_PESSOA_CLIENTE (IDCLIENTE, NOME, SOBRENOME, EMAIL) VALUES (SEQ_CLIENTE_ID.NEXTVAL,?, ?, ?)";
            stmtCliente = conexao.prepareStatement(sqlInsertCliente, new String[]{"IDCLIENTE"});
            stmtCliente.setString(1, pessoaFisica.getNome());
            stmtCliente.setString(2, pessoaFisica.getSobrenome());
            stmtCliente.setString(3, pessoaFisica.getEmail());

            int linhasAfetadas = stmtCliente.executeUpdate();

            if (linhasAfetadas > 0) {
                rsKeys = stmtCliente.getGeneratedKeys();
                long idCliente = 0;
                if (rsKeys.next()) {
                    idCliente = rsKeys.getLong(1);

                    String sqlInsertPF = "INSERT INTO TB_CLIENTE_PF (IDCLIENTE, RG, CPF, DTNASCIMENTO, SEXO, IDADE) VALUES (?, ?, ?, ?, ?, ?)";
                    stmtPessoaFisica = conexao.prepareStatement(sqlInsertPF);
                    stmtPessoaFisica.setLong(1, idCliente);
                    stmtPessoaFisica.setString(2, pessoaFisica.getRg());
                    stmtPessoaFisica.setString(3, pessoaFisica.getCpf());
                    stmtPessoaFisica.setDate(4, java.sql.Date.valueOf(pessoaFisica.getDtNascimento()));
                    stmtPessoaFisica.setString(5, pessoaFisica.getSexo());
                    stmtPessoaFisica.setInt(6, pessoaFisica.getIdade());

                    stmtPessoaFisica.executeUpdate();

                    pessoaFisica.setIdCliente(idCliente);
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

            throw new DBException("Erro ao cadastrar Pessoa Física.");
        } finally {
            try {
                if (stmtCliente != null) {
                    stmtCliente.close();
                }
                if (stmtPessoaFisica != null) {
                    stmtPessoaFisica.close();
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

        return pessoaFisica;
    }
    @Override
    public ClientePessoaFisica obterPessoaFisica(Long idCliente) throws DBException {
        ClientePessoaFisica pessoaFisica = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            stmt = conexao.prepareStatement("SELECT * FROM TB_CLIENTE_PF WHERE IDCLIENTE = ?");
            stmt.setObject(1, idCliente);
            rs = stmt.executeQuery();

            if (rs.next()) {
                String rg = rs.getString("RG");
                String cpf = rs.getString("CPF");
                java.sql.Date dtNascimento = rs.getDate("DTNASCIMENTO");
                String sexo = rs.getString("SEXO");
                int idade = rs.getInt("IDADE");

                pessoaFisica = new ClientePessoaFisica( null, null, null, rg, cpf,
                        dtNascimento.toLocalDate(), sexo, idade);
                pessoaFisica.setIdCliente(idCliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return pessoaFisica;
    }

    @Override
    public void removerPessoaFisica(Long idCliente) throws DBException {
        // Implemente a remoção aqui, se necessário
    }
}
