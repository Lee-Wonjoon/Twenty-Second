package fp.review.model.vo;

import java.sql.Date;

public class ReviewComment {
	private int reviewCommentNo;
	private String reviewCommentWriter;
	private String reviewCommentContent;
	private int reviewRef;
	private String reviewCommentDate;
	public ReviewComment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ReviewComment(int reviewCommentNo, String reviewCommentWriter, String reviewCommentContent, int reviewRef,
			String reviewCommentDate) {
		super();
		this.reviewCommentNo = reviewCommentNo;
		this.reviewCommentWriter = reviewCommentWriter;
		this.reviewCommentContent = reviewCommentContent;
		this.reviewRef = reviewRef;
		this.reviewCommentDate = reviewCommentDate;
	}
	public int getReviewCommentNo() {
		return reviewCommentNo;
	}
	public void setReviewCommentNo(int reviewCommentNo) {
		this.reviewCommentNo = reviewCommentNo;
	}
	public String getReviewCommentWriter() {
		return reviewCommentWriter;
	}
	public void setReviewCommentWriter(String reviewCommentWriter) {
		this.reviewCommentWriter = reviewCommentWriter;
	}
	public String getReviewCommentContent() {
		return reviewCommentContent;
	}
	public void setReviewCommentContent(String reviewCommentContent) {
		this.reviewCommentContent = reviewCommentContent;
	}
	public int getReviewRef() {
		return reviewRef;
	}
	public void setReviewRef(int reviewRef) {
		this.reviewRef = reviewRef;
	}
	public String getReviewCommentDate() {
		return reviewCommentDate;
	}
	public void setReviewCommentDate(String reviewCommentDate) {
		this.reviewCommentDate = reviewCommentDate;
	}
}
