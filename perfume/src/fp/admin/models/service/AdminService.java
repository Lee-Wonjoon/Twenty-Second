package fp.admin.models.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

import fp.CS.models.vo.Question;
import fp.admin.models.dao.AdminDao;
import fp.admin.models.vo.PageData;
import fp.common.JDBCTemplate;
import fp.member.model.vo.Member;
import fp.notice.models.vo.Notice;
import fp.payment.models.dao.PaymentDao;
import fp.payment.models.vo.Payment;
import fp.payment.models.vo.PaymentInfo;
import fp.perfume.model.vo.Perfume;
import fp.review.model.vo.Review;

public class AdminService {

	public PageData memberList(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		AdminDao dao = new AdminDao();
		int numPerPage = 10;
		int totalCount = dao.totalCountMember(conn);
		int totalPage=(totalCount%numPerPage==0)?(totalPage = totalCount/numPerPage):(totalPage = totalCount/numPerPage)+1; //총 페이지

		int start = (reqPage-1)*numPerPage+1;
		int end = reqPage*numPerPage; 
		ArrayList<Object> list = dao.selectListMember(conn,start,end);
/*		for(Notice n : list) {
			System.out.println(n);
		}*/
		String pageNavi = "";
		int pageNaviSize= 5;
		int pageNo;
		if(reqPage<3) {
			pageNo = 1;
		}else if(reqPage+2>totalPage){
			if(totalPage-4 > 0) {
				pageNo= totalPage-4;
			}else {
				pageNo=1;
			}
		}else {
			pageNo = reqPage-2;
		}

		if(pageNo!=1) {
			pageNavi += "<a class='btn' style='color:#888888;' href='/memberAdmin?reqPage="+(pageNo-1)+"'>이전</a>";
		}
		int i=1;

		while(!(i++>pageNaviSize || pageNo>totalPage)) {
			if(reqPage==pageNo) {
				pageNavi +="<span class ='selectPage' style='color:black;'>"+pageNo+"</span>";
			}else {
				pageNavi +="<a class ='btn' style='color:#888888;' href='/memberAdmin?reqPage="+pageNo+"'>"+pageNo+"</a>";
			}
			pageNo++;
		}
		if(pageNo<= totalPage) {
			pageNavi += "<a class='btn' style='color:#888888;' href='/memberAdmin?reqPage="+(pageNo)+"'>다음</a>";
		}
		/*for (Object m : list) {
			Member member = (Member)m;
			System.out.println(member.getMemberNo()+"\t" + member.getMemberNickname());
		}*/
		PageData pd = new PageData(list, pageNavi);
		
		JDBCTemplate.close(conn);
		return pd;
	}

