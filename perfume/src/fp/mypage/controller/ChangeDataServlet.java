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

import fp.member.model.service.MemberService;
import fp.member.model.vo.Member;
import fp.perfumereview.model.service.PerfumeReviewService;

/**
 * Servlet implementation class ChangeDataServlet
 */
@WebServlet(name = "ChangeData", urlPatterns = { "/changeData" })
public class ChangeDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeDataServlet() {
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
			Member m = (Member)session.getAttribute("member");
			int memberNo = m.getMemberNo();
			String phone = request.getParameter("phone");
			String birth = request.getParameter("birth");
			String gender = request.getParameter("gender");
			switch(gender) {
				case "남자" : gender="male";
				break;
				case "여자" : gender="female";
				break;
				default : gender = null;
			}
			MemberService service = new MemberService();
			int result = service.updateData(memberNo,phone,birth,gender);
			if(result>0) {
				String msg = "회원정보가 변경되었습니다.";
				String loc = "/myInfoCheck";
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
				request.setAttribute("msg", msg);
				request.setAttribute("loc", loc);
				rd.forward(request, response);
			}else {
				String msg = "정보변경이 실패했습니다.";
				String loc = "/myInfoCheck";
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
				request.setAttribute("msg", msg);
				request.setAttribute("loc", loc);
				rd.forward(request, response);
			}
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
