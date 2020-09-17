package kr.or.connect.cardMangement.dao;

import java.sql.*;

import kr.or.connect.cardMangement.carddto.Card;

public class CardDao {
	
	private static String url = "jdbc:mysql://localhost:3306/connectdb?serverTimezone=UTC";
	private static String user = "connectuser";
	private static String password = "connect123!@#";
	
	public void addCard(Card card) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "INSERT INTO card (name,phone,compony) values(?,?,?)";
		try(Connection conn = DriverManager.getConnection(url,user,password);
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, card.getName());
			ps.setString(2, card.getPhone());
			ps.setString(3, card.getCompony());
			ps.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public Card searchCard(String name) {
		Card card = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		ResultSet rs =null;
		String sql = "SELECT name, phone, compony from card where name = ?";
		try(Connection conn = DriverManager.getConnection(url,user,password);
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, name);
			rs = ps.executeQuery();
			if(rs.next()) {
				card = new Card(rs.getString(1),rs.getString(2),rs.getString(3));
			}else {
				return null;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return card;
	}
	public void deleteCard(String name) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "DELETE FROM card where name =? ";
		try(Connection conn = DriverManager.getConnection(url,user,password);
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1,name);
			System.out.println("삭제 : "+name+"의 명함");
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
