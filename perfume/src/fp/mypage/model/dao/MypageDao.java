package fp.mypage.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fp.CS.models.vo.Question;
import fp.common.JDBCTemplate;
import fp.member.model.vo.Member;
import fp.mypage.model.vo.QuestionData;

public class MypageDao {

	public int changePw(Connection conn, Member m, String changePw) {
		PreparedStatement pstmt = null;
		int result =0;
		String query = "update member set member_Pw=? where member_No=? ";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, changePw);
			pstmt.setInt(2, m.getMemberNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Question> questionList(Connection conn, int memberNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		//QuestionData qd = null;
		ArrayList<Question> list = new ArrayList<Question>();
		String query = "select * from question join member on (question_writer = member_nickname) where member_no = ? order by question_no desc";
		int count = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				int questionNo = rset.getInt("question_no");
				String questionTitle = rset.getString("question_Title");
				String questionWriter = rset.getString("question_writer");
				String questionContent = rset.getString("question_content");
				Date questionDate = rset.getDate("question_date");
				String filename = rset.getString("filename");
				String filepath = rset.getString("filepath");
				int questionLevel = rset.getInt("question_level");
				int questionRel = rset.getInt("question_rel");
				String questionStatus = rset.getString("question_status");
				Question q = new Question(questionNo, questionTitle, questionWriter, questionContent, questionDate, filename, filepath, questionLevel, questionRel, questionStatus);
				list.add(q);
				count++;
				//qd = new QuestionData(list,rset.getInt("member_no"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		if(count ==0) {
			return null;
		}else {
			return list;			
		}
	}

	public int outMember(Connection conn, String delMes, int i) {
		PreparedStatement pstmt = null;
		int result =0;
		String query = "update member set member_valid = ?, member_delete_content = ? where member_No = ? ";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "true");
			pstmt.setString(2, delMes);
			pstmt.setInt(3, i);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Question> answerList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		//QuestionData qd = null;
		ArrayList<Question> list = new ArrayList<Question>();
		String query = "select * from question where question_level = 1";
		int count = 0;
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				int questionNo = rset.getInt("question_no");
				String questionTitle = rset.getString("question_Title");
				String questionWriter = rset.getString("question_writer");
				String questionContent = rset.getString("question_content");
				Date questionDate = rset.getDate("question_date");
				String filename = rset.getString("filename");
				String filepath = rset.getString("filepath");
				int questionLevel = rset.getInt("question_level");
				int questionRel = rset.getInt("question_rel");
				String questionStatus = rset.getString("question_status");
				Question q = new Question(questionNo, questionTitle, questionWriter, questionContent, questionDate, filename, filepath, questionLevel, questionRel, questionStatus);
				list.add(q);
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		if(count ==0) {
			return null;
		}else {
			return list;			
		}
	}
	
}
