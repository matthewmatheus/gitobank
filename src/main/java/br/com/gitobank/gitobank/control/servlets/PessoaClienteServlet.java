package br.com.gitobank.gitobank.control.servlets;

import br.com.gitobank.dao.PessoaClienteDAO;
import br.com.gitobank.exception.DBException;
import br.com.gitobank.factory.DAOFactory;
import br.com.gitobank.gitobank.model.PessoaCliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/novoCliente")
public class PessoaClienteServlet extends HttpServlet {

    private static final Long serialVersionUID = 1L;
    private PessoaClienteDAO dao;

    @Override
    public void init() throws ServletException {
        super.init();
        dao = DAOFactory.getPessoaaDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String nome  = req.getParameter("nome");
            String sobrenome = req.getParameter("sobrenome");
            String email = req.getParameter("email");

            PessoaCliente pessoa = new PessoaCliente("Fulaninho", "De tal", "fulanodois@email.com");
            dao.cadastrarPessoaCliente(pessoa);
            req.setAttribute("msg", "Cadastro concluido!");
        } catch (DBException db) {
            db.printStackTrace();
            req.setAttribute("erro", "Erro ao cadastrar");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("erro", "por favor valide os dados");
        }
    }
}
