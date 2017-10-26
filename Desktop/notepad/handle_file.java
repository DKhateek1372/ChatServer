import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.io.File;

class handle_file implements ActionListener
    {
		 notepad np1;
		  public static  String s;
		  public static  String s1;// for handle save function only once when saving one file multiple times
		 File f;
		 static int flag=0;
          handle_file(notepad np1)
           {
		   this.np1=np1;         
		     s="";
		     s1="";
		   	 f=new File("");	            	  
	       }	
		 
		 
		// create a new file
  
             public void newfile()
			 {
		       np1.frame.setTitle("Notepad");	
		       np1.ta.setText("");
		        flag=0;
			    f=new File(" ");	 
			 }

			 
			 
           // implement save function
		   
		   public void savefile()
		   {
			      s=np1.ta.getText();
				  
				     	if(flag==0){	
                           JFileChooser fileChooser = new JFileChooser();
		                  fileChooser.setDialogTitle("Save");					 					
                         int userSelection = fileChooser.showSaveDialog(fileChooser);		
		                 if(userSelection == JFileChooser.APPROVE_OPTION) {
			     	        f=fileChooser.getSelectedFile();
						     flag++;
							 s1=f.getAbsolutePath();
                             
                             try {
                               FileWriter fw = new FileWriter(s1);
                               fw.write(s);
                               fw.close();						  
                              } 
			                   catch (Exception ex) {
                                 ex.printStackTrace();
		                        }
      		           		           	  
                            np1.frame.setTitle(s1+"- Notepad");	
						
					     }
					 }
                    else
					{
						try {
                               FileWriter fw = new FileWriter(s1);
                               fw.write(s);
                               fw.close();						  
                              } 
			                   catch (Exception ex) {
                                 ex.printStackTrace();
		                        }	
					}
		
                        	
		   }
    		 

			 
	  // implements save as function
	  
	  public void  save_as()
	  {
		      s=np1.ta.getText();	 	             					
                     JFileChooser fileChooser = new JFileChooser();
		             fileChooser.setDialogTitle("Save");
					 
                     int userSelection = fileChooser.showSaveDialog(fileChooser);
					 
		                 if (userSelection == JFileChooser.APPROVE_OPTION) {
			     	          f=fileChooser.getSelectedFile();
							  s1=f.getAbsolutePath();
                                 try {
                                    FileWriter fw = new FileWriter(s1);
                                    fw.write(s);
                                    fw.close();						  
                                    } 
			                       catch (Exception ex) {
                                   ex.printStackTrace();
		                            }
									
                              np1.frame.setTitle(s1+"- Notepad");		
                               							  
					        }
	   }
	   

	   // implement open function
	    
		public void open()
		{
			
			JFileChooser fileChooser = new JFileChooser();
								fileChooser.setDialogTitle("Open");
				 
								int userSelection = fileChooser.showOpenDialog(fileChooser);
				 
								if (userSelection == JFileChooser.APPROVE_OPTION) {
								File f=fileChooser.getSelectedFile();
				 
								try {
						                   s1=f.getAbsolutePath();
										FileReader fr=new FileReader(f);
										BufferedReader br = new BufferedReader(fr);                                                 
										//Read br and store a line in 'data', print data
										String data=" ",temp=" ";
						
										while((temp=br.readLine())!= null)                    
										data = data+temp+"\n";                                    
					 
										np1.ta.setText(data);
										fr.close();
										br.close();
									}   
									catch (Exception ex) {
									ex.printStackTrace();
									}
                                   flag++;	
                                 	 np1.frame.setTitle(s1+"- Notepad");								
								}
		}
	     
		 
		 // exit from application
		 
		 public void exit()
		 {
				 if(s.equals(np1.ta.getText()))
					System.exit(0); 						 
				  else	
				  { savedialog sd=new savedialog(np1,this);	 } 
			 
		 }
      public void actionPerformed(ActionEvent ae)
	     {
		  if(ae.getSource()==np1.New)
			   newfile();
		  
	       if(ae.getSource()==np1.Save) 			 			      			        			   
			  savefile();      										
			        
		    if(ae.getSource()==np1.Open)			         
			  open();	
            
            if(ae.getSource()==np1.Saveas)					 
			   save_as();		          
            
             if(ae.getSource()==np1.Exit)
				  exit();				 
        			
	    }
   	
	}