package controller.member;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import controller.porder.PorderManager;
import model.Member;
import util.Tool;

public class LoginSuccess extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                LoginSuccess frame = new LoginSuccess();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public LoginSuccess() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 64, 64));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // 歡迎訊息
        JLabel showMessage = new JLabel("");
        showMessage.setFont(new Font("新細明體", Font.BOLD, 19));
        showMessage.setForeground(Color.WHITE);
        showMessage.setBounds(42, 78, 264, 56);
        contentPane.add(showMessage);

        Member member = (Member) Tool.readFile("member.txt");
        String show = member.getName() + ", 歡迎你";
        showMessage.setText(show);

        // 日期時間顯示
        JLabel dateTimeLabel = new JLabel();
        dateTimeLabel.setFont(new Font("新細明體", Font.BOLD, 16));
        dateTimeLabel.setForeground(Color.WHITE);
        dateTimeLabel.setBounds(227, 33, 170, 20);
        contentPane.add(dateTimeLabel);

        // 時間格式
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // 每秒更新時間
        Timer timer = new Timer(1000, e -> {
            String now = LocalDateTime.now().format(dtf);
            dateTimeLabel.setText(now);
        });
        timer.start();

        // 進入購物按鈕
        JButton btnNewButton = new JButton("進入購物");
        btnNewButton.setBounds(61, 161, 100, 30);
        contentPane.add(btnNewButton);

        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PorderManager pm = new PorderManager();
                pm.setVisible(true);
                dispose();
            }
        });
    }
}
