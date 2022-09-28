package file;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class WorkWithFle {

    public  String readFromFileToString() {
        Path filePath = Path.of("D:/learn/semester 3/технологія захисту інформації/lab1/src/file.txt");
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream
                     = Files.lines(Paths.get(filePath.toUri()), StandardCharsets.UTF_8)) {
            //Read the content with Stream
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String fileContent = contentBuilder.toString();
        return fileContent;
    }

    public void writeToFile(String string) throws IOException {

        String path = "D:/learn/semester 3/технологія захисту інформації/lab1/src/file2.txt";
        Files.write(Paths.get(path), string.getBytes());

        char firstChar = string.charAt(0);
        for(int i = 0; i<string.length(); i++) {

            // access each character
            int  a = string.charAt(i);
            System.out.print(a + ", ");
        }
    }
     public void display( String string){
        System.out.println(string);
     }

}
