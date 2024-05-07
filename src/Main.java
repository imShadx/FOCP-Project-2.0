import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->{
            //Creates and shows the frame on the EDT ( Event Dispatch thread )
            new Home();
        });
    }
}