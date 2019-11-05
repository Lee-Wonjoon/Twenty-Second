package fp.CS.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fp.CS.models.service.CSService;
import fp.CS.models.vo.Question;
import fp.member.model.vo.Member;

/**
 * Servlet implementation class PersonalCsServlet
 */
@WebServlet(name = "PersonalCs", urlPatterns = { "/personalCs" })
public class PersonalCsServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonalCsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      HttpSession session = request.getSession();
      Member m = (Member)session.getAttribute("member");
      ArrayList<Question> list = new ArrayList<Question>();
      if(m!= null) {
         CSService service = new CSService();
         list = service.questionList(m.getMemberNickname());
         if(list != null) {
            int size = list.size();
            request.setAttribute("size", size);
         }
      }
      request.setAttribute("list", list);
      RequestDispatcher rd = request.getRequestDispatcher("/views/personalCs.jsp");
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