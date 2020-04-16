package fp.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fp.member.model.sendmail.SendMail;
import fp.member.model.service.MemberService;

/**
 * Servlet implementation class AutoServlet
 */
@WebServlet("/auto2")
public class Auto2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Auto2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//인코딩
		String memberId = request.getParameter("memberId");//변수저장
		System.out.println(memberId);//변수출력
		SendMail sm = new SendMail();//SendMail객체 생성
		String testpw = sm.mail2(memberId);//id라는 변수를 SendMail클래스의 memberId를 가지고 있는 mail매소드로 전송
		MemberService service = new MemberService();
		int result = service.UpdatePassword(memberId, testpw);
		if (result > 0) {
			System.out.println("변경 성공");
		}
		PrintWriter out = response.getWriter();//SendMail클래스의 리턴 값에 반응하여 out에 저장
		out.print(testpw);//id값을 출력
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
