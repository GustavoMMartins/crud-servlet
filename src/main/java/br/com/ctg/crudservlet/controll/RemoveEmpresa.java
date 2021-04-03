package br.com.ctg.crudservlet.controll;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ctg.crudservlet.persistence.EmpresaDAO;

@WebServlet("/removeEmpresa")
public class RemoveEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long id = Long.valueOf(request.getParameter("id"));		
		EmpresaDAO dao = new EmpresaDAO();
		
		try {
			dao.deleta(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("/crud-servlet");		
		
	}


}
