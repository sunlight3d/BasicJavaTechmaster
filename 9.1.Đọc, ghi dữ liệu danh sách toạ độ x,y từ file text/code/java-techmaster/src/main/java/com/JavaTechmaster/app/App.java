/*
* Khoá học Java căn bản + nâng cao, Techmaster Vietnam
* https://techmaster.vn
* Author: Mr Nguyen Duc Hoang
* */
package com.JavaTechmaster.app;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main( String[] args ) {
        System.out.println("Đọc dữ liệu x,y từ file text");
        Path path = Paths.get("/Users/hoangnd/Documents/inputData.txt");
        Path destinationPath = Paths.get("/Users/hoangnd/Documents/inputData2.txt");
        List<String> lines = new ArrayList<String>();
        try {
            lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            lines.forEach(line ->{
                String[] xy = line.split(";");
                System.out.println("x = "+xy[0]+" y = "+xy[1]);
            });
            //Ghi thêm dữ liệu vào file destination
            Files.write(destinationPath, lines.toString().getBytes());
        } catch (IOException | SecurityException e) {
            System.out.println("Cannot read from file"+e.toString());
        }
    }
}
