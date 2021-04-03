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


@WebServlet("/cadastraEmpresa")
public class CadastraEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String dataFundacao = request.getParameter("dataFundacao");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date dataFundacaoFormatada = new Date();
				
		try {
			if(!dataFundacao.equals("")) {
				dataFundacaoFormatada = sdf.parse(dataFundacao);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		Empresa emp = new Empresa(nome, dataFundacaoFormatada);
		
		EmpresaDAO dao = new EmpresaDAO();
		
		try {
			dao.grava(emp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("/crud-servlet");
		
	}

}
