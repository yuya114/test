public class test1 {

	public static void main(String[] args) {
//		int kokugo = 75;
//		int sansu = 80;
//		int rika = 90;
//		int syakai = 50;


		MySqlConnector sqlConnector = new MySqlConnector();

		sqlConnector.DbConnet();

		test2 te = new test2();

		te.setKokugo(75);
		te.setRika(80);
		te.setSansu(79);
		te.setSyakai(60);

	}
}