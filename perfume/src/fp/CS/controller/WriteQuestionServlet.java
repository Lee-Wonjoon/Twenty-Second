package fp.CS.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import fp.CS.models.service.CSService;
import fp.CS.models.vo.Question;
import fp.admin.models.service.AdminService;
import fp.member.model.vo.Member;
import fp.mypage.model.sevice.MypageService;

/**
 * Servlet implementation class WriteQuestionServlet
 */
@WebServlet(name = "WriteQuestion", urlPatterns = { "/writeQuestion" })
public class WriteQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("member");
		RequestDispatcher rd;
		
		if(m != null) {
			String root = getServletContext().getRealPath("/"); // 실제 서버의 절대경로를 가져오는 것임
			String saveDirectory = root+"upload/question"; // 임시경로
			int maxSize = 10*1024*1024;
			MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize,"UTF-8",new DefaultFileRenamePolicy());
			
			String questionTitle = mRequest.getParameter("questionTitle");
			String questionWriter = m.getMemberNickname();
			String questionContent = mRequest.getParameter("questionContent");
			String filename = mRequest.getOriginalFileName("filename");
			String filepath = mRequest.getFilesystemName("filename");
			Question q = new Question(0, questionTitle, questionWriter, questionContent, null, filename, filepath, 0, 0, null);
			
			CSService service = new CSService();
			int result = service.insertQuestionServlet(q);
			if(result == 0 ) {
				System.out.println("뭔가 이상함 확인좀요 : 문의작성(사용자)");
			}
			rd = request.getRequestDispatcher("/questionList");
		}else {
			request.setAttribute("msg", "로그인을 먼저 해주세요");
			rd = request.getRequestDispatcher("/views/member/login.jsp");
		}
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
