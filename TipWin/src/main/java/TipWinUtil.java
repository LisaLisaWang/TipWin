package main.java;

import javax.swing.*;
import java.awt.*;

public class TipWinUtil {

    private TipWindow tw = null;
    private JTextArea textArea = null;
    private String message = null;

    public void init() {

        textArea = new JTextArea(message);
        textArea.setEditable(false);
        textArea.setFont(new Font("黑体", Font.PLAIN, 15));
        textArea.setForeground(Color.YELLOW);
        textArea.setBackground(Color.BLACK);
        textArea.setAutoscrolls(true);
        textArea.setLineWrap(true);
        textArea.getColorModel();

        tw = new TipWindow(PropertiesUtil.winWidth, PropertiesUtil.winHeight); // 消息提示框400*50
        tw.add(textArea, BorderLayout.CENTER);
    }

    public Window show(String message) {
        this.message = message;

        init();

        tw.setAlwaysOnTop(true);
        tw.setUndecorated(true);
        tw.setResizable(false);
        tw.setVisible(true);
        tw.run();
        return tw;
    }
}

class TipWindow extends JDialog {

    private static final long serialVersionUID = 8541659783234673950L;
    private static Dimension dim;
    private int x, y;
    private int width, height;
    private static Insets screenInsets;

    public TipWindow(int width, int height) {
        this.width = width;
        this.height = height;
        dim = Toolkit.getDefaultToolkit().getScreenSize();
        screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(
            this.getGraphicsConfiguration());
        x = (int) (dim.getWidth() - width - 3);
        y = (int) (dim.getHeight() - screenInsets.bottom - 3);

        initComponents();
    }

    public void run() {
        this.setLocation(x, y - PropertiesUtil.winHeight);

        try {
            Thread.sleep(PropertiesUtil.winSleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void initComponents() {
        this.setSize(width, height);
        this.setLocation(x, y);
    }
}
