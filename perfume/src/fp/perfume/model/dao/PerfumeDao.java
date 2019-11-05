package fp.perfume.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fp.common.JDBCTemplate;

import fp.perfume.model.vo.Perfume;

public class PerfumeDao {

	public ArrayList<Perfume> perfumeList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from perfume";
		ArrayList<Perfume> list = new ArrayList<Perfume>();
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while (rset.next() ) {
				Perfume p = new Perfume();
				p.setRnum(rset.getInt("rnum"));
				p.setPerfumeNo(rset.getInt("perfume_no"));
				p.setPerfumeName(rset.getString("perfume_name"));
				p.setPerfumeBrand(rset.getString("perfume_brand"));
				p.setPerfumeVolume(rset.getInt("perfume_volume"));
				p.setPerfumeDensity(rset.getString("perfume_density"));
				p.setPerfumeTop(rset.getString("perfume_top"));
				p.setPerfumeMiddle(rset.getString("perfume_middle"));
				p.setPerfumeBase(rset.getString("perfume_base"));
				p.setPerfumeRecCount(rset.getInt("perfume_rec_count"));
				p.setPerfumeGender(rset.getString("perfume_gender"));
				p.setPerfumePrice(rset.getInt("perfume_price"));
				p.setPerfumePhotoname(rset.getString("perfume_photoname"));
				p.setPerfumePhotopath(rset.getString("perfume_photopath"));
				p.setPerfumeDetail(rset.getString("perfume_detail"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}		
		return list;
	}

	public int insertPerfume(Connection conn, Perfume p) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into perfume values (perfume_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?, 0, ?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, p.getPerfumeName());
			pstmt.setString(2, p.getPerfumeBrand());
			pstmt.setInt(3, p.getPerfumeVolume());
			pstmt.setString(4, p.getPerfumeDensity());
			pstmt.setString(5, p.getPerfumeTop());
			pstmt.setString(6, p.getPerfumeMiddle());
			pstmt.setString(7, p.getPerfumeBase());
			pstmt.setString(8, p.getPerfumeGender());
			pstmt.setInt(9, p.getPerfumePrice());
			pstmt.setString(10, p.getPerfumePhotoname());
			pstmt.setString(11, p.getPerfumePhotopath());
			pstmt.setString(12, p.getPerfumeDetail());			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}		
		return result;
	}

	public int totalCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) as total from perfume"; // as total 알기 쉽게 total 컬럼명 붙임
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt("total");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}		
		return result;
	}
	
	public int totalCountMale(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) as total from perfume where perfume_gender='male'"; // as total 알기 쉽게 total 컬럼명 붙임
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt("total");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}		
		return result;
	}
	
	public int totalCountFemale(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) as total from perfume where perfume_gender='female'"; // as total 알기 쉽게 total 컬럼명 붙임
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt("total");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}		
		return result;
	}
	
	public int totalCountUni(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) as total from perfume where perfume_gender='uni'"; // as total 알기 쉽게 total 컬럼명 붙임
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt("total");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}		
		return result;
	}

	public ArrayList<Perfume> selectList(Connection conn, int start, int end) {
		ArrayList<Perfume> list = new ArrayList<Perfume>();
		Perfume p = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from (select rownum as rnum, n.* from(select * from perfume order by perfume_no desc) n) where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				p = new Perfume();
				p.setRnum(rset.getInt("rnum"));
				p.setPerfumeNo(rset.getInt("perfume_no"));
				p.setPerfumeName(rset.getString("perfume_name"));
				p.setPerfumeBrand(rset.getString("perfume_brand"));
				p.setPerfumeVolume(rset.getInt("perfume_volume"));
				p.setPerfumeDensity(rset.getString("perfume_density"));
				p.setPerfumeTop(rset.getString("perfume_top"));
				p.setPerfumeMiddle(rset.getString("perfume_middle"));
				p.setPerfumeBase(rset.getString("perfume_base"));
				p.setPerfumeRecCount(rset.getInt("perfume_rec_count"));
				p.setPerfumeGender(rset.getString("perfume_gender"));
				p.setPerfumePrice(rset.getInt("perfume_price"));
				p.setPerfumePhotoname(rset.getString("perfume_photoname"));
				p.setPerfumePhotopath(rset.getString("perfume_photopath"));
				p.setPerfumeDetail(rset.getString("perfume_detail"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public Perfume viewPerfume(Connection conn, int perfumeNo) {
		Perfume p = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from perfume where perfume_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, perfumeNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				p = new Perfume();
				p.setPerfumeNo(rset.getInt("perfume_no"));
				p.setPerfumeName(rset.getString("perfume_name"));
				p.setPerfumeBrand(rset.getString("perfume_brand"));
				p.setPerfumeVolume(rset.getInt("perfume_volume"));
				p.setPerfumeDensity(rset.getString("perfume_density"));
				p.setPerfumeTop(rset.getString("perfume_top"));
				p.setPerfumeMiddle(rset.getString("perfume_middle"));
				p.setPerfumeBase(rset.getString("perfume_base"));
				p.setPerfumeRecCount(rset.getInt("perfume_rec_count"));
				p.setPerfumeGender(rset.getString("perfume_gender"));
				p.setPerfumePrice(rset.getInt("perfume_price"));
				p.setPerfumePhotoname(rset.getString("perfume_photoname"));
				p.setPerfumePhotopath(rset.getString("perfume_photopath"));
				p.setPerfumeDetail(rset.getString("perfume_detail"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return p;
	}

	public ArrayList<Perfume> selectList2(Connection conn, int start, int end) {
		ArrayList<Perfume> list = new ArrayList<Perfume>();
		Perfume p = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from (select rownum as rnum, n.* from(select * from perfume order by perfume_rec_count desc) n) where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				p = new Perfume();
				p.setRnum(rset.getInt("rnum"));
				p.setPerfumeNo(rset.getInt("perfume_no"));
				p.setPerfumeName(rset.getString("perfume_name"));
				p.setPerfumeBrand(rset.getString("perfume_brand"));
				p.setPerfumeVolume(rset.getInt("perfume_volume"));
				p.setPerfumeDensity(rset.getString("perfume_density"));
				p.setPerfumeTop(rset.getString("perfume_top"));
				p.setPerfumeMiddle(rset.getString("perfume_middle"));
				p.setPerfumeBase(rset.getString("perfume_base"));
				p.setPerfumeRecCount(rset.getInt("perfume_rec_count"));
				p.setPerfumeGender(rset.getString("perfume_gender"));
				p.setPerfumePrice(rset.getInt("perfume_price"));
				p.setPerfumePhotoname(rset.getString("perfume_photoname"));
				p.setPerfumePhotopath(rset.getString("perfume_photopath"));
				p.setPerfumeDetail(rset.getString("perfume_detail"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public ArrayList<Perfume> selectTop(Connection conn) {
		ArrayList<Perfume> list = new ArrayList<Perfume>();
		Perfume p = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from (select rownum as rnum, n.* from(select * from perfume order by perfume_rec_count desc) n) where rnum between 1 and 4";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				p = new Perfume();
				p.setRnum(rset.getInt("rnum"));
				p.setPerfumeNo(rset.getInt("perfume_no"));
				p.setPerfumeName(rset.getString("perfume_name"));
				p.setPerfumeBrand(rset.getString("perfume_brand"));
				p.setPerfumeVolume(rset.getInt("perfume_volume"));
				p.setPerfumeDensity(rset.getString("perfume_density"));
				p.setPerfumeTop(rset.getString("perfume_top"));
				p.setPerfumeMiddle(rset.getString("perfume_middle"));
				p.setPerfumeBase(rset.getString("perfume_base"));
				p.setPerfumeRecCount(rset.getInt("perfume_rec_count"));
				p.setPerfumeGender(rset.getString("perfume_gender"));
				p.setPerfumePrice(rset.getInt("perfume_price"));
				p.setPerfumePhotoname(rset.getString("perfume_photoname"));
				p.setPerfumePhotopath(rset.getString("perfume_photopath"));
				p.setPerfumeDetail(rset.getString("perfume_detail"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public ArrayList<Perfume> selectListMale(Connection conn, int start, int end) {
		ArrayList<Perfume> list = new ArrayList<Perfume>();
		Perfume p = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from (select rownum as rnum, n.* from(select * from perfume where perfume_gender = 'male' order by perfume_no desc) n) where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				p = new Perfume();
				p.setRnum(rset.getInt("rnum"));
				p.setPerfumeNo(rset.getInt("perfume_no"));
				p.setPerfumeName(rset.getString("perfume_name"));
				p.setPerfumeBrand(rset.getString("perfume_brand"));
				p.setPerfumeVolume(rset.getInt("perfume_volume"));
				p.setPerfumeDensity(rset.getString("perfume_density"));
				p.setPerfumeTop(rset.getString("perfume_top"));
				p.setPerfumeMiddle(rset.getString("perfume_middle"));
				p.setPerfumeBase(rset.getString("perfume_base"));
				p.setPerfumeRecCount(rset.getInt("perfume_rec_count"));
				p.setPerfumeGender(rset.getString("perfume_gender"));
				p.setPerfumePrice(rset.getInt("perfume_price"));
				p.setPerfumePhotoname(rset.getString("perfume_photoname"));
				p.setPerfumePhotopath(rset.getString("perfume_photopath"));
				p.setPerfumeDetail(rset.getString("perfume_detail"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public ArrayList<Perfume> selectListMale2(Connection conn, int start, int end) {
		ArrayList<Perfume> list = new ArrayList<Perfume>();
		Perfume p = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from (select rownum as rnum, n.* from(select * from perfume where perfume_gender = 'male' order by perfume_rec_count desc) n) where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				p = new Perfume();
				p.setRnum(rset.getInt("rnum"));
				p.setPerfumeNo(rset.getInt("perfume_no"));
				p.setPerfumeName(rset.getString("perfume_name"));
				p.setPerfumeBrand(rset.getString("perfume_brand"));
				p.setPerfumeVolume(rset.getInt("perfume_volume"));
				p.setPerfumeDensity(rset.getString("perfume_density"));
				p.setPerfumeTop(rset.getString("perfume_top"));
				p.setPerfumeMiddle(rset.getString("perfume_middle"));
				p.setPerfumeBase(rset.getString("perfume_base"));
				p.setPerfumeRecCount(rset.getInt("perfume_rec_count"));
				p.setPerfumeGender(rset.getString("perfume_gender"));
				p.setPerfumePrice(rset.getInt("perfume_price"));
				p.setPerfumePhotoname(rset.getString("perfume_photoname"));
				p.setPerfumePhotopath(rset.getString("perfume_photopath"));
				p.setPerfumeDetail(rset.getString("perfume_detail"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public ArrayList<Perfume> selectListFemale(Connection conn, int start, int end) {
		ArrayList<Perfume> list = new ArrayList<Perfume>();
		Perfume p = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from (select rownum as rnum, n.* from(select * from perfume where perfume_gender = 'female' order by perfume_no desc) n) where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				p = new Perfume();
				p.setRnum(rset.getInt("rnum"));
				p.setPerfumeNo(rset.getInt("perfume_no"));
				p.setPerfumeName(rset.getString("perfume_name"));
				p.setPerfumeBrand(rset.getString("perfume_brand"));
				p.setPerfumeVolume(rset.getInt("perfume_volume"));
				p.setPerfumeDensity(rset.getString("perfume_density"));
				p.setPerfumeTop(rset.getString("perfume_top"));
				p.setPerfumeMiddle(rset.getString("perfume_middle"));
				p.setPerfumeBase(rset.getString("perfume_base"));
				p.setPerfumeRecCount(rset.getInt("perfume_rec_count"));
				p.setPerfumeGender(rset.getString("perfume_gender"));
				p.setPerfumePrice(rset.getInt("perfume_price"));
				p.setPerfumePhotoname(rset.getString("perfume_photoname"));
				p.setPerfumePhotopath(rset.getString("perfume_photopath"));
				p.setPerfumeDetail(rset.getString("perfume_detail"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public ArrayList<Perfume> selectLisFemale2(Connection conn, int start, int end) {
		ArrayList<Perfume> list = new ArrayList<Perfume>();
		Perfume p = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from (select rownum as rnum, n.* from(select * from perfume where perfume_gender = 'female' order by perfume_rec_count desc) n) where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				p = new Perfume();
				p.setRnum(rset.getInt("rnum"));
				p.setPerfumeNo(rset.getInt("perfume_no"));
				p.setPerfumeName(rset.getString("perfume_name"));
				p.setPerfumeBrand(rset.getString("perfume_brand"));
				p.setPerfumeVolume(rset.getInt("perfume_volume"));
				p.setPerfumeDensity(rset.getString("perfume_density"));
				p.setPerfumeTop(rset.getString("perfume_top"));
				p.setPerfumeMiddle(rset.getString("perfume_middle"));
				p.setPerfumeBase(rset.getString("perfume_base"));
				p.setPerfumeRecCount(rset.getInt("perfume_rec_count"));
				p.setPerfumeGender(rset.getString("perfume_gender"));
				p.setPerfumePrice(rset.getInt("perfume_price"));
				p.setPerfumePhotoname(rset.getString("perfume_photoname"));
				p.setPerfumePhotopath(rset.getString("perfume_photopath"));
				p.setPerfumeDetail(rset.getString("perfume_detail"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
	public ArrayList<Perfume> selectListUni(Connection conn, int start, int end) {
		ArrayList<Perfume> list = new ArrayList<Perfume>();
		Perfume p = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from (select rownum as rnum, n.* from(select * from perfume where perfume_gender = 'uni' order by perfume_no desc) n) where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				p = new Perfume();
				p.setRnum(rset.getInt("rnum"));
				p.setPerfumeNo(rset.getInt("perfume_no"));
				p.setPerfumeName(rset.getString("perfume_name"));
				p.setPerfumeBrand(rset.getString("perfume_brand"));
				p.setPerfumeVolume(rset.getInt("perfume_volume"));
				p.setPerfumeDensity(rset.getString("perfume_density"));
				p.setPerfumeTop(rset.getString("perfume_top"));
				p.setPerfumeMiddle(rset.getString("perfume_middle"));
				p.setPerfumeBase(rset.getString("perfume_base"));
				p.setPerfumeRecCount(rset.getInt("perfume_rec_count"));
				p.setPerfumeGender(rset.getString("perfume_gender"));
				p.setPerfumePrice(rset.getInt("perfume_price"));
				p.setPerfumePhotoname(rset.getString("perfume_photoname"));
				p.setPerfumePhotopath(rset.getString("perfume_photopath"));
				p.setPerfumeDetail(rset.getString("perfume_detail"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public ArrayList<Perfume> selectLisUni2(Connection conn, int start, int end) {
		ArrayList<Perfume> list = new ArrayList<Perfume>();
		Perfume p = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from (select rownum as rnum, n.* from(select * from perfume where perfume_gender = 'uni' order by perfume_rec_count desc) n) where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				p = new Perfume();
				p.setRnum(rset.getInt("rnum"));
				p.setPerfumeNo(rset.getInt("perfume_no"));
				p.setPerfumeName(rset.getString("perfume_name"));
				p.setPerfumeBrand(rset.getString("perfume_brand"));
				p.setPerfumeVolume(rset.getInt("perfume_volume"));
				p.setPerfumeDensity(rset.getString("perfume_density"));
				p.setPerfumeTop(rset.getString("perfume_top"));
				p.setPerfumeMiddle(rset.getString("perfume_middle"));
				p.setPerfumeBase(rset.getString("perfume_base"));
				p.setPerfumeRecCount(rset.getInt("perfume_rec_count"));
				p.setPerfumeGender(rset.getString("perfume_gender"));
				p.setPerfumePrice(rset.getInt("perfume_price"));
				p.setPerfumePhotoname(rset.getString("perfume_photoname"));
				p.setPerfumePhotopath(rset.getString("perfume_photopath"));
				p.setPerfumeDetail(rset.getString("perfume_detail"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
	public ArrayList<String> viewBrand(Connection conn, String msg) {
	      ArrayList<String> list = new ArrayList<String>();
	      String query = "select distinct perfume_brand from perfume where perfume_brand like ?";
	      PreparedStatement pstat = null;
	      ResultSet rset = null;
	      try {
	         pstat = conn.prepareStatement(query);
	         pstat.setString(1, msg+"%");
	         rset = pstat.executeQuery();
	         while(rset.next()) {
	            list.add(rset.getString(1));
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return list;
	   }


	   public ArrayList<Perfume> searchAi(Connection conn, String[] q1, String[] q2, String[] q3, String q4,
	         String brand, int q5, Boolean q6) {
	      ArrayList<Perfume> list = new ArrayList<Perfume>();
	      //쿼리문을 반복문에 넣자.
	      StringBuilder query = new StringBuilder();
	      //select * from perfume where perfume_density = 2 and perfume_brand = 'VINCE CAMUTO' and perfume_price < 100000 and  perfume_top like '%베르가못%' and perfume_top like '%럼주%' and perfume_top like '%바질%' and perfume_middle like '%라벤더%' and perfume_middle like '%블랙페퍼%' and perfume_middle like '%클라리세이지%' and perfume_base like '%베티버%' and perfume_base like '%페츌리%' and perfume_base like '%우드%' order by perfume_rec_count DESC;
	      query.append("select * from perfume where perfume_price < ?");
	      if(brand != null && !brand.equals("")) {
	          query.append(" and perfume_brand = ?");
	      }
	      //TopNote 쿼리 작성
	      if(q1!=null)
	      for(int i = 0; i < q1.length; i++) {
	         query.append(" and perfume_top like ?");
	      }
	      //MiddleNote 쿼리 작성
	      if(q2!=null)
	      for(int i = 0; i < q2.length; i++) {
	         query.append(" and perfume_middle like ?");
	      }
	      //BaseNote 쿼리 작성
	      if(q3!=null)
	      for(int i = 0; i < q3.length; i++) {
	         query.append(" and perfume_base like ?");
	      }
	      //추천수 정렬
	      if(q6) {
	         query.append(" order by perfume_rec_count DESC");
	      }else {
	         query.append(" order by perfume_rec_count ASC");
	      }
	      PreparedStatement pstat = null;
	      ResultSet rset = null;
	      try {
	         pstat = conn.prepareStatement(query.toString());
	         pstat.setInt(1, q5);
	         int j = 2;
	         if(brand != null && !brand.equals("")) {
	            pstat.setString(j, brand);
	            j++;
	         }
	         if(q1!=null) {
	            for(int i = 0; i < q1.length; i++) {
	               pstat.setString(j+i, "%"+q1[i]+"%");
	            }
	            j+=q1.length;
	         }
	         if(q2!=null) {
	            for(int i = 0; i < q2.length; i++) {
	               pstat.setString(j+i, "%"+q2[i]+"%");
	            }
	            j+=q2.length;
	         }
	         if(q3!=null)
	         for(int i = 0 ; i < q3.length; i++) {
	            pstat.setString(j+i, "%"+q3[i]+"%");
	         }
	         rset = pstat.executeQuery();
	         for(int i = 0; i < 8; i++) {
	            if(!rset.next()) {
	               break;
	            }
	            Perfume p = new Perfume();
	            p.setPerfumeNo(rset.getInt(1));
	            p.setPerfumeName(rset.getString(2));
	            p.setPerfumeBrand(brand);
	            p.setPerfumeVolume(rset.getInt(4));
	            p.setPerfumeDensity(q4);
	            p.setPerfumeTop(rset.getString(6));
	            p.setPerfumeMiddle(rset.getString(7));
	            p.setPerfumeBase(rset.getString(8));
	            p.setPerfumeRecCount(rset.getInt(9));
	            p.setPerfumeGender(rset.getString(10));
	            p.setPerfumePrice(rset.getInt(11));
	            p.setPerfumePhotoname(rset.getString(12));
	            p.setPerfumePhotopath(rset.getString(13));
	            p.setPerfumeDetail(rset.getString(14));
	            list.add(p);
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return list;
	   }

	public int totalCountSearch(Connection conn, String selected, String inputvalue) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		inputvalue = "'" + inputvalue + "%'";
		String query = "select count(*) as total from perfume where " + selected + " like " + inputvalue;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt("total");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Perfume> selectSearch(Connection conn, int start, int end, String selected, String inputvalue) {
		ArrayList<Perfume> list = new ArrayList<Perfume>();
		Perfume p = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		inputvalue = "%" + inputvalue.toUpperCase() + "%";
		String query = "select * from (select rownum as rnum, n.* from(select * from perfume where " + selected + " like ?) n) where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, inputvalue);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				p = new Perfume();
				p.setRnum(rset.getInt("rnum"));
				p.setPerfumeNo(rset.getInt("perfume_no"));
				p.setPerfumeName(rset.getString("perfume_name"));
				p.setPerfumeBrand(rset.getString("perfume_brand"));
				p.setPerfumeVolume(rset.getInt("perfume_volume"));
				p.setPerfumeDensity(rset.getString("perfume_density"));
				p.setPerfumeTop(rset.getString("perfume_top"));
				p.setPerfumeMiddle(rset.getString("perfume_middle"));
				p.setPerfumeBase(rset.getString("perfume_base"));
				p.setPerfumeRecCount(rset.getInt("perfume_rec_count"));
				p.setPerfumeGender(rset.getString("perfume_gender"));
				p.setPerfumePrice(rset.getInt("perfume_price"));
				p.setPerfumePhotoname(rset.getString("perfume_photoname"));
				p.setPerfumePhotopath(rset.getString("perfume_photopath"));
				p.setPerfumeDetail(rset.getString("perfume_detail"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int totalCountSearchUni(Connection conn, String selected, String inputvalue) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		inputvalue = "'" + inputvalue + "%'";
		String gender = "'uni'";
		String query = "select count(*) as total from perfume where " + selected + " like " + inputvalue + " and perfume_gender = " + gender;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt("total");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Perfume> selectSearchUni(Connection conn, int start, int end, String selected, String inputvalue) {
		ArrayList<Perfume> list = new ArrayList<Perfume>();
		Perfume p = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		inputvalue = inputvalue + "%";
		String gender = "uni";
		String query = "select * from (select rownum as rnum, n.* from(select * from perfume where " + selected + " like ?) n) where rnum between ? and ? and perfume_gender = 'uni'";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, inputvalue);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				p = new Perfume();
				p.setRnum(rset.getInt("rnum"));
				p.setPerfumeNo(rset.getInt("perfume_no"));
				p.setPerfumeName(rset.getString("perfume_name"));
				p.setPerfumeBrand(rset.getString("perfume_brand"));
				p.setPerfumeVolume(rset.getInt("perfume_volume"));
				p.setPerfumeDensity(rset.getString("perfume_density"));
				p.setPerfumeTop(rset.getString("perfume_top"));
				p.setPerfumeMiddle(rset.getString("perfume_middle"));
				p.setPerfumeBase(rset.getString("perfume_base"));
				p.setPerfumeRecCount(rset.getInt("perfume_rec_count"));
				p.setPerfumeGender(rset.getString("perfume_gender"));
				p.setPerfumePrice(rset.getInt("perfume_price"));
				p.setPerfumePhotoname(rset.getString("perfume_photoname"));
				p.setPerfumePhotopath(rset.getString("perfume_photopath"));
				p.setPerfumeDetail(rset.getString("perfume_detail"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int totalCountSearchFemale(Connection conn, String selected, String inputvalue) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		inputvalue = "'" + inputvalue + "%'";
		String gender = "'female'";
		String query = "select count(*) as total from perfume where " + selected + " like " + inputvalue + " and perfume_gender = " + gender;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt("total");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Perfume> selectSearchFemale(Connection conn, int start, int end, String selected, String inputvalue) {
		ArrayList<Perfume> list = new ArrayList<Perfume>();
		Perfume p = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		inputvalue = inputvalue + "%";
		String query = "select * from (select rownum as rnum, n.* from(select * from perfume where " + selected + " like ?) n) where rnum between ? and ? and perfume_gender = 'female'";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, inputvalue);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				p = new Perfume();
				p.setRnum(rset.getInt("rnum"));
				p.setPerfumeNo(rset.getInt("perfume_no"));
				p.setPerfumeName(rset.getString("perfume_name"));
				p.setPerfumeBrand(rset.getString("perfume_brand"));
				p.setPerfumeVolume(rset.getInt("perfume_volume"));
				p.setPerfumeDensity(rset.getString("perfume_density"));
				p.setPerfumeTop(rset.getString("perfume_top"));
				p.setPerfumeMiddle(rset.getString("perfume_middle"));
				p.setPerfumeBase(rset.getString("perfume_base"));
				p.setPerfumeRecCount(rset.getInt("perfume_rec_count"));
				p.setPerfumeGender(rset.getString("perfume_gender"));
				p.setPerfumePrice(rset.getInt("perfume_price"));
				p.setPerfumePhotoname(rset.getString("perfume_photoname"));
				p.setPerfumePhotopath(rset.getString("perfume_photopath"));
				p.setPerfumeDetail(rset.getString("perfume_detail"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int totalCountSearchMale(Connection conn, String selected, String inputvalue) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		inputvalue = "'" + inputvalue + "%'";
		String gender = "'male'";
		String query = "select count(*) as total from perfume where " + selected + " like " + inputvalue + " and perfume_gender = " + gender;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt("total");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Perfume> selectSearchMale(Connection conn, int start, int end, String selected,
			String inputvalue) {
		ArrayList<Perfume> list = new ArrayList<Perfume>();
		Perfume p = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		inputvalue = inputvalue + "%";
		String query = "select * from (select rownum as rnum, n.* from(select * from perfume where " + selected + " like ?) n) where rnum between ? and ? and perfume_gender = 'male'";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, inputvalue);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				p = new Perfume();
				p.setRnum(rset.getInt("rnum"));
				p.setPerfumeNo(rset.getInt("perfume_no"));
				p.setPerfumeName(rset.getString("perfume_name"));
				p.setPerfumeBrand(rset.getString("perfume_brand"));
				p.setPerfumeVolume(rset.getInt("perfume_volume"));
				p.setPerfumeDensity(rset.getString("perfume_density"));
				p.setPerfumeTop(rset.getString("perfume_top"));
				p.setPerfumeMiddle(rset.getString("perfume_middle"));
				p.setPerfumeBase(rset.getString("perfume_base"));
				p.setPerfumeRecCount(rset.getInt("perfume_rec_count"));
				p.setPerfumeGender(rset.getString("perfume_gender"));
				p.setPerfumePrice(rset.getInt("perfume_price"));
				p.setPerfumePhotoname(rset.getString("perfume_photoname"));
				p.setPerfumePhotopath(rset.getString("perfume_photopath"));
				p.setPerfumeDetail(rset.getString("perfume_detail"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int checkPerfumeStock(Connection conn, int perfumeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select stock_amount from stock where stock_perfume_no = " + perfumeNo; // as total 알기 쉽게 total 컬럼명 붙임
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt("stock_amount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}		
		return result;
	}

	public ArrayList<Perfume> selectTopGender(Connection conn, String gender) {
		ArrayList<Perfume> list = new ArrayList<Perfume>();
		Perfume p = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		gender = "'" + gender + "'";
		String query = "select * from (select rownum as rnum, n.* from(select * from perfume where perfume_gender =" + gender +" order by perfume_rec_count desc) n) where rnum between 1 and 4";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				p = new Perfume();
				p.setRnum(rset.getInt("rnum"));
				p.setPerfumeNo(rset.getInt("perfume_no"));
				p.setPerfumeName(rset.getString("perfume_name"));
				p.setPerfumeBrand(rset.getString("perfume_brand"));
				p.setPerfumeVolume(rset.getInt("perfume_volume"));
				p.setPerfumeDensity(rset.getString("perfume_density"));
				p.setPerfumeTop(rset.getString("perfume_top"));
				p.setPerfumeMiddle(rset.getString("perfume_middle"));
				p.setPerfumeBase(rset.getString("perfume_base"));
				p.setPerfumeRecCount(rset.getInt("perfume_rec_count"));
				p.setPerfumeGender(rset.getString("perfume_gender"));
				p.setPerfumePrice(rset.getInt("perfume_price"));
				p.setPerfumePhotoname(rset.getString("perfume_photoname"));
				p.setPerfumePhotopath(rset.getString("perfume_photopath"));
				p.setPerfumeDetail(rset.getString("perfume_detail"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
}
