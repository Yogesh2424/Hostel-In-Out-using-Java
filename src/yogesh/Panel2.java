package yogesh;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Panel2 extends JPanel implements ActionListener {
	/**
	 * Create the panel.
	 */

	String sId;
	String[] label={"Enter Name :-","Enter Class :-","Room No :-","Mobile Number :-","Parents Mobile No. :-","Select an Image :-"};
	JTextField name = new JTextField(20);
	JTextField cl = new JTextField(20);
	JTextField rNo = new JTextField(20);
    JTextField moNo = new JTextField(20);
    JTextField pMoNo = new JTextField(20);
	JLabel l = new JLabel("");
    JButton btn = new JButton("RAGISTER STUDENT");
    JButton sImg = new JButton("Choose Image");


	Font f1 = new Font("Jester",3,24);
	Font f2 = new Font("Jester",2,20);

	Color c1 = new Color(41, 40, 38);
	public Panel2() {
		setBackground(new Color(41, 40, 38));
		setLayout(null);
		setVisible(true);
		setSize(1400,700);

		JPanel p1 = new JPanel();
		p1.setBounds(410,40,580,480);
		p1.setLayout(null);
		p1.setBorder(BorderFactory.createRaisedBevelBorder());

		int j = 30;
		for(int i=0;i<label.length;i++)
		{
			JLabel l = new JLabel(label[i]);
			l.setBounds(20,j,230,30);
			l.setForeground(c1);
			l.setFont(f1);
			p1.add(l);
			j = j+60;
		}

		name.setBounds(320,30,200,30);
		name.setFont(f2);

		cl.setBounds(320,90,200,30);
		cl.setFont(f2);

		rNo.setBounds(320,150,200,30);
		rNo.setFont(f2);

		moNo.setBounds(320,210,200,30);
		moNo.setFont(f2);

		pMoNo.setBounds(320,270,200,30);
		pMoNo.setFont(f2);

		sImg.setBounds(320,330,200,30);
		sImg.setFont(f2);
		//sImg.setForeground(new Color(26,82,118));
		//sImg.setBackground(new Color(255,255,255));
		sImg.addActionListener(this);
		l.setBounds(320,360,200,30);
		l.setForeground(new Color(249, 211, 66));
		l.setFont(new Font("Jester",2,16));

		btn.setBounds(170,400,250,40);
		btn.setForeground(new Color(249, 211, 66));
		btn.setBackground(new Color(41, 40, 38));
		btn.setFont(new Font("Jester",1,20));
		btn.addActionListener(this);

		p1.setBackground(new Color(249, 211, 66));

		p1.add(name);
		p1.add(cl);
		p1.add(rNo);
		p1.add(moNo);
		p1.add(pMoNo);
		p1.add(btn);
		p1.add(sImg);
		p1.add(l);
		add(p1);

	}
	public void actionPerformed(ActionEvent e)
	{
		String cmd = e.getActionCommand();
		try{
			Statement stat = DBConnection.connectDB();
			//System.out.println("Statement Object Is created");
			ResultSet rs = stat.executeQuery("SELECT COUNT(s_id) FROM student");
			rs.next();
			int id = Integer.parseInt(rs.getString(1));
			//System.out.println(rs.getString(1));
			sId ="S"+(id+1);
			rs.close();
		}
		catch(Exception exc){
		}

		if(cmd.equals("Choose Image"))
		{
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File("D:\\Y Trip"));
				chooser.setMultiSelectionEnabled(false);
				FileFilter filter = new FileNameExtensionFilter("Image Files","jpg","png","jpeg","gif","jfif");
				chooser.setFileFilter(filter);

				int a = chooser.showOpenDialog(this);

				if(a==JFileChooser.APPROVE_OPTION)
				{
					File file = chooser.getSelectedFile();
					ImageIcon icon = new ImageIcon(file.getPath());
					String str = file.getName();
					l.setText(str);
					try{
						//System.out.println(sId);
						ResizeImage img = new ResizeImage(file,sId);
					}
					catch(Exception ex){
						System.out.println(ex);
					}


				}
		}
		else if(cmd.equals("RAGISTER STUDENT"))
		{
			try{
				Statement stat = DBConnection.connectDB();
			   //System.out.println("Statement Object Is created");
				String sql="insert into student values('"+sId+"','"+name.getText()+"','"+cl.getText()+"',"+rNo.getText()+","+moNo.getText()+","+pMoNo.getText()+")";
				//System.out.println(sql);
				stat.execute(sql);
				String msg="Unique Identity of "+name.getText()+" is "+sId;
				JOptionPane.showMessageDialog(null,msg);
				name.setText("");
				cl.setText("");
				rNo.setText("");
				moNo.setText("");
				pMoNo.setText("");
				l.setText("");

			}
			catch(Exception ex){
				System.out.println(ex);
			}


		}
   }
}
