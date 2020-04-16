package fp.mypage.model.vo;

import java.util.ArrayList;

import fp.CS.models.vo.Question;

public class QuestionData {
	private ArrayList<Question> list;
	private int memberNo;
	public QuestionData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ArrayList<Question> getList() {
		return list;
	}
	public void setList(ArrayList<Question> list) {
		this.list = list;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public QuestionData(ArrayList<Question> list, int memberNo) {
		super();
		this.list = list;
		this.memberNo = memberNo;
	}
	
}
