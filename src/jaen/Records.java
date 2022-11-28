/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jaen;

import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Daniel Emas
 */
public class Records extends javax.swing.JFrame {

    /**
     * Creates new form Records
     */
    public Records() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Profile();
        Stocks();
        //Release();
        showdata(" ", " ");
       Supply();
        Header();
    }
    Connection con;
    PreparedStatement pst;
    ResultSet rst;
    
    public void Header(){
         
       
         tblprofile.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD, 20));
         tblStocks.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD, 20));
         tblRelease.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD, 20));
         tblDeliver.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD, 20));
     }
    
    public void showdata(String date1, String date2){
        try{
            if(date1.equals(" ") || date2.equals(" ")){
                pst = con.prepareStatement("SELECT *FROM give");
            }
            else{
                 pst = con.prepareStatement("SELECT *FROM give WHERE Date BETWEEN ? AND ?");
                 pst.setString(1, date1);
                 pst.setString(2, date2);   
            
            }
            rst = pst.executeQuery();
             DefaultTableModel Df = (DefaultTableModel)tblRelease.getModel();
             Object [] row;
             while(rst.next()){
                 row = new Object[8];
                 row[0] = rst.getString(1);
                 row[1] = rst.getString(2);
                 row[2] = rst.getString(3);
                 row[3] = rst.getString(4);
                 row[4] = rst.getString(5);
                 row[5] = rst.getString(6);
                 row[6] = rst.getInt(7);  
                 row[7] = rst.getString(8);
                 
                 Df.addRow(row);


                 
             }
            

        }catch (Exception e){
            System.out.print(e.getMessage());
            
        }
    }

  
    
     private void Profile() {

        int c;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar", "root", "DANIEL05");
            pst = con.prepareStatement("select FID,LName,FName,MName,EName,House_No,House_No,Street,Barangay,Municipality,Province,Region from profile");

            rst = pst.executeQuery();
            ResultSetMetaData rss = rst.getMetaData();
            c = rss.getColumnCount();

            DefaultTableModel Df = (DefaultTableModel) tblprofile.getModel();

            Df.setRowCount(0);

            while (rst.next()) {

                Vector v2 = new Vector();

                for (int a = 1; a <= c; a++) {
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
        } catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
     private void Supply() {

        int c;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar", "root", "DANIEL05");
            pst = con.prepareStatement("select * from stock_delivered");

            rst = pst.executeQuery();
            ResultSetMetaData rss = rst.getMetaData();
            c = rss.getColumnCount();

            DefaultTableModel Df = (DefaultTableModel) tblDeliver.getModel();

            Df.setRowCount(0);

            while (rst.next()) {

                Vector v2 = new Vector();

                for (int a = 1; a <= c; a++) {
                    v2.add(rst.getString("Date_Delivered"));
                    v2.add(rst.getString("Stock_ID"));
                    v2.add(rst.getString("Type_of_Stock"));
                    v2.add(rst.getString("Name"));
                    v2.add(rst.getString("Quantity_Delivered"));
                    v2.add(rst.getString("Type_of_the_Stock"));
                    v2.add(rst.getString("Name_of_Delivery_Man"));
                    
                   
                }

                Df.addRow(v2);

            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
  

      private void Stocks() {

        int c;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar", "root", "DANIEL05");
            pst = con.prepareStatement("select * from stock");

            rst = pst.executeQuery();
            ResultSetMetaData rss = rst.getMetaData();
            c = rss.getColumnCount();

            DefaultTableModel Df = (DefaultTableModel) tblStocks.getModel();

            Df.setRowCount(0);

            while (rst.next()) {

                Vector v2 = new Vector();

                for (int a = 1; a <= c; a++) {
                    v2.add(rst.getString("Stock_ID"));
                    v2.add(rst.getString("Type_of_Stock"));
                    v2.add(rst.getString("Name"));
                    v2.add(rst.getString("Quantity"));
                    v2.add(rst.getString("Type_of_the_Stock"));

                }

                Df.addRow(v2);

            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
      
      private void Release(){
           
           int c;
           
             try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            pst = con.prepareStatement("select * from give");
            
            rst = pst.executeQuery();
            ResultSetMetaData rss = rst.getMetaData();
            c = rss.getColumnCount();
            
            DefaultTableModel Df = (DefaultTableModel)tblRelease.getModel();
            
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblprofile = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStocks = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblRelease = new javax.swing.JTable();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDeliver = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        jPanel1.setBackground(new java.awt.Color(102, 255, 0));

        jPanel2.setBackground(new java.awt.Color(0, 204, 0));

        jLabel1.setFont(new java.awt.Font("Georgia", 3, 60)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("RECORD HISTORY");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyImages/back.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(265, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI Semibold", 3, 24)); // NOI18N

        jPanel4.setBackground(new java.awt.Color(0, 204, 0));

        tblprofile.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        tblprofile.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Farmr ID", "Last Name", "First Name", "Middle Name", "Extension Name", "House No", "Street", "Barangay", "Municipality", "Province", "Region"
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
        tblprofile.setGridColor(new java.awt.Color(0, 204, 0));
        tblprofile.setRowHeight(30);
        tblprofile.setSelectionBackground(new java.awt.Color(0, 255, 0));
        tblprofile.setShowHorizontalLines(true);
        tblprofile.setShowVerticalLines(true);
        tblprofile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblprofileMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblprofile);

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Search Farmer ");

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1695, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Farmer Profile", jPanel4);

        jPanel5.setBackground(new java.awt.Color(0, 204, 0));

        tblStocks.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        tblStocks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Stock_ID", "Type of Stock", "Name", "Quantity", "Types of the Stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
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
        tblStocks.setGridColor(new java.awt.Color(0, 255, 0));
        tblStocks.setRowHeight(30);
        tblStocks.setSelectionBackground(new java.awt.Color(51, 255, 51));
        tblStocks.setShowHorizontalLines(true);
        tblStocks.setShowVerticalLines(true);
        tblStocks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStocksMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblStocks);

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1708, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Stocks", jPanel5);

        jPanel6.setBackground(new java.awt.Color(0, 204, 0));

        tblRelease.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        tblRelease.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Release ID", "Date Release", "Recipient ID", "Farmer_Name", "Type ofS tock", "Stock Name", "Quantity", "Name of Distributor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRelease.setGridColor(new java.awt.Color(51, 204, 0));
        tblRelease.setRowHeight(30);
        tblRelease.setSelectionBackground(new java.awt.Color(51, 204, 0));
        tblRelease.setShowHorizontalLines(true);
        tblRelease.setShowVerticalLines(true);
        jScrollPane4.setViewportView(tblRelease);

        jDateChooser1.setDateFormatString("yyyy-MM-dd");

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jDateChooser2.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1689, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(61, 61, 61))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Release", jPanel6);

        jPanel3.setBackground(new java.awt.Color(0, 204, 0));

        tblDeliver.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        tblDeliver.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date Delivered", "Stock ID", "Type of Stock", "Name", "Quantity Delivered", "Description", "Name of Delivery Man"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDeliver.setGridColor(new java.awt.Color(0, 204, 0));
        tblDeliver.setRowHeight(30);
        tblDeliver.setSelectionBackground(new java.awt.Color(0, 255, 0));
        tblDeliver.setShowHorizontalLines(true);
        tblDeliver.setShowVerticalLines(true);
        jScrollPane3.setViewportView(tblDeliver);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1694, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Supply Diliver", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1754, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);

        setSize(new java.awt.Dimension(1918, 1009));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblStocksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStocksMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_tblStocksMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
       Home home = new Home();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void tblprofileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblprofileMouseClicked
        // TODO add your handling code here:
      

    }//GEN-LAST:event_tblprofileMouseClicked

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
         try{
            String query =" SELECT * FROM stock WHERE Stock_ID = ?";
            pst=con.prepareStatement(query);
            pst.setString(1, jTextField1.getText());
            rst = pst.executeQuery();
            
             DefaultTableModel Df = (DefaultTableModel)tblStocks.getModel();
             String search = jTextField1.getText();
             TableRowSorter< DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>(Df);
             tblStocks.setRowSorter(trs);
             trs.setRowFilter(RowFilter.regexFilter(search));
  
        }catch (Exception e){
            
        }
        
    }//GEN-LAST:event_jTextField1KeyReleased

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
          try{
             
            String query;
              query = " SELECT LName,FName,MName,EName,House_No,Street,"
                      + "Barangay,Municipality,Province,Region FROM profile WHERE FID = ?";
            pst=con.prepareStatement(query);
            pst.setString(1, txtSearch.getText());
            rst = pst.executeQuery();
            
             DefaultTableModel Df = (DefaultTableModel)tblprofile.getModel();
             String search = txtSearch.getText();
             TableRowSorter< DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>(Df);
             tblprofile.setRowSorter(trs);
             trs.setRowFilter(RowFilter.regexFilter(search));
  
        }catch (Exception e){
            
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try{
             SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String Date1  = date.format(jDateChooser1.getDate());
        String Date2  = date.format(jDateChooser2.getDate());
        tblRelease.setModel(new DefaultTableModel(null, new Object[]{"Release_ID","Date Release","Recepient ID","Farmer_Name","Type of Stock","Stock Name","Quantity","Name of Distributor"}));
        showdata(Date1, Date2);
        }catch (Exception e){
            
        }
       
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Records.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Records.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Records.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Records.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Records().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblDeliver;
    private javax.swing.JTable tblRelease;
    private javax.swing.JTable tblStocks;
    private javax.swing.JTable tblprofile;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
