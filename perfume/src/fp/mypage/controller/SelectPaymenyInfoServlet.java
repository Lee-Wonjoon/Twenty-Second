package fp.mypage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.gson.Gson;

import fp.basket.model.vo.BasketList;
import fp.payment.models.service.PaymentService;
import fp.payment.models.vo.PaymentInfo;

/**
 * Servlet implementation class SelectPaymenyInfoServlet
 */
@WebServlet(name = "SelectPaymenyInfo", urlPatterns = { "/selectPaymenyInfo" })
public class SelectPaymenyInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectPaymenyInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int paymentNo = Integer.parseInt(request.getParameter("paymentNo"));
		String paymentProductName = request.getParameter("paymentProductName");
		PaymentService service = new PaymentService();
		ArrayList<PaymentInfo> list = service.selectPaymentInfo(paymentNo);
		System.out.println(list.size());
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/mypage/selectedPaymentInfoView.jsp");
		request.setAttribute("paymentInfoList", list);
		request.setAttribute("paymentProductName", paymentProductName);
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
