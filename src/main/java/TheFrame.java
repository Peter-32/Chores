import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TheFrame extends JFrame {

    private TheFrame() {
        setupFrame();

    }
    public static void main(String[] args) {

        TheFrame tp = new TheFrame();


    }

    private void setupFrame() {
        setTitle("Chores");
        JTabbedPane jtp = new JTabbedPane();
        this.add(jtp);
        BasicsTabPanel basicsTabPanel = new BasicsTabPanel();
        JPanel jp2 = new JPanel();
        //JLabel label1 = new JLabel();
        //label1.setText("You are in area of Basics");
        //basicsTabPanel.add(label1);
        JLabel label2 = new JLabel();
        label2.setText("You are in area of Tab2");
        jp2.add(label2);
        jtp.addTab("New Month", basicsTabPanel);
        jtp.addTab("Historical", jp2);

        this.setSize(800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

}