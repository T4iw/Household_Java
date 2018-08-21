package HouseholdServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HouseholdDAO;

/**
 * Servlet implementation class RegisterResultServlet
 */
@WebServlet("/RegisterResultServlet")
public class RegisterResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request. setCharacterEncoding("UTF-8");
		String key1 = request.getParameter("number");
		String key2 = request.getParameter("date");
		String key3 = request.getParameter("income");
		String key4 = request.getParameter("spending");
		String key5 = request.getParameter("balanceg");
		String key6 = request.getParameter("type");
		if("".equals(key1)||"".equals(key2)||"".equals(key3)||"".equals(key4)||"".equals(key5)||"".equals(key6)){
			String view = "/WEB-INF/view/RegisterResult2.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward (request, response);
		}else{
			int kkey1=Integer.parseInt(key1);
			int kkey3=Integer.parseInt(key3);
			int kkey4=Integer.parseInt(key4);
			int kkey5=Integer.parseInt(key5);
			HouseholdDAO.newDataDAO(kkey1,key2,kkey3,kkey4,kkey5,key6);
			String view = "/WEB-INF/view/RegisterResult.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward (request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
