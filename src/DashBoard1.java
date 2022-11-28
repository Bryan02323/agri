
import jaen.login;
import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Daniel Emas
 */
public class DashBoard1 extends javax.swing.JFrame {

      Connection con1;
    PreparedStatement insert;
    ResultSet rst;
    Statement state;
   String Password;
    Color DefaultColor,ClickedColor;
    
   ImageIcon icon1 = new ImageIcon("question.png");
    public DashBoard1() {
        initComponents();
        panelHome.hide();
        bg();
        DefaultColor = new Color(0,102,0);
        ClickedColor =  new Color(153,153,153);
        
        panelHome.setBackground(DefaultColor);
        panelRecords.setBackground(DefaultColor);
        panellogout.setBackground(DefaultColor);
        panelUser.setBackground(DefaultColor);
    }
   
    
    public void bg(){
       Icon i = jLabel1.getIcon();
       ImageIcon icon = (ImageIcon)i;
       Image image = icon.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
       jLabel1.setIcon(new ImageIcon(image));
       
       Icon a = jLabel5.getIcon();
       ImageIcon icon1 = (ImageIcon)a;
       Image image1 = icon1.getImage().getScaledInstance(jLabel5.getWidth(), jLabel5.getHeight(), Image.SCALE_SMOOTH);
       jLabel5.setIcon(new ImageIcon(image1));
       
       Icon l = jLabel6.getIcon();
       ImageIcon icon2 = (ImageIcon)l;
       Image image2 = icon2.getImage().getScaledInstance(jLabel6.getWidth(), jLabel6.getHeight(), Image.SCALE_SMOOTH);
       jLabel6.setIcon(new ImageIcon(image2));
       
      
       
   }
      public void Date(){
          Date date = new Date();
          SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
          String currentdate = dateformat.format(date);
          lblDate.setText(currentdate);
          
      }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblDate = new javax.swing.JLabel();
        lbltitle = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        panellogout = new javax.swing.JPanel();
        lblLogout = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        panelHome = new javax.swing.JPanel();
        lblHome = new javax.swing.JLabel();
        panelRecords = new javax.swing.JPanel();
        lblrecords = new javax.swing.JLabel();
        panelUser = new javax.swing.JPanel();
        lbluser = new javax.swing.JLabel();
        jDesktopPane = new javax.swing.JDesktopPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDate.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lblDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1530, 20, 130, 30));

        lbltitle.setFont(new java.awt.Font("Broadway", 1, 48)); // NOI18N
        lbltitle.setForeground(new java.awt.Color(255, 255, 255));
        lbltitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltitle.setText("Municipal of Jaen");
        jPanel1.add(lbltitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 980, 70));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Seeds & Fertilizer Management System");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 100, 460, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyImages/log.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 160, 140));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyImages/newlogo1.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1680, 10, 160, 140));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1540, 100, 140, 40));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Department of Agriculture");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 70, 360, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1870, 160));

        jPanel2.setBackground(new java.awt.Color(204, 204, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panellogout.setBackground(new java.awt.Color(51, 255, 0));
        panellogout.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lblLogout.setFont(new java.awt.Font("Segoe UI Semibold", 3, 30)); // NOI18N
        lblLogout.setForeground(new java.awt.Color(255, 255, 255));
        lblLogout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogout.setText("Logout");
        lblLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panellogoutLayout = new javax.swing.GroupLayout(panellogout);
        panellogout.setLayout(panellogoutLayout);
        panellogoutLayout.setHorizontalGroup(
            panellogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panellogoutLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        panellogoutLayout.setVerticalGroup(
            panellogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panellogoutLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.add(panellogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 720, 230, 60));

        jSeparator1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, 790));

        panelHome.setBackground(new java.awt.Color(51, 255, 0));
        panelHome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        panelHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelHomeMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelHomeMousePressed(evt);
            }
        });
        panelHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHome.setFont(new java.awt.Font("Segoe UI Semibold", 3, 24)); // NOI18N
        lblHome.setForeground(new java.awt.Color(255, 255, 255));
        lblHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHome.setText("Home");
        lblHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHomeMouseClicked(evt);
            }
        });
        panelHome.add(lblHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 210, 30));

        jPanel2.add(panelHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 230, 50));

        panelRecords.setBackground(new java.awt.Color(102, 255, 0));
        panelRecords.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lblrecords.setFont(new java.awt.Font("Segoe UI Semibold", 3, 24)); // NOI18N
        lblrecords.setForeground(new java.awt.Color(255, 255, 255));
        lblrecords.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblrecords.setText("Records");
        lblrecords.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblrecordsMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelRecordsLayout = new javax.swing.GroupLayout(panelRecords);
        panelRecords.setLayout(panelRecordsLayout);
        panelRecordsLayout.setHorizontalGroup(
            panelRecordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRecordsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblrecords, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRecordsLayout.setVerticalGroup(
            panelRecordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRecordsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblrecords, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(panelRecords, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 230, 50));

        panelUser.setBackground(new java.awt.Color(102, 255, 0));
        panelUser.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lbluser.setFont(new java.awt.Font("Segoe UI Semibold", 3, 24)); // NOI18N
        lbluser.setForeground(new java.awt.Color(255, 255, 255));
        lbluser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbluser.setText("User Management");
        lbluser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbluserMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelUserLayout = new javax.swing.GroupLayout(panelUser);
        panelUser.setLayout(panelUserLayout);
        panelUserLayout.setHorizontalGroup(
            panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbluser, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        panelUserLayout.setVerticalGroup(
            panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbluser, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(panelUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 230, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 290, 800));

        jDesktopPane.setBackground(new java.awt.Color(242, 242, 242));

        jLabel1.setBackground(new java.awt.Color(204, 204, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyImages/aa.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jDesktopPane.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPaneLayout = new javax.swing.GroupLayout(jDesktopPane);
        jDesktopPane.setLayout(jDesktopPaneLayout);
        jDesktopPaneLayout.setHorizontalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPaneLayout.setVerticalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jDesktopPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 1560, 790));

        jPanel11.setBackground(new java.awt.Color(204, 204, 0));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1870, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1870, 980));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked
        panelHome.setBackground(DefaultColor);
        panelRecords.setBackground(DefaultColor);
        panellogout.setBackground(ClickedColor);
        panelUser.setBackground(DefaultColor);
        
        int con = JOptionPane.showConfirmDialog(this, "<html><b style=\"color:black; font-size:15px;\">Are you sure you want to logout?</b></html>","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,icon1);
     if(con == 0){
     Login log = new Login();
            log.setVisible(true);
           dispose();  
     }else{
          panellogout.setBackground(DefaultColor);
     }
    }//GEN-LAST:event_lblLogoutMouseClicked

    private void lblHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseClicked

        jDesktopPane.removeAll();
        jDesktopPane.add(jPanel3).setVisible(true);
        jPanel3.setVisible(true);
        

        panelHome.setBackground(ClickedColor);
        panelRecords.setBackground(DefaultColor);
        panelUser.setBackground(DefaultColor);
        panellogout.setBackground(DefaultColor);
    }//GEN-LAST:event_lblHomeMouseClicked

    private void panelHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelHomeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_panelHomeMouseClicked

    private void panelHomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelHomeMousePressed

    }//GEN-LAST:event_panelHomeMousePressed

    private void lblrecordsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblrecordsMouseClicked
        Records record = new Records();
        panelHome.show();
        jDesktopPane.removeAll();
        jDesktopPane.add(record).setVisible(true);
        

        panelHome.setBackground(DefaultColor);
        panelRecords.setBackground(ClickedColor);
        panelUser.setBackground(DefaultColor);
        panellogout.setBackground(DefaultColor);
    }//GEN-LAST:event_lblrecordsMouseClicked

    private void lbluserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbluserMouseClicked
         JPasswordField password =  new JPasswordField();
       int con = JOptionPane.showConfirmDialog(this,password,"Enter Password",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,icon1);
       if(con == 0){
       if(password.getText().equals(Password)){
            USER user= new USER();
            jDesktopPane.removeAll();
            jDesktopPane.add(user).setVisible(true);
            panelHome.show();
            panelHome.setBackground(DefaultColor);
            panelRecords.setBackground(DefaultColor);
            panelUser.setBackground(ClickedColor);
            panellogout.setBackground(DefaultColor);
        }else{
            JOptionPane.showMessageDialog(this, "Invalid Password");
        }
       }else{
           
       }
    }//GEN-LAST:event_lbluserMouseClicked

   public void setpassword(String pass){
        Password = pass;
    }
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
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblrecords;
    private javax.swing.JLabel lbltitle;
    private javax.swing.JLabel lbluser;
    private javax.swing.JPanel panelHome;
    private javax.swing.JPanel panelRecords;
    private javax.swing.JPanel panelUser;
    private javax.swing.JPanel panellogout;
    // End of variables declaration//GEN-END:variables
}
