package main.java;

import java.awt.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class main {

    public static Window w1;
    public static Window w2;

    public static void main(String[] args) {

        intiConfig();

        setTimer();

        TipWinUtil win = new TipWinUtil();
        List<String> data = new ArrayList<>();
        Path path = Paths.get(PropertiesUtil.filePath);
        try {
            data = Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < data.size(); i++) {
            if (i % 2 == 0) {
                w1 = win.show(data.get(i));
                if (w2 != null) w2.dispose();
            } else {
                w2 = win.show(data.get(i));
                if (w1 != null) w1.dispose();
            }
        }

        if (w1 != null) w1.dispose();
        if (w2 != null) w2.dispose();
    }

    private static void intiConfig() {
        new PropertiesUtil();
    }

    private static void setTimer(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override public void run() {
                System.exit(-1);
            }
        }, PropertiesUtil.winExit);
    }
}
