/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jaen;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel Emas
 */
public class AgriSupply extends javax.swing.JFrame {

    /**
     * Creates new form AgriSupply
     */
    public AgriSupply() {
        initComponents();
        autoid();
        table_update();
         Header();
    }

    Connection con;
    PreparedStatement pst;
    ResultSet rst;
    Statement state;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblStocks = new javax.swing.JLabel();
        lblRecords = new javax.swing.JLabel();
        lblelease = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblStockType = new javax.swing.JLabel();
        lblSupplyID = new javax.swing.JLabel();
        lblStockDesc = new javax.swing.JLabel();
        txtDeliveryName = new javax.swing.JTextField();
        txtStockDesc = new javax.swing.JTextField();
        txtStockVariety = new javax.swing.JTextField();
        txtStockType = new javax.swing.JTextField();
        jDateDeliver = new com.toedter.calendar.JDateChooser();
        lblDate = new javax.swing.JLabel();
        lblStockVariety = new javax.swing.JLabel();
        lblDeliveryName = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSupply = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backgroundPanel.setBackground(new java.awt.Color(51, 255, 0));
        backgroundPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 204, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Agriculture Supply");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(795, 795, 795)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(776, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        backgroundPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 140));

        jPanel2.setBackground(new java.awt.Color(0, 204, 0));

