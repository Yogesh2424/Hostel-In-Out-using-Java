package yogesh;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Panel3 extends JPanel implements ActionListener {

	/**
	 * Create the panel.
	 */
	JComboBox status;
	Vector v = new Vector();
	JScrollPane sp1,sp2;
	JTable tb_out=new JTable() ;
	JTable tb_in_out=new JTable() ;
	DefaultTableModel model1,model2;
		public Panel3() {
			setBackground(new Color(41, 40, 38));
			setLayout(null);
			setVisible(true);
			setSize(1400,700);

			v.add("Check Out Status");
			v.add("Today CheckIn Status");

			status = new JComboBox(v);
			status.setBounds(30,30,250,30);
			status.setForeground(new Color(41, 40, 38));
			status.setBackground(new Color(249, 211, 66));
			status.setFont(new Font("Jester",1,20));
			status.addActionListener(this);


			sp1 = new JScrollPane(tb_out);
			sp1.setBounds(320,30,1000,480);
			sp1.setVisible(false);

			sp2 = new JScrollPane(tb_in_out);
			sp2.setBounds(320,30,1000,480);
			sp2.setVisible(false);

			JTableHeader h1 = tb_out.getTableHeader();
			h1.setForeground(new Color(41, 40, 38));
			h1.setBackground(new Color(249, 211, 66));
			h1.setFont(new Font("Jester",1,24));

			JTableHeader h2 = tb_in_out.getTableHeader();
			h2.setForeground(new Color(41, 40, 38));
			h2.setBackground(new Color(249, 211, 66));
			h2.setFont(new Font("Jester",1,24));
	

			tb_out.setForeground(new Color(249, 211, 66));
			tb_out.setBackground(new Color(41, 40, 38));
			tb_out.setFont(new Font("Jester",1,20));
			tb_out.setRowHeight(40);

			tb_in_out.setForeground(new Color(249, 211, 66));
			tb_in_out.setBackground(new Color(41, 40, 38));
			tb_in_out.setFont(new Font("Jester",1,20));
			tb_in_out.setRowHeight(40);

			add(status);
			add(sp1);
			add(sp2);

		}
		public void actionPerformed(ActionEvent ex)
		{
			String cmd = (String)status.getSelectedItem();
			if(cmd.equals("Check Out Status"))
			{
				try{
					model1 = new DefaultTableModel(new String[]{"Student ID","Student Name","Class","Check out time", "Check out date","Reason"}, 0);
					Statement st = DBConnection.connectDB();

					String sql="SELECT * FROM temp_view";
					ResultSet rs = st.executeQuery(sql);
					while(rs.next())
					{
					    String id = rs.getString(1);
					    String name = rs.getString(2);
					    String cl =  rs.getString(3);
					    String o_time = rs.getString(4);
					    String o_date = rs.getString(5);
					    String reason = rs.getString(6);


					    model1.addRow(new Object[]{id, name, cl, o_time, o_date, reason});
					}
					tb_out.setModel(model1);
					sp1.setVisible(true);

					//JOptionPane.showMessageDialog(null,"Check Out Status");
				}
				catch(Exception e){
					System.out.println(e);
				}
			}
			else if(cmd.equals("Today CheckIn Status"))
			{
				try{
						model2 = new DefaultTableModel(new String[]{"Student ID","Student Name","Class","Check out time", "Check out date","Check in time","Check in date","Reason"}, 0);
						Statement st = DBConnection.connectDB();

						String sql="SELECT * FROM fix_view";
						ResultSet rs = st.executeQuery(sql);

						while(rs.next())
						{
						    String id = rs.getString(1);
						    String name= rs.getString(2);
						    String cl = rs.getString(3);
						    String o_time = rs.getString(4);
						    String o_date = rs.getString(5);
						    String i_time = rs.getString(6);
						    String i_date = rs.getString(7);
						    String reason = rs.getString(8);

						    model2.addRow(new Object[]{id ,name ,cl ,o_time ,o_date ,i_time ,i_date ,reason});
						}
						tb_out.setModel(model2);
						sp2.setVisible(true);
						//JOptionPane.showMessageDialog(null,"Today CheckIn CheckOut Status");
				}
				catch(Exception e){
					System.out.println(e);
				}
			}
	   	}
}
