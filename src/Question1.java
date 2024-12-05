// Student Name/ID: Sarah Scott B00165892
// GUI FINAL ASSESSMENT VERSION 9

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Question1 extends JFrame implements ActionListener {

    // to manage button logic
    private boolean isPower = false;
    private boolean isWashing = false;
    private boolean isLoadSelected = false;

    // properties of our GUI
    JButton powerButton = new JButton("On/Off");
    JButton halfLoad = new JButton("Half Load");
    JButton fullLoad = new JButton("Full Load");
    JButton startWash = new JButton("Start Wash");
    JButton delayedWash = new JButton("Delayed Wash");
    JButton ecoWash = new JButton("Eco");
    JButton hotWash = new JButton("Hot");
    JButton mediumWash = new JButton("Medium");
    JButton quickWash = new JButton("Quick");

    JLabel powerStatus = new JLabel("Off");
    JLabel loadStatus = new JLabel("");
    JLabel startStatus = new JLabel("");
    JLabel washStatus = new JLabel("");


    // constructor
    public Question1() {
        // frame settings
        setTitle("Dishwasher");
        setLocation(500, 200);
        setSize(1000, 100);
        setResizable(false);

        // create container
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(1,3));

        // create panels
        JPanel powerPanel = new JPanel();
        powerPanel.setLayout(new BorderLayout());
        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new GridLayout(2,2));
        JPanel modesPanel1 = new JPanel();
        modesPanel1.setLayout(new GridLayout(2,2));
        JPanel modesPanel2 = new JPanel();
        modesPanel2.setLayout(new GridLayout(2,2));

        // create listeners for buttons
        powerButton.addActionListener(this);
        halfLoad.addActionListener(this);
        fullLoad.addActionListener(this);
        startWash.addActionListener(this);
        delayedWash.addActionListener(this);
        ecoWash.addActionListener(this);
        hotWash.addActionListener(this);
        mediumWash.addActionListener(this);
        quickWash.addActionListener(this);

        // style buttons
        powerButton.setBackground(Color.RED);
        halfLoad.setBackground(Color.GRAY);
        fullLoad.setBackground(Color.GRAY);
        startWash.setBackground(Color.GRAY);
        delayedWash.setBackground(Color.GRAY);
        ecoWash.setBackground(Color.GRAY);
        hotWash.setBackground(Color.GRAY);
        mediumWash.setBackground(Color.GRAY);
        quickWash.setBackground(Color.GRAY);

        // style status labels
        powerStatus.setOpaque(true);
        washStatus.setOpaque(true);
        startStatus.setOpaque(true);
        loadStatus.setOpaque(true);
        powerStatus.setBackground(Color.lightGray);
        startStatus.setBackground(Color.lightGray);
        washStatus.setBackground(Color.lightGray);
        loadStatus.setBackground(Color.lightGray);

        // add buttons and labels to panels
        powerPanel.add(powerButton);
        statusPanel.add(powerStatus);
        statusPanel.add(loadStatus);
        statusPanel.add(washStatus);
        statusPanel.add(startStatus);
        modesPanel1.add(startWash);
        modesPanel1.add(delayedWash);
        modesPanel1.add(halfLoad);
        modesPanel1.add(fullLoad);
        modesPanel2.add(ecoWash);
        modesPanel2.add(hotWash);
        modesPanel2.add(mediumWash);
        modesPanel2.add(quickWash);

        // make visible
        contentPane.add(powerPanel);
        contentPane.add(statusPanel);
        contentPane.add(modesPanel1);
        contentPane.add(modesPanel2);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        // turn on/off, update status, stop washing if true
        if (source == powerButton) {
            // toggle power
            if (isPower) {
                isPower = false;
                powerButton.setBackground(Color.red);
                powerStatus.setText("Off");
                powerStatus.setBackground(Color.lightGray);

                isWashing = false;
                washStatus.setText("");

                isLoadSelected = false;
                loadStatus.setText("");

                startStatus.setText("");

                // reset coloring
                halfLoad.setBackground(Color.GRAY);
                fullLoad.setBackground(Color.GRAY);
                startWash.setBackground(Color.GRAY);
                delayedWash.setBackground(Color.GRAY);
                ecoWash.setBackground(Color.GRAY);
                hotWash.setBackground(Color.GRAY);
                mediumWash.setBackground(Color.GRAY);
                quickWash.setBackground(Color.GRAY);
                startStatus.setBackground(Color.lightGray);
                washStatus.setBackground(Color.lightGray);
                loadStatus.setBackground(Color.lightGray);
            }
            else {
                isPower = true;
                powerButton.setBackground(Color.green);
                powerStatus.setText("On");
                powerStatus.setBackground(Color.green);

                // "light up" buttons
                halfLoad.setBackground(Color.lightGray);
                fullLoad.setBackground(Color.lightGray);
                startWash.setBackground(Color.lightGray);
                delayedWash.setBackground(Color.lightGray);
                ecoWash.setBackground(Color.lightGray);
                hotWash.setBackground(Color.lightGray);
                mediumWash.setBackground(Color.lightGray);
                quickWash.setBackground(Color.lightGray);
                startStatus.setBackground(Color.lightGray);
                washStatus.setBackground(Color.lightGray);
                loadStatus.setBackground(Color.lightGray);
            }
        }

        // set half load
        if (source == halfLoad && isPower && !isWashing) {
            isLoadSelected = true;
            halfLoad.setBackground(Color.green);
            loadStatus.setText("Half Load");
            loadStatus.setBackground(Color.lightGray);

            // either full or half load must be selected, not both
            fullLoad.setBackground(Color.GRAY);
        }

        // set full load
        if (source == fullLoad && isPower && !isWashing) {
            isLoadSelected = true;
            fullLoad.setBackground(Color.green);
            loadStatus.setText("Full Load");
            loadStatus.setBackground(Color.lightGray);

            // either full or half load must be selected, not both
            halfLoad.setBackground(Color.GRAY);
        }

        // set eco wash
        if (source == ecoWash && isPower && !isWashing) {
            ecoWash.setBackground(Color.green);
            washStatus.setText("Eco Wash");

            // only one of these four options can be selected
            hotWash.setBackground(Color.GRAY);
            mediumWash.setBackground(Color.GRAY);
            quickWash.setBackground(Color.GRAY);
        }

        // set hot wash
        if (source == hotWash && isPower && !isWashing) {
            hotWash.setBackground(Color.green);
            washStatus.setText("Hot Wash");

            // only one of these four options can be selected
            ecoWash.setBackground(Color.GRAY);
            mediumWash.setBackground(Color.GRAY);
            quickWash.setBackground(Color.GRAY);
        }

        // set medium wash
        if (source == mediumWash && isPower && !isWashing) {
            mediumWash.setBackground(Color.green);
            washStatus.setText("Medium Wash");

            // only one of these four options can be selected
            ecoWash.setBackground(Color.GRAY);
            hotWash.setBackground(Color.GRAY);
            quickWash.setBackground(Color.GRAY);
        }

        // set quick wash
        if (source == quickWash && isPower && !isWashing) {
            quickWash.setBackground(Color.green);
            washStatus.setText("Quick Wash");

            // only one of these four options can be selected
            hotWash.setBackground(Color.GRAY);
            mediumWash.setBackground(Color.GRAY);
            ecoWash.setBackground(Color.GRAY);
        }

        // start a wash
        if (source == startWash && isPower && !isWashing) {
            if (isLoadSelected) {
                isWashing = true;
                startStatus.setText("Wash Cycle Started");
                startStatus.setBackground(Color.green);
            }
            else {
                loadStatus.setText("Please select Load!");
                loadStatus.setBackground(Color.red);
            }
        }

        // delayed wash
        if (source == delayedWash && isPower && !isWashing) {
            if (isLoadSelected) {
                startStatus.setText("Delayed Start in 12 Hours");
                startStatus.setBackground(Color.orange);
            }
            else {
                loadStatus.setText("Please select Load!");
                loadStatus.setBackground(Color.red);
            }
        }

    }




    public static void main(String[] args) {
        JFrame frame = new Question1();
    }
}