package Model;
import java.sql.Connection;
import java.sql.DriverManager;
public class Conexao {
    public Connection conectar(){
        Connection con = null;
        System.out.println("Conectando...");
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/crud","root", "");
            System.out.println("Conectado");
        }
        
        catch(Exception e){
            System.out.println("Falha na Conexão");
            System.out.println(e.getMessage());
        }
        return con;
    }
}

