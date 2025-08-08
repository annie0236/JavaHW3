package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import model.Porder;
import util.Tool;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddPorder extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField black;
	private JTextField latte;
	private JTextField mocha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPorder frame = new AddPorder();
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
	public AddPorder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 64, 64));
		panel.setBounds(22, 58, 360, 178);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Black ($50):");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel.setBounds(33, 24, 84, 18);
		panel.add(lblNewLabel);
		
		JLabel lblRam = new JLabel("Latte ($100):");
		lblRam.setFont(new Font("新細明體", Font.BOLD, 14));
		lblRam.setBounds(33, 52, 84, 18);
		panel.add(lblRam);
		
		JLabel lblMouse = new JLabel("Mocha ($120):");
		lblMouse.setFont(new Font("新細明體", Font.BOLD, 14));
		lblMouse.setBounds(33, 80, 92, 18);
		panel.add(lblMouse);
		
		black = new JTextField();
		black.setBounds(149, 23, 96, 21);
		panel.add(black);
		black.setColumns(10);
		
		latte = new JTextField();
		latte.setBounds(149, 51, 96, 21);
		panel.add(latte);
		latte.setColumns(10);
		
		mocha = new JTextField();
		mocha.setBounds(149, 79, 96, 21);
		panel.add(mocha);
		mocha.setColumns(10);
		
		
		
		
		JLabel showMember = new JLabel("");
		showMember.setFont(new Font("新細明體", Font.BOLD, 17));
		showMember.setBounds(51, 10, 331, 49);
		contentPane.add(showMember);
		
		Member m=(Member)Tool.readFile("member.txt");
		
		String show="會員:"+m.getName();
		
		showMember.setText(show);
		
		
		JButton btnNewButton = new JButton("確定");              //Button Clicked
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.擷取->black,latte,mocha-->轉型-->int
				 * 2.new Porder();
				 * 3.Tool-->porder.txt
				 * 4.切換到-->Confirm
				 */
				int Black=Integer.parseInt(black.getText());
				int Latte=Integer.parseInt(latte.getText());
				int Mocha=Integer.parseInt(mocha.getText());
				
				Porder p=new Porder(m.getName(),Black,Latte,Mocha);
				Tool.saveFile(p, "porder.txt");
				
				Confirm confirm=new Confirm();
				confirm.setVisible(true);
				dispose();
				
				
			}
		});
		btnNewButton.setBounds(47, 127, 198, 23);
		panel.add(btnNewButton);
		
		

	}
}
