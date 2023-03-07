package me.night0721.updater;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Thread.sleep(Integer.parseInt(args[0]));
        File modFile = new File(args[1]);
        if (!modFile.delete()) {
            JOptionPane.showMessageDialog(null, "Update failed! Couldn't delete the file provided.");
            return;
        }
        if (args[2].equals("mainrepo")) {
            downloadFile(modFile.getPath());
//            FileUtils.copyURLToFile(new URL("https://github.com/night0721/Lilase/releases/latest/download/Lilase.jar"), modFile);
            JOptionPane.showMessageDialog(null, "Updated Aurora!");
            System.exit(0);
        }
    }
    private static void downloadFile(String filePath) throws IOException {
        URL url = new URL("https://github.com/night0721/Lilase/releases/latest/download/Lilase.jar");
        try (InputStream in = url.openStream();
             FileOutputStream out = new FileOutputStream(filePath)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }
}
