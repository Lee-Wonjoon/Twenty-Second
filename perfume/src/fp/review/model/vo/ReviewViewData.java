package fp.review.model.vo;

import java.util.ArrayList;

public class ReviewViewData {
	private Review r;
	private ArrayList<ReviewComment> list;
	public ReviewViewData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReviewViewData(Review r, ArrayList<ReviewComment> list) {
		super();
		this.r = r;
		this.list = list;
	}
	public Review getR() {
		return r;
	}
	public void setR(Review r) {
		this.r = r;
	}
	public ArrayList<ReviewComment> getList() {
		return list;
	}
	public void setList(ArrayList<ReviewComment> list) {
		this.list = list;
	}
}
