
import jaen.AgriSupply;
import jaen.Registration;
import java.awt.Desktop;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import java.text.*;
import java.awt.print.*;
import java.io.IOException;
import java.text.MessageFormat;
public class Records extends javax.swing.JInternalFrame {

      Connection con;
    PreparedStatement pst;
    ResultSet rst;
    
    public Records() {
        initComponents();
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = ( BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        showdata(" ", " ");
        showdata2(" ", " ");
        showdata3(" ", " ");
        Release();
        Header();
      
        
        Stocks();
        Profile();
       jPanel1.hide();
       Releasedpanel.hide();
       panelStockQuantity.hide();
      
        tblprofile();
        tblRelease();
        
        
       
 
     }
    public void Header(){
         
       
         tblprofile.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD, 20));
         
         tblStocks.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD, 20));
         tblRelease.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD, 20));
         tblDeliver.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD, 20));
        TableColumnModel model = tblprofile.getColumnModel();
        model.getColumn(0).setPreferredWidth(200);
        String query = ("SELECT * FROM stock_delivered ORDER by DeliveredID ASC");
        Supply(query);
     }
    public void tblRelease(){
        TableColumnModel model = tblRelease.getColumnModel();
         model.getColumn(0).setPreferredWidth(150);
         model.getColumn(1).setPreferredWidth(200);
         model.getColumn(2).setPreferredWidth(200);
         model.getColumn(3).setPreferredWidth(350);
         model.getColumn(4).setPreferredWidth(200);
         model.getColumn(5).setPreferredWidth(200);
         model.getColumn(6).setPreferredWidth(130);
         model.getColumn(7).setPreferredWidth(250);
        
    }
    
    public void tblprofile(){
         TableColumnModel model = tblprofile.getColumnModel();
         model.getColumn(0).setPreferredWidth(150);
         model.getColumn(1).setPreferredWidth(170);
         model.getColumn(2).setPreferredWidth(170);
         model.getColumn(3).setPreferredWidth(170);
         model.getColumn(4).setPreferredWidth(170);
         model.getColumn(5).setPreferredWidth(150);
         model.getColumn(6).setPreferredWidth(130);
         model.getColumn(7).setPreferredWidth(250);
         model.getColumn(8).setPreferredWidth(150);
         model.getColumn(9).setPreferredWidth(170);
         model.getColumn(10).setPreferredWidth(100);
         model.getColumn(11).setPreferredWidth(170);
         model.getColumn(12).setPreferredWidth(170);
         model.getColumn(13).setPreferredWidth(150);
         model.getColumn(14).setPreferredWidth(130);
         model.getColumn(15).setPreferredWidth(150);
         model.getColumn(16).setPreferredWidth(200);
         model.getColumn(17).setPreferredWidth(170);
         model.getColumn(18).setPreferredWidth(170);
         model.getColumn(19).setPreferredWidth(100);
         model.getColumn(20).setPreferredWidth(170);
         model.getColumn(21).setPreferredWidth(150);
         model.getColumn(22).setPreferredWidth(130);
         model.getColumn(23).setPreferredWidth(150);
         model.getColumn(24).setPreferredWidth(150);
         model.getColumn(25).setPreferredWidth(170);
         model.getColumn(26).setPreferredWidth(170);
         model.getColumn(27).setPreferredWidth(170);
         model.getColumn(28).setPreferredWidth(170);
         model.getColumn(29).setPreferredWidth(250);
         model.getColumn(30).setPreferredWidth(130);
         model.getColumn(31).setPreferredWidth(250);
         model.getColumn(32).setPreferredWidth(150);
         model.getColumn(33).setPreferredWidth(170);
         model.getColumn(34).setPreferredWidth(250);
         model.getColumn(35).setPreferredWidth(170);
         model.getColumn(36).setPreferredWidth(200);
         model.getColumn(37).setPreferredWidth(200);
         
      
    }
     private void Profile() {

        int c;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar", "root", "DANIEL05");
            pst = con.prepareStatement("select * from profile Order by FID DESC");

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
                    v2.add(rst.getString("Contact"));
                    v2.add(rst.getString("Date_of_Birth"));
                    v2.add(rst.getString("Age"));
                    v2.add(rst.getString("Place_of_Birth"));
                    v2.add(rst.getString("Civil_Status"));
                    v2.add(rst.getString("Sex"));
                    v2.add(rst.getString("Highest_Education"));
                    v2.add(rst.getString("Religion"));
                    v2.add(rst.getString("Religion_Specify"));
                    v2.add(rst.getString("PWD"));
                    v2.add(rst.getString("4Ps_Benificiary"));
                    v2.add(rst.getString("Members_of_Indigenous"));
                    v2.add(rst.getString("Indigen_Specify"));
                    v2.add(rst.getString("MoaFAC"));
                    v2.add(rst.getString("Mofac_Specify"));
                    v2.add(rst.getString("With_Goverment_ID"));
                    v2.add(rst.getString("GovermentID_Specify"));
                    v2.add(rst.getString("ID_Number"));
                    v2.add(rst.getString("House_Hold_Head"));
                    v2.add(rst.getString("If_no_Name_of_House_Hold_Head"));
                    v2.add(rst.getString("Relationship"));
                    v2.add(rst.getString("NO_House_Hold_Member"));
                    v2.add(rst.getString("No_Male"));
                    v2.add(rst.getString("No_Female"));
                    v2.add(rst.getString("Person_to_notify_in_case_of_emergency"));
                    v2.add(rst.getString("Contact_No"));
                    v2.add(rst.getString("Date_Register"));
                   
                }

                Df.addRow(v2);

            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void showdata(String date1, String date2){
        try{
            if(date1.equals(" ") ||  date2.equals(" ")){
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
    
    public void showdata2(String date1, String date2){
        try{
            if(date1.equals(" ") ||  date2.equals(" ")){
                pst = con.prepareStatement("SELECT * FROM stock_delivered");
            }
            else{
                 pst = con.prepareStatement("SELECT *FROM stock_delivered WHERE Date_Delivered BETWEEN ? AND ?");
                 pst.setString(1, date1);
                 pst.setString(2, date2);   
            
            }
            rst = pst.executeQuery();
             DefaultTableModel Df = (DefaultTableModel)tblDeliver.getModel();
             Object [] row;
             while(rst.next()){
                 row = new Object[8];
                 row[0] = rst.getInt(1);
                 row[1] = rst.getString(2);
                 row[2] = rst.getString(3);
                 row[3] = rst.getString(4);
                 row[4] = rst.getString(5);
                 row[5] = rst.getInt(6);
                 row[6] = rst.getString(7);  
                 row[7] = rst.getString(8);
                 
                 Df.addRow(row);
                 
             }
            

        }catch (Exception e){
            System.out.print(e.getMessage());
            
        }
    }
    
    public void showdata3(String date1, String date2){
        try{
            if(date1.equals(" ") ||  date2.equals(" ")){
                pst = con.prepareStatement("SELECT * FROM profile");
            }
            else{
                 pst = con.prepareStatement("SELECT *FROM profile WHERE Date_Register BETWEEN ? AND ?");
                 pst.setString(1, date1);
                 pst.setString(2, date2);   
            
            }
            rst = pst.executeQuery();
             DefaultTableModel Df = (DefaultTableModel)tblprofile.getModel();
             Object [] row;
             while(rst.next()){
                 tblprofile();
                 row = new Object[38];
                 row[0] = rst.getString(1);
                 row[1] = rst.getString(2);
                 row[2] = rst.getString(3);
                 row[3] = rst.getString(4);
                 row[4] = rst.getString(5);
                 row[5] = rst.getString(6);
                 row[6] = rst.getString(7);  
                 row[7] = rst.getString(8);
                 row[8] = rst.getString(9);
                 row[9] = rst.getString(10);
                 row[10] = rst.getInt(11);
                 row[11] = rst.getString(12);
                 row[12] = rst.getString(13);
                 row[13] = rst.getString(14);
                 row[14] = rst.getString(15);
                 row[15] = rst.getString(16);  
                 row[16] = rst.getString(17);
                 row[17] = rst.getString(18);
                 row[18] = rst.getString(19);
                 row[19] = rst.getString(20);
                 row[20] = rst.getString(21);
                 row[21] = rst.getString(22);
                 row[22] = rst.getString(23);
                 row[23] = rst.getString(24);  
                 row[24] = rst.getString(25);
                 row[25] = rst.getString(26);
                 row[26] = rst.getString(27);
                 row[27] = rst.getString(28);
                 row[28] = rst.getString(29);
                 row[29] = rst.getString(30);
                 row[30] = rst.getString(31);
                 row[31] = rst.getString(32);  
                 row[32] = rst.getInt(33);
                 row[33] = rst.getInt(34);
                 row[34] = rst.getInt(35);
                 row[35] = rst.getString(36);
                 row[36] = rst.getLong(37);
                 row[37] = rst.getString(38);

                 Df.addRow(row);
                 
             }
            

        }catch (Exception e){
            System.out.print(e.getMessage());
            
        }
    }
    
     private void Supply(String query) {

        int c;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar", "root", "DANIEL05");
            pst = con.prepareStatement("select * from stock_delivered Order by DeliveredID DESC");

            rst = pst.executeQuery();
            ResultSetMetaData rss = rst.getMetaData();
            c = rss.getColumnCount();

            DefaultTableModel Df = (DefaultTableModel) tblDeliver.getModel();

            Df.setRowCount(0);

            while (rst.next()) {

                Vector v2 = new Vector();

                for (int a = 1; a <= c; a++) {
                    v2.add(rst.getString("DeliveredID"));
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
            pst = con.prepareStatement("select Stock_ID,Type_of_Stock,Name,Description,Quantity from stock2");

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
                    v2.add(rst.getString("Description"));
                    v2.add(rst.getString("Quantity"));
                   

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
            pst = con.prepareStatement("select * from give ORDER BY Give_ID DESC");
            
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
    
   public void relaeseprint(){
       jTextArea1.setText(jTextArea1.getText()+"===========================================================================================================================\n");
       jTextArea1.setText(jTextArea1.getText()+" \t                                                     Released Records\n");
       jTextArea1.setText(jTextArea1.getText()+"===========================================================================================================================\n");
       DefaultTableModel model  = (DefaultTableModel)tblRelease.getModel();
       jTextArea1.setText(jTextArea1.getText()+"Give_ID"+"\t"+"Date"+"\t"+"Farmer_ID"+"\t"+"Farmer_Name"+"\t"+"\t"+"Type_of_Stock"+"\t"+"Stock_Name"+"\t"+"Quantity"+"\t"+"Name_of_Distributor"+"\n");
       for(int i = 0; i< tblRelease.getRowCount(); i++){
           String id = tblRelease.getValueAt(i, 0).toString();
           String date = tblRelease.getValueAt(i, 1).toString();
           String farmerid = tblRelease.getValueAt(i, 2).toString();
           String farmername= tblRelease.getValueAt(i, 3).toString();
           String stocktype = tblRelease.getValueAt(i, 4).toString();
           String stockname = tblRelease.getValueAt(i, 5).toString();
           String quantity = tblRelease.getValueAt(i, 6).toString();
           String carriername= tblRelease.getValueAt(i, 7).toString();
           jTextArea1.setText(jTextArea1.getText()+id+"\t"+date+"\t"+farmerid+"\t"+farmername+"\t"+stocktype
       +"\t"+stockname+"\t"+quantity+"\t"+carriername+"\n");
       }
       jTextArea1.setText(jTextArea1.getText()+"\n");
       jTextArea1.setText(jTextArea1.getText()+"===========================================================================================================================");
       
   }
    public void printdeliver(){
       DeliverSupply.setText(DeliverSupply.getText()+"====================================================================================================================================================================================\n");
       DeliverSupply.setText(DeliverSupply.getText()+" \t\t\t\t\t Supply Delivered\n");
       DeliverSupply.setText(DeliverSupply.getText()+"====================================================================================================================================================================================\n");
       DefaultTableModel model  = (DefaultTableModel)tblDeliver.getModel();
       DeliverSupply.setText(DeliverSupply.getText()+"DeliveredID"+"\t"+"Date_Delivered"+"\t"+"\t"+"Stock_ID"+"\t"+"\t"+"Type_of_Stock"+"\t"+"\t"+"Name"+"\t"+"Quantity_Delivered"+"\t"+"Type_of_the_Stock"+"\t"+"Name_of_Delivery_Man"+"\n");
       for(int i = 0; i< tblDeliver.getRowCount(); i++){
           String id = tblDeliver.getValueAt(i, 0).toString();
           String date = tblDeliver.getValueAt(i, 1).toString();
           String farmerid = tblDeliver.getValueAt(i, 2).toString();
           String farmername= tblDeliver.getValueAt(i, 3).toString();
           String stocktype = tblDeliver.getValueAt(i, 4).toString();
           String stockname = tblDeliver.getValueAt(i, 5).toString();
           String quantity = tblDeliver.getValueAt(i, 6).toString();
           String carriername= tblDeliver.getValueAt(i, 7).toString();
           DeliverSupply.setText(DeliverSupply.getText()+id+"\t"+date+"\t"+"\t"+farmerid+"\t"+farmername+"\t"+"\t"+stocktype
       +"\t"+stockname+"\t"+"\t"+quantity+"\t"+"\t"+carriername+"\n");
       }
       DeliverSupply.setText(DeliverSupply.getText()+"\n");
       DeliverSupply.setText(DeliverSupply.getText()+"===================================================================================================================================================================================");   
   }
    
    public void printStockQuantoty(){
       textStockQuantity.setText(textStockQuantity.getText()+"=============================================================================\n");
       textStockQuantity.setText(textStockQuantity.getText()+" \t                              Stock's \n");
       textStockQuantity.setText(textStockQuantity.getText()+"=============================================================================\n");
       DefaultTableModel model  = (DefaultTableModel)tblStocks.getModel();
       textStockQuantity.setText(textStockQuantity.getText()+"  Stock ID"+"\t"+"\t"+"Type of Stock"+"\t"+"Name"+"\t"+"Type_of_Stock"+"\t"+"Quantity"+"\n");
       for(int i = 0; i< tblStocks.getRowCount(); i++){
           String id = tblStocks.getValueAt(i, 0).toString();
           String date = tblStocks.getValueAt(i, 1).toString();
           String farmerid = tblStocks.getValueAt(i, 2).toString();
           String farmername= tblStocks.getValueAt(i, 3).toString();
           String stocktype = tblStocks.getValueAt(i, 4).toString();

           textStockQuantity.setText(textStockQuantity.getText()+"  "+id+"\t"+date+"\t"+farmerid+"\t"+farmername+"\t"+stocktype+
       "\n");
       }
       textStockQuantity.setText(textStockQuantity.getText()+"\n");
       textStockQuantity.setText(textStockQuantity.getText()+"=============================================================================");   
   }
    
     private void filter() {
        int c;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar", "root", "DANIEL05");
          
            if(combobaranggay.getSelectedItem().equals("Calabasa")){
                 pst = con.prepareStatement("select * from profile where barangay='Calabasa'");
            }
             if(combobaranggay.getSelectedItem().equals("Dampulan")){
                 pst = con.prepareStatement("select * from profile where barangay='Dampulan'");
            }
              if(combobaranggay.getSelectedItem().equals("Don Mariano Marcos")){
                 pst = con.prepareStatement("select * from profile where barangay='Don Mariano Marcos'");
            }
              if(combobaranggay.getSelectedItem().equals("Hilera")){
                 pst = con.prepareStatement("select * from profile where barangay='Hilera'");
            }
              if(combobaranggay.getSelectedItem().equals("Imbunia")){
                 pst = con.prepareStatement("select * from profile where barangay='Imbunia'");
            }
              if(combobaranggay.getSelectedItem().equals("Imelda de Poblacion")){
                 pst = con.prepareStatement("select * from profile where barangay='Imelda de Poblacion'");
            }
              if(combobaranggay.getSelectedItem().equals("lambakin")){
                 pst = con.prepareStatement("select * from profile where barangay='lambakin'");
            }
              if(combobaranggay.getSelectedItem().equals("Langla")){
                 pst = con.prepareStatement("select * from profile where barangay='Langla'");
            }if(combobaranggay.getSelectedItem().equals("Magsalisi")){
                 pst = con.prepareStatement("select * from profile where barangay='Magsalisi'");
            }if(combobaranggay.getSelectedItem().equals("Malabon-kaingin")){
                 pst = con.prepareStatement("select * from profile where barangay='Malabon-kaingin'");
            }if(combobaranggay.getSelectedItem().equals("Marawa")){
                 pst = con.prepareStatement("select * from profile where barangay='Marawa'");
            }if(combobaranggay.getSelectedItem().equals("Niyugan")){
                 pst = con.prepareStatement("select * from profile where barangay='Niyugan'");
            }if(combobaranggay.getSelectedItem().equals("Ocampo-Rivera")){
                 pst = con.prepareStatement("select * from profile where barangay='Ocampo-Rivera'");
            }if(combobaranggay.getSelectedItem().equals("Pakol")){
                 pst = con.prepareStatement("select * from profile where barangay='Pakol'");
            }if(combobaranggay.getSelectedItem().equals("Pamacpacan")){
                 pst = con.prepareStatement("select * from profile where barangay='Pamacpacan'");
            }if(combobaranggay.getSelectedItem().equals("Pinanggaan")){
                 pst = con.prepareStatement("select * from profile where barangay='Pinanggaan'");
            }if(combobaranggay.getSelectedItem().equals("Putlod")){
                 pst = con.prepareStatement("select * from profile where barangay='Putlod'");
            }if(combobaranggay.getSelectedItem().equals("San Jose")){
                 pst = con.prepareStatement("select * from profile where barangay='San Jose'");
            }if(combobaranggay.getSelectedItem().equals("San Josef Nabao")){
                 pst = con.prepareStatement("select * from profile where barangay='San Josef Nabao'");
            }if(combobaranggay.getSelectedItem().equals("San Pablo")){
                 pst = con.prepareStatement("select * from profile where barangay='San Pablo'");
            }if(combobaranggay.getSelectedItem().equals("San Roque")){
                 pst = con.prepareStatement("select * from profile where barangay='San Roque'");
            }if(combobaranggay.getSelectedItem().equals("San Vicente")){
                 pst = con.prepareStatement("select * from profile where barangay='San Vicente'");
            }if(combobaranggay.getSelectedItem().equals("Santa Ine")){
                 pst = con.prepareStatement("select * from profile where barangay='Santa Ine'");
            }if(combobaranggay.getSelectedItem().equals("Santo Tomas North")){
                 pst = con.prepareStatement("select * from profile where barangay='Santo Tomas North'");
            }if(combobaranggay.getSelectedItem().equals("Santo Tomas South")){
                 pst = con.prepareStatement("select * from profile where barangay='Santo Tomas South'");
            }if(combobaranggay.getSelectedItem().equals("Sapang")){
                 pst = con.prepareStatement("select * from profile where barangay='Sapang'");
            }if(combobaranggay.getSelectedItem().equals("Ulanin-Pitak")){
                 pst = con.prepareStatement("select * from profile where barangay='Ulanin-Pitak'");
            }
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
                    v2.add(rst.getString("Contact"));
                    v2.add(rst.getString("Date_of_Birth"));
                    v2.add(rst.getString("Age"));
                    v2.add(rst.getString("Place_of_Birth"));
                    v2.add(rst.getString("Civil_Status"));
                    v2.add(rst.getString("Sex"));
                    v2.add(rst.getString("Highest_Education"));
                    v2.add(rst.getString("Religion"));
                    v2.add(rst.getString("Religion_Specify"));
                    v2.add(rst.getString("PWD"));
                    v2.add(rst.getString("4Ps_Benificiary"));
                    v2.add(rst.getString("Members_of_Indigenous"));
                    v2.add(rst.getString("Indigen_Specify"));
                    v2.add(rst.getString("MoaFAC"));
                    v2.add(rst.getString("Mofac_Specify"));
                    v2.add(rst.getString("With_Goverment_ID"));
                    v2.add(rst.getString("GovermentID_Specify"));
                    v2.add(rst.getString("ID_Number"));
                    v2.add(rst.getString("House_Hold_Head"));
                    v2.add(rst.getString("If_no_Name_of_House_Hold_Head"));
                    v2.add(rst.getString("Relationship"));
                    v2.add(rst.getString("NO_House_Hold_Member"));
                    v2.add(rst.getString("No_Male"));
                    v2.add(rst.getString("No_Female"));
                    v2.add(rst.getString("Person_to_notify_in_case_of_emergency"));
                    v2.add(rst.getString("Contact_No"));
                    v2.add(rst.getString("Date_Register"));
                   
                }


                Df.addRow(v2);

            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        panelStockQuantity = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        textStockQuantity = new javax.swing.JTextArea();
        btnSupplCancel = new javax.swing.JButton();
        btnSupplyPrint = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblprofile = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnPrintprofile = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jDateChooser5 = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jDateChooser6 = new com.toedter.calendar.JDateChooser();
        jButton3 = new javax.swing.JButton();
        combobaranggay = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStocks = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        btnPrintStock = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDeliver = new javax.swing.JTable();
        btnPrintSupply = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
        txtDeliver = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblRelease = new javax.swing.JTable();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnPrintRelease = new javax.swing.JButton();
        txtRelease = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        Releasedpanel = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnReleasedPrint = new javax.swing.JButton();
        btnReleasedCancel = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        DeliverSupply = new javax.swing.JTextArea();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        bg.setPreferredSize(new java.awt.Dimension(1590, 840));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelStockQuantity.setBackground(new java.awt.Color(0, 153, 0));
        panelStockQuantity.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textStockQuantity.setColumns(20);
        textStockQuantity.setRows(5);
        jScrollPane8.setViewportView(textStockQuantity);

        panelStockQuantity.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 550, 590));

        btnSupplCancel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        btnSupplCancel.setText("Cancel");
        btnSupplCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupplCancelActionPerformed(evt);
            }
        });
        panelStockQuantity.add(btnSupplCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 650, 110, 40));

        btnSupplyPrint.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        btnSupplyPrint.setText("Print");
        btnSupplyPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupplyPrintActionPerformed(evt);
            }
        });
        panelStockQuantity.add(btnSupplyPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 650, 110, 40));

        bg.add(panelStockQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 20, 20));

        jTabbedPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI Semibold", 3, 24)); // NOI18N

        jScrollPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblprofile.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        tblprofile.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Farmer ID", "Last Name", "First Name", "Middle Name", "Extension Name", "House No", "Street", "Barangay", "Municipality", "Province", "Region", "Contact", "Date of Birth", "Age", "Place of Birth", "Civil Status", "Gender", "Highest Education", "Religion", "Religion Specify", "PWD", "4Ps Benificiary", "Members of Indigenous", "Indigen Specify", "MoaFAC", "Mofac Specify", "With Goverment_ID", "GovermentID Specify", "ID Number", "House Hold Head", "If no Name of House_Hold_Head", "Relationship", "NO_House Hold Member", "No Male", "No Female", "Person to notify incase of emergency", "Contact No", "Date Registered"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Long.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Long.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblprofile.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblprofile.setFocusable(false);
        tblprofile.setGridColor(new java.awt.Color(0, 153, 0));
        tblprofile.setInheritsPopupMenu(true);
        tblprofile.setRequestFocusEnabled(false);
        tblprofile.setRowHeight(30);
        tblprofile.setRowMargin(10);
        tblprofile.setRowSelectionAllowed(false);
        tblprofile.setSelectionBackground(new java.awt.Color(0, 255, 0));
        tblprofile.setShowHorizontalLines(true);
        tblprofile.setShowVerticalLines(true);
        tblprofile.getTableHeader().setResizingAllowed(false);
        tblprofile.getTableHeader().setReorderingAllowed(false);
        tblprofile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblprofileMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblprofile);

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel3.setText("Search Farmer ");

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        btnPrintprofile.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        btnPrintprofile.setText("Print");
        btnPrintprofile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintprofileActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel6.setText("From :");

        jDateChooser5.setDateFormatString("yyyy-MM-dd");
        jDateChooser5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel7.setText("To :");

        jDateChooser6.setDateFormatString("yyyy-MM-dd");
        jDateChooser6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N

        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        combobaranggay.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        combobaranggay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Calabasa", "Dampulan", "Don Mariano Marcos", "Hilera", "Imbunia", "Imelda de Poblacion", "lambakin", "Langla", "magsalisi", "Malabon-kaingin", "Marawa", "Niyugan", "Ocampo-Rivera", "Pakol", "Pamacpacan", "Pinanggaan", "Putlod", "San Jose", "San Josef Nabao", "San Pablo", "San Roque", "San Vicente", "Santa Ine", "Santo Tomas North", "Santo Tomas South", "Sapang", "Ulanin-Pitak" }));
        combobaranggay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobaranggayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnPrintprofile, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(combobaranggay, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooser5, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser6, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton3))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1431, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap(9, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combobaranggay, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jDateChooser5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jDateChooser6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(btnPrintprofile)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Farmer Profile", jPanel4);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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
                "Stock_ID", "Type of Stock", "Name", "Description", "Quantity"
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
        tblStocks.setGridColor(new java.awt.Color(0, 153, 0));
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

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 67, 1430, 570));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        jPanel5.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 20, 123, 41));

        btnPrintStock.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        btnPrintStock.setText("Print");
        btnPrintStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintStockActionPerformed(evt);
            }
        });
        jPanel5.add(btnPrintStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 110, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel8.setText("Search Stock");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1168, 20, 140, 40));

        jTabbedPane1.addTab("Stocks", jPanel5);

        jScrollPane3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblDeliver.setAutoCreateRowSorter(true);
        tblDeliver.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        tblDeliver.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Delivered ID", "Date Delivered", "Stock ID", "Type of Stock", "Name", "Quantity Delivered", "Description", "Carrier Name"
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
        tblDeliver.setGridColor(new java.awt.Color(0, 153, 0));
        tblDeliver.setRowHeight(30);
        tblDeliver.setSelectionBackground(new java.awt.Color(0, 255, 0));
        tblDeliver.setShowHorizontalLines(true);
        tblDeliver.setShowVerticalLines(true);
        jScrollPane3.setViewportView(tblDeliver);

        btnPrintSupply.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        btnPrintSupply.setText("Print");
        btnPrintSupply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintSupplyActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel4.setText("From :");

        jDateChooser3.setDateFormatString("yyyy-MM-dd");
        jDateChooser3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel5.setText("To :");

        jDateChooser4.setDateFormatString("yyyy-MM-dd");
        jDateChooser4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N

        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtDeliver.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        txtDeliver.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDeliverKeyReleased(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        jLabel11.setText("Search");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1432, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(9, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnPrintSupply, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDeliver, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(24, 24, 24))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnPrintSupply, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDeliver, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDateChooser4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Supply Deliver", jPanel3);

        jScrollPane4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblRelease.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        tblRelease.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Release ID", "Date Release", "Recipient ID", "Farmer Name", "Type of Stock", "Stock Name", "Quantity", "Name of Distributor"
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
        tblRelease.setGridColor(new java.awt.Color(0, 153, 0));
        tblRelease.setRowHeight(30);
        tblRelease.setSelectionBackground(new java.awt.Color(51, 204, 0));
        tblRelease.setShowHorizontalLines(true);
        tblRelease.setShowVerticalLines(true);
        jScrollPane4.setViewportView(tblRelease);

        jDateChooser1.setDateFormatString("yyyy-MM-dd");
        jDateChooser1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jDateChooser2.setDateFormatString("yyyy-MM-dd");
        jDateChooser2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel1.setText("To :");

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel2.setText("From :");

        btnPrintRelease.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        btnPrintRelease.setText("Print");
        btnPrintRelease.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintReleaseActionPerformed(evt);
            }
        });

        txtRelease.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtReleaseKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel9.setText("Search");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(btnPrintRelease, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtRelease, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1429, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtRelease, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnPrintRelease)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Release", jPanel6);

        bg.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 1490, 680));

        jPanel7.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 790, Short.MAX_VALUE)
        );

        bg.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 20, 790));

        jPanel8.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 790, Short.MAX_VALUE)
        );

        bg.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1540, 0, 50, 790));

        jPanel9.setBackground(new java.awt.Color(153, 153, 153));
        jPanel9.setPreferredSize(new java.awt.Dimension(0, 30));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        bg.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1592, -1));

        jPanel10.setBackground(new java.awt.Color(153, 153, 153));
        jPanel10.setPreferredSize(new java.awt.Dimension(0, 30));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1600, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        bg.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 770, 1600, 70));

        Releasedpanel.setBackground(new java.awt.Color(0, 153, 0));
        Releasedpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane7.setViewportView(jTextArea1);

        Releasedpanel.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 21, 880, 520));

        btnReleasedPrint.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        btnReleasedPrint.setText("Print");
        btnReleasedPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReleasedPrintActionPerformed(evt);
            }
        });
        Releasedpanel.add(btnReleasedPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 560, 110, 40));

        btnReleasedCancel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        btnReleasedCancel.setText("Cancel");
        btnReleasedCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReleasedCancelActionPerformed(evt);
            }
        });
        Releasedpanel.add(btnReleasedCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 560, -1, 40));

        bg.add(Releasedpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 21, 22));

        jPanel1.setBackground(new java.awt.Color(0, 153, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DeliverSupply.setColumns(20);
        DeliverSupply.setRows(5);
        jScrollPane5.setViewportView(DeliverSupply);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 1280, 536));

        jButton4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        jButton4.setText("Print");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 560, 100, 40));

        jButton5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        jButton5.setText("Cancel");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 560, -1, 40));

        bg.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 20, 20));

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

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
      jPanel1.hide();
      DeliverSupply.setText(null);
      jTabbedPane1.setSize(1493, 711);
      
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnReleasedCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReleasedCancelActionPerformed
        jTabbedPane1.show();
        Releasedpanel.hide();
        jTextArea1.setText(null);
        jTabbedPane1.setSize(1300, 500
        );
        jPanel1.hide();
        
        
    }//GEN-LAST:event_btnReleasedCancelActionPerformed

    private void btnSupplCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupplCancelActionPerformed
       jTabbedPane1.setSize(1493, 711);
        jTabbedPane1.show();
        panelStockQuantity.hide();
       textStockQuantity.setText(null);
    }//GEN-LAST:event_btnSupplCancelActionPerformed

    private void btnReleasedPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReleasedPrintActionPerformed
          try {
              jTextArea1.print();
              Releasedpanel.hide();
          } catch (PrinterException ex) {
              Logger.getLogger(Records.class.getName()).log(Level.SEVERE, null, ex);
          }
    }//GEN-LAST:event_btnReleasedPrintActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
          try {
              DeliverSupply.print();
              jPanel1.hide();
          } catch (PrinterException ex) {
              Logger.getLogger(Records.class.getName()).log(Level.SEVERE, null, ex);
          }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnSupplyPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupplyPrintActionPerformed
          try {
              textStockQuantity.print();
              panelStockQuantity.hide();
          } catch (PrinterException ex) {
              Logger.getLogger(Records.class.getName()).log(Level.SEVERE, null, ex);
          }
    }//GEN-LAST:event_btnSupplyPrintActionPerformed

    private void txtReleaseKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtReleaseKeyReleased
        try{
            String query;
            query = " SELECT * FROM give WHERE Give_ID = ?";
            pst=con.prepareStatement(query);
            pst.setString(1, txtRelease.getText().toLowerCase());
            rst = pst.executeQuery();

            DefaultTableModel Df = (DefaultTableModel)tblRelease.getModel();
            String search = txtRelease.getText();
            TableRowSorter< DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>(Df);
            tblRelease.setRowSorter(trs);
            trs.setRowFilter(RowFilter.regexFilter(search));
        }catch (Exception e){
        }
    }//GEN-LAST:event_txtReleaseKeyReleased

    private void btnPrintReleaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintReleaseActionPerformed
        Releasedpanel.show();
        Releasedpanel.setSize(940, 600);
        relaeseprint();
        jTabbedPane1.setSize(0, 0);

    }//GEN-LAST:event_btnPrintReleaseActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        tblRelease.setModel(new DefaultTableModel(null, new Object[]{"Release_ID","Date Release",
            "Recepient ID","Farmer_Name","Type of Stock","Stock Name","Quantity","Name of Distributor"}));
