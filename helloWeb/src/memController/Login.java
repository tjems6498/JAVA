package memController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mem.Member;
import mem.Service;
import mem.ServiceImpl;

/**
 * Servlet implementation class Login 서블릿은 웹 기능을 구현한 자바파일
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher ds = request.getRequestDispatcher("cssTest.jsp");
		ds.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String result = "cssTest.jsp";
		Service service = new ServiceImpl();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		boolean flag = service.login(id, pwd);

		if (flag) {
			result = "success.jsp?id=" + id;
		}

		// 서버 내에서 페이지 이동
		RequestDispatcher ds = request.getRequestDispatcher(result);
		ds.forward(request, response);
	}

}
