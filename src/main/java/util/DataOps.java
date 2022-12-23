package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DataOps {

    public void writeDataToFile(String text) {
        try {
            Path fileName = Path.of(PropertyManager.getInstance().getDataFilePath());
            Files.writeString(fileName, text);
            //log.info("Txt dosyaya yazma işlemi başarılı");
        }
        catch (IOException e) {
            //log.error("Txt dosya yazma işleminde hata", e.getMessage());
        }
    }

    public String readFile() {
        String fileString = "";
        try {
            Path fileName = Path.of(PropertyManager.getInstance().getDataFilePath());
            fileString = Files.readString(fileName);
            //log.info("Txt dosya okuma işlemi başarılı");
        }
        catch (IOException e) {
            //log.error("Txt dosya okuma işleminde hata var", e.getMessage());
        }
        return fileString;
    }
}
