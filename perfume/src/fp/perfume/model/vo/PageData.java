package fp.perfume.model.vo;

import java.util.ArrayList;

public class PageData {
	private ArrayList<Perfume> list;
	private String pageNavi;
	public PageData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageData(ArrayList<Perfume> list, String pageNavi) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
	}
	public ArrayList<Perfume> getList() {
		return list;
	}
	public void setList(ArrayList<Perfume> list) {
		this.list = list;
	}
	public String getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
}
