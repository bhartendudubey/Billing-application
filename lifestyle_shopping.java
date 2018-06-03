import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


//*************************//
//“Title” Frame (frametitle.java)//
//*************************//


//Coding of “CONTINUE” button://
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
frame1 t=new frame1();
t.setVisible(true);
this.setVisible(false);
    }







//*************************//
//“Menu” Frame (frame1.java)//
//*************************//



//“NEW CUSTOMER” button://

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
PROJECT t=new PROJECT();
t.setVisible(true);
this.setVisible(false);   }


//“OLD  CUSTOMER” button://

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
PROJECT t=new PROJECT();
t.setVisible(true);
this.setVisible(false);       
    }

//“UPDATE  RECORDS” button://

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    fu t=new fu();
    t.setVisible(true);
    this.setVisible(false);      
    }


//“ABOUT” button://

private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {                                         
fab t=new fab();
t.setVisible(true);
this.setVisible(false);      
}


//“HELP” button://

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
fh t=new fh();
t.setVisible(true);
this.setVisible(false);
}


//“EXIT” button://

private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {                                         
System.exit(0);
}






//*************************//
//“PROJECT” Frame (PROJECT.java)//
//*************************//




//“ADD  TO  DATABASE” button://

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         

          String Name=jTextField1.getText();
          String Mobile=jTextField2.getText();
          String Email=jTextField3.getText();

          /* CHECK IF Any of the VARIABLE is EMPTY AND ACCORDINGLY display an appropriate ERROR MESSAGE*/
          if (Name.isEmpty())
              jOptionPane1.showMessageDialog(this,"NAME IS NOT ENTERED");
          else if (Mobile.isEmpty())
              jOptionPane1.showMessageDialog(this,"MOBILE No. is NOT ENTERED");
          else if (Email.isEmpty())
              jOptionPane1.showMessageDialog(this,"Email ID is NOT ENTERED");
          else
          { try
            {
                Class.forName("java.sql.DriverManager");
                Connection con=(Connection)
                        DriverManager.getConnection("jdbc:mysql://localhost:3306/CBSE", "root", "1111");
                Statement stmt=(Statement) con.createStatement();
                String query="INSERT INTO Customer VALUES ('"+Name+"','"+Mobile+"','"+Email+"');";
                stmt.executeUpdate(query);
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");


            }
            catch (Exception e)
            {
                jOptionPane1.showMessageDialog(this, e.getMessage());
            }


//“SEARCH  IN  DATABASE” button://

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // search the table to find a record matching the input MOBILE No.
        String Mobile=jTextField4.getText();
        if (Mobile.isEmpty())
            //EXECUTE THIS PART IF TEXT FIELD IS BLANK
        {
            jTextField5.setText("");
            jTextField6.setText("");
            jOptionPane1.showMessageDialog (this,"Plz enter the Mobile No.");

        }
        //this part is executed if a Mobile No. is INPUT in the text Field
        else
        {
            try
            {
                Class.forName("java.sql.DriverManager");
                Connection con=(Connection)
                        DriverManager.getConnection("jdbc:mysql://localhost:3306/CBSE","root","1111");
                Statement stmt=(Statement) con.createStatement();
                String query="SELECT NAME,EMAIL FROM Customer WHERE MOBILE='"+Mobile+"';";
                ResultSet rs=stmt.executeQuery(query);
                if (rs.next())
                {
                 String Name =rs.getString("Name");
                 //RETRIEVE THE NAME
                 String Email=rs.getString("Email");
                 //RETRIEVE THE EMAIL ID
                 jTextField5.setText(Name);
                 jTextField6.setText(Email);
                }
                //THIS PART IS EXECUTED IF NO MATCHING RECORD IS FOUND
                else
                    jOptionPane1.showMessageDialog(this,"SORRY! NO SUCH MOBILE No.");
            }
            catch (Exception e)
            {
                jOptionPane1.showMessageDialog(this, e.getMessage());
            }
        }
    }    



//“BACK” button://

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
frame1 t=new frame1();
t.setVisible(true);
this.setVisible(false);  
}


//“FORWARD” button://

private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
p2 t=new p2();
t.setVisible(true);
this.setVisible(false); 
}


//“EXIT” button://

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
System.exit(0);
}





//*************************//
//“Update” Frame (fu.java)//
//*************************//


//“BACK” button://

Private void jButton3ActionPerformed (java.awt.event.ActionEvent evt) {                                         
frame1 t=new frame1();
t.setVisible(true);
this.setVisible(false);
}                            


//“EXIT” button://

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
System.exit(0);
}                                        

