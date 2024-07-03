package yogesh;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Panel4 extends JPanel {
	Vector v = new Vector();
	JScrollPane sp1;
	JTable total_std=new JTable() ;
	DefaultTableModel model1;
		public Panel4() {
			setBackground(new Color(41, 40, 38));
			setLayout(null);
			setVisible(true);
			setSize(1400,700);

			sp1 = new JScrollPane(total_std);
			sp1.setBounds(50,30,1280,480);
			sp1.setVisible(false);

			JTableHeader h1 = total_std.getTableHeader();
			h1.setForeground(new Color(41, 40, 38));
			h1.setBackground(new Color(249, 211, 66));
			h1.setFont(new Font("Jester",1,24));	

			total_std.setForeground(new Color(249, 211, 66));
			total_std.setBackground(new Color(41, 40, 38));
			total_std.setFont(new Font("Jester",1,20));
			total_std.setRowHeight(40);

			add(sp1);
			
			getStdTableData();

		}
		public void getStdTableData()
		{
				try{
					model1 = new DefaultTableModel(new String[]{"Student ID","Student Name","Class","Room No", "Mobile No","Parents Mo No"}, 0);
					Statement st = DBConnection.connectDB();

					String sql="SELECT * FROM student";
					ResultSet rs = st.executeQuery(sql);
					while(rs.next())
					{
					    String id = rs.getString(1);
					    String name = rs.getString(2);
					    String cl =  rs.getString(3);
					    String room_no = rs.getString(4);
					    String mo_no = rs.getString(5);
					    String p_mo_no = rs.getString(6);


					    model1.addRow(new Object[]{id, name, cl, room_no, mo_no, p_mo_no});
					}
					total_std.setModel(model1);
					sp1.setVisible(true);
				}
				catch(Exception e){
					System.out.println(e);
				}
	   	}
}
