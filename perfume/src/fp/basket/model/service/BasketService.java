package fp.basket.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import fp.common.JDBCTemplate;
import fp.basket.model.dao.BasketDao;
import fp.basket.model.vo.Basket;
import fp.basket.model.vo.BasketList;

public class BasketService {
	public ArrayList<BasketList> selectAll(int memberNo){
		Connection conn = JDBCTemplate.getConnection();
		BasketDao dao = new BasketDao();
		ArrayList<BasketList> list = dao.selectAll(conn,memberNo);
		JDBCTemplate.close(conn);
		return list;
	}

	public int deleteBasket(ArrayList<Integer> list) {
		Connection conn = JDBCTemplate.getConnection();
		BasketDao dao = new BasketDao();
		int result = dao.deleteBasket(conn,list);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int insertBasket(int memberNo, int perfumeNo, int perfumeAmount, int totalPrice) {
		Connection conn = JDBCTemplate.getConnection();
		BasketDao dao = new BasketDao();
		int result = dao.insertBasket(conn,memberNo,perfumeNo,perfumeAmount,totalPrice);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<BasketList> selectPart(int memberNo,ArrayList<Integer> list) {
		Connection conn = JDBCTemplate.getConnection();
		BasketDao dao = new BasketDao();
		ArrayList<BasketList> basketList = dao.selectPart(conn,memberNo,list);
		JDBCTemplate.close(conn);
		return basketList;
	}
}
