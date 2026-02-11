import javax.swing.*;
import java.awt.*;

public class Course extends JFrame {
    Course(){
        super ("Курсова робота");
        setBounds(200, 20, 1250, 800);
        setVisible(true);
        setIconImage(Toolkit.getDefaultToolkit().getImage("img.jpg"));
        add(new Picturese());
        setResizable(false);

        //Меню
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Меню");
        menuBar.setBackground(new Color(204, 204, 255));
        menuBar.add(menu);
        // Створено пункти меню
        JMenuItem mainMenuItem = new JMenuItem("Головна");
        JMenuItem authorMenuItem = new JMenuItem("Про автора");
        JMenuItem encryptionMenuItem = new JMenuItem("Шифрування");
        // Додано пункти меню
        menu.add(mainMenuItem);
        menu.add(authorMenuItem);
        menu.add(encryptionMenuItem);
        mainMenuItem.setBackground(new Color(179, 218, 255));
        authorMenuItem.setBackground(new Color(217, 179, 255));
        encryptionMenuItem.setBackground(new Color(179, 218, 255));
        setJMenuBar(menuBar);
        //обробка подій
        mainMenuItem.addActionListener(_ -> showMainwindow());
        authorMenuItem.addActionListener(_ -> showAuthorInfo());
        encryptionMenuItem.addActionListener(_ -> EncryptionWindow());

        // Основна панель з BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        // Додавання Picturese в центр
        Picturese picturese = new Picturese();
        mainPanel.add(picturese, BorderLayout.CENTER);
        // Панель для кнопки з FlowLayout
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Центрування кнопки
        JButton button1 = new JButton("До роботи!");
        button1.setPreferredSize(new Dimension(200, 50));//розмір кнопки
        buttonPanel.setBackground(new Color(204, 255, 255));
        buttonPanel.add(button1);
        Font buttonFont = new Font("Time New Romans", Font.BOLD, 24);//розмір напису на кнопці
        button1.setFont(buttonFont);
        // + панель з кнопкою внизу
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        button1.setBackground(new Color (204, 204, 255));
        // + основна панель до JFrame
        this.add(mainPanel);
        // обробка кнопки
        button1.addActionListener(e -> EncryptionWindow());
    }

    private void EncryptionWindow() {
        JFrame encryptionFrame = new Encryption();
        encryptionFrame.setVisible(true);
    }
    private void showAuthorInfo() {
        JFrame authorFrame = new Author();
        authorFrame.setVisible(true);
    }
    private void showMainwindow() {
        JFrame MainwindowFrame = new Mainwindow();
        MainwindowFrame.setVisible(true);
    }
}


class Picturese extends Canvas {

    Picturese(){
        setBackground(new Color(204, 255, 255));
    }
    public void paint (Graphics gr){
        gr.drawLine(10,  20,  1520, 20);
       Font F = (new Font ("Time New Romans", Font.BOLD+Font.ITALIC, 35));

        FontMetrics fm = this.getFontMetrics(F);
        String s = "Курсова робота";
        int textWidth = fm.stringWidth(s);
        int textHeight = fm.getAscent();// Висота тексту
gr.setFont(F);

                gr.drawString(s,(getWidth() - textWidth) / 2,20 + ((100 - 20 - textHeight) / 2) + fm.getAscent());
        gr.drawLine(10,  95,  1520, 95);
        gr.setFont(new Font ("Time New Romans", Font.BOLD, 20));
        gr.drawString("Тема:",10, 130);
        gr.setFont(new Font ("Time New Romans", Font.ITALIC, 20));
        gr.drawString(" Реалізування шифрування методом Віжинера",65, 130);
        gr.setFont(new Font ("Time New Romans", Font.BOLD, 20));
        gr.drawString("Алгоритм шифру:",10, 160);
        gr.setFont(new Font ("Time New Romans", Font.ITALIC, 20));
        gr.drawString("Шифр Віженера складається з послідовності кількох шифрів Цезаря з різними значеннями зсуву. Для заши-", 190, 160);
        gr.drawString("фровування може використовуватися таблиця алфавітів, звана tabula recta або квадрат (таблиця) Віженера. Стосовно до",10, 180);
        gr.drawString("українського алфавіту таблиця Віженера складається з рядків по 33 символи, причому кожен наступний рядок зсувається на ", 10, 200);
        gr.drawString("кілька позицій. Таким чином, у таблиці виходить 33 різних шифрів Цезаря. На кожному етапі шифрування використовуються ",10, 218);
        gr.drawString("різні алфавіти, які обирають залежно від символу ключового слова.", 10, 234);
        Image im = Toolkit.getDefaultToolkit().getImage("vigener.jpg");
        gr.drawImage(im, 310, 250, getWidth()/2, getHeight()/2+70, this);
    }
}
