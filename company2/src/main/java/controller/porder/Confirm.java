package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import model.Porder;
import service.impl.PorderServiceImpl;
import util.Tool;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Confirm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Confirm frame = new Confirm();
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
    public Confirm() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(128, 0, 0));
        panel.setBounds(10, 53, 414, 180);
        contentPane.add(panel);
        panel.setLayout(null);

        JTextPane showPorder = new JTextPane();
        showPorder.setBounds(10, 21, 394, 106);
        panel.add(showPorder);

        JLabel showMember = new JLabel("");
        showMember.setFont(new Font("新細明體", Font.BOLD, 18));
        showMember.setBounds(10, 10, 281, 33);
        contentPane.add(showMember);

        // 讀取資料
        Porder p = (Porder) Tool.readFile("porder.txt");
        Member m = (Member) Tool.readFile("member.txt");

        if (p != null && m != null) {
            showMember.setText("會員:" + m.getName());

            String show = "你的購物細目:" +
                "\nBlack:" + p.getBlack() +
                "\nLatte:" + p.getLatte() +
                "\nMocha:" + p.getMocha() +
                "\n共:" + (p.getBlack()*50 + p.getLatte()*100 + p.getMocha()*120) + "元";

            showPorder.setText(show);
        } else {
            showMember.setText("讀取會員或訂單資料失敗");
            showPorder.setText("");
        }

        /****** Button *******/
        JButton btnBack = new JButton("回上一頁");
        btnBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AddPorder addporder = new AddPorder();
                addporder.setVisible(true);
                dispose();
            }
        });
        btnBack.setBounds(41, 147, 87, 23);
        panel.add(btnBack);

        JButton btnConfirm = new JButton("確定");
        btnConfirm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                /*
                 * 1 - addPorder() --> 資料庫
                 * 2 - 切換到 finish 畫面
                 */
                if (p != null) {
                    new PorderServiceImpl().addPorder(p);
                    Finish finish = new Finish();
                    finish.setVisible(true);
                    dispose();
                }
            }
        });
        btnConfirm.setBounds(198, 147, 87, 23);
        panel.add(btnConfirm);
    }
}
