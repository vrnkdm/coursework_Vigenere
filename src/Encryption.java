import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.io.*;
import java.util.regex.Pattern;


public class Encryption extends JFrame {

    // Метод перевірки, чи рядок містить тільки українські літери
    private boolean isUkrainianText(String text) {
        String ukrainianRegex = "^[а-щґєіїьюяА-ЩҐЄІЇЬЮЯ0-9 .'`:,!?-]+$";//дозволяє тільки українські літератури та можливості.
        return Pattern.matches(ukrainianRegex, text);// Повертаємо true, якщо текст відповідає шаблону, інакше — false
    }

    Encryption (){
        super ("Шифрування Віженера");
        setBounds(250, 50, 1000, 700);
        setVisible(true);
        setIconImage(Toolkit.getDefaultToolkit().getImage("img.jpg"));
        add(new Pictureses());

        setLayout(new BorderLayout());

        // Панель для заголовка
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(new Color (179, 218, 255));
        JLabel titleLabel = new JLabel("Шифр Віженера", JLabel.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD + Font.ITALIC, 25));
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);//додано панель до верхньої частини вікна

        // Блок вхідного повідомлення
        JPanel WestPanel = new JPanel(new BorderLayout());
        WestPanel.setBorder(new EmptyBorder(10, 30, 10, 10)); // Зміщення вправо (відступи для панелі)
        JLabel label1 = new JLabel("Вхідне повідомлення:");
        label1.setFont(new Font("Times New Roman",  Font.BOLD, 20));
        JTextArea inputTextArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(inputTextArea);//+прокрутка для текстового поля
        inputTextArea.setLineWrap(true);  // Вмикає перенос слів
        inputTextArea.setWrapStyleWord(true);  // Переносить цілі слова, а не розбиває їх
        JPanel buttonPanel1 = new JPanel();
        JButton saveButton1 = new JButton("Зберегти");
        JButton openButton1 = new JButton("Відкрити");
        JButton clearButton1 = new JButton("Очистити");
        saveButton1.setBackground(new Color (204, 204, 255));
        openButton1.setBackground(new Color (204, 204, 255));
        clearButton1.setBackground(new Color (204, 204, 255));
        buttonPanel1.add(saveButton1);
        buttonPanel1.add(openButton1);
        buttonPanel1.add(clearButton1);
        buttonPanel1.setBackground(new Color (204, 255, 255));
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setBackground(new Color (204, 255, 255));
        WestPanel.setBackground(new Color (204, 255, 255));
        inputPanel.add(label1, BorderLayout.NORTH);
        inputPanel.add(scrollPane, BorderLayout.CENTER);
        inputPanel.add(buttonPanel1, BorderLayout.SOUTH);
        WestPanel.add(inputPanel, BorderLayout.CENTER);
        add(WestPanel, BorderLayout.WEST);

        // Блок ключа
        JPanel CenterPanel = new JPanel(new BorderLayout());
        CenterPanel.setBorder(new EmptyBorder(30, 10, 10, 10)); // Зміщення вниз
        JLabel label2 = new JLabel("Ключ: ");
        label2.setFont(new Font("Times New Roman",  Font.BOLD, 20));
        JTextField keyField = new JTextField(5);// поле для введення ключа
        JButton okButton = new JButton("OK");
        okButton.setBackground(new Color (204, 204, 255));
        JPanel radioPanel = new JPanel(); // панель перемикача
        JRadioButton  encryptRadioButton = new JRadioButton("Зашифрувати");
        JRadioButton decryptRadioButton = new JRadioButton("Розшифрувати");
        encryptRadioButton.setFont(new Font("Times New Roman",  Font.ITALIC, 20));
        decryptRadioButton.setFont(new Font("Times New Roman",  Font.ITALIC, 20));
        encryptRadioButton.setBackground(new Color (204, 255, 255));
        decryptRadioButton.setBackground(new Color (204, 255, 255));
        encryptRadioButton.setSelected(true);// За замовчуванням обрано "Зашифрувати"
        ButtonGroup group = new ButtonGroup(); //об'єднано перемикачі у групу для вибору 1 варіанта
        group.add( encryptRadioButton);
        group.add(decryptRadioButton);
        radioPanel.add( encryptRadioButton);
        radioPanel.add(decryptRadioButton);
        radioPanel.setBackground(new Color (204, 255, 255));
        JPanel keyPanel = new JPanel(new BorderLayout());
        keyPanel.setBackground(new Color (204, 255, 255));
        keyPanel.add(label2, BorderLayout.WEST);
        keyPanel.add(keyField, BorderLayout.CENTER);
        keyPanel.add(okButton, BorderLayout.EAST);
        // keyPanel.add(resultArea, BorderLayout.SOUTH);
        CenterPanel.add(keyPanel, BorderLayout.NORTH);
        CenterPanel.add(radioPanel, BorderLayout.CENTER);
        CenterPanel.setBackground(new Color (204, 255, 255));
        // Панель з інструкцією
        JTextArea instructionArea = new JTextArea(20, 30); // збільшено розмір області інструкції
        instructionArea.setEditable(false);
        instructionArea.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        instructionArea.setText(
                "ІНСТРУКЦІЯ ДЛЯ ШИФРУВАННЯ:\n" +
                        "                                  \n"+
                        "1. У текстове поле з назвою 'Вхідне\n " +
                        "   повідомлення' напишіть або вставте\n" +
                        "   з файлу текст, який ви хочете заши-\n" +
                        "   фрувати.\n" +
                        "                                  \n"+
                        "                                  \n"+
                        "2. Виберіть на перемикачу, чи хочете\n" +
                        "   ви зашифрувати чи розшифрувати\n " +
                        "   текст.\n" +
                        "                                  \n"+
                        "                                  \n"+
                        "3. Введіть у текстове поле 'Ключ' свій\n " +
                        "   ключ та натисніть кнопку 'Ок'.\n" +
                        "                                  \n"+
                        "                                  \n"+
                        "4. Після натискання кнопки 'Ок' у текс-\n" +
                        "   товому полі 'Вихідне повідомлення' \n" +
                        "   з'явиться ваш розшифрований/заши-\n" +
                        "   фрований текст, який ви можете \n" +
                        "   зберегти або очистити."
        );
        instructionArea.setBackground(new Color(179, 218, 255));
        instructionArea.setBorder(new EmptyBorder(10, 10, 10, 10));