	public int deletePerfume(int perfumeNo) {
		Connection conn = JDBCTemplate.getConnection();
		AdminDao dao = new AdminDao();
		int result = dao.deletePerfume(conn, perfumeNo);
		if(result != 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public PageData perfumeListAdmin(int reqPage ) {
		Connection conn = JDBCTemplate.getConnection();
		AdminDao dao = new AdminDao();
		int numPerPage = 10;
		int totalCount = dao.totalCountPerfume(conn);
		int totalPage=(totalCount%numPerPage==0)?(totalPage = totalCount/numPerPage):(totalPage = totalCount/numPerPage)+1; //총 페이지

		int start = (reqPage-1)*numPerPage+1;
		int end = reqPage*numPerPage; 
		ArrayList<Object> list = dao.selectListPerfume(conn,start,end);
/*		for(Notice n : list) {
			System.out.println(n);
		}*/
		String pageNavi = "";
		int pageNaviSize= 5;
		int pageNo;
		if(reqPage<3) {
			pageNo = 1;
		}else if(reqPage+2>totalPage){
			if(totalPage-4 > 0) {
				pageNo= totalPage-4;
			}else {
				pageNo=1;
			}
		}else {
			pageNo = reqPage-2;
		}

		if(pageNo!=1) {
			pageNavi += "<a class='btn' style='color:#888888;' href='/listAdmin?reqPage="+(pageNo-1)+"'>이전</a>";
		}
		int i=1;

		while(!(i++>pageNaviSize || pageNo>totalPage)) {
			if(reqPage==pageNo) {
				pageNavi +="<span class ='selectPage' style='color:black;'>"+pageNo+"</span>";
			}else {
				pageNavi +="<a class ='btn' style='color:#888888;' href='/listAdmin?reqPage="+pageNo+"'>"+pageNo+"</a>";
			}
			pageNo++;
		}
		if(pageNo<= totalPage) {
			pageNavi += "<a class='btn' style='color:#888888;' href='/listAdmin?reqPage="+(pageNo)+"'>다음</a>";
		}
		PageData pd = new PageData(list, pageNavi);
		
		JDBCTemplate.close(conn);
		return pd;
		
	}

	public Perfume updatePerfumeAdmin(int perfumeNo) {
		Connection conn = JDBCTemplate.getConnection();
		AdminDao dao = new AdminDao();
		Perfume p = dao.getPerfume(conn, perfumeNo);
		JDBCTemplate.close(conn);
		return p;
	}

	public int updatePerfumeFinishAdmin(int perfumeNo, String perfumeName, int perfumePrice, String perfumePhotoname,
			String perfumePhotopath, String perfumeDetail) {
		Connection conn = JDBCTemplate.getConnection();
		AdminDao dao = new AdminDao();
		int result = dao.updatePerfumeFinishAdmin(conn, perfumeNo, perfumeName, perfumePrice, perfumePhotoname, perfumePhotopath, perfumeDetail);
		if(result != 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int validMemberAdmin(int memberNo, String memberValid) {
		Connection conn = JDBCTemplate.getConnection();
		AdminDao dao = new AdminDao();
		int result = dao.validMemberAdmin(conn, memberNo, memberValid);
		JDBCTemplate.close(conn);
		return result;
	}

	public PageData getReviewAdmin(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		AdminDao dao = new AdminDao();
		int numPerPage = 10;
		int totalCount = dao.totalCountReview(conn);
		int totalPage=(totalCount%numPerPage==0)?(totalPage = totalCount/numPerPage):(totalPage = totalCount/numPerPage)+1; //총 페이지

		int start = (reqPage-1)*numPerPage+1;
		int end = reqPage*numPerPage; 
		ArrayList<Object> list = dao.selectListReview(conn,start,end);
/*		for(Notice n : list) {
			System.out.println(n);
		}*/
		String pageNavi = "";
		int pageNaviSize= 5;
		int pageNo;
		if(reqPage<3) {
			pageNo = 1;
		}else if(reqPage+2>totalPage){
			if(totalPage-4 > 0) {
				pageNo= totalPage-4;
			}else {
				pageNo=1;
			}
		}else {
			pageNo = reqPage-2;
		}

		if(pageNo!=1) {
			pageNavi += "<a class='btn' style='color:#888888;' href='/reviewAdmin?reqPage="+(pageNo-1)+"'>이전</a>";
		}
		int i=1;

		while(!(i++>pageNaviSize || pageNo>totalPage)) {
			if(reqPage==pageNo) {
				pageNavi +="<span class ='selectPage' style='color:black;'>"+pageNo+"</span>";
			}else {
				pageNavi +="<a class ='btn' style='color:#888888;' href='/reviewAdmin?reqPage="+pageNo+"'>"+pageNo+"</a>";
			}
			pageNo++;
		}
		if(pageNo<= totalPage) {
			pageNavi += "<a class='btn' style='color:#888888;' href='/reviewAdmin?reqPage="+(pageNo)+"'>다음</a>";
		}
		PageData pd = new PageData(list, pageNavi);
		
		JDBCTemplate.close(conn);
		return pd;
	}

	public int deleteReviewAdmin(int reviewNo) {
		Connection conn = JDBCTemplate.getConnection();
		AdminDao dao = new AdminDao();
		int result = dao.deleteReviewAdmin(conn, reviewNo);
		if(result!=0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public PageData questionListAdmin(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		AdminDao dao = new AdminDao();
		int numPerPage = 10;
		int totalCount = dao.totalCountQuestion(conn);
		int totalPage=(totalCount%numPerPage==0)?(totalPage = totalCount/numPerPage):(totalPage = totalCount/numPerPage)+1; //총 페이지

		int start = (reqPage-1)*numPerPage+1;
		int end = reqPage*numPerPage; 
		ArrayList<Object> list = dao.selectListQuestion(conn,start,end);
/*		for(Notice n : list) {
			System.out.println(n);
		}*/
		String pageNavi = "";
		int pageNaviSize= 5;
		int pageNo;
		if(reqPage<3) {
			pageNo = 1;
		}else if(reqPage+2>totalPage){
			if(totalPage-4 > 0) {
				pageNo= totalPage-4;
			}else {
				pageNo=1;
			}
		}else {
			pageNo = reqPage-2;
		}

		if(pageNo!=1) {
			pageNavi += "<a class='btn' style='color:#888888;' href='/questionAdmin?reqPage="+(pageNo-1)+"'>이전</a>";
		}
		int i=1;

		while(!(i++>pageNaviSize || pageNo>totalPage)) {
			if(reqPage==pageNo) {
				pageNavi +="<span class ='selectPage' style='color:black;'>"+pageNo+"</span>";
			}else {
				pageNavi +="<a class ='btn' style='color:#888888;' href='/questionAdmin?reqPage="+pageNo+"'>"+pageNo+"</a>";
			}
			pageNo++;
		}
		if(pageNo<= totalPage) {
			pageNavi += "<a class='btn' style='color:#888888;' href='/questionAdmin?reqPage="+(pageNo)+"'>다음</a>";
		}
		/*for (Object m : list) {
			Question member = (Question)m;
			System.out.println(member.getQuestionNo()+"\t" + member.getQuestionWriter());
		}*/
		PageData pd = new PageData(list, pageNavi);
		
		JDBCTemplate.close(conn);
		return pd;
	}

	public int readQuestionAdmin(int questionNo, String to) {
		Connection conn = JDBCTemplate.getConnection();
		AdminDao dao = new AdminDao();
		int result = dao.readQuestionAdmin(conn, questionNo, to);
		if(result!=0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public Question getQuestion(int questionNo) {
		Connection conn = JDBCTemplate.getConnection();
		AdminDao dao = new AdminDao();
		Question q = dao.getQuestion(conn, questionNo);
		JDBCTemplate.close(conn);
		return q;
	}

	public int answerQuestionAdmin(int questionNo, String questionContent, String filename, String filepath) {
		Connection conn = JDBCTemplate.getConnection();
		AdminDao dao = new AdminDao();
		int result = dao.answerQuestionAdmin(conn, questionNo, questionContent, filename, filepath);
		if(result!=0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public Question getQuestionAnswer(int questionNo) {
		Connection conn = JDBCTemplate.getConnection();
		AdminDao dao = new AdminDao();
		Question q = dao.getQuestionAnswer(conn, questionNo);
		JDBCTemplate.close(conn);
		return q;
	}

	public PageData noticeListAdmin(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		AdminDao dao = new AdminDao();
		int numPerPage = 10;
		int totalCount = dao.totalCountNotice(conn);
		int totalPage=(totalCount%numPerPage==0)?(totalPage = totalCount/numPerPage):(totalPage = totalCount/numPerPage)+1; //총 페이지

		int start = (reqPage-1)*numPerPage+1;
		int end = reqPage*numPerPage; 
		ArrayList<Object> list = dao.selectListNotice(conn,start,end);
/*		for(Notice n : list) {
			System.out.println(n);
		}*/
		String pageNavi = "";
		int pageNaviSize= 5;
		int pageNo;
		if(reqPage<3) {
			pageNo = 1;
		}else if(reqPage+2>totalPage){
			if(totalPage-4 > 0) {
				pageNo= totalPage-4;
			}else {
				pageNo=1;
			}
		}else {
			pageNo = reqPage-2;
		}

		if(pageNo!=1) {
			pageNavi += "<a class='btn' style='color:#888888;' href='/noticeAdmin?reqPage="+(pageNo-1)+"'>이전</a>";
		}
		int i=1;

		while(!(i++>pageNaviSize || pageNo>totalPage)) {
			if(reqPage==pageNo) {
				pageNavi +="<span class ='selectPage' style='color:black;'>"+pageNo+"</span>";
			}else {
				pageNavi +="<a class ='btn' style='color:#888888;' href='/noticeAdmin?reqPage="+pageNo+"'>"+pageNo+"</a>";
			}
			pageNo++;
		}
		if(pageNo<= totalPage) {
			pageNavi += "<a class='btn' style='color:#888888;' href='/noticeAdmin?reqPage="+(pageNo)+"'>다음</a>";
		}
		/*for (Object m : list) {
			Notice member = (Notice)m;
			System.out.println(member.getNoticeNo()+"\t" + member.getNoticeWriter());
		}*/
		PageData pd = new PageData(list, pageNavi);
		
		JDBCTemplate.close(conn);
		return pd;
	}

	public int deleteNoticeAdmin(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		AdminDao dao = new AdminDao();
		int result = dao.deleteNoticeAdmin(conn, noticeNo);
		if(result !=0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public Notice getNoticeAdmin(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		AdminDao dao = new AdminDao();
		Notice n = dao.getNoticeAdmin(conn, noticeNo);
		JDBCTemplate.close(conn);
		return n;
	}

	public int updateNoticeAdmin(Notice n) {
		Connection conn = JDBCTemplate.getConnection();
		AdminDao dao = new AdminDao();
		int result = dao.updateNoticeAdmin(conn, n);
		if(result !=0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public PageData getTradeListAdmin(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		AdminDao dao = new AdminDao();
		int numPerPage = 10;
		int totalCount = dao.totalCountTrade(conn);
		int totalPage=(totalCount%numPerPage==0)?(totalPage = totalCount/numPerPage):(totalPage = totalCount/numPerPage)+1; //총 페이지

		int start = (reqPage-1)*numPerPage+1;
		int end = reqPage*numPerPage; 
		ArrayList<Object> list = dao.selectListTrade(conn,start,end);
/*		for(Notice n : list) {
			System.out.println(n);
		}*/
		String pageNavi = "";
		int pageNaviSize= 5;
		int pageNo;
		if(reqPage<3) {
			pageNo = 1;
		}else if(reqPage+2>totalPage){
			if(totalPage-4 > 0) {
				pageNo= totalPage-4;
			}else {
				pageNo=1;
			}
		}else {
			pageNo = reqPage-2;
		}

		if(pageNo!=1) {
			pageNavi += "<a class='btn' style='color:#888888;' href='/tradeAdmin?reqPage="+(pageNo-1)+"'>이전</a>";
		}
		int i=1;

		while(!(i++>pageNaviSize || pageNo>totalPage)) {
			if(reqPage==pageNo) {
				pageNavi +="<span class ='selectPage' style='color:black;'>"+pageNo+"</span>";
			}else {
				pageNavi +="<a class ='btn' style='color:#888888;' href='/tradeAdmin?reqPage="+pageNo+"'>"+pageNo+"</a>";
			}
			pageNo++;
		}
		if(pageNo<= totalPage) {
			pageNavi += "<a class='btn' style='color:#888888;' href='/tradeAdmin?reqPage="+(pageNo)+"'>다음</a>";
		}
		/*for (Object m : list) {
			Payment member = (Payment)m;
			System.out.println(member.getPaymentNo()+"\t" + member.getPaymentMemberNo());
		}*/
		PageData pd = new PageData(list, pageNavi);
		
		JDBCTemplate.close(conn);
		return pd;
	}

	public int insertNoticeSubmit(Notice n) {
		Connection conn = JDBCTemplate.getConnection();
		AdminDao dao = new AdminDao();
		int result = dao.insertNoticeAdmin(conn, n);
		if(result !=0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public PageData getListAdmin(int reqPage, String table, String area, String value, String location) {
		Connection conn = JDBCTemplate.getConnection();
		AdminDao dao = new AdminDao();
		int numPerPage = 10;
		int totalCount = dao.totalSearchCount(conn, table, area, value);
		int totalPage=(totalCount%numPerPage==0)?(totalPage = totalCount/numPerPage):(totalPage = totalCount/numPerPage)+1; //총 페이지

		int start = (reqPage-1)*numPerPage+1;
		int end = reqPage*numPerPage; 
		ArrayList<Object> list = dao.selectSearchListAdmin(conn,start,end,table, area, value);
/*		for(Notice n : list) {
			System.out.println(n);
		}*/
		String pageNavi = "";
		int pageNaviSize= 5;
		int pageNo;
		if(reqPage<3) {
			pageNo = 1;
		}else if(reqPage+2>totalPage){
			if(totalPage-4 > 0) {
				pageNo= totalPage-4;
			}else {
				pageNo=1;
			}
		}else {
			pageNo = reqPage-2;
		}
		pageNavi += "<form action='/searchAdmin' method='post'>";
		pageNavi += "<input type='hidden' name='table' value='"+table+"'>";
		pageNavi += "<input type='hidden' name='area' value='"+area+"'>";
		pageNavi += "<input type='hidden' name='value' value='"+value+"'>";
		pageNavi += "<input type='hidden' name='location' value='"+location+"'>";
		if(pageNo!=1) {
			pageNavi += "<button class='btn' style='color:#888888; ' href='/"+location+"?reqPage="+(pageNo-1)+"'>이전</button>";
		}
		int i=1;

		while(!(i++>pageNaviSize || pageNo>totalPage)) {
			if(reqPage==pageNo) {
				pageNavi +="<span class ='selectPage' style='color:black;'>"+pageNo+"</span>";
			}else {
				pageNavi +="<input type='submit' class ='btn' style='color:#888888;' name='reqPage' value='"+pageNo+"'>";
			}
			pageNo++;
		}
		if(pageNo<= totalPage) {
			pageNavi += "<button class='btn' style='color:#888888;' href='/"+location+"?reqPage="+(pageNo)+"'>다음</button>";
		}
		pageNavi += "</form>";
		PageData pd = new PageData(list, pageNavi);
		
		JDBCTemplate.close(conn);
		return pd;
	}

	public HashMap<String, Integer> getTMB() {
		Connection conn = JDBCTemplate.getConnection();
		AdminDao dao = new AdminDao();
		ArrayList<Perfume> list = dao.getAllPerfume(conn);
		ArrayList<String> toplist = new ArrayList<String>();
		for(Perfume p : list) {
			String top = p.getPerfumeBase();
			StringTokenizer st = new StringTokenizer(top, ",");
			while(st.hasMoreTokens()) {
				toplist.add(st.nextToken());
			}
		}
		HashMap<String, Integer> topmap = new HashMap<String, Integer>();
		for(String top : toplist) {
			if(topmap.containsKey(top)) {
				topmap.put(top, topmap.get(top)+1);
			}else {
				topmap.put(top, 1);
			}
		}
		System.out.println(topmap);
		return topmap;
	}

	public int updateStockAdmin(int amount, String type, int perfumeNo) {
		Connection conn = JDBCTemplate.getConnection();
		AdminDao dao = new AdminDao();
		int result = dao.updateStockAdmin(conn,amount,type,perfumeNo);
		if(result !=0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int getStockAmount(int perfumeNo) {
		Connection conn = JDBCTemplate.getConnection();
		AdminDao dao = new AdminDao();
		int amount = dao.getAmount(conn, perfumeNo);
		JDBCTemplate.close(conn);
		return amount;
	}

	public ArrayList<PaymentInfo> tradeInfoAdmin(int paymentInfoPaymentNo) {
		Connection conn = JDBCTemplate.getConnection();
		AdminDao dao = new AdminDao();
		ArrayList<PaymentInfo> list = dao.tradeInfoAdmin(conn, paymentInfoPaymentNo);
		/*for(PaymentInfo p : list) {
			System.out.println(p);
		}*/
		JDBCTemplate.close(conn);
		return list;
	}

	public int changePaymentStatus(int paymentNo, String status) {
		Connection conn = JDBCTemplate.getConnection();
		AdminDao dao = new AdminDao();
		int result = dao.changePaymentStatus(conn,paymentNo,status);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public PageData perstaListAdmin(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		AdminDao dao = new AdminDao();
		int numPerPage = 10;
		int totalCount = dao.totalCountPersta(conn);
		int totalPage=(totalCount%numPerPage==0)?(totalPage = totalCount/numPerPage):(totalPage = totalCount/numPerPage)+1; //총 페이지

		int start = (reqPage-1)*numPerPage+1;
		int end = reqPage*numPerPage; 
		ArrayList<Object> list = dao.selectListPersta(conn,start,end);
/*		for(Notice n : list) {
			System.out.println(n);
		}*/
		String pageNavi = "";
		int pageNaviSize= 5;
		int pageNo;
		if(reqPage<3) {
			pageNo = 1;
		}else if(reqPage+2>totalPage){
			if(totalPage-4 > 0) {
				pageNo= totalPage-4;
			}else {
				pageNo=1;
			}
		}else {
			pageNo = reqPage-2;
		}

		if(pageNo!=1) {
			pageNavi += "<a class='btn' style='color:#888888;' href='/perstaAdmin?reqPage="+(pageNo-1)+"'>이전</a>";
		}
		int i=1;

		while(!(i++>pageNaviSize || pageNo>totalPage)) {
			if(reqPage==pageNo) {
				pageNavi +="<span class ='selectPage' style='color:black;'>"+pageNo+"</span>";
			}else {
				pageNavi +="<a class ='btn' style='color:#888888;' href='/perstaAdmin?reqPage="+pageNo+"'>"+pageNo+"</a>";
			}
			pageNo++;
		}
		if(pageNo<= totalPage) {
			pageNavi += "<a class='btn' style='color:#888888;' href='/perstaAdmin?reqPage="+(pageNo)+"'>다음</a>";
		}
		PageData pd = new PageData(list, pageNavi);
		
		JDBCTemplate.close(conn);
		return pd;
	}

	public int delPerstaAdmin(String reviewNo) {
		Connection conn = JDBCTemplate.getConnection();
		AdminDao dao = new AdminDao();
		int result = dao.delPerstaAdmin(conn, reviewNo);
		if(result != 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
}
