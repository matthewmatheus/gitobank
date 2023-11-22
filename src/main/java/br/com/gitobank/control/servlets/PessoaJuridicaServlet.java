package br.com.gitobank.control.servlets;

import br.com.gitobank.dao.PessoaClienteDAO;
import br.com.gitobank.dao.PessoaFisicaDAO;
import br.com.gitobank.dao.PessoaJuridicaDAO;
import br.com.gitobank.exception.DBException;
import br.com.gitobank.factory.DAOFactory;
import br.com.gitobank.model.ClientePessoaFisica;
import br.com.gitobank.model.ClientePessoaJuridica;
import br.com.gitobank.model.PessoaCliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

@WebServlet("/novoClienteJuridica")
public class PessoaJuridicaServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private PessoaJuridicaDAO dao;

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            PessoaCliente pessoaCliente = (PessoaCliente) request.getAttribute("pessoa");

            String nome = request.getParameter("nome");
            String sobrenome = request.getParameter("sobrenome");
            String email = request.getParameter("email");

            // Obtendo os parâmetros do formulário
            String razaoSocial = request.getParameter("razaoSocial");
            String cnpj = request.getParameter("cnpj");
            String inscricaoEstadual = request.getParameter("inscricaoEstadual");
            String inscricaoMunicipal = request.getParameter("inscricaoMunicipal");
            LocalDate dataAbertura = LocalDate.parse(request.getParameter("dataAbertura"));

            // Criando um objeto ClientePessoaFisica
            ClientePessoaJuridica pessoaJuridica = new ClientePessoaJuridica(nome, sobrenome, email, razaoSocial, cnpj, inscricaoEstadual, inscricaoMunicipal, dataAbertura);

            // Cadastrando a Pessoa Física
            dao.cadastrarPessoaJuridica(pessoaJuridica);

            // Configurando mensagens de sucesso
            request.setAttribute("msg", "Pessoa Física cadastrada com sucesso!");
        } catch (DBException db) {
            db.printStackTrace();
            // Configurando mensagens de erro
            request.setAttribute("erro", "Erro ao cadastrar Pessoa Física");
        } catch (Exception e) {
            e.printStackTrace();
            // Configurando mensagens de erro
            request.setAttribute("erro", "Por favor, valide os dados");
        }

        // Redirecionando de volta para a página inicial ou outra página apropriada
        response.sendRedirect("home.jsp");

    }
}
