import java.sql.*;
public class sqlconnect {
	public Connection connect() {
		Connection db= null;
		try {
			db = DriverManager.getConnection("jdbc:postgresql://localhost/jdbctest", "postgres", "2099");
			if(db!=null)
				System.out.println("Connected!");
			
			/*ResultSet rs = st.executeQuery("SELECT * FROM test");
			*/
			}catch(Exception e) {
				System.out.println(e);
			}
		return db;
	}
	public static void main(String[] args) {
		sqlconnect connection = new sqlconnect();
		Connection con = connection.connect();
		Statement st;
		String query="";
		try {
		st = con.createStatement();
		query="Insert into test values('FUCK')";
		System.out.println(st.executeUpdate(query));
		//ResultSet rs = st.executeQuery("SELECT * FROM test");
		/*while (rs.next()) {
		    System.out.print("Column 1 returned ");
		    System.out.println(rs.getString(1));
		}*/
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
