package br.com.gitobank.control.servlets;

import br.com.gitobank.dao.PessoaClienteDAO;
import br.com.gitobank.exception.DBException;
import br.com.gitobank.factory.DAOFactory;
import br.com.gitobank.model.PessoaCliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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

            PessoaCliente pessoa = new PessoaCliente(nome,sobrenome, email);

            if ("fisica".equals(tipoPessoa)) {
                // Adicione os parâmetros na URL para serem acessados no novo servlet
                response.sendRedirect("formularioPessoaFisica.jsp?nome=" + nome + "&sobrenome=" + sobrenome + "&email=" + email);
            } else if ("juridica".equals(tipoPessoa)) {
                response.sendRedirect("formularioPessoaJuridica.jsp?nome=" + nome + "&sobrenome=" + sobrenome + "&email=" + email);
            }

//            dao.cadastrarPessoaCliente(pessoa);


            request.setAttribute("msg", "Produto cadastrado!");
//        }catch(DBException db) {
//            db.printStackTrace();
//            request.setAttribute("erro", "Erro ao cadastrar");
        }catch(Exception e){
            e.printStackTrace();
            request.setAttribute("erro","Por favor, valide os dados");
        }
//        request.getRequestDispatcher("index.jsp").forward(request, response);
    }


}