
import jaen.AgriSupply;
import jaen.Registration;
import java.awt.Color;
import java.awt.Font;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
public class Farmer extends javax.swing.JInternalFrame {

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
String gender;
String specify;
    Connection con1;
    PreparedStatement insert;
    ResultSet rst;
    Statement state;
     ImageIcon icon1 = new ImageIcon("error.png");
     ImageIcon icon2 = new ImageIcon("success.png");
     ImageIcon icon3 = new ImageIcon("question.png");
    public Farmer() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = ( BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        Totalfarmer();
        autoid();
        placeholder(txtSearch);
        txtSearch.setText("Enter Farmer ID");
        jPanel10.hide();
        btnAddSave.hide();
        btnEditSave.hide();
        btnDeleteSave.hide();
        bg();
        jButton3.hide();
        editfalse();     
    }
    
   public void bg(){    
       Icon i = jButton4.getIcon();
       ImageIcon icon = (ImageIcon)i;
       Image image = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
       jButton4.setIcon(new ImageIcon(image));   
   }
 
    public void editfalse(){  
        txtID.setEditable(false);
        txtSName.setEditable(false);
        txtFName.setEditable(false);
        txtMName.setEditable(false);
        txtEName.setEditable(false);
        txtPurok.setEditable(false);
        txtStreet.setEditable(false);
        combobrgy.setEnabled(false);
        txtContact.setEditable(false);
        txtPlace.setEditable(false);
        
        txtage.setEditable(false);
        jComboCivil.setEnabled(false);
        Male.setEnabled(false);
        Female.setEnabled(false);
        jCheckChristian.setEnabled(false);       
        jCheckIslam.setEnabled(false);
        jCheckOthers.setEnabled(false);
        txtreligionSpecify.setEditable(false);
        
        jComboEduc.setEnabled(false);
        jCheck4PsYes.setEnabled(false);
        jCheck4PsNo.setEnabled(false);
        jCheckPWDYes.setEnabled(false);
        jCheckPWDNo.setEnabled(false);
        jCheckIndigenousYes.setEnabled(false);
        jCheckIndigenousNo.setEnabled(false);
        txtIndigenousSpecify.setEditable(false);
        jCheckAssociationYes.setEnabled(false);
        jCheckAssociationNo.setEnabled(false);
        txtAssociationSpecify.setEditable(false);
        jCheckGovYes.setEnabled(false);
        jCheckGovNo.setEnabled(false);
        txtIDtype.setEditable(false);
        txtIDNumbber.setEditable(false);
        jCheckHouseYes.setEnabled(false);
        jCheckHouseNo.setEnabled(false);
        txtIfnoHouse.setEditable(false);       
        txtRelationship.setEditable(false);
        txtNoofLiving.setEditable(false);
        txtMale.setEditable(false);
        txtFemale.setEditable(false);
        txtEmergency.setEditable(false);
        txtContactNo.setEditable(false);
        txtPath1.setEditable(false);
        txtPath2.setEditable(false);
        txtPath3.setEditable(false);
        txtPath4.setEditable(false);
        btnupload2x2.setEnabled(false);
        btnUploadvalidID.setEnabled(false);
        btnLandTitle.setEnabled(false);
        btnbrgy.setEnabled(false);
}
     public void edittrrue(){
        txtSName.setEditable(true);
        txtFName.setEditable(true);
        txtMName.setEditable(true);
        txtEName.setEditable(true);
        txtPurok.setEditable(true);
        txtStreet.setEditable(true);
        combobrgy.setEnabled(true);
        txtContact.setEditable(true);
        txtPlace.setEditable(true);
        
        txtage.setEditable(true);
        jComboCivil.setEnabled(true);
        Male.setEnabled(true);
        Female.setEnabled(true);
        jCheckChristian.setEnabled(true);       
        jCheckIslam.setEnabled(true);
        jCheckOthers.setEnabled(true);
        txtreligionSpecify.setEditable(true);
        
        jComboEduc.setEnabled(true);
        jCheck4PsYes.setEnabled(true);
        jCheck4PsNo.setEnabled(true);
        jCheckPWDYes.setEnabled(true);
        jCheckPWDNo.setEnabled(true);
        jCheckIndigenousYes.setEnabled(true);
        jCheckIndigenousNo.setEnabled(true);
        txtIndigenousSpecify.setEditable(true);
        jCheckAssociationYes.setEnabled(true);
        jCheckAssociationNo.setEnabled(true);
        txtAssociationSpecify.setEditable(true);
        jCheckGovYes.setEnabled(true);
        jCheckGovNo.setEnabled(true);
        txtIDtype.setEditable(true);
        txtIDNumbber.setEditable(true);
        jCheckHouseYes.setEnabled(true);
        jCheckHouseNo.setEnabled(true);
        txtIfnoHouse.setEditable(true);       
        txtRelationship.setEditable(true);
        txtNoofLiving.setEditable(true);
        txtMale.setEditable(true);
        txtFemale.setEditable(true);
        txtEmergency.setEditable(true);
        txtContactNo.setEditable(true);
        btnupload2x2.setEnabled(true);
        btnUploadvalidID.setEnabled(true);
        btnLandTitle.setEnabled(true);
        btnbrgy.setEnabled(true);       
}
    
