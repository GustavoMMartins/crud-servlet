package br.com.ctg.crudservlet.controll;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ctg.crudservlet.model.Banco;
import br.com.ctg.crudservlet.model.Empresa;


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
		
		Banco banco = new Banco();
		
		Empresa emp = new Empresa(nome, dataFundacaoFormatada);
		
		banco.adicionaEmpresa(emp);
		
		response.sendRedirect("/crud-servlet");
		
	}

}
