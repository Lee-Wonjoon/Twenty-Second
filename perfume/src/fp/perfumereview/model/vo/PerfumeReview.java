package fp.perfumereview.model.vo;

import java.sql.Date;

public class PerfumeReview {
	private int perfumeReviewNo;
	private int memberNo;
	private String memberNickname;
	private int perfumeNo;
	private String perfumeReviewTitle;
	private String perfumeReviewContent;
	private Date perfumeReviewDate;
	public PerfumeReview() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PerfumeReview(int perfumeReviewNo, int memberNo, String memberNickname, int perfumeNo,
			String perfumeReviewTitle, String perfumeReviewContent, Date perfumeReviewDate) {
		super();
		this.perfumeReviewNo = perfumeReviewNo;
		this.memberNo = memberNo;
		this.memberNickname = memberNickname;
		this.perfumeNo = perfumeNo;
		this.perfumeReviewTitle = perfumeReviewTitle;
		this.perfumeReviewContent = perfumeReviewContent;
		this.perfumeReviewDate = perfumeReviewDate;
	}
	public int getPerfumeReviewNo() {
		return perfumeReviewNo;
	}
	public void setPerfumeReviewNo(int perfumeReviewNo) {
		this.perfumeReviewNo = perfumeReviewNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberNickname() {
		return memberNickname;
	}
	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}
	public int getPerfumeNo() {
		return perfumeNo;
	}
	public void setPerfumeNo(int perfumeNo) {
		this.perfumeNo = perfumeNo;
	}
	public String getPerfumeReviewTitle() {
		return perfumeReviewTitle;
	}
	public void setPerfumeReviewTitle(String perfumeReviewTitle) {
		this.perfumeReviewTitle = perfumeReviewTitle;
	}
	public String getPerfumeReviewContent() {
		return perfumeReviewContent;
	}
	public void setPerfumeReviewContent(String perfumeReviewContent) {
		this.perfumeReviewContent = perfumeReviewContent;
	}
	public Date getPerfumeReviewDate() {
		return perfumeReviewDate;
	}
	public void setPerfumeReviewDate(Date perfumeReviewDate) {
		this.perfumeReviewDate = perfumeReviewDate;
	}
	
}
