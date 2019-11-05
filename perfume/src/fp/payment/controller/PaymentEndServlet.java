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
import fp.payment.models.service.PaymentService;
import fp.payment.models.vo.Payment;
import fp.payment.models.vo.PaymentInfo;

/**
 * Servlet implementation class PaymentEndServlet
 */
@WebServlet(name = "PaymentEnd", urlPatterns = { "/paymentEnd" })
public class PaymentEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//결제 성공시 결제 테이블에 insert
		//insert 성공시 결제정보테이블에 insert
		//insert 성공시 장바구니 삭제
		int memberNo = 0;
		request.setCharacterEncoding("UTF-8");
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
		String paymentMerchantUid = request.getParameter("merchantUid");
		String phone = request.getParameter("phone");
		String addr = request.getParameter("addr");
		int totalPrice = Integer.parseInt(request.getParameter("price"));
		String shipMsg = request.getParameter("shipMsg");
		String productName = request.getParameter("productName");
		String shipName = request.getParameter("shipName");
		String loc = request.getParameter("loc");
		BasketService bservice = new BasketService();
		ArrayList<BasketList> basketList = bservice.selectPart(memberNo,list);
		ArrayList<PaymentInfo> piList = new ArrayList<PaymentInfo>();
		for(int i=0; i<basketList.size();i++) {
			PaymentInfo pi = new PaymentInfo(0, 0, basketList.get(i).getB().getBasketPerfumeNo(), basketList.get(i).getPerfumePhotopath(), basketList.get(i).getPerfumeName(), basketList.get(i).getPerfumeVolume(), basketList.get(i).getB().getBasketAmount(), basketList.get(i).getB().getBasketPrice());
			piList.add(pi);
		}
		PaymentService service = new PaymentService();
		Payment p = new Payment(0, memberNo, productName, shipName, phone, addr, shipMsg, paymentMerchantUid, "배송준비중", totalPrice,null);
		int result = service.paymentLogic(memberNo,piList,p,list);
		if(result>0) {
			RequestDispatcher rd = request.getRequestDispatcher(loc);
			rd.forward(request, response);
//			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
//			request.setAttribute("loc", loc);
//			rd.forward(request, response);
		}else {
			System.out.println("memerNo : "+memberNo);
			System.out.println("basketNoList : "+basketNoList);
			System.out.println("paymentMerchantUid : "+paymentMerchantUid);
			System.out.println("phone : "+phone);
			System.out.println("addr : "+addr);
			System.out.println("totalPrice : "+totalPrice);
			System.out.println("shipMsg : "+shipMsg);
			System.out.println("productName : "+productName);
			System.out.println("shipName : "+shipName);
			System.out.println("loc : "+loc);
			
			
			String msg = "결제가 불완전하게 완료되었습니다. 즉시 환불 처리 진행하겠습니다. 불편을 드려 죄송합니다.";
			response.setCharacterEncoding("UTF-8");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", msg);
			request.setAttribute("loc", loc);
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
