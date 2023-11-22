package br.com.gitobank.dao.implement;

import br.com.gitobank.dao.PessoaJuridicaDAO;
import br.com.gitobank.exception.DBException;
import br.com.gitobank.model.ClientePessoaJuridica;
import br.com.gitobank.singleton.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OraclePessoaJuridicaDAO implements PessoaJuridicaDAO {

    private Connection conexao;

    @Override
    public void cadastrarPessoaJuridica(ClientePessoaJuridica pessoaJuridica) throws DBException {

        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO TB_PESSOA_JURIDICA (IDCLIENTE, NOME, SOBRENOME, EMAIL, RAZAO_SOCIAL, CNPJ, INSCRICAO_ESTADUAL, INSCRICAO_MUNICIPAL, DATA_ABERTURA) " +
                    "VALUES (SEQ_CLIENTE_ID.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";

            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, pessoaJuridica.getNome());
            stmt.setString(2, pessoaJuridica.getSobrenome());
            stmt.setString(3, pessoaJuridica.getEmail());
            stmt.setString(4, pessoaJuridica.getRazaoSocial());
            stmt.setString(5, pessoaJuridica.getCpnj());
            stmt.setString(6, pessoaJuridica.getInscricaoEstadual());
            stmt.setString(7, pessoaJuridica.getInscricaoMunicipal());
            stmt.setDate(8, new java.sql.Date(pessoaJuridica.getDataAbertura().getDayOfYear()));

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao cadastrar pessoa jurídica.");
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
    public ClientePessoaJuridica obterPessoaJuridica(Long idCliente) throws DBException {
        return null;
    }

    @Override
    public void removerPessoaJuridica(Long idCliente) throws DBException {

    }
}
