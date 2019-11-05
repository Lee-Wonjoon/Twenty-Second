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

import fp.CS.models.vo.Question;
import fp.member.model.vo.Member;
import fp.mypage.model.sevice.MypageService;
import fp.mypage.model.vo.QuestionData;

/**
 * Servlet implementation class QuestionListServlet
 */
@WebServlet(name = "QuestionList", urlPatterns = { "/questionList" })
public class QuestionListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionListServlet() {
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
		
		if(m != null) {
			MypageService service = new MypageService();
			ArrayList<Question> list = service.questionList(m.getMemberNo());
			if(list != null) {
				int size = list.size();
				request.setAttribute("size", size);
			}
			ArrayList<Question> ans = service.answerList();
			request.setAttribute("list", list);
			request.setAttribute("ans", ans);
			rd = request.getRequestDispatcher("/WEB-INF/views/mypage/questionList.jsp");	
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
