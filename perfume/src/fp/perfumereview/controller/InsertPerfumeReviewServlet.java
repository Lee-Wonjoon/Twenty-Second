package fp.perfumereview.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fp.member.model.vo.Member;
import fp.perfumereview.model.service.PerfumeReviewService;
import fp.perfumereview.model.vo.PerfumeReview;

/**
 * Servlet implementation class InsertPerfumeReviewServlet
 */
@WebServlet(name = "InsertPerfumeReview", urlPatterns = { "/insertPerfumeReview" })
public class InsertPerfumeReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertPerfumeReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	      int perfumeNo = Integer.parseInt(request.getParameter("perfumeNo"));
	      int memberNo = Integer.parseInt(request.getParameter("memberNo"));
	      String memberNickname = request.getParameter("memberNickname");
	      String perfumeReviewTitle = request.getParameter("perfumeReviewTitle");
	      String perfumeReviewContent = request.getParameter("perfumeReviewContent");
	      PerfumeReviewService service = new PerfumeReviewService();
	      
	      ArrayList<PerfumeReview> prlist = service.onePerfumeReview(perfumeNo);      
	      request.setAttribute("prlist", prlist);
	      request.setAttribute("righttab", "righttab");
	      
	      if(perfumeReviewContent.equals("")) {
	         request.setAttribute("msg", "내용을 입력해주세요.");               
	         RequestDispatcher rd = request.getRequestDispatcher("/viewPerfume?perfumeNo="+perfumeNo);
	         rd.forward(request, response);
	      } else {
	         PerfumeReview pfreview = new PerfumeReview(0, memberNo, memberNickname, perfumeNo, perfumeReviewTitle, perfumeReviewContent, null);      
	         int result = service.insertPerfumeReview(pfreview);
	         RequestDispatcher rd = request.getRequestDispatcher("/viewPerfume?perfumeNo="+perfumeNo);
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
