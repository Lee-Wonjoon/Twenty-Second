package fp.payment.models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fp.common.JDBCTemplate;
import fp.payment.models.vo.Payment;
import fp.payment.models.vo.PaymentInfo;

public class PaymentDao {

	public int insertPayment(Connection conn, Payment p) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into payment values(payment_seq.nextval,?,?,?,?,?,?,?,?,?,sysdate)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, p.getPaymentMemberNo());
			pstmt.setString(2, p.getPaymentProductName());
			pstmt.setString(3, p.getPaymentShipName());
			pstmt.setString(4, p.getPaymentShipPhone());
			pstmt.setString(5, p.getPaymentShipAddr());
			pstmt.setString(6, p.getPaymentShipMsg());
			pstmt.setString(7, p.getPaymentMerchantUid());
			pstmt.setString(8, p.getPaymentStatus());
			pstmt.setInt(9, p.getPaymentPrice());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int currentNo(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int paymentInfoNo = 0;
		String query = "select payment_seq.currval as curr from dual";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				paymentInfoNo = rset.getInt("curr");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return paymentInfoNo;
		
	}

	public int insertPaymentInfo(Connection conn, int paymentNo,PaymentInfo pi) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into payment_info values(payment_info_no_seq.nextval,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, paymentNo);
			pstmt.setInt(2, pi.getPaymentInfoPerfumeNo());
			pstmt.setString(3, pi.getPaymentInfoPerfumePhotopath());
			pstmt.setString(4, pi.getPaymentInfoPerfumeName());
			pstmt.setInt(5, pi.getPaymentInfoPerfumeVolume());
			pstmt.setInt(6, pi.getPaymentInfoBasketAmount());
			pstmt.setInt(7, pi.getPaymentInfoBasketPrice());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Payment> selectPaymentRecentThree(Connection conn, int memberNo) {
		ArrayList<Payment> list = new ArrayList<Payment>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from (select * from payment where payment_member_no =? order by payment_no desc) where rownum<4";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Payment p = new Payment();
				p.setPaymentNo(rset.getInt("payment_no"));
				p.setPaymentMemberNo(rset.getInt("payment_member_no"));
				p.setPaymentProductName(rset.getString("payment_product_name"));
				p.setPaymentShipName(rset.getString("payment_ship_name"));
				p.setPaymentShipPhone(rset.getString("payment_ship_phone"));
				p.setPaymentShipAddr(rset.getString("payment_ship_addr"));
				p.setPaymentShipMsg(rset.getString("payment_ship_msg"));
				p.setPaymentMerchantUid(rset.getString("payment_merchant_uid"));
				p.setPaymentStatus(rset.getString("payment_status"));
				p.setPaymentPrice(rset.getInt("payment_price"));
				p.setPaymentDate(rset.getDate("payment_date"));
				list.add(p);
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

	public ArrayList<Payment> selectPayment(Connection conn, int memberNo) {
		ArrayList<Payment> list = new ArrayList<Payment>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from payment where payment_member_no =? order by payment_no desc";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Payment p = new Payment();
				p.setPaymentNo(rset.getInt("payment_no"));
				p.setPaymentMemberNo(rset.getInt("payment_member_no"));
				p.setPaymentProductName(rset.getString("payment_product_name"));
				p.setPaymentShipName(rset.getString("payment_ship_name"));
				p.setPaymentShipPhone(rset.getString("payment_ship_phone"));
				p.setPaymentShipAddr(rset.getString("payment_ship_addr"));
				p.setPaymentShipMsg(rset.getString("payment_ship_msg"));
				p.setPaymentMerchantUid(rset.getString("payment_merchant_uid"));
				p.setPaymentStatus(rset.getString("payment_status"));
				p.setPaymentPrice(rset.getInt("payment_price"));
				p.setPaymentDate(rset.getDate("payment_date"));
				list.add(p);
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

	public ArrayList<PaymentInfo> selectPaymentInfo(Connection conn, int paymentNo) {
		ArrayList<PaymentInfo> list = new ArrayList<PaymentInfo>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from payment_info where payment_info_payment_no =?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, paymentNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				PaymentInfo pi = new PaymentInfo();
				pi.setPaymentInfoNo(rset.getInt("payment_info_no"));
				pi.setPaymentInfoPaymentNo(rset.getInt("payment_info_payment_no"));
				pi.setPaymentInfoPerfumeNo(rset.getInt("payment_info_perfume_no"));
				pi.setPaymentInfoPerfumePhotopath(rset.getString("payment_info_perfume_photopath"));
				pi.setPaymentInfoPerfumeName(rset.getString("payment_info_perfume_name"));
				pi.setPaymentInfoPerfumeVolume(rset.getInt("payment_info_perfume_volume"));
				pi.setPaymentInfoBasketAmount(rset.getInt("payment_info_basket_amount"));
				pi.setPaymentInfoBasketPrice(rset.getInt("payment_info_basket_price"));
				list.add(pi);
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

	public int changePaymentStatus(Connection conn, int paymentNo, String status) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "update payment set payment_status = ? where payment_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, status);
			pstmt.setInt(2, paymentNo);
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
