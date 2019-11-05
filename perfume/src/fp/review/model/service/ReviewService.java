package fp.review.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import fp.common.JDBCTemplate;
import fp.review.model.dao.ReviewDao;
import fp.review.model.vo.Review;
import fp.review.model.vo.ReviewComment;
import fp.review.model.vo.ReviewRecommend;
import fp.review.model.vo.ReviewViewData;

public class ReviewService {

	public int insertReview(Review r) {
		Connection conn = JDBCTemplate.getConnection();
		ReviewDao dao = new ReviewDao();
		int result = dao.insertReview(conn,r);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Review> selectAll() {
		Connection conn = JDBCTemplate.getConnection();
		ReviewDao dao = new ReviewDao();
		ArrayList<Review> list = dao.selectAll(conn);
		JDBCTemplate.close(conn);
		return list;
	}
	
	public ArrayList<Review> selectRecommend() {
		Connection conn = JDBCTemplate.getConnection();
		ReviewDao dao = new ReviewDao();
		ArrayList<Review> list = dao.selectRecommend(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Review> selectSearch(String search) {
		Connection conn = JDBCTemplate.getConnection();
		ReviewDao dao = new ReviewDao();
		ArrayList<Review> list = dao.selectSearch(conn,search);
		JDBCTemplate.close(conn);
		return list;
	}
	
	public int updateReview(Review r) {
		Connection conn = JDBCTemplate.getConnection();
		ReviewDao dao = new ReviewDao();
		int result = dao.updateReview(conn,r);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;		
	}

	public int deleteReview(int reviewNo) {
		Connection conn = JDBCTemplate.getConnection();
		ReviewDao dao = new ReviewDao();
		int result = dao.deleteReview(conn,reviewNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;		
	}

	public int deleteReviewComment(int reviewCommentNo) {
		Connection conn = JDBCTemplate.getConnection();
		ReviewDao dao = new ReviewDao();
		int result = dao.deleteReviewComment(conn, reviewCommentNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int insertReviewComment(ReviewComment nc) {
		Connection conn = JDBCTemplate.getConnection();
		ReviewDao dao = new ReviewDao();
		int result = dao.insertReviewComment(conn, nc);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateReviewComment(int reviewCommentNo, String reviewCommentContent) {
		Connection conn = JDBCTemplate.getConnection();
		ReviewDao dao = new ReviewDao();
		int result = dao.updateReviewComment(conn, reviewCommentNo, reviewCommentContent);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int insertReviewRecommend(int reviewNo, int memberNo) {
		Connection conn = JDBCTemplate.getConnection();
		ReviewDao dao = new ReviewDao();
		int result = dao.insertReviewRecommend(conn, reviewNo, memberNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateReadCount(int reviewNo,int cnt) {
		Connection conn = JDBCTemplate.getConnection();
		ReviewDao dao = new ReviewDao();
		int result = dao.updateReadCount(conn, reviewNo, cnt);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteReviewRecommend(int reviewNo, int memberNo) {
		Connection conn = JDBCTemplate.getConnection();
		ReviewDao dao = new ReviewDao();
		int result = dao.deleteReviewRecommend(conn, reviewNo, memberNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public ReviewViewData selectOne(int reviewNo) {
		Connection conn= JDBCTemplate.getConnection();
		ReviewDao dao = new ReviewDao();
		Review r = dao.selectOne(conn,reviewNo);
		ArrayList<ReviewComment> list = dao.selectReviewCommentList(conn,reviewNo);
		if(r !=null) {
			JDBCTemplate.commit(conn);				
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		ReviewViewData rvd =  new ReviewViewData(r,list);
		return rvd;
	}

	public ArrayList<ReviewComment> commentList(int reviewRef) {
		Connection conn = JDBCTemplate.getConnection();
		ReviewDao dao = new ReviewDao();
		ArrayList<ReviewComment> list = dao.commentList(conn,reviewRef);
		JDBCTemplate.close(conn);
		return list;
	}

	public int updateRecommendPlus(int reviewNo) {
		Connection conn = JDBCTemplate.getConnection();
		ReviewDao dao = new ReviewDao();
		int result = dao.updateRecommendPlus(conn, reviewNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int insertRecommendInfo(int reviewNo, int memberNo) {
		Connection conn = JDBCTemplate.getConnection();
		ReviewDao dao = new ReviewDao();
		int result = dao.insertRecommendInfo(conn, reviewNo, memberNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteRecommendInfo(int reviewNo, int memberNo) {
		Connection conn = JDBCTemplate.getConnection();
		ReviewDao dao = new ReviewDao();
		int result = dao.deleteRecommendInfo(conn, reviewNo, memberNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateRecommendMinus(int reviewNo) {
		Connection conn = JDBCTemplate.getConnection();
		ReviewDao dao = new ReviewDao();
		int result = dao.updateRecommendMinus(conn, reviewNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<ReviewRecommend> RecommendList(int reviewNo) {
		Connection conn = JDBCTemplate.getConnection();
		ReviewDao dao = new ReviewDao();
		ArrayList<ReviewRecommend> list = dao.RecommendList(conn, reviewNo);
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<ReviewRecommend> selectRecommendAll() {
		Connection conn = JDBCTemplate.getConnection();
		ReviewDao dao = new ReviewDao();
		ArrayList<ReviewRecommend> list = dao.RecommendListAll(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<ReviewComment> selectCommentAll() {
		Connection conn = JDBCTemplate.getConnection();
		ReviewDao dao = new ReviewDao();
		ArrayList<ReviewComment> list = dao.selectCommentAll(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public int selectCommentNo() {
		Connection conn = JDBCTemplate.getConnection();
		ReviewDao dao = new ReviewDao();
		int result = dao.selectCommentNo(conn);
		JDBCTemplate.close(conn);
		return result;
	}
}
