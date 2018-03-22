package util;


import javax.swing.JOptionPane;

public class Mensagem {

    public Mensagem() {
    }

    public static int showOptionDialog(String title, String message) {
        String[] textMessages = {"Sim", "Não"};
        return JOptionPane.showOptionDialog(null, message, title, JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, textMessages, null);
    }

    public static int showOptionDialog(String title, String message, boolean cancel) {
        String[] textMessages = {"Sim", "Não", "Cancelar"};
        return JOptionPane.showOptionDialog(null, message, title, JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, textMessages, null);
    }

    public static void showMessageDialog(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, 1);
    }
}
