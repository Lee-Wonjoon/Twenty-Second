package fp.payment.models.service;

import java.sql.Connection;
import java.util.ArrayList;

import fp.basket.model.dao.BasketDao;
import fp.basket.model.vo.BasketList;
import fp.common.JDBCTemplate;
import fp.payment.models.dao.PaymentDao;
import fp.payment.models.vo.Payment;
import fp.payment.models.vo.PaymentInfo;
import fp.recommend.model.dao.RecommendDao;
import fp.recommend.model.vo.RecommendData;

public class PaymentService {

	public int paymentLogic(int memberNo, ArrayList<PaymentInfo> piList, Payment p,ArrayList<Integer> list) {
		Connection conn = JDBCTemplate.getConnection();
		//payment테이블 insert 진행
		PaymentDao dao = new PaymentDao();
		int result = dao.insertPayment(conn,p);
		if(result>0) {
			int paymentNo = dao.currentNo(conn);
			//paymentInfo테이블 insert 진행
			for(int i=0;i<piList.size();i++) {
				result += dao.insertPaymentInfo(conn,paymentNo,piList.get(i));
			}
			//basket테이블에서 삭제
			BasketDao bDao = new BasketDao();
			result += bDao.deleteBasket(conn,list);
			if(result==(piList.size()+1+list.size())) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
				result=0;
			}
		}else {
			JDBCTemplate.rollback(conn);
			result=0;
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Payment> selectPaymentRecentThree(int memberNo) {
		Connection conn = JDBCTemplate.getConnection();
		PaymentDao dao = new PaymentDao();
		ArrayList<Payment> list = dao.selectPaymentRecentThree(conn,memberNo);
		return list;
	}

	public ArrayList<Payment> selectPayment(int memberNo) {
		Connection conn = JDBCTemplate.getConnection();
		PaymentDao dao = new PaymentDao();
		ArrayList<Payment> list = dao.selectPayment(conn,memberNo);
		return list;
	}

	public ArrayList<PaymentInfo> selectPaymentInfo(int paymentNo) {
		Connection conn = JDBCTemplate.getConnection();
		PaymentDao dao = new PaymentDao();
		ArrayList<PaymentInfo> list = dao.selectPaymentInfo(conn,paymentNo);
		return list;
	}

	public int changePaymentStatus(int paymentNo, String status) {
		Connection conn = JDBCTemplate.getConnection();
		PaymentDao dao = new PaymentDao();
		int result = dao.changePaymentStatus(conn,paymentNo,status);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<RecommendData> selectRecommendDate(int memberNo) {
		Connection conn = JDBCTemplate.getConnection();
		RecommendDao dao = new RecommendDao();
		ArrayList<RecommendData> list = dao.selectRecommendDate(conn,memberNo);
		JDBCTemplate.close(conn);
		return list;
	}

}
