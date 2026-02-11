/*import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;

public class Url extends JFrame {

    private JTextField urlField;
    private JTextArea resultArea;

    public Url() {
        super("Завдання 2");
        setSize(600, 400);
        setVisible(true);
        setIconImage(Toolkit.getDefaultToolkit().getImage("img.jpg"));
        setLocationRelativeTo(null);

        // Створюємо елементи інтерфейсу
        urlField = new JTextField();//текстове поле введення юрл
        urlField.setBackground(new Color(204, 255, 255));
        resultArea = new JTextArea();//текстова обл, буде виводитися вміст сторінки
        resultArea.setEditable(false); // Забороняємо редагування тексту
        resultArea.setBackground(new Color (179, 218, 255));
        JButton Buttonurl = new JButton("Отримати вміст");
        Buttonurl.setBackground(new Color (204, 204, 255));

        // Додаємо елементи в панель
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(urlField, BorderLayout.NORTH);
        panel.add(new JScrollPane(resultArea), BorderLayout.CENTER);
        panel.add(Buttonurl, BorderLayout.SOUTH);

        add(panel);

        // Додаємо обробник події на кнопку
        Buttonurl.addActionListener(e -> fetchURLContent());
    }

    // Метод для отримання вмісту веб-сторінки
    private void fetchURLContent() {
        String urlString = urlField.getText();//отримує текст, що ввів користувач у текстове поле
        try {
            URL url = new URL(urlString);//створює об'єкт URL, передаючи йому текстове значення URL з поля urlField

            // Очищуємо текстову область перед отриманням нових даних
            resultArea.setText("");

            // Отримуємо інформацію про URL
            resultArea.append("Протокол: " + url.getProtocol() + "\n");
            resultArea.append("Хост: " + url.getHost() + "\n");
            resultArea.append("Шлях: " + url.getPath() + "\n\n");

            // Завантажуємо вміст веб-сторінки
            InputStream inputStream = url.openStream();//відкриваємо потік на читання вмісту сторінки
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));//обгортає потік  для зручного читання тексту пострічково.
            String line;//оголошує змінну для зберігання рядків, які будуть прочитані з веб-сторінки.

            resultArea.append("Вміст веб-сторінки:\n");
            while ((line = reader.readLine()) != null) {//читає рядки з веб-сторінки в циклі до тих пір, поки не досягне кінця файлу.
                resultArea.append(line + "\n");
            }

            // Закриваємо потоки
            reader.close();
            inputStream.close();

        } catch (MalformedURLException e) {
            resultArea.append("Неправильний URL: " + e.getMessage() + "\n");
        } catch (IOException e) {
            resultArea.append("Помилка при з'єднанні: " + e.getMessage() + "\n");
        }
    }
}*/