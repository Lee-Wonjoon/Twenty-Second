package fp.perfume.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import fp.common.JDBCTemplate;
import fp.perfume.model.dao.PerfumeDao;
import fp.perfume.model.vo.PageData;
import fp.perfume.model.vo.Perfume;

public class PerfumeService {

	public ArrayList<Perfume> perfumeList() {
		Connection conn = JDBCTemplate.getConnection();
		PerfumeDao dao = new PerfumeDao();
		ArrayList<Perfume> list = dao.perfumeList(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public int insertPerfume(Perfume p) {
		Connection conn = JDBCTemplate.getConnection();
		PerfumeDao dao = new PerfumeDao();
		int result = dao.insertPerfume(conn, p);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public PageData selectList(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		PerfumeDao dao = new PerfumeDao();
		int numPerPage = 16; // 한 페이지당 게시물 수
		int totalCount = dao.totalCount(conn); // 전체 게시물 수
		System.out.println("totalCount : " + totalCount);
		// 100 > 10, 101 > 11
		// 나머지가 0인 경우 : 몫, 나머지가 0이 아닌 경우 몫+1
		int totalPage = (totalCount%numPerPage == 0)?(totalCount/numPerPage):(totalCount/numPerPage)+1;
		System.out.println("totalPage : " + totalPage);
		// 1page > 1번글~10번글, 2page > 11번글~20번글
		int start = (reqPage-1)*numPerPage+1; // 페이지 시작 게시물 번호
		int end = reqPage*numPerPage; // 페이지 마지막 게시물 번호
		System.out.println("시작번호 : " + start + " / 끝번호 : " + end);
		ArrayList<Perfume> list = dao.selectList(conn, start, end);
		
		// 페이지 네비게이션 생성
		String pageNavi = ""; // 페이지 네비 html 을 저장하는 변수
		int pageNaviSize = 5; // 페이지 넘버 수
		// pageNo 는 해당 페이지 시작 번호
		// 1~5 = 1, 6~10 = 2, 11~15 = 3
		int pageNo = 0;
//		int pageNo = ( (reqPage-1)/pageNaviSize )*pageNaviSize+1;
		
		if(reqPage<3) {
			pageNo = 1;
		} else {
			pageNo = reqPage-2;
		}
		
		// 이전 버튼 생성
		if (pageNo != 1) {
			pageNavi += "<a class='btn' href = '/perfumeList?reqPage=" + (reqPage-1) + "'>◀️</a>";
		}
		int i = 1;
		// i를 1부터 증가시키면서 pageNaviSize 만큼 반복문
		// 단, pageNo 가 totalPage 보다 크면 마지막 페이지에 도달한 것이므로 반복문 수행을 멈춤
		while(! (i++>pageNaviSize || pageNo>totalPage)) {
			if(reqPage == pageNo) {
				pageNavi += "<a style='font-weight:bolder;' class='btn' href='/perfumeList?reqPage=" + pageNo + "'>" + pageNo + "</a>";
			} else {
				pageNavi += "<a style='color:gray;' class='btn' href='/perfumeList?reqPage=" + pageNo + "'>" + pageNo + "</a>";
			}
			pageNo++;
		}
		
		if(pageNo <= totalPage) {
			pageNavi += "<a class='btn' href='perfumeList?reqPage=" + pageNo + "'>▶️</a>";
		}
		
		PageData pd = new PageData(list, pageNavi);
		JDBCTemplate.close(conn);
		return pd;
	}

	public Perfume selectOne(int perfumeNo) {
		Connection conn = JDBCTemplate.getConnection();
		PerfumeDao dao = new PerfumeDao();
		Perfume perfume = dao.viewPerfume(conn, perfumeNo);
		JDBCTemplate.close(conn);
		return perfume;
		
	}

	public PageData selectList2(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		PerfumeDao dao = new PerfumeDao();
		int numPerPage = 16; // 한 페이지당 게시물 수
		int totalCount = dao.totalCount(conn); // 전체 게시물 수
		System.out.println("totalCount : " + totalCount);
		int totalPage = (totalCount%numPerPage == 0)?(totalCount/numPerPage):(totalCount/numPerPage)+1;
		System.out.println("totalPage : " + totalPage);
		int start = (reqPage-1)*numPerPage+1; // 페이지 시작 게시물 번호
		int end = reqPage*numPerPage; // 페이지 마지막 게시물 번호
		System.out.println("시작번호 : " + start + " / 끝번호 : " + end);
		ArrayList<Perfume> list = dao.selectList2(conn, start, end);
		String pageNavi = ""; // 페이지 네비 html 을 저장하는 변수
		int pageNaviSize = 5; // 페이지 넘버 수
		int pageNo = 0;
		if(reqPage<3) {
			pageNo = 1;
		} else {
			pageNo = reqPage-2;
		}
		if (pageNo != 1) {
			pageNavi += "<a class='btn' href = '/perfumeList2?reqPage=" + (reqPage-1) + "'>◀️</a>";
		}
		int i = 1;
		while(! (i++>pageNaviSize || pageNo>totalPage)) {
			if(reqPage == pageNo) {
				pageNavi += "<a style='font-weight:bolder;' class='btn' href='/perfumeList2?reqPage=" + pageNo + "'>" + pageNo + "</a>";
			} else {
				pageNavi += "<a style='color:gray;' class='btn' href='/perfumeList2?reqPage=" + pageNo + "'>" + pageNo + "</a>";
			}
			pageNo++;
		}		
		if(pageNo <= totalPage) {
			pageNavi += "<a class='btn' href='perfumeList2?reqPage=" + pageNo + "'>▶️</a>";
		}		
		PageData pd = new PageData(list, pageNavi);
		JDBCTemplate.close(conn);
		return pd;
	}

	public ArrayList<Perfume> selectTop() {
		Connection conn = JDBCTemplate.getConnection();
		PerfumeDao dao = new PerfumeDao();
		ArrayList<Perfume> list = dao.selectTop(conn);
		return list;
	}

	public PageData selectListMale(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		PerfumeDao dao = new PerfumeDao();
		int numPerPage = 16; // 한 페이지당 게시물 수
		int totalCount = dao.totalCountMale(conn); // 전체 게시물 수
		System.out.println("totalCount : " + totalCount);
		int totalPage = (totalCount%numPerPage == 0)?(totalCount/numPerPage):(totalCount/numPerPage)+1;
		System.out.println("totalPage : " + totalPage);
		int start = (reqPage-1)*numPerPage+1; // 페이지 시작 게시물 번호
		int end = reqPage*numPerPage; // 페이지 마지막 게시물 번호
		System.out.println("시작번호 : " + start + " / 끝번호 : " + end);
		ArrayList<Perfume> list = dao.selectListMale(conn, start, end);
		String pageNavi = ""; // 페이지 네비 html 을 저장하는 변수
		int pageNaviSize = 5; // 페이지 넘버 수
		int pageNo = 0;
		if(reqPage<3) {
			pageNo = 1;
		} else {
			pageNo = reqPage-2;
		}
		if (pageNo != 1) {
			pageNavi += "<a class='btn' href = '/perfumeListMale?reqPage=" + (reqPage-1) + "'>◀️</a>";
		}
		int i = 1;
		while(! (i++>pageNaviSize || pageNo>totalPage)) {
			if(reqPage == pageNo) {
				pageNavi += "<a style='font-weight:bolder;' class='btn' href='/perfumeListMale?reqPage=" + pageNo + "'>" + pageNo + "</a>";
			} else {
				pageNavi += "<a style='color:gray;' class='btn' href='/perfumeListMale?reqPage=" + pageNo + "'>" + pageNo + "</a>";
			}
			pageNo++;
		}		
		if(pageNo <= totalPage) {
			pageNavi += "<a class='btn' href='perfumeListMale?reqPage=" + pageNo + "'>▶️</a>";
		}		
		PageData pd = new PageData(list, pageNavi);
		JDBCTemplate.close(conn);
		return pd;
	}

	public PageData selectListMale2(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		PerfumeDao dao = new PerfumeDao();
		int numPerPage = 16; // 한 페이지당 게시물 수
		int totalCount = dao.totalCountMale(conn); // 전체 게시물 수
		System.out.println("totalCount : " + totalCount);
		int totalPage = (totalCount%numPerPage == 0)?(totalCount/numPerPage):(totalCount/numPerPage)+1;
		System.out.println("totalPage : " + totalPage);
		int start = (reqPage-1)*numPerPage+1; // 페이지 시작 게시물 번호
		int end = reqPage*numPerPage; // 페이지 마지막 게시물 번호
		System.out.println("시작번호 : " + start + " / 끝번호 : " + end);
		ArrayList<Perfume> list = dao.selectListMale2(conn, start, end);
		String pageNavi = ""; // 페이지 네비 html 을 저장하는 변수
		int pageNaviSize = 5; // 페이지 넘버 수
		int pageNo = 0;
		if(reqPage<3) {
			pageNo = 1;
		} else {
			pageNo = reqPage-2;
		}
		if (pageNo != 1) {
			pageNavi += "<a class='btn' href = '/perfumeListMale2?reqPage=" + (reqPage-1) + "'>◀️</a>";
		}
		int i = 1;
		while(! (i++>pageNaviSize || pageNo>totalPage)) {
			if(reqPage == pageNo) {
				pageNavi += "<a style='font-weight:bolder;' class='btn' href='/perfumeListMale2?reqPage=" + pageNo + "'>" + pageNo + "</a>";
			} else {
				pageNavi += "<a style='color:gray;' class='btn' href='/perfumeListMale2?reqPage=" + pageNo + "'>" + pageNo + "</a>";
			}
			pageNo++;
		}		
		if(pageNo <= totalPage) {
			pageNavi += "<a class='btn' href='perfumeListMale2?reqPage=" + pageNo + "'>▶️</a>";
		}		
		PageData pd = new PageData(list, pageNavi);
		JDBCTemplate.close(conn);
		return pd;
	}

	public PageData selectListFemale(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		PerfumeDao dao = new PerfumeDao();
		int numPerPage = 16; // 한 페이지당 게시물 수
		int totalCount = dao.totalCountFemale(conn); // 전체 게시물 수
		System.out.println("totalCount : " + totalCount);
		int totalPage = (totalCount%numPerPage == 0)?(totalCount/numPerPage):(totalCount/numPerPage)+1;
		System.out.println("totalPage : " + totalPage);
		int start = (reqPage-1)*numPerPage+1; // 페이지 시작 게시물 번호
		int end = reqPage*numPerPage; // 페이지 마지막 게시물 번호
		System.out.println("시작번호 : " + start + " / 끝번호 : " + end);
		ArrayList<Perfume> list = dao.selectListFemale(conn, start, end);
		String pageNavi = ""; // 페이지 네비 html 을 저장하는 변수
		int pageNaviSize = 5; // 페이지 넘버 수
		int pageNo = 0;
		if(reqPage<3) {
			pageNo = 1;
		} else {
			pageNo = reqPage-2;
		}
		if (pageNo != 1) {
			pageNavi += "<a class='btn' href = '/perfumeListFemale?reqPage=" + (reqPage-1) + "'>◀️</a>";
		}
		int i = 1;
		while(! (i++>pageNaviSize || pageNo>totalPage)) {
			if(reqPage == pageNo) {
				pageNavi += "<a style='font-weight:bolder;' class='btn' href='/perfumeListFemale?reqPage=" + pageNo + "'>" + pageNo + "</a>";
			} else {
				pageNavi += "<a style='color:gray;' class='btn' href='/perfumeListFemale?reqPage=" + pageNo + "'>" + pageNo + "</a>";
			}
			pageNo++;
		}		
		if(pageNo <= totalPage) {
			pageNavi += "<a class='btn' href='perfumeListFemale?reqPage=" + pageNo + "'>▶️</a>";
		}		
		PageData pd = new PageData(list, pageNavi);
		JDBCTemplate.close(conn);
		return pd;
	}

	public PageData selectListFemale2(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		PerfumeDao dao = new PerfumeDao();
		int numPerPage = 16; // 한 페이지당 게시물 수
		int totalCount = dao.totalCountFemale(conn); // 전체 게시물 수
		System.out.println("totalCount : " + totalCount);
		int totalPage = (totalCount%numPerPage == 0)?(totalCount/numPerPage):(totalCount/numPerPage)+1;
		System.out.println("totalPage : " + totalPage);
		int start = (reqPage-1)*numPerPage+1; // 페이지 시작 게시물 번호
		int end = reqPage*numPerPage; // 페이지 마지막 게시물 번호
		System.out.println("시작번호 : " + start + " / 끝번호 : " + end);
		ArrayList<Perfume> list = dao.selectLisFemale2(conn, start, end);
		String pageNavi = ""; // 페이지 네비 html 을 저장하는 변수
		int pageNaviSize = 5; // 페이지 넘버 수
		int pageNo = 0;
		if(reqPage<3) {
			pageNo = 1;
		} else {
			pageNo = reqPage-2;
		}
		if (pageNo != 1) {
			pageNavi += "<a class='btn' href = '/perfumeListFemale2?reqPage=" + (reqPage-1) + "'>◀️</a>";
		}
		int i = 1;
		while(! (i++>pageNaviSize || pageNo>totalPage)) {
			if(reqPage == pageNo) {
				pageNavi += "<a style='font-weight:bolder;' class='btn' href='/perfumeListFemale2?reqPage=" + pageNo + "'>" + pageNo + "</a>";
			} else {
				pageNavi += "<a style='color:gray;' class='btn' href='/perfumeListFemale2?reqPage=" + pageNo + "'>" + pageNo + "</a>";
			}
			pageNo++;
		}		
		if(pageNo <= totalPage) {
			pageNavi += "<a class='btn' href='perfumeListFemale2?reqPage=" + pageNo + "'>▶️</a>";
		}		
		PageData pd = new PageData(list, pageNavi);
		JDBCTemplate.close(conn);
		return pd;
	}

	public PageData selectListUni(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		PerfumeDao dao = new PerfumeDao();
		int numPerPage = 16; // 한 페이지당 게시물 수
		int totalCount = dao.totalCountUni(conn); // 전체 게시물 수
		System.out.println("totalCount : " + totalCount);
		int totalPage = (totalCount%numPerPage == 0)?(totalCount/numPerPage):(totalCount/numPerPage)+1;
		System.out.println("totalPage : " + totalPage);
		int start = (reqPage-1)*numPerPage+1; // 페이지 시작 게시물 번호
		int end = reqPage*numPerPage; // 페이지 마지막 게시물 번호
		System.out.println("시작번호 : " + start + " / 끝번호 : " + end);
		ArrayList<Perfume> list = dao.selectListUni(conn, start, end);
		String pageNavi = ""; // 페이지 네비 html 을 저장하는 변수
		int pageNaviSize = 5; // 페이지 넘버 수
		int pageNo = 0;
		if(reqPage<3) {
			pageNo = 1;
		} else {
			pageNo = reqPage-2;
		}
		if (pageNo != 1) {
			pageNavi += "<a class='btn' href = '/perfumeListUni?reqPage=" + (reqPage-1) + "'>◀️</a>";
		}
		int i = 1;
		while(! (i++>pageNaviSize || pageNo>totalPage)) {
			if(reqPage == pageNo) {
				pageNavi += "<a style='font-weight:bolder;' class='btn' href='/perfumeListUni?reqPage=" + pageNo + "'>" + pageNo + "</a>";
			} else {
				pageNavi += "<a style='color:gray;' class='btn' href='/perfumeListUni?reqPage=" + pageNo + "'>" + pageNo + "</a>";
			}
			pageNo++;
		}		
		if(pageNo <= totalPage) {
			pageNavi += "<a class='btn' href='perfumeListUni?reqPage=" + pageNo + "'>▶️</a>";
		}		
		PageData pd = new PageData(list, pageNavi);
		JDBCTemplate.close(conn);
		return pd;
	}

	public PageData selectListUni2(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		PerfumeDao dao = new PerfumeDao();
		int numPerPage = 16; // 한 페이지당 게시물 수
		int totalCount = dao.totalCountUni(conn); // 전체 게시물 수
		System.out.println("totalCount : " + totalCount);
		int totalPage = (totalCount%numPerPage == 0)?(totalCount/numPerPage):(totalCount/numPerPage)+1;
		System.out.println("totalPage : " + totalPage);
		int start = (reqPage-1)*numPerPage+1; // 페이지 시작 게시물 번호
		int end = reqPage*numPerPage; // 페이지 마지막 게시물 번호
		System.out.println("시작번호 : " + start + " / 끝번호 : " + end);
		ArrayList<Perfume> list = dao.selectLisUni2(conn, start, end);
		String pageNavi = ""; // 페이지 네비 html 을 저장하는 변수
		int pageNaviSize = 5; // 페이지 넘버 수
		int pageNo = 0;
		if(reqPage<3) {
			pageNo = 1;
		} else {
			pageNo = reqPage-2;
		}
		if (pageNo != 1) {
			pageNavi += "<a class='btn' href = '/perfumeListUni2?reqPage=" + (reqPage-1) + "'>◀️</a>";
		}
		int i = 1;
		while(! (i++>pageNaviSize || pageNo>totalPage)) {
			if(reqPage == pageNo) {
				pageNavi += "<a style='font-weight:bolder;' class='btn' href='/perfumeListUni2?reqPage=" + pageNo + "'>" + pageNo + "</a>";
			} else {
				pageNavi += "<a style='color:gray;' class='btn' href='/perfumeListUni2?reqPage=" + pageNo + "'>" + pageNo + "</a>";
			}
			pageNo++;
		}		
		if(pageNo <= totalPage) {
			pageNavi += "<a class='btn' href='perfumeListUni2?reqPage=" + pageNo + "'>▶️</a>";
		}		
		PageData pd = new PageData(list, pageNavi);
		JDBCTemplate.close(conn);
		return pd;
	}
	
	public ArrayList<String> viewBrand(String msg) {
		PerfumeDao dao = new PerfumeDao();
		Connection conn = JDBCTemplate.getConnection();
		msg = msg.toUpperCase();
		ArrayList<String> list = dao.viewBrand(conn, msg);
		if(list.size() == 0) {
			list.add("검색 결과가 없습니다.");
		}
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Perfume> searchAi(String[] q1, String[] q2, String[] q3, String q4, String brand, int q5, Boolean q6) {
		//서버 연결 전 모든 변수 생성(시간 감축을 위함)
		ArrayList<Perfume> list = new ArrayList<Perfume>();
		PerfumeDao dao = new PerfumeDao();
		Connection conn = JDBCTemplate.getConnection();
		//여기서 String 배열 개수를 모르니, 보내기 전 개수만큼 반복하는 메서드를 구상해야한다. 쿼리문을 반복문에 넣자.
		list = dao.searchAi(conn, q1, q2, q3, q4, brand, q5, q6);
		JDBCTemplate.close(conn);
		return list;
	}

	public PageData selectSearch(int reqPage, String selected, String inputvalue) {
		Connection conn = JDBCTemplate.getConnection();
		PerfumeDao dao = new PerfumeDao();
		int numPerPage = 16; // 한 페이지당 게시물 수
		int totalCount = dao.totalCountSearch(conn, selected, inputvalue); // 전체 게시물 수
		System.out.println("totalCount : " + totalCount);
		int totalPage = (totalCount%numPerPage == 0)?(totalCount/numPerPage):(totalCount/numPerPage)+1;
		System.out.println("totalPage : " + totalPage);
		int start = (reqPage-1)*numPerPage+1; // 페이지 시작 게시물 번호
		int end = reqPage*numPerPage; // 페이지 마지막 게시물 번호
		System.out.println("시작번호 : " + start + " / 끝번호 : " + end);
		ArrayList<Perfume> list = dao.selectSearch(conn, start, end, selected, inputvalue);
		String pageNavi = ""; // 페이지 네비 html 을 저장하는 변수
		int pageNaviSize = 5; // 페이지 넘버 수
		int pageNo = 0;
		if(reqPage<3) {
			pageNo = 1;
		} else {
			pageNo = reqPage-2;
		}
		if (pageNo != 1) {
			pageNavi += "<a class='btn' href = '/perfumeList?reqPage=" + (reqPage-1) + "'>◀️</a>";
		}
		int i = 1;
		while(! (i++>pageNaviSize || pageNo>totalPage)) {
			if(reqPage == pageNo) {
				pageNavi += "<a style='font-weight:bolder;' class='btn' href='/perfumeList?reqPage=" + pageNo + "'>" + pageNo + "</a>";
			} else {
				pageNavi += "<a style='color:gray;' class='btn' href='/perfumeList?reqPage=" + pageNo + "'>" + pageNo + "</a>";
			}
			pageNo++;
		}		
		if(pageNo <= totalPage) {
			pageNavi += "<a class='btn' href='perfumeList?reqPage=" + pageNo + "'>▶️</a>";
		}		
		PageData pd = new PageData(list, pageNavi);
		JDBCTemplate.close(conn);
		return pd;
	}

	public PageData selectSearchUni(int reqPage, String selected, String inputvalue) {
		Connection conn = JDBCTemplate.getConnection();
		PerfumeDao dao = new PerfumeDao();
		int numPerPage = 16; // 한 페이지당 게시물 수
		int totalCount = dao.totalCountSearchUni(conn, selected, inputvalue); // 전체 게시물 수
		System.out.println("totalCount : " + totalCount);
		int totalPage = (totalCount%numPerPage == 0)?(totalCount/numPerPage):(totalCount/numPerPage)+1;
		System.out.println("totalPage : " + totalPage);
		int start = (reqPage-1)*numPerPage+1; // 페이지 시작 게시물 번호
		int end = reqPage*numPerPage; // 페이지 마지막 게시물 번호
		System.out.println("시작번호 : " + start + " / 끝번호 : " + end);
		ArrayList<Perfume> list = dao.selectSearchUni(conn, start, end, selected, inputvalue);
		String pageNavi = ""; // 페이지 네비 html 을 저장하는 변수
		int pageNaviSize = 5; // 페이지 넘버 수
		int pageNo = 0;
		if(reqPage<3) {
			pageNo = 1;
		} else {
			pageNo = reqPage-2;
		}
		if (pageNo != 1) {
			pageNavi += "<a class='btn' href = '/perfumeListUni?reqPage=" + (reqPage-1) + "'>◀️</a>";
		}
		int i = 1;
		while(! (i++>pageNaviSize || pageNo>totalPage)) {
			if(reqPage == pageNo) {
				pageNavi += "<a style='font-weight:bolder;' class='btn' href='/perfumeListUni?reqPage=" + pageNo + "'>" + pageNo + "</a>";
			} else {
				pageNavi += "<a style='color:gray;' class='btn' href='/perfumeListUni?reqPage=" + pageNo + "'>" + pageNo + "</a>";
			}
			pageNo++;
		}		
		if(pageNo <= totalPage) {
			pageNavi += "<a class='btn' href='perfumeListUni?reqPage=" + pageNo + "'>▶️</a>";
		}		
		PageData pd = new PageData(list, pageNavi);
		JDBCTemplate.close(conn);
		return pd;
	}

	public PageData selectSearchFemale(int reqPage, String selected, String inputvalue) {
		Connection conn = JDBCTemplate.getConnection();
		PerfumeDao dao = new PerfumeDao();
		int numPerPage = 16; // 한 페이지당 게시물 수
		int totalCount = dao.totalCountSearchFemale(conn, selected, inputvalue); // 전체 게시물 수
		System.out.println("totalCount : " + totalCount);
		int totalPage = (totalCount%numPerPage == 0)?(totalCount/numPerPage):(totalCount/numPerPage)+1;
		System.out.println("totalPage : " + totalPage);
		int start = (reqPage-1)*numPerPage+1; // 페이지 시작 게시물 번호
		int end = reqPage*numPerPage; // 페이지 마지막 게시물 번호
		System.out.println("시작번호 : " + start + " / 끝번호 : " + end);
		ArrayList<Perfume> list = dao.selectSearchFemale(conn, start, end, selected, inputvalue);
		String pageNavi = ""; // 페이지 네비 html 을 저장하는 변수
		int pageNaviSize = 5; // 페이지 넘버 수
		int pageNo = 0;
		if(reqPage<3) {
			pageNo = 1;
		} else {
			pageNo = reqPage-2;
		}
		if (pageNo != 1) {
			pageNavi += "<a class='btn' href = '/perfumeListFemale?reqPage=" + (reqPage-1) + "'>◀️</a>";
		}
		int i = 1;
		while(! (i++>pageNaviSize || pageNo>totalPage)) {
			if(reqPage == pageNo) {
				pageNavi += "<a style='font-weight:bolder;' class='btn' href='/perfumeListFemale?reqPage=" + pageNo + "'>" + pageNo + "</a>";
			} else {
				pageNavi += "<a style='color:gray;' class='btn' href='/perfumeListFemale?reqPage=" + pageNo + "'>" + pageNo + "</a>";
			}
			pageNo++;
		}		
		if(pageNo <= totalPage) {
			pageNavi += "<a class='btn' href='perfumeListFemale?reqPage=" + pageNo + "'>▶️</a>";
		}		
		PageData pd = new PageData(list, pageNavi);
		JDBCTemplate.close(conn);
		return pd;
	}

	public PageData selectSearchMale(int reqPage, String selected, String inputvalue) {
		Connection conn = JDBCTemplate.getConnection();
		PerfumeDao dao = new PerfumeDao();
		int numPerPage = 16; // 한 페이지당 게시물 수
		int totalCount = dao.totalCountSearchMale(conn, selected, inputvalue); // 전체 게시물 수
		System.out.println("totalCount : " + totalCount);
		int totalPage = (totalCount%numPerPage == 0)?(totalCount/numPerPage):(totalCount/numPerPage)+1;
		System.out.println("totalPage : " + totalPage);
		int start = (reqPage-1)*numPerPage+1; // 페이지 시작 게시물 번호
		int end = reqPage*numPerPage; // 페이지 마지막 게시물 번호
		System.out.println("시작번호 : " + start + " / 끝번호 : " + end);
		ArrayList<Perfume> list = dao.selectSearchMale(conn, start, end, selected, inputvalue);
		String pageNavi = ""; // 페이지 네비 html 을 저장하는 변수
		int pageNaviSize = 5; // 페이지 넘버 수
		int pageNo = 0;
		if(reqPage<3) {
			pageNo = 1;
		} else {
			pageNo = reqPage-2;
		}
		if (pageNo != 1) {
			pageNavi += "<a class='btn' href = '/perfumeListMale?reqPage=" + (reqPage-1) + "'>◀️</a>";
		}
		int i = 1;
		while(! (i++>pageNaviSize || pageNo>totalPage)) {
			if(reqPage == pageNo) {
				pageNavi += "<a style='font-weight:bolder;' class='btn' href='/perfumeListMale?reqPage=" + pageNo + "'>" + pageNo + "</a>";
			} else {
				pageNavi += "<a style='color:gray;' class='btn' href='/perfumeListMale?reqPage=" + pageNo + "'>" + pageNo + "</a>";
			}
			pageNo++;
		}		
		if(pageNo <= totalPage) {
			pageNavi += "<a class='btn' href='perfumeListMale?reqPage=" + pageNo + "'>▶️</a>";
		}		
		PageData pd = new PageData(list, pageNavi);
		JDBCTemplate.close(conn);
		return pd;
	}

	public int checkPerfumeStock(int perfumeNo) {
		Connection conn = JDBCTemplate.getConnection();
		PerfumeDao dao = new PerfumeDao();
		int result = dao.checkPerfumeStock(conn, perfumeNo);
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Perfume> selectTopGender(String gender) {
		Connection conn = JDBCTemplate.getConnection();
		PerfumeDao dao = new PerfumeDao();
		ArrayList<Perfume> list = dao.selectTopGender(conn, gender);
		return list;
	}
}
