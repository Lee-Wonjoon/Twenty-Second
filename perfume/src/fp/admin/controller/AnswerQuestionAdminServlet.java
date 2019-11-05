package fp.admin.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import fp.admin.models.service.AdminService;
import fp.member.model.vo.Member;

/**
 * Servlet implementation class AnswerQuestionAdminServlet
 */
@WebServlet(name = "AnswerQuestionAdmin", urlPatterns = { "/answerQuestionAdmin" })
public class AnswerQuestionAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnswerQuestionAdminServlet() {
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
			if(m.getMemberId().equals("admin@")) {
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				String root = getServletContext().getRealPath("/"); // 실제 서버의 절대경로를 가져오는 것임
				String saveDirectory = root+"upload/answer"; // 임시경로
				int maxSize = 10*1024*1024;
				MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize,"UTF-8",new DefaultFileRenamePolicy());
				
				int questionNo = Integer.parseInt(mRequest.getParameter("questionNo"));
				String questionContent = mRequest.getParameter("questionContent");
				String filename = mRequest.getOriginalFileName("filename");
				String filepath = mRequest.getFilesystemName("filename");
				/*파일 추가해야함*/
				AdminService service = new AdminService();
				String to = "처리완료";
				int result = service.readQuestionAdmin(questionNo, to);
				if(result == 0) {
					System.out.println("확인 처리 실패");
				}
				result = service.answerQuestionAdmin(questionNo, questionContent, filename, filepath);
				if(result==0) {
					System.out.println("뭔가 이상함. 질문 답변 확인하셈");
				}
				rd = request.getRequestDispatcher("/readQuestionAdmin?questionNo="+questionNo+"&questionStatus="+to);
			}else {
				rd = request.getRequestDispatcher("/");
			}
		}else {
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
