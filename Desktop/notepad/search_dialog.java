import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.Color;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

class search_dialog extends JDialog implements ActionListener
{
     int f[]=new int[100];			
	        notepad np;
		handle_search hs;
		
	 JDialog dialog;
	 JLabel find=new JLabel("Find What");
         JLabel replace_with=new JLabel("Replace With");

	 JTextField p=new JTextField();
         JTextField rw=new JTextField();

	 JButton find_next=new JButton("Find Next");
         JButton replace=new JButton("Replace");
	 JButton close=new JButton("Close");


      public search_dialog(notepad np,handle_search hs,String s)
	   {
		   
		 this.np=np;
		 this.hs=hs;
		 
               dialog=new JDialog(np);
		  find.setBounds(10,10,100,30);
                   p.setBounds(120,10,150,30);

                     if(s=="Replace") {
                            
		          replace_with.setBounds(10,50,120,30);
                          rw.setBounds(140,50,150,30);
                             
		          find_next.setBounds(30,120,100,30);
	                  replace.setBounds(180,120,100,30);
                          close.setBounds(300,120,100,30);

                         dialog.add(replace_with);
                         dialog.add(replace);
                         dialog.add(rw);
                       replace.addActionListener(this);
               }

                  else {
                                       
                         find_next.setBounds(30,70,100,30);
                          close.setBounds(160,70,100,30);
                    }

		  dialog.add(find);
		  dialog.add(p);
		  dialog.add(find_next);
		  dialog.add(close);

		  find_next.addActionListener(this);
		  close.addActionListener(this);
		 
       
		 
		  
         dialog.setTitle(s);
         dialog.setSize(420, 200);
         dialog.setLocationRelativeTo(np);
          dialog.setModal(true);
	 dialog.setLayout(null);
         dialog.setVisible(true);
		 
	 }

	  void prefix_table(char pattern[],int m)
	         {
	               	int i=1,j=0;
	     	         f[0]=0;
		while(i<m) {
		
			if(pattern[i]==pattern[j]){
				f[i]=j+1;
				i++;
				j++;
			}
			else if(j>0)
				j=f[j-1];
			else{
				f[i]=0;
				i++;
			}
				
		}
	}

      ArrayList<Integer> kmp(char input[],int n,char pattern[],int m)
	   {
		int i=0,j=0;
		prefix_table(pattern,m);
		ArrayList<Integer> ans=new ArrayList<Integer>();

		while(i<n){
			  if(input[i]==pattern[j]){
				  if(j==m-1) {
					  ans.add(i-j);			
					  j=0;
					  i++;
				  }
					  
				   else{
					   i++;
					   j++;
				   }
			  }
			  else if(j>0)
				  j=f[j-1];
			  else
				  i++;
		}
		return ans;
	}
// highlight given text
	
        public void highlight(String s3)
            {
                  ArrayList<Integer> ans=new ArrayList<Integer>();                       	 		    
	             String s=np.ta.getText();
		     char input[]=s.toCharArray();
		     int n=input.length;
		 
		    String s1=p.getText();
		    char pattern[]=s1.toCharArray();
		      int m=pattern.length;

                     
			// method call for searching 			   
		      ans=kmp(input,n,pattern,m);
	                 
                                       
                             Highlighter highlighter = np.ta.getHighlighter();
                             HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.pink);

                         if(ans.size()==0) 
                         { JOptionPane.showMessageDialog(null,"Can't Find given String"); }


                          else {  
 				Iterator itr=ans.iterator();                          
                                 while(itr.hasNext())
                                 {     
                                   int temp=(int)itr.next();                               
                                         try { highlighter.addHighlight(temp, temp+m,painter);}
                                           catch(Exception e){ }
                                 }


                 // condition for replace
 
                           if(s3=="replace")
                             {
                               String s2=rw.getText();
                                   int temp3=s2.length();

                                   int i=0;
                                     Iterator itr1=ans.iterator();
                                      while(itr1.hasNext())
                                      {   
                                             int temp=(int)itr1.next();  
                                             int temp1=temp3-m;                             
                                             np.ta.replaceRange(s2,temp+i*temp1,temp+m+i*temp1);

                                        try { highlighter.addHighlight(temp+i*temp1, temp+m+i*temp1+temp1,painter);}
					catch(Exception e1) {}
                                               i++;					   
  				     }
                                  
                             }
                         }
    }



   
	  public void actionPerformed(ActionEvent ae) {

		if(ae.getSource()==find_next)  		
	            highlight("find");
	         
		 if(ae.getSource()==replace)
                      highlight("replace");
		
		  if(ae.getSource()==close){	  
			    dialog.setVisible(false);
            			 
		    }
                
           			
	  }
	  


}
