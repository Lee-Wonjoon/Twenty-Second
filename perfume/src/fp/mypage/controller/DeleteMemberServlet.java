package fp.mypage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fp.member.model.vo.Member;
import fp.mypage.model.sevice.MypageService;

/**
 * Servlet implementation class DeleteMemberServlet
 */
@WebServlet(name = "DeleteMember", urlPatterns = { "/deleteMember" })
public class DeleteMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("member");
		RequestDispatcher rd;
		String delMes = request.getParameter("unregister_form_reason");
		if(m != null) {
			MypageService service = new MypageService();
			int result = service.outMember(delMes, m.getMemberNo());
			if(result != 0) {
				session.invalidate();
				request.setAttribute("msg", "계정이 비활성화되었습니다.");
				rd = request.getRequestDispatcher("/");
			}else {
				System.out.println("이상함. outpageservlet");
				rd = request.getRequestDispatcher("/WEB-INF/views/mypage/outPage.jsp");
			}
		}else {
			request.setAttribute("msg", "로그인을 먼저 해주세요");
			rd = request.getRequestDispatcher("/views/member/login.jsp");
		}
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