SimpleDateFormat dates = new SimpleDateFormat("yyyy-MM-dd");
String Date1  = dates.format(jDateChooser1.getDate());
String Date2  = dates.format(jDateChooser2.getDate());

showdata(Date1, Date2);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtDeliverKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDeliverKeyReleased
        // TODO add your handling code here:
        try{
            String query;
            query = " SELECT * FROM stock_delivered WHERE DeliveredID = ?";
            pst=con.prepareStatement(query);
            pst.setString(1, txtDeliver.getText().toLowerCase());
            rst = pst.executeQuery();

            DefaultTableModel Df = (DefaultTableModel)tblDeliver.getModel();
            String search = txtDeliver.getText();
            TableRowSorter< DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>(Df);
            tblDeliver.setRowSorter(trs);
            trs.setRowFilter(RowFilter.regexFilter(search));
        }catch (Exception e){
        }
    }//GEN-LAST:event_txtDeliverKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        tblDeliver.setModel(new DefaultTableModel(null, new Object[]{"Delivered ID","Date Delivered",
            "Stock ID","Type of Stock","Name","Quantity Delivered","Desciption","Carrier Name"}));
SimpleDateFormat dates = new SimpleDateFormat("yyyy-MM-dd");
String Date1  = dates.format(jDateChooser3.getDate());
String Date2  = dates.format(jDateChooser4.getDate());
showdata2(Date1, Date2);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnPrintSupplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintSupplyActionPerformed
        jPanel1.show();
        jPanel1.setSize(1320, 620);
        jTabbedPane1.setSize(0, 0);
        jTextArea1.setEditable(false);
        printdeliver();

    }//GEN-LAST:event_btnPrintSupplyActionPerformed

    private void btnPrintStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintStockActionPerformed
        printStockQuantoty();
        panelStockQuantity.show();
        jTabbedPane1.setSize(0, 0);
        panelStockQuantity.setSize(620, 700);

    }//GEN-LAST:event_btnPrintStockActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        try{
            String query =" SELECT * FROM stock WHERE Stock_ID = ?";
            pst=con.prepareStatement(query);
            pst.setString(1, jTextField1.getText().toLowerCase());
            rst = pst.executeQuery();

            DefaultTableModel Df = (DefaultTableModel)tblStocks.getModel();
            String search = jTextField1.getText();
            TableRowSorter< DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>(Df);
            tblStocks.setRowSorter(trs);
            trs.setRowFilter(RowFilter.regexFilter(search));

        }catch (Exception e){

        }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void tblStocksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStocksMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblStocksMouseClicked

    private void combobaranggayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobaranggayActionPerformed
        filter();
    }//GEN-LAST:event_combobaranggayActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        tblprofile.setModel(new DefaultTableModel(null, new Object[]{"Farmer ID","Last name",
            "First name","Middle name","Extension name","House Number","Street","Baranggay",
            "Municipality","Province","Region","Contact","Date of Birth","Age","Place of Birth","Civil Status",
            "Gender","Highest Education","Religion","Religion Specify","PWD","4Ps Benificiary",
            "Members of Indigenous","Indigen Specify","MoaFAC","Mofac Specify","With Goverment ID",
            "GovermentID Specify","ID Number","House Hold Head","If no Name of House Hold Head",
            "Relationship","NO House Hold Member","No Male","No Female","Person to notify in case of emergency",
            "Contact_No","Date_Register"}));

