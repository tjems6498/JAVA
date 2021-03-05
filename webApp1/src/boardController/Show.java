package boardController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.Board;
import board.Service;
import board.ServiceImpl;
import mem.Member;

/**
 * Servlet implementation class Show
 */
@WebServlet("/board/Show")
public class Show extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Show() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Service service = new ServiceImpl();
		ArrayList<Board> list = service.getAll();
	
		request.setAttribute("list", list);
		RequestDispatcher ds = request.getRequestDispatcher("/boarder/show.jsp");
		ds.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		String id = (String)session.getAttribute("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		Board b = new Board(id,title,content);
		Service service = new ServiceImpl();
		service.writeBoard(b);
		
		doGet(request, response);
	}

}
