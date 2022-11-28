import jaen.Home;
import jaen.SecretaryHome;
import jaen.Stock2;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends javax.swing.JFrame {

    /**
     * Creates new form NewJaen
     */
    public Login() {
        initComponents();
        this.setTitle("Login");
        
        txtUser.setBackground(new java.awt.Color(0,0,0,1));
        txtPassword.setBackground(new java.awt.Color(0,0,0,1));
        buttonLogin.setBackground(new java.awt.Color(1,1,1,0));
        setIconImage();
       logo();
       lblHide.hide();
    }
  Statement state;
        Connection con;
    PreparedStatement pst;
    ResultSet rst;
   ImageIcon icon = new ImageIcon("error.png");
   ImageIcon icon2 = new ImageIcon("success.png");
   ImageIcon icon1 = new ImageIcon("question.png");
    public String Security_pass(){
        return Security_pass();
    }
    
    public void logo(){
       Icon i = lbluser.getIcon();
       ImageIcon icon = (ImageIcon)i;
       Image image = icon.getImage().getScaledInstance(lbluser.getWidth(), lbluser.getHeight(), Image.SCALE_SMOOTH);
       lbluser.setIcon(new ImageIcon(image));
       
       Icon i1 = lblkey.getIcon();
       ImageIcon icon1 = (ImageIcon)i1;
       Image image1 = icon1.getImage().getScaledInstance(lblkey.getWidth(), lblkey.getHeight(), Image.SCALE_SMOOTH);
       lblkey.setIcon(new ImageIcon(image1));
       
       Icon i2 = lblshow.getIcon();
       ImageIcon icon2 = (ImageIcon)i2;
       Image image2 = icon2.getImage().getScaledInstance(lblshow.getWidth(), lblshow.getHeight(), Image.SCALE_SMOOTH);
       lblshow.setIcon(new ImageIcon(image2));
       
       Icon i3 = lblHide.getIcon();
       ImageIcon icon3 = (ImageIcon)i3;
       Image image3 = icon3.getImage().getScaledInstance(lblHide.getWidth(), lblHide.getHeight(), Image.SCALE_SMOOTH);
       lblHide.setIcon(new ImageIcon(image3));
       
       Icon i4 = lblHide.getIcon();
       ImageIcon icon4 = (ImageIcon)i3;
       Image image4 = icon4.getImage().getScaledInstance(lblbg.getWidth(), lblbg.getHeight(), Image.SCALE_SMOOTH);
       lblHide.setIcon(new ImageIcon(image3));
       
      
       
   }
  

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblshow = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        buttonLogin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblkey = new javax.swing.JLabel();
        lbluser = new javax.swing.JLabel();
        lblHide = new javax.swing.JLabel();
        lblbg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblshow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyImages/show.png"))); // NOI18N
        lblshow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblshowMouseClicked(evt);
            }
        });
        jPanel1.add(lblshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 450, 50, 40));

        txtUser.setBackground(new java.awt.Color(242, 242, 242));
        txtUser.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        txtUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUser.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 242, 242), 2, true), "USER NAME", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Semibold", 1, 18), new java.awt.Color(242, 242, 242))); // NOI18N
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });
        jPanel1.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 330, 80));

        txtPassword.setBackground(new java.awt.Color(242, 242, 242));
        txtPassword.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 242, 242), 2, true), "PASSWORD", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Semibold", 1, 18), new java.awt.Color(242, 242, 242))); // NOI18N
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, 330, 80));

        buttonLogin.setBackground(new java.awt.Color(242, 242, 242));
        buttonLogin.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        buttonLogin.setForeground(new java.awt.Color(242, 242, 242));
        buttonLogin.setText("Login");
        buttonLogin.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 242, 242), 2, true));
        buttonLogin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });
        jPanel1.add(buttonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 510, 90, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyImages/log.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 230, 240));

        lblkey.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyImages/36992.png"))); // NOI18N
        jPanel1.add(lblkey, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 50, 40));

        lbluser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyImages/header-icon-9.jpg"))); // NOI18N
        jPanel1.add(lbluser, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 50, 40));

        lblHide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyImages/hide.png"))); // NOI18N
        lblHide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHideMouseClicked(evt);
            }
        });
        jPanel1.add(lblHide, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 450, 50, 40));

        lblbg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyImages/aa.jpg"))); // NOI18N
        jPanel1.add(lblbg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 640));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed

        try{
           // String Security_pass = txtPassword.getText();
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            String sql ="SELECT * FROM account WHERE User_Name=? and Password=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, txtUser.getText());
            pst.setString(2, txtPassword.getText());
            rst = pst.executeQuery();
            if(rst.next()){
                    
                        String pass =  rst.getString("Password");
                        String user = rst.getString("User_Name");
                        String accountType = rst.getString("Account_Type");
                        if(accountType.equals("Admin")){
                            JOptionPane.showMessageDialog(this,"<html><b style=\"color:black; font-size:15px;\">Login Successfuly</b></html>","Success",JOptionPane.INFORMATION_MESSAGE,icon2);
                            DashBoard1 home = new DashBoard1();
                            home.setpassword(txtPassword.getText());
                             home.setVisible(true);
                             this.setVisible(false); 
                        }
                        else{
                            JOptionPane.showMessageDialog(this,"<html><b style=\"color:black; font-size:15px;\">Login Successfuly</b></html>","Success",JOptionPane.INFORMATION_MESSAGE,icon2);
                            DashBoard home = new DashBoard();  
                        home.setVisible(true);
                        this.setVisible(false);
                        }
                        
                }else{
                JOptionPane.showMessageDialog(this,"<html><b style=\"color:black; font-size:15px;\">Invalid Username & Password  </b></html>","Incorrect",JOptionPane.INFORMATION_MESSAGE,icon);
            }
           
            
        }catch(Exception e){
            System.out.println("Error : " + e);
    }
     
        

        
    }//GEN-LAST:event_buttonLoginActionPerformed

    private void lblshowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblshowMouseClicked
        txtPassword.setEchoChar((char)0);
        lblHide.show();
        lblshow.hide();
    }//GEN-LAST:event_lblshowMouseClicked

    private void lblHideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHideMouseClicked
         txtPassword.setEchoChar('*');
         lblHide.hide();
         lblshow.show();
    }//GEN-LAST:event_lblHideMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblHide;
    private javax.swing.JLabel lblbg;
    private javax.swing.JLabel lblkey;
    private javax.swing.JLabel lblshow;
    private javax.swing.JLabel lbluser;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables

    private void setIconImage() {
         setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Jaenlogo.png")));
    }
}