SimpleDateFormat dates = new SimpleDateFormat("yyyy-MM-dd");
String Date1  = dates.format(jDateChooser5.getDate());
String Date2  = dates.format(jDateChooser6.getDate());
showdata3(Date1, Date2);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnPrintprofileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintprofileActionPerformed
        // TODO add your handling code here:
        MessageFormat header = new MessageFormat("Report Print");
        MessageFormat footer = new MessageFormat("Page{0, number,integer}");
        try{
            tblprofile.print(JTable.PrintMode.FIT_WIDTH, header,footer);

        }catch(Exception e){

        }

    }//GEN-LAST:event_btnPrintprofileActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        try{
            int c;
            String query;
            query = " SELECT * FROM profile WHERE FID = ?";
            pst=con.prepareStatement(query);
            pst.setString(1, txtSearch.getText().toLowerCase());
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
                    v2.add(rst.getString("Contact"));
                    v2.add(rst.getString("Date_of_Birth"));
                    v2.add(rst.getString("Age"));
                    v2.add(rst.getString("Place_of_Birth"));
                    v2.add(rst.getString("Civil_Status"));
                    v2.add(rst.getString("Sex"));
                    v2.add(rst.getString("Highest_Education"));
                    v2.add(rst.getString("Religion"));
                    v2.add(rst.getString("Religion_Specify"));
                    v2.add(rst.getString("PWD"));
                    v2.add(rst.getString("4Ps_Benificiary"));
                    v2.add(rst.getString("Members_of_Indigenous"));
                    v2.add(rst.getString("Indigen_Specify"));
                    v2.add(rst.getString("MoaFAC"));
                    v2.add(rst.getString("Mofac_Specify"));
                    v2.add(rst.getString("With_Goverment_ID"));
                    v2.add(rst.getString("GovermentID_Specify"));
                    v2.add(rst.getString("ID_Number"));
                    v2.add(rst.getString("House_Hold_Head"));
                    v2.add(rst.getString("If_no_Name_of_House_Hold_Head"));
                    v2.add(rst.getString("Relationship"));
                    v2.add(rst.getString("NO_House_Hold_Member"));
                    v2.add(rst.getString("No_Male"));
                    v2.add(rst.getString("No_Female"));
                    v2.add(rst.getString("Person_to_notify_in_case_of_emergency"));
                    v2.add(rst.getString("Contact_No"));
                    v2.add(rst.getString("Date_Register"));

                }

                Df.addRow(v2);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Records.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void tblprofileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblprofileMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblprofileMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea DeliverSupply;
    private javax.swing.JPanel Releasedpanel;
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnPrintRelease;
    private javax.swing.JButton btnPrintStock;
    private javax.swing.JButton btnPrintSupply;
    private javax.swing.JButton btnPrintprofile;
    private javax.swing.JButton btnReleasedCancel;
    private javax.swing.JButton btnReleasedPrint;
    private javax.swing.JButton btnSupplCancel;
    private javax.swing.JButton btnSupplyPrint;
    private javax.swing.JComboBox<String> combobaranggay;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private com.toedter.calendar.JDateChooser jDateChooser5;
    private com.toedter.calendar.JDateChooser jDateChooser6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel panelStockQuantity;
    private javax.swing.JTable tblDeliver;
    private javax.swing.JTable tblRelease;
    private javax.swing.JTable tblStocks;
    private javax.swing.JTable tblprofile;
    private javax.swing.JTextArea textStockQuantity;
    private javax.swing.JTextField txtDeliver;
    private javax.swing.JTextField txtRelease;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
