import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MainScreen extends JFrame {

	private JPanel contentPane;
	public static void main(String[] args) {
		MainScreen frame = new MainScreen();
		frame.setVisible(true);
	}
	public MainScreen() {
		JLabel background;
		ImageIcon img = new ImageIcon("background.png");
		background = new JLabel("",img,JLabel.CENTER);
		background.setBounds(100,0,400,400);
		getContentPane().add(background);
		//setBackground(Color.PINK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 451);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Airline Flight Management System ");
		lblNewLabel.setBackground(Color.PINK);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(81, 11, 414, 28);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModeSelection obj=new ModeSelection();
				obj.setVisible(true);
			}
		});
		btnNewButton.setBounds(241, 113, 148, 65);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(552, 277, 89, 23);
		contentPane.add(btnNewButton_1);
		
	}
}
