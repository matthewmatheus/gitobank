package br.com.gitobank.dao.implement;

import br.com.gitobank.dao.PessoaFisicaDAO;
import br.com.gitobank.exception.DBException;
import br.com.gitobank.model.ClientePessoaFisica;
import br.com.gitobank.model.PessoaCliente;
import br.com.gitobank.singleton.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OraclePessoaFisicaDAO implements PessoaFisicaDAO {

    private Connection conexao;


    @Override
    public void cadastrarPessoaFisica(ClientePessoaFisica pessoaFisica) throws DBException {

        PreparedStatement stmt = null;

        try {
           conexao = ConnectionManager.getInstance().getConnection();
            String sql = "INSERT INTO TB_CLIENTE_PF (idCliente, RG, CPF, DTNASCIMENTO, SEXO, IDADE) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            stmt = conexao.prepareStatement(sql);
            stmt.setLong(1, pessoaFisica.getIdCliente());
            stmt.setString(2, pessoaFisica.getRg());
            stmt.setString(3, pessoaFisica.getCpf());
            stmt.setDate(4, java.sql.Date.valueOf(pessoaFisica.getDtNascimento()));
            stmt.setString(5, pessoaFisica.getSexo());
            stmt.setInt(6, pessoaFisica.getIdade());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao cadastrar Pessoa Física.");
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

                pessoaFisica = new ClientePessoaFisica(null, null, null, null, rg, cpf,
                        dtNascimento.toLocalDate(), sexo, idade);
                pessoaFisica.setIdCliente(idCliente);
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
        return pessoaFisica;
    }


    @Override
    public void removerPessoaFisica(Long idCliente) throws DBException {

    }
}
