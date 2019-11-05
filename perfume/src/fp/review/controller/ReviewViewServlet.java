package fp.review.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fp.review.model.service.ReviewService;
import fp.review.model.vo.ReviewViewData;

/**
 * Servlet implementation class ReviewViewServlet
 */
@WebServlet(name = "ReviewView", urlPatterns = { "/reviewView" })
public class ReviewViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		ReviewService service = new ReviewService();
		ReviewViewData rvd = service.selectOne(reviewNo);
		if(rvd.getR() != null) {
			request.setAttribute("review", rvd.getR());
			request.setAttribute("comments", rvd.getList());
			RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/views/review/reviewList.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("msg", "해당 게시글이 없습니다.");
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
