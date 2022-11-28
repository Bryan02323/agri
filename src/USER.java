
import jaen.AgriSupply;
import jaen.Registration;
import jaen.User;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Vector;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
public class USER extends javax.swing.JInternalFrame {

   ResultSet rst2;
    
    public USER() {
        initComponents();
        User();
        editflase();
        Header();
        auotoid();
        ImageAutoID();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = ( BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        
       
    }
    
    public void editflase(){

         txtUserType.setEditable(false);
         txtUserName.setEditable(false);
         JPassword.setEditable(false);
         JConfirmPassword.setEditable(false);
         txtFullName.setEditable(false);
         txtAddress.setEditable(false);
         txtAge.setEditable(false);
         txtPhone.setEditable(false);
        
    }
    
    public void edittrue(){
         txtUserType.setEditable(true);
         txtUserName.setEditable(true);
         JPassword.setEditable(true);
         JConfirmPassword.setEditable(true);
         txtFullName.setEditable(true);
         txtAddress.setEditable(true);
         txtAge.setEditable(true);
         txtPhone.setEditable(true);
        
    }
    
    
       
          //This for Image 1
File filename1 = null;
String path1 = null;
private ImageIcon format1 = null;

        //This for Image 2
File filename2 = null;
String path2 = null;
private ImageIcon format2 = null;


String gender;
String ID;
    
    Connection con1;
    PreparedStatement insert;
    ResultSet rst;
    Statement state;
    
 
    ImageIcon icon1 = new ImageIcon("error.png");
     ImageIcon icon2 = new ImageIcon("success.png");
     ImageIcon icon3 = new ImageIcon("question.png");
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
            Logger.getLogger(jaen.Release.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(jaen.Release.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(jaen.Release.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(jaen.Release.class.getName()).log(Level.SEVERE, null, ex);
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
          if(Male.isSelected()){
                gender="Male";
            }
            else if(Female.isSelected()){
                gender="Female";
            }
          insert.setString(8, gender);
          insert.setString(9, phone);
          insert.executeUpdate();

            if(password.equals(confirmpassword)){
                
              if(path1 != null){
             System.out.println("Image Path1 - " + path1);
             System.out.println("Image Name1 - "+ filename1.getName());
             File file1 = new File(path1);
             
             System.out.println("Image Path1 - " + path2);
             System.out.println("Image Name1 - "+ filename2.getName());
             File file2 = new File(path2);
             InputStream image1 = new FileInputStream(file1);
             InputStream image2 = new FileInputStream(file2);
             
          
               
               String query1 = "insert into user_image(Imaged_ID,Account_ID,User_Type,ImageFile1,ImageName1,ImageFile2,ImageName2) values (?,?,?,?,?,?,?)";
              insert = con1.prepareStatement(query1);
 
              insert.setString(1, ID);
              insert.setString(2, lblID.getText());
              insert.setString(3, txtUserType.getText());
              insert.setBlob(4, image1);
              insert.setString(5, path1);
              insert.setBlob(6, image2);
              insert.setString(7, path2);

               if(insert.executeUpdate()  > 0){
                    txtUserType.setText("");
               }
                }
                
            
            txtFullName.setText("");
            txtUserName.setText("");
            JPassword.setText("");
            JConfirmPassword.setText("");
            JConfirmPassword.setText("");
            txtAddress.setText("");
            txtAge.setText("");
            txtPhone.setText("");
            lbl2x2.setIcon(null);
            lblvalidid.setIcon(null);
              

           
            JOptionPane.showMessageDialog(this,"<html><b style=\"color:black; font-size:15px;\">Create Account Successfull!</b></html>","Success",JOptionPane.INFORMATION_MESSAGE,icon2);
                 User();
                 auotoid();
                 ImageAutoID();
            }
            else{
              JOptionPane.showMessageDialog(this,"<html><b style=\"color:black; font-size:15px;\">Check your UserName or Password!</b></html>","Invalid",JOptionPane.INFORMATION_MESSAGE,icon1);
            }
       
            
                
                }
            

        }catch (ClassNotFoundException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) { 
           Logger.getLogger(USER.class.getName()).log(Level.SEVERE, null, ex);
       } 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        bg = new javax.swing.JPanel();
        BackGroundPanel = new javax.swing.JPanel();
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
        Male = new javax.swing.JRadioButton();
        Female = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        JPassword = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        JConfirmPassword = new javax.swing.JPasswordField();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnAddSave = new javax.swing.JButton();
        lbl2x2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();
        lblID = new javax.swing.JLabel();
        lblAcoountID = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        lblvalidid = new javax.swing.JLabel();
        lbltitle2 = new javax.swing.JLabel();
        lbltitle = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnUpload2x2 = new javax.swing.JButton();
        btnUploadValidid = new javax.swing.JButton();
        btnDeleteSave = new javax.swing.JButton();
        btnEditSave = new javax.swing.JButton();
        txtvalidid = new javax.swing.JTextField();
        txt2x2 = new javax.swing.JTextField();

        bg.setBackground(new java.awt.Color(51, 204, 0));
        bg.setPreferredSize(new java.awt.Dimension(1590, 840));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BackGroundPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel1.setText("Full Name ");
        BackGroundPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, 140, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel3.setText("User Type  ");
        BackGroundPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 140, 40));

