package fp.admin.controller;

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
import fp.notice.models.vo.Notice;

/**
 * Servlet implementation class ModifyNoticeAdminSubmitServlet
 */
@WebServlet(name = "ModifyNoticeAdminSubmit", urlPatterns = { "/modifyNoticeAdminSubmit" })
public class ModifyNoticeAdminSubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyNoticeAdminSubmitServlet() {
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
				String saveDirectory = root+"upload/notice"; // 임시경로
				int maxSize = 10*1024*1024;
				MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize,"UTF-8",new DefaultFileRenamePolicy());
				
				int noticeNo = Integer.parseInt(mRequest.getParameter("noticeNo"));
				String noticeTitle = mRequest.getParameter("noticeTitle");
				String noticeContent = mRequest.getParameter("noticeContent");
				String filename = mRequest.getOriginalFileName("filename");
				String filepath = mRequest.getFilesystemName("filename");
				Notice n= new Notice(noticeNo, null, noticeTitle, noticeContent, null, filename, filepath);
				AdminService service = new AdminService();
				int result = service.updateNoticeAdmin(n);
				if(result==0) {
					System.out.println("관리자 공지 수정 실패");
				}
				rd = request.getRequestDispatcher("/noticeAdmin");
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
