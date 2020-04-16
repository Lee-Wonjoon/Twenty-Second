package fp.review.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import fp.review.model.service.ReviewService;
import fp.review.model.vo.Review;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class ReviewUpdateServlet
 */
@WebServlet(name = "ReviewUpdate", urlPatterns = { "/reviewUpdate" })
public class ReviewUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "[enctype]확인하세요");
			request.setAttribute("loc", "/");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			rd.forward(request, response);
			return;
		}
		String root = getServletContext().getRealPath("/");
		String saveDirectory = root+"upload/review";
		int maxSize = 10*1024*1024;
		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory,maxSize,"UTF-8",new DefaultFileRenamePolicy());
		int reviewNo = Integer.parseInt(mRequest.getParameter("reviewNo2"));
		String reviewWriter = mRequest.getParameter("reviewWriter2");
		String reviewContent = mRequest.getParameter("reviewContent2");
		String hashtag = mRequest.getParameter("hashtag2");
		String filename = mRequest.getOriginalFileName("filename2");
		String filepath = mRequest.getFilesystemName("filename2");
		if(filename == null && filepath==null) {	//기존 첨부파일이 있는 경우
				filename = mRequest.getParameter("oldFileName");
				filepath = mRequest.getParameter("oldFileName");
		}else {
			filename = mRequest.getOriginalFileName("filename2");
			filepath = mRequest.getFilesystemName("filename2");
		}
		Review r = new Review(reviewNo, reviewWriter, reviewContent, filename, filepath, 0, hashtag, null);
		//3.비지니스로직
		ReviewService service = new ReviewService();
		int result=service.updateReview(r);
		if(result>0) {
			request.setAttribute("msg", "리뷰를 수정하였습니다.");
		}else {
			request.setAttribute("msg", "리뷰 수정을 실패하였습니다.");
		}
		//4.뷰작성
		request.setAttribute("loc", "/reviewList");
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
