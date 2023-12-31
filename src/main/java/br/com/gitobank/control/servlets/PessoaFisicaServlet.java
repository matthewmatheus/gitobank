package br.com.gitobank.control.servlets;

import br.com.gitobank.dao.PessoaFisicaDAO;
import br.com.gitobank.exception.DBException;
import br.com.gitobank.factory.DAOFactory;
import br.com.gitobank.model.ClientePessoaFisica;
import br.com.gitobank.model.PessoaCliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/novoClienteFisica")
public class PessoaFisicaServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private PessoaFisicaDAO dao;

    @Override
    public void init() throws ServletException {
        super.init();
        dao = DAOFactory.getPessoaFisicaDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            HttpSession session = request.getSession();
            String nome = (String) session.getAttribute("nome");
            String sobrenome = (String) session.getAttribute("sobrenome");
            String email = (String) session.getAttribute("email");


            // Obtendo os parâmetros do formulário
            String rg = request.getParameter("rg");
            String cpf = request.getParameter("cpf");
            LocalDate dtNascimento = LocalDate.parse(request.getParameter("dtNascimento"));
            String sexo = request.getParameter("sexo");
            int idade = Integer.parseInt(request.getParameter("idade"));

            // Criando um objeto ClientePessoaFisica
            ClientePessoaFisica pessoaFisica = new ClientePessoaFisica(nome, sobrenome, email, rg, cpf, dtNascimento, sexo, idade);

            // Cadastrando a Pessoa Física
            dao.cadastrarPessoaFisica(pessoaFisica);


            // Configurando mensagens de sucesso
            request.setAttribute("msg", "Pessoa Física cadastrada com sucesso!");
            System.out.println("sucesso");
        } catch (DBException db) {
            db.printStackTrace();
            // Configurando mensagens de erro
            request.setAttribute("erro", "Erro ao cadastrar Pessoa Física");
            System.out.println("erro cadastro");
        } catch (Exception e) {
            e.printStackTrace();
            // Configurando mensagens de erro
            request.setAttribute("erro", "Por favor, valide os dados");
            System.out.println("erro dados");
        }

        // Redirecionando de volta para a página home
        response.sendRedirect("home.jsp");

    }
}
