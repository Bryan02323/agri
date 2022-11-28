/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jaen;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Daniel Emas
 */
public class Registration1 extends javax.swing.JFrame {
    //This for Image 1
File filename1 = null;
String path1 = null;
private ImageIcon format1 = null;

String gender;
String ID;
    
    Connection con1;
    PreparedStatement insert;
    ResultSet rst;
    Statement state;

    public Registration1() {
        initComponents();
        placeholder(txtUserName);
       
    }

    public void placeholder(JTextField txtUserName){
        Font font = txtUserName.getFont();
        font = font.deriveFont(Font.PLAIN);
        txtUserName.setFont(font);
        txtUserName.setForeground(Color.gray);
    }
     public void removeplaceholder(JTextField txtUserName){
        Font font = txtUserName.getFont();
        font = font.deriveFont(Font.PLAIN|Font.BOLD);
        txtUserName.setFont(font);
        txtUserName.setForeground(Color.black);
    }
    
     public void adduser(){
          
           
             String ID1 = txtID.getText();
            String account = txtUserType.getText();
            String name = txtFullName.getText();
            String username = txtUserName.getText();
            String password = jPassword.getText();
            String confirmpassword = jConfirmPassword.getText();
            String address = txtAddress.getText();
            String age = txtAge.getText();
            String phone = txtPhone.getText();
            
               try{
     
             if (ID1.isEmpty() || account.isEmpty() || name.isEmpty() || username.isEmpty() || password.isEmpty() || confirmpassword.isEmpty() || address.isEmpty() || age.isEmpty()
                      || phone.isEmpty()){     
                    JOptionPane.showMessageDialog(null, "Fill the Blank!","Complete the details", JOptionPane.ERROR_MESSAGE);
                
                }
                
                else{
                     Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            
            insert = con1.prepareStatement("insert into account(Account_ID,Account_Type,Full_Name,User_Name,Password,Confirm_Password,Address,"
                    + "Age,Gender,Phone)values(?,?,?,?,?,?,?,?,?,?)");

          insert.setString(1, txtID.getText());
          insert.setString(2, account);
          insert.setString(3, name);
          insert.setString(4, username);
          insert.setString(5, password);
          insert.setString(6, confirmpassword);
          insert.setString(7, address);
          insert.setString(8, age);
          insert.setString(9, gender);
          insert.setString(10, phone);

            if(password.equals(confirmpassword)){
                
            
            insert.executeUpdate();
           
            txtFullName.setText("");
            txtUserName.setText("");
            jPassword.setText("");
            jConfirmPassword.setText("");
            txtAddress.setText("");
            txtAge.setText("");
            txtPhone.setText("");
                
                 if(path1 != null){
              System.out.println("Image Path1 - " + path1);
             System.out.println("Image Name1 - "+ filename1.getName());
             File file1 = new File(path1);
             InputStream image1 = new FileInputStream(file1);
          
               
               String query1 = "insert into user_image(Imaged_ID,Account_ID,User_Type,ImageFile1) values (?,?,?,?)";
              insert = con1.prepareStatement(query1);
 
              insert.setString(1, ID);
              insert.setString(2, txtID.getText());
              insert.setString(3, txtUserType.getText());
              insert.setBlob(4, image1);

               if(insert.executeUpdate()  > 0){
                    txtUserType.setText("");
               }
                }

           
                 JOptionPane.showMessageDialog(this, "Create Account Succesful!","Success",JOptionPane.INFORMATION_MESSAGE);
                
            }
            else{
                JOptionPane.showMessageDialog(this, "Check your UserName or Password!","Error",JOptionPane.ERROR_MESSAGE);
            }
       
            
                
                }
            

        }catch (ClassNotFoundException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) { 
        Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
    } 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gendergroup = new javax.swing.ButtonGroup();
        bg = new javax.swing.JPanel();
        txtUserType = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtFullName = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtUserName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jConfirmPassword = new javax.swing.JPasswordField();
        jPassword = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jRadioButton5 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(57, 255, 20));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUserType.setBackground(new java.awt.Color(57, 255, 20));
        txtUserType.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        txtUserType.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUserType.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 242, 242), 2, true), "User Type", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Semibold", 1, 18))); // NOI18N
        txtUserType.setOpaque(true);
        txtUserType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserTypeActionPerformed(evt);
            }
        });
        bg.add(txtUserType, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 330, 70));

        jPanel1.setBackground(new java.awt.Color(50, 205, 50));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setText("Create Account");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(264, 264, 264)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bg.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 903, -1));

        txtAge.setBackground(new java.awt.Color(57, 255, 20));
        txtAge.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        txtAge.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAge.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 242, 242), 2, true), "Age", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Semibold", 1, 18))); // NOI18N
        txtAge.setOpaque(true);
        txtAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgeActionPerformed(evt);
            }
        });
        bg.add(txtAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 540, 330, 70));

        txtAddress.setBackground(new java.awt.Color(57, 255, 20));
        txtAddress.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        txtAddress.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAddress.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 242, 242), 2, true), "Address", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Semibold", 1, 18))); // NOI18N
        txtAddress.setOpaque(true);
        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });
        bg.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 450, 330, 70));

        txtFullName.setBackground(new java.awt.Color(57, 255, 20));
        txtFullName.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        txtFullName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFullName.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 242, 242), 2, true), "Full Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Semibold", 1, 18))); // NOI18N
        txtFullName.setOpaque(true);
        txtFullName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFullNameActionPerformed(evt);
            }
        });
        bg.add(txtFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, 330, 70));

        txtID.setBackground(new java.awt.Color(57, 255, 20));
        txtID.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        txtID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtID.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 242, 242), 2, true), "Account ID", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Semibold", 1, 18))); // NOI18N
        txtID.setOpaque(true);
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        bg.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 330, 70));

        txtPhone.setBackground(new java.awt.Color(57, 255, 20));
        txtPhone.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        txtPhone.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPhone.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 242, 242), 2, true), "Phone Number", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Semibold", 1, 18))); // NOI18N
        txtPhone.setOpaque(true);
        txtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneActionPerformed(evt);
            }
        });
        bg.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 600, 330, 70));

        txtUserName.setBackground(new java.awt.Color(57, 255, 20));
        txtUserName.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        txtUserName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUserName.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 242, 242), 2, true), "USER NAME", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Semibold", 1, 18))); // NOI18N
        txtUserName.setOpaque(true);
        txtUserName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUserNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUserNameFocusLost(evt);
            }
        });
        txtUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserNameActionPerformed(evt);
            }
        });
        bg.add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 330, 70));

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jLabel2.setOpaque(true);
        bg.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 260, 220));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel7.setText("Gender ");
        bg.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 620, 140, 50));

        gendergroup.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        jRadioButton4.setText("Male");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });
        bg.add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 620, -1, 50));

        gendergroup.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        jRadioButton3.setText("Female");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        bg.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 620, -1, 50));

        jConfirmPassword.setBackground(new java.awt.Color(57, 255, 20));
        jConfirmPassword.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jConfirmPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jConfirmPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true), "Confirm Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24))); // NOI18N
        bg.add(jConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 330, 80));

        jPassword.setBackground(new java.awt.Color(57, 255, 20));
        jPassword.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true), "Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24))); // NOI18N
        jPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        bg.add(jPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 330, 80));

        jButton1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jButton1.setText("Create Account");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        bg.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 720, 220, 50));

        gendergroup.add(jRadioButton5);
        jRadioButton5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        jRadioButton5.setText("Male");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });
        bg.add(jRadioButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 620, -1, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 928, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserTypeActionPerformed

    private void txtAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgeActionPerformed

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

    private void txtFullNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFullNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFullNameActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneActionPerformed

    private void txtUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserNameActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
        gender = "Male";
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
        gender = "FeMale";
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void txtUserNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserNameFocusGained
        // TODO add your handling code here:
        if(txtUserName.getText().equals("User Name")){
            txtUserName.setText(null);
            txtUserName.requestFocus();
            removeplaceholder(txtUserName);
        }
    }//GEN-LAST:event_txtUserNameFocusGained

    private void txtUserNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserNameFocusLost
        // TODO add your handling code here:
         if(txtUserName.getText().length()==0){  
            placeholder(txtUserName);
            txtUserName.setText("User Name");
        }
    }//GEN-LAST:event_txtUserNameFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(Registration1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registration1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registration1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registration1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registration1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.ButtonGroup gendergroup;
    private javax.swing.JButton jButton1;
    private javax.swing.JPasswordField jConfirmPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtUserName;
    private javax.swing.JTextField txtUserType;
    // End of variables declaration//GEN-END:variables
}
