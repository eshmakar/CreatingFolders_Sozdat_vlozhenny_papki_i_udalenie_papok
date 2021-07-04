package com.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

public class VlozhennyePapki {
    public static void createDirs(String createPath) {
        if (new File(createPath).mkdir()) { //если указанная путь не существует, создает
            for (int i = 0; i < 200; i++) {
                String digits = "/" + i; //вложенная папка по такому символу (здесь номера)
                if (new File(createPath + digits.repeat(7_000)).mkdirs()) //создает вложенные папки 0/0... 7 тыс раз
                    System.out.println("Gotovo " + i);
            }
        }
    }

    public static void deleteDirs(String deletePath) throws IOException {//после папки указать слеш, вот так: "Z:/1/"
        System.out.println("Идет удаление, подождите...");
        long start = System.currentTimeMillis();
        Files.walk(Paths.get(deletePath)).sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(File::delete);
        long end = System.currentTimeMillis();
        double time = (double) (end - start) / 1000 / 60;
        System.out.println("Gotovo, proshlo: " + time + " min.");
    }

    public static void main(String[] args) throws IOException {
//        createDirs("Z:/1");
        deleteDirs("E:/0/");

    }
}
