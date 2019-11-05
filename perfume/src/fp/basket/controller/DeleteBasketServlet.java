package fp.basket.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fp.basket.model.service.BasketService;
import fp.basket.model.vo.BasketList;

/**
 * Servlet implementation class DeleteBasketServlet
 */
@WebServlet(name = "DeleteBasket", urlPatterns = { "/deleteBasket" })
public class DeleteBasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBasketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String delBasket =request.getParameter("delBasket");
		StringTokenizer st = new StringTokenizer(delBasket,",");
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(st.hasMoreElements()) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		BasketService service = new BasketService();
		int result = service.deleteBasket(list);
		if(result>0) {
			request.setAttribute("msg", "선택한 상품이 삭제되었습니다.");
		}else {
			request.setAttribute("msg", "삭제가 실패하였습니다. 반복적인 문제 발생 시 1:1문의로 알려주세요. 확인 후 조치하겠습니다.");
		}
		request.setAttribute("loc", "/basketList");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
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
