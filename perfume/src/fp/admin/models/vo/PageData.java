package fp.admin.models.vo;

import java.util.ArrayList;

public class PageData {
	private ArrayList<Object> list;
	private String pageNavi;
	//pd.getlist.get으로 사용할 때 형변환을 해야한다.;
	//pd.getlist.add할 때는 뭐가 들어가도 무관
	public PageData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageData(ArrayList<Object> list, String pageNavi) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
	}
	public ArrayList<Object> getList() {
		return list;
	}
	public void setList(ArrayList<Object> list) {
		this.list = list;
	}
	public String getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
	
}
