
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
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
public class product extends javax.swing.JInternalFrame {

     Connection con1;
     PreparedStatement insert;
     PreparedStatement insert2;
     ResultSet rs;
     ResultSet rs2;
     Statement state;
    String current;
    String deliverqty;
    String id;
    String lastid = null;
    String Date;
    ImageIcon icon = new ImageIcon("error.png");
     ImageIcon icon2 = new ImageIcon("success.png");
     ImageIcon icon1 = new ImageIcon("question.png");
    public product() {
        initComponents();
        
        btnplus.hide();
        btnminus.hide();
        txtQuantity.hide();
      txtStockID.setText("AgriSupply-");  
        //tblStocks.setEnabled(false);
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = ( BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        jLabel1.hide();
        table_update();
        Header();
        Supply();
        tblDeliver();
        autoid();
    }

     public void tblDeliver(){
        TableColumnModel model = tblDeliver.getColumnModel();
         model.getColumn(0).setPreferredWidth(200);
         model.getColumn(1).setPreferredWidth(250);
         model.getColumn(2).setPreferredWidth(300);
         model.getColumn(3).setPreferredWidth(250);
         model.getColumn(4).setPreferredWidth(200);
         model.getColumn(5).setPreferredWidth(200);
         model.getColumn(6).setPreferredWidth(130);
         model.getColumn(7).setPreferredWidth(250);
        
    }
     public void autoid(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            state = con1.createStatement();
            rs = state.executeQuery("SELECT Max(DeliveredID) FROM stock_delivered");
            rs.next();
            
              if(rs.getString("Max(DeliveredID)")== null){
                 jLabel1.setText("Deliver-0001");
            }else{
             String preid = rs.getString("Max(DeliveredID)");
            String data = preid.replace("Deliver-", "");
            int num =Integer.parseInt(data);
            num=num+1;
            String nextID=getnumerformat(num);
            jLabel1.setText(nextID);
            System.out.print(nextID);
             }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AgriSupply.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AgriSupply.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
    public static String getnumerformat(int number){
        
        String numberData="Deliver-";
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
    
     private void Supply() {

        int c;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar", "root", "DANIEL05");
            insert = con1.prepareStatement("select * from stock_delivered ORDER BY DeliveredID DESC");

            rs = insert.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            c = rss.getColumnCount();

            DefaultTableModel Df = (DefaultTableModel) tblDeliver.getModel();

            Df.setRowCount(0);

            while (rs.next()) {

                Vector v2 = new Vector();

                for (int a = 1; a <= c; a++) {
                     v2.add(rs.getString("DeliveredID"));
                    v2.add(rs.getString("Date_Delivered"));
                    v2.add(rs.getString("Stock_ID"));
                    v2.add(rs.getString("Type_of_Stock"));
                    v2.add(rs.getString("Name"));
                    v2.add(rs.getString("Quantity_Delivered"));
                    v2.add(rs.getString("Type_of_the_Stock"));
                    v2.add(rs.getString("Name_of_Delivery_Man"));
                    
                   
                }

                Df.addRow(v2);

            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
  
    
   
    
    public void editfalse(){
         txtStockID.setEditable(false);
        txtStocktype.setEditable(false);
        txtVariety.setEditable(false);
        txtQuantity.setEditable(false);
        txtType.setEditable(false);
        txtDelievery.setEditable(false);
    }
      public void Header(){
         
         tblStocks.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD, 24));
         tblDeliver.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD, 24));
         
         
     }
    
    private void table_update(){
           
           int c;
           
             try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            insert = con1.prepareStatement("select * from stock2");
            
            rs = insert.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            c = rss.getColumnCount();
            
            DefaultTableModel Df = (DefaultTableModel)tblStocks.getModel();
            Df.setRowCount(0);
            
            while(rs.next()){
                
                Vector v2 = new Vector();
                
                for(int a=1; a<=c; a++)
                {
                    v2.add(rs.getString("Stock_ID"));
                    v2.add(rs.getString("Type_of_Stock"));
                    v2.add(rs.getString("Name"));
                    v2.add(rs.getString("Description"));
                    v2.add(rs.getString("Quantity"));
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
        PanelAdd1 = new javax.swing.JPanel();
        lblQuantity = new javax.swing.JLabel();
        lblType = new javax.swing.JLabel();
        lblEdit = new javax.swing.JLabel();
        lblDelete = new javax.swing.JLabel();
        lblSave = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        lblFertilizer = new javax.swing.JLabel();
        lblName1 = new javax.swing.JLabel();
        lblStockID = new javax.swing.JLabel();
        txtStockID = new javax.swing.JTextField();
        txtType = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lblFertilizer1 = new javax.swing.JLabel();
        txtDelievery = new javax.swing.JTextField();
        txtVariety = new javax.swing.JTextField();
        txtStocktype = new javax.swing.JTextField();
        btnEdit = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStocks = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDeliver = new javax.swing.JTable();
        btnminus = new javax.swing.JButton();
        btnplus = new javax.swing.JButton();
        txtaddqty = new javax.swing.JTextField();
        btnAddSave = new javax.swing.JButton();
        btnDeleteSave = new javax.swing.JButton();
        btnMinusSave = new javax.swing.JButton();
        btnaddEditSave = new javax.swing.JButton();
        btneditsave = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
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

        lblQuantity.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblQuantity.setText("Quantity");
        PanelAdd1.add(lblQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 510, 190, 50));

        lblType.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblType.setText("Stock Type");
        PanelAdd1.add(lblType, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 190, 50));

        lblEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyImages/edit.png"))); // NOI18N
        PanelAdd1.add(lblEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 660, 50, 50));

        lblDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyImages/-.png"))); // NOI18N
        PanelAdd1.add(lblDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 660, 60, 50));

        lblSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyImages/+.png"))); // NOI18N
        PanelAdd1.add(lblSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 660, 60, 50));

        txtQuantity.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });
        txtQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQuantityKeyTyped(evt);
            }
        });
        PanelAdd1.add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 510, 150, 50));

        btnDelete.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        PanelAdd1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 660, 150, 50));

        lblFertilizer.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblFertilizer.setText("Carrier Name");
        PanelAdd1.add(lblFertilizer, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 580, 180, 50));

        lblName1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblName1.setText("Name");
        PanelAdd1.add(lblName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 190, 50));

        lblStockID.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblStockID.setText("Stock ID");
        PanelAdd1.add(lblStockID, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 190, 50));

        txtStockID.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        txtStockID.setOpaque(true);
        txtStockID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockIDActionPerformed(evt);
            }
        });
        txtStockID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtStockIDKeyReleased(evt);
            }
        });
        PanelAdd1.add(txtStockID, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 260, 50));

        txtType.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        PanelAdd1.add(txtType, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 440, 260, 50));

        jButton1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        jButton1.setText("Add Quantity");
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        PanelAdd1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 660, 200, 50));

        lblFertilizer1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblFertilizer1.setText("Description");
        PanelAdd1.add(lblFertilizer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, 190, 50));

        txtDelievery.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        PanelAdd1.add(txtDelievery, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 580, 260, 50));

        txtVariety.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        PanelAdd1.add(txtVariety, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, 260, 50));

        txtStocktype.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        PanelAdd1.add(txtStocktype, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 260, 50));

        btnEdit.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        PanelAdd1.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 660, 130, 50));

        jTabbedPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N

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
                "Stock_ID", "Type of Stock", "Name", "Description", "Stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
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

        jTabbedPane1.addTab("Stock's", jScrollPane2);

        tblDeliver.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        tblDeliver.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Date Delivered", "Stock ID", "Type of Stock", "Name", "Quantity Delivered", "Description", "Carrier Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
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
        tblDeliver.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblDeliver.setGridColor(new java.awt.Color(0, 204, 0));
        tblDeliver.setRowHeight(30);
        tblDeliver.setSelectionBackground(new java.awt.Color(0, 255, 0));
        tblDeliver.setShowHorizontalLines(true);
        tblDeliver.setShowVerticalLines(true);
        tblDeliver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDeliverMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblDeliver);

        jTabbedPane1.addTab("Supply Delivered", jScrollPane3);

        PanelAdd1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1420, 190));

        btnminus.setFont(new java.awt.Font("Segoe UI Semibold", 0, 22)); // NOI18N
        btnminus.setText("-");
        btnminus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnminusActionPerformed(evt);
            }
        });
        PanelAdd1.add(btnminus, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 510, 50, 50));

        btnplus.setFont(new java.awt.Font("Segoe UI Semibold", 0, 22)); // NOI18N
        btnplus.setText("+");
        btnplus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnplusActionPerformed(evt);
            }
        });
        PanelAdd1.add(btnplus, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 510, 50, 50));

        txtaddqty.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        txtaddqty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtaddqtyKeyTyped(evt);
            }
        });
        PanelAdd1.add(txtaddqty, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 510, 260, 50));

        btnAddSave.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        btnAddSave.setText("Save");
        btnAddSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSaveActionPerformed(evt);
            }
        });
        PanelAdd1.add(btnAddSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 670, -1, 50));

        btnDeleteSave.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        btnDeleteSave.setText("Save");
        btnDeleteSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteSaveActionPerformed(evt);
            }
        });
        PanelAdd1.add(btnDeleteSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 670, -1, 50));

        btnMinusSave.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        btnMinusSave.setText("Save");
        btnMinusSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinusSaveActionPerformed(evt);
            }
        });
        PanelAdd1.add(btnMinusSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 670, -1, 50));

        btnaddEditSave.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        btnaddEditSave.setText("Save");
        btnaddEditSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddEditSaveActionPerformed(evt);
            }
        });
        PanelAdd1.add(btnaddEditSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 670, -1, 50));

        btneditsave.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        btneditsave.setText("Save");
        btneditsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditsaveActionPerformed(evt);
            }
        });
        PanelAdd1.add(btneditsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 670, -1, 50));
        PanelAdd1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 250, 80, 40));

        bg.add(PanelAdd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 1460, 730));

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
            .addGap(0, 1610, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        bg.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-8, 770, 1610, 70));

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );

        bg.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 20, 780));

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

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
       btnMinusSave.hide();
       btneditsave.hide();
       btnaddEditSave.hide();
       btnDeleteSave.show();
       btnAddSave.hide();   
       btnplus.hide();
       btnminus.hide();
       txtQuantity.hide();
       txtaddqty.show();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txtQuantity.hide();
        txtaddqty.show();
        btnplus.hide();
        btnminus.hide();       
        btnMinusSave.hide();
        btnaddEditSave.hide();
        btnDeleteSave.hide();
        btnAddSave.show();
        btneditsave.hide();
        txtQuantity.setEditable(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        tblDeliver.setEnabled(true);
        btneditsave.hide();
        txtaddqty.hide();
        btnplus.show();
        btnminus.show();
        txtQuantity.show();
        btnDeleteSave.hide();
        btnAddSave.hide();
        btneditsave.show();
        btnMinusSave.hide();
        btnaddEditSave.hide();
        txtStockID.setEditable(true);
        txtStocktype.setEditable(false);
        txtVariety.setEditable(false);
        txtQuantity.setEditable(true);
        txtType.setEditable(false);
        txtDelievery.setEditable(true);
    }//GEN-LAST:event_btnEditActionPerformed

    private void tblStocksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStocksMouseClicked
        // TODO add your handling code here:
         DefaultTableModel Df = (DefaultTableModel)tblStocks.getModel();
        int SelectedRows = tblStocks.getSelectedRow();
       
        txtStockID.setText(Df.getValueAt(SelectedRows, 0).toString());
        txtStocktype.setText(Df.getValueAt(SelectedRows, 1).toString());
        txtVariety.setText(Df.getValueAt(SelectedRows, 2).toString());
        txtType.setText(Df.getValueAt(SelectedRows,3).toString());
        
         try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            insert = con1.prepareStatement("SELECT Quantity from stock2 where Stock_ID = ?");
            String ids = (txtStockID.getText());
            insert.setString(1,ids);
            rs = insert.executeQuery();
            if(rs.next() == true){

                current = rs.getString("Quantity");

            }
            else {

            }

        }catch (Exception e){

        }
        
    }//GEN-LAST:event_tblStocksMouseClicked

    private void btnminusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnminusActionPerformed
       btnMinusSave.show();
        btnaddEditSave.hide();
        btnDeleteSave.hide();
        btnAddSave.hide();    
        btneditsave.hide();
    }//GEN-LAST:event_btnminusActionPerformed

    private void btnplusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnplusActionPerformed
       btnMinusSave.hide();
       btnaddEditSave.show();
       btnDeleteSave.hide();
       btnAddSave.hide();     
       btneditsave.hide();
    }//GEN-LAST:event_btnplusActionPerformed

    private void txtStockIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockIDKeyReleased

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            insert = con1.prepareStatement(" SELECT Agri_Supply_ID,Type_of_Stock,Stock_Variety,Stock_Description "
                + "from agri_supply where Agri_Supply_ID = ?");
            String id = (txtStockID.getText());
            insert.setString(1,id);
            rs = insert.executeQuery();
            if(rs.next() == true){
                String fname = rs.getString("Type_of_Stock");
                txtStocktype.setText(fname);
                String mname = rs.getString("Stock_Variety");
                txtVariety.setText(mname);
                String lname = rs.getString("Stock_Description");
                txtType.setText(lname);

            }
            else {
                txtStocktype.setText("");
                txtVariety.setText("");
                txtType.setText("");

            }

        }catch (Exception e){

        }

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            insert = con1.prepareStatement("SELECT Quantity from stock2 where Stock_ID = ?");
            String ids = (txtStockID.getText());
            insert.setString(1,ids);
            rs = insert.executeQuery();
            if(rs.next() == true){

                current = rs.getString("Quantity");

            }
            else {

            }

        }catch (Exception e){

        }
    }//GEN-LAST:event_txtStockIDKeyReleased

    private void tblDeliverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDeliverMouseClicked
        DefaultTableModel Df = (DefaultTableModel)tblDeliver.getModel();
        int SelectedRows = tblDeliver.getSelectedRow();
       
        jLabel1.setText(Df.getValueAt(SelectedRows, 0).toString());
        Date =(Df.getValueAt(SelectedRows, 1).toString());
        txtStockID.setText(Df.getValueAt(SelectedRows, 2).toString());
        txtStocktype.setText(Df.getValueAt(SelectedRows,3).toString());
        txtVariety.setText(Df.getValueAt(SelectedRows, 4).toString());
        deliverqty = (Df.getValueAt(SelectedRows, 5).toString());
        txtType.setText(Df.getValueAt(SelectedRows, 6).toString());
        txtDelievery.setText(Df.getValueAt(SelectedRows, 7).toString());
        System.out.println(deliverqty);
        System.out.println(id);
        System.out.println(Date);
        
        
         try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            insert = con1.prepareStatement(" SELECT Stock_ID,Type_of_Stock,Name,Description"
                + "from stock2 where Stock_ID = ?");
            String id = (txtStockID.getText());
            insert.setString(1,id);
            rs = insert.executeQuery();
            if(rs.next() == true){
                String fname = rs.getString("Type_of_Stock");
                txtStocktype.setText(fname);
                String mname = rs.getString("Name");
                txtVariety.setText(mname);
                String lname = rs.getString("Description");
                txtType.setText(lname);

            }
            else {
                txtStocktype.setText("");
                txtVariety.setText("");
                txtType.setText("");

            }

        }catch (Exception e){

        }

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            insert = con1.prepareStatement("SELECT Quantity from stock2 where Stock_ID = ?");
            String ids = (txtStockID.getText());
            insert.setString(1,ids);
            rs = insert.executeQuery();
            if(rs.next() == true){

                current = rs.getString("Quantity");

            }
            else {

            }

        }catch (Exception e){

        }
        
    }//GEN-LAST:event_tblDeliverMouseClicked

    private void txtStockIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockIDActionPerformed

    private void txtQuantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantityKeyTyped
         char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtQuantityKeyTyped

    private void txtaddqtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtaddqtyKeyTyped
         char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtaddqtyKeyTyped

    private void btnAddSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSaveActionPerformed
         String stockids = txtStockID.getText();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            state = con1.createStatement();
            rs = state.executeQuery("SELECT* FROM stock2 WHERE Stock_ID = '" +stockids+ "' ");
            
            if(rs.next()==true){
                String yes = rs.getString("Stock_ID");
                System.out.println(stockids);
                
                  Date date = new Date();
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        String currentdate = dateformat.format(date);
        
        String stockid = txtStockID.getText();
        String type = txtStocktype.getText();
        String name = txtVariety.getText();
        String qty = txtaddqty.getText();
        String desc = txtType.getText();
        String deliverid =jLabel1.getText();
             String deliveryName = txtDelievery.getText();
             int cur  = Integer.parseInt(current);
             System.out.println("current"+cur);
             int quantity  = Integer.parseInt(qty);
             int total =   cur + quantity  ;
            String ne = Integer.toString(total);
           System.out.print("total"+ne);
           
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
           insert = con1.prepareStatement("update stock2 set Quantity=? where Stock_ID=?");

            insert.setString(2, yes);
            insert.setString(1, ne);
            insert.executeUpdate();
            
              insert = con1.prepareStatement("insert into stock_delivered(DeliveredID,Date_Delivered,Stock_ID,Type_of_Stock,Name,"
                     + "Quantity_Delivered,Type_of_the_Stock,Name_of_Delivery_Man)values(?,?,?,?,?,?,?,?)");
            insert.setString(1, deliverid);
            insert.setString(2, currentdate);
            insert.setString(3, yes);
            insert.setString(4, type);
            insert.setString(5, name);
            insert.setString(6, qty);
            insert.setString(7, desc);
            insert.setString(8, deliveryName);
            
            insert.executeUpdate();
            JOptionPane.showMessageDialog(this,"<html><b style=\"color:black; font-size:15px;\">Add Successfuly!</b></html>","Success",JOptionPane.INFORMATION_MESSAGE,icon2);
            Supply();
            table_update();
            autoid();
            txtStockID.setText(null);
            txtStocktype.setText(null);
            txtVariety.setText(null);
            txtQuantity.setText(null);
            txtType.setText(null);
            txtDelievery.setText(null);
            txtaddqty.setText(null);
            
            }else{
                Date date = new Date();
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        String currentdate = dateformat.format(date);
      

        String stockid = txtStockID.getText();
        String type = txtStocktype.getText();
        String name = txtVariety.getText();
        String addqty = txtaddqty.getText();
        String desc = txtType.getText();
        String deliverid =jLabel1.getText();
        String deliveryName = txtDelievery.getText();
         if (stockid.isEmpty() || type.isEmpty() || name.isEmpty()  || desc.isEmpty() || deliveryName.isEmpty()){
        JOptionPane.showMessageDialog(null, "<html><b style=\"color:black; font-size:15px;\">Fill the Blank!</b></html>","Complete the details", JOptionPane.ERROR_MESSAGE,icon);

            }else{

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            insert = con1.prepareStatement("update stock2 set Quantity=? where Stock_ID=?");

            insert.setString(1, stockids);
            insert.setString(2, addqty);
            insert.executeUpdate();
            
            insert = con1.prepareStatement("insert into stock_delivered(DeliveredID,Date_Delivered,Stock_ID,Type_of_Stock,Name,"
                     + "Quantity_Delivered,Type_of_the_Stock,Name_of_Delivery_Man)values(?,?,?,?,?,?,?,?)");
            insert.setString(1, deliverid);
            insert.setString(2, currentdate);
            insert.setString(3, stockids);
            insert.setString(4, type);
            insert.setString(5, name);
            insert.setString(6, addqty);
            insert.setString(7, desc);
            insert.setString(8, deliveryName);
            
            
            insert.executeUpdate();
            JOptionPane.showMessageDialog(this,"<html><b style=\"color:black; font-size:15px;\">Add Successfuly!</b></html>","Success",JOptionPane.INFORMATION_MESSAGE,icon2);
            table_update();
            Supply();

            txtVariety.setText("");
            txtQuantity.setText("");
            txtType.setText("");
            txtDelievery.setText("");
            txtaddqty.setText("");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
            }
            
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_btnAddSaveActionPerformed

    private void btnDeleteSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteSaveActionPerformed
            String supplyID  = txtStockID.getText();
            String type = txtStocktype.getText();
            String stockName = txtVariety.getText();
            String desc =txtType.getText();
            if (supplyID.isEmpty() || type.isEmpty() || stockName.isEmpty() || desc.isEmpty()){
             JOptionPane.showMessageDialog(null, "<html><b style=\"color:black; font-size:15px;\">Fill the Blank!</b></html>","Complete the details", JOptionPane.ERROR_MESSAGE,icon);
            }else{    
        int op =JOptionPane.showConfirmDialog(null, "<html><b style=\"color:black; font-size:15px;\">Are you sure to Delete</b></html>", "Delete", JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,icon1);
        if(op == 0){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con1= DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
                String query = "DELETE FROM stock_delivered where DeliveredID=?";
                insert = con1.prepareStatement(query);
                insert.setString(1,jLabel1.getText());
                insert.executeUpdate();
                JOptionPane.showMessageDialog(this,"<html><b style=\"color:black; font-size:15px;\">Delete Successfuly!</b></html>","Success",JOptionPane.INFORMATION_MESSAGE,icon2);
                Supply();
                table_update();
                txtStockID.setText(null);
                txtStocktype.setText(null);
                txtVariety.setText(null);
                txtQuantity.setText(null);
                txtType.setText(null);
                txtDelievery.setText(null);
                txtaddqty.setText(null);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }    
    }//GEN-LAST:event_btnDeleteSaveActionPerformed

    private void btnMinusSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinusSaveActionPerformed
         try{
             String supplyID  = txtStockID.getText();
             String type = txtStocktype.getText();
             String deliveryName = txtDelievery.getText();
             String stockid = txtStockID.getText();
             String qty = txtQuantity.getText();
              String stockName = txtVariety.getText();
             if (supplyID.isEmpty() || type.isEmpty() || stockName.isEmpty() || stockid.isEmpty() || qty.isEmpty()){
             JOptionPane.showMessageDialog(null, "<html><b style=\"color:black; font-size:15px;\">Fill the Blank!</b></html>","Complete the details", JOptionPane.ERROR_MESSAGE,icon);

            }else{
             int cur1  = Integer.parseInt(deliverqty);
             System.out.println(cur1);
             int quantity1  = Integer.parseInt(qty);
             int total1 =   cur1 - quantity1  ;
             String ne1 = Integer.toString(total1);
             System.out.print(ne1);
           
             int cur  = Integer.parseInt(current);
             System.out.println(cur);
             int quantity  = Integer.parseInt(qty);
             int total =   cur - quantity  ;
            String ne = Integer.toString(total);
           System.out.print(ne);
           
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
           insert = con1.prepareStatement("update stock2 set Quantity=? where Stock_ID=?");

            insert.setString(2, stockid);
            insert.setString(1, ne);
            insert.executeUpdate();
            insert = con1.prepareStatement("UPDATE stock_delivered set Quantity_Delivered=?,Name_of_Delivery_Man=?"
                    + "where DeliveredID=?");
             
            insert.setString(3, id);
            insert.setString(1, ne1);
            insert.setString(2, deliveryName);
            insert.executeUpdate();
            JOptionPane.showMessageDialog(this,"<html><b style=\"color:black; font-size:15px;\">Edit Successfuly!</b></html>","Success",JOptionPane.INFORMATION_MESSAGE,icon2);
            Supply();
            table_update();
            
            txtStockID.setText(null);
            txtStocktype.setText(null);
            txtVariety.setText(null);
            txtQuantity.setText(null);
            txtType.setText(null);
           txtDelievery.setText(null);
           }
         }catch(Exception e){
             
         } 
            
    }//GEN-LAST:event_btnMinusSaveActionPerformed

    private void btnaddEditSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddEditSaveActionPerformed
         try{
             String stockid = txtStockID.getText();
             String type = txtStocktype.getText();
             String name = txtVariety.getText();
             String qty = txtQuantity.getText();
             String desc = txtType.getText();
             String deliveryName = txtDelievery.getText();
             if (stockid.isEmpty() || type.isEmpty() || name.isEmpty() || desc.isEmpty() || qty.isEmpty() || deliveryName.isEmpty()){
             JOptionPane.showMessageDialog(null, "<html><b style=\"color:black; font-size:15px;\">Fill the Blank!</b></html>","Complete the details", JOptionPane.ERROR_MESSAGE,icon);
             }else{
             int cur1  = Integer.parseInt(deliverqty);
             System.out.println(cur1);
             int quantity1  = Integer.parseInt(qty);
             int total1 =   cur1 + quantity1  ;
             String ne1 = Integer.toString(total1);
             System.out.print(ne1);
             
             int cur  = Integer.parseInt(current);
             System.out.println("current"+cur);
             int quantity  = Integer.parseInt(qty);
             int total =   cur + quantity  ;
             String ne = Integer.toString(total);
             System.out.print("total"+ne);
           
             Class.forName("com.mysql.cj.jdbc.Driver");
             con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
             insert = con1.prepareStatement("update stock2 set Quantity=? where Stock_ID=?");

             insert.setString(2, stockid);
             insert.setString(1, ne);
             insert.executeUpdate();
             
             insert.setString(2, stockid);
             insert.setString(1, ne);
             insert.executeUpdate();
             insert = con1.prepareStatement("UPDATE stock_delivered set Quantity_Delivered=?,Name_of_Delivery_Man=?"
                    + "where DeliveredID=?");
             insert.setString(3, id);
             insert.setString(1, ne1);
             insert.setString(2, deliveryName);
             insert.executeUpdate();
             JOptionPane.showMessageDialog(this,"<html><b style=\"color:black; font-size:15px;\">Edit Successfuly!</b></html>","Success",JOptionPane.INFORMATION_MESSAGE,icon2);
             Supply();
             table_update();
             txtStockID.setText(null);
             txtStocktype.setText(null);
             txtVariety.setText(null);
             txtQuantity.setText(null);
             txtType.setText(null);
             txtDelievery.setText(null);
             }
         }catch(Exception e){    
         }
    }//GEN-LAST:event_btnaddEditSaveActionPerformed

    private void btneditsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditsaveActionPerformed
         try{
             String supplyID  = txtStockID.getText();
             String type = txtStocktype.getText();
             String deliveryName = txtDelievery.getText();
             String stockid = txtStockID.getText();
             String qty = txtQuantity.getText();
              String stockName = txtVariety.getText();
             if (supplyID.isEmpty() || type.isEmpty() || stockName.isEmpty() || stockid.isEmpty() || qty.isEmpty()){
             JOptionPane.showMessageDialog(null, "<html><b style=\"color:black; font-size:15px;\">Fill the Blank!</b></html>","Complete the details", JOptionPane.ERROR_MESSAGE,icon);

            }else{
             
            insert = con1.prepareStatement("UPDATE stock_delivered set Name_of_Delivery_Man=?"
                    + "where DeliveredID=?");
             
            insert.setString(2, id);
            insert.setString(1, deliveryName);
            insert.executeUpdate();
            JOptionPane.showMessageDialog(this,"<html><b style=\"color:black; font-size:15px;\">Edit Successfuly!</b></html>","Success",JOptionPane.INFORMATION_MESSAGE,icon2);
            Supply();
            table_update();
            
            txtStockID.setText(null);
            txtStocktype.setText(null);
            txtVariety.setText(null);
            txtQuantity.setText(null);
            txtType.setText(null);
           txtDelievery.setText(null);
           }
         }catch(Exception e){
             
         } 
    }//GEN-LAST:event_btneditsaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelAdd1;
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnAddSave;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDeleteSave;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnMinusSave;
    private javax.swing.JButton btnaddEditSave;
    private javax.swing.JButton btneditsave;
    private javax.swing.JButton btnminus;
    private javax.swing.JButton btnplus;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblDelete;
    private javax.swing.JLabel lblEdit;
    private javax.swing.JLabel lblFertilizer;
    private javax.swing.JLabel lblFertilizer1;
    private javax.swing.JLabel lblName1;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblSave;
    private javax.swing.JLabel lblStockID;
    private javax.swing.JLabel lblType;
    private javax.swing.JTable tblDeliver;
    private javax.swing.JTable tblStocks;
    private javax.swing.JTextField txtDelievery;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtStockID;
    private javax.swing.JTextField txtStocktype;
    private javax.swing.JTextField txtType;
    private javax.swing.JTextField txtVariety;
    private javax.swing.JTextField txtaddqty;
    // End of variables declaration//GEN-END:variables
}
