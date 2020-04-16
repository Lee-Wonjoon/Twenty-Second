package fp.mypage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fp.payment.models.service.PaymentService;

/**
 * Servlet implementation class ChangePaymentStatusServlet
 */
@WebServlet(name = "ChangePaymentStatus", urlPatterns = { "/changePaymentStatus" })
public class ChangePaymentStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePaymentStatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String status = request.getParameter("status");
		int paymentNo = Integer.parseInt(request.getParameter("paymentNo"));
		PaymentService service = new PaymentService();
		int result = service.changePaymentStatus(paymentNo,status);
		if(result>0) {
			request.setAttribute("msg", "처리되었습니다.");
		}else {
			request.setAttribute("msg", "오류가 발생했습니다. 계속해서 문제 발생시 1:1 문의로 문의 주시면 감사하겠습니다.");
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		request.setAttribute("loc", "/paymentList");
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
