package fp.perfume.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fp.member.model.vo.Member;
import fp.perfume.model.service.PerfumeService;
import fp.perfume.model.vo.Perfume;
import fp.perfumerecommend.model.service.PerfumeRecommendService;
import fp.perfumerecommend.model.vo.PerfumeRecommend;
import fp.perfumereview.model.service.PerfumeReviewService;
import fp.perfumereview.model.vo.PerfumeReview;

/**
 * Servlet implementation class ViewPerfumeServlet
 */
@WebServlet(name = "ViewPerfume", urlPatterns = { "/viewPerfume" })
public class ViewPerfumeServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewPerfumeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // 1. 인코딩
      request.setCharacterEncoding("utf-8");
      HttpSession session = request.getSession(false);
      int memberNo = 0;
      if(session.getAttribute("member")!=null) {
         Member m = (Member)session.getAttribute("member");
         memberNo = m.getMemberNo();
      }
      int perfumeNo = Integer.parseInt(request.getParameter("perfumeNo"));
      PerfumeService service = new PerfumeService();
      Perfume p = service.selectOne(perfumeNo);
      PerfumeRecommendService service2 = new PerfumeRecommendService();
      PerfumeRecommend pr2 = service2.checkRecommend(memberNo, perfumeNo);
      PerfumeReviewService service3 = new PerfumeReviewService();
      ArrayList<PerfumeReview> prlist = service3.onePerfumeReview(perfumeNo);
      if (p != null) {
         request.setAttribute("perfume", p);
         request.setAttribute("pr", pr2);
         request.setAttribute("prlist", prlist);
         RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/shop/viewPerfume.jsp");
         rd.forward(request, response);
       
      } else {
         request.setAttribute("msg", "해당 게시물이 없습니다.");
         request.setAttribute("loc", "/perfumeList");
         RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
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