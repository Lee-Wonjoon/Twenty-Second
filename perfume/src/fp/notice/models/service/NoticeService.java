package fp.notice.models.service;

import java.sql.Connection;
import java.util.ArrayList;

import fp.common.JDBCTemplate;
import fp.notice.models.dao.NoticeDao;
import fp.notice.models.vo.Notice;
import fp.notice.models.vo.PageData;

public class NoticeService {

	public PageData noticeList(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		NoticeDao dao = new NoticeDao();
		int numPerPage = 10; // 한 페이지당 게시글 수 
		int totalCount = dao.totalCount(conn); // 전체 게시물 수 
		//System.out.println("토탈카운트 : " + totalCount);
		int totalPage=(totalCount%numPerPage==0)?(totalPage = totalCount/numPerPage):(totalPage = totalCount/numPerPage)+1; //총 페이지
		/*if(totalCount%numPerPage==0) {
			int totalPage = totalCount/numPerPage;
		}else{
			int totalPage = (totalCount/numPerPage) + 1;
		}*/
		//System.out.println("토탈페이지 : " + totalPage);
		// 1페이지 = 1~10번 
		// 2페이지 = 11~20번 글
		int start = (reqPage-1)*numPerPage+1; // 페이지 시작 번호
		int end = reqPage*numPerPage; // 마지막 게시물 번호
		//System.out.println(start+"~"+end);
		ArrayList<Notice> list = dao.selectList(conn,start,end);
/*		for(Notice n : list) {
			System.out.println(n);
		}*/
		
		
		
		/*페이지 네비게이션 생성*/
		String pageNavi = "";// 페이지 네비 HTML을 저장하는 변수
		int pageNaviSize= 5;//페이지 넘버 수
		//페이지 넘버라는 변수는 해당 페이지의 시작번호
		int pageNo;
		if(reqPage<3) {
			pageNo = 1;
		}else if(reqPage+2>totalPage){
			pageNo= totalPage-4;
		}else {
			pageNo = reqPage-2;
		}
		//이전 버튼 생성
		//if(pageNo!=1) {
		if(pageNo!=1) {
			pageNavi += "<a class='btn' style='color:#888888;' href='/news?reqPage="+(pageNo-1)+"'>이전</a>";
		}
		int i=1;
		//i를 1부터 증가시키면서 pageNaviSize만큼 반복할 것임.
		//단, pageNo가 totalPage보다 크면 반복문을 탈출
		while(!(i++>pageNaviSize || pageNo>totalPage)) {
			if(reqPage==pageNo) {
				pageNavi +="<span class ='selectPage' style='color:black;'>"+pageNo+"</span>";
			}else {
				pageNavi +="<a class ='btn' style='color:#888888;' href='/news?reqPage="+pageNo+"'>"+pageNo+"</a>";
			}
			pageNo++;
		}
		// 이미 페이지의 끝인 10에서 ++ 한 11이 되어있을거다.
		if(pageNo<= totalPage) {
			pageNavi += "<a class='btn' style='color:#888888;' href='/news?reqPage="+(pageNo)+"'>다음</a>";
		}
		for (Notice n : list) {
			System.out.println(n.getNoticeNo() +"\t" + n.getNoticeTitle());
		}
		PageData pd = new PageData(list, pageNavi);
		
		JDBCTemplate.close(conn);
		return pd;
	}

	public Notice noticeView(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		NoticeDao dao = new NoticeDao();
		Notice n = dao.noticeView(conn, noticeNo);
		JDBCTemplate.close(conn);
		return n;
	}

}
