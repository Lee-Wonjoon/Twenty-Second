package fp.member.model.service;

import java.sql.Connection;

import fp.common.JDBCTemplate;
import fp.member.model.dao.MemberDao;
import fp.member.model.vo.Member;

public class MemberService {

	public int insertMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		MemberDao dao = new MemberDao();
		int result = dao.insertMember(conn, m);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public Member login(String memberId, String memberPw) {
		Connection conn = JDBCTemplate.getConnection();
		MemberDao dao = new MemberDao();
		Member m = dao.login(conn, memberId, memberPw);
		JDBCTemplate.close(conn);
		return m;
	}

	public String pw(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		MemberDao dao = new MemberDao();
		String memberPw = null;
		memberPw = dao.pw(conn, memberId);
		return memberPw;
	}

	public Member checkId(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		MemberDao dao = new MemberDao();
		Member m = dao.checkId(conn, memberId);
		JDBCTemplate.close(conn);
		return m;
	}

	public Member checkNickName(String memberNickName) {
		Connection conn = JDBCTemplate.getConnection();
		MemberDao dao = new MemberDao();
		Member m = dao.checkNickName(conn, memberNickName);
		JDBCTemplate.close(conn);
		return m;
	}

	public int UpdatePassword(String memberId, String testpw) {
		Connection conn = JDBCTemplate.getConnection();
		MemberDao dao = new MemberDao();
		int result = dao.UpdatePassword(conn, memberId, testpw);
		if (result != 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateData(int memberNo, String phone, String birth, String gender) {
		Connection conn = JDBCTemplate.getConnection();
		MemberDao dao = new MemberDao();
		int result = dao.updateData(conn, memberNo, phone, birth,gender);
		if(result>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	

}
