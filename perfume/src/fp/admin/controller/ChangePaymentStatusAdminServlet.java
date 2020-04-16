package fp.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fp.admin.models.service.AdminService;
import fp.payment.models.service.PaymentService;
import fp.payment.models.vo.PaymentInfo;

/**
 * Servlet implementation class ChangePaymentStatusAdminServlet
 */
@WebServlet(name = "ChangePaymentStatusAdmin", urlPatterns = { "/changePaymentStatusAdmin" })
public class ChangePaymentStatusAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePaymentStatusAdminServlet() {
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
		AdminService service = new AdminService();
		int result = service.changePaymentStatus(paymentNo,status);
		if(result>0) {
			ArrayList<PaymentInfo> list = service.tradeInfoAdmin(paymentNo);
			if(list != null) {
				String type;
				switch(status) {
				case "환불":
					type = "in";
					break;
				case "배송중":
					type = "out";
					break;
				default:
					type = "none";
					break;	
				}
				System.out.println("type : "+type);
				if(type.equals("in")||type.equals("out")) {
					int i=0;
					for(PaymentInfo p : list) {
						int result2 = service.updateStockAdmin(p.getPaymentInfoBasketAmount(), type, p.getPaymentInfoPerfumeNo());
						if(result2 !=0) {
							i++;
						}
					}
					if(i!= list.size()) {
						request.setAttribute("msg", "처리실패. i size");
					}else {
						request.setAttribute("msg", "처리완료.");						
					}
				}
			}else {
				request.setAttribute("msg", "처리실패. list eq");
			}
		}else {
			request.setAttribute("msg", "오류 발생.");
		}
		RequestDispatcher rd = request.getRequestDispatcher("/tradeAdmin");
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
