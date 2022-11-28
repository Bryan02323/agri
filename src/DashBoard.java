
import jaen.login;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Daniel Emas
 */
public class DashBoard extends javax.swing.JFrame {

      Connection con1;
    PreparedStatement insert;
    ResultSet rst;
    Statement state;
    ImageIcon icon1 = new ImageIcon("question.png");
    Color DefaultColor,ClickedColor;
    public DashBoard() {
        initComponents();
        this.setTitle("Jaen");
       // this.setExtendedState(JFrame.MAXIMIZED_BOTH);
       //this.setSize(300, 300);
        bg();
        DefaultColor = new Color(0,153,0);
        ClickedColor =  new Color(153,153,153);
        panelHome.hide();
        panelHome.setBackground(DefaultColor);
        panelFarmer.setBackground(DefaultColor);
        panelStock.setBackground(DefaultColor);
        panelproduct.setBackground(DefaultColor);
        panelRelease.setBackground(DefaultColor);
        panelRecords.setBackground(DefaultColor);
        panellogout.setBackground(DefaultColor);
        setIconImage();
    }
   
    
    public void bg(){
       Icon i = jLabel1.getIcon();
       ImageIcon icon = (ImageIcon)i;
       Image image = icon.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
       jLabel1.setIcon(new ImageIcon(image));
       
       Icon a = jLabel5.getIcon();
       ImageIcon icon1 = (ImageIcon)a;
       Image image1 = icon1.getImage().getScaledInstance(jLabel5.getWidth(), jLabel5.getHeight(), Image.SCALE_SMOOTH);
       jLabel5.setIcon(new ImageIcon(image1));
       
       Icon l = jLabel6.getIcon();
       ImageIcon icon2 = (ImageIcon)l;
       Image image2 = icon2.getImage().getScaledInstance(jLabel6.getWidth(), jLabel6.getHeight(), Image.SCALE_SMOOTH);
       jLabel6.setIcon(new ImageIcon(image2));
       
      
       
   }
      public void Date(){
          Date date = new Date();
          SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
          String currentdate = dateformat.format(date);
          lblDate.setText(currentdate);
          
      }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblDate = new javax.swing.JLabel();
        lbltitle = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        panelHome = new javax.swing.JPanel();
        lblHome = new javax.swing.JLabel();
        panelFarmer = new javax.swing.JPanel();
        lblFarmer = new javax.swing.JLabel();
        panelStock = new javax.swing.JPanel();
        lblStock = new javax.swing.JLabel();
        panelRelease = new javax.swing.JPanel();
        lblStock1 = new javax.swing.JLabel();
        panelRecords = new javax.swing.JPanel();
        lblrecords = new javax.swing.JLabel();
        panellogout = new javax.swing.JPanel();
        lblLogout = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        panelproduct = new javax.swing.JPanel();
        lblStock2 = new javax.swing.JLabel();
        jDesktopPane = new javax.swing.JDesktopPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDate.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lblDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1490, 120, 130, 30));

        lbltitle.setFont(new java.awt.Font("Calisto MT", 1, 60)); // NOI18N
        lbltitle.setForeground(new java.awt.Color(255, 255, 255));
        lbltitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltitle.setText("Municipal of Jaen");
        jPanel1.add(lbltitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 980, 70));

        jLabel3.setFont(new java.awt.Font("Calisto MT", 1, 26)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Seeds & Fertilizer Management System");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 110, 530, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyImages/log.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 160, 130));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyImages/newlogo1.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1700, 10, 150, 140));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1540, 100, 140, 40));

        jLabel4.setFont(new java.awt.Font("Calisto MT", 1, 26)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Department of Agriculture");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 80, 430, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1880, 160));

        jPanel2.setBackground(new java.awt.Color(204, 204, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelHome.setBackground(new java.awt.Color(0, 204, 204));
        panelHome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        panelHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelHomeMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelHomeMousePressed(evt);
            }
        });
        panelHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHome.setFont(new java.awt.Font("Segoe UI Semibold", 3, 24)); // NOI18N
        lblHome.setForeground(new java.awt.Color(255, 255, 255));
        lblHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHome.setText("Home");
        lblHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHomeMouseClicked(evt);
            }
        });
        panelHome.add(lblHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 210, 30));

        jPanel2.add(panelHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 230, 50));

        panelFarmer.setBackground(new java.awt.Color(51, 255, 0));
        panelFarmer.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lblFarmer.setBackground(new java.awt.Color(0, 255, 255));
        lblFarmer.setFont(new java.awt.Font("Segoe UI Semibold", 3, 24)); // NOI18N
        lblFarmer.setForeground(new java.awt.Color(255, 255, 255));
        lblFarmer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFarmer.setText("Farmer's Profile");
        lblFarmer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFarmerMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelFarmerLayout = new javax.swing.GroupLayout(panelFarmer);
        panelFarmer.setLayout(panelFarmerLayout);
        panelFarmerLayout.setHorizontalGroup(
            panelFarmerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFarmerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFarmer, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelFarmerLayout.setVerticalGroup(
            panelFarmerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFarmerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFarmer, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(panelFarmer, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 230, 50));

        panelStock.setBackground(new java.awt.Color(102, 255, 0));
        panelStock.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lblStock.setFont(new java.awt.Font("Segoe UI Semibold", 3, 24)); // NOI18N
        lblStock.setForeground(new java.awt.Color(255, 255, 255));
        lblStock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStock.setText("Product Info");
        lblStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblStockMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelStockLayout = new javax.swing.GroupLayout(panelStock);
        panelStock.setLayout(panelStockLayout);
        panelStockLayout.setHorizontalGroup(
            panelStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelStockLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblStock, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );
        panelStockLayout.setVerticalGroup(
            panelStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelStockLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblStock, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(panelStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 230, 50));

        panelRelease.setBackground(new java.awt.Color(102, 255, 0));
        panelRelease.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lblStock1.setFont(new java.awt.Font("Segoe UI Semibold", 3, 24)); // NOI18N
        lblStock1.setForeground(new java.awt.Color(255, 255, 255));
        lblStock1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStock1.setText("Release");
        lblStock1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblStock1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelReleaseLayout = new javax.swing.GroupLayout(panelRelease);
        panelRelease.setLayout(panelReleaseLayout);
        panelReleaseLayout.setHorizontalGroup(
            panelReleaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelReleaseLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblStock1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelReleaseLayout.setVerticalGroup(
            panelReleaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelReleaseLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblStock1)
                .addGap(19, 19, 19))
        );

        jPanel2.add(panelRelease, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 230, 50));

        panelRecords.setBackground(new java.awt.Color(102, 255, 0));
        panelRecords.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lblrecords.setFont(new java.awt.Font("Segoe UI Semibold", 3, 24)); // NOI18N
        lblrecords.setForeground(new java.awt.Color(255, 255, 255));
        lblrecords.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblrecords.setText("Records");
        lblrecords.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblrecordsMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelRecordsLayout = new javax.swing.GroupLayout(panelRecords);
        panelRecords.setLayout(panelRecordsLayout);
        panelRecordsLayout.setHorizontalGroup(
            panelRecordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRecordsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblrecords, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        panelRecordsLayout.setVerticalGroup(
            panelRecordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRecordsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblrecords, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(panelRecords, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 230, 50));

        panellogout.setBackground(new java.awt.Color(51, 255, 0));
        panellogout.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lblLogout.setFont(new java.awt.Font("Segoe UI Semibold", 3, 24)); // NOI18N
        lblLogout.setForeground(new java.awt.Color(255, 255, 255));
        lblLogout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogout.setText("Logout");
        lblLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panellogoutLayout = new javax.swing.GroupLayout(panellogout);
        panellogout.setLayout(panellogoutLayout);
        panellogoutLayout.setHorizontalGroup(
            panellogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panellogoutLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        panellogoutLayout.setVerticalGroup(
            panellogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panellogoutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(panellogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 730, 230, 50));

        jSeparator1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, 780));

        panelproduct.setBackground(new java.awt.Color(102, 255, 0));
        panelproduct.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lblStock2.setFont(new java.awt.Font("Segoe UI Semibold", 3, 24)); // NOI18N
        lblStock2.setForeground(new java.awt.Color(255, 255, 255));
        lblStock2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStock2.setText("Add's Stock");
        lblStock2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblStock2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelproductLayout = new javax.swing.GroupLayout(panelproduct);
        panelproduct.setLayout(panelproductLayout);
        panelproductLayout.setHorizontalGroup(
            panelproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelproductLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblStock2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        panelproductLayout.setVerticalGroup(
            panelproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelproductLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblStock2, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(panelproduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 230, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 290, 800));

        jDesktopPane.setBackground(new java.awt.Color(242, 242, 242));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyImages/aa.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jDesktopPane.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPaneLayout = new javax.swing.GroupLayout(jDesktopPane);
        jDesktopPane.setLayout(jDesktopPaneLayout);
        jDesktopPaneLayout.setHorizontalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPaneLayout.setVerticalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jDesktopPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 1560, 790));

        jPanel11.setBackground(new java.awt.Color(204, 204, 0));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1880, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1880, 980));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblFarmerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFarmerMouseClicked
        this.setTitle("Farmer Registration");
        Farmer farmer = new Farmer();
       jDesktopPane.removeAll();
       jDesktopPane.add(farmer).setVisible(true);
       panelHome.show();
       
        panelHome.setBackground(DefaultColor);
        panelFarmer.setBackground(ClickedColor);
        panelStock.setBackground(DefaultColor);
        panelproduct.setBackground(DefaultColor);
        panelRelease.setBackground(DefaultColor);
        panelRecords.setBackground(DefaultColor);
        panellogout.setBackground(DefaultColor);
        
    }//GEN-LAST:event_lblFarmerMouseClicked

    private void lblStockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStockMouseClicked
      this.setTitle("Produc Information");
        Stock stock = new Stock();
        jDesktopPane.removeAll();
       jDesktopPane.add(stock).setVisible(true);
        panelHome.show();
       
        panelHome.setBackground(DefaultColor);
        panelFarmer.setBackground(DefaultColor);
        panelStock.setBackground(ClickedColor);
        panelproduct.setBackground(DefaultColor);
        panelRelease.setBackground(DefaultColor);
        panelRecords.setBackground(DefaultColor);
        panellogout.setBackground(DefaultColor);
    }//GEN-LAST:event_lblStockMouseClicked

    private void lblStock1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStock1MouseClicked
      this.setTitle("Stock Release");
        Release release = new Release();
       jDesktopPane.removeAll();
       jDesktopPane.add(release).setVisible(true);
        panelHome.show();
       
        panelHome.setBackground(DefaultColor);
        panelFarmer.setBackground(DefaultColor);
        panelStock.setBackground(DefaultColor);
        panelproduct.setBackground(DefaultColor);
        panelRelease.setBackground(ClickedColor);
        panelRecords.setBackground(DefaultColor);
        panellogout.setBackground(DefaultColor);
    }//GEN-LAST:event_lblStock1MouseClicked

    private void lblrecordsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblrecordsMouseClicked
     this.setTitle("Record History");
        
             Records record = new Records();
        jDesktopPane.removeAll();
       jDesktopPane.add(record).setVisible(true);
        panelHome.show();
       
        panelHome.setBackground(DefaultColor);
        panelFarmer.setBackground(DefaultColor);
        panelStock.setBackground(DefaultColor);
        panelproduct.setBackground(DefaultColor);
        panelRelease.setBackground(DefaultColor);
        panelRecords.setBackground(ClickedColor);
        panellogout.setBackground(DefaultColor);
        

       
    }//GEN-LAST:event_lblrecordsMouseClicked

    private void lblHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseClicked
      this.setTitle("Jaen");
        jDesktopPane.removeAll();
        jDesktopPane.add(jPanel3).setVisible(true);
        jPanel3.setVisible(true);
         panelHome.show();
        
        panelHome.setBackground(ClickedColor);
        panelFarmer.setBackground(DefaultColor);
        panelStock.setBackground(DefaultColor);
        panelproduct.setBackground(DefaultColor);
        panelRelease.setBackground(DefaultColor);
        panelRecords.setBackground(DefaultColor);
        panellogout.setBackground(DefaultColor);
       
    }//GEN-LAST:event_lblHomeMouseClicked

    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked
        panelHome.setBackground(DefaultColor);
        panelFarmer.setBackground(DefaultColor);
        panelStock.setBackground(DefaultColor);
        panelproduct.setBackground(DefaultColor);
        panelRelease.setBackground(DefaultColor);
        panelRecords.setBackground(DefaultColor);
        panellogout.setBackground(ClickedColor);
        
        
     int con = JOptionPane.showConfirmDialog(this, "<html><b style=\"color:black; font-size:15px;\">Are you sure you want to logout?</b></html>","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,icon1);
     if(con == 0){
     Login log = new Login();
            log.setVisible(true);
           dispose();  
     }else{
          panellogout.setBackground(DefaultColor);
     }
    }//GEN-LAST:event_lblLogoutMouseClicked

    private void panelHomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelHomeMousePressed

        jDesktopPane.removeAll();
        jDesktopPane.add(jPanel3).setVisible(true);
        jPanel3.setVisible(true);
        
        
        panelHome.setBackground(ClickedColor);
        panelFarmer.setBackground(DefaultColor);
        panelStock.setBackground(DefaultColor);
        panelRelease.setBackground(DefaultColor);
        panelRecords.setBackground(DefaultColor);
        panellogout.setBackground(DefaultColor);
    }//GEN-LAST:event_panelHomeMousePressed

    private void panelHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelHomeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_panelHomeMouseClicked

    private void lblStock2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStock2MouseClicked
        product user= new product();
       jDesktopPane.removeAll();
       jDesktopPane.add(user).setVisible(true);
       
       
        panelHome.setBackground(DefaultColor);
        panelFarmer.setBackground(DefaultColor);
        panelStock.setBackground(DefaultColor);
        panelproduct.setBackground(ClickedColor);
        panelRelease.setBackground(DefaultColor);
        panelRecords.setBackground(DefaultColor);
        panellogout.setBackground(DefaultColor);
    }//GEN-LAST:event_lblStock2MouseClicked

  
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
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblFarmer;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblStock;
    private javax.swing.JLabel lblStock1;
    private javax.swing.JLabel lblStock2;
    private javax.swing.JLabel lblrecords;
    private javax.swing.JLabel lbltitle;
    private javax.swing.JPanel panelFarmer;
    private javax.swing.JPanel panelHome;
    private javax.swing.JPanel panelRecords;
    private javax.swing.JPanel panelRelease;
    private javax.swing.JPanel panelStock;
    private javax.swing.JPanel panellogout;
    private javax.swing.JPanel panelproduct;
    // End of variables declaration//GEN-END:variables

    private void setIconImage() {
       setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Jaenlogo.png")));
    }
}
