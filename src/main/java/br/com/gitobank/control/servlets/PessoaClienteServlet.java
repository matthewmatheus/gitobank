package br.com.gitobank.control.servlets;

import br.com.gitobank.dao.PessoaClienteDAO;
import br.com.gitobank.exception.DBException;
import br.com.gitobank.factory.DAOFactory;
import br.com.gitobank.model.PessoaCliente;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/novoCliente")
public class PessoaClienteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private PessoaClienteDAO dao;

    @Override
    public void init() throws ServletException {
        super.init();
        dao = DAOFactory.getPessoaaDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {
            String nome = request.getParameter("nome");
            String sobrenome = request.getParameter("sobrenome");
            String email = request.getParameter("email");
            String tipoPessoa = request.getParameter("tipoPessoa");

            HttpSession session = request.getSession();
            session.setAttribute("nome", nome);
            session.setAttribute("sobrenome", sobrenome);
            session.setAttribute("email", email);


            if ("fisica".equals(tipoPessoa)) {
                // Adicione os parâmetros na URL para serem acessados no novo servlet
                RequestDispatcher dispatcher = request.getRequestDispatcher("formularioPessoaFisica.jsp");
                dispatcher.forward(request, response);
            } else if ("juridica".equals(tipoPessoa)) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("formularioPessoaJuridica.jsp");
                dispatcher.forward(request, response);
            }


            request.setAttribute("msg", "Produto cadastrado!");

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("erro", "Por favor, valide os dados");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}