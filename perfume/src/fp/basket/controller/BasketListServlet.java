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
import fp.basket.model.vo.Basket;
import fp.basket.model.vo.BasketList;
import fp.member.model.vo.Member;

/**
 * Servlet implementation class BasketListServlet
 */
@WebServlet(name = "BasketList", urlPatterns = { "/basketList" })
public class BasketListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BasketListServlet() {
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
			String directCheck = (String)request.getAttribute("directCheck");
			System.out.println(directCheck);
			BasketService service = new BasketService();
			ArrayList<BasketList> list = service.selectAll(memberNo);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/basket/basketList.jsp");
			request.setAttribute("directCheck", directCheck);
			request.setAttribute("basketList", list);
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
