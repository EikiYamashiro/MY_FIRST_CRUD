package br.edu.insper.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.insper.model.DAO;
import br.edu.insper.model.Task;

@WebServlet("/altera")
public class Altera extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Altera() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/altera.jsp");
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = new DAO();
		Task tasks = new Task();
		System.out.println("-----------TITULO-------------");
		System.out.println(request.getParameter("titulo"));
		tasks.setTitulo(request.getParameter("titulo"));
		System.out.println("-----------ENTREGA-------------");
		System.out.println(request.getParameter("entrega"));
		tasks.setEntrega(request.getParameter("entrega"));
		System.out.println("-----------DESC-------------");
		System.out.println(request.getParameter("descricao"));
		tasks.setDescricao(request.getParameter("descricao"));
		System.out.println("-----------PRIORIDADE-------------");
		System.out.println(request.getParameter("prioridade"));
		tasks.setPrioridade(request.getParameter("prioridade"));
		System.out.println("-----------ID-------------");
		System.out.println(request.getParameter("id"));
		tasks.setArea(request.getParameter("area"));
		
		tasks.setId(Integer.valueOf(request.getParameter("id")));
		
		try {
			dao.altera(tasks);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Lista");
		dispatcher.forward(request, response);
		
		dao.close();

		
		
	}
}
