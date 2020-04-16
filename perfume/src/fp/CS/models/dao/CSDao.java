package fp.CS.models.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fp.CS.models.vo.Question;
import fp.common.JDBCTemplate;
import fp.notice.models.vo.Notice;

public class CSDao {

	public ArrayList<Question> questionList(Connection conn, String memberNickname) {
		ArrayList<Question> list = new ArrayList<Question>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from question where question_level=0 and question_writer = ? order by question_no desc";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberNickname);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				int qustionNo = rset.getInt("question_no");
				String questionTitle = rset.getString("question_title");
				String questionWriter = rset.getString("question_writer");
				String questionContent = rset.getString("question_content");
				Date questionDate = rset.getDate("question_date");
				String filename = rset.getString("filename");
				String filepath = rset.getString("filepath");
				int questionLevel = rset.getInt("question_level");
				int questionRel = rset.getInt("question_rel");
				String questionStatus = rset.getString("question_status");
				Question q = new Question(qustionNo, questionTitle, questionWriter, questionContent, questionDate, filename, filepath, questionLevel, questionRel, questionStatus);
				list.add(q);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int insertQuestionServlet(Connection conn, Question q) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into question values(question_seq.nextval,?,?,?,sysdate,?,?,0,null,default)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, q.getQuestionTitle());
			pstmt.setString(2, q.getQuestionWriter());
			pstmt.setString(3, q.getQuestionContent());
			pstmt.setString(4, q.getFilename());
			pstmt.setString(5, q.getFilepath());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

}
