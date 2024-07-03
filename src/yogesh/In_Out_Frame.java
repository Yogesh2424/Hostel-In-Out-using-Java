package yogesh;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class In_Out_Frame extends JFrame {
	private JPanel contentPane;
	String top=" Hostel Management System , GP Jalgaon";
	JLabel Jtop= new JLabel();

	/**
	 * Launch the application for hotel.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					In_Out_Frame frame = new In_Out_Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public In_Out_Frame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\xampp\\htdocs\\Hostel_In_Out\\logo.png"));
		setTitle("Hostel In Out");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tp = new JTabbedPane(JTabbedPane.TOP);

		Panel1 p1 = new Panel1();
		Panel2 p2 = new Panel2();
		Panel3 p3 = new Panel3();
		Panel4 p4 = new Panel4();
		JLabel l6 = new JLabel("GOVERNMENT POLYTECHNIC , GPJ");

		JLabel img = new JLabel(new ImageIcon("C:\\xampp\\htdocs\\Hostel_In_Out\\logo.png"));
		setVisible(true);
		setBounds(50,20,1400,800);
		getContentPane().setLayout(null);

        tp.addTab("Check Student",p1);
        tp.addTab("Register Student",p2);
        tp.addTab("In/Out Status",p3);
        tp.addTab("Total Number Of Student",p4);
		tp.setBounds(0,200,1400,700);
		tp.setFont(new Font("Jester",2,20));
		tp.setForeground(new Color(41, 40, 38));
		tp.setBackground(new Color(249, 211, 66));

		JPanel pan = new JPanel();
		pan.setBounds(0,0,1400,150);
		pan.setLayout(null);
		pan.setBackground(new Color(255,204,51));
		
		
        Jtop.setBounds(0,150,1400,40);
        Jtop.setText(top);
        //Jtop.setBackground(new Color(26,82,118));
        Jtop.setForeground(new Color(41, 40, 38));
        Jtop.setFont(new Font("Jester",3,26));

		img.setBounds(0,0,150,150);
		l6.setBounds(450,30,700,100);
		l6.setForeground(new Color(41, 40, 38));
		l6.setFont(new Font("Jester",1,30));
		pan.add(l6);

		pan.add(img);
		getContentPane().add(pan);
		getContentPane().add(Jtop);
        getContentPane().add(tp);
        getContentPane().setBackground(new Color(249, 211, 66));
        t.start();
	}
	Thread t=new Thread()
	{
	  public void run()
	  {
		  int i=3;
	      while(true)
	      {
	      try {
	          Thread.sleep(80);
	      } catch (Exception ex) {}
	      Jtop.setLocation(Jtop.getX()+i,Jtop.getY());
	      if(Jtop.getX()>=1400){
			  Jtop.setLocation(i,Jtop.getY());
			}
	      }
	  }
	};
}
