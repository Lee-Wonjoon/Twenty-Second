package fp.review.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fp.review.model.service.ReviewService;
import fp.review.model.vo.ReviewComment;

import com.google.gson.Gson;

/**
 * Servlet implementation class ReviewCommentInsertServlet
 */
@WebServlet(name = "ReviewCommentInsert", urlPatterns = { "/reviewCommentInsert" })
public class ReviewCommentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewCommentInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reviewCommentWriter = request.getParameter("commentWriter");
		String reviewCommentContent = request.getParameter("commentWrite");
		int reviewRef = Integer.parseInt(request.getParameter("reviewNo"));
		ReviewComment nc = new ReviewComment(0, reviewCommentWriter, reviewCommentContent, reviewRef, null);
		ReviewService service = new ReviewService();
		int result = service.insertReviewComment(nc);
		result = service.selectCommentNo();

		response.setContentType("application/json; charset=utf-8");
		new Gson().toJson(result,response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
