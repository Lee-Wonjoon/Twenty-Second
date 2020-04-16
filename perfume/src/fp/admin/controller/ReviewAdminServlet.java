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
import fp.admin.models.vo.PageData;
import fp.member.model.vo.Member;

/**
 * Servlet implementation class ReviewAdminServlet
 */
@WebServlet(name = "ReviewAdmin", urlPatterns = { "/reviewAdmin" })
public class ReviewAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewAdminServlet() {
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
				AdminService service = new AdminService();
				int reqPage;
				try {
					reqPage = Integer.parseInt(request.getParameter("reqPage"));
				} catch(NumberFormatException e) {
					reqPage =1;
				}
				PageData pd = service.getReviewAdmin(reqPage);
				if(pd==null) {
					System.out.println("뭔가 이상함. 확인 바람 : 리뷰 리스트 어드민 서블릿");
				}
				request.setAttribute("pd", pd);
				rd = request.getRequestDispatcher("/WEB-INF/views/hide/for/admin/reviewAdmin.jsp");
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
