import crypto.ImageCrypto;
import crypto.Password;
import java.awt.Color;
import java.io.FileWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class LoginForm extends javax.swing.JFrame {
public LoginForm() {
        initComponents();
        this.setLocationRelativeTo(null);//center form in the screen
    }
private void jButtonMouseEntered(java.awt.event.MouseEvent evt) { 
 jButton.setBackground(new  Color(102,102,255));
    }           
private void jButtonMouseExited(java.awt.event.MouseEvent evt) {                                    
        jButton.setBackground(new  Color(0,102,255));
    }      
private void jButtonMousePressed(java.awt.event.MouseEvent evt) {                                     
        String user = jTextField_User.getText();
        String pass = String.valueOf(jPasswordField1.getPassword());
        Password.setPwd(pass);
        
        if(jTextField_User.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Enter a Valid username");
        }             
 if(pass.trim().toLowerCase().equals("")){
             JOptionPane.showMessageDialog(null,"Enter Valid Secret Key");
        }
        else
        {
       
         ImageCrypto ic = new ImageCrypto();
        ic.setVisible(true);
        ic.pack();
        ic.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
       }    
public static void main(String args[]) {
java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
 private javax.swing.JButton jButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField_User;
}      
