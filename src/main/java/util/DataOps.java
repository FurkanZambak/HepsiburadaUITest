package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DataOps {

    public void writeDataToFile(String text) {
        try {
            Path fileName = Path.of(PropertyManager.getInstance().getDataFilePath());
            Files.writeString(fileName, text);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readFile() {
        String fileString = "";
        try {
            Path fileName = Path.of(PropertyManager.getInstance().getDataFilePath());
            fileString = Files.readString(fileName);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return fileString;
    }
}
