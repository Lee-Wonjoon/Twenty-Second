package fp.perfumerecommend.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fp.common.JDBCTemplate;
import fp.perfumerecommend.model.vo.PerfumeRecommend;

public class PerfumeRecommendDao {

	public int insertRecommend(Connection conn, PerfumeRecommend pr) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into perfume_recommend values (perfume_recommend_SEQ.nextval, ?, ?, sysdate)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, pr.getMemberNo());
			pstmt.setInt(2, pr.getPerfumeNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}		
		return result;
	}

	public PerfumeRecommend checkRecommend(Connection conn, int memberNo, int perfumeNo) {
		PerfumeRecommend pr = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from perfume_recommend where member_no = ? and perfume_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, perfumeNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				pr = new PerfumeRecommend();
				pr.setPerfumeRecommendNo(rset.getInt("perfume_recommend_no"));
				pr.setMemberNo(rset.getInt("member_no"));
				pr.setPerfumeNo(rset.getInt("perfume_no"));
				pr.setPerfumeRecommendDate(rset.getDate("perfume_recommend_date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return pr;
	}

	public int deleteRecommend(Connection conn, PerfumeRecommend pr) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete perfume_recommend where member_no = ? and perfume_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, pr.getMemberNo());
			pstmt.setInt(2, pr.getPerfumeNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}		
		return result;
	}

	public int insertRecommendUpdatePerfume(Connection conn, PerfumeRecommend pr) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update perfume set perfume_rec_count = perfume_rec_count + 1 where perfume_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, pr.getPerfumeNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}		
		return result;
	}

	public int deleteRecommendUpdatePerfume(Connection conn, PerfumeRecommend pr) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update perfume set perfume_rec_count = perfume_rec_count - 1 where perfume_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, pr.getPerfumeNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}		
		return result;
	}

}
