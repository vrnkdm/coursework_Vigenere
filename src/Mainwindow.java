import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Mainwindow extends JFrame {
    Mainwindow() {
        super("Головне вікно");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 600);
        setIconImage(Toolkit.getDefaultToolkit().getImage("img.jpg"));
        this.add(new Picture());
        setVisible(true);
        setResizable(false);

        //Меню
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Меню");
        menuBar.setBackground(new Color(204, 204, 255));
        menuBar.add(menu);
        // Створено пункти меню
        JMenuItem authorMenuItem = new JMenuItem("Про автора");
        JMenuItem courseMenuItem = new JMenuItem("Курсова");
        JMenuItem encryptionMenuItem = new JMenuItem("Шифрування");
        // Додано пункти меню
        menu.add(authorMenuItem);
        menu.add(courseMenuItem);
        menu.add(encryptionMenuItem);

        authorMenuItem.setBackground(new Color(179, 218, 255));
        courseMenuItem.setBackground(new Color(217, 179, 255));
        encryptionMenuItem.setBackground(new Color(179, 218, 255));

        setJMenuBar(menuBar);
        //обробка подій
        authorMenuItem.addActionListener(_ -> showAuthorInfo());
        courseMenuItem.addActionListener(_ -> showCourse());
        encryptionMenuItem.addActionListener(_ -> EncryptionWindow());
    }

    // Методи для обробки подій головного меню
    private void showAuthorInfo() {
        JFrame authorFrame = new Author();
        authorFrame.setVisible(true);
    }
    private void showCourse() {
        JFrame CourseFrame = new Course();
        CourseFrame.setVisible(true);
    }
    private void EncryptionWindow() {
        JFrame EncryptionFrame = new Encryption();
        EncryptionFrame.setVisible(true);
    }
    /*private void TestWindow() {
        JFrame TestFrame = new Test();
        TestFrame.setVisible(true);
    }
    private void LabWindow() {
        JFrame LabFrame = new Lab();
        LabFrame.setVisible(true);
    }*/
}



class Picture extends Canvas {
    private int xText = 80;  // Початкові координати по х та у
    private int yText = 450;
    private int textFlag = 1; // Напрямок руху
    Picture() {
        setBackground(new Color(204, 255, 255));

        // контекстне меню
        JPopupMenu contextMenu = new JPopupMenu();
        JMenuItem contextAuthor = new JMenuItem("Про автора");
        JMenuItem contextCourse = new JMenuItem("Курсова");
        JMenuItem contextEncryption = new JMenuItem("Шифрування");
        contextAuthor.setBackground(new Color(179, 218, 255));
        contextCourse.setBackground(new Color(217, 179, 255));
        contextEncryption.setBackground(new Color(179, 218, 255));
        contextMenu.add(contextAuthor);
        contextMenu.add(contextCourse);
        contextMenu.add(contextEncryption);
        // обробка події
        contextAuthor.addActionListener(e -> showAuthorInfos());
        contextCourse.addActionListener(e -> showCourses());
        contextEncryption.addActionListener(e -> EncryptionWindows());

        // MouseListener обробляє події миші
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) { //  метод, який обробляє подію натискання на кнопку миші
                if (e.isPopupTrigger()) { // чи подія є тригером для контекстного меню
                    contextMenu.show(e.getComponent(), e.getX(), e.getY()); // показ контекстного меню на координатах кліку миші
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) { // метод, який обробляє подію відпускання кнопки миші
                if (e.isPopupTrigger()) {
                    contextMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

        // Таймер для оновлення руху тексту
        Timer timer = new Timer(100, e ->{ //інтервал у мілісекундах, через який таймер буде викликати ActionListener
            updateTextPosition();  // Оновлення позиції тексту
            repaint();  // Перерисовка
        });
        timer.start();  // Запуск таймера
    }

    private void updateTextPosition() {
        xText += 5 * textFlag;// Оновлення xText на 5 пікселів у напрямку textFlag
        if (xText > getWidth() - 220) {
            textFlag = -1;  // Рух вліво, якщо досяг, змінюємо напрямок
        }
        if (xText < 0) {
            textFlag = 1;  // Рух вправо, якщо досяг, змінюємо напрямок
        }
    }

    @Override
    public void paint(Graphics gr) {
        Image im = Toolkit.getDefaultToolkit().getImage("Vprog.png");
        //gr.drawImage(im,400, 50, getWidth()/2, getHeight()-60, this); //по центру не на весь екран
        //gr.drawImage(im,0, 0, getWidth(), getHeight(), this);// на весь екран
        gr.drawImage(im, 50, 50, getWidth() - 100, getHeight() / 2, this);

        gr.setFont(new Font("Time New Romans", Font.BOLD + Font.ITALIC, 50));
        gr.setColor(Color.black);
        gr.drawString("Вітаю!!!",  xText, yText);// Виводення тексту на новій позиції xText

    }
    // Методи для обробки подій контекстного меню
    private void showAuthorInfos() {
        JFrame authorFrame = new Author();
        authorFrame.setVisible(true);
    }

    private void showCourses() {
        JFrame CourseFrame = new Course();
        CourseFrame.setVisible(true);
    }

    private void EncryptionWindows() {
        JFrame EncryptionFrame = new Encryption();
        EncryptionFrame.setVisible(true);
    }
}

