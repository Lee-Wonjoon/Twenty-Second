package fp.perfume.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fp.perfume.model.service.PerfumeService;
import fp.perfume.model.vo.PageData;
import fp.perfume.model.vo.Perfume;

/**
 * Servlet implementation class PerfumeListServlet
 */
@WebServlet(name = "PerfumeListUni2", urlPatterns = { "/perfumeListUni2" })
public class PerfumeListUni2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PerfumeListUni2Servlet() {
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
		String gender = "uni";
		try {
			reqPage = Integer.parseInt(request.getParameter("reqPage"));
		} catch (NumberFormatException e) {
			reqPage = 1;
		}
		// 3. 비지니스 로직
		PerfumeService service = new PerfumeService();
		PageData pd = service.selectListUni2(reqPage);
		ArrayList<Perfume> p = service.selectTopGender(gender);
		// 4. view 처리
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/shop/shop_main_uni.jsp");
		request.setAttribute("pd", pd);
		request.setAttribute("p", p);

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
