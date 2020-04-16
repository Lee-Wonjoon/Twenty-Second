package fp.recommend.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import fp.common.JDBCTemplate;
import fp.recommend.model.dao.RecommendDao;
import fp.recommend.model.vo.Recommend;

public class RecommendService {

	public int insertRecommendArr(ArrayList<Recommend> prlist) {
		Connection conn = JDBCTemplate.getConnection();
		int result = 1;
		for(int i = 0; i<prlist.size(); i++) {
			RecommendDao dao = new RecommendDao();
			//한번이라도 실패가 뜨면 0가 되고, 0면 실패가 됨.
			result *= dao.insertRecommend(conn, prlist.get(i));
		}
		//작업 후 한번이라도 실패시 롤백
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

}
