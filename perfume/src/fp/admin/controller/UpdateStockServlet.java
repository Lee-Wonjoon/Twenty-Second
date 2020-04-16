package fp.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import fp.admin.models.service.AdminService;
import fp.admin.models.vo.PageData;
import fp.member.model.vo.Member;

/**
 * Servlet implementation class UpdateStockServlet
 */
@WebServlet(name = "UpdateStock", urlPatterns = { "/updateStock" })
public class UpdateStockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStockServlet() {
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
				int amount = Integer.parseInt(request.getParameter("amount"));
				/*in, out*/
				String type = request.getParameter("type");
				int perfumeNo = Integer.parseInt(request.getParameter("perfumeNo"));
				AdminService service = new AdminService();
				int result = service.updateStockAdmin(amount,type, perfumeNo);
				if(result!=0) {
					amount = service.getStockAmount(perfumeNo);
					if(amount != -1) {
						response.setContentType("application/json");
						response.setCharacterEncoding("UTF-8");
						new Gson().toJson(amount,response.getWriter());
					}else {
						rd = request.getRequestDispatcher("/WEB-INF/views/hide/for/admin/listAdmin.jsp");
						rd.forward(request, response);				
					}
				}else {
					rd = request.getRequestDispatcher("/WEB-INF/views/hide/for/admin/listAdmin.jsp");
					rd.forward(request, response);
				}
			}else {
				rd = request.getRequestDispatcher("/");
				rd.forward(request, response);
			}
		}else {
			rd = request.getRequestDispatcher("/views/member/login.jsp");
			rd.forward(request, response);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
