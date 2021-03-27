package br.com.ctg.crudservlet.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Banco {
	
	public static List<Empresa> empresas = new ArrayList<Empresa>();
	public static Long idIncrement = 1L;
	
	static {		
		Empresa emp1 = new Empresa(idIncrement++, "Facebook", new Date());
		Empresa emp2 = new Empresa(idIncrement++, "Google", new Date());		
		Banco.empresas.add(emp1);
		Banco.empresas.add(emp2);	
	}
	
	public void adicionaEmpresa (Empresa emp) {
		emp.setId(idIncrement++);
		Banco.empresas.add(emp);
	}
	
	public Empresa getEmpresaById(Long id) {		
		for (Empresa emp : empresas) {
			if(emp.getId() == id) {
				return emp;
			}
		}		
		return null;		
	}

	public void remevoEmpresaById(Long id) {
		Empresa emp = getEmpresaById(id);
		Banco.empresas.remove(emp);
	}
	
}
