package fp.perfumereview.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import fp.common.JDBCTemplate;
import fp.perfumereview.model.dao.PerfumeReviewDao;
import fp.perfumereview.model.vo.PerfumeReview;

public class PerfumeReviewService {

	public int insertPerfumeReview(PerfumeReview pfreview) {
		Connection conn = JDBCTemplate.getConnection();
		PerfumeReviewDao dao = new PerfumeReviewDao();
		int result = dao.insertPerfumeReview(conn, pfreview);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<PerfumeReview> onePerfumeReview(int perfumeNo) {
		Connection conn = JDBCTemplate.getConnection();
		PerfumeReviewDao dao = new PerfumeReviewDao();
		ArrayList<PerfumeReview> prlist = dao.onePerfumeReview(conn, perfumeNo);
		return prlist;
	}

	public int updatePerfumeReview(int perfumeReviewNo, String perfumeReviewContent) {
		Connection conn = JDBCTemplate.getConnection();
		PerfumeReviewDao dao = new PerfumeReviewDao();
		int result = dao.updatePerfumeReview(conn, perfumeReviewNo, perfumeReviewContent);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int deletePerfumeReview(int perfumeReviewNo) {
		Connection conn = JDBCTemplate.getConnection();
		PerfumeReviewDao dao = new PerfumeReviewDao();
		int result = dao.deletePerfumeReview(conn, perfumeReviewNo);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

}
