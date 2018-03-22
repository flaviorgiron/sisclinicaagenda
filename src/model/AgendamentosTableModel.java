package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.*;

public class AgendamentosTableModel extends AbstractTableModel {

    private static List<Agendamento> linhas;
    private static String[] cColunas = new String[]{"Seq", "Data", "Hora", "Agenda", "Paciente", "Motivo", "Obs"};

    public AgendamentosTableModel() {
        linhas = new ArrayList<>();
    }

    public AgendamentosTableModel(List<Agendamento> listaAgendamentos) {
        linhas = new ArrayList<>(listaAgendamentos);
    }

    @Override
    public int getColumnCount() {
        return cColunas.length;
    }

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return cColunas[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {

        switch (columnIndex) {
            case 0:
                return String.class; // código
            case 1:
                return String.class;//médico
            case 2:
                return String.class;//paciente
            case 3:
                return String.class;//data
            case 4:
                return String.class;//hora
            case 5:
                return String.class;//exame
            case 6:
                return String.class;//obs
            default:
                throw new IndexOutOfBoundsException("AgendamentosTableModel - GetColumnClass - Indice da Coluna fora dos limites");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Agendamento a = linhas.get(rowIndex);
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        switch (columnIndex) {
            case 0:
                return a.getCodigo().toString();
            case 1:
                return formato.format(a.getData());
            case 2:
                return a.getHora();
            case 3:
                return a.getAgenda();
            case 4:
                return a.getPaciente();
            case 5:
                return a.getExame();
            case 6:
                return a.getObservacao();
            default:
                throw new IndexOutOfBoundsException("AgendamentosTableModel - getValueAt - Indice da Coluna fora dos limites");
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Agendamento getAgendamento(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

    public void limpar() {
        linhas.clear();
        fireTableDataChanged();
    }

    public boolean isEmpty() {
        return linhas.isEmpty();
    }

    public void addListaAgendamentos(List<Agendamento> agendamento) {
        int tamanhoAntigo = getRowCount();
        linhas.addAll(agendamento);
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }

    public void addAgendamento(Agendamento pAgendamento) {
        Boolean existe = false;
        //verifica se ja nao existe o registro
        for (Agendamento a : linhas) {
            if (a.getCodigo().equals(pAgendamento.getCodigo())) {
                existe = true;
                break;
            } else {
                existe = false;
            }
        }
        if (!existe) {
            linhas.add(pAgendamento);
            int ultimoIndice = getRowCount() - 1;
            fireTableRowsInserted(ultimoIndice, ultimoIndice);
        }
    }
}
