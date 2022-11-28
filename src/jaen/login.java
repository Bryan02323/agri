
package jaen;
import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Emas
 */
public class login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public login() {
        initComponents();
        updatecombo();
    }
     Statement state;
        Connection con;
    PreparedStatement pst;
    ResultSet rst;
    
     public void updatecombo(){
        try{
             Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            state = con.createStatement();
            rst = state.executeQuery("SELECT * FROM account");
                while(rst.next()){
                    String type = rst.getString("Account_Type");
                   jComboType.addItem(type);
                   
                }con.close();
           
            
        }catch(Exception e){
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
   
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblLogin = new javax.swing.JLabel();
        lblExit = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        buttonLogin = new javax.swing.JButton();
        buttonLogin1 = new javax.swing.JButton();
        jComboType = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(102, 255, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyImages/login.png"))); // NOI18N
        jPanel1.add(lblLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 620, 60, 60));

        lblExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyImages/exit.png"))); // NOI18N
        jPanel1.add(lblExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 620, 60, 60));

        txtUser.setBackground(new java.awt.Color(102, 255, 0));
        txtUser.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        txtUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUser.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 242, 242), 2, true), "USER NAME", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Semibold", 1, 18))); // NOI18N
        txtUser.setOpaque(true);
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });
        jPanel1.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 450, 330, 80));

        txtPassword.setBackground(new java.awt.Color(102, 255, 0));
        txtPassword.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 242, 242), 2, true), "PASSWORD", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Semibold", 1, 18))); // NOI18N
        txtPassword.setOpaque(true);
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 540, 330, 80));

        buttonLogin.setBackground(new java.awt.Color(242, 242, 242));
        buttonLogin.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        buttonLogin.setText("Login");
        buttonLogin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });
        jPanel1.add(buttonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 620, 180, 60));

        buttonLogin1.setBackground(new java.awt.Color(242, 242, 242));
        buttonLogin1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        buttonLogin1.setText("Exit");
        buttonLogin1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        buttonLogin1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        buttonLogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLogin1ActionPerformed(evt);
            }
        });
        jPanel1.add(buttonLogin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 620, 160, 60));

        jComboType.setBackground(new java.awt.Color(102, 255, 0));
        jComboType.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jComboType.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jComboType.setOpaque(true);
        jComboType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboTypeActionPerformed(evt);
            }
        });
        jPanel1.add(jComboType, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 330, 60));

        jPanel2.setBackground(new java.awt.Color(204, 255, 0));

        lblTitle.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("LOGIN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 80));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyImages/log.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 230, 240));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 868, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed
        
        
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            String sql ="SELECT * FROM account WHERE User_Name=? and Password=? and Account_Type=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, txtUser.getText());
            pst.setString(2, txtPassword.getText());
            pst.setString(3, String.valueOf(jComboType.getSelectedItem()));
            rst = pst.executeQuery();
            if(rst.next()){
            
                if(jComboType.getSelectedIndex()==0) {
                    
                        String pass =  rst.getString("Password");
                        String user = rst.getString("User_Name");
                         if(user.equals(user) && pass.equals(pass)){
                             JOptionPane.showMessageDialog(this, "Login Successfully ","Success",JOptionPane.INFORMATION_MESSAGE);
                             Home home = new Home();
                             home.setVisible(true);
                             this.setVisible(false);                         
                         }
                        
                }

                else if(jComboType.getSelectedIndex()==1){
                    String pass =  rst.getString("Password");
                        String user = rst.getString("User_Name");
                         if(user.equals(user) && pass.equals(pass)){
                             JOptionPane.showMessageDialog(this, "Login Successfully ","Success",JOptionPane.INFORMATION_MESSAGE);
                             SecretaryHome home = new SecretaryHome();
                        home.setVisible(true);
                        this.setVisible(false);                           
                         }
                         
                }else{
                    Stock2 s2 =  new Stock2();
                    s2.setVisible(true);
                    this.setVisible(false);   
                    
                }
   
            }else{
                        JOptionPane.showMessageDialog(this, "UserName and Password is Wrong ");
                        }
           
            
        }catch(Exception e){
            
    }
    }//GEN-LAST:event_buttonLoginActionPerformed

    private void buttonLogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLogin1ActionPerformed
        // TODO add your handling code here:
       JFrame frame1 = new JFrame("EXIT");
       if(JOptionPane.showConfirmDialog(frame1, "Confrim if you want to Exit!", "EXIT", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
       {
           System.exit(0);
       }
    }//GEN-LAST:event_buttonLogin1ActionPerformed

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void jComboTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboTypeActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jComboTypeActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonLogin;
    private javax.swing.JButton buttonLogin1;
    private javax.swing.JComboBox<String> jComboType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblExit;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
