// Student Name/ID: Sarah Scott B00165892

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Question2 extends JFrame implements MouseMotionListener {

    JLabel label = new JLabel("Drag the mouse in here to see image!");
    ImageIcon image = new ImageIcon("images//cat.jpg");
    private int count = 1;

    public Question2() {
        // frame settings
        setTitle("Drag the Mouse!");
        setLocation(500, 200);
        setSize(700, 700);
        setResizable(false);

        // create container
        Container contentPane = getContentPane();

        //create panel
        JPanel panel = new JPanel();

        // style label
        label.setBorder(BorderFactory.createLineBorder(Color.black, 5, true));

        // create listeners
        label.addMouseMotionListener(this);

        // make visible
        panel.add(label);
        contentPane.add(panel);
        setVisible(true);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // increment count, count starts at 1
        count++;

        // when count is odd, dragging displays image
        if (count % 2 == 1) {
            label.setText("");
            label.setIcon(image);

        }

        // when count is even, dragging displays text
        if (count % 2 == 0) {
            label.setText("Drag the mouse in here to see image!");
            label.setIcon(null);

        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // do nothing
    }

    public static void main(String[] args) {
        JFrame frame = new Question2();
    }

}
