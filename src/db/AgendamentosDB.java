package db;

import model.Agendamento;
import util.GlobalParameter;
import util.GeraLog;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AgendamentosDB {

    public static ArrayList<Agendamento> buscaAgendamentos(Date dataSelecionada, String filtro) {
        Connection con = GlobalParameter.getInstance().getConn();
        try {
            ArrayList<Agendamento> agendamentos = new ArrayList<>();
            Statement stmt = con.createStatement();
            String sql;
            DateFormat formato = new SimpleDateFormat("yyyy/MM/dd");

            if (filtro.equals("TODAS AGENDAS")) {
                sql = "SELECT * FROM AGENDAMENTOS WHERE DATA = ' " + formato.format(dataSelecionada) + " ' ORDER BY AGENDA ASC, DATA ASC, HORA ASC";
            } else if (filtro.equals("EVALDO DE ARAÚJO SANCHEZ")) {
                sql = "SELECT * FROM AGENDAMENTOS WHERE AGENDA = 'EVALDO DE ARAÚJO SANCHEZ' AND DATA = ' " + formato.format(dataSelecionada) + " ' ORDER BY AGENDA ASC, DATA ASC, HORA ASC";
            } else if (filtro.equals("RICARDO DE ARAUJO SANCHEZ")) {
                sql = "SELECT * FROM AGENDAMENTOS WHERE AGENDA = 'RICARDO DE ARAUJO SANCHEZ' AND DATA = ' " + formato.format(dataSelecionada) + " ' ORDER BY AGENDA ASC, DATA ASC, HORA ASC";
            } else if (filtro.equals("RICHARD CREVELARO")) {
                sql = "SELECT * FROM AGENDAMENTOS WHERE AGENDA = 'RICHARD CREVELARO' AND DATA = ' " + formato.format(dataSelecionada) + " ' ORDER BY AGENDA ASC, DATA ASC, HORA ASC";
            } else if (filtro.equals("TARCÍSIO ALMODOVA")) {
                sql = "SELECT * FROM AGENDAMENTOS WHERE AGENDA = 'TARCÍSIO ALMODOVA' AND DATA = ' " + formato.format(dataSelecionada) + " ' ORDER BY AGENDA ASC, DATA ASC, HORA ASC";
            } else {
                sql = "SELECT * FROM AGENDAMENTOS WHERE AGENDA = 'MAPA/HOLTER' AND DATA = ' " + formato.format(dataSelecionada) + " ' ORDER BY AGENDA ASC, DATA ASC, HORA ASC";
            }
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Agendamento a = new Agendamento();
                a.setCodigo(rs.getInt("CODIGO"));
                a.setData(rs.getDate("DATA"));
                a.setExame(rs.getString("MOTIVO"));
                a.setHora(rs.getTime("HORA").toString().substring(0, rs.getTime("HORA").toString().length() - 3));
                a.setAgenda(rs.getString("AGENDA"));
                a.setObservacao(rs.getString("OBSERVACAO"));
                a.setPaciente(rs.getString("PACIENTE"));
                a.setSecretaria(rs.getString("SECRETARIA"));
                a.setPacienteChegou(rs.getString("PACIENTECHEGOU"));
                a.setPacienteEmAtendimento(rs.getString("PACIENTEEMATENDIMENTO"));
                a.setValorPago(rs.getDouble("VALORPAGO"));
                a.setFormaPagamento(rs.getString("FORMADEPAGAMENTO"));

                agendamentos.add(a);
            }
            return agendamentos;
        } catch (SQLException | NumberFormatException e) {
            GeraLog g = new GeraLog();
            g.gravaErro(e);
            g.close();
            return null;
        }
    }

    public static boolean insertOrUpdate(Agendamento a) {
        Connection conn = GlobalParameter.getConn();
        try {
            Statement stmt = conn.createStatement();

            DateFormat formato = new SimpleDateFormat("yyyy/MM/dd");

            String sql = "UPDATE OR INSERT INTO AGENDAMENTOS (CODIGO, DATA, HORA, MEDICO, PACIENTE, EXAME, OBSERVACAO, SECRETARIA) VALUES ("
                    + a.getCodigo()
                    + ",'"
                    + formato.format(a.getData())
                    + "','"
                    + a.getHora()
                    + "','"
                    + a.getAgenda()
                    + "','"
                    + a.getPaciente()
                    + "','"
                    + a.getExame()
                    + "','"
                    + a.getObservacao()
                    + "','"
                    + a.getSecretaria() + "')";

            int res = stmt.executeUpdate(sql);
            return res == 1;
        } catch (SQLException | NumberFormatException e) {
            GeraLog g = new GeraLog();
            g.gravaErro(e);
            g.close();
            return false;
        }
    }

//    public static Bico buscaBico(Integer seqBico) {
//        Connection conn = GlobalParameter.getConn();
//        try {
//            Bico b = new Bico();
//            Statement stmt = conn.createStatement();
//            String sql = "SELECT * FROM BICOS B INNER JOIN COMBUSTIVEIS C ON B.SEQCOMBUSTIVEL = C.SEQCOMBUSTIVEL WHERE SEQBICO = " + seqBico;
//            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                Combustivel c = new Combustivel(rs.getInt("SEQCOMBUSTIVEL"), rs.getString("IDENTCOMBUSTIVEL"), rs.getString("NOMECOMBUSTIVEL"), rs.getString("SITCOMBUSTIVEL"));
//                b.setSeqBico(rs.getInt("SEQBICO"));
//                b.setIdentBico(rs.getString("IDENTBICO"));
//                b.setNomeBico(rs.getString("NOMEBICO"));
//                b.setIdCBC(rs.getString("IDCBC"));
//                b.setSituacao(rs.getString("SITBICO"));
//                b.setEncerrante(rs.getDouble("ENCERRANTEINICIAL"));
//                b.setComboio(rs.getString("COMBOIO"));
//                b.setConexao(rs.getString("CONEXAO"));
//                b.setPorta(rs.getInt("PORTA"));
//                b.setCasasDecimais(rs.getInt("CASASDECIMAIS"));
//                b.setExterno(rs.getString("EXTERNO"));
//                b.setIdTWC(rs.getInt("IDTWC"));
//                b.setCombustivel(c);
//            }
//            return b;
//        } catch (Exception e) {
//            GeraLog g = new GeraLog();
//            g.gravaErro(e);
//            g.close();
//            return null;
//        }
//    }
    public static boolean excluirAgenda(Integer codigo) {
        Connection conn = GlobalParameter.getConn();
        try {
            Statement stmt = conn.createStatement();
            int res = stmt.executeUpdate("DELETE FROM AGENDAMENTOS WHERE CODIGO = " + codigo);
            return res == 1;
        } catch (Exception e) {
            GeraLog g = new GeraLog();
            g.gravaErro(e);
            g.close();
            return false;
        }
    }
}
