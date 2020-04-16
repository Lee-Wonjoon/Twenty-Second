package fp.shipaddr.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import fp.common.JDBCTemplate;
import fp.shipaddr.model.dao.ShipAddrDao;
import fp.shipaddr.model.vo.ShipAddr;

public class ShipAddrService {

	public ArrayList<ShipAddr> selectAll(int memberNo) {
		Connection conn = JDBCTemplate.getConnection();
		ShipAddrDao dao = new ShipAddrDao();
		ArrayList<ShipAddr> list = dao.selectAll(conn,memberNo);
		JDBCTemplate.close(conn);
		return list;
	}

	public int insertAddr(ShipAddr sa) {
		Connection conn = JDBCTemplate.getConnection();
		ShipAddrDao dao = new ShipAddrDao();
		int result = dao.insertAddr(conn,sa);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteOne(int shipAddrNo) {
		Connection conn = JDBCTemplate.getConnection();
		ShipAddrDao dao = new ShipAddrDao();
		int result = dao.deleteOne(conn,shipAddrNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

}
