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
 * Servlet implementation class UpdatePerfumeFinishServlet
 */
@WebServlet(name = "UpdatePerfumeFinish", urlPatterns = { "/updatePerfumeFinish" })
public class UpdatePerfumeFinishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePerfumeFinishServlet() {
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
				String saveDirectory = root+"upload/photo"; // 임시경로
				int maxSize = 10*1024*1024;
				MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize,"UTF-8",new DefaultFileRenamePolicy());
				
				
				int perfumeNo = Integer.parseInt(mRequest.getParameter("perfumeNo"));
				String perfumeName = mRequest.getParameter("perfumeName");
				int perfumePrice = Integer.parseInt(mRequest.getParameter("perfumePrice"));
				String perfumePhotoname = mRequest.getOriginalFileName("perfumePhotoname");
				String perfumePhotopath = mRequest.getFilesystemName("perfumePhotoname");
				String perfumeDetail = mRequest.getParameter("perfumeDetail");
				
				
				String oldFilename = mRequest.getParameter("oldFilename");
				String oldFilepath = mRequest.getParameter("oldFilepath");
				String status = mRequest.getParameter("status"); //기본 파일 삭제 여부
				AdminService service = new AdminService();
				int result=0;
				if(oldFilename != null && status.equals("change")) {//기존 첨부파일이 있는 경우
					System.out.println("이미지 파일 삭제됨");
					//기존 파일 삭제
					File delFile = new File(saveDirectory+"/"+oldFilepath);
					delFile.delete();
					//삭제 확인을 위한 코드
					//System.out.println(delFile.delete()?"성공":"실패");
					result = service.updatePerfumeFinishAdmin(perfumeNo, perfumeName, perfumePrice, perfumePhotoname, perfumePhotopath, perfumeDetail);
				}else {
					result = service.updatePerfumeFinishAdmin(perfumeNo, perfumeName, perfumePrice, oldFilename, oldFilepath, perfumeDetail);
				}
				
				if(result == 0 ) {
					System.out.println("뭔가 이상함 확인좀요 : 업뎃향수");
				}
				rd = request.getRequestDispatcher("/listAdmin");
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
