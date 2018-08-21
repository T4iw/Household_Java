package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Household;

public class HouseholdDAO {



	public static void newDataDAO(int key1,String key2,int key3,int key4,int key5,String key6){
		//①準備
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			// ②JDBCドライバをロードする
			Class.forName("com.mysql.jdbc.Driver");

			// ③DBMSとの接続を確立する
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/dbdb?useSSL=false",
					"root",
					"1104");

			// ④SQL文を作成する
			String sql = "insert into homehold(number,date,income,spending,balanceg,type) VALUES(?,?,?,?,?,?);";

			// ⑤SQL文を実行するための準備を行う
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,key1);
			pstmt.setString(2,key2);
			pstmt.setInt(3,key3);
			pstmt.setInt(4,key4);
			pstmt.setInt(5,key5);
			pstmt.setString(6,key6);
			pstmt.executeUpdate();

			// ⑥SQL文を実行してDBMSから結果を受信する



		} catch (ClassNotFoundException e) {
			System.out.println("JDBCドライバが見つかりません。");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
	}


	public static ArrayList<Household> getAllData(){
		ArrayList<Household> resultList = new ArrayList<Household>();
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/dbdb?useSSL=false",
					"root",
					"1104");

			String sql ="select*from homehold;";

			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while(rs.next()==true){
				int number = rs.getInt("number");
				String date = rs.getString("date");
				int income = rs.getInt("income");
				int spending = rs.getInt("spending");
				int balanceg = rs.getInt("balanceg");
				String type = rs.getString("type");
				resultList.add(new Household(number,date,income,spending,balanceg,type));
			}
			}catch (ClassNotFoundException e) {
				System.out.println("JDBCドライバが見つかりません。");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			} finally {

				try {
					if (pstmt != null) {
						pstmt.close();
					}
				} catch (SQLException e) {
					System.out.println("DBアクセス時にエラーが発生しました。");
					e.printStackTrace();
				}
				try {
					if (con != null) {
						con.close();
					}
				} catch (SQLException e) {
					System.out.println("DBアクセス時にエラーが発生しました。");
					e.printStackTrace();
				}
			}
		return resultList;
		}
}
