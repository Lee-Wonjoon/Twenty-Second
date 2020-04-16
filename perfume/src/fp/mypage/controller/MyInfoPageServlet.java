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

/**
 * Servlet implementation class MyInfoPageServlet
 */
@WebServlet(name = "MyInfoPage", urlPatterns = { "/myInfoPage" })
public class MyInfoPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyInfoPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("member");
		RequestDispatcher rd;
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
		if(m != null) {
			if(m.getMemberId().equals(memberId)&&m.getMemberPw().equals(memberPw)) {
				rd = request.getRequestDispatcher("/WEB-INF/views/mypage/myInfoPage.jsp");				
			}else {
				System.out.println("뭔가 이상함. MyInfoPageServlet 확인좀요");
				rd = request.getRequestDispatcher("/");
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
