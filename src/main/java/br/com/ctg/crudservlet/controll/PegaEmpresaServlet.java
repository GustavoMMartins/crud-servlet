package br.com.ctg.crudservlet.controll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ctg.crudservlet.model.Banco;
import br.com.ctg.crudservlet.model.Empresa;

/**
 * Servlet implementation class PegaEmpresaServlet
 */
@WebServlet("/editaEmpresa")
public class PegaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		Long id = Long.valueOf(request.getParameter("id"));
		
		Banco banco = new Banco();
		
		Empresa emp = banco.getEmpresaById(id);
		
		request.setAttribute("empresa", emp);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/formAlteraEmpresa.jsp");
		rd.forward(request, response);
		
	}

}
