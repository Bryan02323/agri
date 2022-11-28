package jaen;

import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
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
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;


public class Registration extends javax.swing.JFrame {


    //This for Image 1
File filename1 = null;
String path1 = null;
private ImageIcon format1 = null;

//This is for Image 2
File filename2 = null;
String path2 = null;
private ImageIcon format2 = null;

// This for Image 3
File filename3 = null;
String path3 = null;
private ImageIcon format3 = null;

// This is forImage 4
File filename4 = null;
String path4 = null;
private ImageIcon format4 = null;

byte[] images = null;


    
    
   
    
    
    Connection con1;
    PreparedStatement insert;
    ResultSet rst;
    Statement state;

    public Registration() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        table_update();
        Header();
        autoid();
        Date();
        Totalfarmer();
    }
    
    

    @SuppressWarnings("unchecked")
  
     public void autoid(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            state = con1.createStatement();
            rst = state.executeQuery("SELECT Max(FID) FROM profile");
            rst.next();
            
              if(rst.getString("Max(FID)")== null){
                 txtID.setText("Farmer-0001");
            }else{
             String preid = rst.getString("MAX(FID)");
            String data = preid.replace("Farmer-", "");
            int num =Integer.parseInt(data);
            num=num+1;
            String nextID=getnumerformat(num);
            txtID.setText(nextID);
             }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AgriSupply.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AgriSupply.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
    public static String getnumerformat(int number){
        
        String numberData="Farmer-";
        if(number>=1 && number <=9){
            numberData=numberData+"000"+number;    
        }
        else if(number>=10 && number <=99){
            numberData=numberData+"00"+number;    
        }
         else if(number>=100 && number <=999){
            numberData=numberData+"00"+number;    
        }
         else if(number>=1000 && number <=9999){
            numberData=numberData+"0"+number;    
        }
         else if(number>=10000 && number <=99999){
            numberData=numberData+""+number;    
        }
        
   return numberData;
    }
    
      public void Header(){
         
         jTable2.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD, 20));
         
     }
      public void Totalfarmer(){
          
          try{
                Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
           String sql = "SELECT count(*) from profile;";
           insert = con1.prepareStatement(sql);
           rst = insert.executeQuery();
           if(rst.next()){
               int count = rst.getInt(1);
               jLabel5.setText(String.valueOf(count));
               
               
           }
              
              
          }catch(SQLException e){
              
          } catch (ClassNotFoundException ex) {
        Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
    }
        
          
      }
      
      
      public void Date(){
          Date date = new Date();
          SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
          String currentdate = dateformat.format(date);
          txtDates.setText(currentdate);
          
      }
    
    
    private void table_update(){
           
           int c;
           
             try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            insert = con1.prepareStatement("select FID,LName,FName,MName,EName,House_No,Street,Barangay,Municipality,Province,Region from profile");
            
            rst = insert.executeQuery();
            ResultSetMetaData rss = rst.getMetaData();
            c = rss.getColumnCount();   
            
             DefaultTableModel Df = (DefaultTableModel) jTable2.getModel();

            Df.setRowCount(0);
            while(rst.next()){
                
                Vector v2 = new Vector();
                
                for(int a=1; a<=c; a++)
                {
                    v2.add(rst.getString("FID"));
                    v2.add(rst.getString("LName"));
                    v2.add(rst.getString("FName"));
                    v2.add(rst.getString("MName"));
                    v2.add(rst.getString("EName"));
                    v2.add(rst.getString("House_No"));
                    v2.add(rst.getString("Street"));
                    v2.add(rst.getString("Barangay"));
                    v2.add(rst.getString("Municipality"));
                    v2.add(rst.getString("Province"));
                    v2.add(rst.getString("Region"));
                   
                
                }
                 Df.addRow(v2);
       
            }

            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
           
           
       }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupReligion = new javax.swing.ButtonGroup();
        buttonGroupPWD = new javax.swing.ButtonGroup();
        buttonGroup4Ps = new javax.swing.ButtonGroup();
        buttonGroupIndigenous = new javax.swing.ButtonGroup();
        buttonGroupGoverment = new javax.swing.ButtonGroup();
        buttonGroupFarmers = new javax.swing.ButtonGroup();
        buttonGroupHouse = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        tableFarmer = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        lblFID = new javax.swing.JLabel();
        txtFName = new javax.swing.JTextField();
        lblFName = new javax.swing.JLabel();
        txtMName = new javax.swing.JTextField();
        lblMName = new javax.swing.JLabel();
        txtEName = new javax.swing.JTextField();
        lblEName = new javax.swing.JLabel();
        txtSName = new javax.swing.JTextField();
        lblSName = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        txtPurok = new javax.swing.JTextField();
        lblPurok = new javax.swing.JLabel();
        txtStreet = new javax.swing.JTextField();
        lblStreet = new javax.swing.JLabel();
        lblBarangay = new javax.swing.JLabel();
        txtMunicipality = new javax.swing.JTextField();
        lblMunicipality = new javax.swing.JLabel();
        txtprovince = new javax.swing.JTextField();
        lblProvince = new javax.swing.JLabel();
        txtRegion = new javax.swing.JTextField();
        lblrRegion = new javax.swing.JLabel();
        combobrgy = new javax.swing.JComboBox<>();
        lblContact = new javax.swing.JLabel();
        txtContact = new javax.swing.JTextField();
        lblDate = new javax.swing.JLabel();
        lblPlace = new javax.swing.JLabel();
        txtPlace = new javax.swing.JTextField();
        lblSex = new javax.swing.JLabel();
        jComboSex = new javax.swing.JComboBox<>();
        jComboCivil = new javax.swing.JComboBox<>();
        lblCivil = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        lblReligion = new javax.swing.JLabel();
        jCheckChristian = new javax.swing.JCheckBox();
        jCheckIslam = new javax.swing.JCheckBox();
        jCheckOthers = new javax.swing.JCheckBox();
        txtreligionSpecify = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel5 = new javax.swing.JPanel();
        jComboEduc = new javax.swing.JComboBox<>();
        lblPWD = new javax.swing.JLabel();
        lblEduc = new javax.swing.JLabel();
        jCheckPWDNo = new javax.swing.JCheckBox();
        jCheckPWDYes = new javax.swing.JCheckBox();
        lbl4Ps = new javax.swing.JLabel();
        jCheck4PsYes = new javax.swing.JCheckBox();
        jCheckIndigenousNo = new javax.swing.JCheckBox();
        lblName10 = new javax.swing.JLabel();
        jCheckIndigenousYes = new javax.swing.JCheckBox();
        jCheck4PsNo = new javax.swing.JCheckBox();
        lblIndigenous = new javax.swing.JLabel();
        txtAssociationSpecify = new javax.swing.JTextField();
        lblHouseHold = new javax.swing.JLabel();
        jCheckHouseYes = new javax.swing.JCheckBox();
        jCheckHouseNo = new javax.swing.JCheckBox();
        lblIfnoHouse = new javax.swing.JLabel();
        lblRelatioship = new javax.swing.JLabel();
        lblNoofLiving = new javax.swing.JLabel();
        lblMale = new javax.swing.JLabel();
        lblFemale = new javax.swing.JLabel();
        txtIfnoHouse = new javax.swing.JTextField();
        txtRelationship = new javax.swing.JTextField();
        txtMale = new javax.swing.JTextField();
        txtFemale = new javax.swing.JTextField();
        txtNoofLiving = new javax.swing.JTextField();
        lblName22 = new javax.swing.JLabel();
        jCheckAssociationYes = new javax.swing.JCheckBox();
        jCheckAssociationNo = new javax.swing.JCheckBox();
        lblEmergency = new javax.swing.JLabel();
        txtEmergency = new javax.swing.JTextField();
        txtContactNo = new javax.swing.JTextField();
        lblContactNo = new javax.swing.JLabel();
        txtIndigenousSpecify = new javax.swing.JTextField();
        lblGoverment = new javax.swing.JLabel();
        jCheckGovYes = new javax.swing.JCheckBox();
        jCheckGovNo = new javax.swing.JCheckBox();
        lblIDtype = new javax.swing.JLabel();
        txtIDtype = new javax.swing.JTextField();
        lblID = new javax.swing.JLabel();
        txtIDNumbber = new javax.swing.JTextField();
        lblFarmerAssociation = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblmain3 = new javax.swing.JLabel();
        lblName44 = new javax.swing.JLabel();
        lblName43 = new javax.swing.JLabel();
        jCheckRice1 = new javax.swing.JCheckBox();
        jCheckCorn1 = new javax.swing.JCheckBox();
        jCheckFarmOthers1 = new javax.swing.JCheckBox();
        lblName45 = new javax.swing.JLabel();
        txtOtherSpecify1 = new javax.swing.JTextField();
        jCheckFarmer3 = new javax.swing.JCheckBox();
        jCheckLive1 = new javax.swing.JCheckBox();
        lblName46 = new javax.swing.JLabel();
        txtLiveSpecify1 = new javax.swing.JTextField();
        jCheckPoultry1 = new javax.swing.JCheckBox();
        lblName47 = new javax.swing.JLabel();
        txtPoultrySpecify1 = new javax.swing.JTextField();
        jCheckFarmLabor1 = new javax.swing.JCheckBox();
        SeperatorForFarmer = new javax.swing.JSeparator();
        lblName49 = new javax.swing.JLabel();
        jCheckLand1 = new javax.swing.JCheckBox();
        jCheckPlanting1 = new javax.swing.JCheckBox();
        jCheckCultivation1 = new javax.swing.JCheckBox();
        lblName20 = new javax.swing.JLabel();
        jCheckHarvest1 = new javax.swing.JCheckBox();
        jCheckFarmworkerHarvest1 = new javax.swing.JCheckBox();
        lblName75 = new javax.swing.JLabel();
        txtFarmWorkerSpecify1 = new javax.swing.JTextField();
        SeperatorFarmWorkers = new javax.swing.JSeparator();
        jCheckFish1 = new javax.swing.JCheckBox();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        lblName51 = new javax.swing.JLabel();
        jCheckAqua2 = new javax.swing.JCheckBox();
        jCheckFishOthers1 = new javax.swing.JCheckBox();
        txtFishSpecify2 = new javax.swing.JTextField();
        jCheckFishProcess1 = new javax.swing.JCheckBox();
        jCheckFishVending1 = new javax.swing.JCheckBox();
        jCheckFishCapture2 = new javax.swing.JCheckBox();
        lblName74 = new javax.swing.JLabel();
        jCheckGleaning1 = new javax.swing.JCheckBox();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jCheckPart1 = new javax.swing.JCheckBox();
        jCheckNonFromal1 = new javax.swing.JCheckBox();
        lblName48 = new javax.swing.JLabel();
        lblName50 = new javax.swing.JLabel();
        jCheckAgri1 = new javax.swing.JCheckBox();
        jCheckFormal1 = new javax.swing.JCheckBox();
        lblName77 = new javax.swing.JLabel();
        jCheckParticipated1 = new javax.swing.JCheckBox();
        lblName76 = new javax.swing.JLabel();
        jCheckBox44 = new javax.swing.JCheckBox();
        jTextAgriSpecify1 = new javax.swing.JTextField();
        lblName52 = new javax.swing.JLabel();
        SeperatorFisher = new javax.swing.JSeparator();
        SeperetorAgri = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        lblImage1 = new javax.swing.JLabel();
        txtPath1 = new javax.swing.JTextField();
        lblImage2 = new javax.swing.JLabel();
        txtPath2 = new javax.swing.JTextField();
        lblImage3 = new javax.swing.JLabel();
        txtPath3 = new javax.swing.JTextField();
        lblImage4 = new javax.swing.JLabel();
        txtPath4 = new javax.swing.JTextField();
        txtDates = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblDateReg = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        jPanel1.setBackground(new java.awt.Color(102, 255, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(51, 204, 0));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Jaen Municipal Department of Agriculture");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Management System");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("X");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyImages/back.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1608, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(22, 22, 22))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 140));

        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 120, 50));

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnUpdate.setText("Edit");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, 150, 50));

        tableFarmer.setBackground(new java.awt.Color(102, 204, 0));
        tableFarmer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Farmer ID", "Last Name", "First Name", "Middle Name", "Extension Name", "House No", "Street", "Barangay", "Municipality", "Province", "Region"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setRowHeight(30);
        jTable2.setSelectionBackground(new java.awt.Color(0, 255, 0));
        jTable2.setShowHorizontalLines(true);
        jTable2.setShowVerticalLines(true);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable2);

        tableFarmer.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 1790, 170));

        jPanel1.add(tableFarmer, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 1810, 190));

        jTabbedPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel4.setOpaque(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFID.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblFID.setText("Farmer ID");
        jPanel4.add(lblFID, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 200, 40));

        txtFName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtFName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel4.add(txtFName, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 80, 220, 40));

        lblFName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblFName.setText("First Name");
        jPanel4.add(lblFName, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 30, 200, 40));

        txtMName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtMName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel4.add(txtMName, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 80, 220, -1));

        lblMName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblMName.setText("Middle Name");
        jPanel4.add(lblMName, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 30, 200, 40));

        txtEName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtEName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel4.add(txtEName, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 80, 220, -1));

        lblEName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblEName.setText("Extension Name");
        jPanel4.add(lblEName, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 30, 190, 40));

        txtSName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtSName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel4.add(txtSName, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 220, 40));

        lblSName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblSName.setText("SurName");
        jPanel4.add(lblSName, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 200, 40));

        txtID.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        jPanel4.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 220, -1));

        lblAddress.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblAddress.setText("Address :");
        jPanel4.add(lblAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 120, 50));

        txtPurok.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtPurok.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel4.add(txtPurok, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 210, 40));

        lblPurok.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblPurok.setText("House Number");
        jPanel4.add(lblPurok, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 200, -1));

        txtStreet.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtStreet.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel4.add(txtStreet, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 220, -1));

        lblStreet.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblStreet.setText("Purok");
        jPanel4.add(lblStreet, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 90, -1));

        lblBarangay.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblBarangay.setText("Barangay");
        jPanel4.add(lblBarangay, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 160, 130, -1));

        txtMunicipality.setEditable(false);
        txtMunicipality.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtMunicipality.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMunicipality.setText("Jaen");
        jPanel4.add(txtMunicipality, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 200, 210, -1));

        lblMunicipality.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblMunicipality.setText("Municipality");
        jPanel4.add(lblMunicipality, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 160, 160, -1));

        txtprovince.setEditable(false);
        txtprovince.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtprovince.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtprovince.setText("Nueva Ecija");
        jPanel4.add(txtprovince, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 200, 230, -1));

        lblProvince.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblProvince.setText("Province");
        jPanel4.add(lblProvince, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 160, -1, -1));

        txtRegion.setEditable(false);
        txtRegion.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtRegion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRegion.setText("3");
        jPanel4.add(txtRegion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1580, 200, 140, -1));

        lblrRegion.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblrRegion.setText("Region");
        jPanel4.add(lblrRegion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1610, 160, 100, -1));

        combobrgy.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        combobrgy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Calabasa", "Dampulan", "Don Mariano Marcos", "Hilera", "Imbunia", "Imelda de Poblacion", "lambakin", "Langla", "magsalisi", "Malabon-kaingin", "Marawa", "Niyugan", "Ocampo-Rivera", "Pakol", "Pamacpacan", "Pinanggaan", "Putlod", "San Jose", "San Josef Nabao", "San Pablo", "San Roque", "San Vicente", "Santa Ine", "Santo Tomas North", "Santo Tomas South", "Sapang", "Ulanin-Pitak" }));
        jPanel4.add(combobrgy, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 200, 220, 40));

        lblContact.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblContact.setText("Contact");
        jPanel4.add(lblContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 120, 40));

        txtContact.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jPanel4.add(txtContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 220, -1));

        lblDate.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblDate.setText("Date of Birth");
        jPanel4.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 260, 170, 40));

        lblPlace.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblPlace.setText("Place of Birth");
        jPanel4.add(lblPlace, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, 170, 40));

        txtPlace.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jPanel4.add(txtPlace, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 220, 41));

        lblSex.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblSex.setText("Gender");
        jPanel4.add(lblSex, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 260, 140, 40));

        jComboSex.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jComboSex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        jPanel4.add(jComboSex, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 300, 180, 40));

        jComboCivil.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jComboCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single", "Married", "Windowed", "Separated" }));
        jPanel4.add(jComboCivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(1580, 300, 140, 40));

        lblCivil.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblCivil.setText("Civil Status");
        jPanel4.add(lblCivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(1580, 260, 150, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setText("Age");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 260, 80, 40));

        jTextField1.setEditable(false);
        jPanel4.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 300, 200, 40));

        lblReligion.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblReligion.setText("Religion :");
        jPanel4.add(lblReligion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 170, 40));

        buttonGroupReligion.add(jCheckChristian);
        jCheckChristian.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jCheckChristian.setText("Christianity");
        jPanel4.add(jCheckChristian, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, -1, 40));

        buttonGroupReligion.add(jCheckIslam);
        jCheckIslam.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jCheckIslam.setText("Islam");
        jPanel4.add(jCheckIslam, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 380, 90, 40));

        buttonGroupReligion.add(jCheckOthers);
        jCheckOthers.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jCheckOthers.setText("Others");
        jPanel4.add(jCheckOthers, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 380, -1, 40));

        txtreligionSpecify.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jPanel4.add(txtreligionSpecify, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 380, 150, 40));

        jDateChooser1.setDateFormatString("MM/dd/yyyy");
        jDateChooser1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jPanel4.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 300, 210, 40));

        jTabbedPane1.addTab("Part 1", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 51, 51));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel5.setOpaque(false);
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboEduc.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jComboEduc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pre-School", "Elementary", "High School (Non K-12)", "Junior High School (K-12)", "Sinior High School (K-12)", "College", "Vocational", "Post-Graduate", "None" }));
        jPanel5.add(jComboEduc, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 260, 40));

        lblPWD.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblPWD.setText("Person With Disability");
        jPanel5.add(lblPWD, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 260, -1));

        lblEduc.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblEduc.setText("Highest Formal education");
        jPanel5.add(lblEduc, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 310, 40));

        buttonGroupPWD.add(jCheckPWDNo);
        jCheckPWDNo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckPWDNo.setText("NO");
        jPanel5.add(jCheckPWDNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, -1, -1));

        buttonGroupPWD.add(jCheckPWDYes);
        jCheckPWDYes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckPWDYes.setText("YES");
        jPanel5.add(jCheckPWDYes, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, -1, -1));

        lbl4Ps.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl4Ps.setText("4P's Beneficiary?");
        jPanel5.add(lbl4Ps, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 200, 40));

        buttonGroup4Ps.add(jCheck4PsYes);
        jCheck4PsYes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheck4PsYes.setText("YES");
        jPanel5.add(jCheck4PsYes, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, -1, -1));

        buttonGroupIndigenous.add(jCheckIndigenousNo);
        jCheckIndigenousNo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckIndigenousNo.setText("NO");
        jPanel5.add(jCheckIndigenousNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 230, -1, 30));

        lblName10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblName10.setText("If Yes Specify");
        jPanel5.add(lblName10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, 40));

        buttonGroupIndigenous.add(jCheckIndigenousYes);
        jCheckIndigenousYes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckIndigenousYes.setText("YES");
        jPanel5.add(jCheckIndigenousYes, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, -1, 30));

        buttonGroup4Ps.add(jCheck4PsNo);
        jCheck4PsNo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheck4PsNo.setText("NO");
        jPanel5.add(jCheck4PsNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, -1, -1));

        lblIndigenous.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblIndigenous.setText("Members of Indigenous Group");
        jPanel5.add(lblIndigenous, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 360, -1));

        txtAssociationSpecify.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jPanel5.add(txtAssociationSpecify, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 380, 200, 40));

        lblHouseHold.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblHouseHold.setText("House Hold Head");
        jPanel5.add(lblHouseHold, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 210, 210, 40));

        buttonGroupHouse.add(jCheckHouseYes);
        jCheckHouseYes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckHouseYes.setText("YES");
        jPanel5.add(jCheckHouseYes, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 210, -1, -1));

        buttonGroupHouse.add(jCheckHouseNo);
        jCheckHouseNo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckHouseNo.setText("NO");
        jPanel5.add(jCheckHouseNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 210, -1, -1));

        lblIfnoHouse.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblIfnoHouse.setText("If no, Name house Hold Head :");
        jPanel5.add(lblIfnoHouse, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 270, -1, 40));

        lblRelatioship.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblRelatioship.setText("Relationship :");
        jPanel5.add(lblRelatioship, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 380, 190, 40));

        lblNoofLiving.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblNoofLiving.setText("No. Of Living Household Members :");
        jPanel5.add(lblNoofLiving, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 20, 430, 40));

        lblMale.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblMale.setText("No. of Male :");
        jPanel5.add(lblMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 120, 420, 40));

        lblFemale.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblFemale.setText("No. of Female :");
        jPanel5.add(lblFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 180, 420, 40));

        txtIfnoHouse.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jPanel5.add(txtIfnoHouse, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 320, 430, 40));

        txtRelationship.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jPanel5.add(txtRelationship, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 380, 230, 40));

        txtMale.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jPanel5.add(txtMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(1540, 120, 180, 40));

        txtFemale.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        jPanel5.add(txtFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(1540, 180, 180, 40));

        txtNoofLiving.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jPanel5.add(txtNoofLiving, new org.netbeans.lib.awtextra.AbsoluteConstraints(1540, 60, 180, 40));

        lblName22.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblName22.setText("If Yes Specify");
        jPanel5.add(lblName22, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, -1, 40));

        buttonGroupFarmers.add(jCheckAssociationYes);
        jCheckAssociationYes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckAssociationYes.setText("YES");
        jPanel5.add(jCheckAssociationYes, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, -1, 40));

        buttonGroupFarmers.add(jCheckAssociationNo);
        jCheckAssociationNo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckAssociationNo.setText("NO");
        jPanel5.add(jCheckAssociationNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, -1, 40));

        lblEmergency.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblEmergency.setText("InCase of Emergency :");
        jPanel5.add(lblEmergency, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 230, 270, 40));

        txtEmergency.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jPanel5.add(txtEmergency, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 270, 320, 40));

        txtContactNo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jPanel5.add(txtContactNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1520, 330, 200, 40));

        lblContactNo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblContactNo.setText("Contact Number :");
        jPanel5.add(lblContactNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 330, 270, 40));

        txtIndigenousSpecify.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jPanel5.add(txtIndigenousSpecify, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 230, 40));

        lblGoverment.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblGoverment.setText("With Goverment ID?");
        jPanel5.add(lblGoverment, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, 290, 50));

        buttonGroupGoverment.add(jCheckGovYes);
        jCheckGovYes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckGovYes.setText("YES");
        jPanel5.add(jCheckGovYes, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 30, -1, -1));

        buttonGroupGoverment.add(jCheckGovNo);
        jCheckGovNo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckGovNo.setText("NO");
        jPanel5.add(jCheckGovNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 30, -1, -1));

        lblIDtype.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblIDtype.setText("If Yes Specify ID type");
        jPanel5.add(lblIDtype, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 80, -1, 40));

        txtIDtype.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jPanel5.add(txtIDtype, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 80, 160, 40));

        lblID.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblID.setText("ID Number :");
        jPanel5.add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 140, 230, 40));

        txtIDNumbber.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jPanel5.add(txtIDNumbber, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 140, 240, 40));

        lblFarmerAssociation.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblFarmerAssociation.setText("Member of any farmers Association/Cooperative?");
        jPanel5.add(lblFarmerAssociation, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 580, 40));

        jTabbedPane1.addTab("Part 2", jPanel5);

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblmain3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblmain3.setText("Main LiveLiHood");
        jPanel2.add(lblmain3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 210, -1));

        lblName44.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblName44.setText("For Farmers");
        jPanel2.add(lblName44, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 161, -1));

        lblName43.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblName43.setText("Types of Farming Activity");
        jPanel2.add(lblName43, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 300, -1));

        jCheckRice1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckRice1.setText("Rice");
        jPanel2.add(jCheckRice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 82, -1));

        jCheckCorn1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckCorn1.setText("Corn");
        jPanel2.add(jCheckCorn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 120, -1));

        jCheckFarmOthers1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckFarmOthers1.setText("Others Crops");
        jPanel2.add(jCheckFarmOthers1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 190, -1));

        lblName45.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblName45.setText("Please Specify");
        jPanel2.add(lblName45, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, -1, -1));
        jPanel2.add(txtOtherSpecify1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 290, 40));

        jCheckFarmer3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckFarmer3.setText("Farmer");
        jPanel2.add(jCheckFarmer3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 120, -1));

        jCheckLive1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckLive1.setText("LiveStock");
        jPanel2.add(jCheckLive1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 170, -1));

        lblName46.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblName46.setText("Please Specify");
        jPanel2.add(lblName46, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 190, -1));
        jPanel2.add(txtLiveSpecify1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 280, 40));

        jCheckPoultry1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckPoultry1.setText("Poultry");
        jPanel2.add(jCheckPoultry1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 120, -1));

        lblName47.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblName47.setText("Please Specify");
        jPanel2.add(lblName47, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 170, -1));
        jPanel2.add(txtPoultrySpecify1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 290, 40));

        jCheckFarmLabor1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckFarmLabor1.setText("FarmWorker/laborer");
        jPanel2.add(jCheckFarmLabor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, -1, -1));

        SeperatorForFarmer.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.add(SeperatorForFarmer, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 330, 430));

        lblName49.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblName49.setText("Kind of Works");
        jPanel2.add(lblName49, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, -1, -1));

        jCheckLand1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckLand1.setText("LandPreparation");
        jPanel2.add(jCheckLand1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, -1, -1));

        jCheckPlanting1.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jCheckPlanting1.setText("Planting/TransPlanting");
        jPanel2.add(jCheckPlanting1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, -1, -1));

        jCheckCultivation1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckCultivation1.setText("Cultivation");
        jPanel2.add(jCheckCultivation1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, -1, -1));

        lblName20.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblName20.setText("For FarmWorkers");
        jPanel2.add(lblName20, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, -1, 30));

        jCheckHarvest1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckHarvest1.setText("Harvesting");
        jPanel2.add(jCheckHarvest1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 250, -1, -1));

        jCheckFarmworkerHarvest1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckFarmworkerHarvest1.setText("Others");
        jPanel2.add(jCheckFarmworkerHarvest1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, -1, -1));

        lblName75.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblName75.setText("Please Specify");
        jPanel2.add(lblName75, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, -1, -1));
        jPanel2.add(txtFarmWorkerSpecify1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 390, 260, 40));

        SeperatorFarmWorkers.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.add(SeperatorFarmWorkers, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 330, 430));

        jCheckFish1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckFish1.setText("FisherFolk");
        jPanel2.add(jCheckFish1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 0, -1, -1));

        jTextArea4.setBackground(new java.awt.Color(242, 242, 242));
        jTextArea4.setColumns(20);
        jTextArea4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jTextArea4.setRows(5);
        jTextArea4.setText("The lending Conduct shall coordinate \nwiththe Bureau of Fisherlesand Aquatic \nresources (BFAR) in the Issurance of a \ncertification that the fisherfolk-borrower\nuner PUNLA?PLEA is registered under the \nMunicipalRegistration (FishR).");
        jTextArea4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane5.setViewportView(jTextArea4);

        jPanel2.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 70, 410, 120));

        lblName51.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblName51.setText("For Argri Youth");
        jPanel2.add(lblName51, new org.netbeans.lib.awtextra.AbsoluteConstraints(1460, 40, 190, -1));

        jCheckAqua2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckAqua2.setText("AquaCulture");
        jPanel2.add(jCheckAqua2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 270, -1, -1));

        jCheckFishOthers1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckFishOthers1.setText("Others Please Specify");
        jPanel2.add(jCheckFishOthers1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 350, -1, -1));
        jPanel2.add(txtFishSpecify2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 400, 230, 40));

        jCheckFishProcess1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckFishProcess1.setText("Fish Processing");
        jPanel2.add(jCheckFishProcess1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 230, -1, -1));

        jCheckFishVending1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckFishVending1.setText("Fish Vending");
        jPanel2.add(jCheckFishVending1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 310, -1, -1));

        jCheckFishCapture2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckFishCapture2.setText("Fish Capture");
        jPanel2.add(jCheckFishCapture2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 230, -1, -1));

        lblName74.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblName74.setText("Types of Fishing Activity");
        jPanel2.add(lblName74, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 190, 290, -1));

        jCheckGleaning1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckGleaning1.setText("Gleaning");
        jPanel2.add(jCheckGleaning1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 280, -1, -1));

        jTextArea5.setBackground(new java.awt.Color(242, 242, 242));
        jTextArea5.setColumns(20);
        jTextArea5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jTextArea5.setRows(5);
        jTextArea5.setText("For the purposes of trainings,financial \nassistance, and the other programs \ncatered to the youth with involvement\nto any aggriculture activitty.");
        jScrollPane6.setViewportView(jTextArea5);

        jPanel2.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 70, 390, 110));

        jCheckPart1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckPart1.setText("part of a farming household");
        jPanel2.add(jCheckPart1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 210, -1, -1));

        jCheckNonFromal1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckNonFromal1.setText("attending/attended non/formal ");
        jPanel2.add(jCheckNonFromal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 290, -1, -1));

        lblName48.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblName48.setText("agri/fishery related course");
        jPanel2.add(lblName48, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 320, -1, -1));

        lblName50.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblName50.setText("Types of Involvement");
        jPanel2.add(lblName50, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 180, 290, -1));

        jCheckAgri1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckAgri1.setText("Agri Youth");
        jPanel2.add(jCheckAgri1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1480, 0, -1, 30));

        jCheckFormal1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckFormal1.setText("attending/attended formal ");
        jPanel2.add(jCheckFormal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 240, -1, -1));

        lblName77.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblName77.setText("agri/fishery related course");
        jPanel2.add(lblName77, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 270, 320, 30));

        jCheckParticipated1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckParticipated1.setText("participated in any agricultural ");
        jPanel2.add(jCheckParticipated1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 340, -1, -1));

        lblName76.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblName76.setText("activity/program");
        jPanel2.add(lblName76, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 370, -1, -1));

        jCheckBox44.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckBox44.setText("Others, Specify");
        jPanel2.add(jCheckBox44, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 400, -1, -1));
        jPanel2.add(jTextAgriSpecify1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1530, 400, 200, 40));

        lblName52.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblName52.setText("For FisherFolk");
        jPanel2.add(lblName52, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 40, 190, -1));

        SeperatorFisher.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.add(SeperatorFisher, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 30, 480, 430));

        SeperetorAgri.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.add(SeperetorAgri, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 30, 460, 430));

        jTabbedPane1.addTab("Part 3", jPanel2);

        jPanel6.setOpaque(false);
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblImage1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        lblImage1.setOpaque(true);
        lblImage1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImage1MouseClicked(evt);
            }
        });
        jPanel6.add(lblImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 300, 340));
        jPanel6.add(txtPath1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 300, 40));

        lblImage2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        lblImage2.setOpaque(true);
        lblImage2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImage2MouseClicked(evt);
            }
        });
        jPanel6.add(lblImage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 310, 340));
        jPanel6.add(txtPath2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, 310, 40));

        lblImage3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        lblImage3.setOpaque(true);
        lblImage3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImage3MouseClicked(evt);
            }
        });
        jPanel6.add(lblImage3, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 90, 310, 340));
        jPanel6.add(txtPath3, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 40, 310, 40));

        lblImage4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        lblImage4.setOpaque(true);
        lblImage4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImage4MouseClicked(evt);
            }
        });
        jPanel6.add(lblImage4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 90, 310, 350));

        txtPath4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPath4ActionPerformed(evt);
            }
        });
        jPanel6.add(txtPath4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 30, 320, 40));

        jTabbedPane1.addTab("Part4", jPanel6);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 480, 1810, 530));

        txtDates.setFont(new java.awt.Font("Segoe UI Semibold", 2, 24)); // NOI18N
        txtDates.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDates.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel1.add(txtDates, new org.netbeans.lib.awtextra.AbsoluteConstraints(1710, 150, 140, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 2, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1550, 150, 60, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 2, 22)); // NOI18N
        jLabel6.setText("Total of the Farmers Register");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 150, 300, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 2, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Date :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1610, 150, 90, 40));

        lblDateReg.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lblDateReg.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Date Register", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Semibold", 2, 18))); // NOI18N
        jPanel1.add(lblDateReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 200, 60));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 410, -1, 50));

        getContentPane().add(jPanel1);

        setSize(new java.awt.Dimension(1902, 1200));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
 
          
       System.out.println("Image Path1 - " + path1);
       System.out.println("Image Name1 - "+ filename1.getName());
       File file1 = new File(path1);
       
        System.out.println("Image Path2 - " + path2);
       System.out.println("Image Name2 - "+ filename2.getName());
       File file2 = new File(path2);
       
        System.out.println("Image Path3 - " + path3);
       System.out.print("Image Name3 - "+ filename3.getName());
       File file3 = new File(path3);
       
        System.out.println("Image Path4 - " + path3);
       System.out.println("Image Name4 - "+ filename3.getName());
       File file4 = new File(path3);
      
       
         
           if(path1 != null){
               try{
              
              InputStream image1 = new FileInputStream(file1);
              InputStream image2 = new FileInputStream(file2);
              InputStream image3 = new FileInputStream(file3);
              InputStream image4 = new FileInputStream(file4);
              
               
               String query1 = "insert into images(Image_ID,ImageName1,ImagePath1,ImageFile1,ImageName2,ImagePath2,ImageFile2,ImageName3,"
                       + "ImagePath3,ImageFile3,ImageName4,ImagePath4,ImageFile4) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
              insert = con1.prepareStatement(query1);
              insert.setString(1, txtID.getText());
              insert.setString(2, filename1.getName());
              insert.setString(3, path1);
              insert.setBlob(4, image1);
              insert.setString(5, filename2.getName());
              insert.setString(6, path2);
              insert.setBlob(7, image2);
              insert.setString(8, filename3.getName());
              insert.setString(9, path3);
              insert.setBlob(10, image3);
              insert.setString(11, filename4.getName());
              insert.setString(12, path4);
              insert.setBlob(13, image4);
                   
               if(insert.executeUpdate()  > 0){
                   
               }
        
               
               
               
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd");
        String dates = format.format(jDateChooser1.getDate());
        
        String SName = txtSName.getText();
        String FName = txtFName.getText();
        String MName = txtMName.getText();
        String EName = txtEName.getText();
        
        String HouseNo = txtPurok.getText();
        String street = txtStreet.getText();
        String baranggay = combobrgy.getSelectedItem().toString();
        String municipal = txtMunicipality.getText();
        String province = txtprovince.getText();
        String region = txtRegion.getText();   
        
        String educ = jComboEduc.getSelectedItem().toString();
        String reg = txtreligionSpecify.getText();
        String indi = txtIndigenousSpecify.getText();
        String Association = txtAssociationSpecify.getText();
        String IDType = txtIDtype.getText(); 
        String IDNumber = txtIDNumbber.getText();
        String If = txtIfnoHouse.getText();
        String relation = txtRelationship.getText();
        String member = txtNoofLiving.getText();
        String male = txtMale.getText();
        String female = txtFemale.getText();
        String emergency = txtEmergency.getText();
        String emergencycontact = txtContactNo.getText();
        
        
        String religion = null;
        String pwd = null;
        String four = null;
        String indigenous = null;
        String farmersAssociation = null;
        String GovermentID = null;
        String house = null;
   
        String contact = txtContact.getText();
        String sex = jComboSex.getSelectedItem().toString();
        String place = txtPlace.getText();
        String civil = jComboCivil.getSelectedItem().toString();
       
     // This for Religion//
      if(jCheckChristian.isSelected()){
                religion = "Christianity";
                
            }
           else if(jCheckIslam.isSelected()){
                religion = "Islam";
            }
           else if(jCheckOthers.isSelected()){
                religion = "Others";
            }

      //This is for PWD//
       if(jCheckPWDYes.isSelected()){
                pwd = "YES";
                
            }
           else if(jCheckPWDNo.isSelected()){
                pwd = "NO";
            }
          
           //This is for 4P's//
        if(jCheck4PsYes.isSelected()){
               four = "YES";
                
            }
           else if(jCheck4PsNo.isSelected()){
                four = "NO";
            }
      
        //This is for Indigenous//
        if(jCheckIndigenousYes.isSelected()){
               indigenous = "YES";
                
            }
           else if(jCheckIndigenousNo.isSelected()){
                indigenous = "NO";
            }
        
        //This is for Farmer Association//
         if(jCheckAssociationYes.isSelected()){
               farmersAssociation = "YES";
                
            }
           else if(jCheckAssociationNo.isSelected()){
                farmersAssociation = "NO";
            }
        
             //This is for Goverment ID//
         if(jCheckGovYes.isSelected()){
               GovermentID = "YES";
               
                
            }
           else if(jCheckGovNo.isSelected()){
                GovermentID = "NO";
            }
         
         if(jCheckHouseYes.isSelected()){
               house = "YES";
                
            }
           else if(jCheckHouseNo.isSelected()){
                house = "NO";
            }
        
      
        
    
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            insert = con1.prepareStatement("insert into profile(FID,LName,FName,MName,EName,House_No,Street,Barangay,Municipality,"
                    + "Province,Region,Contact,Date_of_Birth,Place_of_Birth,Civil_Status,Sex,Highest_Education,Religion,Religion_Specify,"
                    + "PWD,4Ps_Benificiary,Members_of_Indigenous,Indigen_Specify,MoaFAC,Mofac_Specify,With_Goverment_ID,GovermentID_Specify,"
                    + "ID_Number,House_Hold_Head,If_no_Name_of_House_Hold_Head,Relationship,NO_House_Hold_Member,No_Male,No_Female,"
                    + "Person_to_notify_in_case_of_emergency,Contact_No) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
    
            
            insert.setString(1, txtID.getText());
            insert.setString(2, SName);
            insert.setString(3, FName);
            insert.setString(4, MName);
            insert.setString(5, EName);
            insert.setString(6, HouseNo);
            insert.setString(7, street);
            insert.setString(8, baranggay);
            insert.setString(9, municipal);            
            insert.setString(10, province);
            insert.setString(11, region);
            insert.setString(12, contact);
            insert.setString(13, dates);
            insert.setString(14, place);
            insert.setString(15, civil);
            insert.setString(16, sex);
            insert.setString(17, educ);
            insert.setString(18, religion);
            insert.setString(19, reg);
            insert.setString(20, pwd);
            insert.setString(21, four);
            insert.setString(22, indigenous); 
            insert.setString(23, indi);        
            insert.setString(24, farmersAssociation );
            insert.setString(25, Association );        
            insert.setString(26, GovermentID );
            insert.setString(27, IDType );
            insert.setString(28, IDNumber );
            insert.setString(29, house );
            insert.setString(30, If );
            insert.setString(31, relation );
            insert.setString(32, member );
            insert.setString(33, male);
            insert.setString(34, female );
            insert.setString(35, emergency );
            insert.setString(36, emergencycontact );
            insert.executeUpdate();
            
             JOptionPane.showMessageDialog(this,"Record Addedd!!");
             Totalfarmer();
             autoid();
             table_update(); 
  
         
          txtSName.setText("");
          txtFName.setText("");
          txtMName.setText("");
          txtEName.setText("");
          txtPurok.setText("");
          txtStreet.setText("");
          txtContact.setText("");
          txtPlace.setText("");
          txtIDNumbber.setText("");
          txtIndigenousSpecify.setText("");
          txtIDtype.setText("");
          txtAssociationSpecify.setText("");
          txtIfnoHouse.setText("");
          txtRelationship.requestFocus();
          txtNoofLiving.setText("");
          txtMale.setText("");
          txtFemale.setText("");
          txtEmergency.setText("");
          txtContactNo.requestFocus();
          
            try {
                 Date date = new Date();
          SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
          String currentdate = dateformat.format(date);
          txtDates.setText(currentdate);
          
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
             insert = con1.prepareStatement("insert into register_date(Farmer_ID,Date_Register) values (?,?)");
            insert.setString(1, txtID.getText());
            insert.setString(2, currentdate);
             insert.executeUpdate();
             txtID.requestFocus();
            } catch(Exception e){
            
       
        }
          
        } catch(Exception e){
            
       
        }
  
               }catch(Exception e){
                   
               }
           }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        
        // This is for Image 1
         if(path1 != null){
             try{
                 
                 
                       System.out.print("Image Path1 - " + path1);
                       System.out.print("Image Name1 - "+ filename1.getName());
                      InputStream image1 = new FileInputStream(path1);
                      
                      
                      
               String query1 = "UPDATE images SET ImageName1=?, ImagePath1=?, ImageFile1=? WHERE Image_ID=?";
              insert = con1.prepareStatement(query1);
              insert.setString(4, txtID.getText());      
              insert.setString(1, filename1.getName()); 
              insert.setString(2, path1); 
              insert.setBlob(3, image1);
              if(insert.executeUpdate()  > 0){
                   
            
              }

                 }catch(Exception e){
      
              }
    
        }
         
         // This is for Image 2
         if(path2 != null){
             try{
                 
                 
                       System.out.print("Image Path2 - " + path2);
                       System.out.print("Image Name2 - "+ filename2.getName());
                      InputStream image2 = new FileInputStream(path2);
        
               String query1 = "UPDATE images SET ImageName2=?, ImagePath2=?, ImageFile2=? WHERE Image_ID=?";
              insert = con1.prepareStatement(query1);
              insert.setString(4, txtID.getText());      
              insert.setString(1, filename2.getName()); 
              insert.setString(2, path2); 
              insert.setBlob(3, image2);
              if(insert.executeUpdate()  > 0){
                   
            
              }

                 }catch(Exception e){
      
              }
    
        }
         
         // This is for Image 3
         if(path1 != null){
             try{
                 
                 
                       System.out.print("Image Path 3 - " + path3);
                       System.out.print("Image Name 3 - "+ filename3.getName());
                      InputStream image3 = new FileInputStream(path3);
                      
                      
                      
               String query1 = "UPDATE images SET ImageName3=?, ImagePath3=?, ImageFile3=? WHERE Image_ID=?";
              insert = con1.prepareStatement(query1);
              insert.setString(4, txtID.getText());      
              insert.setString(1, filename3.getName()); 
              insert.setString(2, path3); 
              insert.setBlob(3, image3);
              if(insert.executeUpdate()  > 0){
                   
            
              }

                 }catch(Exception e){
      
              }
    
        }
         
         // This is for Image 4
         if(path1 != null){
             try{
                 
                 
                       System.out.print("Image Path 4 - " + path4);
                       System.out.print("Image Name 4 - "+ filename4.getName());
                      InputStream image4 = new FileInputStream(path4);
            
               String query1 = "UPDATE images SET ImageName4=?, ImagePath4=?, ImageFile4=? WHERE Image_ID=?";
              insert = con1.prepareStatement(query1);
              insert.setString(4, txtID.getText());      
              insert.setString(1, filename4.getName()); 
              insert.setString(2, path4); 
              insert.setBlob(3, image4);
              if(insert.executeUpdate()  > 0){
                   
            
              }

                 }catch(Exception e){
      
              }
    
        }
        
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd");
        String dates = format.format(jDateChooser1.getDate());
        
       
        String SName = txtSName.getText();
        String FName = txtFName.getText();
        String MName = txtMName.getText();
        String EName = txtEName.getText();
        
        String HouseNo = txtPurok.getText();
        String street = txtStreet.getText();
        String baranggay = combobrgy.getSelectedItem().toString();
        String municipal = txtMunicipality.getText();
        String province = txtprovince.getText();
        String region = txtRegion.getText();
        
        String educ = jComboEduc.getSelectedItem().toString();
        String reg = txtreligionSpecify.getText();
        String indi = txtIndigenousSpecify.getText();
        String Association = txtAssociationSpecify.getText();
        String IDType = txtIDtype.getText(); 
        String IDNumber = txtIDNumbber.getText();
        String If = txtIfnoHouse.getText();
        String relation = txtRelationship.getText();
        String member = txtNoofLiving.getText();
        String male = txtMale.getText();
        String female = txtFemale.getText();
        String emergency = txtEmergency.getText();
        String emergencycontact = txtContactNo.getText();
        
        
        String religion = null;
        String pwd = null;
        String four = null;
        String indigenous = null;
        String farmersAssociation = null;
        String GovermentID = null;
        String house = null;
        
   
        String contact = txtContact.getText();
        String sex = jComboSex.getSelectedItem().toString();
        String place = txtPlace.getText();
        String civil = jComboCivil.getSelectedItem().toString();
       
        
      
 
     
     // This for Religion//
      if(jCheckChristian.isSelected()){
                religion = "Christianity";
                
            }
           else if(jCheckIslam.isSelected()){
                religion = "Islam";
            }
           else if(jCheckOthers.isSelected()){
                religion = "Others";
            }

      //This is for PWD//
       if(jCheckPWDYes.isSelected()){
                pwd = "YES";
                
            }
           else if(jCheckPWDNo.isSelected()){
                pwd = "NO";
            }
          
           //This is for 4P's//
        if(jCheck4PsYes.isSelected()){
               four = "YES";
                
            }
           else if(jCheck4PsNo.isSelected()){
                four = "NO";
            }
      
        //This is for Indigenous//
        if(jCheckIndigenousYes.isSelected()){
               indigenous = "YES";
                
            }
           else if(jCheckIndigenousNo.isSelected()){
                indigenous = "NO";
            }
        
        //This is for Farmer Association//
         if(jCheckAssociationYes.isSelected()){
               farmersAssociation = "YES";
                
            }
           else if(jCheckAssociationNo.isSelected()){
                farmersAssociation = "NO";
            }
        
             //This is for Goverment ID//
         if(jCheckGovYes.isSelected()){
               GovermentID = "YES";
                
            }
           else if(jCheckGovNo.isSelected()){
                GovermentID = "NO";
            }
         
         if(jCheckHouseYes.isSelected()){
               house = "YES";
                
            }
           else if(jCheckHouseNo.isSelected()){
                house = "NO";
            }
                
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            insert = con1.prepareStatement("UPDATE profile set LName=?,FName=?,MName=?,EName=?,House_No=?,Street=?,"
                    + "Barangay=?,Municipality=?,Province=?,Region=?,Contact=?,Sex=?,Date_of_Birth=?,Place_of_Birth=?,"
                    + "Civil_Status=?,Highest_Education=?,Religion=?,Religion_Specify=?,PWD=?,4Ps_Benificiary=?,"
                    + "Members_of_Indigenous=?,Indigen_Specify=?,MoaFAC=?,Mofac_Specify=?,With_Goverment_ID=?,"
                    + "GovermentID_Specify=?,ID_Number=?,House_Hold_Head=?,If_no_Name_of_House_Hold_Head=?,"
                    + "Relationship=?,NO_House_Hold_Member=?,No_Male=?,No_Female=?,Person_to_notify_in_case_of_emergency=?,"
                    + "Contact_No=? WHERE FID=?");
    
            
           insert.setString(36, txtID.getText());
            insert.setString(1, SName);
            insert.setString(2, FName);
            insert.setString(3, MName);
            insert.setString(4, EName);
            insert.setString(5, HouseNo);
            insert.setString(6, street);
            insert.setString(7, baranggay);
            insert.setString(8, municipal);            
            insert.setString(9, province);
            insert.setString(10, region);
            insert.setString(11, contact);
            insert.setString(12, sex);
            insert.setString(13, dates);
            insert.setString(14, place);
            insert.setString(15, civil);
            insert.setString(16, educ);
            insert.setString(17, religion);
            insert.setString(18, reg);
            insert.setString(19, pwd);
            insert.setString(20, four);
            insert.setString(21, indigenous); 
            insert.setString(22, indi);        
            insert.setString(23, farmersAssociation );
            insert.setString(24, Association );        
            insert.setString(25, GovermentID );
            insert.setString(26, IDType );
            insert.setString(27, IDNumber );
            insert.setString(28, house );
            insert.setString(29, If );
            insert.setString(30, relation );
            insert.setString(31, member );
            insert.setString(32, male);
            insert.setString(33, female );
            insert.setString(34, emergency );
            insert.setString(35, emergencycontact );
            insert.executeUpdate();
            
            JOptionPane.showMessageDialog(this,"Edit Successful");
            table_update();
            
          
          txtID.setText("");
          txtSName.setText("");
          txtFName.setText("");
          txtMName.setText("");
          txtEName.setText("");
          txtPurok.setText("");
          txtStreet.setText("");
          txtContact.setText("");
          txtPlace.setText("");
          txtIDNumbber.setText("");
          txtID.requestFocus();
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
       Home home = new Home();
       home.setVisible(true);
       dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
         DefaultTableModel Df = (DefaultTableModel)jTable2.getModel();
         int SelectedRows = jTable2.getSelectedRow();
       
       txtID.setText(Df.getValueAt(SelectedRows, 0).toString());
       txtSName.setText(Df.getValueAt(SelectedRows,1).toString());
       txtFName.setText(Df.getValueAt(SelectedRows, 2).toString());
       txtMName.setText(Df.getValueAt(SelectedRows, 3).toString());
       txtEName.setText(Df.getValueAt(SelectedRows, 4).toString());
       txtPurok.setText(Df.getValueAt(SelectedRows, 5).toString());
       txtStreet.setText(Df.getValueAt(SelectedRows, 6).toString());
       combobrgy.setSelectedItem(Df.getValueAt(SelectedRows, 7).toString());
       txtMunicipality.setText(Df.getValueAt(SelectedRows, 8).toString());
       txtprovince.setText(Df.getValueAt(SelectedRows, 9).toString());
       txtRegion.setText(Df.getValueAt(SelectedRows, 10).toString());
      
       
       try{
            
                Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            String query ="SELECT Contact,Sex,Date_of_Birth,Place_of_Birth,Civil_Status,Highest_Education,Religion,Religion_Specify,"
                    + "PWD,4Ps_Benificiary,Members_of_Indigenous,Indigen_Specify,MoaFAC,Mofac_Specify,With_Goverment_ID,"
                    + "GovermentID_Specify,ID_Number,House_Hold_Head,If_no_Name_of_House_Hold_Head,"
                    + "Relationship,NO_House_Hold_Member,No_Male,No_Female,Person_to_notify_in_case_of_emergency,Contact_No from profile where FID = ?";
            insert=con1.prepareStatement(query);
            insert.setString(1, txtID.getText());
            rst = insert.executeQuery();
        
          
               
                while(rst.next()){
                      
                      String contact = rst.getString("Contact");
                      txtContact.setText(contact);
                      String sex = rst.getString("Sex");
                      jComboSex.setSelectedItem(sex);
                      Date date = rst.getDate("Date_of_Birth");
                      jDateChooser1.setDate(date);
                      String place = rst.getString("Place_of_Birth");
                      txtPlace.setText(place);
                      String civil = rst.getString("Civil_Status");
                      jComboCivil.setSelectedItem(civil);
                      String educ = rst.getString("Highest_Education");
                      jComboEduc.setSelectedItem(educ);
                      
                     
                      String religion = rst.getString("Religion");
                      String religionspecify = rst.getString("Religion_Specify");
                      if(religion.equals("Christianity")){
                          jCheckChristian.setSelected(true);
                      }else if(religion.equals("Islam")){
                          jCheckIslam.setSelected(true);
                          
                      }else if(religion.equals("Others")){
                          jCheckOthers.setSelected(true);
                        txtreligionSpecify.setText(religionspecify);
                          
                      }
                      
                      String pwd = rst.getString("PWD");
                      if(pwd.equals("YES")){
                          jCheckPWDYes.setSelected(true);
                      }else if(pwd.equals("NO")){
                         jCheckPWDNo.setSelected(true);
                          
                      }
                          
                      String four = rst.getString("4Ps_Benificiary");
                      if(four.equals("YES")){
                          jCheck4PsYes.setSelected(true);
                      }else if(four.equals("NO")){
                         jCheck4PsNo.setSelected(true);
                          
                      }
                      
                       String indigen = rst.getString("Members_of_Indigenous");
                       String indigenspecify = rst.getString("Indigen_Specify");
                      if(indigen.equals("YES")){
                          jCheckIndigenousYes.setSelected(true);
                          txtIndigenousSpecify.setText(indigenspecify);
                      }else if(indigen.equals("NO")){
                         jCheckIndigenousNo.setSelected(true);
                          
                      }
                      
                       String moafac = rst.getString("MoaFAC");
                       String mofacspecify = rst.getString("Mofac_Specify");
                        if(moafac.equals("YES")){
                          jCheckAssociationYes.setSelected(true);
                         txtAssociationSpecify.setText(mofacspecify);
                      }else if(moafac.equals("NO")){
                         jCheckAssociationNo.setSelected(true);
                          
                      }
                       
                       String gov =rst.getString("With_Goverment_ID");
                       String govSpecify = rst.getString("GovermentID_Specify");
                       String num = rst.getString("ID_Number");
                       
                      if(gov.equals("YES")){
                          jCheckGovYes.setSelected(true);
                          txtIDtype.setText(govSpecify);
                          txtIDNumbber.setText(num);
                      }else if(gov.equals("NO")){
                         jCheckGovNo.setSelected(true);
                          
                      }
                      
                    String head = rst.getString("House_Hold_Head");
                    String yes = rst.getString("If_no_Name_of_House_Hold_Head");
                      if(head.equals("YES")){
                          jCheckHouseYes.setSelected(true);
                      }else if(head.equals("NO")){
                         jCheckHouseNo.setSelected(true);
                         txtIfnoHouse.setText(yes);
                          
                      }
                       String relationship = rst.getString("Relationship");
                      txtRelationship.setText(relationship);
                      String no_member = rst.getString("NO_House_Hold_Member");
                      txtNoofLiving.setText(no_member);
                      String male = rst.getString("No_Male");
                      txtMale.setText(male);
                      String female = rst.getString("No_Female");
                      txtFemale.setText(female);
                      String emergency = rst.getString("Person_to_notify_in_case_of_emergency");
                      txtEmergency.setText(emergency);
                      String contact1 = rst.getString("Contact_No");
                      txtContactNo.setText(contact1);
  
                }
            
                 String id = txtID.getText();
        try{
              
              Class.forName("com.mysql.cj.jdbc.Driver");
               con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            String sql ="SELECT * FROM images where Image_ID=?";
           
            insert = con1.prepareStatement(sql);
            insert.setString(1, id);
            rst = insert.executeQuery();
            
            if(rst.next()){
                 txtID.setText(id);
              
                  //This is for Image 1
                     path1 = rst.getString("ImagePath1");
                     File newfilename1 = new File("ImageName1");
                     byte[] ImageData = rst.getBytes("ImageFile1");
                     format1 = new ImageIcon(ImageData);
                     Image mm = format1.getImage();
                     Image img1 = mm.getScaledInstance(lblImage1.getWidth(), lblImage1.getHeight(), Image.SCALE_SMOOTH);
                     ImageIcon image1 = new ImageIcon(img1);
                     lblImage1.setIcon(image1);
                     txtPath1.setText(path1);
                     
                     //This for Image 2
                      path2 = rst.getString("ImagePath2");
                     File newfilename2 = new File("ImageName2");
                     byte[] ImageData2 = rst.getBytes("ImageFile2");
                     format2 = new ImageIcon(ImageData2);
                     Image mm2 = format2.getImage();
                     Image img2 = mm2.getScaledInstance(lblImage2.getWidth(), lblImage2.getHeight(), Image.SCALE_SMOOTH);
                     ImageIcon image2 = new ImageIcon(img2);
                     lblImage2.setIcon(image2);
                     txtPath2.setText(path2);
                     
                     
                      //This for Image 3
                     path3 = rst.getString("ImagePath3");
                     File newfilename3 = new File("ImageName3");
                     byte[] ImageData3 = rst.getBytes("ImageFile3");
                     format3 = new ImageIcon(ImageData3);
                     Image mm3 = format3.getImage();
                     Image img3 = mm3.getScaledInstance(lblImage3.getWidth(), lblImage3.getHeight(), Image.SCALE_SMOOTH);
                     ImageIcon image3 = new ImageIcon(img3);
                     lblImage3.setIcon(image3);
                     txtPath3.setText(path3);
                     
                     
                     //This is for Image4
                     path4 = rst.getString("ImagePath4");
                     File newfilename4 = new File("ImageName4");
                     byte[] ImageData4 = rst.getBytes("ImageFile4");
                     format4 = new ImageIcon(ImageData4);
                     Image mm4 = format4.getImage();
                     Image img4 = mm4.getScaledInstance(lblImage4.getWidth(), lblImage4.getHeight(), Image.SCALE_SMOOTH);
                     ImageIcon image4 = new ImageIcon(img4);
                     lblImage4.setIcon(image4);
                     txtPath4.setText(path4);
    
        }
           
            
        }
             catch (SQLException ex) {
                     
                  } catch (ClassNotFoundException ex) {
       
    }
                    
            
        }catch(Exception e){
            
        }
        try {
  
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
              String sql ="SELECT Date_Register FROM register_date where Farmer_ID=?";      
            insert = con1.prepareStatement(sql);
            insert.setString(1, txtID.getText());
            rst = insert.executeQuery();
            while(rst.next()){
                String date = rst.getString("Date_Register");
                lblDateReg.setText(date);
                
                
            }
            
            } catch(Exception e){
            
       
        }
       
      
    }//GEN-LAST:event_jTable2MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
         Home home = new Home();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtIDActionPerformed

    private void lblImage1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImage1MouseClicked
        // TODO add your handling code here:
         JFileChooser filechooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG JPG AND JPEG","png","jpg","jpeg");
        filechooser.addChoosableFileFilter(filter);
        int load =  filechooser.showOpenDialog(null);
        
        if(load==filechooser.APPROVE_OPTION){
            filename1 = filechooser.getSelectedFile();
            
            path1 = filename1.getAbsolutePath();
            txtPath1.setText(path1);
            ImageIcon icon = new ImageIcon(path1);
            Image img = icon.getImage().getScaledInstance(lblImage1.getWidth(), lblImage1.getHeight(), Image.SCALE_SMOOTH);
            lblImage1.setIcon(new ImageIcon(img));
            
        }
    }//GEN-LAST:event_lblImage1MouseClicked

    private void lblImage2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImage2MouseClicked
        // TODO add your handling code here:
        JFileChooser filechooser2 = new JFileChooser();
        FileNameExtensionFilter filter2 = new FileNameExtensionFilter("PNG JPG AND JPEG","png","jpg","jpeg");
        filechooser2.addChoosableFileFilter(filter2);
        int load2 =  filechooser2.showOpenDialog(null);
        
        if(load2==filechooser2.APPROVE_OPTION){
            filename2 = filechooser2.getSelectedFile();
            
            path2 = filename2.getAbsolutePath();
            txtPath2.setText(path2);
            ImageIcon icon2 = new ImageIcon(path2);
            Image img = icon2.getImage().getScaledInstance(lblImage2.getWidth(), lblImage2.getHeight(), Image.SCALE_SMOOTH);
            lblImage2.setIcon(new ImageIcon(img));
            
        }
    }//GEN-LAST:event_lblImage2MouseClicked

    private void lblImage3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImage3MouseClicked
        // TODO add your handling code here:
         JFileChooser filechooser3 = new JFileChooser();
        FileNameExtensionFilter filter3 = new FileNameExtensionFilter("PNG JPG AND JPEG","png","jpg","jpeg");
        filechooser3.addChoosableFileFilter(filter3);
        int load3 =  filechooser3.showOpenDialog(null);
        
        if(load3==filechooser3.APPROVE_OPTION){
            filename3 = filechooser3.getSelectedFile();
            
            path3 = filename3.getAbsolutePath();
            txtPath3.setText(path3);
            ImageIcon icon3 = new ImageIcon(path3);
            Image img3 = icon3.getImage().getScaledInstance(lblImage3.getWidth(), lblImage3.getHeight(), Image.SCALE_SMOOTH);
            lblImage3.setIcon(new ImageIcon(img3));
            
        }
    }//GEN-LAST:event_lblImage3MouseClicked

    private void lblImage4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImage4MouseClicked
        // TODO add your handling code here:
         JFileChooser filechooser4 = new JFileChooser();
        FileNameExtensionFilter filter4 = new FileNameExtensionFilter("PNG JPG AND JPEG","png","jpg","jpeg");
        filechooser4.addChoosableFileFilter(filter4);
        int load4 =  filechooser4.showOpenDialog(null);
        
        if(load4==filechooser4.APPROVE_OPTION){
            filename4 = filechooser4.getSelectedFile();
            
            path4 = filename4.getAbsolutePath();
            txtPath4.setText(path4);
            ImageIcon icon4 = new ImageIcon(path4);
            Image img4 = icon4.getImage().getScaledInstance(lblImage4.getWidth(), lblImage4.getHeight(), Image.SCALE_SMOOTH);
            lblImage4.setIcon(new ImageIcon(img4));
            
        }
    }//GEN-LAST:event_lblImage4MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          String dateofbirth = ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText();
        
        String dob[] = dateofbirth.split("/");
        //System.out.println(""+dob[0]);
        //System.out.println(""+dob[1]);
        //System.out.println(""+dob[2]);
        
        int day = Integer.parseInt(dob[0]);
        int month = Integer.parseInt(dob[1]);
        int year = Integer.parseInt(dob[2]);
        
        LocalDate selectedDate = LocalDate.of(year,month,day);
        LocalDate currentDates = LocalDate.now();
        //System.out.println("" + selectedDate);
        //System.out.println("" + currentDates);
        
        int resultyear = Period.between(selectedDate,currentDates).getYears();
        jTextField1.setText(""+ resultyear);
    }//GEN-LAST:event_jButton1ActionPerformed
 
    private void jDateChooser1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser1MouseReleased
        // TODO add your handling code here:
           String dateofbirth = ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText();
        
        String dob[] = dateofbirth.split("/");
        //System.out.println(""+dob[0]);
        //System.out.println(""+dob[1]);
        //System.out.println(""+dob[2]);
        
        int day = Integer.parseInt(dob[0]);
        int month = Integer.parseInt(dob[1]);
        int year = Integer.parseInt(dob[2]);
        
        LocalDate selectedDate = LocalDate.of(year,month,day);
        LocalDate currentDates = LocalDate.now();
        //System.out.println("" + selectedDate);
        //System.out.println("" + currentDates);
        
        int resultyear = Period.between(selectedDate,currentDates).getYears();
        int resultmonth = Period.between(selectedDate,currentDates).getMonths();
        int resultday = Period.between(selectedDate,currentDates).getDays();
        jTextField1.setText(""+ resultyear);
    }//GEN-LAST:event_jDateChooser1MouseReleased

    private void txtPath4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPath4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPath4ActionPerformed

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
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator SeperatorFarmWorkers;
    private javax.swing.JSeparator SeperatorFisher;
    private javax.swing.JSeparator SeperatorForFarmer;
    private javax.swing.JSeparator SeperetorAgri;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup4Ps;
    private javax.swing.ButtonGroup buttonGroupFarmers;
    private javax.swing.ButtonGroup buttonGroupGoverment;
    private javax.swing.ButtonGroup buttonGroupHouse;
    private javax.swing.ButtonGroup buttonGroupIndigenous;
    private javax.swing.ButtonGroup buttonGroupPWD;
    public javax.swing.ButtonGroup buttonGroupReligion;
    private javax.swing.JComboBox<String> combobrgy;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheck4PsNo;
    private javax.swing.JCheckBox jCheck4PsYes;
    private javax.swing.JCheckBox jCheckAgri1;
    private javax.swing.JCheckBox jCheckAqua2;
    private javax.swing.JCheckBox jCheckAssociationNo;
    private javax.swing.JCheckBox jCheckAssociationYes;
    private javax.swing.JCheckBox jCheckBox44;
    public javax.swing.JCheckBox jCheckChristian;
    private javax.swing.JCheckBox jCheckCorn1;
    private javax.swing.JCheckBox jCheckCultivation1;
    private javax.swing.JCheckBox jCheckFarmLabor1;
    private javax.swing.JCheckBox jCheckFarmOthers1;
    private javax.swing.JCheckBox jCheckFarmer3;
    private javax.swing.JCheckBox jCheckFarmworkerHarvest1;
    private javax.swing.JCheckBox jCheckFish1;
    private javax.swing.JCheckBox jCheckFishCapture2;
    private javax.swing.JCheckBox jCheckFishOthers1;
    private javax.swing.JCheckBox jCheckFishProcess1;
    private javax.swing.JCheckBox jCheckFishVending1;
    private javax.swing.JCheckBox jCheckFormal1;
    private javax.swing.JCheckBox jCheckGleaning1;
    private javax.swing.JCheckBox jCheckGovNo;
    private javax.swing.JCheckBox jCheckGovYes;
    private javax.swing.JCheckBox jCheckHarvest1;
    private javax.swing.JCheckBox jCheckHouseNo;
    private javax.swing.JCheckBox jCheckHouseYes;
    private javax.swing.JCheckBox jCheckIndigenousNo;
    private javax.swing.JCheckBox jCheckIndigenousYes;
    public javax.swing.JCheckBox jCheckIslam;
    private javax.swing.JCheckBox jCheckLand1;
    private javax.swing.JCheckBox jCheckLive1;
    private javax.swing.JCheckBox jCheckNonFromal1;
    public javax.swing.JCheckBox jCheckOthers;
    private javax.swing.JCheckBox jCheckPWDNo;
    private javax.swing.JCheckBox jCheckPWDYes;
    private javax.swing.JCheckBox jCheckPart1;
    private javax.swing.JCheckBox jCheckParticipated1;
    private javax.swing.JCheckBox jCheckPlanting1;
    private javax.swing.JCheckBox jCheckPoultry1;
    private javax.swing.JCheckBox jCheckRice1;
    private javax.swing.JComboBox<String> jComboCivil;
    private javax.swing.JComboBox<String> jComboEduc;
    private javax.swing.JComboBox<String> jComboSex;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextAgriSpecify1;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbl4Ps;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblBarangay;
    private javax.swing.JLabel lblCivil;
    private javax.swing.JLabel lblContact;
    private javax.swing.JLabel lblContactNo;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDateReg;
    private javax.swing.JLabel lblEName;
    private javax.swing.JLabel lblEduc;
    private javax.swing.JLabel lblEmergency;
    private javax.swing.JLabel lblFID;
    private javax.swing.JLabel lblFName;
    private javax.swing.JLabel lblFarmerAssociation;
    private javax.swing.JLabel lblFemale;
    private javax.swing.JLabel lblGoverment;
    private javax.swing.JLabel lblHouseHold;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblIDtype;
    private javax.swing.JLabel lblIfnoHouse;
    private javax.swing.JLabel lblImage1;
    private javax.swing.JLabel lblImage2;
    private javax.swing.JLabel lblImage3;
    private javax.swing.JLabel lblImage4;
    private javax.swing.JLabel lblIndigenous;
    private javax.swing.JLabel lblMName;
    private javax.swing.JLabel lblMale;
    private javax.swing.JLabel lblMunicipality;
    private javax.swing.JLabel lblName10;
    private javax.swing.JLabel lblName20;
    private javax.swing.JLabel lblName22;
    private javax.swing.JLabel lblName43;
    private javax.swing.JLabel lblName44;
    private javax.swing.JLabel lblName45;
    private javax.swing.JLabel lblName46;
    private javax.swing.JLabel lblName47;
    private javax.swing.JLabel lblName48;
    private javax.swing.JLabel lblName49;
    private javax.swing.JLabel lblName50;
    private javax.swing.JLabel lblName51;
    private javax.swing.JLabel lblName52;
    private javax.swing.JLabel lblName74;
    private javax.swing.JLabel lblName75;
    private javax.swing.JLabel lblName76;
    private javax.swing.JLabel lblName77;
    private javax.swing.JLabel lblNoofLiving;
    private javax.swing.JLabel lblPWD;
    private javax.swing.JLabel lblPlace;
    private javax.swing.JLabel lblProvince;
    private javax.swing.JLabel lblPurok;
    private javax.swing.JLabel lblRelatioship;
    private javax.swing.JLabel lblReligion;
    private javax.swing.JLabel lblSName;
    private javax.swing.JLabel lblSex;
    private javax.swing.JLabel lblStreet;
    private javax.swing.JLabel lblmain3;
    private javax.swing.JLabel lblrRegion;
    private javax.swing.JPanel tableFarmer;
    private javax.swing.JTextField txtAssociationSpecify;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtContactNo;
    private javax.swing.JLabel txtDates;
    private javax.swing.JTextField txtEName;
    private javax.swing.JTextField txtEmergency;
    private javax.swing.JTextField txtFName;
    private javax.swing.JTextField txtFarmWorkerSpecify1;
    private javax.swing.JTextField txtFemale;
    private javax.swing.JTextField txtFishSpecify2;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIDNumbber;
    private javax.swing.JTextField txtIDtype;
    private javax.swing.JTextField txtIfnoHouse;
    private javax.swing.JTextField txtIndigenousSpecify;
    private javax.swing.JTextField txtLiveSpecify1;
    private javax.swing.JTextField txtMName;
    private javax.swing.JTextField txtMale;
    private javax.swing.JTextField txtMunicipality;
    private javax.swing.JTextField txtNoofLiving;
    private javax.swing.JTextField txtOtherSpecify1;
    private javax.swing.JTextField txtPath1;
    private javax.swing.JTextField txtPath2;
    private javax.swing.JTextField txtPath3;
    private javax.swing.JTextField txtPath4;
    private javax.swing.JTextField txtPlace;
    private javax.swing.JTextField txtPoultrySpecify1;
    private javax.swing.JTextField txtPurok;
    private javax.swing.JTextField txtRegion;
    private javax.swing.JTextField txtRelationship;
    private javax.swing.JTextField txtSName;
    private javax.swing.JTextField txtStreet;
    private javax.swing.JTextField txtprovince;
    private javax.swing.JTextField txtreligionSpecify;
    // End of variables declaration//GEN-END:variables
}
