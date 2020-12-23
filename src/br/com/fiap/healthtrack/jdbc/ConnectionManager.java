package br.com.fiap.healthtrack.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {

	private static ConnectionManager connectionManager;

	private ConnectionManager() {
	}

	public static ConnectionManager getInstance() {
		if (connectionManager == null) {
			connectionManager = new ConnectionManager();
			
		}
		return connectionManager;
	}


    public static Connection obterConexao() {
        Connection conexao = null;
        try {

          Class.forName("oracle.jdbc.driver.OracleDriver");
          	
          conexao = DriverManager.getConnection(
              "jdbc:oracle:thin:@localhost:1521:xe", "system", "oracma99");
          
//          System.out.println("Conectou HT " + conexao);
        } catch (Exception e) {
          e.printStackTrace();
        }
        return conexao;
      }
   
}
