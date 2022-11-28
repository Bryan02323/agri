
package jaen;


class Farmer {
    
    private String  Farmer_ID, Last_Name, First_Name, Middle_Name, Extension_Name,Status;
    private byte[] picture;
    
    public Farmer (String Farmer_ID, String Last_Name, String First_Name, String Middle_Name, String Extension_Name, byte[]image, String Status)
    {
        this.Farmer_ID = Farmer_ID;
        this.Last_Name = Last_Name;
        this.First_Name = First_Name;
        this.Middle_Name = Middle_Name;
        this.Extension_Name = Extension_Name;
        this.picture = image;
        this.Status = Status;
    }

    


    public String getfarmerid(){
        return Farmer_ID;
    }
     public String getLastName(){
        return Last_Name;
    }
      public String getFirstName(){
        return First_Name;
    }
       public String getMiddleName(){
        return Middle_Name;
    }
        public String getExtensionName(){
        return Extension_Name;
    }
         public byte[] getimage(){
        return picture;
    }
          public String getstatus(){
        return Status;
    }

}
