import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class CConexion {
    Connection conectar = null;
    
    String user = "postgres";
    String password = "123";
    String port = "5432";
    String database = "ivr_db";
    String url = "localhost";
    
    String cad = "jdbc:postgresql://"+url+":"+port+"/"+database;
    
    public Connection establecerConexion(){
    
    
        try{
            Class.forName("org.postgresql.Driver");
            
            conectar = DriverManager.getConnection(cad,user,password);
            JOptionPane.showMessageDialog(null, "Se realizo la coneccion correctamente");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos, Error: "+e.toString());
        }
        return conectar;
    
    
    }



    
    
}
