package fp.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fp.member.model.service.MemberService;
import fp.member.model.vo.Member;

/**
 * Servlet implementation class KakaoJoinServlet
 */
@WebServlet("/kakaoJoin")
public class KakaoJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KakaoJoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String memberId = request.getParameter("memberId");
		String memberNickName = request.getParameter("memberNickName");
		String memberPw = request.getParameter("memberPw");
		String memberGender = request.getParameter("memberGender");
		String memberBirth = request.getParameter("memberBirth");
		String memberPhone = request.getParameter("memberPhone");
		Member m = new Member(0,memberId, memberNickName, memberPw, memberGender, memberBirth, memberPhone, null,null,null,null);
		MemberService service = new MemberService();
		int result = service.insertMember(m);
		RequestDispatcher rd = null;
		if(result>0) {
			request.setAttribute("msg", "회원가입 성공");
			rd = request.getRequestDispatcher("/views/member/login.jsp");

		}else {
			request.setAttribute("msg", "회원가입 실패");
			rd = request.getRequestDispatcher("/WEB-INF/views/member/kakaoJoin.jsp");
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
