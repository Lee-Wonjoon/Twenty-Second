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
import fp.perfume.model.service.PerfumeService;
import fp.perfume.model.vo.Perfume;
import fp.recommend.model.vo.RecommendData;

/**
 * Servlet implementation class PaymentDirectServlet
 */
@WebServlet(name = "PaymentDirect", urlPatterns = { "/paymentDirect" })
public class PaymentDirectServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentDirectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession session = request.getSession(false);
      if(session.getAttribute("member") == null) {
         request.setAttribute("msg", "로그인해주세요");
         request.setAttribute("loc", "/");
         RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
         rd.forward(request, response);
      }else {
         Member m = (Member)session.getAttribute("member");
         int memberNo = m.getMemberNo();
         int perfumeNo = Integer.parseInt(request.getParameter("perfumeNo"));
         int totalCount = Integer.parseInt(request.getParameter("amount"));
         PerfumeService service = new PerfumeService();
         Perfume p = service.selectOne(perfumeNo);
         int totalPrice = p.getPerfumePrice()*totalCount;
         int shipPrice = 0;
         int shipTotalPrice = 0;
         if(totalPrice<50000) {
            shipPrice = 2500;
         }
         shipTotalPrice = shipPrice + totalPrice;
         BasketService bService = new BasketService();
         int result2 = service.checkPerfumeStock(perfumeNo);
         
         if(result2 >= totalCount) {
            int result = bService.insertBasket(memberNo,perfumeNo,totalCount,totalPrice);
            if(result > 0) {
               request.setAttribute("directCheck", "1");
               RequestDispatcher rd = request.getRequestDispatcher("/basketList");
               rd.forward(request, response);
            }else {
               request.setAttribute("msg", "구매 등록에 실패했습니다.");
               request.setAttribute("loc", "/viewPerfume?perfumeNo="+perfumeNo);
               RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
               rd.forward(request, response);
            }            
         } else {
            request.setAttribute("msg", "재고가 부족합니다.");
            request.setAttribute("loc", "/viewPerfume?perfumeNo="+perfumeNo);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
            rd.forward(request, response);
         }
                  
         //여기까지함 새로운 서블릿에 보내고 받는 것도 새로(장바구니관계없는것으로)
         
         
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