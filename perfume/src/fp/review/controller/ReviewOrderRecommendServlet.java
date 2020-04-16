package fp.review.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fp.review.model.service.ReviewService;
import fp.review.model.vo.Review;
import fp.review.model.vo.ReviewRecommend;

/**
 * Servlet implementation class ReviewOrderRecommendServlet
 */
@WebServlet(name = "ReviewOrderRecommend", urlPatterns = { "/reviewOrderRecommend" })
public class ReviewOrderRecommendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewOrderRecommendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewService service = new ReviewService();
		ArrayList<Review> list = service.selectRecommend();
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/review/reviewList.jsp");
		ArrayList<ReviewRecommend> recommend = service.selectRecommendAll();
		request.setAttribute("recommend", recommend);
		request.setAttribute("review", list);
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
