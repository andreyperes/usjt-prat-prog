package conexao;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class ConnectionFactory {
		static {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		
		//Verificacao
		public static Connection fazerConexao(){
			try {
				return DriverManager.getConnection("jdbc:mysql://localhost/mydb1?user=root&password=jamal");
			}catch(SQLException e) {
					System.out.println(e);
					}
			return null;
				}
	}

