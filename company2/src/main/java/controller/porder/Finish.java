package controller.porder;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import model.Porder;
import util.Tool;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;

public class Finish extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Finish frame = new Finish();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Finish() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 625, 473);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(128, 64, 64));
        panel.setBounds(28, 64, 549, 347);
        contentPane.add(panel);
        panel.setLayout(null);

        Member member = (Member) Tool.readFile("member.txt");
        Porder porder = (Porder) Tool.readFile("porder.txt");

        JLabel showMessage = new JLabel("");
        showMessage.setFont(new Font("新細明體", Font.BOLD, 18));
        showMessage.setBounds(28, 10, 500, 44);
        contentPane.add(showMessage);

        showMessage.setText("訂單已完成 , " + member.getName() + " 這是你的細目");

        JTextPane showReporter = new JTextPane();
        showReporter.setBounds(10, 10, 529, 247);
        panel.add(showReporter);

        int sum = porder.getBlack() * 50 + porder.getLatte() * 100 + porder.getMocha() * 120;
        String show = "客戶名稱:" + member.getName() + "\t\t地址:" + member.getAddress() + "\t\t連絡電話:" + member.getPhone() +
                "\n=======================================================" +
                "\nBlack: " + porder.getBlack() + " 個" +
                "\nLatte: " + porder.getLatte() + " 個" +
                "\nMocha: " + porder.getMocha() + " 個" +
                "\n=======================================================" +
                "\n小計: " + sum + " 元";

        showReporter.setText(show);

        // 按鈕：列印
        JButton btnPrint = new JButton("列印");
        btnPrint.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    showReporter.print();
                } catch (PrinterException e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnPrint.setBounds(264, 288, 87, 23);
        panel.add(btnPrint);

        // 按鈕：回管理頁
        JButton btnBack = new JButton("回管理頁");
        btnBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PorderManager porderManager = new PorderManager();
                porderManager.setVisible(true);
                dispose();
            }
        });
        btnBack.setBounds(59, 288, 87, 23);
        panel.add(btnBack);
    }
}
