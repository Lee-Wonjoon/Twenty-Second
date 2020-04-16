package fp.member.model.vo;

import java.sql.Date;

public class Member {
	private int memberNo;
	private String memberId;
	private String memberNickname;
	private String memberPw;
	private String memberGender;
	private String memberBirth;
	private String memberPhone;
	private Date memberEnrollDate;
	private String memberValid;
	private Date memberDeleteDate;
	private String memberDeleteContent;
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Member(int memberNo, String memberId, String memberNickname, String memberPw, String memberGender,
			String memberBirth, String memberPhone, Date memberEnrollDate, String memberValid, Date memberDeleteDate,
			String memberDeleteContent) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberNickname = memberNickname;
		this.memberPw = memberPw;
		this.memberGender = memberGender;
		this.memberBirth = memberBirth;
		this.memberPhone = memberPhone;
		this.memberEnrollDate = memberEnrollDate;
		this.memberValid = memberValid;
		this.memberDeleteDate = memberDeleteDate;
		this.memberDeleteContent = memberDeleteContent;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberNickname() {
		return memberNickname;
	}
	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}
	public String getMemberBirth() {
		return memberBirth;
	}
	public void setMemberBirth(String memberBirth) {
		this.memberBirth = memberBirth;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public Date getMemberEnrollDate() {
		return memberEnrollDate;
	}
	public void setMemberEnrollDate(Date memberEnrollDate) {
		this.memberEnrollDate = memberEnrollDate;
	}
	public String getMemberValid() {
		return memberValid;
	}
	public void setMemberValid(String memberValid) {
		this.memberValid = memberValid;
	}
	public Date getMemberDeleteDate() {
		return memberDeleteDate;
	}
	public void setMemberDeleteDate(Date memberDeleteDate) {
		this.memberDeleteDate = memberDeleteDate;
	}
	public String getMemberDeleteContent() {
		return memberDeleteContent;
	}
	public void setMemberDeleteContent(String memberDeleteContent) {
		this.memberDeleteContent = memberDeleteContent;
	}
	
	
	
}
