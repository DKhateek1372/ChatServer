
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class savedialog extends JDialog implements ActionListener
{
     handle_file hf;
	 notepad np;
	
	JLabel label=new JLabel("Do you want to save file?");
	JButton save=new JButton("Save");
	JButton donotsave = new JButton("Donot Save");
	JButton cancel=new JButton("Cancel");
	
       JDialog dialog;
	public savedialog(notepad np,handle_file hf)
	{
	   this.hf=hf;	   
	   this.np=np;
	   
         dialog = new JDialog(np);
		dialog.add(label);
		dialog.add(save);
		dialog.add(donotsave);
		dialog.add(cancel);
         
		 label.setBounds(30,0 ,200,100);
		 save.setBounds(30,120,90,40);
		 donotsave.setBounds(140,120,120,40);
		 cancel.setBounds(280,120,90,40);
		   
        save.addActionListener(this);
		donotsave.addActionListener(this);
		cancel.addActionListener(this);
		
        dialog.setTitle("Notepad");
        dialog.setSize(400, 250);
        dialog.setLocationRelativeTo(np);
        dialog.setModal(true);
		dialog.setLayout(null);
        dialog.setVisible(true);
		
	}
   public void actionPerformed(ActionEvent ae1)
    {
		
	 if(ae1.getSource()==save)
	 {    
         hf.savefile();
         System.exit(0);
	 }
	 
	 if(ae1.getSource()==donotsave)
		 System.exit(0);
	 
	 if(ae1.getSource()==cancel)
		dialog.setVisible(false);
     }   
}