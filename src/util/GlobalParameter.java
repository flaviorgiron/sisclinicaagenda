package util;
import db.ConexaoFirebird;
import java.sql.Connection;
import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public final class GlobalParameter {

    private static GlobalParameter instance = null;
    private static String caminhoAplicacao;
    private static Connection conn;

    public static GlobalParameter getInstance() {
        try {
            if (instance == null) {
                instance = new GlobalParameter();
                conn = new ConexaoFirebird().getConnection();
            }
            return instance;
        } catch (Exception e) {
            GeraLog g = new GeraLog();
            g.gravaErro(e);
            g.close();
            return null;
        }
    }

    public static Connection getConn() {
        return conn;
    }

    public static String getCaminhoAplicacao() {
        return caminhoAplicacao;
    }

    public static Integer getDiaSemana() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        return calendar.get(GregorianCalendar.DAY_OF_WEEK);
    }

    public static void setCaminhoAplicacao(String aCaminhoAplicacao) {
        caminhoAplicacao = aCaminhoAplicacao;
    }

    private GlobalParameter() {
    }

    public String getDataSistema() {
        try {
            return DateFormat.getDateInstance().format(new Date());
        } catch (Exception e) {
            return null;
        }
    }
}
