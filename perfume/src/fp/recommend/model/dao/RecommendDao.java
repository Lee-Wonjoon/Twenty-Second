package fp.recommend.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fp.common.JDBCTemplate;
import fp.recommend.model.vo.Recommend;
import fp.recommend.model.vo.RecommendData;

public class RecommendDao {

	public ArrayList<RecommendData> selectRecommendDate(Connection conn, int memberNo) {
		ArrayList<RecommendData> list = new ArrayList<RecommendData>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from recommend join perfume on(perfume_no=recommend_perfume_no) where recommend_member_no = ? order by recommend_date desc";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				RecommendData rd = new RecommendData();
				rd.setRecommendNo(rset.getInt("recommend_no"));
				rd.setRecommendMemberNo(rset.getInt("recommend_member_no"));
				rd.setRecommendPerfumeNo(rset.getInt("recommend_perfume_no"));
				rd.setRecommendPerfumeVolume(rset.getInt("perfume_volume"));
				rd.setRecommendPerfumeName(rset.getString("perfume_name"));
				rd.setRecommendPerfumePhotopath(rset.getString("perfume_photopath"));
				rd.setRecommendDate(rset.getDate("recommend_date"));
				list.add(rd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int insertRecommend(Connection conn, Recommend recommend) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into recommend values (recommend_no_SEQ.nextval, ?, ?, sysdate)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, recommend.getRecommendMemberNo());
			pstmt.setInt(2, recommend.getRecommendPerfumeNo());
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
