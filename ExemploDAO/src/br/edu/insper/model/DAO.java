package br.edu.insper.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DAO {
	private Connection connection = null;
	public DAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(  
					"jdbc:mysql://localhost/projeto_1", "root", "insper2020");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Task> getByRH() {
		List<Task> tasks = new ArrayList<Task>();
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement("SELECT * FROM Tasks WHERE area='RH';");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				Task task = new Task();
				task.setId(rs.getInt("id"));
				task.setTitulo(rs.getString("titulo"));
				task.setPrioridade(rs.getString("prioridade"));
				task.setDescricao(rs.getString("descricao"));
				task.setEntrega(rs.getString("entrega"));
				task.setArea(rs.getString("area"));
				tasks.add(task);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return tasks;
		
	}
	
	public List<Task> getByHardware() {
		List<Task> tasks = new ArrayList<Task>();
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement("SELECT * FROM Tasks WHERE area='Hardware';");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				Task task = new Task();
				task.setId(rs.getInt("id"));
				task.setTitulo(rs.getString("titulo"));
				task.setPrioridade(rs.getString("prioridade"));
				task.setDescricao(rs.getString("descricao"));
				task.setEntrega(rs.getString("entrega"));
				task.setArea(rs.getString("area"));
				tasks.add(task);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return tasks;
		
	}
	
	public List<Task> getBySoftware() {
		List<Task> tasks = new ArrayList<Task>();
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement("SELECT * FROM Tasks WHERE area='Software';");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				Task task = new Task();
				task.setId(rs.getInt("id"));
				task.setTitulo(rs.getString("titulo"));
				task.setPrioridade(rs.getString("prioridade"));
				task.setDescricao(rs.getString("descricao"));
				task.setEntrega(rs.getString("entrega"));
				task.setArea(rs.getString("area"));
				tasks.add(task);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return tasks;
		
	}
	
	public List<Task> getLista() {
		List<Task> tasks = new ArrayList<Task>();
		
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement("SELECT * FROM Tasks ORDER BY prioridade DESC;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				Task task = new Task();
				task.setId(rs.getInt("id"));
				task.setTitulo(rs.getString("titulo"));
				task.setPrioridade(rs.getString("prioridade"));
				task.setDescricao(rs.getString("descricao"));
				task.setEntrega(rs.getString("entrega"));
				task.setArea(rs.getString("area"));
				tasks.add(task);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return tasks;
		
		
	}
	
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cria(Task task) {
		String sql = "INSERT INTO Tasks" + "(titulo, prioridade, descricao, entrega, area) values(?,?,?,?,?);";
		PreparedStatement stmt = null;
		
		try {
			stmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.setString(1, task.getTitulo());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.setString(2, task.getPrioridade());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			stmt.setString(3, task.getDescricao());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			stmt.setString(4, task.getEntrega());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			stmt.setString(5, task.getArea());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void altera(Task task) throws SQLException { 
		String sql = "UPDATE Tasks SET " + "titulo=?,prioridade=?,descricao=?,entrega=? WHERE id=?";
		PreparedStatement stmt = null;
		stmt = connection.prepareStatement(sql);
		stmt.setString(1, task.getTitulo());
		stmt.setString(2, task.getPrioridade());
		stmt.setString(3, task.getDescricao());
		stmt.setString(4, task.getEntrega());
		stmt.setInt(5, task.getId());
		
		stmt.execute();
	
		stmt.close();
		} 
	
	public void remove(String titulo){
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement("DELETE FROM Tasks WHERE titulo=?");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			stmt.setNString(1, titulo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

