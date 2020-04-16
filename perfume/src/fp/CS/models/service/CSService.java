package fp.CS.models.service;

import java.sql.Connection;
import java.util.ArrayList;

import fp.CS.models.dao.CSDao;
import fp.CS.models.vo.Question;
import fp.common.JDBCTemplate;

public class CSService {

	public ArrayList<Question> questionList(String memberNickname) {
		Connection conn = JDBCTemplate.getConnection();
		CSDao dao = new CSDao();
		ArrayList<Question> list = dao.questionList(conn, memberNickname);
		JDBCTemplate.close(conn);
		return list;
	}

	public int insertQuestionServlet(Question q) {
		Connection conn = JDBCTemplate.getConnection();
		CSDao dao = new CSDao();
		int result = dao.insertQuestionServlet(conn, q);
		JDBCTemplate.close(conn);
		return result;
	}

}
