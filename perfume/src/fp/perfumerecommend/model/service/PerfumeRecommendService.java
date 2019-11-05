package fp.perfumerecommend.model.service;

import java.sql.Connection;

import fp.common.JDBCTemplate;
import fp.perfume.model.vo.Perfume;
import fp.perfumerecommend.model.dao.PerfumeRecommendDao;
import fp.perfumerecommend.model.vo.PerfumeRecommend;

public class PerfumeRecommendService {

	public int insertRecommend(PerfumeRecommend pr) {
		Connection conn = JDBCTemplate.getConnection();
		PerfumeRecommendDao dao = new PerfumeRecommendDao();
		int result = dao.insertRecommend(conn, pr);
		int result2 = dao.insertRecommendUpdatePerfume(conn, pr);
		if (result > 0 && result2 > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public PerfumeRecommend checkRecommend(int memberNo, int perfumeNo) {
		Connection conn = JDBCTemplate.getConnection();
		PerfumeRecommendDao dao = new PerfumeRecommendDao();
		PerfumeRecommend pr = dao.checkRecommend(conn, memberNo, perfumeNo);
		JDBCTemplate.close(conn);
		return pr;
	}

	public int deleteRecommend(PerfumeRecommend pr) {
		Connection conn = JDBCTemplate.getConnection();
		PerfumeRecommendDao dao = new PerfumeRecommendDao();
		int result = dao.deleteRecommend(conn, pr);
		int result2 = dao.deleteRecommendUpdatePerfume(conn, pr);
		if (result > 0 && result2 > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

}
