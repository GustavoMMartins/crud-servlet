package br.com.ctg.crudservlet.controll;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ctg.crudservlet.model.Banco;
import br.com.ctg.crudservlet.model.Empresa;


@WebServlet("/listaEmpresas")
public class ListaEmpresas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		List<Empresa> empresas = Banco.empresas;		
		request.setAttribute("empresas", empresas);
		RequestDispatcher rd =  request.getRequestDispatcher("WEB-INF/jsp/listaEmpresas.jsp");
		rd.forward(request, response);
	}

}
