package fp.basket.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fp.common.JDBCTemplate;
import fp.basket.model.vo.Basket;
import fp.basket.model.vo.BasketList;

public class BasketDao {

	public ArrayList<BasketList> selectAll(Connection conn, int memberNo) {
		ArrayList<BasketList> list = new ArrayList<BasketList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from basket join perfume on (basket_perfume_no = perfume_no) where basket_member_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Basket b = new Basket();
				b.setBasketNo(rset.getInt("basket_no"));
				b.setBasketPerfumeNo(rset.getInt("basket_perfume_no"));
				b.setBasketMemberNo(rset.getInt("basket_member_no"));
				b.setBasketAmount(rset.getInt("basket_amount"));
				b.setBasketPrice(rset.getInt("basket_price"));
				String perfume_photopath = rset.getString("perfume_photopath");
				String perfume_name = rset.getString("perfume_name");
				int perfume_volume = rset.getInt("perfume_volume");
				BasketList bl = new BasketList(b, perfume_photopath, perfume_name, perfume_volume);
				list.add(bl);
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

	public int deleteBasket(Connection conn, ArrayList<Integer> list) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "delete from basket where basket_no in (";
		for(int i=0; i<list.size();i++) {
			if(i!=list.size()-1) {
				query += "?,";
			}else {
				query += "?)";
			}
		}
		try {
			pstmt = conn.prepareStatement(query);
			for(int i=0; i<list.size();i++) {
				pstmt.setInt(i+1, list.get(i));
			}
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int insertBasket(Connection conn, int memberNo, int perfumeNo, int perfumeAmount, int totalPrice) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "insert into basket values(basket_seq.nextval,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, perfumeNo);
			pstmt.setInt(2, memberNo);
			pstmt.setInt(3, perfumeAmount);
			pstmt.setInt(4, totalPrice);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<BasketList> selectPart(Connection conn,int memberNo, ArrayList<Integer> list) {
		ArrayList<BasketList> basketList = new ArrayList<BasketList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from basket join perfume on (basket_perfume_no = perfume_no) where basket_member_no = ? and basket_no in (";
		for(int i=0; i<list.size();i++) {
			if(i==list.size()-1) {
				query += "?)";
			}else {
				query += "?,";
			}
		}
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			for(int i=0;i<list.size();i++) {
				pstmt.setInt(i+2, list.get(i));
			}
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Basket b = new Basket();
				b.setBasketNo(rset.getInt("basket_no"));
				b.setBasketPerfumeNo(rset.getInt("basket_perfume_no"));
				b.setBasketMemberNo(rset.getInt("basket_member_no"));
				b.setBasketAmount(rset.getInt("basket_amount"));
				b.setBasketPrice(rset.getInt("basket_price"));
				String perfumePhotopath = rset.getString("perfume_photopath");
				String perfumeName = rset.getString("perfume_name");
				int perfumeVolume = rset.getInt("perfume_volume");
				BasketList bl = new BasketList(b, perfumePhotopath, perfumeName, perfumeVolume);
				basketList.add(bl);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return basketList;
	}

}
