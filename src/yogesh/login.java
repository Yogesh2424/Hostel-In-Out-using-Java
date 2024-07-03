package yogesh;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login {
	private JFrame frmHostelLogin;
	In_Out_Frame d ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frmHostelLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmHostelLogin = new JFrame();
		frmHostelLogin.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\xampp\\htdocs\\Hostel_In_Out\\logo.png"));
		frmHostelLogin.setTitle("Hostel Login ");
		frmHostelLogin.setBounds(50,20,1400,800);
		frmHostelLogin.getContentPane().setBackground(new Color(41, 40, 38));
		frmHostelLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHostelLogin.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(249, 211, 66));
		panel.setBounds(0,0,1400,150);
		frmHostelLogin.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon("C:\\xampp\\htdocs\\Hostel_In_Out\\logo.png"));
		lblNewLabel.setBounds(0,0,150,150);
		panel.add(lblNewLabel);
		
		JLabel lblGpj = new JLabel("GOVERNMENT POLYTECHNIC , Jalgaon");
		lblGpj.setFont(new Font("Jester", Font.BOLD, 30));
		lblGpj.setForeground(new Color(41, 40, 38));
		lblGpj.setBounds(450,30,700,100);
		panel.add(lblGpj);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(510,200,350,400);
		panel_1.setBackground(new Color(249, 211, 66));
		frmHostelLogin.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBorder(BorderFactory.createRaisedBevelBorder());
		
		JLabel l1 = new JLabel("Username :- ");
		l1.setFont(new Font("Jester",3,22));
		l1.setBounds(15,70,130,30);
		l1.setForeground(new Color(41, 40, 38));
		panel_1.add(l1);
		
		JLabel l2 = new JLabel("Password :- ");
		l2.setFont(new Font("Jester",3,22));
		l2.setBounds(15,150,130,30);
		l2.setForeground(new Color(41, 40, 38));
		panel_1.add(l2);
		
		JTextField tf1 = new JTextField(15);
		tf1.setBounds(155,70,170,30);
		tf1.setFont(new Font("Jester",2,20));
		tf1.setText("hostel_io");
		panel_1.add(tf1);
		
		JPasswordField tf2 = new JPasswordField(15);
		tf2.setBounds(155,150,170,30);
		tf2.setFont(new Font("Jester",2,20));
		tf2.setText("says24");
		panel_1.add(tf2);
		
		JButton btn = new JButton("SUBMIT");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String uName = tf1.getText();
				@SuppressWarnings("deprecation")
				String uPass = tf2.getText();
				if(uName.equals("hostel_io") && uPass.equals("says24"))
				{
					JOptionPane.showMessageDialog(null,"Login Successful");
					d = new In_Out_Frame();
					d.setVisible(true);
					frmHostelLogin.setVisible(false);

				}
				else
				{
					JOptionPane.showMessageDialog(null,"Login Unsccessful");
					tf1.setText("");
					tf2.setText("");
				}
			}
		});
		btn.setBounds(90,270,170,40);
		btn.setForeground(new Color(249, 211, 66));
		btn.setBackground(new Color(41, 40, 38));
		btn.setFont(new Font("Jester",1,20));
		panel_1.add(btn);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0,650,1400,110);
		frmHostelLogin.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(249, 211, 66));
		
		JPanel p4 = new JPanel();
		panel_2.add(p4);
		p4.setBounds(0,0,1400,50);
		p4.setBackground(new Color(249, 211, 66));
		
		JLabel l3 = new JLabel("Project Guide By :- H. K. Nemade Sir");
		l3.setForeground(Color.BLACK);
		l3.setFont(new Font("Jester",1,24));
		p4.add(l3);
		
		JPanel p5 = new JPanel();
		panel_2.add(p5);
		p5.setBounds(0,50,1400,40);
		p5.setBackground(new Color(249, 211, 66));
		
		JLabel l4 = new JLabel("Project By Students Of Information Technology :- Yogesh Gend, Apurva Khachane, Samrudhi Patil, Shivam koli");
		l4.setForeground(Color.BLACK);
		l4.setFont(new Font("Jester",1,22));
		p5.add(l4);
	}
}
