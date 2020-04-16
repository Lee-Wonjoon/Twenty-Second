package fp.mypage.model.sevice;

import java.sql.Connection;
import java.util.ArrayList;

import fp.CS.models.vo.Question;
import fp.common.JDBCTemplate;
import fp.member.model.vo.Member;
import fp.mypage.model.dao.MypageDao;

public class MypageService {

	public int changePw(Member m, String changePw) {
		Connection conn = JDBCTemplate.getConnection();
		MypageDao dao = new MypageDao();
		int result = dao.changePw(conn,m,changePw);
		if(result!=0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Question> questionList(int memberNo) {
		Connection conn = JDBCTemplate.getConnection();
		MypageDao dao = new MypageDao();
		ArrayList<Question> list = dao.questionList(conn,memberNo);
		JDBCTemplate.close(conn);
		return list;
	}

	public int outMember(String delMes, int i) {
		Connection conn = JDBCTemplate.getConnection();
		MypageDao dao = new MypageDao();
		int result = dao.outMember(conn,delMes,i);
		if(result!=0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Question> answerList() {
		Connection conn = JDBCTemplate.getConnection();
		MypageDao dao = new MypageDao();
		ArrayList<Question> list = dao.answerList(conn);
		JDBCTemplate.close(conn);
		return list;
	}
	
}