        lblStocks.setFont(new java.awt.Font("Segoe UI Semibold", 3, 36)); // NOI18N
        lblStocks.setForeground(new java.awt.Color(255, 255, 255));
        lblStocks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStocks.setText("Stock's");
        lblStocks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblStocksMouseClicked(evt);
            }
        });

        lblRecords.setFont(new java.awt.Font("Segoe UI Semibold", 3, 36)); // NOI18N
        lblRecords.setForeground(new java.awt.Color(255, 255, 255));
        lblRecords.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRecords.setText("Records");
        lblRecords.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRecordsMouseClicked(evt);
            }
        });

        lblelease.setFont(new java.awt.Font("Segoe UI Semibold", 3, 36)); // NOI18N
        lblelease.setForeground(new java.awt.Color(255, 255, 255));
        lblelease.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblelease.setText("Release");
        lblelease.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbleleaseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblRecords, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblelease, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblStocks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblStocks)
                .addGap(29, 29, 29)
                .addComponent(lblelease)
                .addGap(18, 18, 18)
                .addComponent(lblRecords)
                .addContainerGap(634, Short.MAX_VALUE))
        );

        backgroundPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 190, 860));

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, new java.awt.Color(51, 51, 51), java.awt.Color.darkGray, java.awt.Color.darkGray));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblStockType.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lblStockType.setText("Type of Stock");
        jPanel3.add(lblStockType, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 260, 40));

        lblSupplyID.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lblSupplyID.setText("Agri-Supply-ID");
        jPanel3.add(lblSupplyID, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 200, 40));

        lblStockDesc.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lblStockDesc.setText("Stock Description");
        jPanel3.add(lblStockDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 260, 40));

        txtDeliveryName.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jPanel3.add(txtDeliveryName, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 520, 220, 40));

        txtStockDesc.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jPanel3.add(txtStockDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 460, 220, 40));

        txtStockVariety.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jPanel3.add(txtStockVariety, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 400, 220, 40));

        txtStockType.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jPanel3.add(txtStockType, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, 220, 40));

        jDateDeliver.setDateFormatString("MM/dd/yyyy");
        jDateDeliver.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        jPanel3.add(jDateDeliver, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 580, 218, 41));

        lblDate.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lblDate.setText("Date Deliver");
        jPanel3.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 580, 260, 40));

        lblStockVariety.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lblStockVariety.setText("Stock Variety");
        jPanel3.add(lblStockVariety, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 260, 40));

        lblDeliveryName.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lblDeliveryName.setText("Name of Delivery Man");
        jPanel3.add(lblDeliveryName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 260, 40));

        lblID.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jPanel3.add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, 210, 40));

        btnAdd.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel3.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 670, 170, 50));

        btnEdit.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel3.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 670, 170, 50));

        tblSupply.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        tblSupply.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Agri Supply ID", "Type of Stock", "Stock Variety", "Stock Description", "Name of_Delivery_Man", "Date Deliver"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSupply.setRowHeight(30);
        tblSupply.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSupplyMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSupply);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1580, 230));

        backgroundPanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 1640, 770));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1888, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     public void Header(){
         
         tblSupply.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD, 24));
     }
     private void table_update(){
           
           int c;
           
             try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            pst = con.prepareStatement("select * from agri_supply");
            
            rst = pst.executeQuery();
            ResultSetMetaData rss = rst.getMetaData();
            c = rss.getColumnCount();
            
            DefaultTableModel Df = (DefaultTableModel)tblSupply.getModel();
            
            Df.setRowCount(0);
            
            while(rst.next()){
                
                Vector v2 = new Vector();
                
                for(int a=1; a<=c; a++)
                {
                    v2.add(rst.getString("Agri_Supply_ID"));
                    v2.add(rst.getString("Type_of_Stock"));
                    v2.add(rst.getString("Stock_Variety"));
                    v2.add(rst.getString("Stock_Description"));
                    v2.add(rst.getString("Name_of_Delivery_Man"));
                    v2.add(rst.getString("Date_Deliver"));
             
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
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            state = con.createStatement();
            rst = state.executeQuery("SELECT Max(Agri_Supply_ID) FROM agri_supply");
            rst.next();
 
            if(rst.getString("Max(Agri_Supply_ID)")== null){
                 lblID.setText("AgriSupply-0001");
            }else{
            String preid = rst.getString("MAX(Agri_Supply_ID)");
            String data = preid.replace("AgriSupply-", "");
            int num =Integer.parseInt(data);
            num=num+1;
            String nextID=getnumerformat(num);
            lblID.setText(nextID);
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
    
    
    
    
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
         SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd");
          String supplyID = lblID.getText();
          String type = txtStockType.getText();
          String variety = txtStockVariety.getText();
          String stockdesc = txtStockDesc.getText();
          String deliveryname = txtDeliveryName.getText();
          String date = format.format(jDateDeliver.getDate());
          try {
              
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            pst = con.prepareStatement("insert into agri_supply(Agri_Supply_ID,Type_of_Stock,Stock_Variety,"
                    + "Stock_Description,Name_of_Delivery_Man,Date_Deliver)values(?,?,?,?,?,?)");
           
            pst.setString(1, supplyID);
            pst.setString(2, type);
            pst.setString(3, variety);
            pst.setString(4, stockdesc);
            pst.setString(5, deliveryname);
            pst.setString(6, date);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(this,"Record Addedd!!");
            autoid();
            table_update();
            txtStockType.setText("");
            txtStockVariety.setText("");
            txtStockDesc.setText("");
            txtDeliveryName.setText("");
            txtStockType.requestFocus();
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
         SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd");
          String supplyID = lblID.getText();
          String type = txtStockType.getText();
          String variety = txtStockVariety.getText();
          String stockdesc = txtStockDesc.getText();
          String deliveryname = txtDeliveryName.getText();
          String date = format.format(jDateDeliver.getDate());
          try {
              
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            pst = con.prepareStatement("UPDATE agri_supply SET Type_of_Stock=?, Stock_Variety=?, Stock_Description=?,"
                    + "Name_of_Delivery_Man=?, Date_Deliver=? WHERE Agri_Supply_ID=?");
           
            pst.setString(6, supplyID);
            pst.setString(1, type);
            pst.setString(2, variety);
            pst.setString(3, stockdesc);
            pst.setString(4, deliveryname);
            pst.setString(5, date);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(this,"Record Addedd!!");
            autoid();
            table_update();
            txtStockType.setText("");
            txtStockVariety.setText("");
            txtStockDesc.setText("");
            txtDeliveryName.setText("");
            txtStockType.requestFocus();
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void tblSupplyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSupplyMouseClicked
        try {
            // TODO add your handling code here:
            DefaultTableModel Df = (DefaultTableModel)tblSupply.getModel();
            int SelectedRows = tblSupply.getSelectedRow();
            lblID.setText(Df.getValueAt(SelectedRows, 0).toString());
            txtStockType.setText(Df.getValueAt(SelectedRows,1).toString());
            txtStockVariety.setText(Df.getValueAt(SelectedRows, 2).toString());
            txtStockDesc.setText(Df.getValueAt(SelectedRows, 3).toString());
            txtDeliveryName.setText(Df.getValueAt(SelectedRows, 4).toString());
            
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            String sql ="SELECT Date_Deliver FROM agri_supply where Agri_Supply_ID=?";      
            pst = con.prepareStatement(sql);
            pst.setString(1, lblID.getText());
            rst = pst.executeQuery();
            while(rst.next()){
                Date date = rst.getDate("Date_Deliver");
                      jDateDeliver.setDate(date);
                
                
            }
            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AgriSupply.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AgriSupply.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblSupplyMouseClicked

    private void lblStocksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStocksMouseClicked
        // TODO add your handling code here:
        Stock stock = new Stock();
        stock.setVisible(true);
        dispose();
    }//GEN-LAST:event_lblStocksMouseClicked

    private void lblRecordsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRecordsMouseClicked
        // TODO add your handling code here:
        Records record = new Records();
        record.setVisible(true);
        dispose();
    }//GEN-LAST:event_lblRecordsMouseClicked

    private void lbleleaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbleleaseMouseClicked
        // TODO add your handling code here:
        Release release = new Release();
        release.setVisible(true);
        dispose();
    }//GEN-LAST:event_lbleleaseMouseClicked

    
    
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
            java.util.logging.Logger.getLogger(AgriSupply.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgriSupply.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgriSupply.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgriSupply.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgriSupply().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnEdit;
    private com.toedter.calendar.JDateChooser jDateDeliver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDeliveryName;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblRecords;
    private javax.swing.JLabel lblStockDesc;
    private javax.swing.JLabel lblStockType;
    private javax.swing.JLabel lblStockVariety;
    private javax.swing.JLabel lblStocks;
    private javax.swing.JLabel lblSupplyID;
    private javax.swing.JLabel lblelease;
    private javax.swing.JTable tblSupply;
    private javax.swing.JTextField txtDeliveryName;
    private javax.swing.JTextField txtStockDesc;
    private javax.swing.JTextField txtStockType;
    private javax.swing.JTextField txtStockVariety;
    // End of variables declaration//GEN-END:variables
}
