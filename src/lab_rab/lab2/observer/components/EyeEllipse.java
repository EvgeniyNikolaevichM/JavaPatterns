package lab_rab.lab2.observer.components;

import lab_rab.lab2.observer.ControlRole;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class EyeEllipse extends ObserverComponent {
    private boolean isOpen;
    private final int offset = 15;

    EyeEllipse(int x, int y, int width, int height, ControlRole role) {
        super(x, y, width, height, role);
        this.isOpen = true;
    }


    //Параметры, которые определяют открыт глаз или нет:
    //Здесь также работа с файлом ObserverComponent, update меняет true на false
    @Override
    void onUpdate() {
        this.isOpen = !this.isOpen;
    }

    private int halfWidth() {
        return width / 2;
    }

    private int halfHeight() {
        return height / 2;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setPaint(Color.BLACK);
        g2.setStroke(new BasicStroke(2.0f));
        g2.draw(new Ellipse2D.Double(0, 0, width, height));


        Color myColor = new Color(99,69,51);
        g2.setPaint(myColor);
        int x = halfWidth() - offset;
        int y = halfHeight() - offset;

        //В зависимости от того открыт глаз или геь, то рисуем либо овал , либо линию:

        if (isOpen) {//Если открыт, то рисуем овал:
            g2.setStroke(new BasicStroke(1f));
            g2.fill(new Ellipse2D.Double(x, y, 30, 30));
        } else {//Если закрыт, то линию:
            g2.setStroke(new BasicStroke(3f));
            g2.drawLine(x, halfHeight(), halfWidth() + offset, halfHeight());
        }
    }
}
