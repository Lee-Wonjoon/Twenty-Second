package fp.review.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fp.review.model.service.ReviewService;

/**
 * Servlet implementation class ReviewRecommendMusServlet
 */
@WebServlet(name = "ReviewRecommendMus", urlPatterns = { "/reviewRecommendMus" })
public class ReviewRecommendMusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewRecommendMusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		
		ReviewService service = new ReviewService();
		int result2= service.deleteRecommendInfo(reviewNo,memberNo);
		int result = service.updateRecommendMinus(reviewNo);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
