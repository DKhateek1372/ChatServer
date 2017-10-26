import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class handle_search implements ActionListener
{
	notepad np;
	public handle_search (notepad np)
	{
		this.np=np;
	}
	
	public void actionPerformed(ActionEvent ae)
	{
                String s;
		if(ae.getSource()==np.find) {
                    s="Find"; 
		   search_dialog ss =new search_dialog(np,this,s);
		}
             
               if(ae.getSource()==np.replace) {
                   s="Replace";
                  search_dialog ss =new search_dialog(np,this,s);
	         }
	}
}
