package Transport;

import java.awt.EventQueue;
import java.lang.Integer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import com.mysql.cj.protocol.a.NativeConstants.IntegerDataType;

public class Passenger {

	private JFrame frame;
	private JTextField pname;
	int Nt;
	int cost;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Passenger window = new Passenger();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Passenger() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 539, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("METRO TICKET BOOKING");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(149, 11, 292, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Passsenger Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(21, 64, 144, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("from");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(98, 113, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("to");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(98, 153, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("No.Of Tickets");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(43, 193, 122, 14);
		frame.getContentPane().add(lblNewLabel_4);
		JComboBox c1 = new JComboBox();
		c1.setModel(new DefaultComboBoxModel(new String[] {"LBNagar", "Balanagar", "JNTU", "Moosapet", "Erragada", "ECIL", "SRNagar"}));
		c1.setBounds(168, 111, 86, 22);
		frame.getContentPane().add(c1);
		
		JComboBox c2 = new JComboBox();
		c2.setModel(new DefaultComboBoxModel(new String[] {"LBNagar", "Balanagar", "JNTU", "Moosapet", "Erragada", "ECIL", "SRNagar"}));
		c2.setBounds(168, 151, 86, 22);
		frame.getContentPane().add(c2);
		JComboBox tickets = new JComboBox();
		tickets.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		tickets.setBounds(175, 191, 79, 22);
		frame.getContentPane().add(tickets);
		
		JButton btnNewButton = new JButton("BOOK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String from=(String) c1.getSelectedItem();
				String to=(String) c2.getSelectedItem();
				String name=pname.getText();
				String NoOfTickets=(String) tickets.getSelectedItem();
				Nt=Integer.parseInt(NoOfTickets);
				
				if(from.equals(to)) {
					JOptionPane.showMessageDialog(btnNewButton, "Error!");
				}
				else {
					 cost=Nt*50;
					JOptionPane.showMessageDialog(btnNewButton,cost);
					try {
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/it","root","welcome@123");
						String qry="insert into passenger values('"+name+"','"+from+"','"+to+"','"+NoOfTickets+"')";
						Statement stmt=con.createStatement();
						stmt.executeUpdate(qry);
						JOptionPane.showMessageDialog(btnNewButton, "done macha!");
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}}
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(226, 287, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		pname = new JTextField();
		pname.setBounds(168, 67, 86, 20);
		frame.getContentPane().add(pname);
		pname.setColumns(10);
		
		
		
		
	}
}
