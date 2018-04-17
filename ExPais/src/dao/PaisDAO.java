package dao;

	import negocio.Pais;
	import conexao.ConnectionFactory;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	public class PaisDAO {
	public void IncluirPais(Pais pais){
			String sqlInsert = "INSERT INTO pais (id, nome, area, populacao) VALUES(?, ?, ?, ?)";
			//Conexao com o banco
			try {
				
				Connection conn = ConnectionFactory.fazerConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);
				stm.setInt(1, pais.getId());
				stm.setString(2,pais.getNome());
				stm.setDouble(3,pais.getArea());
				stm.setLong(4,pais.getPopulacao());
				
				stm.execute();
				
			}catch(SQLException e) {
				
				System.out.println(e);
			}
			
	}		
		
		public void AtualizarPais(Pais pais, String checkAlter) {
			
			String sqlAlter = "";
			PreparedStatement stm = null;
			try {
				Connection conn = ConnectionFactory.fazerConexao();
			
			if (checkAlter.equals("Populacao")) {
				 sqlAlter = "UPDATE pais SET populacao= ?  WHERE id=?";
				 stm = conn.prepareStatement(sqlAlter);
				 stm.setLong(1, pais.getPopulacao());
				 stm.setInt(2, pais.getId());
				 stm.execute();
			}
			
			else if (checkAlter.equals("Area")) {
				 sqlAlter = "UPDATE pais SET area = ?  WHERE id=?";
				 stm = conn.prepareStatement(sqlAlter);
				 stm.setDouble(1, pais.getArea());
				 stm.setInt(2, pais.getId());
				 stm.execute();
			}
			
			else if(checkAlter.equals("Nome")) {
				sqlAlter = "UPDATE pais SET nome = ?  WHERE id=?";
				stm = conn.prepareStatement(sqlAlter);
				stm.setString(1, pais.getNome());
				stm.setInt(2, pais.getId());
				stm.execute();
			}
			
			}catch(SQLException e) {
				System.out.println(e);
			}
			
		}
		
		public void DeletarPais(Pais pais) {
			String sqlDelete = "DELETE from pais WHERE id = ?";
			try {
				Connection conn = ConnectionFactory.fazerConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);
				stm.setInt(1, pais.getId());
				stm.execute();
			}catch(SQLException e) {
				System.out.println(e);
			}
			
		}
		
		public void CarregarPais(Pais pais) {
			String sqlSelect = "Select nome, area, populacao FROM pais WHERE id = ?";
			try {
				Connection conn = ConnectionFactory.fazerConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);
				stm.setInt(1, pais.getId());
				
				ResultSet rs = stm.executeQuery();
				
				try {
					if(rs.next()) {
						
						pais.setNome(rs.getString("nome"));
						pais.setArea(rs.getDouble("area"));
						pais.setPopulacao(rs.getLong("populacao"));
					}else {
						pais.setId(-1);
						pais.setNome(null);
						pais.setPopulacao(0);
						pais.setArea(0);
					}
				}catch(Exception e) {
					System.out.println(e);
				}
				
			}catch(SQLException e) {
				System.out.println(e);
			}
			

		}
		
		public void getMenorArea(Pais pais) {
			try {
			String sqlQuery = "Select * from pais where area = (Select Min(area) from pais)";
			Connection conn  = ConnectionFactory.fazerConexao();
			PreparedStatement stm = conn.prepareStatement(sqlQuery);
			
			ResultSet rs = stm.executeQuery();
			
			if(rs.next()) {
				pais.setId(rs.getInt("id"));
				pais.setNome(rs.getString("nome"));
				pais.setArea(rs.getDouble("area"));
				pais.setPopulacao(rs.getLong("populacao"));
			}
			
			}catch(SQLException e) {
				
				System.out.println(e);
			}
			
		}
		
		public void getHabitantes(Pais pais) {
			try {
			String sqlQuery =  "Select * from pais where populacao = (Select Max(populacao) from pais)";
			Connection conn  = ConnectionFactory.fazerConexao();
			PreparedStatement stm = conn.prepareStatement(sqlQuery);
			
			
			ResultSet rs = stm.executeQuery();
			
			if(rs.next()) {
				pais.setId(rs.getInt("id"));
				pais.setNome(rs.getString("nome"));
				pais.setArea(rs.getDouble("area"));
				pais.setPopulacao(rs.getLong("populacao"));
			}
			
			}catch(SQLException e) {
				
				System.out.println(e);
			}
			
		}
		
		
		public String[] vetorPais() {
			
			String[] vet = new String[3];
			int cont = 0;
			
			try {
			String sqlQuery = "Select nome from pais order by nome";
			Connection conn = ConnectionFactory.fazerConexao();
			
			PreparedStatement stm = conn.prepareStatement(sqlQuery);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next() && cont < 3) {
				vet[cont] = rs.getString("nome");
				cont++;
			}
			
			}catch(SQLException e) {
				System.out.println(e);
			}
			
			return vet;
		
		}
	}

