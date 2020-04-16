package fp.shipaddr.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.google.gson.Gson;

import fp.member.model.vo.Member;
import fp.shipaddr.model.service.ShipAddrService;
import fp.shipaddr.model.vo.ShipAddr;

/**
 * Servlet implementation class InsertShipAddrServlet
 */
@WebServlet(name = "InsertShipAddr", urlPatterns = { "/insertShipAddr" })
public class InsertShipAddrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertShipAddrServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Member m = (Member)session.getAttribute("member");
		int shipAddrMemberNo = m.getMemberNo();
		String msg = "배송지 등록이 완료되었습니다.";
		String shipAddrAddr = request.getParameter("addr");
		String shipAddrPhone = request.getParameter("phone");
		String shipAddrName = request.getParameter("name");
		System.out.println(shipAddrAddr.length());
		System.out.println(shipAddrPhone.length());
		System.out.println(shipAddrName.length());
		ShipAddr sa = new ShipAddr(0, shipAddrMemberNo, shipAddrAddr, shipAddrPhone, shipAddrName);
		ShipAddrService service = new ShipAddrService();
		int resultChk = service.insertAddr(sa);
		if(resultChk==0) {
			msg="배송지 등록이 실패했습니다. 다시 시도해주세요.";
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
