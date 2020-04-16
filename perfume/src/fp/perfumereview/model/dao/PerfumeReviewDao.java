package fp.perfumereview.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fp.common.JDBCTemplate;
import fp.perfumereview.model.vo.PerfumeReview;

public class PerfumeReviewDao {

	public int insertPerfumeReview(Connection conn, PerfumeReview pfreview) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into perfume_review values(perfume_review_no_seq.nextval, ?, ?, ?, ?, ?, sysdate)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, pfreview.getMemberNo());
			pstmt.setString(2, pfreview.getMemberNickname());
			pstmt.setInt(3, pfreview.getPerfumeNo());
			pstmt.setString(4, pfreview.getPerfumeReviewTitle());
			pstmt.setString(5, pfreview.getPerfumeReviewContent());
			result = pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<PerfumeReview> onePerfumeReview(Connection conn, int perfumeNo) {
		ArrayList<PerfumeReview> pflist = new ArrayList<PerfumeReview>();
		PerfumeReview preview = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from perfume_review where perfume_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, perfumeNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				preview = new PerfumeReview();
				preview.setPerfumeReviewNo(rset.getInt("perfume_review_no"));
				preview.setMemberNo(rset.getInt("member_no"));
				preview.setMemberNickname(rset.getString("member_nickname"));
				preview.setPerfumeNo(rset.getInt("perfume_no"));
				preview.setPerfumeReviewTitle(rset.getString("perfume_review_title"));
				preview.setPerfumeReviewContent(rset.getString("perfume_review_content"));
				preview.setPerfumeReviewDate(rset.getDate("perfume_review_date"));
				pflist.add(preview);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return pflist;
	}


	public int updatePerfumeReview(Connection conn, int perfumeReviewNo, String perfumeReviewContent) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update perfume_review set perfume_review_content = ? where perfume_review_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, perfumeReviewContent);
			pstmt.setInt(2, perfumeReviewNo);
			result = pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deletePerfumeReview(Connection conn, int perfumeReviewNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from perfume_review where perfume_review_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, perfumeReviewNo);
			result = pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

}
