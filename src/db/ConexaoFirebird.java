package db;

import util.GeraLog;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoFirebird {

    public Connection getConnection() {
        try {
            File f = new File("AGENDA");
            f.createNewFile();
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            //lc_ctype=WIN1252  --> Necesario para a codificação da acentuação no realtorios
            //defaultResultSetHoldable=True  --> Necessario para relatorios com subrelatorios(receita) --> problema encontrado com o jaybird
            String driver = ("jdbc:firebirdsql:localhost/3050:" + f.getAbsolutePath().replace("AGENDA", "") + "SisClinicaAgenda.FDB?defaultResultSetHoldable=True;lc_ctype=WIN1252;allowMultiQueries=true");
            Connection con = DriverManager.getConnection(driver, "SYSDBA", "masterkey");
            return con;
        } catch (Exception e) {
            GeraLog g = new GeraLog();
            g.gravaErro(e);
            g.close();
            return null;
        }
    }
}
