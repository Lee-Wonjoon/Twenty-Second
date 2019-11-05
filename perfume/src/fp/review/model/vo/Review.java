package fp.review.model.vo;

import java.sql.Date;

public class Review {
	private int reviewNo;
	private String reviewWriter;
	private String reviewContent;
	private String filename;
	private String filepath;
	private int readcount;
	private String hashtag;
	private Date reviewDate;
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Review(int reviewNo, String reviewWriter, String reviewContent, String filename, String filepath,
			int readcount, String hashtag, Date reviewDate) {
		super();
		this.reviewNo = reviewNo;
		this.reviewWriter = reviewWriter;
		this.reviewContent = reviewContent;
		this.filename = filename;
		this.filepath = filepath;
		this.readcount = readcount;
		this.hashtag = hashtag;
		this.reviewDate = reviewDate;
	}
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public String getReviewWriter() {
		return reviewWriter;
	}
	public void setReviewWriter(String reviewWriter) {
		this.reviewWriter = reviewWriter;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public String getReviewContentBr() {
		
		String kkk = reviewContent.replaceAll("\r\n", "<br>");
		kkk = kkk.replaceAll("\n", "<br>");
		return kkk;
		
		/*return reviewContent.replaceAll("\n", "<br>");*/
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public String getHashtag() {
		return hashtag;
	}
	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
}