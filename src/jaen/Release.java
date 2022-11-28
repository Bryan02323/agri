package jaen;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Release extends javax.swing.JFrame {
    DefaultTableModel model;
    public Release() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Header();
        auotoid();
        table_update();
        updatecombo(); 
    }
      Connection con;
   PreparedStatement pst;
   PreparedStatement pst1;
   PreparedStatement pst2;
   PreparedStatement pst3;
   Statement state;
   ResultSet rst;
   ResultSet rst2;

    public void Header(){
         
         jTable1.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD, 24));
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
                 txtGiveID.setText("R-001");
                 
             }else{
                 Long id = Long.parseLong(rst.getString("Max(Give_ID)").substring(2,rst.getString("Max(Give_ID)").length()));
                 id++;
                 txtGiveID.setText("R-00" + String.format("%01d", id));
             }         
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Release.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Release.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
    
    private void updatecombo(){
        try{  
            state = con.createStatement();
            rst = state.executeQuery("SELECT * FROM account");
                while(rst.next()){
                    jComboName.addItem(rst.getString("Full_Name"));
                   
                }con.close();   
        }catch(Exception e){
            
        }
    }
 private void table_update(){     
           int c;
             try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            pst = con.prepareStatement("select * from give");
            
            rst = pst.executeQuery();
            ResultSetMetaData rss = rst.getMetaData();
            c = rss.getColumnCount();
            DefaultTableModel Df = (DefaultTableModel)jTable1.getModel();
            Df.setRowCount(0);  
            while(rst.next()){        
                Vector v2 = new Vector();
                for(int a=1; a<=c; a++)
                {
                    v2.add(rst.getString("Give_ID"));
                    v2.add(rst.getString("Date"));
                    v2.add(rst.getString("Farmer_ID"));
                    v2.add(rst.getString("Farmer_Name"));
                    v2.add(rst.getString("Type_of_Stock"));
                    v2.add(rst.getString("Stock_Name"));
                    v2.add(rst.getString("Quantity"));
                    v2.add(rst.getString("Name_of_Distributor"));
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

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblfarmerID = new javax.swing.JLabel();
        lblFarmerName = new javax.swing.JLabel();
        lblType = new javax.swing.JLabel();
        lblStockName = new javax.swing.JLabel();
        lblQty = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        txtFarmerName = new javax.swing.JTextField();
        txtGiveID = new javax.swing.JTextField();
        lblGiveID = new javax.swing.JLabel();
        txtFarmerID = new javax.swing.JTextField();
        txtQty = new javax.swing.JTextField();
        lblRelease = new javax.swing.JLabel();
        btnRelease = new javax.swing.JButton();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        comboStockName = new javax.swing.JComboBox<>();
        comboStock = new javax.swing.JComboBox<>();
        lblQty1 = new javax.swing.JLabel();
        jComboName = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txtCurrent = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 255, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(51, 204, 0));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Jaen Municipal Department of Agriculture");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Management System");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyImages/back.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("X");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 483, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 955, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(423, 423, 423))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1930, 160));

        jPanel2.setBackground(new java.awt.Color(0, 204, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblfarmerID.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblfarmerID.setForeground(new java.awt.Color(255, 255, 255));
        lblfarmerID.setText(" Farmer ID");
        jPanel2.add(lblfarmerID, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 131, 40));

        lblFarmerName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblFarmerName.setForeground(new java.awt.Color(255, 255, 255));
        lblFarmerName.setText("Farmer Name");
        jPanel2.add(lblFarmerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, -1, 40));

        lblType.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblType.setForeground(new java.awt.Color(255, 255, 255));
        lblType.setText("Type of Stock");
        jPanel2.add(lblType, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, -1, 42));

        lblStockName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblStockName.setForeground(new java.awt.Color(255, 255, 255));
        lblStockName.setText("Stock Name");
        jPanel2.add(lblStockName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, 156, 44));

        lblQty.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblQty.setForeground(new java.awt.Color(255, 255, 255));
        lblQty.setText("Qty");
        jPanel2.add(lblQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 580, 162, 40));

        lblDate.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblDate.setForeground(new java.awt.Color(255, 255, 255));
        lblDate.setText("Date Release");
        jPanel2.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 340, 180, 40));

        txtFarmerName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtFarmerName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtFarmerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, 260, -1));

        txtGiveID.setEditable(false);
        txtGiveID.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtGiveID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGiveID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtGiveIDKeyPressed(evt);
            }
        });
        jPanel2.add(txtGiveID, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 260, -1));

        lblGiveID.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblGiveID.setForeground(new java.awt.Color(255, 255, 255));
        lblGiveID.setText("Release ID");
        jPanel2.add(lblGiveID, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 152, 40));

        txtFarmerID.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtFarmerID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFarmerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFarmerIDActionPerformed(evt);
            }
        });
        txtFarmerID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFarmerIDKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFarmerIDKeyReleased(evt);
            }
        });
        jPanel2.add(txtFarmerID, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 260, -1));

        txtQty.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtQty.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 580, 260, -1));

        lblRelease.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyImages/release.png"))); // NOI18N
        jPanel2.add(lblRelease, new org.netbeans.lib.awtextra.AbsoluteConstraints(1460, 560, 60, 60));

        btnRelease.setBackground(new java.awt.Color(242, 242, 242));
        btnRelease.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnRelease.setText("Release");
        btnRelease.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnRelease.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReleaseActionPerformed(evt);
            }
        });
        jPanel2.add(btnRelease, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 561, 180, 60));

        jDateChooser2.setDateFormatString("MM/dd/yyyy");
        jDateChooser2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jPanel2.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 390, 280, 39));

        comboStockName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        comboStockName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboStockNameActionPerformed(evt);
            }
        });
        jPanel2.add(comboStockName, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 510, 260, 45));

        comboStock.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        comboStock.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seeds", "Fertilizer" }));
        comboStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboStockActionPerformed(evt);
            }
        });
        jPanel2.add(comboStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 440, 260, 45));

        lblQty1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblQty1.setForeground(new java.awt.Color(255, 255, 255));
        lblQty1.setText("Name of Distributor");
        jPanel2.add(lblQty1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 240, 241, 40));

        jComboName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jPanel2.add(jComboName, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 290, 280, -1));

        jSeparator1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 1750, 450));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Current Stock");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 440, 190, 40));

        txtCurrent.setEditable(false);
        txtCurrent.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtCurrent.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtCurrent, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 490, 160, 40));

        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Release ID", "Date Release", "Recipient ID", "Farmer Name", "Type of Stock", "Stock Name", "Quantity", "Name of Distributor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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
        jScrollPane2.setViewportView(jTable1);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1760, 180));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 1800, 730));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1900, 1000));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtGiveIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGiveIDKeyPressed
        // TODO add your handling code here    
    }//GEN-LAST:event_txtGiveIDKeyPressed

    private void txtFarmerIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFarmerIDKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFarmerIDKeyReleased

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentShown

    private void btnReleaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReleaseActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd");
        String give = txtGiveID.getText();
        String fid = txtFarmerID.getText();
        String farmername = txtFarmerName.getText();        
        String stock = comboStock.getSelectedItem().toString();
        String stockname = comboStockName.getSelectedItem().toString();
        String qty = txtQty.getText();        
        String date = format.format(jDateChooser2.getDate());
        String name = jComboName.getSelectedItem().toString();       
        String current = txtCurrent.getText();
        String quan =txtQty.getText();

          try{
                    
        int cur  = Integer.parseInt(current);
                int quantity  = Integer.parseInt(quan);
                if(quantity > cur){
                    JOptionPane.showMessageDialog(this, "Sorry the Stock low");
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
            pst.setString(7, date);
            pst.setString(8, name);         
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(this,"Record Addedd!!");
            auotoid();
            table_update();
            txtFarmerID.setText("");
            txtFarmerID.setText("");
            txtFarmerName.setText("");
            txtQty.setText("");
            txtGiveID.requestFocus();   
                }
            }catch(Exception e){
                
            } 
    }//GEN-LAST:event_btnReleaseActionPerformed

    private void comboStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboStockActionPerformed
        // TODO add your handling code here:
          try{          
                Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            String query ="SELECT Type_of_Stock,Name from stock2 where Type_of_Stock = ?";
            pst=con.prepareStatement(query);
            pst.setString(1, comboStock.getSelectedItem().toString());
            rst = pst.executeQuery();
  
            if(comboStock.getSelectedItem().equals("Seeds"))
            {
                comboStockName.removeAllItems();
                while(rst.next()){
                      
                      String stock = rst.getString("Name");
                      comboStockName.addItem(stock);                     
                }
            }
              if(comboStock.getSelectedItem().equals("Fertilizer"))
            {
                comboStockName.removeAllItems();
                while(rst.next()){
                    
                      String stock = rst.getString("Name");
                      comboStockName.addItem(stock);
                }
            }
  
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_comboStockActionPerformed

    private void txtFarmerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFarmerIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFarmerIDActionPerformed

    private void txtFarmerIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFarmerIDKeyPressed
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
                  String fullname = fname + "," + mname + ","+ lname + "," + ename;
               txtFarmerName.setText(fullname);
             }
             else {        
             } 
        }catch (Exception e){
            
        }
    }//GEN-LAST:event_txtFarmerIDKeyPressed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        Home home = new Home();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void comboStockNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboStockNameActionPerformed
    try{      
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            pst2=con.prepareStatement("SELECT Quantity from stock2 where Name ='"+comboStockName+"'");
             
            rst2 = pst2.executeQuery();
               if(comboStockName.getSelectedItem().equals("RC-222"))
            {
               txtCurrent.setText(" ");
                while(rst2.next()){
                      
                      String stock = rst2.getString("Quantity");
                      txtCurrent.setText(stock);    
                }
            }
               
               if(comboStockName.getSelectedItem().equals("RC-132H"))
            {
              txtCurrent.setText(" ");
                while(rst2.next()){
                      
                      String stock = rst2.getString("Quantity");
                    txtCurrent.setText(stock);                                     
                }
            }
               
                 if(comboStockName.getSelectedItem().equals("RC-140H"))
            {
               txtCurrent.setText(" ");
                while(rst2.next()){
                      
                      String stock = rst2.getString("Quantity");
                      txtCurrent.setText(stock);   
                }
            }
                   if(comboStockName.getSelectedItem().equals("RC-236H"))
            {
               txtCurrent.setText(" ");
                while(rst2.next()){
                      
                      String stock = rst2.getString("Quantity");
                      txtCurrent.setText(stock);                     
                }
            }
                     if(comboStockName.getSelectedItem().equals("RC-456H"))
            {
               txtCurrent.setText(" ");
                while(rst2.next()){
                      
                      String stock = rst2.getString("TQuantity");
                      txtCurrent.setText(stock);  
                }
            }
                       if(comboStockName.getSelectedItem().equals("RC-534"))
            {
              txtCurrent.setText(" ");
                while(rst2.next()){
                      
                      String stock = rst2.getString("Quantity");
                      txtCurrent.setText(stock);     
                }
            }
                         if(comboStockName.getSelectedItem().equals("RC-436"))
            {
               txtCurrent.setText(" ");
                while(rst2.next()){
                      
                      String stock = rst2.getString("Quantity");
                      txtCurrent.setText(stock);    
                }
            }
                           if(comboStockName.getSelectedItem().equals("RC-480"))
            {
               
                while(rst2.next()){
                      
                      String stock = rst2.getString("Quantity"); 
                      txtCurrent.setText(stock);     
                }
            }
              if(comboStockName.getSelectedItem().equals("Urea"))
            {
               txtCurrent.setText(" ");
                while(rst2.next()){
                    
                      String stock = rst2.getString("Quantity");
                      txtCurrent.setText(stock);
                }
            }
              
              if(comboStockName.getSelectedItem().equals("Abono"))
            {
               txtCurrent.setText(" ");
                while(rst2.next()){
                    
                      String stock = rst2.getString("Quantity");
                      txtCurrent.setText(stock);
                }
            }      
        }catch(Exception e){
        } 
    }//GEN-LAST:event_comboStockNameActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        Home home = new Home();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Release().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRelease;
    private javax.swing.JComboBox<String> comboStock;
    private javax.swing.JComboBox<String> comboStockName;
    private javax.swing.JComboBox<String> jComboName;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblFarmerName;
    private javax.swing.JLabel lblGiveID;
    private javax.swing.JLabel lblQty;
    private javax.swing.JLabel lblQty1;
    private javax.swing.JLabel lblRelease;
    private javax.swing.JLabel lblStockName;
    private javax.swing.JLabel lblType;
    private javax.swing.JLabel lblfarmerID;
    private javax.swing.JTextField txtCurrent;
    private javax.swing.JTextField txtFarmerID;
    private javax.swing.JTextField txtFarmerName;
    private javax.swing.JTextField txtGiveID;
    private javax.swing.JTextField txtQty;
    // End of variables declaration//GEN-END:variables
}
