package main.java;

import java.util.ResourceBundle;

public class PropertiesUtil {

    public static String filePath;
    public static int winWidth;
    public static int winHeight;
    public static int winSleep;
    public static int winExit;


    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setWinWidth(int winWidth) {
        this.winWidth = winWidth;
    }

    public void setWinHeight(int winHeight) {
        this.winHeight = winHeight;
    }

    public void setWinSleep(int winSleep) {
        this.winSleep = winSleep;
    }

    public void setWinExit(int winExit) {
        this.winExit = winExit;
    }

    PropertiesUtil(){
        ResourceBundle resource = ResourceBundle.getBundle("main/resources/application");
        setFilePath(resource.getString("FILE_PATH"));
        setWinHeight(Integer.parseInt(resource.getString("WIN_HEIGHT")));
        setWinWidth(Integer.parseInt(resource.getString("WIN_WIDTH")));
        setWinSleep(Integer.parseInt(resource.getString("WIN_SLEEP"))*1000);
        setWinExit(Integer.parseInt(resource.getString("WIN_EXIT"))*60*1000);
    }
}
