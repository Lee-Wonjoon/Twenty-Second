package fp.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fp.CS.models.vo.Question;
import fp.admin.models.service.AdminService;
import fp.member.model.vo.Member;

/**
 * Servlet implementation class ReadQuestionAdminServlet
 */
@WebServlet(name = "ReadQuestionAdmin", urlPatterns = { "/readQuestionAdmin" })
public class ReadQuestionAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadQuestionAdminServlet() {
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
			if(m.getMemberId().equals("admin@")) {
				int questionNo = Integer.parseInt(request.getParameter("questionNo"));
				String questionStatus = request.getParameter("questionStatus");
				AdminService service = new AdminService();
				if(questionStatus.equals("접수")) {
					String to = "처리중";
					int result = service.readQuestionAdmin(questionNo, to);
					if(result == 0) {
						System.out.println("확인 처리 실패");
					}
				}
				Question q = service.getQuestion(questionNo);
				if(q == null) {
					System.out.println("문의 호출 실패");
				}
				Question qa = service.getQuestionAnswer(questionNo);
				if(qa == null) {
					System.out.println("문의 답변 없거나 이상함");
				}
				request.setAttribute("question", q);
				request.setAttribute("answer", qa);
				
				rd = request.getRequestDispatcher("/WEB-INF/views/hide/for/admin/readQuestionAdmin.jsp");
			}else {
				rd = request.getRequestDispatcher("/");
			}
		}else {
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
