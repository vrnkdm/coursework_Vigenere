/*import javax.swing.*;
import java.awt.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Lab extends JFrame {

    private JTextField siteInputField;
    private JTextArea resultArea;

    public Lab() {
        super("Завдання 1");
        setSize(400, 300);
        setVisible(true);
        setIconImage(Toolkit.getDefaultToolkit().getImage("img.jpg"));
        setLocationRelativeTo(null);//розташування вікна по центру екрана

        // Меню
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Меню");
        menuBar.setBackground(new Color(204, 204, 255));
        menuBar.add(menu);
        // Створено пункти меню
        JMenuItem task2MenuItem = new JMenuItem("Завдання 2");
        // Додано пункти меню
        menu.add(task2MenuItem);
        task2MenuItem.setBackground(new Color(179, 218, 255));
        setJMenuBar(menuBar);
        //обробка подій
        task2MenuItem.addActionListener(_ -> Task2Window());

        // Створення компонентів інтерфейсу
        JLabel siteLabel = new JLabel("Введіть назву сайту:");
        siteInputField = new JTextField(20);//текстове поле для введення назви сайту
        JButton Buttonip = new JButton("Знайти IP та домен");
        Buttonip.setBackground(new Color (204, 204, 255));
        resultArea = new JTextArea();//текстова обл для результатів
        resultArea.setBackground(new Color (179, 218, 255));
        resultArea.setEditable(false);//текстова обл буде нередагована (ніхто не зможе змінити тексст)

        // Панель для введення сайту
        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(new Color(204, 255, 255));
        inputPanel.setLayout(new FlowLayout());//компоненти розташовані почерзі
        inputPanel.add(siteLabel);
        inputPanel.add(siteInputField);
        inputPanel.add(Buttonip);

        // Панель для результатів
        JScrollPane scrollPane = new JScrollPane(resultArea);//прокрутка для результату
        scrollPane.setPreferredSize(new Dimension(300, 100));//розмір панелі прокрутки

        // Додавання компонентів у вікно
        add(inputPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // Додавання обробника подій для кнопки
        Buttonip.addActionListener(e -> getIPInfo());

        // Відображення IP-адреси власного комп'ютера при запуску
        displayLocalHostIP();
    }

    //метод після натискання кнопки (отримує та відображає ір адресу для сайту)
    private void getIPInfo() {
        String siteName = siteInputField.getText().trim();//отримуємо текст який ввели

        try {
            InetAddress[] addresses = InetAddress.getAllByName(siteName);//отримуємо всі ір адреси для введеного сайту
            StringBuilder result = new StringBuilder("Інформація про сайт " + siteName + ":\n");//створення змінної для накопичення результатів

            for (InetAddress addr : addresses) { //перебирає всі отримані адреси для сайту
                result.append("IP: ").append(addr.getHostAddress()) //додає до текстової обл результатів
                        .append(" | Домен: ").append(addr.getHostName()).append("\n");
            }

            resultArea.setText(result.toString());//виводить результат у текстову область

        } catch (UnknownHostException ex) { //якщо з'являється якийсь виняток
            resultArea.setText("Помилка: неможливо знайти IP для " + siteName);
        }
    }

    private void displayLocalHostIP() {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            resultArea.append("Моя адреса: " + localHost.getHostAddress() + " | " + localHost.getHostName() + "\n");
        } catch (UnknownHostException ex) {
            resultArea.append("Помилка: неможливо отримати локальну IP-адресу.");
        }
    }
    // Методи для обробки подій головного меню
    private void Task2Window() {
        JFrame UrlFrame = new Url();
        UrlFrame.setVisible(true);
    }
}*/
