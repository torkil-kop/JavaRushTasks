package com.javarush.task.task31.task3101;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Проход по дереву файлов
*/

public class Solution {
    public static void main(String[] args) {
//        Solution solution = new Solution();
//        File file0 = new File(args[0]);
//        File file = new File(args[1]);
//        File newFile = new File("e:/allFilesContent.txt");
//        List<File> fileList = new ArrayList<>();
//        solution.fileList(file0, fileList);
//          FileUtils.renameFile(file, newFile);
////        for (File ff : fileList
////        ) {
////            System.out.println(ff.toString());
////        }
//        for (File ff:fileList
//             ) {
////            try (FileInputStream fileInputStream = new FileInputStream(ff);
////                 FileOutputStream fileOutputStream = new FileOutputStream(newFile)) {
//            try  {
//                FileInputStream fileInputStream = new FileInputStream(ff);
//                FileOutputStream fileOutputStream = new FileOutputStream(newFile, true);
//                if (ff.length() <= 50){
//                    byte[] buffer = new byte[50];
//                    while (fileInputStream.available()>0){
//                       int b = fileInputStream.read(buffer);
//                        fileOutputStream.write(buffer, 0, b);
//
//                    }
//
//                    fileOutputStream.write(10);
////                    fileOutputStream.flush();
//                }
//                fileInputStream.close();
//                fileOutputStream.close();
//            }
//            catch (Exception e){
//                e.printStackTrace();
//            }
//
//        }
//
//
//    }
//
//    //    public void wrightFile(String path, File outputFile){
////        File file = new File(path);
////        try(FileInputStream fileInputStream = new FileInputStream(file);
////        FileOutputStream fileOutputStream = new FileOutputStream(outputFile)) {
////
////        }
////    }
//    public void fileList(File file, List<File> fileList) {
//        for (File f : file.listFiles()
//        ) {
//            if (f.isDirectory()) {
//                fileList(f, fileList);
//            } else {
//                fileList.add(f);
//            }
//        }
//    }
//}
        String path = args[0];
        String resultFileAbsolutePath = args[1];
        try {
            File resultFile = new File(resultFileAbsolutePath);
            File dest = new File(resultFile.getParentFile() + "/allFilesContent.txt");
            if (FileUtils.isExist(dest)) {
                FileUtils.deleteFile(dest);
            }
            FileUtils.renameFile(resultFile, dest);

            Map<String, byte[]> fileTree = getFileTree(path);
            try (FileOutputStream fileOutputStream = new FileOutputStream(dest)) {
                for (byte[] bytes : fileTree.values()) {
                    fileOutputStream.write(bytes);
                    fileOutputStream.write("\n".getBytes());
                }
            }
        } catch (IOException ignored) {
        }
    }

    public static Map<String, byte[]> getFileTree(String root) throws IOException {
        Map<String, byte[]> result = new TreeMap<>();

        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        Files.walkFileTree(Paths.get(root), options, 20, new GetFiles(result));

        return result;
    }

    private static class GetFiles extends SimpleFileVisitor<Path> {
        private Map<String, byte[]> result;

        public GetFiles(Map<String, byte[]> result) {
            this.result = result;
        }

        @Override
        public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
            File file = path.toFile();
            if (file.isFile()) {
                if (file.length() <= 50) {
                    result.put(path.getFileName().toString(), Files.readAllBytes(path));
                }
            }
            return super.visitFile(path, basicFileAttributes);
        }
    }
}
/*
1. На вход метода main() подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя (полный путь) существующего файла, который будет содержать результат.
2. Переименовать resultFileAbsolutePath в allFilesContent.txt (используй метод FileUtils.renameFile(), и, если понадобится, FileUtils.isExist()).
3. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
Если у файла длина в байтах НЕ больше 50, то записать его содержимое в allFilesContent.txt.
После каждого тела файла записать "\n".
Все файлы имеют расширение txt.
В качестве разделителя пути используй "/".
Для создания файлов используй конструктор File(String pathname).


Requirements:
1. Файл, который приходит вторым параметром в main, должен быть переименован в allFilesContent.txt.
2. Нужно создать поток для записи в переименованный файл.
3. Содержимое всех файлов, размер которых не превышает 50 байт, должно быть записано в файл allFilesContent.txt.
4. Поток для записи в файл нужно закрыть.
5. Не используй статические переменные.
 */