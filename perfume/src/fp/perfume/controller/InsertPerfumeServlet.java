package fp.perfume.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import fp.perfume.model.service.PerfumeService;
import fp.perfume.model.vo.Perfume;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class InsertPhotoServlet
 */
@WebServlet(name = "InsertPerfume", urlPatterns = { "/insertPerfume" })
public class InsertPerfumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertPerfumeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "[enctype] 확인하세요.");
			request.setAttribute("loc", "/");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			rd.forward(request, response);
			return;
		}
		String root = getServletContext().getRealPath("/");
		String saveDirectory = root + "upload/photo";
		int maxSize = 10*1024*1024;
		// 3) request -> MultipartRequest
		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "UTF-8", new DefaultFileRenamePolicy());		
		String perfumeName = mRequest.getParameter("perfumeName");
		String perfumeBrand = mRequest.getParameter("perfumeBrand");
		int perfumeVolume = Integer.parseInt(mRequest.getParameter("perfumeVolume"));
		String perfumeDensity = mRequest.getParameter("perfumeDensity");
		String perfumeTop = mRequest.getParameter("perfumeTop");
		String perfumeMiddle = mRequest.getParameter("perfumeMiddle");
		String perfumeBase = mRequest.getParameter("perfumeBase");
		String perfumeGender = mRequest.getParameter("perfumeGender");
		int perfumePrice = Integer.parseInt(mRequest.getParameter("perfumePrice"));
		String perfumePhotoname = mRequest.getOriginalFileName("perfumePhotoname");
		String perfumePhotopath = mRequest.getFilesystemName("perfumePhotoname");
		String perfumeDetail = mRequest.getParameter("perfumeDetail");
		
		Perfume p = new Perfume(0, 0, perfumeName, perfumeBrand, perfumeVolume, perfumeDensity, perfumeTop, perfumeMiddle, perfumeBase, 0, perfumeGender, perfumePrice, perfumePhotoname, perfumePhotopath, perfumeDetail);
		
		PerfumeService service = new PerfumeService();
		int result = service.insertPerfume(p);
		if (result > 0) {
			request.setAttribute("msg", "향수 등록 성공");
		} else {
			request.setAttribute("msg", "향수 등록 실패");
		}
		request.setAttribute("loc", "/perfumeList");
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
