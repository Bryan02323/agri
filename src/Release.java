
import jaen.AgriSupply;
import jaen.Registration;
import java.awt.Color;
import javax.swing.plaf.basic.BasicInternalFrameUI;
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
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
public class Release extends javax.swing.JInternalFrame {

   
   Connection con;
   PreparedStatement pst;
   PreparedStatement pst1;
   PreparedStatement pst2;
   PreparedStatement pst3;
   Statement state;
   ResultSet rst;
   ResultSet rst2;
   
   ImageIcon icon1 = new ImageIcon("error.png");
   ImageIcon icon2 = new ImageIcon("success.png");
    public Release() {
        initComponents();
        jScrollPane1.hide();
                
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = ( BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        Header();
        auotoid();
        updatecombostockname();
        table_update();
        updatecombo(); 
        txtSearch.setText("Enter Farmer ID");
        placeholder(txtFarmerID);
        updatecombostockname();
        
        
    }
    
      public void updatecombostockname(){
        try{
             Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            state = con.createStatement();
            rst = state.executeQuery("SELECT * FROM stock2");
            DefaultListModel model =  new DefaultListModel();
                while(rst.next()){
                    String type = rst.getString("Name");
                   model.addElement(type);
                   
                }list.setModel(model);
                con.close();
            
                
                
            
        }catch(Exception e){
            
        }
    }
     

    public void placeholder(JTextField txtSearch){
        Font font = txtSearch.getFont();
        font = font.deriveFont(Font.ITALIC);
        txtSearch.setFont(font);
        txtSearch.setForeground(Color.gray);
    }
     public void removeplaceholder(JTextField txtSearch){
        Font font = txtSearch.getFont();
        font = font.deriveFont(Font.PLAIN|Font.BOLD);
        txtSearch.setFont(font);
       txtSearch.setForeground(Color.black);
    }
     
      public void placeholder1(JTextField txtSupplyid){
        Font font = txtSupplyid.getFont();
        font = font.deriveFont(Font.PLAIN);
        txtSupplyid.setFont(font);
        txtSupplyid.setForeground(Color.black);
    }
     public void removeplaceholder1(JTextField txtSupplyid){
        Font font = txtSupplyid.getFont();
        font = font.deriveFont(Font.PLAIN|Font.BOLD);
        txtSupplyid.setFont(font);
       txtSupplyid.setForeground(Color.black);
    }
    
     public void Header(){
         
         jTable1.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD, 24));
         TableColumnModel model = jTable1.getColumnModel();
         model.getColumn(0).setPreferredWidth(150);
         model.getColumn(1).setPreferredWidth(200);
         model.getColumn(2).setPreferredWidth(200);
         model.getColumn(3).setPreferredWidth(350);
         model.getColumn(4).setPreferredWidth(200);
       
     }
    public void auotoid(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
             state = con.createStatement();
             rst = state.executeQuery("SELECT Max(Give_ID) FROM give");
             rst.next();
             rst.getString("Max(Give_ID)");
             
             if(rst.getString("Max(Give_ID)")== null){
                 txtGiveID.setText("R-0001");
                 
             }else{
                 Long id = Long.parseLong(rst.getString("Max(Give_ID)").substring(2,rst.getString("Max(Give_ID)").length()));
                 id++;
                 txtGiveID.setText("R-00" + String.format("%01d", id));
             }         
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jaen.Release.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(jaen.Release.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
    
    
   

    private void updatecombo(){
        try{  
            state = con.createStatement();
            rst = state.executeQuery("SELECT Full_Name from account where Account_Type = 'Secretary'");
                while(rst.next()){
                    String a= (rst.getString("Full_Name"));
                    jLabel1.setText(a);
                   
                }con.close();   
        }catch(Exception e){
            
        }
    }
 private void table_update(){     
           int c;
             try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            pst = con.prepareStatement("select FID,LName,FName,MName,EName from profile");
            
            rst = pst.executeQuery();
            ResultSetMetaData rss = rst.getMetaData();
            c = rss.getColumnCount();
            DefaultTableModel Df = (DefaultTableModel)jTable1.getModel();
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
                    
                }            
                Df.addRow(v2);       
            }
 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
  
       }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblfarmerID = new javax.swing.JLabel();
        lblFarmerName = new javax.swing.JLabel();
        lblType = new javax.swing.JLabel();
        lblStockName = new javax.swing.JLabel();
        lblQty = new javax.swing.JLabel();
        txtFarmerName = new javax.swing.JTextField();
        txtGiveID = new javax.swing.JTextField();
        lblGiveID = new javax.swing.JLabel();
        txtFarmerID = new javax.swing.JTextField();
        txtQty = new javax.swing.JTextField();
        lblRelease = new javax.swing.JLabel();
        btnRelease = new javax.swing.JButton();
        lblQty1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCurrent = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtSupplyid = new javax.swing.JTextField();
        txtStockType = new javax.swing.JTextField();
        txtStockName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDesc = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        list = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();

        bg.setPreferredSize(new java.awt.Dimension(1590, 840));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblfarmerID.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lblfarmerID.setText(" Farmer ID");
        jPanel2.add(lblfarmerID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 150, 50));

        lblFarmerName.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lblFarmerName.setText("Farmer Name");
        jPanel2.add(lblFarmerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, -1, 50));

        lblType.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lblType.setText("Type of Stock");
        jPanel2.add(lblType, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 390, 170, 50));

        lblStockName.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lblStockName.setText("Stock Name");
        jPanel2.add(lblStockName, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 460, 170, 50));

        lblQty.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lblQty.setText("Quantity");
        jPanel2.add(lblQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 530, 160, 50));

        txtFarmerName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtFarmerName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtFarmerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 460, 260, 50));

        txtGiveID.setEditable(false);
        txtGiveID.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtGiveID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGiveID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtGiveIDKeyPressed(evt);
            }
        });
        jPanel2.add(txtGiveID, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, 260, 50));

        lblGiveID.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lblGiveID.setText("Release ID");
        jPanel2.add(lblGiveID, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 152, 50));

        txtFarmerID.setEditable(false);
        txtFarmerID.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtFarmerID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtFarmerID, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, 260, 50));

        txtQty.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtQty.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQtyKeyTyped(evt);
            }
        });
        jPanel2.add(txtQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 530, 260, 50));

        lblRelease.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyImages/release.png"))); // NOI18N
        jPanel2.add(lblRelease, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 610, 60, 60));

        btnRelease.setBackground(new java.awt.Color(242, 242, 242));
        btnRelease.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnRelease.setText("Release");
        btnRelease.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnRelease.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReleaseActionPerformed(evt);
            }
        });
        jPanel2.add(btnRelease, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 610, 180, 60));

        lblQty1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lblQty1.setText("Distributor");
        jPanel2.add(lblQty1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 600, 180, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel2.setText("Description");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 530, 190, 50));

        txtCurrent.setEditable(false);
        txtCurrent.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        txtCurrent.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCurrent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCurrentActionPerformed(evt);
            }
        });
        jPanel2.add(txtCurrent, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 600, 230, 50));

        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Farmer ID", "Lastname", "Firstname", "Middlename", "Extensionname"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(0, 204, 0));
        jTable1.setRowHeight(40);
        jTable1.setShowHorizontalLines(true);
        jTable1.setShowVerticalLines(true);
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 1450, 210));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 600, 260, 50));

        txtSupplyid.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtSupplyid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSupplyid.setText("AgriSupply-");
        txtSupplyid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSupplyidFocusLost(evt);
            }
        });
        txtSupplyid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSupplyidActionPerformed(evt);
            }
        });
        txtSupplyid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSupplyidKeyReleased(evt);
            }
        });
        jPanel2.add(txtSupplyid, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 320, 230, 50));

        txtStockType.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        txtStockType.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStockType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockTypeActionPerformed(evt);
            }
        });
        jPanel2.add(txtStockType, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 390, 230, 50));

        txtStockName.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        txtStockName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStockName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockNameActionPerformed(evt);
            }
        });
        jPanel2.add(txtStockName, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 460, 230, 50));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel3.setText("AggriSpply ID");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 330, 170, 50));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel4.setText("Current Stock");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 600, 190, 50));

        txtDesc.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        txtDesc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 530, 230, 50));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 22)); // NOI18N
        jLabel5.setText("Search Farmer");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 20, -1, 40));

        txtSearch.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchFocusLost(evt);
            }
        });
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        jPanel2.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 19, 180, 40));

        list.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(list);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 360, 130, -1));

        jButton1.setText("Show Stock's");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 330, 130, -1));

        bg.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 1490, 690));

        jPanel7.setBackground(new java.awt.Color(153, 153, 153));
        jPanel7.setPreferredSize(new java.awt.Dimension(0, 30));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1590, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        bg.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 770, 1590, 20));

        jPanel8.setBackground(new java.awt.Color(153, 153, 153));
        jPanel8.setPreferredSize(new java.awt.Dimension(0, 30));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        bg.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1592, -1));

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );

        bg.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 20, 750));

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );

        bg.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1540, 10, 50, 770));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 1592, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtGiveIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGiveIDKeyPressed
        // TODO add your handling code here
    }//GEN-LAST:event_txtGiveIDKeyPressed

    private void btnReleaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReleaseActionPerformed
        // TODO add your handling code here:
          Date date = new Date();
          SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
          String currentdate = dateformat.format(date);
        String give = txtGiveID.getText();
        String fid = txtFarmerID.getText();
        String farmername = txtFarmerName.getText();
        String stock = txtStockName.getText();
        String stockname = txtStockName.getText();
        String qty = txtQty.getText();
        String name = jLabel1.getText();
        String current = txtCurrent.getText();
        String quan =txtQty.getText();

        try{
              if(give.isEmpty() || fid.isEmpty() || farmername.isEmpty() || stock.isEmpty() || qty.isEmpty()
                || name.isEmpty() || current.isEmpty() || quan.isEmpty() ){
        JOptionPane.showMessageDialog(null, "<html><b style=\"color:black; font-size:15px;\">Fill the Blank!</b></html>","Complete the details", JOptionPane.ERROR_MESSAGE,icon1);
            }else{

            int cur  = Integer.parseInt(current);
            int quantity  = Integer.parseInt(quan);
            if(quantity > cur){
                JOptionPane.showMessageDialog(this, "<html><b style=\"color:black; font-size:15px;\">Sorry the Stock low</b></html>");
            }
            else if(quantity <= cur){
                int total =  cur - quantity ;
                String ne = Integer.toString(total);
                txtCurrent.setText(ne);

                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
                pst = con.prepareStatement("update stock2 set Quantity=? where Name=?");

                pst.setString(1,ne);
                pst.setString(2, stockname);
                pst.executeUpdate();

                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
                pst = con.prepareStatement("insert into give(Give_ID,Farmer_ID,Farmer_Name,Type_of_Stock,Stock_Name,Quantity,Date,Name_of_Distributor)values(?,?,?,?,?,?,?,?)");

                pst.setString(1, give);
                pst.setString(2, fid);
                pst.setString(3, farmername);
                pst.setString(4, stock);
                pst.setString(5, stockname);
                pst.setString(6, qty);
                pst.setString(7, currentdate);
                pst.setString(8, name);
                pst.executeUpdate();

                JOptionPane.showMessageDialog(this,"<html><b style=\"color:black; font-size:15px;\">Release Successfuly</b></html>","Success",JOptionPane.INFORMATION_MESSAGE,icon2);
                auotoid();
                table_update();
                txtFarmerID.setText("");
                txtFarmerID.setText("");
                txtFarmerName.setText("");
                txtQty.setText("");
                txtGiveID.requestFocus();
            }
            }
        }catch(Exception e){

        }
    }//GEN-LAST:event_btnReleaseActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
         DefaultTableModel Df = (DefaultTableModel)jTable1.getModel();
        int SelectedRows = jTable1.getSelectedRow();
       
        txtFarmerID.setText(Df.getValueAt(SelectedRows, 0).toString()); 
         try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            pst = con.prepareStatement(" SELECT FID,FName,MName,LName,EName from profile where FID = ?");
            String id = (txtFarmerID.getText());
            pst.setString(1,id);
            rst = pst.executeQuery();
            if(rst.next() == true){
                String fname = rst.getString("FName");
                String mname = rst.getString("MName");
                String lname = rst.getString("LName");
                String ename = rst.getString("EName");
                char first = mname.charAt(0);
                String fullname = fname + " " + first+ " "+ lname + " " + ename;
                txtFarmerName.setText(fullname);
            }
            else {
                txtFarmerName.setText("");
            }
        }catch (Exception e){

        }
        
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtQtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtyKeyTyped
         char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtQtyKeyTyped

    private void txtSupplyidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSupplyidKeyReleased
      try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            pst = con.prepareStatement(" SELECT Type_of_Stock,Name,Description,Quantity from stock2 where Stock_ID = ?");
            String id = (txtSupplyid.getText());
            pst.setString(1,id);
            rst = pst.executeQuery();
            if(rst.next() == true){
                String fname = rst.getString("Type_of_Stock");
                String mname = rst.getString("Name");
                String lname = rst.getString("Quantity");
                String desc = rst.getString("Description");
                txtStockName.setText(fname);
                txtStockType.setText(mname);
                txtCurrent.setText(lname);
                txtDesc.setText(desc);
            }
            else {
                
            }
        }catch (Exception e){

        }
       
    }//GEN-LAST:event_txtSupplyidKeyReleased

    private void txtStockTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockTypeActionPerformed

    private void txtCurrentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCurrentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCurrentActionPerformed

    private void txtStockNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockNameActionPerformed

    private void txtSupplyidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSupplyidFocusLost
       // if(txtSupplyid.getText().length()==0){  
        //    placeholder(txtSupplyid);
        //    txtSupplyid.setText("AgriSupply-");
       // }
    }//GEN-LAST:event_txtSupplyidFocusLost

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
          try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            pst = con.prepareStatement(" SELECT FID,FName,MName,LName,EName from profile where FID = ?");
            String id = (txtSearch.getText());
            pst.setString(1,id);
            rst = pst.executeQuery();
            if(rst.next() == true){
                String fname = rst.getString("FName");
                String mname = rst.getString("MName");
                String lname = rst.getString("LName");
                String ename = rst.getString("EName");
                char first = mname.charAt(0);
                String fullname = fname + " " + first+ " "+ lname + " " + ename;
                txtFarmerName.setText(fullname);
            }
            else {
                 JOptionPane.showMessageDialog(null, "<html><b style=\"color:black; font-size:15px;\">Sorry Farmer Not Found!</b></html>","Enter Correct Farmer ID", JOptionPane.ERROR_MESSAGE,icon1);
                txtFarmerName.setText("");
            }
        }catch (Exception e){

        }
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        if(txtSearch.getText().length()==0){  
            placeholder(txtSearch);
            txtSearch.setText("Enter Farmer ID");
        }
    }//GEN-LAST:event_txtSearchFocusLost

    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
         if(txtSearch.getText().equals("Enter Farmer ID")){
            txtSearch.setText(null);
            txtSearch.requestFocus();
            removeplaceholder(txtSearch);
       }
    }//GEN-LAST:event_txtSearchFocusGained

    private void txtSupplyidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSupplyidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSupplyidActionPerformed

    private void listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMouseClicked
        String selected = list.getSelectedValue().toString();
        txtStockName.setText(selected);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            pst = con.prepareStatement(" SELECT * from stock2 where Name = ?");
            String id = (txtStockName.getText());
            pst.setString(1,id);
            rst = pst.executeQuery();
            if(rst.next() == true){
                String fname = rst.getString("Type_of_Stock");
                String mname = rst.getString("Stock_ID");
                String lname = rst.getString("Quantity");
                String desc = rst.getString("Description");
                txtStockType.setText(fname);
                txtSupplyid.setText(mname);
                txtCurrent.setText(lname);
                txtDesc.setText(desc);
            }
            else {

            }
        }catch (Exception e){

        }
    }//GEN-LAST:event_listMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jScrollPane1.show();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnRelease;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblFarmerName;
    private javax.swing.JLabel lblGiveID;
    private javax.swing.JLabel lblQty;
    private javax.swing.JLabel lblQty1;
    private javax.swing.JLabel lblRelease;
    private javax.swing.JLabel lblStockName;
    private javax.swing.JLabel lblType;
    private javax.swing.JLabel lblfarmerID;
    private javax.swing.JList<String> list;
    private javax.swing.JTextField txtCurrent;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JTextField txtFarmerID;
    private javax.swing.JTextField txtFarmerName;
    private javax.swing.JTextField txtGiveID;
    private javax.swing.JTextField txtQty;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtStockName;
    private javax.swing.JTextField txtStockType;
    private javax.swing.JTextField txtSupplyid;
    // End of variables declaration//GEN-END:variables

    private void fillDataJList(JList<String> list) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
