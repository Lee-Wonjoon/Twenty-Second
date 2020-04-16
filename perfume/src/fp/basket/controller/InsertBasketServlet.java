package fp.basket.controller;

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
import fp.perfume.model.service.PerfumeService;

/**
 * Servlet implementation class InsertBasketServlet
 */
@WebServlet(name = "InsertBasket", urlPatterns = { "/insertBasket" })
public class InsertBasketServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBasketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      int perfumeNo = Integer.parseInt(request.getParameter("perfumeNo"));
      int perfumePrice = Integer.parseInt(request.getParameter("perfumePrice"));
      HttpSession session = request.getSession(false);
      if(session.getAttribute("member")==null) {
         request.setAttribute("msg", "로그인해주세요");
         request.setAttribute("loc", "/viewPerfume?perfumeNo="+perfumeNo);
         RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
         rd.forward(request, response);
      }else {
         int perfumeAmount = Integer.parseInt(request.getParameter("perfumeAmount"));
         int totalPrice = perfumeAmount*perfumePrice;
         System.out.println(totalPrice);
         Member m = (Member)session.getAttribute("member");
         int memberNo = m.getMemberNo();
         if(request.getParameter("perfumeAmount").equals("0")) {
            request.setAttribute("msg", "수량을 선택해주세요.");
            request.setAttribute("loc", "/viewPerfume?perfumeNo="+perfumeNo);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
            rd.forward(request, response);
         }else {
            BasketService service = new BasketService();
            PerfumeService service2 = new PerfumeService();            
            int result2 = service2.checkPerfumeStock(perfumeNo);
            if (result2 >= perfumeAmount) {
               int result = service.insertBasket(memberNo,perfumeNo,perfumeAmount,totalPrice);
               if(result > 0) {
                  request.setAttribute("msg", "장바구니에 등록되었습니다.");
                  request.setAttribute("loc", "/viewPerfume?perfumeNo="+perfumeNo);
               }else {
                  request.setAttribute("msg", "장바구니 등록에 실패했습니다.");
                  request.setAttribute("loc", "/viewPerfume?perfumeNo="+perfumeNo);
               }            
            } else {
               request.setAttribute("msg", "재고가 부족합니다.");
               request.setAttribute("loc", "/viewPerfume?perfumeNo="+perfumeNo);
            }
            
            
            
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
            rd.forward(request, response);
         }
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