        txtUserType.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        BackGroundPanel.add(txtUserType, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 260, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel4.setText("Age");
        BackGroundPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 570, 140, 40));

        jLabel13.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel13.setText("Password");
        BackGroundPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 140, 40));

        txtAddress.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });
        BackGroundPanel.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 520, 260, 40));

        txtPhone.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        txtPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPhoneKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPhoneKeyTyped(evt);
            }
        });
        BackGroundPanel.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 620, 260, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel12.setText("Address ");
        BackGroundPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 520, 140, 40));

        jLabel14.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel14.setText("Phone");
        BackGroundPanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 620, 140, 40));

        txtAge.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        BackGroundPanel.add(txtAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 570, 260, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel7.setText("Gender ");
        BackGroundPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 670, 140, 40));

        buttonGroup1.add(Male);
        Male.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        Male.setText("Male");
        Male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaleActionPerformed(evt);
            }
        });
        BackGroundPanel.add(Male, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 670, -1, 40));

        buttonGroup1.add(Female);
        Female.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        Female.setText("Female");
        Female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FemaleActionPerformed(evt);
            }
        });
        BackGroundPanel.add(Female, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 670, -1, 40));

        jLabel15.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel15.setText("User Name");
        BackGroundPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 140, 40));

        txtUserName.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        BackGroundPanel.add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 260, 40));

        JPassword.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        BackGroundPanel.add(JPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, 260, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel5.setText("ConfirmPassword");
        BackGroundPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 200, 40));

        txtFullName.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        txtFullName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFullNameActionPerformed(evt);
            }
        });
        BackGroundPanel.add(txtFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 470, 260, 40));

        JConfirmPassword.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        BackGroundPanel.add(JConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 400, 210, 40));

        btnEdit.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        BackGroundPanel.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 700, 110, 50));

        btnDelete.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        BackGroundPanel.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 700, 110, 50));

        jButton3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        BackGroundPanel.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 700, 110, 50));

        btnAddSave.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        btnAddSave.setText("Save");
        btnAddSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSaveActionPerformed(evt);
            }
        });
        BackGroundPanel.add(btnAddSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 700, 110, 50));

        lbl2x2.setBackground(new java.awt.Color(204, 204, 204));
        lbl2x2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        lbl2x2.setOpaque(true);
        lbl2x2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl2x2MouseClicked(evt);
            }
        });
        BackGroundPanel.add(lbl2x2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 240, 400, 340));

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

        BackGroundPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 1460, 130));

        lblID.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lblID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblID.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        BackGroundPanel.add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 180, 40));

        lblAcoountID.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lblAcoountID.setText("Account ID");
        BackGroundPanel.add(lblAcoountID, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 150, 40));

        jCheckBox1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jCheckBox1.setText("Show Password");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        BackGroundPanel.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 440, 170, -1));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(0, 102, 0));
        jPanel7.setPreferredSize(new java.awt.Dimension(1580, 25));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1580, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 25, 1580, -1));

        BackGroundPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 780, 1580, 60));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        BackGroundPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1550, -10, 30, 800));

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 810, Short.MAX_VALUE)
        );

        BackGroundPanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 30, 810));

        jPanel5.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1550, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        BackGroundPanel.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1550, 30));

        jPanel6.setBackground(new java.awt.Color(0, 153, 0));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
        );

        BackGroundPanel.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1580, 0, 10, 850));

        lblvalidid.setBackground(new java.awt.Color(204, 204, 204));
        lblvalidid.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        lblvalidid.setOpaque(true);
        lblvalidid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblvalididMouseClicked(evt);
            }
        });
        BackGroundPanel.add(lblvalidid, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 240, 400, 350));

        lbltitle2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lbltitle2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltitle2.setText("Valid ID");
        lbltitle2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        BackGroundPanel.add(lbltitle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 600, 320, 30));

        lbltitle.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lbltitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltitle.setText("2x2 Picture");
        lbltitle.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        BackGroundPanel.add(lbltitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 590, 320, 30));

        btnAdd.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        BackGroundPanel.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 700, 110, 50));

        btnUpload2x2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnUpload2x2.setText("Upload");
        btnUpload2x2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpload2x2ActionPerformed(evt);
            }
        });
        BackGroundPanel.add(btnUpload2x2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 630, 110, -1));

        btnUploadValidid.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnUploadValidid.setText("Upload");
        btnUploadValidid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadValididActionPerformed(evt);
            }
        });
        BackGroundPanel.add(btnUploadValidid, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 630, 110, -1));

        btnDeleteSave.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        btnDeleteSave.setText("Save");
        btnDeleteSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteSaveActionPerformed(evt);
            }
        });
        BackGroundPanel.add(btnDeleteSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 700, 110, 50));

        btnEditSave.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        btnEditSave.setText("Save");
        btnEditSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditSaveActionPerformed(evt);
            }
        });
        BackGroundPanel.add(btnEditSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 700, 110, 50));
        BackGroundPanel.add(txtvalidid, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 200, 400, -1));
        BackGroundPanel.add(txt2x2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 200, 400, -1));

        bg.add(BackGroundPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1590, 840));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaleActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_MaleActionPerformed

    private void FemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FemaleActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_FemaleActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        btnDeleteSave.hide();
        btnEditSave.show();
        btnAddSave.hide();
        tblUser.setEnabled(true);
       
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        btnDeleteSave.show();
        btnEditSave.hide();
        btnAddSave.hide();
        tblUser.setEnabled(true);

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
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
        lbl2x2.setIcon(null);
        lblvalidid.setIcon(null);
       auotoid();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnAddSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSaveActionPerformed
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
            || phone.isEmpty()  ){
        JOptionPane.showMessageDialog(null, "<html><b style=\"color:black; font-size:15px;\">Fill the Blank!</b></html>","Complete the details", JOptionPane.ERROR_MESSAGE,icon1);

        }else{
            adduser();
            
        }

    }//GEN-LAST:event_btnAddSaveActionPerformed

    private void lbl2x2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl2x2MouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_lbl2x2MouseClicked

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
            Male.setSelected(true);
        }else{
            Female.setSelected(true);
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
            
                     String id = lblID.getText();
        try{
              
              Class.forName("com.mysql.cj.jdbc.Driver");
               con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            String sql ="SELECT * FROM  user_image where Account_ID=?";
           
            insert = con1.prepareStatement(sql);
            insert.setString(1, id);
            rst = insert.executeQuery();
            
            if(rst.next()){
                 lblID.setText(id);
              
                  //This is for Image 1
                     path1 = rst.getString("ImageName1");
                     File newfilename1 = new File("ImageName1");
                     byte[] ImageData = rst.getBytes("ImageFile1");
                     format1 = new ImageIcon(ImageData);
                     Image mm = format1.getImage();
                     Image img1 = mm.getScaledInstance(lbl2x2.getWidth(), lbl2x2.getHeight(), Image.SCALE_SMOOTH);
                     ImageIcon image1 = new ImageIcon(img1);
                     txt2x2.setText(path1);
                     lbl2x2.setIcon(image1);
                     
                     path2 = rst.getString("ImageName2");
                     byte[] ImageData1 = rst.getBytes("ImageFile2");
                     format2 = new ImageIcon(ImageData1);
                     Image mm2 = format2.getImage();
                     Image img2 = mm2.getScaledInstance(lblvalidid.getWidth(), lblvalidid.getHeight(), Image.SCALE_SMOOTH);
                     ImageIcon image2 = new ImageIcon(img2);
                     txtvalidid.setText(path2);
                     lblvalidid.setIcon(image2);
                     
            }
        }catch(Exception e){
            
        }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_tblUserMouseClicked

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

    private void txtFullNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFullNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFullNameActionPerformed

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

    private void lblvalididMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblvalididMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblvalididMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        edittrue();
        tblUser.setEnabled(false);
        btnDeleteSave.hide();
        btnEditSave.hide();
        btnAddSave.show();
       
            
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpload2x2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpload2x2ActionPerformed
         JFileChooser filechooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG JPG AND JPEG","png","jpg","jpeg");
        filechooser.addChoosableFileFilter(filter);
        int load =  filechooser.showOpenDialog(null);

        if(load==filechooser.APPROVE_OPTION){
            filename1 = filechooser.getSelectedFile();
            path1 = filename1.getAbsolutePath();
            txt2x2.setText(path1);
            
            ImageIcon icon = new ImageIcon(path1);
            Image img = icon.getImage().getScaledInstance(lbl2x2.getWidth(), lbl2x2.getHeight(), Image.SCALE_SMOOTH);
            lbl2x2.setIcon(new ImageIcon(img));

        }
    }//GEN-LAST:event_btnUpload2x2ActionPerformed

    private void btnUploadValididActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadValididActionPerformed
        JFileChooser filechooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG JPG AND JPEG","png","jpg","jpeg");
        filechooser.addChoosableFileFilter(filter);
        int load =  filechooser.showOpenDialog(null);

        if(load==filechooser.APPROVE_OPTION){
            filename2 = filechooser.getSelectedFile();
            
            path2 = filename2.getAbsolutePath();
            txtvalidid.setText(path2);
            ImageIcon icon1 = new ImageIcon(path2);
            Image img1 = icon1.getImage().getScaledInstance(lblvalidid.getWidth(), lblvalidid.getHeight(), Image.SCALE_SMOOTH);
            lblvalidid.setIcon(new ImageIcon(img1));

        }
    }//GEN-LAST:event_btnUploadValididActionPerformed

    private void txtPhoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneKeyTyped
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtPhoneKeyTyped

    private void txtPhoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneKeyPressed
        String phonenumer = txtPhone.getText();
       int length = phonenumer.length();
       char c = evt.getKeyChar();
       if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9'){
            if (length<11) {
                txtPhone.setEditable(true);
           }else{
                txtPhone.setEditable(false);
            }
    }else{
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE ){
                txtPhone.setEditable(true);
            }else{
                txtPhone.setEditable(false);
            }
       }
    }//GEN-LAST:event_txtPhoneKeyPressed

    private void btnDeleteSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteSaveActionPerformed
        
            String account = txtUserType.getText();
            String name = txtFullName.getText();
            String username = txtUserName.getText();
            String password = JPassword.getText();
            String address = txtAddress.getText();
            String age = txtAge.getText();
            String phone = txtPhone.getText();
            
        if (account.isEmpty() || name.isEmpty() || username.isEmpty() || password.isEmpty() || address.isEmpty() || age.isEmpty()
                || phone.isEmpty()){
           JOptionPane.showMessageDialog(null, "<html><b style=\"color:black; font-size:15px;\">Fill the Blank!</b></html>","Complete the details", JOptionPane.ERROR_MESSAGE,icon1);

            }else{
        int op =JOptionPane.showConfirmDialog(null, "<html><b style=\"color:black; font-size:15px;\">Are you sure to Delete</b></html>", "Delete", JOptionPane.YES_NO_OPTION,JOptionPane.DEFAULT_OPTION,icon3);
        if(op == 0){
            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                con1= DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");

                int row = tblUser.getSelectedRow();

                String query = "DELETE  FROM account where Account_Type=?";
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
                lbl2x2.setIcon(null);
                lblvalidid.setIcon(null);
                tblUser.setEnabled(false);

         JOptionPane.showMessageDialog(this,"<html><b style=\"color:black; font-size:15px;\">Delete Successfuly!</b></html>","Success",JOptionPane.INFORMATION_MESSAGE,icon2);
                User();
                auotoid();

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
    }//GEN-LAST:event_btnDeleteSaveActionPerformed

    private void btnEditSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditSaveActionPerformed
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
           JOptionPane.showMessageDialog(null, "<html><b style=\"color:black; font-size:15px;\">Fill the Blank!</b></html>","Complete the details", JOptionPane.ERROR_MESSAGE,icon1);

            }else{
               if(path1 != null){
             try{
                       System.out.print("Image Path1 - " + path1);
                       System.out.print("Image Name1 - "+ filename1.getName());
                       InputStream image1 = new FileInputStream(path1);
                      
                      
                      
               String query1 = "UPDATE user_image SET User_Type=?,ImageFile1=?,ImageName1=? WHERE Account_ID=?";   
              insert = con1.prepareStatement(query1);

              insert.setString(4, lblID.getText());
               insert.setString(1, txtUserType.getText());
              insert.setBlob(2, image1); 
              insert.setString(3, path1);
              if(insert.executeUpdate()  > 0){
                   
            
              }

                 }catch(Exception e){
      
              }
    
        }
                if(path2 != null){
             try{
                 
                 
                       System.out.print("Image Path1 - " + path2);
                       System.out.print("Image Name1 - "+ filename2.getName());
                      InputStream image2 = new FileInputStream(path2);
                      
                      
                      
               String query1 = "UPDATE user_image SET User_Type=?,ImageFile2=?,ImageName2=? WHERE Account_ID=?";   
              insert = con1.prepareStatement(query1);
   
              insert.setString(4, lblID.getText());
               insert.setString(1, txtUserType.getText());
              insert.setBlob(2, image2); 
              insert.setString(3, path2);
              if(insert.executeUpdate()  > 0){
                   
            
              }

                 }catch(Exception e){
      
              }
    
        }
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");

                insert = con1.prepareStatement("UPDATE account SET Account_Type=?,Full_Name=?,User_Name=?,Password=?,"
                    + "Address=?,Age=?,Gender=?,Phone=? WHERE Account_ID=?");

                insert.setString(9,lblID.getText());
                insert.setString(1, account);
                insert.setString(2, name);
                insert.setString(3, username);
                insert.setString(4, password);
                insert.setString(5, address);
                insert.setString(6, age);
                if(Male.isSelected()){
                gender="Male";
                }
                else if(Female.isSelected()){
                  gender="Female";
                }
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
                lbl2x2.setIcon(null);
                lblvalidid.setIcon(null);
                tblUser.setEnabled(false);

            JOptionPane.showMessageDialog(this,"<html><b style=\"color:black; font-size:15px;\">Edit Successfuly!</b></html>","Success",JOptionPane.INFORMATION_MESSAGE,icon2);
             auotoid();
            }

        }catch (ClassNotFoundException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_btnEditSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackGroundPanel;
    private javax.swing.JRadioButton Female;
    private javax.swing.JPasswordField JConfirmPassword;
    private javax.swing.JPasswordField JPassword;
    private javax.swing.JRadioButton Male;
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddSave;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDeleteSave;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnEditSave;
    private javax.swing.JButton btnUpload2x2;
    private javax.swing.JButton btnUploadValidid;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl2x2;
    private javax.swing.JLabel lblAcoountID;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lbltitle;
    private javax.swing.JLabel lbltitle2;
    private javax.swing.JLabel lblvalidid;
    private javax.swing.JTable tblUser;
    private javax.swing.JTextField txt2x2;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtUserName;
    private javax.swing.JTextField txtUserType;
    private javax.swing.JTextField txtvalidid;
    // End of variables declaration//GEN-END:variables
}