      public void placeholder(JTextField txtSearch){
        Font font =txtSearch.getFont();
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
      public void Totalfarmer(){  
          try{
                Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
           String sql = "SELECT count(*) from profile;";
           insert = con1.prepareStatement(sql);
           rst = insert.executeQuery();
           if(rst.next()){
               int count = rst.getInt(1);
               jLabel1.setText(String.valueOf(count));  
           }      
          }catch(SQLException e){
              
          } catch (ClassNotFoundException ex) {
        Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
    }    
      }
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
 
    public void addfarmer(){
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
         
        
        
                        Date date = new Date();
                        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
                        String currentdate = dateformat.format(date);
                        lblDate.setText(currentdate);
               SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd");
               // String dates = format.format(jDateChooser1.getDate());
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
                String age = txtage.getText();
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
                String place = txtPlace.getText();
                String civil = jComboCivil.getSelectedItem().toString();
                String livelihood = null;
                String farmingtype = null;
                
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
                if(Male.isSelected()){
                gender="Male";
                }
                else if(Female.isSelected()){
                  gender="Female";
                }
                //for main livelihood
                if(jCheckFarmer.isSelected()){
                    livelihood = "Farmer";
                }
                else if(jCheckFarmLabor1.isSelected()){
                    livelihood = "FarmWorker/laborer";
                }
                else if(jCheckFish1.isSelected()){
                    livelihood = "FisherFolk";
                }
                else if(jCheckAgri1.isSelected()){
                    livelihood = "Agri Youth";
                }
                //for main farming type
                if(jCheckRice1.isSelected()){
                    farmingtype = "Rice";
                }
                else if(jCheckCorn1.isSelected()){
                    farmingtype = "Corn";
                }
                else if(jCheckFarmOthers1.isSelected()){
                    farmingtype = "Others Crops";
                    specify = txtOtherSpecify1.getText();
                }
                else if(jCheckLive1.isSelected()){
                    farmingtype = "LiveStock";
                    specify = txtLiveSpecify1.getText();
                }
                else if(jCheckPoultry1.isSelected()){
                    farmingtype = "Poultry";
                    specify = txtPoultrySpecify1.getText();
                }
                else if(jCheckLand1.isSelected()){
                    farmingtype = "LandPreparation";
                }
                else if(jCheckPlanting1.isSelected()){
                    farmingtype = "Planting/TransPlanting";
                }
                else if(jCheckCultivation1.isSelected()){
                    farmingtype = "Cultivation";
                }
                else if(jCheckHarvest1.isSelected()){
                    farmingtype = "Harvesting";
                }
                else if(jCheckFarmworkerHarvest1.isSelected()){
                    farmingtype = "Others";
                }
                else if(jCheckAqua2.isSelected()){
                    farmingtype = "AquaCulture";
                }
                else if(jCheckFishVending1.isSelected()){
                    farmingtype = "Fish Vending";
                }
                else if(jCheckFishProcess1.isSelected()){
                    farmingtype = "Fish Processing";
                }
                else if(jCheckFishOthers1.isSelected()){
                    farmingtype = "Others";
                }
                else if(jCheckGleaning1.isSelected()){
                    farmingtype = "Gleaning";
                }
                else if(jCheckFishCapture2.isSelected()){
                    farmingtype = "Fish Capture";
                }
                else if(jCheckPart1.isSelected()){
                    farmingtype = "part of a farming household";
                }
                 else if(jCheckFormal1.isSelected()){
                    farmingtype = "attending/attended formal agri/fishery related course";
                }
                 else if(jCheckNonFromal1.isSelected()){
                    farmingtype = "attending/attended non/formal agri/fishery related course";
                }
                 else if(jCheckBox44.isSelected()){
                    farmingtype = "Others";
                }
                try {
             
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
                    insert = con1.prepareStatement("insert into profile(FID,LName,FName,MName,EName,House_No,Street,Barangay,Municipality,"
                        + "Province,Region,Contact,Date_of_Birth,Age,Place_of_Birth,Civil_Status,Sex,Highest_Education,Religion,Religion_Specify,"
                        + "PWD,4Ps_Benificiary,Members_of_Indigenous,Indigen_Specify,MoaFAC,Mofac_Specify,With_Goverment_ID,GovermentID_Specify,"
                        + "ID_Number,House_Hold_Head,If_no_Name_of_House_Hold_Head,Relationship,NO_House_Hold_Member,No_Male,No_Female,"
                        + "Person_to_notify_in_case_of_emergency,Contact_No,livelihood,Farmingtype,Date_Register"
                        +") values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

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
                    String datePersonal = comboday.getSelectedItem().toString();
		    if(datePersonal.length() <= 1) {
		    datePersonal = "0" + datePersonal;
				  				}
		    String monthPersonal = Integer.toString(combomonth.getSelectedIndex()+1);
		    if(monthPersonal.length()>= 1) {
		    monthPersonal = "0" + monthPersonal ;
				  				}
		    String yearPersonal = comboyear.getSelectedItem().toString();
		    String birthday = yearPersonal + "/" + datePersonal + "/" + monthPersonal;
		    insert.setString(13,  birthday);
                    insert.setString(14, age);
                    insert.setString(15, place);
                    insert.setString(16, civil);
                    insert.setString(17, gender);
                    insert.setString(18, educ);
                    insert.setString(19, religion);
                    insert.setString(20, reg);
                    insert.setString(21, pwd);
                    insert.setString(22, four);
                    insert.setString(23, indigenous);
                    insert.setString(24, indi);
                    insert.setString(25, farmersAssociation );
                    insert.setString(26, Association );
                    insert.setString(27, GovermentID );
                    insert.setString(28, IDType );
                    insert.setString(29, IDNumber );
                    insert.setString(30, house );
                    insert.setString(31, If );
                    insert.setString(32, relation );
                    insert.setString(33, member );
                    insert.setString(34, male);
                    insert.setString(35, female );
                    insert.setString(36, emergency );
                    insert.setString(37, emergencycontact );
                    insert.setString(38, livelihood );
                    insert.setString(39, farmingtype );
                    insert.setString(40, currentdate );
                    insert.executeUpdate();
                    
                    JOptionPane.showMessageDialog(this,"<html><b style=\"color:black; font-size:15px;\">Registered Successfuly!</b></html>","Success",JOptionPane.INFORMATION_MESSAGE,icon2);
                    Totalfarmer();
                    autoid();
                    
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
                }catch (Exception e){       
                }
    }       catch (FileNotFoundException ex) {
                Logger.getLogger(Farmer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Farmer.class.getName()).log(Level.SEVERE, null, ex);
            }
           }
    }
    public void adddate(){
          try {
                        Date date = new Date();
                        SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
                        String currentdate = dateformat.format(date);
                        lblDate.setText(currentdate);

                        Class.forName("com.mysql.cj.jdbc.Driver");
                        con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
                        insert = con1.prepareStatement("insert into register_date(Farmer_ID,Date_Register) values (?,?)");
                        insert.setString(1, txtID.getText());
                        insert.setString(2, currentdate);
                        insert.executeUpdate();
                        txtID.requestFocus();
                    } catch(Exception e){

                    }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gendergroup = new javax.swing.ButtonGroup();
        religiongroup = new javax.swing.ButtonGroup();
        fourpsgroup = new javax.swing.ButtonGroup();
        pwdgroup = new javax.swing.ButtonGroup();
        indigengroup = new javax.swing.ButtonGroup();
        mofacgroup = new javax.swing.ButtonGroup();
        govermentgroup = new javax.swing.ButtonGroup();
        housegroup = new javax.swing.ButtonGroup();
        buttongrouplivelihood = new javax.swing.ButtonGroup();
        buttonGroupfarmer = new javax.swing.ButtonGroup();
        bg = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtprint = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
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
        lblCivil = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtage = new javax.swing.JTextField();
        lblReligion = new javax.swing.JLabel();
        jCheckChristian = new javax.swing.JCheckBox();
        jCheckIslam = new javax.swing.JCheckBox();
        jCheckOthers = new javax.swing.JCheckBox();
        txtreligionSpecify = new javax.swing.JTextField();
        Male = new javax.swing.JRadioButton();
        Female = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jComboCivil = new javax.swing.JComboBox<>();
        lblContact1 = new javax.swing.JLabel();
        combomonth = new javax.swing.JComboBox<>();
        comboday = new javax.swing.JComboBox<>();
        comboyear = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnNextPart2 = new javax.swing.JButton();
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
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        lblFarmerAssociation1 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        btnNextPart3 = new javax.swing.JButton();
        btnbackPart1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblmain3 = new javax.swing.JLabel();
        lblName44 = new javax.swing.JLabel();
        lblName43 = new javax.swing.JLabel();
        jCheckRice1 = new javax.swing.JCheckBox();
        jCheckCorn1 = new javax.swing.JCheckBox();
        jCheckFarmOthers1 = new javax.swing.JCheckBox();
        lblName45 = new javax.swing.JLabel();
        txtOtherSpecify1 = new javax.swing.JTextField();
        jCheckFarmer = new javax.swing.JCheckBox();
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
        jCheckBox44 = new javax.swing.JCheckBox();
        jTextAgriSpecify1 = new javax.swing.JTextField();
        lblName52 = new javax.swing.JLabel();
        SeperatorFisher = new javax.swing.JSeparator();
        SeperetorAgri = new javax.swing.JSeparator();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        lblName53 = new javax.swing.JLabel();
        btnNextPart4 = new javax.swing.JButton();
        btnbackPart2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        lblImage1 = new javax.swing.JLabel();
        txtPath1 = new javax.swing.JTextField();
        lblImage2 = new javax.swing.JLabel();
        txtPath2 = new javax.swing.JTextField();
        lblImage3 = new javax.swing.JLabel();
        txtPath3 = new javax.swing.JTextField();
        lblImage4 = new javax.swing.JLabel();
        txtPath4 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        btnUploadvalidID = new javax.swing.JButton();
        btnbrgy = new javax.swing.JButton();
        btnupload2x2 = new javax.swing.JButton();
        btnLandTitle = new javax.swing.JButton();
        btnbackPart3 = new javax.swing.JButton();
        btnAddSave = new javax.swing.JButton();
        btnEditSave = new javax.swing.JButton();
        btnDeleteSave = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        btnEdit = new javax.swing.JButton();
        btnUpdate1 = new javax.swing.JButton();
        btnAdd1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1570, 820));

        bg.setPreferredSize(new java.awt.Dimension(1570, 820));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(204, 204, 204));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtprint.setColumns(20);
        txtprint.setRows(5);
        jScrollPane1.setViewportView(txtprint);

        jPanel10.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 410, 330));

        jButton2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 120, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("X");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel10.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 20, 20));

        bg.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 450, 430));

        jTabbedPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel4.setOpaque(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFID.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblFID.setText("Farmer ID");
        jPanel4.add(lblFID, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 190, 50));

        txtFName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtFName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel4.add(txtFName, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, 220, 50));

        lblFName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblFName.setText("Firstname");
        jPanel4.add(lblFName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 190, 50));

        txtMName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtMName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel4.add(txtMName, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 380, 220, 50));

        lblMName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblMName.setText("Middlename");
        jPanel4.add(lblMName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 190, 50));

        txtEName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtEName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel4.add(txtEName, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 470, 220, 50));

        lblEName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblEName.setText("Extension Name");
        jPanel4.add(lblEName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 190, 50));

        txtSName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtSName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSNameKeyTyped(evt);
            }
        });
        jPanel4.add(txtSName, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 220, 50));

        lblSName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblSName.setText("Surname");
        jPanel4.add(lblSName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 190, 50));

        txtID.setEditable(false);
        txtID.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel4.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 220, 50));

        lblAddress.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblAddress.setText("Address :");
        jPanel4.add(lblAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, 120, 40));

        txtPurok.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtPurok.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPurok.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPurokKeyTyped(evt);
            }
        });
        jPanel4.add(txtPurok, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 140, 240, 50));

        lblPurok.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblPurok.setText("House Number");
        jPanel4.add(lblPurok, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 140, 200, 50));

        txtStreet.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtStreet.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel4.add(txtStreet, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 230, 240, 50));

        lblStreet.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblStreet.setText("Purok");
        jPanel4.add(lblStreet, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, 190, 50));

        lblBarangay.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblBarangay.setText("Barangay");
        jPanel4.add(lblBarangay, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 300, 200, 60));

        txtMunicipality.setEditable(false);
        txtMunicipality.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtMunicipality.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMunicipality.setText("Jaen");
        jPanel4.add(txtMunicipality, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 390, 240, 50));

        lblMunicipality.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblMunicipality.setText("Municipality");
        jPanel4.add(lblMunicipality, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 390, 190, 50));

        txtprovince.setEditable(false);
        txtprovince.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtprovince.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtprovince.setText("Nueva Ecija");
        jPanel4.add(txtprovince, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 470, 240, 50));

        lblProvince.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblProvince.setText("Province");
        jPanel4.add(lblProvince, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 470, 190, 50));

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
        jPanel4.add(combobrgy, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 310, 240, 50));

        lblContact.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblContact.setText("Civil Status");
        jPanel4.add(lblContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 380, 140, 50));

        txtContact.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        txtContact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContactKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContactKeyTyped(evt);
            }
        });
        jPanel4.add(txtContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 110, 210, 50));

        lblDate.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblDate.setText("Date of Birth");
        jPanel4.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 260, 160, 50));

        lblPlace.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblPlace.setText("Place of Birth");
        jPanel4.add(lblPlace, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 180, 160, 50));

        txtPlace.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jPanel4.add(txtPlace, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 180, 210, 50));

        lblSex.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblSex.setText("Gender");
        jPanel4.add(lblSex, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 70, 140, 40));

        lblCivil.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblCivil.setText("Civil Status");
        jPanel4.add(lblCivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(1580, 260, 150, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setText("Age");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 320, 150, 50));
        jPanel4.add(txtage, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 320, 210, 50));

        lblReligion.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblReligion.setText("Religion :");
        jPanel4.add(lblReligion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 430, 170, 50));

        religiongroup.add(jCheckChristian);
        jCheckChristian.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jCheckChristian.setText("Christianity");
        jCheckChristian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckChristianActionPerformed(evt);
            }
        });
        jPanel4.add(jCheckChristian, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 440, -1, 40));

        religiongroup.add(jCheckIslam);
        jCheckIslam.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jCheckIslam.setText("Islam");
        jCheckIslam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckIslamActionPerformed(evt);
            }
        });
        jPanel4.add(jCheckIslam, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 440, 90, 40));

        religiongroup.add(jCheckOthers);
        jCheckOthers.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jCheckOthers.setText("Others");
        jCheckOthers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckOthersActionPerformed(evt);
            }
        });
        jPanel4.add(jCheckOthers, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 490, -1, 40));

        txtreligionSpecify.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jPanel4.add(txtreligionSpecify, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 490, 130, 40));

        gendergroup.add(Male);
        Male.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        Male.setText("Male");
        Male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaleActionPerformed(evt);
            }
        });
        jPanel4.add(Male, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 70, -1, 40));

        gendergroup.add(Female);
        Female.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        Female.setText("Female");
        Female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FemaleActionPerformed(evt);
            }
        });
        jPanel4.add(Female, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 70, -1, 40));

        jSeparator1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel4.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, 480, 490));

        jSeparator2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel4.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 60, 420, 490));

        jSeparator3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel4.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 470, 490));

        jComboCivil.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jComboCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single", "Married", "Windowed", "Separated" }));
        jComboCivil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboCivilActionPerformed(evt);
            }
        });
        jPanel4.add(jComboCivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 380, 210, 50));

        lblContact1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblContact1.setText("Contact");
        jPanel4.add(lblContact1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 110, 120, 50));

        combomonth.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        combomonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec", " " }));
        combomonth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combomonthItemStateChanged(evt);
            }
        });
        jPanel4.add(combomonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 260, 70, 40));

        comboday.setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N
        comboday.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        comboday.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combodayItemStateChanged(evt);
            }
        });
        jPanel4.add(comboday, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 260, 60, 40));

        comboyear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", " " }));
        comboyear.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboyearItemStateChanged(evt);
            }
        });
        comboyear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboyearActionPerformed(evt);
            }
        });
        jPanel4.add(comboyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 260, 80, 40));

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Day");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 240, 60, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Year");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 240, 80, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Month");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 240, 70, -1));

        btnNextPart2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        btnNextPart2.setText("Next");
        btnNextPart2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextPart2ActionPerformed(evt);
            }
        });
        jPanel4.add(btnNextPart2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 570, -1, 40));

        jTabbedPane1.addTab("Part 1", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 51, 51));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel5.setOpaque(false);
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboEduc.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jComboEduc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pre-School", "Elementary", "High School (Non K-12)", "Junior High School (K-12)", "Sinior High School (K-12)", "College", "Vocational", "Post-Graduate", "None" }));
        jPanel5.add(jComboEduc, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 290, 50));

        lblPWD.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblPWD.setText("Person With Disability");
        jPanel5.add(lblPWD, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 260, -1));

        lblEduc.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblEduc.setText("Highest Formal education");
        jPanel5.add(lblEduc, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 300, 50));

        pwdgroup.add(jCheckPWDNo);
        jCheckPWDNo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckPWDNo.setText("NO");
        jPanel5.add(jCheckPWDNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, -1, 40));

        pwdgroup.add(jCheckPWDYes);
        jCheckPWDYes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckPWDYes.setText("YES");
        jPanel5.add(jCheckPWDYes, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, -1, 40));

        lbl4Ps.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl4Ps.setText("4P's Beneficiary?");
        jPanel5.add(lbl4Ps, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 200, 40));

        fourpsgroup.add(jCheck4PsYes);
        jCheck4PsYes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheck4PsYes.setText("YES");
        jPanel5.add(jCheck4PsYes, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, -1, 40));

        indigengroup.add(jCheckIndigenousNo);
        jCheckIndigenousNo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckIndigenousNo.setText("NO");
        jCheckIndigenousNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckIndigenousNoActionPerformed(evt);
            }
        });
        jPanel5.add(jCheckIndigenousNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, -1, 40));

        lblName10.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblName10.setText("If Yes Specify");
        jPanel5.add(lblName10, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, -1, 40));

        indigengroup.add(jCheckIndigenousYes);
        jCheckIndigenousYes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckIndigenousYes.setText("YES");
        jCheckIndigenousYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckIndigenousYesActionPerformed(evt);
            }
        });
        jPanel5.add(jCheckIndigenousYes, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, 40));

        fourpsgroup.add(jCheck4PsNo);
        jCheck4PsNo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheck4PsNo.setText("NO");
        jPanel5.add(jCheck4PsNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, -1, 40));

        lblIndigenous.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblIndigenous.setText("Members of Indigenous Group");
        jPanel5.add(lblIndigenous, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 360, -1));

        txtAssociationSpecify.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jPanel5.add(txtAssociationSpecify, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 260, 50));

        lblHouseHold.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblHouseHold.setText("House Hold Head");
        jPanel5.add(lblHouseHold, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, 210, 50));

        housegroup.add(jCheckHouseYes);
        jCheckHouseYes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckHouseYes.setText("YES");
        jCheckHouseYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckHouseYesActionPerformed(evt);
            }
        });
        jPanel5.add(jCheckHouseYes, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 260, -1, 40));

        housegroup.add(jCheckHouseNo);
        jCheckHouseNo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckHouseNo.setText("NO");
        jCheckHouseNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckHouseNoActionPerformed(evt);
            }
        });
        jPanel5.add(jCheckHouseNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 260, -1, 40));

        lblIfnoHouse.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblIfnoHouse.setText("If no, Name house Hold Head :");
        jPanel5.add(lblIfnoHouse, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 310, -1, 40));

        lblRelatioship.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblRelatioship.setText("Relationship :");
        jPanel5.add(lblRelatioship, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 430, 190, 50));

        lblNoofLiving.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblNoofLiving.setText("No Household Members :");
        jPanel5.add(lblNoofLiving, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 70, 330, 40));

        lblMale.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblMale.setText("No. of Male :");
        jPanel5.add(lblMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 140, 160, 50));

        lblFemale.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblFemale.setText("No. of Female :");
        jPanel5.add(lblFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 210, 190, 50));

        txtIfnoHouse.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jPanel5.add(txtIfnoHouse, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 360, 430, 50));

        txtRelationship.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jPanel5.add(txtRelationship, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 430, 230, 50));

        txtMale.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        txtMale.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMaleKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMaleKeyTyped(evt);
            }
        });
        jPanel5.add(txtMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 140, 100, 50));

        txtFemale.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        txtFemale.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFemaleKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFemaleKeyTyped(evt);
            }
        });
        jPanel5.add(txtFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 210, 100, 50));

        txtNoofLiving.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        txtNoofLiving.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNoofLivingKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNoofLivingKeyTyped(evt);
            }
        });
        jPanel5.add(txtNoofLiving, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 70, 100, 40));

        lblName22.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblName22.setText("If Yes Specify");
        jPanel5.add(lblName22, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 440, -1, 40));

        mofacgroup.add(jCheckAssociationYes);
        jCheckAssociationYes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckAssociationYes.setText("YES");
        jCheckAssociationYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckAssociationYesActionPerformed(evt);
            }
        });
        jPanel5.add(jCheckAssociationYes, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, -1, 40));

        mofacgroup.add(jCheckAssociationNo);
        jCheckAssociationNo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckAssociationNo.setText("NO");
        jCheckAssociationNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckAssociationNoActionPerformed(evt);
            }
        });
        jPanel5.add(jCheckAssociationNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 440, -1, 40));

        lblEmergency.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblEmergency.setText("InCase of Emergency :");
        jPanel5.add(lblEmergency, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 280, 320, 40));

        txtEmergency.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jPanel5.add(txtEmergency, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 340, 360, 50));

        txtContactNo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        txtContactNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContactNoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContactNoKeyTyped(evt);
            }
        });
        jPanel5.add(txtContactNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 410, 200, 50));

        lblContactNo.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblContactNo.setText("Contact Number :");
        jPanel5.add(lblContactNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 410, 200, 50));

        txtIndigenousSpecify.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jPanel5.add(txtIndigenousSpecify, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 280, 50));

        lblGoverment.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblGoverment.setText("With Goverment ID?");
        jPanel5.add(lblGoverment, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, 290, 50));

        govermentgroup.add(jCheckGovYes);
        jCheckGovYes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckGovYes.setText("YES");
        jCheckGovYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckGovYesActionPerformed(evt);
            }
        });
        jPanel5.add(jCheckGovYes, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 70, -1, -1));

        govermentgroup.add(jCheckGovNo);
        jCheckGovNo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckGovNo.setText("NO");
        jCheckGovNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckGovNoActionPerformed(evt);
            }
        });
        jPanel5.add(jCheckGovNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 70, -1, -1));

        lblIDtype.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblIDtype.setText("If Yes Specify ID type");
        jPanel5.add(lblIDtype, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, -1, 50));

        txtIDtype.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jPanel5.add(txtIDtype, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 110, 170, 50));

        lblID.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblID.setText("ID Number :");
        jPanel5.add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, 230, 50));

        txtIDNumbber.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        txtIDNumbber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIDNumbberKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIDNumbberKeyTyped(evt);
            }
        });
        jPanel5.add(txtIDNumbber, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 180, 170, 50));

        lblFarmerAssociation.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblFarmerAssociation.setText("Association/Cooperative?");
        jPanel5.add(lblFarmerAssociation, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 300, 40));

        jSeparator4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel5.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 40, 470, 510));

        jSeparator5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel5.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 420, 500));

        lblFarmerAssociation1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblFarmerAssociation1.setText("Member of any farmers ");
        jPanel5.add(lblFarmerAssociation1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 280, 40));

        jSeparator6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel5.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 470, 510));

        btnNextPart3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        btnNextPart3.setText("Next");
        btnNextPart3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextPart3ActionPerformed(evt);
            }
        });
        jPanel5.add(btnNextPart3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 570, -1, 40));

        btnbackPart1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        btnbackPart1.setText("Back");
        btnbackPart1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackPart1ActionPerformed(evt);
            }
        });
        jPanel5.add(btnbackPart1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, -1, 40));

        jTabbedPane1.addTab("Part 2", jPanel5);

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblmain3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblmain3.setText("Main LiveLiHood");
        jPanel2.add(lblmain3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 210, 40));

        lblName44.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblName44.setText("For Farmers");
        jPanel2.add(lblName44, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 161, -1));

        lblName43.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblName43.setText("Types of Farming Activity");
        jPanel2.add(lblName43, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 250, -1));

        buttonGroupfarmer.add(jCheckRice1);
        jCheckRice1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckRice1.setText("Rice");
        jCheckRice1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckRice1ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckRice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 82, -1));

        buttonGroupfarmer.add(jCheckCorn1);
        jCheckCorn1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckCorn1.setText("Corn");
        jCheckCorn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckCorn1ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckCorn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 120, -1));

        buttonGroupfarmer.add(jCheckFarmOthers1);
        jCheckFarmOthers1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckFarmOthers1.setText("Others Crops");
        jCheckFarmOthers1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckFarmOthers1ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckFarmOthers1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 190, -1));

        lblName45.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblName45.setText("Please Specify");
        jPanel2.add(lblName45, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));
        jPanel2.add(txtOtherSpecify1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 250, 40));

        buttongrouplivelihood.add(jCheckFarmer);
        jCheckFarmer.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckFarmer.setText("Farmer");
        jCheckFarmer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckFarmerActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckFarmer, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 120, -1));

        buttonGroupfarmer.add(jCheckLive1);
        jCheckLive1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckLive1.setText("LiveStock");
        jCheckLive1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckLive1ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckLive1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 170, -1));

        lblName46.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblName46.setText("Please Specify");
        jPanel2.add(lblName46, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 190, -1));
        jPanel2.add(txtLiveSpecify1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 250, 40));

        buttonGroupfarmer.add(jCheckPoultry1);
        jCheckPoultry1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckPoultry1.setText("Poultry");
        jCheckPoultry1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckPoultry1ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckPoultry1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 120, 40));

        lblName47.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblName47.setText("Please Specify");
        jPanel2.add(lblName47, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 170, -1));
        jPanel2.add(txtPoultrySpecify1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 250, 40));

        buttongrouplivelihood.add(jCheckFarmLabor1);
        jCheckFarmLabor1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckFarmLabor1.setText("FarmWorker/laborer");
        jCheckFarmLabor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckFarmLabor1ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckFarmLabor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, -1, -1));

        SeperatorForFarmer.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.add(SeperatorForFarmer, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 290, 470));

        lblName49.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblName49.setText("Kind of Works");
        jPanel2.add(lblName49, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, -1, -1));

        buttonGroupfarmer.add(jCheckLand1);
        jCheckLand1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckLand1.setText("LandPreparation");
        jPanel2.add(jCheckLand1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, -1, -1));

        buttonGroupfarmer.add(jCheckPlanting1);
        jCheckPlanting1.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jCheckPlanting1.setText("Planting/TransPlanting");
        jCheckPlanting1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckPlanting1ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckPlanting1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, -1, -1));

        buttonGroupfarmer.add(jCheckCultivation1);
        jCheckCultivation1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckCultivation1.setText("Cultivation");
        jPanel2.add(jCheckCultivation1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, -1, -1));

        lblName20.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblName20.setText("For FarmWorkers");
        jPanel2.add(lblName20, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, -1, 30));

        buttonGroupfarmer.add(jCheckHarvest1);
        jCheckHarvest1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckHarvest1.setText("Harvesting");
        jPanel2.add(jCheckHarvest1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, -1, -1));

        buttonGroupfarmer.add(jCheckFarmworkerHarvest1);
        jCheckFarmworkerHarvest1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckFarmworkerHarvest1.setText("Others");
        jPanel2.add(jCheckFarmworkerHarvest1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 410, -1, -1));

        lblName75.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblName75.setText("Please Specify");
        jPanel2.add(lblName75, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 450, -1, -1));
        jPanel2.add(txtFarmWorkerSpecify1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 480, 250, 50));

        SeperatorFarmWorkers.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.add(SeperatorFarmWorkers, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 290, 470));

        buttongrouplivelihood.add(jCheckFish1);
        jCheckFish1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckFish1.setText("FisherFolk");
        jCheckFish1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckFish1ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckFish1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 40, -1, -1));

        lblName51.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblName51.setText("For Argri Youth");
        jPanel2.add(lblName51, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 90, 190, -1));

        buttonGroupfarmer.add(jCheckAqua2);
        jCheckAqua2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckAqua2.setText("AquaCulture");
        jPanel2.add(jCheckAqua2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 330, -1, -1));

        buttonGroupfarmer.add(jCheckFishOthers1);
        jCheckFishOthers1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckFishOthers1.setText("Others Please Specify");
        jPanel2.add(jCheckFishOthers1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 440, -1, -1));
        jPanel2.add(txtFishSpecify2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 480, 230, 50));

        buttonGroupfarmer.add(jCheckFishProcess1);
        jCheckFishProcess1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckFishProcess1.setText("Fish Processing");
        jPanel2.add(jCheckFishProcess1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 410, -1, -1));

        buttonGroupfarmer.add(jCheckFishVending1);
        jCheckFishVending1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckFishVending1.setText("Fish Vending");
        jPanel2.add(jCheckFishVending1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 370, -1, -1));

        buttonGroupfarmer.add(jCheckFishCapture2);
        jCheckFishCapture2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckFishCapture2.setText("Fish Capture");
        jPanel2.add(jCheckFishCapture2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 370, -1, -1));

        lblName74.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblName74.setText("Types of Fishing Activity");
        jPanel2.add(lblName74, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 290, 290, -1));

        buttonGroupfarmer.add(jCheckGleaning1);
        jCheckGleaning1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckGleaning1.setText("Gleaning");
        jPanel2.add(jCheckGleaning1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 330, -1, -1));

        jTextArea5.setBackground(new java.awt.Color(242, 242, 242));
        jTextArea5.setColumns(20);
        jTextArea5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jTextArea5.setRows(5);
        jTextArea5.setText("For the purposes of trainings,\nfinancial assistance, and the \nother programs catered to the \nyouth with involvementto any \naggriculture activitty.");
        jScrollPane6.setViewportView(jTextArea5);

        jPanel2.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 130, 370, 150));

        buttonGroupfarmer.add(jCheckPart1);
        jCheckPart1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckPart1.setText("part of a farming household");
        jPanel2.add(jCheckPart1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 300, -1, -1));

        buttonGroupfarmer.add(jCheckNonFromal1);
        jCheckNonFromal1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckNonFromal1.setText("attending/attended non/formal ");
        jPanel2.add(jCheckNonFromal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 380, -1, -1));

        lblName48.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblName48.setText("agri/fishery related course");
        jPanel2.add(lblName48, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 410, -1, -1));

        lblName50.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblName50.setText("Types of Involvement");
        jPanel2.add(lblName50, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 220, 290, -1));

        buttongrouplivelihood.add(jCheckAgri1);
        jCheckAgri1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckAgri1.setText("Agri Youth");
        jCheckAgri1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckAgri1ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckAgri1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 40, -1, 30));

        buttonGroupfarmer.add(jCheckFormal1);
        jCheckFormal1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckFormal1.setText("attending/attended formal ");
        jPanel2.add(jCheckFormal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 330, -1, -1));

        lblName77.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblName77.setText("agri/fishery related course");
        jPanel2.add(lblName77, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 360, 320, 30));

        buttonGroupfarmer.add(jCheckBox44);
        jCheckBox44.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jCheckBox44.setText("Others, Specify");
        jPanel2.add(jCheckBox44, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 440, -1, -1));
        jPanel2.add(jTextAgriSpecify1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 480, 270, 50));

        lblName52.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblName52.setText("For FisherFolk");
        jPanel2.add(lblName52, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 90, 190, -1));

        SeperatorFisher.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.add(SeperatorFisher, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, 390, 470));

        SeperetorAgri.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.add(SeperetorAgri, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 80, 420, 150));

        jTextArea4.setBackground(new java.awt.Color(242, 242, 242));
        jTextArea4.setColumns(20);
        jTextArea4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jTextArea4.setRows(5);
        jTextArea4.setText("The lending Conduct shall coordinate\nwiththe Bureau of Fisherlesand Aquatic \nresources (BFAR) in the Issurance of \na certification that the fisherfolk-\nborroweruner PUNLA?PLEA is \nregistered under the \nMunicipalRegistration (FishR).");
        jTextArea4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane5.setViewportView(jTextArea4);

        jPanel2.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 130, 370, -1));

        lblName53.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblName53.setText("Types of Involvement");
        jPanel2.add(lblName53, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 280, 290, -1));

        btnNextPart4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        btnNextPart4.setText("Next");
        btnNextPart4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextPart4ActionPerformed(evt);
            }
        });
        jPanel2.add(btnNextPart4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 570, -1, 40));

        btnbackPart2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        btnbackPart2.setText("Back");
        btnbackPart2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackPart2ActionPerformed(evt);
            }
        });
        jPanel2.add(btnbackPart2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, -1, 40));

        jTabbedPane1.addTab("Part 3", jPanel2);

        jPanel6.setOpaque(false);
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblImage1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        lblImage1.setOpaque(true);
        jPanel6.add(lblImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 300, 340));
        jPanel6.add(txtPath1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 300, 40));

        lblImage2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        lblImage2.setOpaque(true);
        jPanel6.add(lblImage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 310, 340));
        jPanel6.add(txtPath2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 310, 40));

        lblImage3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        lblImage3.setOpaque(true);
        jPanel6.add(lblImage3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 100, 310, 340));
        jPanel6.add(txtPath3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 40, 310, 40));

        lblImage4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        lblImage4.setOpaque(true);
        jPanel6.add(lblImage4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 100, 310, 340));

        txtPath4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPath4ActionPerformed(evt);
            }
        });
        jPanel6.add(txtPath4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 40, 310, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Valid ID");
        jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 450, 290, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Land Title");
        jLabel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 450, 290, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Brgy. Certificate");
        jLabel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 450, 290, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("2x2 Picture");
        jLabel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 280, 40));

        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 560, -1, 40));

        btnUploadvalidID.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnUploadvalidID.setText("Upload");
        btnUploadvalidID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadvalidIDActionPerformed(evt);
            }
        });
        jPanel6.add(btnUploadvalidID, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 500, 120, -1));

        btnbrgy.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnbrgy.setText("Upload");
        btnbrgy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbrgyActionPerformed(evt);
            }
        });
        jPanel6.add(btnbrgy, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 500, 120, -1));

        btnupload2x2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnupload2x2.setText("Upload");
        btnupload2x2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupload2x2ActionPerformed(evt);
            }
        });
        jPanel6.add(btnupload2x2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 500, 120, -1));

        btnLandTitle.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnLandTitle.setText("Upload");
        btnLandTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLandTitleActionPerformed(evt);
            }
        });
        jPanel6.add(btnLandTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 500, 120, -1));

        btnbackPart3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        btnbackPart3.setText("Back");
        btnbackPart3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackPart3ActionPerformed(evt);
            }
        });
        jPanel6.add(btnbackPart3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, -1, 40));

        btnAddSave.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        btnAddSave.setText("Save");
        btnAddSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSaveActionPerformed(evt);
            }
        });
        jPanel6.add(btnAddSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 559, -1, 40));

        btnEditSave.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        btnEditSave.setText("Save");
        btnEditSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditSaveActionPerformed(evt);
            }
        });
        jPanel6.add(btnEditSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 560, -1, 40));

        btnDeleteSave.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        btnDeleteSave.setText("Save");
        btnDeleteSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteSaveActionPerformed(evt);
            }
        });
        jPanel6.add(btnDeleteSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 560, -1, 40));

        jTabbedPane1.addTab("Part4", jPanel6);

        bg.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 1490, 670));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 30));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        bg.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 770, 1560, 50));

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );

        bg.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 20, 760));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1480, 40, 50, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel2.setText("Registered Farmer :");
        bg.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 40, 220, 40));

        jPanel7.setBackground(new java.awt.Color(153, 153, 153));
        jPanel7.setPreferredSize(new java.awt.Dimension(0, 30));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1570, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        bg.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1570, -1));

        jPanel8.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );

        bg.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1550, 30, 20, 760));

        btnEdit.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        bg.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 120, 40));

        btnUpdate1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        btnUpdate1.setText("Delete");
        btnUpdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate1ActionPerformed(evt);
            }
        });
        bg.add(btnUpdate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 120, 40));

        btnAdd1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        btnAdd1.setText("Add");
        btnAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd1ActionPerformed(evt);
            }
        });
        bg.add(btnAdd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 120, 40));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyImages/file.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        bg.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 39, 40, 40));

        txtSearch.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
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
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        bg.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 39, 190, 40));

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        jLabel9.setText("Search Farmer");
        bg.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 40, 140, 40));

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
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPath4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPath4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPath4ActionPerformed

    private void jCheckPlanting1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckPlanting1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckPlanting1ActionPerformed

    private void MaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaleActionPerformed
      
    }//GEN-LAST:event_MaleActionPerformed

    private void FemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FemaleActionPerformed
     
    }//GEN-LAST:event_FemaleActionPerformed

    private void jCheckChristianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckChristianActionPerformed
        // TODO add your handling code here:
        txtreligionSpecify.setEditable(false);
    }//GEN-LAST:event_jCheckChristianActionPerformed

    private void jComboCivilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboCivilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboCivilActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
         btnAddSave.hide();
       btnEditSave.show();
       btnDeleteSave.hide();       
        edittrrue();

    }//GEN-LAST:event_btnEditActionPerformed

    private void btnUpdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate1ActionPerformed
       btnAddSave.hide();
       btnEditSave.hide();
       btnDeleteSave.show();
       edittrrue();
    }//GEN-LAST:event_btnUpdate1ActionPerformed

    private void btnAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd1ActionPerformed
        btnAddSave.show();
        btnEditSave.hide();
        btnDeleteSave.hide();        
        edittrrue();
        autoid();
        txtID.setEditable(false);
        Font font =txtID.getFont();
        font = font.deriveFont(Font.PLAIN);
        txtID.setFont(font);
        txtID.setForeground(Color.black);
    }//GEN-LAST:event_btnAdd1ActionPerformed

    private void jCheckIslamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckIslamActionPerformed
         txtreligionSpecify.setEditable(false);
    }//GEN-LAST:event_jCheckIslamActionPerformed

    private void jCheckOthersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckOthersActionPerformed
        txtreligionSpecify.setEditable(true);
    }//GEN-LAST:event_jCheckOthersActionPerformed

    private void txtContactKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContactKeyTyped
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtContactKeyTyped

    private void txtIDNumbberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDNumbberKeyTyped
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtIDNumbberKeyTyped

    private void txtContactNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContactNoKeyTyped
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtContactNoKeyTyped

    private void txtNoofLivingKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoofLivingKeyTyped
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtNoofLivingKeyTyped

    private void txtMaleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaleKeyTyped
         char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtMaleKeyTyped

    private void txtFemaleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFemaleKeyTyped
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtFemaleKeyTyped

    private void txtContactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContactKeyPressed
       String phonenumer = txtContact.getText();
       int length = phonenumer.length();
       char c = evt.getKeyChar();
       if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9'){
            if (length<11) {
                txtContact.setEditable(true);
           }else{
                txtContact.setEditable(false);
            }
    }else{
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE ){
                txtContact.setEditable(true);
            }else{
                txtContact.setEditable(false);
            }
       }
    }//GEN-LAST:event_txtContactKeyPressed

    private void txtContactNoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContactNoKeyPressed
        String phonenumer = txtContactNo.getText();
       int length = phonenumer.length();
       char c = evt.getKeyChar();
       if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9'){
            if (length<11) {
                txtContactNo.setEditable(true);
           }else{
                txtContactNo.setEditable(false);
            }
    }else{
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE ){
                txtContactNo.setEditable(true);
            }else{
               txtContactNo.setEditable(false);
            }
       }
    }//GEN-LAST:event_txtContactNoKeyPressed

    private void txtIDNumbberKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDNumbberKeyPressed
         String phonenumer = txtIDNumbber.getText();
       int length = phonenumer.length();
       char c = evt.getKeyChar();
       if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9'){
            if (length<11) {
                txtIDNumbber.setEditable(true);
           }else{
                txtIDNumbber.setEditable(false);
            }
    }else{
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE ){
                txtIDNumbber.setEditable(true);
            }else{
               txtIDNumbber.setEditable(false);
            }
       }
    }//GEN-LAST:event_txtIDNumbberKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         try {
        txtprint.print();
       jPanel10.hide();
    } catch (PrinterException ex) {
        Logger.getLogger(Farmer.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        txtprint.setEditable(false);
        String id = txtID.getText();
        String sname = txtSName.getText();
        String fname = txtFName.getText();
        String mname = txtMName.getText();
        String ename = txtEName.getText();
        String Fullname = sname +" "+" " +fname+" "+" "+ mname+" "+ename;
        String house = txtPurok.getText();
        String street = txtStreet.getText();
        String brgy = combobrgy.getSelectedItem().toString();
        String muni = txtMunicipality.getText();
        String province = txtprovince.getText();
        String address = house +" "+" " +street+" "+" "+ brgy+" "+muni+" "+province;
        txtprint.setText(txtprint.getText() +"   -----------------------------------------------------------------------------------------\n");
        txtprint.setText(txtprint.getText()  + "            Registry System for Basic Sectors in Agriculture                            \n");
        txtprint.setText(txtprint.getText()  + "                                          Client's Copy                          \n");
        txtprint.setText(txtprint.getText() + "   -----------------------------------------------------------------------------------------   \n");
        txtprint.setText(txtprint.getText() + "                                                                                               \n");
        txtprint.setText(txtprint.getText() + "      Farmer ID :"+" " +txtID.getText()+"                          \n");
        txtprint.setText(txtprint.getText() + "                                                                                                \n");
        txtprint.setText(txtprint.getText() + "      Farmername :"+" "+" "+Fullname+" \n");
        txtprint.setText(txtprint.getText() + "                                                                                                \n");
        txtprint.setText(txtprint.getText() + "      Address :"+" "+" "+address+" \n");
        txtprint.setText(txtprint.getText() + "   -----------------------------------------------------------------------------------------   \n");
        jPanel10.show();
          //jTabbedPane1.hide(); 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtNoofLivingKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoofLivingKeyPressed
        String phonenumer = txtNoofLiving.getText();
       int length = phonenumer.length();
       char c = evt.getKeyChar();
       if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9'){
            if (length<3) {
                txtNoofLiving.setEditable(true);
           }else{
                txtNoofLiving.setEditable(false);
            }
    }else{
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE ){
                txtNoofLiving.setEditable(true);
            }else{
                txtNoofLiving.setEditable(false);
            }
       }
    }//GEN-LAST:event_txtNoofLivingKeyPressed

    private void txtMaleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaleKeyPressed
        String phonenumer = txtMale.getText();
       int length = phonenumer.length();
       char c = evt.getKeyChar();
       if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9'){
            if (length<3) {
                txtMale.setEditable(true);
           }else{
                txtMale.setEditable(false);
            }
    }else{
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE ){
                txtMale.setEditable(true);
            }else{
                txtMale.setEditable(false);
            }
       }
    }//GEN-LAST:event_txtMaleKeyPressed

    private void txtFemaleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFemaleKeyPressed
        String phonenumer = txtFemale.getText();
       int length = phonenumer.length();
       char c = evt.getKeyChar();
       if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9'){
            if (length<3) {
                txtFemale.setEditable(true);
           }else{
                txtFemale.setEditable(false);
            }
    }else{
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE ){
                txtFemale.setEditable(true);
            }else{
                txtFemale.setEditable(false);
            }
       }
    }//GEN-LAST:event_txtFemaleKeyPressed

    private void jCheckIndigenousNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckIndigenousNoActionPerformed
        txtIndigenousSpecify.setEditable(false);
    }//GEN-LAST:event_jCheckIndigenousNoActionPerformed

    private void jCheckAssociationNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckAssociationNoActionPerformed
       txtAssociationSpecify.setEditable(false);
    }//GEN-LAST:event_jCheckAssociationNoActionPerformed

    private void jCheckGovNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckGovNoActionPerformed
        txtIDtype.setEditable(false);
        txtIDNumbber.setEditable(false);
    }//GEN-LAST:event_jCheckGovNoActionPerformed

    private void jCheckHouseYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckHouseYesActionPerformed
       txtIfnoHouse.setEditable(false);
       txtRelationship.setEditable(false);
    }//GEN-LAST:event_jCheckHouseYesActionPerformed

    private void btnupload2x2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupload2x2ActionPerformed
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
    }//GEN-LAST:event_btnupload2x2ActionPerformed

    private void btnUploadvalidIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadvalidIDActionPerformed
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
    }//GEN-LAST:event_btnUploadvalidIDActionPerformed

    private void btnLandTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLandTitleActionPerformed
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
    }//GEN-LAST:event_btnLandTitleActionPerformed

    private void btnbrgyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbrgyActionPerformed
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
    }//GEN-LAST:event_btnbrgyActionPerformed

    private void jCheckGovYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckGovYesActionPerformed
        txtIDNumbber.setEditable(true);
        txtIDtype.setEditable(true);
    }//GEN-LAST:event_jCheckGovYesActionPerformed

    private void jCheckIndigenousYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckIndigenousYesActionPerformed
       txtIndigenousSpecify.setEditable(true);
    }//GEN-LAST:event_jCheckIndigenousYesActionPerformed

    private void jCheckAssociationYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckAssociationYesActionPerformed
        txtAssociationSpecify.setEditable(true);
    }//GEN-LAST:event_jCheckAssociationYesActionPerformed

    private void jCheckHouseNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckHouseNoActionPerformed
        txtIfnoHouse.setEditable(true);
        txtRelationship.setEditable(true);
    }//GEN-LAST:event_jCheckHouseNoActionPerformed

    private void txtPurokKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPurokKeyTyped
         char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtPurokKeyTyped

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        ImageIcon icon = new ImageIcon("file.png");
        JOptionPane.showMessageDialog(this, "<html><b style=\"color:black; font-size:15px;\">Click Add Button to Add Farmer "
                + "\n<html><b style=\"color:black; font-size:15px;\"> Click Edit Button to Edit Farmer info \n"
                + "<html><b style=\"color:black; font-size:15px;\">Click Delete Button to Delete Farmer</b></html>","Instruction",JOptionPane.INFORMATION_MESSAGE,icon); 
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtSNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSNameKeyTyped
        char c = evt.getKeyChar();
       if(Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)){
           txtSName.setEditable(true);
       }else{
           txtSName.setEditable(false);
       }
    }//GEN-LAST:event_txtSNameKeyTyped

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        jPanel10.hide();
        txtprint.setText(null);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void combomonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combomonthItemStateChanged
        int ageString = 0;
				Date d = new Date();
				SimpleDateFormat  yearDateFormat = new SimpleDateFormat("yyyy");
				String yearString = yearDateFormat.format(d);
				ageString = Integer.parseInt(yearString) - Integer.parseInt(comboyear.getSelectedItem().toString());
				System.out.println(ageString);
				SimpleDateFormat monthDateFormat = new SimpleDateFormat("MM");
				String monthString = monthDateFormat.format(d);
				System.out.println(monthString);
				System.out.println((combomonth.getSelectedIndex() + 1));
				if(Integer.parseInt(monthString) < (combomonth.getSelectedIndex() + 1)) {
					ageString--;
					System.out.println("Age : " + ageString);
				}else if (Integer.parseInt(monthString) == (combomonth.getSelectedIndex() + 1)) {
					SimpleDateFormat dayDateFormat = new SimpleDateFormat("dd");
					String dateString = dayDateFormat.format(d);
					if(Integer.parseInt(dateString) < Integer.parseInt(combomonth.getSelectedItem().toString())) {
						ageString--;
						System.out.println(ageString);
					}
				}
				if(ageString < 0) {
					ageString = 0;
				}
				txtage.setText(Integer.toString(ageString));
    }//GEN-LAST:event_combomonthItemStateChanged

    private void combodayItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combodayItemStateChanged
        int ageString = 0;
				Date d = new Date();
				SimpleDateFormat  yearDateFormat = new SimpleDateFormat("yyyy");
				String yearString = yearDateFormat.format(d);
				ageString = Integer.parseInt(yearString) - Integer.parseInt(comboyear.getSelectedItem().toString());
				System.out.println(ageString);
				SimpleDateFormat monthDateFormat = new SimpleDateFormat("MM");
				String monthString = monthDateFormat.format(d);
				System.out.println(monthString);
				System.out.println((combomonth.getSelectedIndex() + 1));
				if(Integer.parseInt(monthString) < (combomonth.getSelectedIndex() + 1)) {
					ageString--;
					System.out.println("Age : " + ageString);
				}else if (Integer.parseInt(monthString) == (combomonth.getSelectedIndex() + 1)) {
					SimpleDateFormat dayDateFormat = new SimpleDateFormat("dd");
					String dateString = dayDateFormat.format(d);
					if(Integer.parseInt(dateString) < Integer.parseInt(combomonth.getSelectedItem().toString())) {
						ageString--;
						System.out.println(ageString);
					}
				}
				if(ageString < 0) {
					ageString = 0;
				}
				txtage.setText(Integer.toString(ageString));
    }//GEN-LAST:event_combodayItemStateChanged

    private void comboyearItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboyearItemStateChanged
        int ageString = 0;
				Date d = new Date();
				SimpleDateFormat  yearDateFormat = new SimpleDateFormat("yyyy");
				String yearString = yearDateFormat.format(d);
				ageString = Integer.parseInt(yearString) - Integer.parseInt(comboyear.getSelectedItem().toString());
				System.out.println(ageString);
				SimpleDateFormat monthDateFormat = new SimpleDateFormat("MM");
				String monthString = monthDateFormat.format(d);
				System.out.println(monthString);
				System.out.println((combomonth.getSelectedIndex() + 1));
				if(Integer.parseInt(monthString) < (combomonth.getSelectedIndex() + 1)) {
					ageString--;
					System.out.println("Age : " + ageString);
				}else if (Integer.parseInt(monthString) == (combomonth.getSelectedIndex() + 1)) {
					SimpleDateFormat dayDateFormat = new SimpleDateFormat("dd");
					String dateString = dayDateFormat.format(d);
					if(Integer.parseInt(dateString) < Integer.parseInt(combomonth.getSelectedItem().toString())) {
						ageString--;
						System.out.println(ageString);
					}
				}
				if(ageString < 0) {
					ageString = 0;
				}
				txtage.setText(Integer.toString(ageString));
    }//GEN-LAST:event_comboyearItemStateChanged

    private void comboyearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboyearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboyearActionPerformed

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
      
    }//GEN-LAST:event_txtSearchKeyPressed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
      if(txtSearch.getText().equals("Enter Farmer ID")){
            txtSearch.setText(null);
            txtSearch.requestFocus();
            removeplaceholder(txtSearch);
       }
    }//GEN-LAST:event_txtSearchFocusGained

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
      if(txtSearch.getText().length()==0){  
          placeholder(txtSearch);
          txtSearch.setText("Enter Farmer ID");
      }
    }//GEN-LAST:event_txtSearchFocusLost

    private void btnNextPart2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextPart2ActionPerformed
       
       jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btnNextPart2ActionPerformed

    private void btnNextPart3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextPart3ActionPerformed
       jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_btnNextPart3ActionPerformed

    private void btnNextPart4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextPart4ActionPerformed
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_btnNextPart4ActionPerformed

    private void btnbackPart1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackPart1ActionPerformed
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_btnbackPart1ActionPerformed

    private void btnbackPart2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackPart2ActionPerformed
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btnbackPart2ActionPerformed

    private void btnbackPart3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackPart3ActionPerformed
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_btnbackPart3ActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            insert = con1.prepareStatement(" SELECT * from profile where FID = ?");
            String id = (txtSearch.getText());
            insert.setString(1,id);
            rst = insert.executeQuery();
            if(rst.next()==true){
                String fid = rst.getString("FID");
                String fname = rst.getString("FName");
                String mname = rst.getString("MName");
                String lname = rst.getString("LName");
                String ename = rst.getString("EName");
                String houseno = rst.getString("House_No");
                String street = rst.getString("Street");
                String  brgy = rst.getString("Barangay");
                
                String dbirth = rst.getString("Date_of_Birth");
                String pbirth = rst.getString("Place_of_Birth");
                String civil = rst.getString("Civil_Status");
                txtID.setText(fid);
                txtSName.setText(fname);
                txtFName.setText(mname);
                txtMName.setText(lname);
                txtEName.setText(ename);
                txtPurok.setText(houseno);
                txtStreet.setText(street);
                combobrgy.setSelectedItem(brgy);
                
                 String gender = rst.getString("Sex");
                  if(gender.equals("Male")){
                          Male.setSelected(true);
                      }else if(gender.equals("Female")){
                          Female.setSelected(true);
                          
                      }
                      
                 String contact = rst.getString("Contact");
                      txtContact.setText(contact);
          String birthdate = rst.getString("Date_of_Birth");
					String year = birthdate.substring(0, 4);
					combomonth.setSelectedItem(year);
					int date = Integer.parseInt(birthdate.substring(5, 7)) - 1 + 1;
					
					combomonth.setSelectedItem(Integer.toString(date));
					int month = Integer.parseInt(birthdate.substring(9, birthdate.length())) - 1;
					switch(month) {
					case 0:
						combomonth.setSelectedItem("Jan");
						break;
					case 1:
						combomonth.setSelectedItem("Feb");
						break;
					case 2:
						combomonth.setSelectedItem("Mar");
						break;
					case 3:
						combomonth.setSelectedItem("Apr");
						break;
					case 4:
						combomonth.setSelectedItem("May");
						break;
					case 5:
						combomonth.setSelectedItem("June");
						break;
					case 6:
						combomonth.setSelectedItem("July");
						break;
					case 7:
						combomonth.setSelectedItem("Aug");
						break;
					case 8:
						combomonth.setSelectedItem("Sept");
						break;
					case 9:
						combomonth.setSelectedItem("Oct");
						break;
					case 10:
						combomonth.setSelectedItem("Nov");
						break;
					case 11:
						combomonth.setSelectedItem("Dec");
						break;
					}           
                      String age =  rst.getString("Age");
                      txtage.setText(age);
                      String place = rst.getString("Place_of_Birth");
                      txtPlace.setText(place);
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
                      
                
           
                     String ids = txtID.getText();
        try{
              
              Class.forName("com.mysql.cj.jdbc.Driver");
               con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            String sql ="SELECT * FROM images where Image_ID=?";
           
            insert = con1.prepareStatement(sql);
            insert.setString(1, ids);
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
    
        }else{
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
          lblImage1.setIcon(null);
          lblImage2.setIcon(null);
          lblImage3.setIcon(null);
          lblImage4.setIcon(null);
          lblImage1.setIcon(null);
          lblImage2.setIcon(null);
          lblImage3.setIcon(null);
          lblImage4.setIcon(null);
           autoid();
            }
            
                
        }
             catch (SQLException ex) {
                     
                  } catch (ClassNotFoundException ex) {
       
    }
            }else{
                JOptionPane.showMessageDialog(null, "<html><b style=\"color:black; font-size:15px;\">Sorry Farmer Not Found!</b></html>","Enter Correct Farmer ID", JOptionPane.ERROR_MESSAGE,icon1);
            }
            
            
        }catch (Exception e){

        }
    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnAddSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSaveActionPerformed
          String id = txtID.getText();
         String SName = txtSName.getText();
         String FName = txtFName.getText();
         String MName = txtMName.getText();
         String EName = txtEName.getText();
         String HouseNo = txtPurok.getText();
         String street = txtStreet.getText();
         String contact = txtContact.getText();
         String place = txtPlace.getText();
         String civil = jComboCivil.getSelectedItem().toString();
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
         
 
        if(id.isEmpty() || SName.isEmpty() || FName.isEmpty() || MName.isEmpty() || HouseNo.isEmpty()
            || street.isEmpty() || contact.isEmpty() | place.isEmpty()){
            JOptionPane.showMessageDialog(null, "<html><b style=\"color:black; font-size:15px;\">Fill the Blank!</b></html>","Complete the details", JOptionPane.ERROR_MESSAGE,icon1);
        }else{
            
            addfarmer();
        txtprint.setEditable(false);
        String ids = txtID.getText();
        String sname = txtSName.getText();
        String fname = txtFName.getText();
        String mname = txtMName.getText();
        String ename = txtEName.getText();
        String Fullname = sname +" "+" " +fname+" "+" "+ mname+" "+ename;
        String house = txtPurok.getText();
        String streets = txtStreet.getText();
        String brgy = combobrgy.getSelectedItem().toString();
        String muni = txtMunicipality.getText();
        String province = txtprovince.getText();
        String address = house +" "+" " +streets+" "+" "+ brgy+" "+muni+" "+province;
        txtprint.setText(txtprint.getText() +"   -----------------------------------------------------------------------------------------\n");
        txtprint.setText(txtprint.getText()  + "            Registry System for basic Sectors in Agriculture                            \n");
        txtprint.setText(txtprint.getText()  + "                                          Client's Copy                          \n");
        txtprint.setText(txtprint.getText() + "   -----------------------------------------------------------------------------------------   \n");
        txtprint.setText(txtprint.getText() + "                                                                                               \n");
        txtprint.setText(txtprint.getText() + "      Farmer ID :"+" " +txtID.getText()+"                          \n");
        txtprint.setText(txtprint.getText() + "                                                                                                \n");
        txtprint.setText(txtprint.getText() + "      Farmername :"+" "+" "+Fullname+" \n");
        txtprint.setText(txtprint.getText() + "                                                                                                \n");
        txtprint.setText(txtprint.getText() + "      Address :"+" "+" "+address+" \n");
        txtprint.setText(txtprint.getText() + "   -----------------------------------------------------------------------------------------   \n");
          jPanel10.show();
           
        }
        edittrrue();
        autoid();
        txtID.setEditable(false);
        Font font =txtID.getFont();
        font = font.deriveFont(Font.PLAIN);
        txtID.setFont(font);
        txtID.setForeground(Color.black);
        
         
    }//GEN-LAST:event_btnAddSaveActionPerformed

    private void btnEditSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditSaveActionPerformed
         String id = txtID.getText();
         String SName = txtSName.getText();
         String FName = txtFName.getText();
         String MName = txtMName.getText();
         String EName = txtEName.getText();
         String HouseNo = txtPurok.getText();
         String street = txtStreet.getText();
         String contact = txtContact.getText();
         String place = txtPlace.getText();
         
        

        if(SName.isEmpty() || FName.isEmpty() || MName.isEmpty() || HouseNo.isEmpty()
            || street.isEmpty() || contact.isEmpty() | place.isEmpty()){
        JOptionPane.showMessageDialog(null, "<html><b style=\"color:black; font-size:15px;\">Fill the Blank!</b></html>","Complete the details", JOptionPane.ERROR_MESSAGE,icon1);
        }else{
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
//        String dates = format.format(jDateChooser1.getDate());
        String datePersonal = comboday.getSelectedItem().toString();
        if(datePersonal.length() <= 1) {
	datePersonal = "0" + datePersonal;
	}
        String monthPersonal = Integer.toString(combomonth.getSelectedIndex()+1);
	if(monthPersonal.length()>= 1) {
	 monthPersonal = "0" + monthPersonal ;
	}
	String yearPersonal = comboyear.getSelectedItem().toString();
	String birthday = yearPersonal + "/" + datePersonal + "/" + monthPersonal;
       
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
        String age = txtage.getText();
        
        String religion = null;
        String pwd = null;
        String four = null;
        String indigenous = null;
        String farmersAssociation = null;
        String GovermentID = null;
        String house = null;
        String civil = jComboCivil.getSelectedItem().toString();
        String livelihood = null;
        String farmingtype = null;
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
         if(Male.isSelected()){
                gender="Male";
                }
                else if(Female.isSelected()){
                  gender="Female";
                }
         //for main livelihood
                if(jCheckFarmer.isSelected()){
                    livelihood = "Farmer";
                }
                else if(jCheckFarmLabor1.isSelected()){
                    livelihood = "FarmWorker/laborer";
                }
                else if(jCheckFish1.isSelected()){
                    livelihood = "FisherFolk";
                }
                else if(jCheckAgri1.isSelected()){
                    livelihood = "Agri Youth";
                }
                //for main farming type
                if(jCheckRice1.isSelected()){
                    farmingtype = "Rice";
                }
                else if(jCheckCorn1.isSelected()){
                    farmingtype = "Corn";
                }
                else if(jCheckFarmOthers1.isSelected()){
                    farmingtype = "Others Crops";
                    specify = txtOtherSpecify1.getText();
                }
                else if(jCheckLive1.isSelected()){
                    farmingtype = "LiveStock";
                    specify = txtLiveSpecify1.getText();
                }
                else if(jCheckPoultry1.isSelected()){
                    farmingtype = "Poultry";
                    specify = txtPoultrySpecify1.getText();
                }
                else if(jCheckLand1.isSelected()){
                    farmingtype = "LandPreparation";
                }
                else if(jCheckPlanting1.isSelected()){
                    farmingtype = "Planting/TransPlanting";
                }
                else if(jCheckCultivation1.isSelected()){
                    farmingtype = "Cultivation";
                }
                else if(jCheckHarvest1.isSelected()){
                    farmingtype = "Harvesting";
                }
                else if(jCheckFarmworkerHarvest1.isSelected()){
                    farmingtype = "Others";
                }
                else if(jCheckAqua2.isSelected()){
                    farmingtype = "AquaCulture";
                }
                else if(jCheckFishVending1.isSelected()){
                    farmingtype = "Fish Vending";
                }
                else if(jCheckFishProcess1.isSelected()){
                    farmingtype = "Fish Processing";
                }
                else if(jCheckFishOthers1.isSelected()){
                    farmingtype = "Others";
                }
                else if(jCheckGleaning1.isSelected()){
                    farmingtype = "Gleaning";
                }
                else if(jCheckFishCapture2.isSelected()){
                    farmingtype = "Fish Capture";
                }
                else if(jCheckPart1.isSelected()){
                    farmingtype = "part of a farming household";
                }
                 else if(jCheckFormal1.isSelected()){
                    farmingtype = "attending/attended formal agri/fishery related course";
                }
                 else if(jCheckNonFromal1.isSelected()){
                    farmingtype = "attending/attended non/formal agri/fishery related course";
                }
                 else if(jCheckBox44.isSelected()){
                    farmingtype = "Others";
                }
                
        try {
           
                
                Date date = new Date();
                        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
                        String currentdate = dateformat.format(date);
                        lblDate.setText(currentdate);
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");
            insert = con1.prepareStatement("UPDATE profile set LName=?,FName=?,MName=?,EName=?,House_No=?,Street=?,"
                    + "Barangay=?,Municipality=?,Province=?,Region=?,Contact=?,Sex=?,Date_of_Birth=?,Age=?,Place_of_Birth=?,"
                    + "Civil_Status=?,Highest_Education=?,Religion=?,Religion_Specify=?,PWD=?,4Ps_Benificiary=?,"
                    + "Members_of_Indigenous=?,Indigen_Specify=?,MoaFAC=?,Mofac_Specify=?,With_Goverment_ID=?,"
                    + "GovermentID_Specify=?,ID_Number=?,House_Hold_Head=?,If_no_Name_of_House_Hold_Head=?,"
                    + "Relationship=?,NO_House_Hold_Member=?,No_Male=?,No_Female=?,Person_to_notify_in_case_of_emergency=?,"
                    + "Contact_No=?,livelihood=?,Farmingtype=?,Date_Register=? WHERE FID=?");
    
            
            insert.setString(40, txtID.getText());
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
            insert.setString(12, gender);
            insert.setString(13, birthday);
            insert.setString(14, age);
            insert.setString(15, place);
            insert.setString(16, civil);
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
            insert.setString(37, livelihood );
            insert.setString(38, farmingtype );
            insert.setString(39, currentdate );
            insert.executeUpdate();
            
    JOptionPane.showMessageDialog(this,"<html><b style=\"color:black; font-size:15px;\">Edit Successfuly!</b></html>","Success",JOptionPane.INFORMATION_MESSAGE,icon2);
            autoid();
            
          
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
          lblImage1.setIcon(null);
          lblImage2.setIcon(null);
          lblImage3.setIcon(null);
          lblImage4.setIcon(null);
          txtID.requestFocus();
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
       
    }//GEN-LAST:event_btnEditSaveActionPerformed

    private void btnDeleteSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteSaveActionPerformed
      String id = txtID.getText();
         String SName = txtSName.getText();
         String FName = txtFName.getText();
         String MName = txtMName.getText();
         String EName = txtEName.getText();
         String HouseNo = txtPurok.getText();
         String street = txtStreet.getText();
         String contact = txtContact.getText();
         String place = txtPlace.getText();
         if(SName.isEmpty() || FName.isEmpty() || MName.isEmpty() || HouseNo.isEmpty()
            || street.isEmpty() || contact.isEmpty() | place.isEmpty()){
        JOptionPane.showMessageDialog(null, "<html><b style=\"color:black; font-size:15px;\">Fill the Blank!</b></html>","Complete the details", JOptionPane.ERROR_MESSAGE,icon1);
        }else{
        
        int op =JOptionPane.showConfirmDialog(null, "<html><b style=\"color:black; font-size:15px;\">Are you sure to Delete</b></html>", "Delete", JOptionPane.YES_NO_OPTION,JOptionPane.DEFAULT_OPTION,icon3);
        if(op == 0){
            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                con1= DriverManager.getConnection("jdbc:mysql://localhost:3306/registar","root","DANIEL05");

                String query = "DELETE FROM profile where FID=?";
                insert = con1.prepareStatement(query);
                insert.setString(1,txtID.getText());
                String query1 = "DELETE FROM images where Image_ID=?";
                insert = con1.prepareStatement(query);
                insert.setString(1,txtID.getText());
                insert.executeUpdate();

       JOptionPane.showMessageDialog(this,"<html><b style=\"color:black; font-size:15px;\"> Successfuly Deleted!</b></html>","Success",JOptionPane.INFORMATION_MESSAGE,icon2);
                  txtID.setText("");
          txtSName.setText("");
          txtFName.setText("");
          txtMName.setText("");
          txtEName.setText("");
          txtPurok.setText("");
          txtStreet.setText("");
          txtContact.setText("");
          txtPlace.setText("");
          txtIndigenousSpecify.setText("");
          txtAssociationSpecify.setText("");
          txtIDtype.setText("");
          txtIDNumbber.setText("");
          txtIfnoHouse.setText("");
          txtRelationship.setText("");
          txtNoofLiving.setText("");
          txtMale.setText("");
          txtFemale.setText("");
          txtEmergency.setText("");
          txtContactNo.setText("");
          txtPath1.setText("");
          txtPath2.setText("");
          txtPath3.setText("");
          txtPath4.setText("");
          combobrgy.setSelectedIndex(0);
          jComboCivil.setSelectedIndex(0);
          jComboEduc.setSelectedIndex(0);
          txtIDNumbber.setText("");
          religiongroup.clearSelection();
          gendergroup.clearSelection();
          fourpsgroup.clearSelection();
          pwdgroup.clearSelection();
          indigengroup.clearSelection();
          mofacgroup.clearSelection();
          govermentgroup.clearSelection();
          housegroup.clearSelection();
          lblImage1.setIcon(null);
          lblImage2.setIcon(null);
          lblImage3.setIcon(null);
          lblImage4.setIcon(null);
          txtID.requestFocus();
          txtSearch.setText(null);
          autoid();
          Totalfarmer();
               

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         }
    }//GEN-LAST:event_btnDeleteSaveActionPerformed

    private void jCheckFarmLabor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckFarmLabor1ActionPerformed
       lblName20.setEnabled(true);
       lblName49.setEnabled(true);
       lblName75.setEnabled(true);
       
       jCheckLand1.setEnabled(true);
       jCheckPlanting1.setEnabled(true);
       jCheckLand1.setEnabled(true);
       jCheckCultivation1.setEnabled(true);
       jCheckHarvest1.setEnabled(true);
       jCheckFarmworkerHarvest1.setEnabled(true);
       txtFarmWorkerSpecify1.setEditable(true);
       
       lblName44.setEnabled(false);
       lblName43.setEnabled(false);
       jCheckRice1.setEnabled(false);
       jCheckCorn1.setEnabled(false);
       jCheckFarmOthers1.setEnabled(false);
       jCheckLive1.setEnabled(false);
       jCheckPoultry1.setEnabled(false);
       txtOtherSpecify1.setEditable(false);
       txtLiveSpecify1.setEditable(false);
       txtPoultrySpecify1.setEditable(false);
       lblName45.setEnabled(false);
       lblName46.setEnabled(false);
       lblName47.setEnabled(false);
       
       
       lblName51.setEnabled(false);
       lblName53.setEnabled(false);
       lblName77.setEnabled(false);
       lblName48.setEnabled(false);
       jTextArea5.setEnabled(false);
       
       
        lblName52.setEnabled(false);
       lblName74.setEnabled(false);
       jTextArea4.setEnabled(false);
       jCheckFishVending1.setEnabled(false);
       jCheckAqua2.setEnabled(false);
       jCheckFishProcess1.setEnabled(false);
       jCheckGleaning1.setEnabled(false);
       jCheckFishCapture2.setEnabled(false);
       jCheckFishOthers1.setEnabled(false);
       txtFishSpecify2.setEditable(false);
       
       
       
        lblName51.setEnabled(false);
       lblName53.setEnabled(false);
       lblName77.setEnabled(false);
       lblName48.setEnabled(false);
       jTextArea5.setEnabled(false);
       jCheckPart1.setEnabled(false);
       jCheckFormal1.setEnabled(false);
       jCheckNonFromal1.setEnabled(false);
       jCheckBox44.setEnabled(false);
       jTextAgriSpecify1.setEditable(false);
    }//GEN-LAST:event_jCheckFarmLabor1ActionPerformed

    private void jCheckFarmerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckFarmerActionPerformed

        lblName44.setEnabled(true);
       lblName43.setEnabled(true);
       jCheckRice1.setEnabled(true);
       jCheckCorn1.setEnabled(true);
       jCheckFarmOthers1.setEnabled(true);
       jCheckLive1.setEnabled(true);
       jCheckPoultry1.setEnabled(true);
       txtOtherSpecify1.setEditable(true);
       txtLiveSpecify1.setEditable(true);
       txtPoultrySpecify1.setEditable(true);
       lblName45.setEnabled(true);
       lblName46.setEnabled(true);
       lblName47.setEnabled(true);
        
        
        
       lblName20.setEnabled(false);
       lblName49.setEnabled(false);
       lblName75.setEnabled(false);
       jCheckLand1.setEnabled(false);
       jCheckPlanting1.setEnabled(false);
       jCheckCultivation1.setEnabled(false);
       jCheckHarvest1.setEnabled(false);
       jCheckFarmworkerHarvest1.setEnabled(false);
       txtFarmWorkerSpecify1.setEditable(false);
       
       lblName52.setEnabled(false);
       lblName74.setEnabled(false);
       jTextArea4.setEnabled(false);
       lblName52.setEnabled(false);
       lblName74.setEnabled(false);
       jTextArea4.setEnabled(false);
       jCheckLand1.setEnabled(false);
       jCheckFishVending1.setEnabled(false);
       jCheckAqua2.setEnabled(false);
       jCheckFishProcess1.setEnabled(false);
       jCheckGleaning1.setEnabled(false);
       jCheckFishCapture2.setEnabled(false);
       jCheckFishOthers1.setEnabled(false);
       txtFishSpecify2.setEditable(false);
       
        lblName51.setEnabled(false);
       lblName53.setEnabled(false);
       lblName77.setEnabled(false);
       lblName48.setEnabled(false);
       jTextArea5.setEnabled(false);
       jCheckPart1.setEnabled(false);
       jCheckFormal1.setEnabled(false);
       jCheckNonFromal1.setEnabled(false);
       jCheckBox44.setEnabled(false);
       jTextAgriSpecify1.setEditable(false);
    }//GEN-LAST:event_jCheckFarmerActionPerformed

    private void jCheckFish1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckFish1ActionPerformed
         lblName52.setEnabled(true);
       lblName74.setEnabled(true);
       jTextArea4.setEnabled(true);
       jCheckFishVending1.setEnabled(true);
       jCheckAqua2.setEnabled(true);
       jCheckFishProcess1.setEnabled(true);
       jCheckGleaning1.setEnabled(true);
       jCheckFishCapture2.setEnabled(true);
       jCheckFishOthers1.setEnabled(true);
       txtFishSpecify2.setEditable(true);
       
       // for farmer
        lblName44.setEnabled(false);
       lblName43.setEnabled(false);
       jCheckRice1.setEnabled(false);
       jCheckCorn1.setEnabled(false);
       jCheckFarmOthers1.setEnabled(false);
       jCheckLive1.setEnabled(false);
       jCheckPoultry1.setEnabled(false);
       txtOtherSpecify1.setEditable(false);
       txtLiveSpecify1.setEditable(false);
       txtPoultrySpecify1.setEditable(false);
       lblName45.setEnabled(false);
       lblName46.setEnabled(false);
       lblName47.setEnabled(false);
       //form farm laborer
       lblName20.setEnabled(false);
       lblName49.setEnabled(false);
       lblName75.setEnabled(false);
       jCheckLand1.setEnabled(false);
       jCheckPlanting1.setEnabled(false);
       jCheckCultivation1.setEnabled(false);
       jCheckHarvest1.setEnabled(false);
       jCheckFarmworkerHarvest1.setEnabled(false);
       txtFarmWorkerSpecify1.setEditable(false);
       // for agri youth
       lblName51.setEnabled(false);
       lblName53.setEnabled(false);
       lblName77.setEnabled(false);
       lblName48.setEnabled(false);
       jTextArea5.setEnabled(false);
       jCheckPart1.setEnabled(false);
       jCheckFormal1.setEnabled(false);
       jCheckNonFromal1.setEnabled(false);
       jCheckBox44.setEnabled(false);
       jTextAgriSpecify1.setEditable(false);
    }//GEN-LAST:event_jCheckFish1ActionPerformed

    private void jCheckAgri1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckAgri1ActionPerformed
       lblName51.setEnabled(true);
       lblName53.setEnabled(true);
       lblName77.setEnabled(true);
       lblName48.setEnabled(true);
       jTextArea5.setEnabled(true);
       jCheckPart1.setEnabled(true);
       jCheckFormal1.setEnabled(true);
       jCheckNonFromal1.setEnabled(true);
       jCheckBox44.setEnabled(true);
       jTextAgriSpecify1.setEditable(true);
       
         lblName52.setEnabled(false);
       lblName74.setEnabled(false);
       jTextArea4.setEnabled(false);
       jCheckFishVending1.setEnabled(false);
       jCheckAqua2.setEnabled(false);
       jCheckFishProcess1.setEnabled(false);
       jCheckGleaning1.setEnabled(false);
       jCheckFishCapture2.setEnabled(false);
       jCheckFishOthers1.setEnabled(false);
       txtFishSpecify2.setEditable(false);
       
       // for farmer
        lblName44.setEnabled(false);
       lblName43.setEnabled(false);
       jCheckRice1.setEnabled(false);
       jCheckCorn1.setEnabled(false);
       jCheckFarmOthers1.setEnabled(false);
       jCheckLive1.setEnabled(false);
       jCheckPoultry1.setEnabled(false);
       txtOtherSpecify1.setEditable(false);
       txtLiveSpecify1.setEditable(false);
       txtPoultrySpecify1.setEditable(false);
       lblName45.setEnabled(false);
       lblName46.setEnabled(false);
       lblName47.setEnabled(false);
       //form farm laborer
       lblName20.setEnabled(false);
       lblName49.setEnabled(false);
       lblName75.setEnabled(false);
       jCheckLand1.setEnabled(false);
       jCheckPlanting1.setEnabled(false);
       jCheckCultivation1.setEnabled(false);
       jCheckHarvest1.setEnabled(false);
       jCheckFarmworkerHarvest1.setEnabled(false);
       txtFarmWorkerSpecify1.setEditable(false);
    }//GEN-LAST:event_jCheckAgri1ActionPerformed

    private void jCheckLive1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckLive1ActionPerformed
      txtOtherSpecify1.setText(null);
       txtPoultrySpecify1.setText(null);
        txtOtherSpecify1.setEditable(false);
        txtLiveSpecify1.setEditable(true);
        txtPoultrySpecify1.setEditable(false);
    }//GEN-LAST:event_jCheckLive1ActionPerformed

    private void jCheckFarmOthers1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckFarmOthers1ActionPerformed
       txtLiveSpecify1.setText(null);
       txtPoultrySpecify1.setText(null);
        txtOtherSpecify1.setEditable(true);
        txtLiveSpecify1.setEditable(false);
        txtPoultrySpecify1.setEditable(false);
    }//GEN-LAST:event_jCheckFarmOthers1ActionPerformed

    private void jCheckPoultry1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckPoultry1ActionPerformed
       txtLiveSpecify1.setText(null);
       txtOtherSpecify1.setText(null);
        txtOtherSpecify1.setEditable(false);
        txtLiveSpecify1.setEditable(false);
        txtPoultrySpecify1.setEditable(true);
    }//GEN-LAST:event_jCheckPoultry1ActionPerformed

    private void jCheckRice1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckRice1ActionPerformed
        txtOtherSpecify1.setEditable(false);
        txtLiveSpecify1.setEditable(false);
        txtPoultrySpecify1.setEditable(false);
    }//GEN-LAST:event_jCheckRice1ActionPerformed

    private void jCheckCorn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckCorn1ActionPerformed
        txtOtherSpecify1.setEditable(false);
        txtLiveSpecify1.setEditable(false);
        txtPoultrySpecify1.setEditable(false);
    }//GEN-LAST:event_jCheckCorn1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Female;
    private javax.swing.JRadioButton Male;
    private javax.swing.JSeparator SeperatorFarmWorkers;
    private javax.swing.JSeparator SeperatorFisher;
    private javax.swing.JSeparator SeperatorForFarmer;
    private javax.swing.JSeparator SeperetorAgri;
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnAdd1;
    private javax.swing.JButton btnAddSave;
    private javax.swing.JButton btnDeleteSave;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnEditSave;
    private javax.swing.JButton btnLandTitle;
    private javax.swing.JButton btnNextPart2;
    private javax.swing.JButton btnNextPart3;
    private javax.swing.JButton btnNextPart4;
    private javax.swing.JButton btnUpdate1;
    private javax.swing.JButton btnUploadvalidID;
    private javax.swing.JButton btnbackPart1;
    private javax.swing.JButton btnbackPart2;
    private javax.swing.JButton btnbackPart3;
    private javax.swing.JButton btnbrgy;
    private javax.swing.JButton btnupload2x2;
    private javax.swing.ButtonGroup buttonGroupfarmer;
    private javax.swing.ButtonGroup buttongrouplivelihood;
    private javax.swing.JComboBox<String> combobrgy;
    private javax.swing.JComboBox<String> comboday;
    private javax.swing.JComboBox<String> combomonth;
    private javax.swing.JComboBox<String> comboyear;
    private javax.swing.ButtonGroup fourpsgroup;
    private javax.swing.ButtonGroup gendergroup;
    private javax.swing.ButtonGroup govermentgroup;
    private javax.swing.ButtonGroup housegroup;
    private javax.swing.ButtonGroup indigengroup;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
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
    private javax.swing.JCheckBox jCheckFarmer;
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
    private javax.swing.JCheckBox jCheckPlanting1;
    private javax.swing.JCheckBox jCheckPoultry1;
    private javax.swing.JCheckBox jCheckRice1;
    private javax.swing.JComboBox<String> jComboCivil;
    private javax.swing.JComboBox<String> jComboEduc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextAgriSpecify1;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JLabel lbl4Ps;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblBarangay;
    private javax.swing.JLabel lblCivil;
    private javax.swing.JLabel lblContact;
    private javax.swing.JLabel lblContact1;
    private javax.swing.JLabel lblContactNo;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblEName;
    private javax.swing.JLabel lblEduc;
    private javax.swing.JLabel lblEmergency;
    private javax.swing.JLabel lblFID;
    private javax.swing.JLabel lblFName;
    private javax.swing.JLabel lblFarmerAssociation;
    private javax.swing.JLabel lblFarmerAssociation1;
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
    private javax.swing.JLabel lblName53;
    private javax.swing.JLabel lblName74;
    private javax.swing.JLabel lblName75;
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
    private javax.swing.ButtonGroup mofacgroup;
    private javax.swing.ButtonGroup pwdgroup;
    private javax.swing.ButtonGroup religiongroup;
    private javax.swing.JTextField txtAssociationSpecify;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtContactNo;
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
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtStreet;
    private javax.swing.JTextField txtage;
    private javax.swing.JTextArea txtprint;
    private javax.swing.JTextField txtprovince;
    private javax.swing.JTextField txtreligionSpecify;
    // End of variables declaration//GEN-END:variables
}
