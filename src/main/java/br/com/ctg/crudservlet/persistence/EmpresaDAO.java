package br.com.ctg.crudservlet.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ctg.crudservlet.model.Empresa;

public class EmpresaDAO {
	
	
	public void grava(Empresa emp) throws SQLException {
	
		try(Connection con = new ConnectionFactory().open()){
			con.setAutoCommit(false);
			try(PreparedStatement stmt = con.prepareStatement("insert into empresa (nome, dataFundacao) values (?,?)")){
				stmt.setString(1, emp.getNome());
				stmt.setDate(2, new java.sql.Date(emp.getDataFundacao().getTime()));				
				stmt.executeUpdate();
			}catch (SQLException e) {
				con.rollback();
				throw new RuntimeException(e);				
			}
			con.commit();
		}
	}
	
	public void deleta(Long id) throws SQLException {
		try(Connection con = new ConnectionFactory().open()){
			con.setAutoCommit(false);
			try(PreparedStatement stmt = con.prepareStatement("delete from empresa where id = ?")){
				stmt.setLong(1, id);	
				stmt.executeUpdate();
			}catch (SQLException e) {
				con.rollback();
				throw new RuntimeException(e);				
			}
			con.commit();
		}
	}
	
	public void altera(Empresa emp) throws SQLException {
		
		try(Connection con = new ConnectionFactory().open()){
			con.setAutoCommit(false);
			try(PreparedStatement stmt = con.prepareStatement("update empresa set nome = ?, dataFundacao = ? where id = ?")){
				stmt.setString(1, emp.getNome());
				stmt.setDate(2, new java.sql.Date(emp.getDataFundacao().getTime()));
				stmt.setLong(3, emp.getId());
				stmt.executeUpdate();
			}catch (SQLException e) {
				con.rollback();
				throw new RuntimeException(e);				
			}
			con.commit();
		}
		
	}
	
	public List<Empresa> lista() throws SQLException {
		
		List<Empresa> empresas = new ArrayList<Empresa>();
		
		try(Connection con = new ConnectionFactory().open()){
			try(PreparedStatement stmt = con.prepareStatement("select id, nome, dataFundacao from empresa")){
				stmt.executeQuery();
				try(ResultSet rs = stmt.getResultSet()){
					while (rs.next()) {
						Empresa emp = new Empresa();
						emp.setId(rs.getLong("id"));
						emp.setNome(rs.getString("nome"));
						emp.setDataFundacao(rs.getDate("dataFundacao"));
						empresas.add(emp);
					}
				}
			}catch (SQLException e) {
				throw new RuntimeException(e);				
			}
		}
		
		return empresas;
		
	}
	
	public Empresa getEmpresaById(Long id) throws SQLException {
		
		Empresa emp = new Empresa();
		
		try(Connection con = new ConnectionFactory().open()){
			try(PreparedStatement stmt = con.prepareStatement("select id, nome, dataFundacao from empresa where id = ?")){
				stmt.setLong(1, id);
				stmt.executeQuery();
				try(ResultSet rs = stmt.getResultSet()){
					while (rs.next()) {						
						emp.setId(rs.getLong("id"));
						emp.setNome(rs.getString("nome"));
						emp.setDataFundacao(rs.getDate("dataFundacao"));
					}
				}
			}catch (SQLException e) {
				throw new RuntimeException(e);				
			}
		}
		
		return emp;
		
	}
	

}
