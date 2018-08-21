package HouseholdServlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HouseholdDAO;
import dto.Household;
import dto.ReturnI;

/**
 * Servlet implementation class AllServlet
 */
@WebServlet("/AllServlet")
public class AllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Household> list = HouseholdDAO.getAllData();
		int i=0;
		for(Household result : list){
			int number = result.getNumber();
			String date = result.getDate();
			int income = result.getIncome();
			int spending = result.getSpending();
			int balanceg = result.getBalanceg();
			String type = result.getType();
			Household data = new Household(number,date,income,spending,balanceg,type);
			String rs = "rs" + i ;
			request.setAttribute(rs,data);
			i++;
		}
		ReturnI ri = new ReturnI(i);
		request.setAttribute("inum",ri);

		String view = "/WEB-INF/view/All.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward (request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
