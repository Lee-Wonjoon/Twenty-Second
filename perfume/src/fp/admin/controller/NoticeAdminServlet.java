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
import fp.notice.models.service.NoticeService;

/**
 * Servlet implementation class NoticeAdminServlet
 */
@WebServlet(name = "NoticeAdmin", urlPatterns = { "/noticeAdmin" })
public class NoticeAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeAdminServlet() {
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
				request.setCharacterEncoding("UTF-8");
				AdminService service = new AdminService();
				
				int reqPage;
				try {
					reqPage = Integer.parseInt(request.getParameter("reqPage"));
				} catch(NumberFormatException e) {
					reqPage =1;
				}
				
				PageData pd = service.noticeListAdmin(reqPage);
				request.setAttribute("pd",pd);
				rd = request.getRequestDispatcher("/WEB-INF/views/hide/for/admin/noticeAdmin.jsp");
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
