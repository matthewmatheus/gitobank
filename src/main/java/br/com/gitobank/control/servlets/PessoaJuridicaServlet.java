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
import jakarta.servlet.http.HttpSession;

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
        dao = DAOFactory.getPessoaJuridicaDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            HttpSession session = request.getSession();
            String nome = (String) session.getAttribute("nome");
            String sobrenome = (String) session.getAttribute("sobrenome");
            String email = (String) session.getAttribute("email");


            // Obtendo os parâmetros do formulário
            String razaoSocial = request.getParameter("razaoSocial");
            String cnpj = request.getParameter("cnpj");
            String inscricaoEstadual = request.getParameter("inscricaoEstadual");
            String inscricaoMunicipal = request.getParameter("inscricaoMunicipal");
            LocalDate dataAbertura = LocalDate.parse(request.getParameter("dataAbertura"));

            // Criando um objeto ClientePessoaFisica
            ClientePessoaJuridica pessoaJuridica = new ClientePessoaJuridica(nome, sobrenome, email, razaoSocial, cnpj, inscricaoEstadual, inscricaoMunicipal, dataAbertura);

            // Cadastrando a Pessoa Jurídica
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

        // Redirecionando de volta para a página homez
        response.sendRedirect("home.jsp");

    }
}
