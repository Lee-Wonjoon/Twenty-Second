package fp.admin.models.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.plaf.synth.SynthSplitPaneUI;

import fp.CS.models.vo.Question;
import fp.admin.models.vo.PerfumeAddStock;
import fp.common.JDBCTemplate;
import fp.member.model.vo.Member;
import fp.notice.models.vo.Notice;
import fp.payment.models.vo.Payment;
import fp.payment.models.vo.PaymentInfo;
import fp.perfume.model.vo.Perfume;
import fp.perfumereview.model.vo.PerfumeReview;
import fp.review.model.vo.Review;

public class AdminDao {

	public int totalCountMember(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result=0;
		String query = "select count(*) as tot from member";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("tot");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Object> selectListMember(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Object> list = new ArrayList<Object>();
		String query = "select * from "
						+ "(select ROWNUM as rnum, n.* from "
							+ "(select * from  member order by member_no desc)"
						+ " n) "
					+ "where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				int memberNo = rset.getInt("member_no");
				String memberId = rset.getString("member_Id");
				String memberNickname = rset.getString("member_nickname");
				String memberPw = rset.getString("member_pw");
				String memberGender = rset.getString("member_gender");
				String memberBirth = rset.getString("member_birth");
				String memberPhone = rset.getString("member_phone");
				Date memberEnrollDate = rset.getDate("member_enroll_date");
				String memberValid = rset.getString("member_valid");
				Date memberDeleteDate = rset.getDate("member_delete_date");
				String memberDeleteContent = rset.getString("member_delete_content");
				Member m = new Member(memberNo, memberId, memberNickname, memberPw, memberGender, memberBirth, memberPhone, memberEnrollDate, memberValid, memberDeleteDate, memberDeleteContent);
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int deletePerfume(Connection conn, int perfumeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result=0;
		String query = "delete from PERFUME where perfume_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, perfumeNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int totalCountPerfume(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result=0;
		String query = "select count(*) as tot from Perfume";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("tot");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Object> selectListPerfume(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Object> list = new ArrayList<Object>();
		String query = "select * from "
						+ "(select ROWNUM as rnum, n.* from "
							+ "(select * from perfume left join stock on (perfume_no = stock_perfume_no) order by perfume_no desc)"
						+ " n) "
					+ "where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				PerfumeAddStock p = new PerfumeAddStock();
				p.setRnum(rset.getInt("rnum"));
				p.setPerfumeNo(rset.getInt("perfume_no"));
				p.setPerfumeName(rset.getString("perfume_name"));
				p.setPerfumeBrand(rset.getString("perfume_brand"));
				p.setPerfumeVolume(rset.getInt("perfume_volume"));
				p.setPerfumeDensity(rset.getString("perfume_density"));
				p.setPerfumeTop(rset.getString("perfume_top"));
				p.setPerfumeMiddle(rset.getString("perfume_middle"));
				p.setPerfumeBase(rset.getString("perfume_base"));
				p.setPerfumeRecCount(rset.getInt("perfume_rec_count"));
				p.setPerfumeGender(rset.getString("perfume_gender"));
				p.setPerfumePrice(rset.getInt("perfume_price"));
				p.setPerfumePhotoname(rset.getString("perfume_photoname"));
				p.setPerfumePhotopath(rset.getString("perfume_photopath"));
				p.setPerfumeDetail(rset.getString("perfume_detail"));
				p.setStock(rset.getInt("stock_amount"));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public Perfume getPerfume(Connection conn, int perfumeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Perfume p =null;
		String query = "select * from perfume left join stock on (perfume_no = stock_perfume_no) where perfume_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, perfumeNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				p = new Perfume();
				p.setPerfumeNo(rset.getInt("perfume_no"));
				p.setPerfumeName(rset.getString("perfume_name"));
				p.setPerfumeBrand(rset.getString("perfume_brand"));
				p.setPerfumeVolume(rset.getInt("perfume_volume"));
				p.setPerfumeDensity(rset.getString("perfume_density"));
				p.setPerfumeTop(rset.getString("perfume_top"));
				p.setPerfumeMiddle(rset.getString("perfume_middle"));
				p.setPerfumeBase(rset.getString("perfume_base"));
				p.setPerfumeRecCount(rset.getInt("perfume_rec_count"));
				p.setPerfumeGender(rset.getString("perfume_gender"));
				p.setPerfumePrice(rset.getInt("perfume_price"));
				p.setPerfumePhotoname(rset.getString("perfume_photoname"));
				p.setPerfumePhotopath(rset.getString("perfume_photopath"));
				p.setPerfumeDetail(rset.getString("perfume_detail"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return p;
	}

	public int updatePerfumeFinishAdmin(Connection conn, int perfumeNo, String perfumeName, int perfumePrice,
			String perfumePhotoname, String perfumePhotopath, String perfumeDetail) {
		PreparedStatement pstmt = null;  
		int result =0;
		String query = "update perfume set perfume_name =?, perfume_price = ?, perfume_photoname = ? , perfume_photopath = ? ,perfume_detail =? where perfume_No=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, perfumeName);
			pstmt.setInt(2, perfumePrice);
			pstmt.setString(3, perfumePhotoname);
			pstmt.setString(4, perfumePhotopath);
			pstmt.setString(5, perfumeDetail);
			pstmt.setInt(6 , perfumeNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int validMemberAdmin(Connection conn, int memberNo, String memberValid) {
		PreparedStatement pstmt = null;
		int result =0;
		String query = "update member set member_Valid =? where member_No=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberValid);
			pstmt.setInt(2, memberNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int totalCountReview(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result=0;
		String query = "select count(*) as tot from perfume_review";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("tot");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Object> selectListReview(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Object> list = new ArrayList<Object>();
		String query = "select * from "
						+ "(select ROWNUM as rnum, n.* from "
							+ "(select * from perfume_review order by perfume_review_no desc)"
						+ " n) "
					+ "where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				int perfumeReviewNo = rset.getInt("perfume_review_no");
				int revMembNo = rset.getInt("member_no");
				String revMembNick = rset.getString("member_nickname");
				int perfumeNo = rset.getInt("perfume_no");
				String perfumeReviewTitle = rset.getString("perfume_review_title");
				String perfumeReviewContent = rset.getString("perfume_review_content");
				Date perfumeReviewDate = rset.getDate("perfume_review_date");
				PerfumeReview r = new PerfumeReview(perfumeReviewNo, revMembNo, revMembNick, perfumeNo, perfumeReviewTitle, perfumeReviewContent, perfumeReviewDate);
				list.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
	public int deleteReviewAdmin(Connection conn, int reviewNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from perfume_review where perfume_review_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, reviewNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int totalCountQuestion(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result=0;
		String query = "select count(*) as tot from question where question_level=0";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("tot");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Object> selectListQuestion(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Object> list = new ArrayList<Object>();
		String query = "select * from "
						+ "(select ROWNUM as rnum, n.* from "
							+ "(select * from question where question_level=0 order by question_no desc)"
						+ " n) "
					+ "where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				int questionNo = rset.getInt("question_No");
				String questionTitle = rset.getString("question_title");
				String questionWriter = rset.getString("question_writer");
				String questionContent = rset.getString("question_content");
				Date questionDate = rset.getDate("question_date");
				String filename = rset.getString("filename");
				String filepath = rset.getString("filepath");
				int questionLevel = rset.getInt("question_level");
				int questionRel  = rset.getInt("question_rel");
				String questionStatus = rset.getString("question_status");
				Question q = new Question(questionNo, questionTitle, questionWriter, questionContent, questionDate, filename, filepath, questionLevel, questionRel, questionStatus);
				list.add(q);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int readQuestionAdmin(Connection conn, int questionNo, String to) {
		PreparedStatement pstmt = null;
		int result =0;
		String query = "update question set question_status =? where question_No=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, to);
			pstmt.setInt(2, questionNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public Question getQuestion(Connection conn, int questionNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Question q = null;
		String query = "select * from question where question_No=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, questionNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				String questionTitle = rset.getString("question_title");
				String questionWriter = rset.getString("question_writer");
				String questionContent = rset.getString("question_content");
				Date questionDate = rset.getDate("question_date");
				String filename = rset.getString("filename");
				String filepath = rset.getString("filepath");
				int questionLevel = rset.getInt("question_level");
				int questionRel  = rset.getInt("question_rel");
				String questionStatus = rset.getString("question_status");
				q = new Question(questionNo, questionTitle, questionWriter, questionContent, questionDate, filename, filepath, questionLevel, questionRel, questionStatus);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return q;
	}

	public int answerQuestionAdmin(Connection conn, int questionNo, String questionContent, String filename, String filepath) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into question values(question_seq.nextval,'안녕하세요. 두번째 스무살입니다.','관리자',?,sysdate,?,?,1,?,'답변')";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, questionContent);// 답변내용
			pstmt.setString(2, filename);//파일명
			pstmt.setString(3, filepath);//파일경로
			pstmt.setInt(4, questionNo);// 질문글 번호
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public Question getQuestionAnswer(Connection conn, int questionNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Question q = null;
		String query = "select * from question where question_rel=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, questionNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				int answerNo = rset.getInt("question_no");
				String questionTitle = rset.getString("question_title");
				String questionWriter = rset.getString("question_writer");
				String questionContent = rset.getString("question_content");
				Date questionDate = rset.getDate("question_date");
				String filename = rset.getString("filename");
				String filepath = rset.getString("filepath");
				int questionLevel = rset.getInt("question_level");
				String questionStatus = rset.getString("question_status");
				q = new Question(answerNo, questionTitle, questionWriter, questionContent, questionDate, filename, filepath, questionLevel, questionNo, questionStatus);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return q;
	}

	public int totalCountNotice(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result=0;
		String query = "select count(*) as tot from notice";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("tot");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Object> selectListNotice(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Object> list = new ArrayList<Object>();
		String query = "select * from "
						+ "(select ROWNUM as rnum, n.* from "
							+ "(select * from notice order by notice_no desc)"
						+ " n) "
					+ "where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				int noticeNo = rset.getInt("notice_no");
				String noticeWriter = rset.getString("notice_writer");
				String noticeTitle = rset.getString("notice_title");
				String noticeContent = rset.getString("notice_content");
				Date noticeDate = rset.getDate("notice_date");
				String filename = rset.getString("filename");
				String filepath = rset.getString("filepath");
				Notice n = new Notice(noticeNo, noticeWriter, noticeTitle, noticeContent, noticeDate, filename, filepath);
				list.add(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int deleteNoticeAdmin(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null;
		int result=0;
		String query= "delete from notice where notice_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			result= pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public Notice getNoticeAdmin(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Notice n = null;
		String query= "select * from notice where notice_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			rset= pstmt.executeQuery();
			if(rset.next()) {
				String noticeWriter = rset.getString("notice_writer");
				String noticeTitle = rset.getString("notice_title");
				String noticeContent = rset.getString("notice_content");
				Date noticeDate = rset.getDate("notice_date");
				String filename = rset.getString("filename");
				String filepath = rset.getString("filepath");
				n = new Notice(noticeNo, noticeWriter, noticeTitle, noticeContent, noticeDate, filename, filepath);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return n;
	}

	public int updateNoticeAdmin(Connection conn, Notice n) {
		PreparedStatement pstmt = null;
		int result =0;
		String query = "update notice set notice_title = ?, notice_content = ?, filename=?, filepath=? where notice_No=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, n.getNoticeTitle());
			pstmt.setString(2, n.getNoticeContent());
			pstmt.setString(3, n.getFilename());
			pstmt.setString(4, n.getFilepath());
			pstmt.setInt(5, n.getNoticeNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int totalCountTrade(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result=0;
		String query = "select count(*) as tot from payment";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("tot");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Object> selectListTrade(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Object> list = new ArrayList<Object>();
		String query = "select * from "
						+ "(select ROWNUM as rnum, n.* from "
							+ "(select * from payment order by payment_no desc)"
						+ " n) "
					+ "where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				int paymentNo = rset.getInt("payment_no");
				int paymentMemberNo = rset.getInt("payment_member_no");
				String paymentProductName = rset.getString("payment_product_name");
				String paymentShipName = rset.getString("payment_ship_name");
				String paymentShipPhone = rset.getString("payment_ship_phone");
				String paymentShipAddr = rset.getString("payment_ship_addr");
				String paymentShipMsg = rset.getString("payment_ship_msg");
				String paymentMerchantUid = rset.getString("payment_Merchant_uid");
				String paymentStatus = rset.getString("payment_Status");
				int paymentPrice = rset.getInt("payment_price");
				Date paymentDate = rset.getDate("payment_date");
				Payment pp = new Payment(paymentNo, paymentMemberNo, paymentProductName, paymentShipName, paymentShipPhone, paymentShipAddr, paymentShipMsg, paymentMerchantUid, paymentStatus, paymentPrice, paymentDate);
				list.add(pp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int insertNoticeAdmin(Connection conn, Notice n) {
		PreparedStatement pstmt = null;
		int result =0;
		String query = "insert into notice values(notice_seq.nextval,'관리자',?,?,sysdate,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, n.getNoticeTitle());
			pstmt.setString(2, n.getNoticeContent());
			pstmt.setString(3, n.getFilename());
			pstmt.setString(4, n.getFilepath());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int totalSearchCount(Connection conn, String table, String area, String value) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result=0;
		String query = "select count(*) as tot from "+table+" where "+area+" = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, value);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("tot");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Object> selectSearchListAdmin(Connection conn, int start, int end, String table, String area,
			String value) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Object> list = new ArrayList<Object>();
		String orderby = table;
		if(table.equals("perfume left join stock on (perfume_no = stock_perfume_no)")) {
			orderby = "perfume";
		}
		String query = "select * from "
						+ "(select ROWNUM as rnum, n.* from "
							+ "(select * from "+table+" where "+area+" = ? order by "+orderby+"_no desc)"
						+ " n) "
					+ "where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, value);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				switch(table){
					case "member":
						int memberNo = rset.getInt("member_no");
						String memberId = rset.getString("member_Id");
						String memberNickname = rset.getString("member_nickname");
						String memberPw = rset.getString("member_pw");
						String memberGender = rset.getString("member_gender");
						String memberBirth = rset.getString("member_birth");
						String memberPhone = rset.getString("member_phone");
						Date memberEnrollDate = rset.getDate("member_enroll_date");
						String memberValid = rset.getString("member_valid");
						Date memberDeleteDate = rset.getDate("member_delete_date");
						String memberDeleteContent = rset.getString("member_delete_content");
						Member m = new Member(memberNo, memberId, memberNickname, memberPw, memberGender, memberBirth, memberPhone, memberEnrollDate, memberValid, memberDeleteDate, memberDeleteContent);
						list.add(m);
						break;
					case "notice":
						int noticeNo = rset.getInt("notice_no");
						String noticeWriter = rset.getString("notice_writer");
						String noticeTitle = rset.getString("notice_title");
						String noticeContent = rset.getString("notice_content");
						Date noticeDate = rset.getDate("notice_date");
						String filename = rset.getString("filename");
						String filepath = rset.getString("filepath");
						Notice n = new Notice(noticeNo, noticeWriter, noticeTitle, noticeContent, noticeDate, filename, filepath);
						list.add(n);
						break;
					case "question":
						int questionNo = rset.getInt("question_No");
						String questionTitle = rset.getString("question_title");
						String questionWriter = rset.getString("question_writer");
						String questionContent = rset.getString("question_content");
						Date questionDate = rset.getDate("question_date");
						String questfilename = rset.getString("filename");
						String questfilepath = rset.getString("filepath");
						int questionLevel = rset.getInt("question_level");
						int questionRel  = rset.getInt("question_rel");
						String questionStatus = rset.getString("question_status");
						Question q = new Question(questionNo, questionTitle, questionWriter, questionContent, questionDate, questfilename, questfilepath, questionLevel, questionRel, questionStatus);
						list.add(q);
						break;
					case "perfume left join stock on (perfume_no = stock_perfume_no)":
						PerfumeAddStock p = new PerfumeAddStock();
						p.setRnum(rset.getInt("rnum"));
						p.setPerfumeNo(rset.getInt("perfume_no"));
						p.setPerfumeName(rset.getString("perfume_name"));
						p.setPerfumeBrand(rset.getString("perfume_brand"));
						p.setPerfumeVolume(rset.getInt("perfume_volume"));
						p.setPerfumeDensity(rset.getString("perfume_density"));
						p.setPerfumeTop(rset.getString("perfume_top"));
						p.setPerfumeMiddle(rset.getString("perfume_middle"));
						p.setPerfumeBase(rset.getString("perfume_base"));
						p.setPerfumeRecCount(rset.getInt("perfume_rec_count"));
						p.setPerfumeGender(rset.getString("perfume_gender"));
						p.setPerfumePrice(rset.getInt("perfume_price"));
						p.setPerfumePhotoname(rset.getString("perfume_photoname"));
						p.setPerfumePhotopath(rset.getString("perfume_photopath"));
						p.setPerfumeDetail(rset.getString("perfume_detail"));
						p.setStock(rset.getInt("stock_amount"));
						list.add(p);
						break;
					case "perfume_review":
						int perfumeReviewNo = rset.getInt("perfume_review_no");
						int revMembNo = rset.getInt("member_no");
						String revMembNick = rset.getString("member_nickname");
						int perfumeNo = rset.getInt("perfume_no");
						String perfumeReviewTitle = rset.getString("perfume_review_title");
						String perfumeReviewContent = rset.getString("perfume_review_content");
						Date perfumeReviewDate = rset.getDate("perfume_review_date");
						PerfumeReview r = new PerfumeReview(perfumeReviewNo, revMembNo, revMembNick, perfumeNo, perfumeReviewTitle, perfumeReviewContent, perfumeReviewDate);
						list.add(r);
						break;
					case "payment":
						int paymentNo = rset.getInt("payment_no");
						int paymentMemberNo = rset.getInt("payment_member_no");
						String paymentProductName = rset.getString("payment_product_name");
						String paymentShipName = rset.getString("payment_ship_name");
						String paymentShipPhone = rset.getString("payment_ship_phone");
						String paymentShipAddr = rset.getString("payment_ship_addr");
						String paymentShipMsg = rset.getString("payment_ship_msg");
						String paymentMerchantUid = rset.getString("payment_Merchant_uid");
						String paymentStatus = rset.getString("payment_Status");
						int paymentPrice = rset.getInt("payment_price");
						Date paymentDate = rset.getDate("payment_date");
						Payment pp = new Payment(paymentNo, paymentMemberNo, paymentProductName, paymentShipName, paymentShipPhone, paymentShipAddr, paymentShipMsg, paymentMerchantUid, paymentStatus, paymentPrice, paymentDate);
						list.add(pp);
						break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public ArrayList<Perfume> getAllPerfume(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Perfume> list = new ArrayList<Perfume>();
		String query = "select * from perfume";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Perfume p = new Perfume();
				p.setPerfumeNo(rset.getInt("perfume_no"));
				p.setPerfumeName(rset.getString("perfume_name"));
				p.setPerfumeBrand(rset.getString("perfume_brand"));
				p.setPerfumeVolume(rset.getInt("perfume_volume"));
				p.setPerfumeDensity(rset.getString("perfume_density"));
				p.setPerfumeTop(rset.getString("perfume_top"));
				p.setPerfumeMiddle(rset.getString("perfume_middle"));
				p.setPerfumeBase(rset.getString("perfume_base"));
				p.setPerfumeRecCount(rset.getInt("perfume_rec_count"));
				p.setPerfumeGender(rset.getString("perfume_gender"));
				p.setPerfumePrice(rset.getInt("perfume_price"));
				p.setPerfumePhotoname(rset.getString("perfume_photoname"));
				p.setPerfumePhotopath(rset.getString("perfume_photopath"));
				p.setPerfumeDetail(rset.getString("perfume_detail"));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int updateStockAdmin(Connection conn, int amount, String type, int perfumeNo) {
		PreparedStatement pstmt = null;
		int result=0;
		String query = "update stock set stock_amount = stock_amount + ? where stock_perfume_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			if(type.equals("out")) {
				pstmt.setInt(1, (-amount));				
			}else {
				pstmt.setInt(1, amount);
			}
			pstmt.setInt(2, perfumeNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int getAmount(Connection conn, int perfumeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int amount=-1;
		String query = "select * from stock where stock_perfume_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, perfumeNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				amount = rset.getInt("stock_amount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return amount;
	}

	public ArrayList<PaymentInfo> tradeInfoAdmin(Connection conn, int paymentInfoPaymentNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<PaymentInfo> list = null;
		String query = "select * from payment_info where payment_Info_Payment_No = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, paymentInfoPaymentNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				if(list == null) {
					list = new ArrayList<PaymentInfo>();
				}
				int paymentInfoNo = rset.getInt("payment_info_no");
				int paymentInfoPerfumeNo = rset.getInt("payment_Info_Perfume_No");
				String paymentInfoPerfumePhotopath = rset.getString("payment_Info_Perfume_Photopath");
				String paymentInfoPerfumeName = rset.getString("payment_Info_Perfume_Name");
				int paymentInfoPerfumeVolume = rset.getInt("payment_Info_Perfume_Volume");
				int paymentInfoBasketAmount = rset.getInt("payment_Info_Basket_Amount");
				int paymentInfoBasketPrice = rset.getInt("payment_Info_Basket_Price");
				PaymentInfo p = new PaymentInfo(paymentInfoNo, paymentInfoPaymentNo, paymentInfoPerfumeNo, paymentInfoPerfumePhotopath, paymentInfoPerfumeName, paymentInfoPerfumeVolume, paymentInfoBasketAmount, paymentInfoBasketPrice);
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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

	public int totalCountPersta(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result=0;
		String query = "select count(*) as tot from review";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("tot");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public ArrayList<Object> selectListPersta(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Object> list = null;
		String query = "select * from "
				+ "(select ROWNUM as rnum, n.* from "
					+ "(select * from review order by review_no desc)"
				+ " n) "
			+ "where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				if(list == null) {
					list = new ArrayList<Object>();
				}
				int reviewNo = rset.getInt("review_no");
				String reviewWriter = rset.getString("review_writer");
				String reviewContent = rset.getString("review_content");
				String filename = rset.getString("filename");
				String filepath = rset.getString("filepath");
				int readcount = rset.getInt("readcount");
				String hashtag = rset.getString("hashtag");
				Date reviewDate = rset.getDate("review_Date");
				Review r= new Review(reviewNo, reviewWriter, reviewContent, filename, filepath, readcount, hashtag, reviewDate);
				list.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int delPerstaAdmin(Connection conn, String reviewNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from review where review_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, reviewNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
}
