package fp.mypage.controller;

import java.io.IOException;
import java.util.ArrayList;

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
import fp.recommend.model.vo.Recommend;
import fp.recommend.model.vo.RecommendData;

/**
 * Servlet implementation class MypageMainServlet
 */
@WebServlet(name = "MypageMain", urlPatterns = { "/mypageMain" })
public class MypageMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageMainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("member")==null) {
			request.setAttribute("msg", "로그인해주세요");
			request.setAttribute("loc", "/");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			rd.forward(request, response);
		}else {
			Member m = (Member)session.getAttribute("member");
			int memberNo = m.getMemberNo();
			PaymentService service = new PaymentService();
			ArrayList<Payment> list = service.selectPaymentRecentThree(memberNo);
			ArrayList<RecommendData> recommendDataList = service.selectRecommendDate(memberNo);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/mypage/main.jsp");
			request.setAttribute("paymentList", list);
			request.setAttribute("recommendDataList", recommendDataList);
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
