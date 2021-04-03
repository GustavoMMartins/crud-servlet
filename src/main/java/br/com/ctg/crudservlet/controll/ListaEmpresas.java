package br.com.ctg.crudservlet.controll;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ctg.crudservlet.model.Empresa;
import br.com.ctg.crudservlet.persistence.EmpresaDAO;


@WebServlet("/listaEmpresas")
public class ListaEmpresas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		EmpresaDAO dao = new EmpresaDAO();
		try {
			List<Empresa> empresas = dao.lista();
			request.setAttribute("empresas", empresas);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		RequestDispatcher rd =  request.getRequestDispatcher("WEB-INF/jsp/listaEmpresas.jsp");
		rd.forward(request, response);
	}

}
