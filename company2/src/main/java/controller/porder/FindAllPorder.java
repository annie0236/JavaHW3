package controller.porder;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import model.Porder;
import service.impl.PorderServiceImpl;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

public class FindAllPorder extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField id;
    private JTextField black;
    private JTextField latte;
    private JTextField mocha;
    private static PorderServiceImpl psi = new PorderServiceImpl();
    private JTextField delID;

    private JTextArea allPorder;  // 改成成員變數
    private JLabel sum;           // 改成成員變數

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FindAllPorder frame = new FindAllPorder();
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
    public FindAllPorder() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 724, 591);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        
     
        allPorder = new JTextArea();   
        allPorder.setLineWrap(true);       //自動換行
        allPorder.setWrapStyleWord(true);  //單字不會被拆開
        
        JScrollPane scrollPane = new JScrollPane(allPorder);                                   //滾動條的滾動視窗
        scrollPane.setBounds(45, 82, 573, 204);
        contentPane.add(scrollPane);

        sum = new JLabel("");
        sum.setBounds(32, 301, 633, 45);
        contentPane.add(sum);

        // 第一次初始化資料
        refreshData();

        JButton btnNewButton = new JButton("回管理頁");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PorderManager pm = new PorderManager();
                pm.setVisible(true);
                dispose();
            }
        });
        btnNewButton.setBounds(32, 519, 87, 23);
        contentPane.add(btnNewButton);

        JPanel panel =  new JPanel();
        panel.setBackground(new Color(128, 64, 64));
        panel.setBounds(32, 356, 623, 67);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("ID");
        lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 12));
        lblNewLabel.setBounds(10, 28, 32, 15);
        panel.add(lblNewLabel);

        id = new JTextField();
        id.setBounds(37, 25, 51, 21);
        panel.add(id);
        id.setColumns(10);

        JLabel tt = new JLabel("BLACK");
        tt.setFont(new Font("新細明體", Font.BOLD, 12));
        tt.setBounds(110, 28, 46, 15);
        panel.add(tt);

        black = new JTextField();
        black.setBounds(158, 25, 51, 21);
        panel.add(black);
        black.setColumns(10);

        JLabel lblRam = new JLabel("LATTE");
        lblRam.setFont(new Font("新細明體", Font.BOLD, 12));
        lblRam.setBounds(255, 28, 46, 15);
        panel.add(lblRam);

        JLabel lblMouse = new JLabel("MOCHA");
        lblMouse.setFont(new Font("新細明體", Font.BOLD, 12));
        lblMouse.setBounds(374, 31, 46, 15);
        panel.add(lblMouse);

        latte = new JTextField();
        latte.setBounds(300, 25, 51, 21);
        panel.add(latte);
        latte.setColumns(10);

        mocha = new JTextField();
        mocha.setBounds(430, 25, 58, 21);
        panel.add(mocha);
        mocha.setColumns(10);

        JButton btnNewButton_1 = new JButton("修改");
        btnNewButton_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    int ID = Integer.parseInt(id.getText());
                    int Black = Integer.parseInt(black.getText());
                    int Latte = Integer.parseInt(latte.getText());
                    int Mocha = Integer.parseInt(mocha.getText());
                    Porder p = new Porder();
                    p.setId(ID);
                    p.setBlack(Black);
                    p.setLatte(Latte);
                    p.setMocha(Mocha);

                    psi.updatePorder(p);

                    // 更新畫面資料
                    refreshData();
                } catch (NumberFormatException ex) {
                    System.out.println("請輸入有效的數字！");
                }
            }
        });
        btnNewButton_1.setBounds(515, 24, 87, 23);
        panel.add(btnNewButton_1);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(128, 64, 64));
        panel_1.setBounds(32, 433, 623, 53);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("ID");
        lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 12));
        lblNewLabel_1.setBounds(10, 13, 32, 15);
        panel_1.add(lblNewLabel_1);

        delID = new JTextField();
        delID.setColumns(10);
        delID.setBounds(37, 10, 51, 21);
        panel_1.add(delID);

        JButton btnNewButton_2 = new JButton("刪除");
        btnNewButton_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    int DELID = Integer.parseInt(delID.getText());

                    Porder p = new Porder();
                    p.setId(DELID);

                    psi.deletePorder(p);

                    // 更新畫面資料
                    refreshData();
                } catch (NumberFormatException ex) {
                    System.out.println("請輸入有效的數字！");
                }
            }
        });
        btnNewButton_2.setBounds(139, 10, 87, 23);
        panel_1.add(btnNewButton_2);

    }

    // 新增刷新資料的方法，更新 allPorder 與 sum 的文字
    public void refreshData() {
        List<Porder> l = psi.findAllPorder();
        String show = "";
        int count = 0;
        int BLACK = 0;
        int LATTE = 0;
        int MOCHA = 0;

        for (Porder p : l) {
            show += "id:" + p.getId() + "\tname:" + p.getName()
                    + "\tblac:" + p.getBlack() + "\tlatte:" + p.getLatte()
                    + "\tmocha:" + p.getMocha() + "\n";
            count++;
            BLACK += p.getBlack();
            LATTE += p.getLatte();
            MOCHA += p.getMocha();
        }

        allPorder.setText(show);

        int allSum = BLACK * 4999 + LATTE * 799 + MOCHA * 200;
        sum.setText("筆數:" + count + "    BLACK:" + BLACK + "  LATTE:" + LATTE + "  MOCHA:" + MOCHA + "   銷售總金額:" + allSum + "元");
    }
}
