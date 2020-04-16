package fp.payment.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fp.basket.model.service.BasketService;
import fp.basket.model.vo.BasketList;
import fp.member.model.vo.Member;
import fp.payment.models.vo.Payment;

/**
 * Servlet implementation class PaymentStartServlet
 */
@WebServlet(name = "PaymentStart", urlPatterns = { "/paymentStart" })
public class PaymentStartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentStartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int memberNo = 0;
		HttpSession session = request.getSession(false);
		if(session.getAttribute("member")!=null) {
			Member m = (Member)session.getAttribute("member");
			memberNo = m.getMemberNo();
		}
		String basketNoList =request.getParameter("basketNoList");
		StringTokenizer st = new StringTokenizer(basketNoList,",");
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(st.hasMoreElements()) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		BasketService service = new BasketService();
		ArrayList<BasketList> basketList = service.selectPart(memberNo,list);
		int totalPrice = 0;
		int totalCount = 0;
		int shipPrice = 0;
		int shipTotalPrice = 0;
		for(int i=0; i<basketList.size();i++) {
			totalCount += basketList.get(i).getB().getBasketAmount();
			totalPrice += basketList.get(i).getB().getBasketPrice();
		}
		if(totalPrice<50000) {
			shipPrice = 2500;
		}
		shipTotalPrice = shipPrice + totalPrice;
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/payment/paymentStart.jsp");
		request.setAttribute("basketNoList", basketNoList);
		request.setAttribute("basketList", basketList);
		request.setAttribute("totalPrice", totalPrice);
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("shipPrice", shipPrice);
		request.setAttribute("shipTotalPrice", shipTotalPrice);
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
