package fp.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fp.admin.models.service.AdminService;
import fp.member.model.vo.Member;
import fp.payment.models.vo.PaymentInfo;

/**
 * Servlet implementation class TradeInfoAdminServlet
 */
@WebServlet(name = "TradeInfoAdmin", urlPatterns = { "/tradeInfoAdmin" })
public class TradeInfoAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TradeInfoAdminServlet() {
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
				int paymentInfoPaymentNo = Integer.parseInt(request.getParameter("paymentInfoPaymentNo"));
				AdminService service = new AdminService();
				ArrayList<PaymentInfo> list = service.tradeInfoAdmin(paymentInfoPaymentNo);
				if(list == null ) {
					System.out.println("결제정보 없거나 뭔가 이상. 결제정보 어드민 서블릿 확인 필요");
				}
				request.setAttribute("list", list);
				rd= request.getRequestDispatcher("/WEB-INF/views/hide/for/admin/tradeDetailAdmin.jsp");
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