//“LOAD RECORD” button://

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
try{
    Class.forName("java.sql.DriverManager");
    Connection con=(Connection)
            DriverManager.getConnection("jdbc:mysql://localhost/CBSE","root","1111");
    Statement stmt=con.createStatement();
    String query="SELECT * FROM Customer WHERE Mobile="+jTextField1.getText()+";";
    ResultSet rs=stmt.executeQuery(query);
    if (rs.next()){
        String Mobile=rs.getString("Mobile");
        String Name=rs.getString("Name");
        String Email=rs.getString("Email");
        jTextField2.setText(Name);
        jTextField3.setText(Email);
        jButton2.setEnabled(true);

    }
    else {
        jOptionPane1.showMessageDialog(null, "NO SUCH RECORD FOUND.");
    }
}catch (Exception e) {
    jOptionPane1.showMessageDialog(null, "error");

    }
    }     


//“UPDATE RECORD” button://

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
try{
    Connection con=(Connection)
            DriverManager.getConnection("jdbc:mysql://localhost/CBSE","root","1111");
    Statement stmt=con.createStatement();
    String query="UPDATE Customer SET Name='"+jTextField2.getText()+"', Email='"+jTextField3.getText()+"' WHERE Mobile="+jTextField1.getText()+";";
    stmt.executeUpdate(query);
    jOptionPane1.showMessageDialog(null, "RECORD SUCCESSFULLY UPDATED.");
}
catch (Exception e) {
    jOptionPane1.showMessageDialog(null, "error in updation");
}

jTextField1.setText("");
jTextField2.setText("");
jTextField3.setText("");
jButton2.setEnabled(false);
    }





//*************************//
//“About” Frame (fab.java)//
//*************************//



//“BACK” button:

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
frame1 t=new frame1();
t.setVisible(true);
this.setVisible(false);
} 

//“VERSION” button:

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
vrsn t=new vrsn();
t.setVisible(true);
this.setVisible(false);           
}                        

                
//“DEVELOPER’S INFORMATION” button:

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
dvlp t=new dvlp();
t.setVisible(true);
this.setVisible(false);            
}                                        
              

//“CONTACT US” button:

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
cnt t=new cnt();
t.setVisible(true);
this.setVisible(false);           
}




//*************************//
//”Version” Frame (vrsn.java)//
//*************************//


//“BACK” button:

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
fab t=new fab();
t.setVisible(true);
this.setVisible(false);   
  }


//*************************//
//“Developer” Frame (dvlp.java)//
//*************************//


//“BACK” button:

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
fab t=new fab();
t.setVisible(true);
this.setVisible(false);
}



//*************************//
//“Contact” Frame (cnt.java)//
//*************************//


//“BACK” button:
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
fab t=new fab();
t.setVisible(true);
this.setVisible(false);
}



//*************************//
//“Help” Frame (fh.java)//
//*************************//


//“BACK” button:
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                          frame1 t=new frame1();
t.setVisible(true);
this.setVisible(false);
}

//*************************//
//“Bill” Frame (p2.java)//
//*************************//



//“SEARCH  IN  DATABASE” button :
Private void jButton1ActionPerformed (java.awt.event.ActionEvent evt) {                                         
//Search the database in MySQL to find a record matching
//the INPUT Product Code
        String pcode=jTextField1.getText();
        if (pcode.isEmpty())
//EXECUTE this part if the TEXT FIELD IS BLANK
        {
          jLabel5.setText("");
          jLabel7.setText("");
          jOptionPane1.showMessageDialog(this, "enter the product code");
        }
//THIS PART IS EXECUTED IF A pcode is INPUT in the TextField
        else
        {
            try
            {
                Class.forName("java.sql.DriverManager");
                Connection con=(Connection)
                        DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/CBSE", "root", "1111");
                Statement stmt= (Statement) con.createStatement();
                String query="SELECT PNAME,PRICE FROM PRODUCT WHERE PCODE='"+pcode+"';";
                ResultSet rs=stmt.executeQuery(query);
                if (rs.next())
                {
                    String pname=rs.getString("pname"); //RETRIEVE THE PRODUCT NAME
String price=rs.getString("price"); //RETRIEVE THE PRODUCT PRICE
jLabel5.setText(pname);
jLabel7.setText(price);}
//THIS PART IS executed IF NO MATCHING RECORD IS FOUND
else                  jOptionPane1.showMessageDialog(this, "SORRY! INVALID CODE");}
catch (Exception e){ jOptionPane1.showMessageDialog(this, e.getMessage()); }
}
}                                        

//“CONFIRM” button:
private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
int a=Integer.parseInt(jTextField2.getText());
float amt=a*Float.parseFloat(jLabel7.getText());
jLabel10.setText("" +amt);
jOptionPane1.showMessageDialog(rootPane, "you have ordered for" +a+ "items n ur bill is Rs." +amt);}

//“EXIT” button:
    private void jButton4ActionPerformed (java.awt.event.ActionEvent evt) {                                         
jOptionPane1.showMessageDialog(rootPane, "thank u for shopping @ LIFESTYLE");
System.exit(0);
}








