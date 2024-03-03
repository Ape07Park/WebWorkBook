package kcity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.mysql.cj.exceptions.RSAException;

import kcity.entity.Kcity;

public class KcityDao {
	public Connection getConnection() {
		Connection conn = null;
		try {
			// JNDI를 이용하기 위한 객체 생성: 이름으로 객체 찾기 o
			Context initContext = new InitialContext();

			// java:comp/env까지 initCtx의 lookup메서드-찾아서 넣음-
			// 를 이용해서 "java:comp/env" 에 해당하는 객체(톰캣)를 찾아서 evnCtx에 삽입
			// + 부터 envCtx의 lookup메서드를 이용해서 "jdbc/world"에 해당하는 객체(server.xml에 등록한 이름
			// world)를 찾아서 ds에 삽입

			DataSource ds = (DataSource) initContext.lookup("java:comp/env/" + "jdbc/world"); // "jdbc/world"는
																								// context.xml에서 가져온 거

			// getConnection메서드를 이용해서 커넥션 풀로 부터 커넥션 객체를 얻어내어 conn변수에 저장
			conn = ds.getConnection();

			/*
			 *  위의 코드를 아래와 같이 줄여서 작성 가능하다.  Context context = new InitialContext(); 
			 * DataSource dataSource = (DataSource) context.lookup(
			 * "java:comp/env/jdbc/oracle");             
			 * Connection con = dataSource.getConnection(); 
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public Kcity getKcityById(int id) {
		Connection conn = getConnection();
		String sql= "select * from kcity where id=?";
		Kcity kcity= null;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				kcity = new Kcity(rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getInt(5));
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kcity;
	}
	
	public List<Kcity> getKcityList() {
		Connection conn = getConnection();
		
		String sql= "select * from kcity";
		List<Kcity> list = new ArrayList<Kcity>();
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Kcity kcity = new Kcity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
				list.add(kcity);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Kcity insertKcity(Kcity kcity) {
		Connection conn = getConnection();
		String sql = "insert kcity values(default, ?, ?, ?, ?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, kcity.getName());
			pstmt.setString(2, kcity.getCountryCode());
			pstmt.setString(3, kcity.getDistrict());
			pstmt.setInt(4, kcity.getPopulation());
			
			pstmt.executeUpdate();
						
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kcity;
	}
	
	// 더 살펴보기
	public void updateKcity(int id) {
		Connection conn = getConnection();
	}
	
	public void deleteKcity(int id) {
		Connection conn = getConnection();
		String sql = "delete from kcity where id=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
