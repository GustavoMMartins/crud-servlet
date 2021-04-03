package br.com.ctg.crudservlet.controll;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ctg.crudservlet.model.Empresa;
import br.com.ctg.crudservlet.persistence.EmpresaDAO;

/**
 * Servlet implementation class PegaEmpresaServlet
 */
@WebServlet("/editaEmpresa")
public class PegaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		Long id = Long.valueOf(request.getParameter("id"));
		
		EmpresaDAO dao = new EmpresaDAO();	
	
		try {
			Empresa emp = dao.getEmpresaById(id);
			request.setAttribute("empresa", emp);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
				
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/formAlteraEmpresa.jsp");
		rd.forward(request, response);
		
	}

}
