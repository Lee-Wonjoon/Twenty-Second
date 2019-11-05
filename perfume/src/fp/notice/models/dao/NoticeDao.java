package fp.notice.models.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fp.common.JDBCTemplate;
import fp.notice.models.vo.Notice;

public class NoticeDao {

	public int totalCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result=0;
		String query = "select count(*) as tot from notice";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("tot");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Notice> selectList(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Notice> list = new ArrayList<Notice>();
		// 쿼리문이 중요하다. 두 번쨰 서브쿼리는 우리가 아는 그거, 첫 서브쿼리는 불러온 데이터에 각각 넘버링을 하는 것 . 메인쿼리는 ?~? 까지 호출 
		String query = "select * from "
						+ "(select ROWNUM as rnum, n.* from "
							+ "(select * from  notice order by notice_no desc)"
						+ " n) "
					+ "where rnum between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				int noticeNo = rset.getInt("notice_no");
				String noticeWriter = rset.getString("notice_writer");
				String noticeTitle = rset.getString("notice_title");
				String noticeContent = rset.getString("notice_content");
				Date noticeDate= rset.getDate("notice_date");
				String filename=rset.getString("filename");
				String filepath=rset.getString("filepath");
				Notice n = new Notice(noticeNo, noticeWriter, noticeTitle, noticeContent, noticeDate, filename, filepath);
				list.add(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public Notice noticeView(Connection conn, int noticeNo) {
		Notice n = null;
		PreparedStatement pstmt =null;
		ResultSet rset = null;
		String query="select * from notice where notice_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				String noticeWriter = rset.getString("notice_writer");
				String noticeTitle = rset.getString("notice_title");
				String noticeContent = rset.getString("notice_content");
				Date noticeDate= rset.getDate("notice_date");
				String filename=rset.getString("filename");
				String filepath=rset.getString("filepath");
				n = new Notice(noticeNo, noticeWriter, noticeTitle, noticeContent, noticeDate, filename, filepath);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return n;
	}

}
