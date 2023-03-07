package me.night0721.updater;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Thread.sleep(Integer.parseInt(args[0]));
        File modFile = new File(args[1]);
        if (!modFile.delete()) {
            JOptionPane.showMessageDialog(null, "Update failed! Couldn't delete the file provided.");
            System.exit(0);
        }
        if (args[2].equals("mainrepo")) {
            URL url = new URL("https://github.com/night0721/Lilase/releases/latest/download/Lilase.jar");
            Files.copy(url.openStream(), Paths.get(modFile.getPath()));
            JOptionPane.showMessageDialog(null, "Updated Aurora!");
            System.exit(0);
        }
    }
}
