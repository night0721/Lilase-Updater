import org.apache.commons.io.FileUtils;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
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
            FileUtils.copyURLToFile(new URL("https://github.com/night0721/Lilase/releases/latest/download/Lilase.jar"), modFile);
            JOptionPane.showMessageDialog(null, "Updated Aurora!");
            System.exit(0);
        }
    }
}
