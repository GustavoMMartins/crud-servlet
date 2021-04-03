package br.com.ctg.crudservlet.controll;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ctg.crudservlet.model.Empresa;
import br.com.ctg.crudservlet.persistence.EmpresaDAO;


@WebServlet("/alteraEmpresa")
public class AlteraEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long id = Long.valueOf(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String dataFundacao = request.getParameter("dataFundacao") ;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dataFundacaoFormatado = new Date();		
		
		try {
			if(!dataFundacao.equals("")) {
				dataFundacaoFormatado = sdf.parse(dataFundacao);				
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		EmpresaDAO dao = new EmpresaDAO();
		
		try {
			Empresa emp = dao.getEmpresaById(id);
			emp.setNome(nome);
			emp.setDataFundacao(dataFundacaoFormatado);
			dao.altera(emp);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		response.sendRedirect("/crud-servlet");		
	}

}
