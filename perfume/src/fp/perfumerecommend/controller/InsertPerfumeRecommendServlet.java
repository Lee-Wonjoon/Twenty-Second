package fp.perfumerecommend.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fp.perfume.model.service.PerfumeService;
import fp.perfume.model.vo.Perfume;
import fp.perfumerecommend.model.service.PerfumeRecommendService;
import fp.perfumerecommend.model.vo.PerfumeRecommend;

/**
 * Servlet implementation class InsertPerfumeRecommendServlet
 */
@WebServlet(name = "InsertPerfumeRecommend", urlPatterns = { "/insertPerfumeRecommend" })
public class InsertPerfumeRecommendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertPerfumeRecommendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		int perfumeNo = Integer.parseInt(request.getParameter("perfumeNo"));
		String heart = request.getParameter("heart");
		PerfumeRecommendService service = new PerfumeRecommendService();
		PerfumeRecommend pr = new PerfumeRecommend(0, memberNo, perfumeNo, null);
		if(heart.equals("insert")) {
			int result1 = service.insertRecommend(pr);
		} else {
			int result1 = service.deleteRecommend(pr);
		}		
		PerfumeRecommend pr2 = service.checkRecommend(memberNo, perfumeNo);
		
		request.setAttribute("pr", pr2);
		RequestDispatcher rd = request.getRequestDispatcher("/viewPerfume?perfumeNo="+perfumeNo);
		/*
		 * RequestDispatcher rd =
		 * request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		 */
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
