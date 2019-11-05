package fp.shipaddr.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fp.common.JDBCTemplate;
import fp.shipaddr.model.vo.ShipAddr;

public class ShipAddrDao {

	public ArrayList<ShipAddr> selectAll(Connection conn, int memberNo) {
		ArrayList<ShipAddr> list = new ArrayList<ShipAddr>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from ship_addr where ship_addr_member_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				ShipAddr sa = new ShipAddr();
				sa.setShipAddrNo(rset.getInt("ship_addr_no"));
				sa.setShipAddrMemberNo(rset.getInt("ship_addr_member_no"));
				sa.setShipAddrAddr(rset.getString("ship_addr_addr"));
				sa.setShipAddrPhone(rset.getString("ship_addr_phone"));
				sa.setShipAddrName(rset.getString("ship_addr_name"));
				list.add(sa);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int insertAddr(Connection conn, ShipAddr sa) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into ship_addr values(ship_addr_no_seq.nextval,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, sa.getShipAddrMemberNo());
			pstmt.setString(2, sa.getShipAddrAddr());
			pstmt.setString(3, sa.getShipAddrPhone());
			pstmt.setString(4, sa.getShipAddrName());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteOne(Connection conn, int shipAddrNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from ship_addr where ship_addr_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, shipAddrNo);
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
