package fp.mypage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fp.member.model.vo.Member;
import fp.perfumereview.model.service.PerfumeReviewService;
import fp.perfumereview.model.vo.PerfumeReviewAndPhotoAndName;


/**
 * Servlet implementation class PerfumeReviewListServlet
 */
@WebServlet(name = "PerfumeReviewList", urlPatterns = { "/perfumeReviewList" })
public class PerfumeReviewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PerfumeReviewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("member")==null) {
			request.setAttribute("msg", "로그인해주세요");
			request.setAttribute("loc", "/");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			rd.forward(request, response);
		}else {
			System.out.println("로그인 확인");
			Member m = (Member)session.getAttribute("member");
			int memberNo = m.getMemberNo();
			PerfumeReviewService service = new PerfumeReviewService();
			ArrayList<PerfumeReviewAndPhotoAndName> list = service.selectAllonMemberNo(memberNo);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/mypage/perfumeReviewList.jsp");
			request.setAttribute("perfumeReviewList", list);
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
