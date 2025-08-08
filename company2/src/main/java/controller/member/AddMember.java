package controller.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import service.impl.MemberServiceImpl;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddMember extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField address;
	private JTextField phone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMember frame = new AddMember();
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
	public AddMember() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 64, 64));
		panel.setBounds(47, 20, 381, 44);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("會員基本資料");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel.setBounds(138, 10, 99, 24);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 64, 64));
		panel_1.setBounds(47, 74, 381, 319);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("姓名:");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel_1.setBounds(43, 30, 46, 23);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("帳號:");
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(43, 73, 46, 23);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("密碼:");
		lblNewLabel_1_2.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(43, 119, 46, 23);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("地址:");
		lblNewLabel_1_3.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(43, 157, 46, 23);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("電話:");
		lblNewLabel_1_4.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel_1_4.setBounds(43, 199, 46, 23);
		panel_1.add(lblNewLabel_1_4);
		
		name = new JTextField();
		name.setBounds(142, 31, 96, 21);
		panel_1.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setBounds(142, 74, 96, 21);
		panel_1.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(142, 120, 96, 22);
		panel_1.add(password);
		password.setColumns(10);
		
		address = new JTextField();
		address.setBounds(142, 158, 96, 21);
		panel_1.add(address);
		address.setColumns(10);
		
		phone = new JTextField();
		phone.setBounds(142, 200, 96, 21);
		panel_1.add(phone);
		phone.setColumns(10);
		
		JLabel errorMessage = new JLabel("");
		errorMessage.setFont(new Font("新細明體", Font.BOLD, 15));
		errorMessage.setBounds(142, 231, 159, 53);
		panel_1.add(errorMessage);
		
		JButton btnNewButton = new JButton("註冊");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String Name=name.getText();
				String UserName=username.getText();
				String Password=password.getText();
				String Address=address.getText();
				String Phone=phone.getText();
				
				Member member=new Member(Name,UserName,Password,Address,Phone);
				
				if(new MemberServiceImpl().addMember(member))
				{
					AddMemberSuccess addMembersuccess=new AddMemberSuccess();
					addMembersuccess.setVisible(true);
					dispose();
					
				}
				else
				{
					errorMessage.setText("帳號重複");
				}
			
			}
		});
		btnNewButton.setBounds(43, 249, 87, 23);
		panel_1.add(btnNewButton);
		
		

	}

}
