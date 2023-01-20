import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class BookInternationalFlight extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private String visa="0";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		BookInternationalFlight frame = new BookInternationalFlight();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public BookInternationalFlight() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 872, 433);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("International Flight Schedule");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 764, 23);
		contentPane.add(lblNewLabel);
		
		String[] columns = {"Flight ID", "Time", "Date", "Daparture Destination",
                "Land Destination" , "Economy Seats" , "Business Seats" , "Time Duration"};

		DefaultTableModel obj=new DefaultTableModel(columns,0);
        
		sqlconnect connection = new sqlconnect();
		Connection con = connection.connect();
		Statement st=null;
		String query="select * from intflights";
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
			        Object[] update= {rs.getString(1) , rs.getString(2) , rs.getString(3)
			        			, rs.getString(4), rs.getString(5) , 
			        			rs.getString(6) , rs.getString(7) , rs.getString(8)};
			        
			    	obj.addRow(update);
			}
		}catch(Exception i) {
			System.out.println(i);
		}
	    
	    table = new JTable(obj);
	    JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 39, 764, 200);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("Cancel Flight");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for (Passengers x: SignUP.PassengerList)
				{
					if (x.getUsername().equals(SignUP.username.getText()))
					{
						if (x.getBooked()==true)
						{
							double hour=Integer.valueOf((String) table.getModel().getValueAt(table.getSelectedRow(), 7));
							
							double cost=(hour*10000)+((hour*10000)*5/100);
							JOptionPane.showMessageDialog(null, "Your flight has been cancelled successfully with a penalty of "+ (cost*25/100));
							SignUP.PassengerList.get(0).setBooked(false);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Please book your flight first.");
						}
					}
				}
				
				
			}
		});
		btnNewButton.setBounds(249, 250, 112, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Book Flight");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRowCount()==1)
				{
					String visachoice= JOptionPane.showInputDialog(null,"Enter Y for having Visa and N for having no Visa",null);
					if(visachoice.equals("N")) {
						JOptionPane.showMessageDialog(null,"Sorry you can't book a flight");
					}
					else if(visachoice.equals("Y")){
						String userchoice= JOptionPane.showInputDialog(null,"Enter 1 for Economy class and 2 for Business Class",null);
						
					
					int slctClass = Integer.valueOf(userchoice);
						
						switch (slctClass)
						{
							case 1:
							{
								JOptionPane.showMessageDialog(null, "Your flight has been booked!");
								break;
							}
							case 2:
							{
								JOptionPane.showMessageDialog(null, "Your flight has been booked!");
								
								break;
							}
							default:
							{
								JOptionPane.showMessageDialog(null, "You entered an invalid input. Try again");
								break;
							}
						}
					}
					else
					{
						System.out.println(visa);
						JOptionPane.showMessageDialog(null, "Please enter '1' or '2' only.");
					}
				}
				else if(table.getSelectedRowCount()==0)
				{
					JOptionPane.showMessageDialog(null, "Please select a flight to book.");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please select one flight at a time.");
				}
			}
		});
		btnNewButton_1.setBounds(127, 250, 111, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("View Ticket Price");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double hour=Integer.valueOf((String) table.getModel().getValueAt(table.getSelectedRow(), 7));
				
				double cost=(hour*20000)+((hour*20000)*10/100);
				JOptionPane.showMessageDialog(null, "The cost for this flight is: "+cost);
			}
		});
		btnNewButton_2.setBounds(371, 250, 131, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PassengerMenu obj=new PassengerMenu();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(543, 250, 112, 23);
		contentPane.add(btnNewButton_3);
	

}
}
