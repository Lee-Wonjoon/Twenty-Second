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

import fp.perfume.model.service.PerfumeService;
import fp.perfume.model.vo.PageData;
import fp.perfume.model.vo.Perfume;


/**
 * Servlet implementation class SearchAdminServlet
 */
@WebServlet(name = "SearchPerfume", urlPatterns = { "/searchPerfume" })
public class SearchPerfumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchPerfumeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 인코딩
		request.setCharacterEncoding("utf-8");
		// 2. 변수 저장
		int reqPage;
		try {
			reqPage = Integer.parseInt(request.getParameter("reqPage"));
		} catch (NumberFormatException e) {
			reqPage = 1;
		}
		
		String selected = request.getParameter("selected");
		String inputvalue = request.getParameter("inputvalue");
		
		PerfumeService service = new PerfumeService();
		PageData pd = service.selectSearch(reqPage, selected, inputvalue);

		ArrayList<Perfume> p = service.selectTop();
		// 4. view 처리
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/shop/shop_main.jsp");
		request.setAttribute("pd", pd);
		request.setAttribute("p", p);
		request.setAttribute("selected", selected);
		request.setAttribute("inputvalue", inputvalue);

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
