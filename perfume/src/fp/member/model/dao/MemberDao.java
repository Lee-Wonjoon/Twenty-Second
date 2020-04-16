package fp.member.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sun.org.apache.bcel.internal.generic.GETFIELD;

import fp.common.JDBCTemplate;
import fp.member.model.vo.Member;

public class MemberDao {

	public int insertMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into member values(member_SEQ.nextval,?,?,?,?,?,?,sysdate,'false',null,null)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberNickname());
			pstmt.setString(3, m.getMemberPw());
			pstmt.setString(4, m.getMemberGender());
			pstmt.setString(5, m.getMemberBirth());
			pstmt.setString(6, m.getMemberPhone());
			result = pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public Member login(Connection conn, String memberId, String memberPw) {
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from member where member_id = ? and member_pw = ? and member_valid='false'";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				m = new Member();
				m.setMemberNo(rset.getInt("member_no"));
				m.setMemberId(rset.getString("member_id"));
				m.setMemberNickname(rset.getString("member_nickname"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setMemberGender(rset.getString("member_gender"));
				m.setMemberBirth(rset.getString("member_birth"));
				m.setMemberPhone(rset.getString("member_phone"));
				m.setMemberEnrollDate(rset.getDate("member_enroll_date"));
				m.setMemberValid(rset.getString("member_valid"));
				m.setMemberDeleteDate(rset.getDate("member_delete_date"));
				m.setMemberDeleteContent(rset.getString("member_delete_content"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m;
	}


	public String pw(Connection conn, String MemberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String MemberPw = null;
		String query = "select * from member where member_id=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, MemberId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				MemberPw = rset.getString("member_pw");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return MemberPw;
	}

	public Member checkId(Connection conn, String MemberId) {
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from member where member_id = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, MemberId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				m = new Member();
				m.setMemberId(rset.getString("member_id"));
				m.setMemberNickname(rset.getString("member_nickname"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setMemberGender(rset.getString("member_gender"));
				m.setMemberBirth(rset.getString("member_birth"));
				m.setMemberPhone(rset.getString("member_phone"));
				m.setMemberEnrollDate(rset.getDate("member_enroll_date"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m;
	}

	public Member checkNickName(Connection conn, String memberNickName) {
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from member where member_nickname=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberNickName);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				m = new Member();
				m.setMemberId(rset.getString("member_id"));
				m.setMemberNickname(rset.getString("member_nickname"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setMemberGender(rset.getString("member_gender"));
				m.setMemberBirth(rset.getString("member_birth"));
				m.setMemberPhone(rset.getString("member_phone"));
				m.setMemberEnrollDate(rset.getDate("member_enroll_date"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m;
	}

	public int UpdatePassword(Connection conn, String memberId, String testpw) {
		int result = 0;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String query = "update member set member_pw = ? where member_id = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, testpw);
			pstmt.setString(2, memberId);
			result = pstmt.executeUpdate();	
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateData(Connection conn, int memberNo, String phone, String birth, String gender) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "update member set member_phone = ?, member_birth = ?, member_gender = ? where member_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, phone);
			pstmt.setString(2, birth);
			pstmt.setString(3, gender);
			pstmt.setInt(4, memberNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
}
