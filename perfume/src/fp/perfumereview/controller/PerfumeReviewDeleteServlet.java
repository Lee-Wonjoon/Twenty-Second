package fp.perfumereview.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fp.perfumereview.model.service.PerfumeReviewService;
import fp.perfumereview.model.vo.PerfumeReview;

/**
 * Servlet implementation class PerfumeReviewDeleteServlet
 */
@WebServlet(name = "PerfumeReviewDelete", urlPatterns = { "/perfumeReviewDelete" })
public class PerfumeReviewDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PerfumeReviewDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int perfumeNo = Integer.parseInt(request.getParameter("perfumeNo"));
		int perfumeReviewNo = Integer.parseInt(request.getParameter("perfumeReviewNo"));
		PerfumeReviewService service = new PerfumeReviewService();
		int result = service.deletePerfumeReview(perfumeReviewNo);
		request.setAttribute("righttab", "righttab");
		RequestDispatcher rd = request.getRequestDispatcher("/viewPerfume?perfumeNo="+perfumeNo);
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
