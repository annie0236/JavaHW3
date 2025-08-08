package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PorderManager extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PorderManager frame = new PorderManager();
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
	public PorderManager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 64, 64));
		panel.setBounds(72, 30, 328, 52);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("咖啡因 購物系統");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel.setBounds(109, 10, 141, 32);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 64, 64));
		panel_1.setBounds(72, 93, 328, 188);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("新增");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddPorder addporder=new AddPorder();
				addporder.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(113, 37, 87, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("查詢");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FindAllPorder allporder=new FindAllPorder();
				allporder.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(113, 70, 87, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("修改");
		btnNewButton_2.setBounds(113, 103, 87, 23);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("刪除");
		btnNewButton_3.setBounds(113, 136, 87, 23);
		panel_1.add(btnNewButton_3);

	}
}
