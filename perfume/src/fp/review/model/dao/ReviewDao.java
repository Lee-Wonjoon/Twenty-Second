package fp.review.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fp.common.JDBCTemplate;
import fp.review.model.vo.Review;
import fp.review.model.vo.ReviewComment;
import fp.review.model.vo.ReviewRecommend;

public class ReviewDao {

	public int insertReview(Connection conn, Review r) {
		PreparedStatement pstmt=null;
		int result = 0;
		String query="insert into review values(review_no_seq.nextval,?,?,?,?,?,?,sysdate)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, r.getReviewWriter());
			pstmt.setString(2, r.getReviewContent());
			pstmt.setString(3, r.getFilename());
			pstmt.setString(4, r.getFilepath());
			pstmt.setInt(5, r.getReadcount());
			pstmt.setString(6, r.getHashtag());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			
		}
		return result;
	}

	public ArrayList<Review> selectAll(Connection conn) {
		ArrayList<Review> list = new ArrayList<Review>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query="select * from review order by review_no desc";
		try {
			pstmt=conn.prepareStatement(query);
			rset= pstmt.executeQuery();
			while(rset.next()) {
				int reviewNo=rset.getInt("review_no");
				String reviewWriter=rset.getString("review_writer");
				String reviewContent=rset.getString("review_content");
				String filename=rset.getString("filename");
				String filepath=rset.getString("filepath");
				int readcount=rset.getInt("readcount");
				String hashtag=rset.getString("hashtag");
				Date reviewDate=rset.getDate("review_date");
				Review r = new Review(reviewNo, reviewWriter, reviewContent, filename, filepath, readcount, hashtag, reviewDate);
				list.add(r);
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

	public ArrayList<Review> selectSearch(Connection conn, String search) {
		ArrayList<Review> list = new ArrayList<Review>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query="select * from review where hashtag like ?";
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, "%"+search+"%");
			rset= pstmt.executeQuery();
			while(rset.next()) {
				int reviewNo=rset.getInt("review_no");
				String reviewWriter=rset.getString("review_writer");
				String reviewContent=rset.getString("review_content");
				String filename=rset.getString("filename");
				String filepath=rset.getString("filepath");
				int readcount=rset.getInt("readcount");
				String hashtag=rset.getString("hashtag");
				Date reviewDate=rset.getDate("review_date");
				Review r = new Review(reviewNo, reviewWriter, reviewContent, filename, filepath, readcount, hashtag, reviewDate);
				list.add(r);
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
	
	public int updateReview(Connection conn, Review r) {
		PreparedStatement pstmt = null;
		int result=0;
		String query="update review set review_content=?,filename=?,filepath=?,hashtag=? where review_no=?";
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, r.getReviewContent());
			pstmt.setString(2, r.getFilename());
			pstmt.setString(3, r.getFilepath());
			pstmt.setString(4, r.getHashtag());
			pstmt.setInt(5, r.getReviewNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteReview(Connection conn, int reviewNo) {
		PreparedStatement pstmt = null;
		int result=0;
		String query="delete from review where review_no=?";
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, reviewNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int insertReviewComment(Connection conn, ReviewComment nc) {
		PreparedStatement pstmt =null;
		int result=0;
		String query = "insert into review_comment(REVIEW_COMMENT_NO,REVIEW_COMMENT_WRITER,REVIEW_COMMENT_CONTENT,REVIEW_REF,REVIEW_COMMENT_DATE) values(review_comment_no_seq.nextval,?,?,?,sysdate)";
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, nc.getReviewCommentWriter());
			pstmt.setString(2, nc.getReviewCommentContent());
			pstmt.setInt(3, nc.getReviewRef());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int updateReviewComment(Connection conn, int reviewCommentNo, String reviewCommentContent) {
		PreparedStatement pstmt = null;
		int result=0;
		String query = "update review_comment set review_comment_content=? where review_comment_no=?";
		try {
			pstmt= conn.prepareStatement(query);
			pstmt.setString(1, reviewCommentContent);
			pstmt.setInt(2, reviewCommentNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int deleteReviewComment(Connection conn, int reviewCommentNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from review_comment where review_comment_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, reviewCommentNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int insertReviewRecommend(Connection conn, int reviewNo,int memberNo) {
		PreparedStatement pstmt = null;
		int result=0;
		String query = "insert into REVIEW_RECOMMAND values(?,?,null)";
		try {
			pstmt= conn.prepareStatement(query);
			pstmt.setInt(1, reviewNo);
			pstmt.setInt(2, memberNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateReadCount(Connection conn, int reviewNo, int cnt) {
		PreparedStatement pstmt = null;
		int result=0;
		String query = "update review set readcount=? where review_no=?";
		try {
			pstmt= conn.prepareStatement(query);
			pstmt.setInt(1, cnt);
			pstmt.setInt(2, reviewNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteReviewRecommend(Connection conn, int reviewNo, int memberNo) {
		PreparedStatement pstmt = null;
		int result=0;
		String query = "delete from REVIEW_RECOMMAND where review_No = ?";
		try {
			pstmt= conn.prepareStatement(query);
			pstmt.setInt(1, reviewNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public Review selectOne(Connection conn, int reviewNo) {
		PreparedStatement pstmt=null;
		ResultSet rset = null;
		Review r =null;
		String query ="select * from review where review_no=? ";
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, reviewNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				int reviewNo2 = rset.getInt("review_no");
				String reviewWriter = rset.getString("review_writer");
				String reviewContent = rset.getString("review_content");
				String filename = rset.getString("filename");
				String filepath = rset.getString("filepath");
				int readcount = rset.getInt("readcount");
				String hashtag = rset.getString("hashtag");
				Date reviewDate = rset.getDate("review_date");
				r = new Review(reviewNo2, reviewWriter, reviewContent, filename, filepath, 0, hashtag, reviewDate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return r;
	}

	public ArrayList<ReviewComment> selectReviewCommentList(Connection conn, int reviewNo) {
		PreparedStatement pstmt =null;
		ResultSet rset = null;
		ArrayList<ReviewComment> list = new ArrayList<ReviewComment>();
		String query = "select * from review_comment where review_ref=?";
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, reviewNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				ReviewComment nc = new ReviewComment();
				nc.setReviewCommentContent(rset.getString("review_comment_content"));
				//nc.setReviewCommentDate(rset.getDate("review_comment_date"));
				nc.setReviewCommentNo(rset.getInt("review_comment_no"));
				nc.setReviewCommentWriter(rset.getString("review_comment_writer"));
				nc.setReviewRef(rset.getInt("review_ref"));
				list.add(nc);
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

	public ArrayList<ReviewComment> commentList(Connection conn, int reviewRef) {
		PreparedStatement pstmt =null;
		ResultSet rset = null;
		ArrayList<ReviewComment> list = new ArrayList<ReviewComment>();
		String query = "select review_comment_content,to_char(review_comment_date,'YYYY-MM-DD') AS review_comment_date,review_comment_no,review_comment_writer,review_ref from review_comment where review_ref=?";
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, reviewRef);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				ReviewComment nc = new ReviewComment();
				nc.setReviewCommentContent(rset.getString("review_comment_content"));
				nc.setReviewCommentDate(rset.getString("review_comment_date"));
				nc.setReviewCommentNo(rset.getInt("review_comment_no"));
				nc.setReviewCommentWriter(rset.getString("review_comment_writer"));
				nc.setReviewRef(rset.getInt("review_ref"));
				list.add(nc);
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

	public int updateRecommendPlus(Connection conn, int reviewNo) {
		PreparedStatement pstmt = null;
		int result=0;
		String query = "update review set readcount=readcount+1 where review_no=?";
		try {
			pstmt= conn.prepareStatement(query);
			pstmt.setInt(1, reviewNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int insertRecommendInfo(Connection conn, int reviewNo, int memberNo) {
		PreparedStatement pstmt = null;
		int result=0;
		String query = "insert into REVIEW_RECOMMEND values(?,?,sysdate)";
		try {
			pstmt= conn.prepareStatement(query);
			pstmt.setInt(1, reviewNo);
			pstmt.setInt(2, memberNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteRecommendInfo(Connection conn, int reviewNo, int memberNo) {
		PreparedStatement pstmt = null;
		int result=0;
		String query = "delete from REVIEW_RECOMMEND where review_No=? and member_No = ?";
		try {
			pstmt= conn.prepareStatement(query);
			pstmt.setInt(1, reviewNo);
			pstmt.setInt(2, memberNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateRecommendMinus(Connection conn, int reviewNo) {
		PreparedStatement pstmt = null;
		int result=0;
		String query = "update review set readcount=readcount-1 where review_no=?";
		try {
			pstmt= conn.prepareStatement(query);
			pstmt.setInt(1, reviewNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public ArrayList<ReviewRecommend> RecommendList(Connection conn,int reviewNo) {
		ArrayList<ReviewRecommend> list = new ArrayList<ReviewRecommend>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query="select * from REVIEW_RECOMMEND where review_No = ?";
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, reviewNo);
			rset= pstmt.executeQuery();
			while(rset.next()) {
				int rNo=rset.getInt("review_no");
				int memberNo = rset.getInt("member_no");
				Date recomDate = rset.getDate("recommend_date") ;
				ReviewRecommend rr = new ReviewRecommend(rNo, memberNo, recomDate);
				list.add(rr);
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

	public ArrayList<Review> selectRecommend(Connection conn) {
		ArrayList<Review> list = new ArrayList<Review>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query="select * from review order by readcount desc";
		try {
			pstmt=conn.prepareStatement(query);
			rset= pstmt.executeQuery();
			while(rset.next()) {
				int reviewNo=rset.getInt("review_no");
				String reviewWriter=rset.getString("review_writer");
				String reviewContent=rset.getString("review_content");
				String filename=rset.getString("filename");
				String filepath=rset.getString("filepath");
				int readcount=rset.getInt("readcount");
				String hashtag=rset.getString("hashtag");
				Date reviewDate=rset.getDate("review_date");
				Review r = new Review(reviewNo, reviewWriter, reviewContent, filename, filepath, readcount, hashtag, reviewDate);
				list.add(r);
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

	public ArrayList<ReviewRecommend> RecommendListAll(Connection conn) {
		ArrayList<ReviewRecommend> list = new ArrayList<ReviewRecommend>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query="select * from REVIEW_RECOMMEND";
		try {
			pstmt=conn.prepareStatement(query);
			rset= pstmt.executeQuery();
			while(rset.next()) {
				int rNo=rset.getInt("review_no");
				int memberNo = rset.getInt("member_no");
				Date recomDate = rset.getDate("recommend_date") ;
				ReviewRecommend rr = new ReviewRecommend(rNo, memberNo, recomDate);
				list.add(rr);
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

	public ArrayList<ReviewComment> selectCommentAll(Connection conn) {
		ArrayList<ReviewComment> list = new ArrayList<ReviewComment>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query="select REVIEW_COMMENT_NO,REVIEW_COMMENT_WRITER,REVIEW_COMMENT_CONTENT,REVIEW_REF,REVIEW_COMMENT_DATE from REVIEW_COMMENT";
		try {
			pstmt=conn.prepareStatement(query);
			rset= pstmt.executeQuery();
			while(rset.next()) {
				int cNo = rset.getInt("REVIEW_COMMENT_NO") ;
				String comWriter=rset.getString("REVIEW_COMMENT_WRITER");
				String comContent= rset.getString("REVIEW_COMMENT_CONTENT");
				int comRNo = rset.getInt("REVIEW_REF") ;
				String date = rset.getString("REVIEW_COMMENT_DATE");
				ReviewComment rc = new ReviewComment(cNo, comWriter, comContent, comRNo, date);
				list.add(rc);
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

	public int selectCommentNo(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query="SELECT max(REVIEW_COMMENT_NO) keep(DENSE_RANK FIRST ORDER BY REVIEW_COMMENT_NO desc) as REVIEW_COMMENT_NO FROM REVIEW_COMMENT";
		try {
			pstmt=conn.prepareStatement(query);
			rset= pstmt.executeQuery();
			while(rset.next()) {
				int cNo = rset.getInt("REVIEW_COMMENT_NO") ;
				result = cNo;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
}
