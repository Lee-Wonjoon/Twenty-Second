ackage fp.perfume.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import fp.perfume.model.service.PerfumeService;
import fp.perfume.model.vo.Perfume;

/**
 * Servlet implementation class KnowStepServlet
 */
@WebServlet(name = "KnowStep", urlPatterns = { "/knowStep" })
public class KnowStepServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KnowStepServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
//		String[] q1 = request.getParameterValues("q1");
//		String[] q2 = request.getParameterValues("q2");
//		String[] q3 = request.getParameterValues("q3");
//		String q4 = request.getParameter("q4");
//		int q5 = Integer.parseInt(request.getParameter("q5"));
//		Boolean q6 = Boolean.parseBoolean(request.getParameter("q6"));
//		String brand = request.getParameter("brand");
		String[] q1 = {"베르가못", "럼주", "바질"};
		String[] q2 = {"라벤더", "블랙페퍼", "클라리세이지"};
		String[] q3 = {"베티버"};
		String q4 = "2";
		int q5 = 100000;
		Boolean q6 = true;
		String brand = "VINCE CAMUTO";
		
		PerfumeService ps = new PerfumeService();
		ArrayList<Perfume> list = ps.searchAi(q1, q2, q3, q4, brand, q5, q6);
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("/paper/showProduct.jsp");
		rd.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
