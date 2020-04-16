package fp.review.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fp.review.model.service.ReviewService;

import com.google.gson.Gson;

/**
 * Servlet implementation class ReviewCommentUpdateServlet
 */
@WebServlet(name = "ReviewCommentUpdate", urlPatterns = { "/reviewCommentUpdate" })
public class ReviewCommentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewCommentUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reviewCommentNo = Integer.parseInt(request.getParameter("no"));
		String reviewCommentContent = request.getParameter("reviewCommentContent");
		ReviewService service = new ReviewService();
		int result = service.updateReviewComment(reviewCommentNo,reviewCommentContent);
		if(result>0) {
			response.setContentType("application/json; charset=utf-8");
			new Gson().toJson(result,response.getWriter());
		}else {
			request.setAttribute("msg", "댓글수정을 실패하였습니다.");
			request.setAttribute("loc", "/reviewList");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			rd.forward(request, response);		
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
