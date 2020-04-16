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
import fp.perfume.model.vo.Perfume;

/**
 * Servlet implementation class UpdatePerfumeServlet
 */
@WebServlet(name = "UpdatePerfume", urlPatterns = { "/updatePerfume" })
public class UpdatePerfumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePerfumeServlet() {
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
				response.setCharacterEncoding("utf-8");
				int perfumeNo = Integer.parseInt(request.getParameter("perfumeNo"));
				AdminService service =new AdminService();
				Perfume p = service.updatePerfumeAdmin(perfumeNo);
				if(p == null) {
					System.out.println("뭔가 이상함.");
				}
				request.setAttribute("perfume", p);
				rd = request.getRequestDispatcher("/WEB-INF/views/hide/for/admin/updatePerfume.jsp");
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
