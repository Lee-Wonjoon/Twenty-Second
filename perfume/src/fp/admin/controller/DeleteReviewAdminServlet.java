package fp.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fp.admin.models.service.AdminService;
import fp.member.model.vo.Member;

/**
 * Servlet implementation class DeleteReviewAdminServlet
 */
@WebServlet(name = "DeleteReviewAdmin", urlPatterns = { "/deleteReviewAdmin" })
public class DeleteReviewAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteReviewAdminServlet() {
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
				int reviewNo = Integer.parseInt(request.getParameter("perfumeReviewNo"));
				AdminService service = new AdminService();
				int result = service.deleteReviewAdmin(reviewNo);
				if(result ==0) {
					System.out.println("뭔가 이상함. 확인 요청  : 리뷰 삭제 어드민");
				}
				rd= request.getRequestDispatcher("/reviewAdmin");
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
