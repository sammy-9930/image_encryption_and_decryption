package crypto;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
public class ImageCrypto extends javax.swing.JFrame {
    public ImageCrypto() {
      initComponents();
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        file_path.setText(f.getAbsolutePath());
        private void encrypt_buttonActionPerformed(java.awt.event.ActionEvent evt) {
          try {
            System.out.println("Encrypt pass : " + encrypt_pass.getText());
            Password.setKey(encrypt_pass.getText());

            if (Password.getKey().isEmpty()) {
              JOptionPane.showMessageDialog(null, "Enter a secret key ");
              return;
            }
            FileInputStream file = new FileInputStream(file_path.getText());
            FileOutputStream outStream = new FileOutputStream("Encrypt.jpg");
            byte k[] = "ThisIsA256BitKeyForAES256".getBytes();
            SecretKeySpec key = new SecretKeySpec(k, "AES");
            Cipher enc = Cipher.getInstance("AES"); //creates instance of cipher class
            enc.init(Cipher.ENCRYPT_MODE, key); //initializing cipher  
            CipherOutputStream cos = new CipherOutputStream(outStream, enc);
            byte[] buf = new byte[1024]; //encrypt into exisiting byte array
            int read; //reads next byte 
            while ((read = file.read(buf)) != -1) {
              cos.write(buf, 0, read);
            }
            file.close();
            outStream.flush(); //forces buffered output bytes to be written out 
            cos.close();
            JOptionPane.showMessageDialog(null, "The File Encrypted Sucessfully");
          } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
          }
        }

        private void decrypt_buttonActionPerformed(java.awt.event.ActionEvent evt) {
          try {
            if (Password.getKey().isEmpty()) {
              JOptionPane.showMessageDialog(null, "Enter a  secret key ");
              return;
            }
            System.out.println(Password.getKey());
            System.out.println(encrypt_pass.getText());
            if (Password.getKey().equals(encrypt_pass.getText()) != true) {
              JOptionPane.showMessageDialog(null, "Enter valid secret key");
              return;
            }
            Password.getPwd();
            FileInputStream file = new FileInputStream(file_path.getText());
            FileOutputStream outStream = new FileOutputStream("Decrypt.jpg");
            byte k[] = "ThisIsA256BitKeyForAES256".getBytes();
            SecretKeySpec key = new SecretKeySpec(k, "AES");
            Cipher enc = Cipher.getInstance("AES");
            enc.init(Cipher.DECRYPT_MODE, key);
            CipherOutputStream cos = new CipherOutputStream(outStream, enc);
            byte[] buf = new byte[1024];
            int read;
            while ((read = file.read(buf)) != -1) {
              cos.write(buf, 0, read);
            }
            file.close();
            outStream.flush();
            cos.close();
            JOptionPane.showMessageDialog(null, "The Image Was Successfully Decrypted");
          } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
          }
        }
        private void encrypt_passActionPerformed(java.awt.event.ActionEvent evt) {
            public static void main(String args[]) {
              try {
                for (javax.swing.UIManager.LookAndFeelInfo info: javax.swing.UIManager.getInstalledLookAndFeels()) {
                  if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                  }
                }
              } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(ImageCrypto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
              } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(ImageCrypto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
              } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(ImageCrypto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
              } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(ImageCrypto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
              }
              //</editor-fold>

              /* Create and display the form */
              java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                  new ImageCrypto().setVisible(true);
                }
              });
            }
            private javax.swing.JButton decrypt_button;
            private javax.swing.JButton encrypt_button;
            private javax.swing.JTextField encrypt_pass;
            private javax.swing.JTextField file_path;
            private javax.swing.JButton jButton1;
            private javax.swing.JLabel jLabel2;
            private javax.swing.JPanel jPanel1;
            private javax.swing.JPanel jPanel2;
