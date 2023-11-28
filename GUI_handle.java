import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUI_handle extends JFrame { 
    private JTextField tnum1, tnum2;
    private JButton btn;
    private JLabel jKetQua;

    public GUI_handle() {
        setTitle("Bai Hoc Dau Tien");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("so thu 1:"));
        
        setVisible(true);
    }

    public static void main(String[] args) {
        GUI_handle t = new GUI_handle();
    }
}
