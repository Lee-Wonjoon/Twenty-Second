package fp.shipaddr.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fp.shipaddr.model.service.ShipAddrService;

/**
 * Servlet implementation class DeleteShipAddrServlet
 */
@WebServlet(name = "DeleteShipAddr", urlPatterns = { "/deleteShipAddr" })
public class DeleteShipAddrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteShipAddrServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int shipAddrNo = Integer.parseInt(request.getParameter("shipAddrNo"));
		ShipAddrService service = new ShipAddrService();
		int result = service.deleteOne(shipAddrNo);
		String msg = "";
		if(result>0) {
			msg = "삭제 완료";
		}else {
			msg = "삭제 실패";
		}
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(msg);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
