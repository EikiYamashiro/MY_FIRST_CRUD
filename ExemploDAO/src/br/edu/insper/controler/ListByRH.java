package br.edu.insper.controler;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.insper.model.DAO;
import br.edu.insper.model.Task;

import java.util.*;
@WebServlet("/ListByRH")

public class ListByRH extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = new DAO();
		
		List<Task> tasks = dao.getByRH();
		
		request.setAttribute("tasks", tasks);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/listBy.jsp");
		dispatcher.forward(request, response);
		
		dao.close();
	}
	
}
