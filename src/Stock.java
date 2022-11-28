
import jaen.AgriSupply;
import jaen.Registration;
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
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
public class Stock extends javax.swing.JInternalFrame {

     Connection con1;
     PreparedStatement insert;
     PreparedStatement insert2;
     ResultSet rs;
     ResultSet rs2;
     Statement state;
    ImageIcon icon1 = new ImageIcon("error.png");
    ImageIcon icon2 = new ImageIcon("success.png");
    ImageIcon icon3 = new ImageIcon("question.png");
    int quanity = 0;
    public Stock() {
        initComponents();
        jTable1.setEnabled(false);
        jComboBox1.setEnabled(false);
        txtVariety.setEditable(false); 
        txtType.setEditable(false);
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = ( BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        table_update();
        autoid();
        Header();
        autoid();
    }
     ImageIcon icon = new ImageIcon("error.png");
    
      public void Header(){
         
         jTable1.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD, 26));
         jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
         
     }
    
    private void table_update(){
           
           int c;
           
             try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            insert = con1.prepareStatement("select Stock_ID,Type_of_Stock,Name,Description from stock2");
            
            rs = insert.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            c = rss.getColumnCount();
            
            DefaultTableModel Df = (DefaultTableModel)jTable1.getModel();
            Df.setRowCount(0);
            
            while(rs.next()){
                
                Vector v2 = new Vector();
                
                for(int a=1; a<=c; a++)
                {
                    v2.add(rs.getString("Stock_ID"));
                    v2.add(rs.getString("Type_of_Stock"));
                    v2.add(rs.getString("Name"));
                    v2.add(rs.getString("Description"));
                }
                
                Df.addRow(v2);
                        
            }
 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }         
       }
    
      public void autoid(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            state = con1.createStatement();
            rs = state.executeQuery("SELECT Max(Agri_Supply_ID) FROM agri_supply");
            rs.next();
            
              if(rs.getString("Max(Agri_Supply_ID)")== null){
                 txtStockID.setText("AgriSupply-0001");
            }else{
             String preid = rs.getString("Max(Agri_Supply_ID)");
            String data = preid.replace("AgriSupply-", "");
            int num =Integer.parseInt(data);
            num=num+1;
            String nextID=getnumerformat(num);
            txtStockID.setText(nextID);
             }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AgriSupply.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AgriSupply.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
    public static String getnumerformat(int number){
        
        String numberData="AgriSupply-";
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
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        PanelAdd1 = new javax.swing.JPanel();
        lblType = new javax.swing.JLabel();
        lblEdit = new javax.swing.JLabel();
        lblDelete = new javax.swing.JLabel();
        lblSave = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblName1 = new javax.swing.JLabel();
        lblStockID = new javax.swing.JLabel();
        txtStockID = new javax.swing.JTextField();
        txtType = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lblFertilizer1 = new javax.swing.JLabel();
        txtVariety = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnEditSave = new javax.swing.JButton();
        btnDeleteSave = new javax.swing.JButton();
        btnAddSave = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();

        bg.setPreferredSize(new java.awt.Dimension(1590, 840));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelAdd1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PanelAdd1.setOpaque(false);
        PanelAdd1.setPreferredSize(new java.awt.Dimension(800, 690));
        PanelAdd1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblType.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblType.setText("Stock Type");
        PanelAdd1.add(lblType, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 190, 50));

        lblEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyImages/edit.png"))); // NOI18N
        PanelAdd1.add(lblEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 620, 50, 50));

        lblDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyImages/-.png"))); // NOI18N
        PanelAdd1.add(lblDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 620, 60, 50));

        lblSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyImages/+.png"))); // NOI18N
        PanelAdd1.add(lblSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 620, 60, 50));

        btnUpdate.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        btnUpdate.setText("Edit");
        btnUpdate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        PanelAdd1.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 620, 130, 50));

        btnDelete.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        PanelAdd1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 620, 140, 50));

        lblName1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblName1.setText("Name");
        PanelAdd1.add(lblName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, 190, 50));

        lblStockID.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblStockID.setText("Stock ID");
        PanelAdd1.add(lblStockID, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 190, 50));

        txtStockID.setEditable(false);
        txtStockID.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        txtStockID.setOpaque(true);
        PanelAdd1.add(txtStockID, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 260, 50));

        txtType.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        PanelAdd1.add(txtType, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 540, 260, 50));

        jButton1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        jButton1.setText("Add");
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        PanelAdd1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 620, 120, 50));

        lblFertilizer1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblFertilizer1.setText("Description");
        PanelAdd1.add(lblFertilizer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 540, 190, 50));

        txtVariety.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        txtVariety.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVarietyActionPerformed(evt);
            }
        });
        PanelAdd1.add(txtVariety, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 460, 260, 50));

        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setEnabled(false);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(1300, 415));
        jScrollPane2.setWheelScrollingEnabled(false);

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Stock ID", "Type of Stock", "Name", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setAutoscrolls(false);
        jTable1.setGridColor(new java.awt.Color(0, 204, 0));
        jTable1.setPreferredSize(new java.awt.Dimension(1400, 397));
        jTable1.setRowHeight(30);
        jTable1.setSelectionBackground(new java.awt.Color(51, 204, 0));
        jTable1.setShowHorizontalLines(true);
        jTable1.setShowVerticalLines(true);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        PanelAdd1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 1400, 240));

        jComboBox1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seeds", "Fertilizer" }));
        PanelAdd1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 380, 260, 50));

        btnEditSave.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        btnEditSave.setText("Save");
        btnEditSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditSaveActionPerformed(evt);
            }
        });
        PanelAdd1.add(btnEditSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 620, -1, 50));

        btnDeleteSave.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        btnDeleteSave.setText("Save");
        btnDeleteSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteSaveActionPerformed(evt);
            }
        });
        PanelAdd1.add(btnDeleteSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 620, -1, 50));

        btnAddSave.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        btnAddSave.setText("Save");
        btnAddSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSaveActionPerformed(evt);
            }
        });
        PanelAdd1.add(btnAddSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 620, -1, 50));

        bg.add(PanelAdd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 1460, 700));

        jPanel7.setBackground(new java.awt.Color(153, 153, 153));
        jPanel7.setPreferredSize(new java.awt.Dimension(0, 30));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        bg.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1592, 20));

        jPanel8.setBackground(new java.awt.Color(153, 153, 153));
        jPanel8.setPreferredSize(new java.awt.Dimension(0, 30));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1592, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        bg.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 780, 1592, 60));

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 790, Short.MAX_VALUE)
        );

        bg.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 20, 790));

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 810, Short.MAX_VALUE)
        );

        bg.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1540, 20, 50, -1));

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
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        btnEditSave.show();
        btnAddSave.hide();
        btnDeleteSave.hide();
        txtVariety.setEditable(true);
        txtType.setEditable(true);
        jComboBox1.setEnabled(true);
        jTable1.setEnabled(true);

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        btnEditSave.hide();
        btnAddSave.hide();
        btnDeleteSave.show();
        jTable1.setEnabled(true);
        txtVariety.setEditable(true);
        txtType.setEditable(true);
        jComboBox1.setEnabled(true);
      
        
           
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        autoid();
        btnEditSave.hide();
        btnAddSave.show();
        btnDeleteSave.hide();
        jTable1.setEnabled(false);
        jComboBox1.setEnabled(true);
        txtVariety.setEditable(true); 
        txtType.setEditable(true);
        txtVariety.setText(""); 
        txtType.setText("");

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel Df = (DefaultTableModel)jTable1.getModel();
        int SelectedRows = jTable1.getSelectedRow();
       
        txtStockID.setText(Df.getValueAt(SelectedRows, 0).toString()); 
        jComboBox1.setSelectedItem(Df.getValueAt(SelectedRows, 1).toString());
        txtVariety.setText(Df.getValueAt(SelectedRows, 2).toString());
        txtType.setText(Df.getValueAt(SelectedRows, 3).toString());
      
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtVarietyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVarietyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVarietyActionPerformed

    private void btnAddSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSaveActionPerformed
        String stockid = txtStockID.getText();
        String type = jComboBox1.getSelectedItem().toString();
        String name = txtVariety.getText();
        String desc = txtType.getText();
        
        
         if (stockid.isEmpty() || type.isEmpty() || name.isEmpty()  || desc.isEmpty() ){
                JOptionPane.showMessageDialog(null, "<html><b style=\"color:black; font-size:15px;\">Fill the Blank!</b></html>","Complete the details", JOptionPane.ERROR_MESSAGE,icon);

            }else{

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            insert = con1.prepareStatement("insert into stock2(Stock_ID,Type_of_Stock,Name,Description,Quantity)values(?,?,?,?,?)");

            insert.setString(1, stockid);
            insert.setString(2, type);
            insert.setString(3, name);
            insert.setString(4, desc);
            insert.setInt(5,quanity);
            insert.executeUpdate();
            
            
            JOptionPane.showMessageDialog(this,"<html><b style=\"color:black; font-size:15px;\">Add Successfuly!</b></html>","Success",JOptionPane.INFORMATION_MESSAGE,icon2);
            table_update();
            autoid();

            
            txtVariety.setText("");
            txtType.setText("");
            

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
    }//GEN-LAST:event_btnAddSaveActionPerformed

    private void btnEditSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditSaveActionPerformed
         DefaultTableModel Df = (DefaultTableModel)jTable1.getModel();
        int SelectedRows = jTable1.getSelectedRow();

        try {
            Date date = new Date();
            SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
            String currentdate = dateformat.format(date);

            String stockid = txtStockID.getText();
            String type = jComboBox1.getSelectedItem().toString();
            String name = txtVariety.getText();
            
            String types = txtType.getText();

            if (stockid.isEmpty() || type.isEmpty() || name.isEmpty() || types.isEmpty()){
             JOptionPane.showMessageDialog(null, "<html><b style=\"color:black; font-size:15px;\">Fill the Blank!</b></html>","Complete the details", JOptionPane.ERROR_MESSAGE,icon);

            }else{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            insert = con1.prepareStatement("update agri_supply set Type_of_Stock=?, Stock_Variety=?,Stock_Description=? where Agri_Supply_ID=?");

            insert.setString(4, stockid);
            insert.setString(1, type);
            insert.setString(2, name);;
            insert.setString(3, types);

            insert.executeUpdate();

            JOptionPane.showMessageDialog(this,"<html><b style=\"color:black; font-size:15px;\">Edit Successfuly!</b></html>","Success",JOptionPane.INFORMATION_MESSAGE,icon2);
            table_update();

          ;
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEditSaveActionPerformed

    private void btnDeleteSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteSaveActionPerformed
        String supplyID  = txtStockID.getText();
            String type = jComboBox1.getSelectedItem().toString();
            String stockName = txtVariety.getText();
            String adqty = txtType.getText();
  
            if (supplyID.isEmpty() || type.isEmpty() || stockName.isEmpty() || adqty.isEmpty()){
                 JOptionPane.showMessageDialog(null, "<html><b style=\"color:black; font-size:15px;\">Fill the Blank!</b></html>","Complete the details", JOptionPane.ERROR_MESSAGE,icon);

            }else{
        
        int op =JOptionPane.showConfirmDialog(null, "<html><b style=\"color:black; font-size:15px;\">Are you sure to Delete</b></html>", "Delete", JOptionPane.YES_NO_OPTION,JOptionPane.DEFAULT_OPTION,icon3);
        if(op == 0){
            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                con1= DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");

                int row = jTable1.getSelectedRow();
                String value = (jTable1.getModel().getValueAt(row, 0).toString());
                String query = "DELETE FROM agri_supply where Agri_Supply_ID=?";
                insert = con1.prepareStatement(query);
                insert.setString(1,txtStockID.getText());
                insert.executeUpdate();

               JOptionPane.showMessageDialog(this,"<html><b style=\"color:black; font-size:15px;\">Delete Successfuly!</b></html>","Success",JOptionPane.INFORMATION_MESSAGE,icon2);
                table_update();

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
    }//GEN-LAST:event_btnDeleteSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelAdd1;
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnAddSave;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDeleteSave;
    private javax.swing.JButton btnEditSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblDelete;
    private javax.swing.JLabel lblEdit;
    private javax.swing.JLabel lblFertilizer1;
    private javax.swing.JLabel lblName1;
    private javax.swing.JLabel lblSave;
    private javax.swing.JLabel lblStockID;
    private javax.swing.JLabel lblType;
    private javax.swing.JTextField txtStockID;
    private javax.swing.JTextField txtType;
    private javax.swing.JTextField txtVariety;
    // End of variables declaration//GEN-END:variables
}
