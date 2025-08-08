package controller;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controller.member.AddMember;
import controller.member.LoginError;
import controller.member.LoginSuccess;
import model.Member;
import service.impl.MemberServiceImpl;
import util.Tool;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField username;
    private JTextField password;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Login frame = new Login();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 486, 340);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // 標題區塊
        JPanel panel = new JPanel();
        panel.setBackground(new Color(128, 64, 64));
        panel.setBounds(54, 20, 366, 45);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblTitle = new JLabel("咖啡因 電子商城");
        lblTitle.setFont(new Font("新細明體", Font.BOLD, 16));
        lblTitle.setBounds(111, 10, 130, 35);
        panel.add(lblTitle);

        // 登入區塊
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(128, 64, 64));
        panel_1.setBounds(54, 75, 366, 180);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblUsername = new JLabel("帳號:");
        lblUsername.setFont(new Font("新細明體", Font.BOLD, 14));
        lblUsername.setBounds(31, 35, 46, 23);
        panel_1.add(lblUsername);

        JLabel lblPassword = new JLabel("密碼:");
        lblPassword.setFont(new Font("新細明體", Font.BOLD, 14));
        lblPassword.setBounds(31, 68, 46, 23);
        panel_1.add(lblPassword);

        username = new JTextField();
        username.setBounds(124, 36, 96, 21);
        panel_1.add(username);
        username.setColumns(10);

        password = new JTextField();
        password.setBounds(124, 69, 96, 21);
        panel_1.add(password);
        password.setColumns(10);

        JButton btnLogin = new JButton("登入");
        btnLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String Username = username.getText();
                String Password = password.getText();

                Member m = new MemberServiceImpl().login(Username, Password);

                if (m != null) {
                    Tool.saveFile(m, "member.txt");

                    LoginSuccess loginSuccess = new LoginSuccess();
                    loginSuccess.setVisible(true);
                    dispose();
                } else {
                    LoginError loginError = new LoginError();
                    loginError.setVisible(true);
                    dispose();
                }
            }
        });
        btnLogin.setBounds(40, 126, 87, 23);
        panel_1.add(btnLogin);

        JButton btnRegister = new JButton("註冊");
        btnRegister.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AddMember addmember = new AddMember();
                addmember.setVisible(true);
                dispose();
            }
        });
        btnRegister.setBounds(203, 126, 87, 23);
        panel_1.add(btnRegister);

        // 載入並縮放圖片
        ImageIcon originalIcon = new ImageIcon("C:\\Users\\student\\eclipse-workspace\\company2\\src\\main\\resources\\1.jpg");
        Image scaledImg = originalIcon.getImage().getScaledInstance(80, 60, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);

        // 建立 JLabel 並設定圖示
        JLabel lblImage = new JLabel(scaledIcon);
        lblImage.setBounds(286, 10, 80, 60);
        panel_1.add(lblImage);

        // 將圖片置頂（panel_1最頂層）
        panel_1.setComponentZOrder(lblImage, 0);

        // 重新整理面板
        panel_1.repaint();
        panel_1.revalidate();
    }
}
