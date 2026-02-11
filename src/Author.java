import javax.swing.*;
import java.awt.*;

public class Author extends JFrame {
    Author(){
        super ("Інформація про автора");
        setLocation(100, 50);
        setSize(400, 550 ); //600 якщо з кнопкою анімація
        setResizable(false);
        setVisible(true);
        setIconImage(Toolkit.getDefaultToolkit().getImage("img.jpg"));
        this.add(new Pictures());

        //Меню
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Меню");
        menuBar.setBackground(new Color(204, 204, 255));
        menuBar.add(menu);
        // Створено пункти меню
        JMenuItem mainMenuItem = new JMenuItem("Головна");
        JMenuItem courseMenuItem = new JMenuItem("Курсова");
        JMenuItem encryptionMenuItem = new JMenuItem("Шифрування");
        // Додано пункти меню
        menu.add(mainMenuItem);
        menu.add(courseMenuItem);
        menu.add(encryptionMenuItem);
        mainMenuItem.setBackground(new Color(217, 179, 255));
        courseMenuItem.setBackground(new Color(179, 218, 255));
        encryptionMenuItem.setBackground(new Color(217, 179, 255));
        setJMenuBar(menuBar);
        //обробка подій
        mainMenuItem.addActionListener(_ -> showMainwindow());
        courseMenuItem.addActionListener(_ -> showCourse());
        encryptionMenuItem.addActionListener(_ -> EncryptionWindow());

        //JPanel buttonPanel = new JPanel();
       // buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Центрування кнопки
       //JButton button1 = new JButton("Анімація");
        //JButton button2 = new JButton("ЛР 6");
        //button1.setPreferredSize(new Dimension(150, 55));//розмір кнопки
       // button2.setPreferredSize(new Dimension(150, 55));//розмір кнопки
        //buttonPanel.setBackground(new Color(204, 255, 255));
       // buttonPanel.add(button1);
       // buttonPanel.add(button2);
       // Font buttonFont = new Font("Time New Romans", Font.BOLD, 20);//розмір напису на кнопці
       // button1.setFont(buttonFont);
        //button2.setFont(buttonFont);
        // + панель з кнопкою внизу
       // add(buttonPanel, BorderLayout.SOUTH);
       // button1.setBackground(new Color (204, 204, 255));
       // button2.setBackground(new Color (204, 204, 255));
        // обробка кнопки
        //button1.addActionListener(e ->new Test());
        //button2.addActionListener(e ->new Lab());
    }
    private void showMainwindow() {
        JFrame MainwindowFrame = new Mainwindow();
        MainwindowFrame.setVisible(true);
    }
    private void showCourse() {
        JFrame CourseFrame = new Course();
        CourseFrame.setVisible(true);
    }
    private void EncryptionWindow() {
        JFrame GameFrame = new Encryption();
        GameFrame.setVisible(true);
    }
}


class Pictures extends Canvas{
    Pictures(){
        setBackground(new Color(204, 255, 255));
    }
    public void paint (Graphics gr){
        Image im = Toolkit.getDefaultToolkit().getImage("author.jpg");
        gr.drawImage(im, 50, 50, getWidth()-100, getHeight()/2, this);
        gr.setColor(new Color(204, 204, 255));
        gr.fillRect(10,  getHeight()/2+90,getWidth()-40, 100);
        gr.setColor(Color.black);
        gr.setFont(new Font ("Time New Romans", Font.ITALIC, 15));
        FontMetrics fm = this.getFontMetrics(this.getFont());
        int l=fm.stringWidth("ПІБ: Демченко Вероніка Олександрівна");
        gr.drawString("ПІБ: Демченко Вероніка Олександрівна",(getWidth()-l)/2-60,getHeight()/2+120);
        gr.drawString("Заклад освіти: ВНТУ",(getWidth()-l)/2-60,getHeight()/2+135);
        gr.drawString("Спеціальність: 125 Кібербезпека",(getWidth()-l)/2-60,getHeight()/2+150);
        gr.drawString("Факультет: ФІТКІ",(getWidth()-l)/2-60,getHeight()/2+165);
        gr.drawString("Група: 1БКС-23б",(getWidth()-l)/2-60,getHeight()/2+180);
    }
        }
