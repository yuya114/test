import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySqlConnector {
	public void DbConnet(){
		Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

		//jdbc:mysql://localhost/データベース名 (自分のパソコン内のDBに接続する場合)
		String url = "jdbc:mysql://localhost/test1?useSSL=false";
		String user = "root";
		String password = "root";

        try {
            // JDBCドライバのロード - JDBC4.0（JDK1.6）以降は不要
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // MySQLに接続
            con = DriverManager.getConnection(url, user, password);
            System.out.println("MySQLに接続できました。");

            pstmt = con.prepareStatement("select * from mvcTest");

            rs = pstmt.executeQuery();

            while (rs.next()) {
            	System.out.println(rs.getInt("id"));
                System.out.println(rs.getInt("kokugo"));
                System.out.println(rs.getInt("sansuu"));
                System.out.println(rs.getInt("rika"));
            }

        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            System.out.println("JDBCドライバのロードに失敗しました。");
        } catch (SQLException e) {
            System.out.println("MySQLに接続できませんでした。");
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println("MySQLのクローズに失敗しました。");
                }
            }
        }
	}
}
