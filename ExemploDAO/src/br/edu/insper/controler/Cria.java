package br.edu.insper.controler;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.insper.model.DAO;
import br.edu.insper.model.Task;


@WebServlet("/cria")
public class Cria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cria() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = new DAO();
		List<Task> tasks = dao.getLista();
		request.setAttribute("tasks", tasks);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/cria.jsp");
		dispatcher.forward(request, response);
		dao.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = new DAO();
		Task task = new Task();
		task.setTitulo(request.getParameter("titulo"));
		task.setPrioridade(request.getParameter("prioridade"));
		task.setDescricao(request.getParameter("descricao"));
		task.setEntrega(request.getParameter("entrega"));
		task.setArea(request.getParameter("area"));
		dao.cria(task);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Lista");
		dispatcher.forward(request, response);
		
		dao.close();
	}
}