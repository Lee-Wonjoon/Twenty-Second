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

/**
 * Servlet implementation class ReviewSearchServlet
 */
@WebServlet(name = "ReviewSearch", urlPatterns = { "/reviewSearch" })
public class ReviewSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewService service = new ReviewService();
		String search = request.getParameter("search_txt");
		ArrayList<Review> list = service.selectSearch(search);
		if(list.isEmpty()){
			request.setAttribute("msg", "일치하는 해쉬 태그가 존재하지 않습니다.");
			request.setAttribute("loc", "/reviewList");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			rd.forward(request, response);
		}else {			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/review/reviewList.jsp");
			request.setAttribute("review", list);
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
