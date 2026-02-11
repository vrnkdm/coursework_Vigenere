/*import javax.swing.*;
import java.awt.*;

public class Test extends JFrame {
    int count = 9; // кількість картинок
    String dir = "img", ext = ".png"; // Додаємо формат файлів
    Slide slide = new Slide(this);

    Test() {
        super("Анімація");
        setBounds(100, 100, 200, 200);
        add(slide);
        setVisible(true);
    }


    class Slide extends JPanel implements Runnable {
        Test amt;
        Thread potok = null; // створюємо потік
        Graphics m_Graphics;
         Image[] m_Images; // для картинок
         int nom; // номер поточної картинки
         boolean m_fAllLoaded = false;  // для перевірки закінчення завантаження

        Slide(Test obj) {
            amt = obj;
            potok = new Thread(this);    // створюємо і запускаємо потік
            potok.start();
        }

        public void paint(Graphics g) {
            super.paint(g); // Додаємо super.paint для коректної перерисовки
            if (m_fAllLoaded) {   // якщо все введено, виводимо картинку
                g.drawImage(m_Images[nom], 0, 0, this.getWidth(), this.getHeight(), this);
            } else {
                g.drawString("Please, wait...", 10, getSize().height / 2);
            }
        }

        public void run() {
            nom = 0;    // поточний номер картинки
            if (!m_fAllLoaded) {
                repaint();
                m_Graphics = getGraphics();
                m_Images = new Image[amt.count];
                MediaTracker tracker = new MediaTracker(this);
                for (int i = 1; i < amt.count; i++) {
                    m_Images[i] = Toolkit.getDefaultToolkit().getImage(amt.dir + "/" + i + amt.ext); // Коригуємо імена файлів
                    tracker.addImage(m_Images[i], 0);
                }
                try {
                    tracker.waitForAll(); //переконуємося, що всі зображення завантажені
                    m_fAllLoaded = !tracker.isErrorAny();
                } catch (InterruptedException e) { //виключення, виникає, якщо з будь-якої причини процес очікування переривається
                    System.out.println("TRACKER ERROR!!!");
                }
                if (!m_fAllLoaded) {
                    m_Graphics.drawString("Load error",10,getSize().height/2);
                    return;
                }
            }

            while (true) {
                try {
                    repaint();
                    nom++;
                    if (nom == amt.count) {
                        nom = 0; // Повертаємо до першої картинки
                    }
                    Thread.sleep(100); // Задаємо інтервал між зображеннями
                } catch (InterruptedException e) {
                    System.out.println("THREAD ERROR!!!");
                }
            }
        }
    }
}*/

