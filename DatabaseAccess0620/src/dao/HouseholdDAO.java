package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Household;

public class HouseholdDAO {

	public static Household searchDao(int key){
		//①準備
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Household result =null;


		try {
			// ②JDBCドライバをロードする
			Class.forName("com.mysql.jdbc.Driver");

			// ③DBMSとの接続を確立する
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/dbdb?useSSL=false",
					"root",
					"1104");

			// ④SQL文を作成する
			String sql = "SELECT * FROM pokemon where Number= ? ;";

			// ⑤SQL文を実行するための準備を行う
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,key);

			// ⑥SQL文を実行してDBMSから結果を受信する
			rs = pstmt.executeQuery();

			// ⑦実行結果を含んだインスタンスからデータを取り出す
			while(rs.next() == true){
				//ResultSetからデータを取得する
				int Number = rs.getInt("Number");
				String Name = rs.getString("Name");
				String Type1 = rs.getString("Type1");
				String Type2 = rs.getString("Type2");
				int Rare = rs.getInt("Rare");
				//result = new HouseholdServlet(Number,Name,Type1,Type2,Rare);

			}

		} catch (ClassNotFoundException e) {
			System.out.println("JDBCドライバが見つかりません。");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		} finally {
			// ⑧DBMSから切断する
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
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

		return result;
	}


	public static Household deleteDao(int keyN){
		//①準備
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Household result =null;


		try {
			// ②JDBCドライバをロードする
			Class.forName("com.mysql.jdbc.Driver");

			// ③DBMSとの接続を確立する
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/dbdb?useSSL=false",
					"root",
					"1104");

			// ④SQL文を作成する
			String sql = "delete from pokemon where Number = ? ;";

			// ⑤SQL文を実行するための準備を行う
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,keyN);

			// ⑥SQL文を実行してDBMSから結果を受信する
			pstmt.executeUpdate();



		} catch (ClassNotFoundException e) {
			System.out.println("JDBCドライバが見つかりません。");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		} finally {
			// ⑧DBMSから切断する
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
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

		return result;
	}

	public static int registerDao(int keyA,String key,String key1,String key2,String key3,String key4){
		//①準備
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;


		try {
			// ②JDBCドライバをロードする
			Class.forName("com.mysql.jdbc.Driver");

			// ③DBMSとの接続を確立する
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/dbdb?useSSL=false",
					"root",
					"1104");

			// ④SQL文を作成する
			String sql = "insert into pokemon(Number,Name,Type1,Type2,Rare) VALUE(?,?,?,?,?)  ;";

			// ⑤SQL文を実行するための準備を行う
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,keyA);
			pstmt.setString(2,key1);
			pstmt.setString(3,key2);
			pstmt.setString(4,key3);
			pstmt.setString(5,key4);
			result = pstmt.executeUpdate();

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

		return result;
	}

	public static int newDataDAO(int key1,String key2,int key3,int key4,int key5,String key6){
		//①準備
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;


		try {
			// ②JDBCドライバをロードする
			Class.forName("com.mysql.jdbc.Driver");

			// ③DBMSとの接続を確立する
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/dbdb?useSSL=false",
					"root",
					"1104");

			// ④SQL文を作成する
			String sql = "insert into Homehold(number,date,income,specting,balanceg,type) VALUE(?,?,?,?,?,?)  ;";

			// ⑤SQL文を実行するための準備を行う
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,key1);
			pstmt.setString(2,key2);
			pstmt.setInt(3,key3);
			pstmt.setInt(4,key4);
			pstmt.setInt(5,key5);
			pstmt.setString(6,key6);
			result = pstmt.executeUpdate();

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

		return result;
	}






}
