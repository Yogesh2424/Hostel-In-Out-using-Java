package yogesh;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panel1 extends JPanel implements ActionListener {
	
	/**
	 * Create the panel.
	 */
	JTextField tf1 = new JTextField();
	JButton in = new JButton("CHECK IN");
	JButton out = new JButton("CHECK OUT");
	JButton view = new JButton("View");
	JLabel l1 = new JLabel("Enter student id :- ");

	JLabel l2 = new JLabel("");// yogesh gend roll no: 24
	JLabel l3 = new JLabel("");
	JLabel l4 = new JLabel("");
	JLabel img = new JLabel();
	JComboBox reason;
	Vector v = new Vector();
	String sName,sClass;
	public Panel1() {
			setBackground(new Color(41, 40, 38));
			//setVisible(true);
					//setBounds(200,100,1400,700);
					setLayout(null);
					setVisible(true);

					l1.setBounds(120,50,170,30);
					l1.setForeground(new Color(249, 211, 66));
					l1.setFont(new Font("Jester",3,20));

					tf1.setBounds(300,50,170,30);
					tf1.setFont(new Font("Jester",2,20));
					//tf1.addActionListener(this);

					view.setBounds(200,130,150,30);
					view.setForeground(new Color(41, 40, 38));
					view.setBackground(new Color(249, 211, 66));
					view.setFont(new Font("Jester",1,20));
					view.addActionListener(this);

					in.setBounds(730,370,200,30);
					in.setForeground(new Color(41, 40, 38));
					in.setBackground(new Color(249, 211, 66));
					in.setFont(new Font("Jester",1,20));
					in.setVisible(false);

					out.setBounds(980,370,200,30);
					out.setForeground(new Color(41, 40, 38));
					out.setBackground(new Color(249, 211, 66));
					out.setFont(new Font("Jester",1,20));
					out.setVisible(false);

					reason = new JComboBox(v);
					reason.setBounds(850,300,200,30);
					reason.setForeground(new Color(41, 40, 38));
					reason.setBackground(new Color(249, 211, 66));
					reason.setFont(new Font("Jester",1,20));
					reason.setVisible(false);

					img.setBounds(700,70,150,200);

					l2.setBounds(920,120,450,30);
					l2.setFont(new Font("Jester",1,24));
					l2.setForeground(new Color(249, 211, 66));

					l3.setBounds(920,150,170,30);
					l3.setFont(new Font("Jester",1,24));
					l3.setForeground(new Color(249, 211, 66));

					l4.setBounds(920,180,150,30);
					l4.setFont(new Font("Jester",1,24));
					l4.setForeground(new Color(249, 211, 66));

					in.addActionListener(new inOutHandler());

					out.addActionListener(new inOutHandler());

					v.add("Go To Home");
					v.add("Go To Class");
					v.add("Go To Shopping");


					add(tf1);
					add(l1);
					add(in);
					add(out);
					add(reason);
					add(view);
					add(img);
					add(l2);
					add(l3);
					add(l4);

	}
	public void actionPerformed(ActionEvent e)
	{
		String sId = tf1.getText();
		try{
				Statement stat = DBConnection.connectDB();
				System.out.println("Statement Object Is created");
				ResultSet rs = stat.executeQuery("select * from student where s_id ='"+sId+"'");
				rs.next();
				//System.out.println(sql);
				String name = "Name :- "+rs.getString(2);
				String cl = "Class :- "+rs.getString(3);
				String rNo = "Room No:- "+rs.getString(4);
				sName = rs.getString(2);
				sClass =rs.getString(4);
				rs.close();
				l2.setText(name);
				l3.setText(rNo);
				l4.setText(cl);
				System.out.println(sId);


				File input = new File("C:\\xampp\\htdocs\\Hostel_In_Out\\Student\\"+sId+".png");
				//File input= new File("D:\\hostel_in_out\\"+sId+".png");
                BufferedImage image = ImageIO.read(input);
                ImageIcon ic = new ImageIcon(image);
                img.setIcon(ic);
                in.setVisible(true);
                out.setVisible(true);
                reason.setVisible(true);


			}
			catch(Exception ex){
					System.out.println(ex);
			}

	}
	class inOutHandler implements ActionListener
	{

			public void actionPerformed(ActionEvent e)
			{
				String cmd = e.getActionCommand();

				if(cmd.equals("CHECK OUT"))
				{
					//System.out.println("hiii");
					try{

							Statement stat = DBConnection.connectDB();

							String sId = tf1.getText();
							//System.out.println(java.time.LocalDate.now());
							//System.out.println(java.time.LocalTime.now());
							//String sql="Select * from temp where s_id='"+sId+"'";
							stat.execute("INSERT INTO temp_view(s_id,s_name,s_class,s_out_time,s_out_date,reason) VALUES ('"+sId+"','"+sName+"','"+sClass+"','"+java.time.LocalTime.now()+"','"+java.time.LocalDate.now()+"','"+reason.getSelectedItem()+"')");
							JOptionPane.showMessageDialog(null,"Student Is Checkout For "+reason.getSelectedItem());
				   }
				   catch(Exception ex){
					   System.out.println(ex);
				   }



				}
				else if(cmd.equals("CHECK IN"))
				{
					try{
						Statement stat = DBConnection.connectDB();
						String sId = tf1.getText();
						try{
							ResultSet rs = stat.executeQuery("Select * from temp_view where s_id='"+sId+"'");
							rs.next();
							String name = rs.getString(2);
							String sClass = rs.getString(3);
							String check_out_time = rs.getString(4);
							String check_out_date = rs.getString(5);	
							String reason = rs.getString(6);
							stat.execute("INSERT INTO fix_view (s_id,s_name,s_class,s_out_time,s_out_date,s_in_time,s_in_date,reason) VALUES ('"+sId+"','"+name+"','"+sClass+"','"+check_out_time+"','"+check_out_date+"','"+java.time.LocalTime.now()+"','"+java.time.LocalDate.now()+"','"+reason+"')");

							rs.close();
							l2.setText("");
							l3.setText("");
							l4.setText("");
							img.setIcon(null);
							tf1.setText("");
							boolean b=stat.execute("Delete from temp_view where s_id = '"+sId+"'");
							if(b) {
								JOptionPane.showMessageDialog(null,"This Student Is Check In at "+java.time.LocalTime.now());
							}

						}
						catch(Exception exc){
							System.out.println(exc);
							JOptionPane.showMessageDialog(null,"This Student Is Not Check Out");
						}
					}
					catch(Exception ex){
						System.out.println(ex);
					}

				}

			}
	}

}