// Додаємо панель інструкції одразу під перемикачами
        CenterPanel.add(instructionArea, BorderLayout.SOUTH);

        add(CenterPanel, BorderLayout.CENTER);
        CenterPanel.setBackground(new Color(204, 255, 255));

        // Блок вихідного повідомлення
        JPanel EastPanel = new JPanel(new BorderLayout());
        EastPanel.setBorder(new EmptyBorder(10, 10, 10, 30)); // Зміщення вліво
        EastPanel.setBackground(new Color (204, 255, 255));
        JLabel label3 = new JLabel("Вихідне повідомлення:");
        label3.setFont(new Font("Times New Roman",  Font.BOLD, 20));
        JTextArea outputTextArea = new JTextArea(10, 30);
        JScrollPane scrollPane2 = new JScrollPane(outputTextArea); //+прокрутка для текстового поля
        outputTextArea.setLineWrap(true);  // Вмикає перенос слів
        outputTextArea.setWrapStyleWord(true);  // Переносить цілі слова, а не розбиває їх
        outputTextArea.setEditable(false); // забороняє користувачеві писати в полі
        JPanel buttonPanel2 = new JPanel();
        buttonPanel2.setBackground(new Color (204, 255, 255));
        JButton saveButton2 = new JButton("Зберегти");
        //JButton openButton2 = new JButton("Відкрити");
        JButton clearButton2 = new JButton("Очистити");
        saveButton2.setBackground(new Color (204, 204, 255));
        //openButton2.setBackground(new Color (204, 204, 255));
        clearButton2.setBackground(new Color (204, 204, 255));
        buttonPanel2.add(saveButton2);
        //buttonPanel2.add(openButton2);
        buttonPanel2.add(clearButton2);
        JPanel outputPanel = new JPanel(new BorderLayout());
        outputPanel.setBackground(new Color (204, 255, 255));
        outputPanel.add(label3, BorderLayout.NORTH);
        outputPanel.add(scrollPane2, BorderLayout.CENTER);
        outputPanel.add(buttonPanel2, BorderLayout.SOUTH);
        EastPanel.add(outputPanel, BorderLayout.CENTER);
        add(EastPanel, BorderLayout.EAST);

        //Меню
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Меню");
        menuBar.setBackground(new Color(204, 204, 255));
        menuBar.add(menu);
        // Створено пункти меню
        JMenuItem mainMenuItem = new JMenuItem("Головна");
        JMenuItem authorMenuItem = new JMenuItem("Про автора");
        JMenuItem courseMenuItem = new JMenuItem("Курсова");
        // Додано пункти меню
        menu.add(mainMenuItem);
        menu.add(authorMenuItem);
        menu.add(courseMenuItem);
        mainMenuItem.setBackground(new Color(217, 179, 255));
        authorMenuItem.setBackground(new Color(179, 218, 255));
        courseMenuItem.setBackground(new Color(217, 179, 255));
        setJMenuBar(menuBar);
        //обробка подій
        mainMenuItem.addActionListener(_ -> showMainwindow());
        authorMenuItem.addActionListener(_ -> showAuthorInfo());
        courseMenuItem.addActionListener(_ ->  showCourse());

        // Обробники подій для кнопок
        //КНОПКИ
        clearButton1.addActionListener(e -> inputTextArea.setText(""));//очищає текстове поле
        openButton1.addActionListener(e -> openFile(inputTextArea));// відкриває файл
        saveButton1.addActionListener(e -> saveFile(inputTextArea));//зберігає вміст текстового поля у файл

        clearButton2.addActionListener(e -> outputTextArea.setText(""));//очищає текстове поле
        //openButton2.addActionListener(e -> openFile(outputTextArea));// відкриває файл
        saveButton2.addActionListener(e -> saveFile(outputTextArea));//зберігає вміст текстового поля у файл

        // Обробник для кнопки OK
        okButton.addActionListener(e -> {
            String inputText = inputTextArea.getText();
            String key = keyField.getText();

            // Перевірка вхідного тексту і ключа на українські літери
            if (!isUkrainianText(inputText) || !isUkrainianText(key)) {
                JOptionPane.showMessageDialog(this, "Будь ласка, введіть текст та ключ лише українською мовою.", "Помилка вводу", JOptionPane.WARNING_MESSAGE); //Виводимо повідомлення для користувача у разі, якщо є неукраїнські символи
                return; // зупиняємо подальше виконання, якщо є неукраїнські символи
            }

            // Перевіряє чи вибрано шифрування або дешифрування
            if (encryptRadioButton.isSelected()) {
                String encryptedText = vigenereEncrypt(inputText, key);
                outputTextArea.setText(encryptedText);
            } else if (decryptRadioButton.isSelected()) {
                String decryptedText = vigenereDecrypt(inputText, key);
                outputTextArea.setText(decryptedText);
            }
        });
    }

    // Метод для шифрування Віженера
    private String vigenereEncrypt(String text, String key) {
        String ukrAlphabet = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя"; //український алфавіт
        StringBuilder result = new StringBuilder(); //тут буде збиратися зашифрований текст
        text = text.toLowerCase();//приводить текст і ключ до нижнього регістру
        key = key.toLowerCase();

        for (int i = 0, j = 0; i < text.length(); i++) { //проходить по кожному символу вхідного тексту (і-символ у тексті, j-символ у ключі)
            char letter = text.charAt(i);//знаходить символ у вхідному тексті на позиції і

            if (ukrAlphabet.indexOf(letter) != -1) { //перевірка, чи є літера в українському алфавіті
                int letterIndex = ukrAlphabet.indexOf(letter);//знаходить індекс літери в українському алфавіті
                int keyIndex = ukrAlphabet.indexOf(key.charAt(j));//знаходить індекс ключа в українському алфавіті
                int encryptedIndex = (letterIndex + keyIndex) % ukrAlphabet.length();//вираховується індекс зашифроврованої літери за формулою
                result.append(ukrAlphabet.charAt(encryptedIndex));//+до зашифрованого тексту
                j = (j + 1) % key.length(); //циклічний рух по ключу
            } else {
                result.append(letter);//зберігаються символи, які не є літерами українського алфавіту
            }
        }
        return result.toString();
    }

    // Метод для дешифрування Віженера
    private String vigenereDecrypt(String text, String key) {
        String ukrAlphabet = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя"; //український алфавіт
        StringBuilder result = new StringBuilder();//тут буде збиратися розшифрований текст
        text = text.toLowerCase();//приводить текст і ключ до нижнього регістру
        key = key.toLowerCase();

        for (int i = 0, j = 0; i < text.length(); i++) {//проходить по кожному символу зашифрованого тексту (і-символ у тексті, j-символ у ключі)
            char letter = text.charAt(i);//знаходить символ у зашифрованому тексті на позиції і

            if (ukrAlphabet.indexOf(letter) != -1) { //перевірка, чи є літера в українському алфавіті
                int letterIndex = ukrAlphabet.indexOf(letter);//знаходить індекс літери в українському алфавіті
                int keyIndex = ukrAlphabet.indexOf(key.charAt(j));//знаходить індекс ключа в українському алфавіті
                int decryptedIndex = (letterIndex - keyIndex + ukrAlphabet.length()) % ukrAlphabet.length();//вираховується індекс розшифроврованої літери за формулою
                result.append(ukrAlphabet.charAt(decryptedIndex));//вираховується індекс розшифроврованої літери за формулою
                j = (j + 1) % key.length(); //циклічний рух по ключу
            } else {
                result.append(letter);//зберігається символи, які не є літерами українського алфавіту
            }
        }
        return result.toString();
    }

    //ОБРОБНИКИ КНОПОК

    private void openFile(JTextArea textArea) {
        JFileChooser fileChooser = new JFileChooser();//створено вікно для вибору файлу
        int returnValue = fileChooser.showOpenDialog(null);//показує  вікно для вибору файлу і повертає результат (чи був файл вибраний)
        if (returnValue == JFileChooser.APPROVE_OPTION) { //перевіряє, чи вибрав користувач файл
            File file = fileChooser.getSelectedFile(); // файл, вибраний у вікні зберігається  в змінній file для подальшого використання
            try (BufferedReader br = new BufferedReader(new FileReader(file))) { //відкриває вибраний файл для читання
                textArea.read(br, null); //зчитує вміст файлу і вставляє його в текстове поле
            } catch (IOException e) { //обробляє можливі помилки вводу/виводу
                e.printStackTrace();
            }
        }
    }

    private void saveFile(JTextArea textArea) {
        JFileChooser fileChooser = new JFileChooser(); //створено вікно для вибору файлу
        int returnValue = fileChooser.showSaveDialog(null); //показує  вікно для вибору файлу і повертає результат (чи був файл вибраний)
        if (returnValue == JFileChooser.APPROVE_OPTION) { //перевіряє, чи вибрав користувач файл
            File file = fileChooser.getSelectedFile(); // файл, вибраний у вікні зберігається  в змінній file для подальшого використання
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) { //відкриває вибраний файл для запису
                textArea.write(bw);
            } catch (IOException e) { //обробляє можливі помилки вводу/виводу
                e.printStackTrace();
            }
        }
    }

    private void showCourse() {
        JFrame CourseFrame = new Course();
        CourseFrame.setVisible(true);
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

class Pictureses extends Canvas {
    Pictureses() {
        setBackground(new Color(204, 255, 255));
    }
}


