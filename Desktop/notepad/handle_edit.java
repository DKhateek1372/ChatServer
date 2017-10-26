
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
	
class handle_edit implements ActionListener
{
	   notepad np;
	   String s;
	  handle_edit(notepad np)
	  {
		  this.np=np;
	  }
     public void actionPerformed(ActionEvent ae)
	   { 
	      if(ae.getSource()==np.selectall)
	         np.ta.selectAll();
		   if(ae.getSource()==np.delete)
		   {
			   s=np.ta.getSelectedText();
			   np.ta.setText(np.ta.getText().replace(s,""));
			  
		   }
	   }
}