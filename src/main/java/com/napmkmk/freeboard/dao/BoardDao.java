package com.napmkmk.freeboard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.napmkmk.freeboard.dto.BoardDto;

public class BoardDao {
	
	static String driverName = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/serverdb";
	static String user = "root";
	static String pass = "12345";
	
	/*글쓰기 리스트 함수*/
	public void write(String bname, String btitle, String bcontent) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO freeboard(bname, btitle, bcontent, bhit) "
				+ "VALUES ('"+bname+"','"+btitle+"','"+bcontent+"',0)";
		
		try {
			Class.forName(driverName); // jdbc 드라이버 로딩
			conn = DriverManager.getConnection(url, user, pass);//DB 연동 커넥션 생성
			pstmt = conn.prepareStatement(sql);//sql 객체 생성
			
			pstmt.executeUpdate();//sql 실행
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn !=null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/*리스트 만드는 함수*/
	public ArrayList<BoardDto> list() { // 매게변수가 없다. ArrayList 부를때 임포트 해야함.
		
		String sql ="SELECT * FROM freeboard ORDER BY bid DESC"; // 조건이 없으므로 freeboard 에 있는 정보를 모두 가져와라. ORDER BY DESC는 오름차순
		
		/*리스트 생성*/
		ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null ; //SELECT 일때만 필요한 클래스 ResultSet 
		
		try {
			Class.forName(driverName); // jdbc 드라이버 로딩
			conn = DriverManager.getConnection(url, user, pass);//DB 연동 커넥션 생성
			pstmt = conn.prepareStatement(sql);//sql 객체 생성
			
			rs = pstmt.executeQuery();//sql 실행
			 
			while(rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				String bdate = rs.getString("bdate");
				int bhit =rs.getInt("bhit");
				
				BoardDto dto = new BoardDto(bid, bname, btitle, bcontent, bdate, bhit); // 밑에 대신 이거써도 됨. 생성자 만든걸 불러오기.
//				dto.setBid(bid);
//				dto.setBname(bname);
//				dto.setBtitle(btitle);
//				dto.setBcontent(bcontent);
//				dto.setBdate(bdate);
//				dto.setBhit(bhit);
				dtos.add(dto); // 빈배열에 하나씩 넣기
				
			}
			
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if(rs !=null) {
						rs.close();
					}
					if(pstmt != null) {
						pstmt.close();
					}
					if(conn !=null) {
						conn.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		return dtos; // 여기 중요함
		
	}
	
	/*특정글 내용 가져오기*/
public BoardDto content_view(String boardNum) { 
		
		String sql = "SELECT * FROM freeboard WHERE bid=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;//select 문이 반환하는 데이터를 담는 객체 선언
		BoardDto dto = null;
		
		try {
			Class.forName(driverName); // jdbc 드라이버 로딩
			conn = DriverManager.getConnection(url, user, pass);//DB 연동 커넥션 생성
			pstmt = conn.prepareStatement(sql);//sql 객체 생성
			pstmt.setString(1, boardNum);
			
			rs = pstmt.executeQuery();//sql 실행
			
			if(rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				String bdate = rs.getString("bdate");
				int bhit = rs.getInt("bhit");
				
				dto = new BoardDto(bid, bname, btitle, bcontent, bdate, bhit);							
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}	
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn !=null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return dto;
	}
/*특정번호 글의 내용 수정하기*/
	public void modify(String bname, String btitle, String bcontent, String bid) {
		String sql = "UPDATE * FROM freeboard WHERE bid=?";
	};
	
}
