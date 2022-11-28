/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jaen;

import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;
import javax.swing.Icon;
import javax.swing.JPasswordField;
public class User extends javax.swing.JFrame {
    
 
    
    public User() {
        initComponents();
       
        User();
        Header();
        auotoid();
        ImageAutoID();
        jPanel4.hide();
    }
    
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
    
 
    
     public void Header(){
         
         tblUser.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD, 18));
         
     }
      public void ImageAutoID(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
             state = con1.createStatement();
             rst = state.executeQuery("SELECT Max(Imaged_ID) FROM user_image");
             rst.next();
             
             rst.getString("Max(Imaged_ID)");
             
             if(rst.getString("Max(Imaged_ID)")== null){
                 ID = ("I-0001");
                 
             }else{
                 Long id = Long.parseLong(rst.getString("Max(Imaged_ID)").substring(2,rst.getString("Max(Imaged_ID)").length()));
                 id++;
                 ID = ("I-000" + String.format("%01d", id));
             }
                     
                     
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Release.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Release.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
      
      public void auotoid(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
             state = con1.createStatement();
             rst = state.executeQuery("SELECT Max(Account_ID) FROM account");
             rst.next();
             
             rst.getString("Max(Account_ID)");
             
             if(rst.getString("Max(Account_ID)")== null){
                 lblID.setText("A-0001");
                 
             }else{
                 Long id = Long.parseLong(rst.getString("Max(Account_ID)").substring(2,rst.getString("Max(Account_ID)").length()));
                 id++;
                 lblID.setText("A-000" + String.format("%01d", id));
             }
                     
                     
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Release.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Release.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }

    public void User(){
            int c;
           
             try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            insert = con1.prepareStatement("select * from account");
            
            rst = insert.executeQuery();
            ResultSetMetaData rss = rst.getMetaData();
            c = rss.getColumnCount();
            
            DefaultTableModel Df = (DefaultTableModel)tblUser.getModel();
            Df.setRowCount(0);
            
            while(rst.next()){
                
                Vector v2 = new Vector();
                
                for(int a=1; a<=c; a++)
                {
                    v2.add(rst.getString("Account_ID"));
                    v2.add(rst.getString("Account_Type"));
                    v2.add(rst.getString("Full_Name"));
                    v2.add(rst.getString("User_Name"));
                    v2.add(rst.getString("Password"));
                    v2.add(rst.getString("Address"));
                    v2.add(rst.getString("Age"));
                    v2.add(rst.getString("Gender"));
                    v2.add(rst.getString("Phone"));
       
                }
                
                Df.addRow(v2);
                        
            }
 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
    public void adduser(){
          
           
             String ID1 = lblID.getText();
            String account = txtUserType.getText();
            String name = txtFullName.getText();
            String username = txtUserName.getText();
            String password = JPassword.getText();
            String confirmpassword = JConfirmPassword.getText();
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
            
            insert = con1.prepareStatement("insert into account(Account_ID,Account_Type,Full_Name,User_Name,Password,Address,"
                    + "Age,Gender,Phone)values(?,?,?,?,?,?,?,?,?)");

          insert.setString(1, lblID.getText());
          insert.setString(2, account);
          insert.setString(3, name);
          insert.setString(4, username);
          insert.setString(5, password);
          insert.setString(6, address);
          insert.setString(7, age);
          insert.setString(8, gender);
          insert.setString(9, phone);

            if(password.equals(confirmpassword)){
                
            
            insert.executeUpdate();
           
            txtFullName.setText("");
            txtUserName.setText("");
            JPassword.setText("");
            JConfirmPassword.setText("");
            JConfirmPassword.setText("");
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
              insert.setString(2, lblID.getText());
              insert.setString(3, txtUserType.getText());
              insert.setBlob(4, image1);

               if(insert.executeUpdate()  > 0){
                    txtUserType.setText("");
               }
                }

           
                 JOptionPane.showMessageDialog(this, "Create Account Succesful!","Success",JOptionPane.INFORMATION_MESSAGE);
                 User();
                 auotoid();
                 ImageAutoID();
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        BackGroundPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lbladmin = new javax.swing.JLabel();
        lbladmin1 = new javax.swing.JLabel();
        jPassword = new javax.swing.JPasswordField();
        btnSave = new javax.swing.JButton();
        lbladmin2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblBack = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUserType = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        JPassword = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        JConfirmPassword = new javax.swing.JPasswordField();
        btnEdit = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblImage1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();
        lblID = new javax.swing.JLabel();
        lblAcoountID = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        BackGroundPanel.setBackground(new java.awt.Color(102, 255, 51));
        BackGroundPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 204, 0));
        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.darkGray, java.awt.Color.darkGray, java.awt.Color.darkGray));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbladmin.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lbladmin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbladmin.setText("Enter Admin Password");
        jPanel4.add(lbladmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 310, 47));

        lbladmin1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lbladmin1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(lbladmin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 310, 47));

        jPassword.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel4.add(jPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 210, 40));

        btnSave.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel4.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 100, 40));

        lbladmin2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lbladmin2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbladmin2.setText("Password");
        jPanel4.add(lbladmin2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 310, 47));

        BackGroundPanel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 290, 330, 260));

        jPanel2.setBackground(new java.awt.Color(51, 204, 0));

        lblTitle.setFont(new java.awt.Font("Segoe UI Semibold", 2, 40)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("User Management");

        lblBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyImages/back.png"))); // NOI18N
        lblBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblBack, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(600, 600, 600)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(930, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        BackGroundPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 2142, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel1.setText("Full Name ");
        BackGroundPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 470, 140, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel3.setText("User Type  ");
        BackGroundPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 140, 40));

        txtUserType.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        BackGroundPanel.add(txtUserType, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, 260, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel4.setText("Age");
        BackGroundPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 590, 140, 40));

        jLabel13.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel13.setText("Password");
        BackGroundPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 140, 40));

        txtAddress.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        BackGroundPanel.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 530, 260, 40));

        txtPhone.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        BackGroundPanel.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 700, 260, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel12.setText("Address ");
        BackGroundPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 530, 140, 40));

        jLabel14.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel14.setText("Phone");
        BackGroundPanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 700, 140, 40));

        txtAge.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        BackGroundPanel.add(txtAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 590, 260, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel7.setText("Gender ");
        BackGroundPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 640, 140, 40));

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        jRadioButton4.setText("Male");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });
        BackGroundPanel.add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 640, -1, 50));

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        jRadioButton3.setText("Female");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        BackGroundPanel.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 640, -1, 50));

        jLabel15.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel15.setText("User Name");
        BackGroundPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 140, 40));

        txtUserName.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        BackGroundPanel.add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 260, 40));

        JPassword.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        BackGroundPanel.add(JPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, 260, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel5.setText("ConfirmPassword");
        BackGroundPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 200, 40));

        txtFullName.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        BackGroundPanel.add(txtFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 470, 260, 40));

        JConfirmPassword.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        BackGroundPanel.add(JConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 380, 210, 40));

        btnEdit.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        BackGroundPanel.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 460, 110, 50));

        jButton2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        BackGroundPanel.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 540, 110, 50));

        jButton3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        BackGroundPanel.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 540, 110, 50));

        btnAdd.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        BackGroundPanel.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 460, 110, 50));
        BackGroundPanel.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(1580, 150, 150, 40));

        jButton6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jButton6.setText("Search");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        BackGroundPanel.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1750, 150, 120, 40));

        jPanel1.setBackground(new java.awt.Color(51, 204, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
        );

        BackGroundPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, -1, 1090));

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1800, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        BackGroundPanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 1800, 30));

        lblImage1.setBackground(new java.awt.Color(204, 204, 204));
        lblImage1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        lblImage1.setOpaque(true);
        lblImage1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImage1MouseClicked(evt);
            }
        });
        BackGroundPanel.add(lblImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 200, 230, 220));

        tblUser.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "User ID", "User Type", "Full Name", "User Name", "Password", "Addess", "Age", "Gender", "Phone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUser.setGridColor(new java.awt.Color(0, 255, 0));
        tblUser.setRowHeight(30);
        tblUser.setSelectionBackground(new java.awt.Color(51, 255, 0));
        tblUser.setShowHorizontalLines(true);
        tblUser.setShowVerticalLines(true);
        tblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUser);

        BackGroundPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 200, 1030, 520));

        lblID.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lblID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BackGroundPanel.add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 180, 30));

        lblAcoountID.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lblAcoountID.setText("Account ID");
        BackGroundPanel.add(lblAcoountID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 150, 30));

        btnLogin.setFont(new java.awt.Font("Segoe UI Semibold", 0, 30)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        BackGroundPanel.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 780, 140, 50));

        btnCancel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 30)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        BackGroundPanel.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 780, 140, 50));

        jCheckBox1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jCheckBox1.setText("Show Password");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        BackGroundPanel.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 430, 170, -1));

        getContentPane().add(BackGroundPanel);

        setSize(new java.awt.Dimension(1918, 1209));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jCheckBox1.setSelected(false);
       buttonGroup1.clearSelection();
        txtUserType.setText(" ");
        txtFullName.setText(" ");
        txtUserName.setText(" ");
        JPassword.setText("");
        JConfirmPassword.setText("");
        txtAddress.setText(" ");
        txtAge.setText(" ");
        txtPhone.setText(" ");
       auotoid();
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
          String ID1 = lblID.getText();
            String account = txtUserType.getText();
            String name = txtFullName.getText();
            String username = txtUserName.getText();
            String password = JPassword.getText();
            String confirmpassword = JConfirmPassword.getText();
            String address = txtAddress.getText();
            String age = txtAge.getText();
            String phone = txtPhone.getText();
           
           if (ID1.isEmpty() || account.isEmpty() || name.isEmpty() || username.isEmpty() || password.isEmpty() || confirmpassword.isEmpty() || address.isEmpty() || age.isEmpty()
                      || phone.isEmpty() ){     
                    JOptionPane.showMessageDialog(null, "Fill the Blank!","Complete the details", JOptionPane.ERROR_MESSAGE);
                
                }else{
               jPanel4.setVisible(true);
           }
     
    }//GEN-LAST:event_btnAddActionPerformed
    
    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
        gender = "Male";
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
        gender = "FeMale";
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        try{
            
            String account = txtUserType.getText();
            String name = txtFullName.getText();
            String username = txtUserName.getText();
            String password = JPassword.getText();
            String address = txtAddress.getText();
            String age = txtAge.getText();
            String phone = txtPhone.getText();
            
              if (account.isEmpty() || name.isEmpty() || username.isEmpty() || password.isEmpty() || address.isEmpty() || age.isEmpty()
                      || phone.isEmpty()){     
                    JOptionPane.showMessageDialog(null, "Fill the Blank!","Complete the details", JOptionPane.ERROR_MESSAGE);
                
                }else{
                   Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            
            insert = con1.prepareStatement("UPDATE account SET Account_Type=?,Full_Name=?,User_Name=?,Password=?,"
                    + "Address=?,Age=?,Gender=?,Phone=? WHERE Account_ID=?");

            insert.setString(9,txtSearch.getText());
          insert.setString(1, account);
          insert.setString(2, name);
          insert.setString(3, username);
          insert.setString(4, password);
           insert.setString(5, address);
          insert.setString(6, age);
          insert.setString(7, gender);
          insert.setString(8, phone);
          insert.executeUpdate();

            txtUserType.setText("");
            txtFullName.setText("");
            txtUserName.setText("");
            JPassword.setText("");
            JConfirmPassword.setText("");
            txtAddress.setText("");
            txtAge.setText("");
            txtPhone.setText("");

 
                JOptionPane.showMessageDialog(this, "Edit Account Succesful!");
               
                  
              }
        
   
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
             try{ 
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
              System.out.println("SASA");
            insert = con1.prepareStatement
        ("select Account_ID,Account_Type,Full_Name,User_Name,Password,Address,Age,Phone from account where Account_ID=? ");
         
            int id = Integer.parseInt(txtSearch.getText());
            insert.setInt(1, id);
            rst = insert.executeQuery();
            
           
            if(rst.next() == false){
                JOptionPane.showMessageDialog(this, "User Not Found!");
            txtUserType.setText("");
            txtFullName.setText("");
            txtUserName.setText("");
            JPassword.setText("");
            JConfirmPassword.setText("");
            txtAddress.setText("");
            txtAge.setText("");
            txtPhone.setText("");
            
            }else{
                
            txtUserType.setText(rst.getString("Account_Type"));
            txtFullName.setText(rst.getString("Full_Name"));
            txtUserName.setText(rst.getString("User_Name"));
            JPassword.setText(rst.getString("Password"));
            txtAddress.setText(rst.getString("Address"));
            txtAge.setText(rst.getString("Age"));
            txtPhone.setText(rst.getString("Phone"));
            }
            
                    
            
        }catch (Exception e){
            
        }
          
      
    }//GEN-LAST:event_jButton6ActionPerformed

    private void lblImage1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImage1MouseClicked
        // TODO add your handling code here:
         JFileChooser filechooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG JPG AND JPEG","png","jpg","jpeg");
        filechooser.addChoosableFileFilter(filter);
        int load =  filechooser.showOpenDialog(null);
        
        if(load==filechooser.APPROVE_OPTION){
            filename1 = filechooser.getSelectedFile();
            
            path1 = filename1.getAbsolutePath();
            ImageIcon icon = new ImageIcon(path1);
            Image img = icon.getImage().getScaledInstance(lblImage1.getWidth(), lblImage1.getHeight(), Image.SCALE_SMOOTH);
            lblImage1.setIcon(new ImageIcon(img));
            
        }
    }//GEN-LAST:event_lblImage1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         int op =JOptionPane.showConfirmDialog(null, "Are you sure to Delete", "Delete", JOptionPane.YES_NO_OPTION);
        if(op == 0){
        try {
          
            Class.forName("com.mysql.cj.jdbc.Driver");
             con1= DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
             
              int row = tblUser.getSelectedRow();

              String query = "DELETE FROM account where Account_Type=?";
              insert = con1.prepareStatement(query);
              insert.setString(1,txtUserType.getText());
               insert.executeUpdate();
               
            txtUserType.setText("");
            txtFullName.setText("");
            txtUserName.setText("");
            JPassword.setText("");
            JConfirmPassword.setText("");
            txtAddress.setText("");
            txtAge.setText("");
            txtPhone.setText("");
               
                JOptionPane.showMessageDialog(null, "Delete Success");
              User();
        
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        login log = new login();
        log.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        Home home = new Home();
        home.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
    try {
        // TODO add your handling code here:
        Class.forName("com.mysql.cj.jdbc.Driver");
        con1= DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
        String sql ="SELECT Password FROM account WHERE Password=? ";
        insert = con1.prepareStatement(sql);
        insert.setString(1, jPassword.getText());
        rst = insert.executeQuery();
        if(rst.next()){           
           adduser();
           jPanel4.hide();
        }else{
        JOptionPane.showMessageDialog(this, "Incorrect Admin Password");
    }
        
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        JPasswordField password = JPassword;
        JPasswordField password1 = JConfirmPassword;
           
            if (jCheckBox1.isSelected()) {
               password.setEchoChar((char)0); //password = JPasswordField
               password1.setEchoChar((char)0);
            } else {
               password.setEchoChar('*');
               password1.setEchoChar('*');
            }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void tblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserMouseClicked
   
      
     
        DefaultTableModel Df = (DefaultTableModel)tblUser.getModel();
        int SelectedRows = tblUser.getSelectedRow();
        
        lblID.setText(Df.getValueAt(SelectedRows, 0).toString());
        txtUserType.setText(Df.getValueAt(SelectedRows,1).toString());
        txtFullName.setText(Df.getValueAt(SelectedRows, 2).toString());
        txtUserName.setText(Df.getValueAt(SelectedRows, 3).toString());
        JPassword.setText(Df.getValueAt(SelectedRows, 4).toString());
        
        txtAddress.setText(Df.getValueAt(SelectedRows, 5).toString());
        txtAge.setText(Df.getValueAt(SelectedRows, 6).toString());
        String gender = Df.getValueAt(SelectedRows, 7).toString();
        if(gender.equals("Male")){
            jRadioButton4.setSelected(true);
        }else{
            jRadioButton3.setSelected(true);
        }
        txtPhone.setText(Df.getValueAt(SelectedRows, 8).toString());
        try{
               Class.forName("com.mysql.cj.jdbc.Driver");
        con1= DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
          String query ="SELECT Password from account where Account_ID =?";
            insert=con1.prepareStatement(query);
            insert.setString(1, lblID.getText());
            rst = insert.executeQuery();
          while(rst.next()){
              String contact = rst.getString("Password");
                      JConfirmPassword.setText(contact);
          }
        
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
    }
       
    }//GEN-LAST:event_tblUserMouseClicked

    private void lblBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseClicked
        // TODO add your handling code here:
        Home home = new Home();
        home.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblBackMouseClicked

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
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackGroundPanel;
    private javax.swing.JPasswordField JConfirmPassword;
    private javax.swing.JPasswordField JPassword;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAcoountID;
    private javax.swing.JLabel lblBack;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblImage1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lbladmin;
    private javax.swing.JLabel lbladmin1;
    private javax.swing.JLabel lbladmin2;
    private javax.swing.JTable tblUser;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtUserName;
    private javax.swing.JTextField txtUserType;
    // End of variables declaration//GEN-END:variables
}
