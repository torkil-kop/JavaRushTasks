package com.javarush.task.task19.task1917;

import java.io.*;
import java.nio.charset.Charset;

/* 
Свой FileWriter
*/

public class FileConsoleWriter  {
    private FileWriter fileWriter;

    public FileConsoleWriter(String fileName) throws IOException {

        this.fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {

        this.fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {

        this.fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {

        this.fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {

        this.fileWriter = new FileWriter(fd);
    }

   /* public FileConsoleWriter(String fileName, Charset charset) throws IOException {

        this.fileWriter = new FileWriter(fileName, charset);
    }

    public FileConsoleWriter(String fileName, Charset charset, boolean append) throws IOException {

        this.fileWriter = new FileWriter(fileName, charset, append);
    }

    public FileConsoleWriter(File file, Charset charset) throws IOException {

        this.fileWriter = new FileWriter(file, charset);
    }

    public FileConsoleWriter(File file, Charset charset, boolean append) throws IOException {

        this.fileWriter = new FileWriter(file, charset, append);
    }

    */

    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
       for (int i = off; i < off + len; i++) {
            System.out.print(cbuf[i]);
        }

       // System.out.println(cbuf);
    }

    public void write(int c) throws IOException {
        fileWriter.write(c);
        System.out.println((char) c);
    }

    public void write(String str) throws IOException {
        fileWriter.write(str);
        System.out.println(str);
    }

    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);
       System.out.print(new StringBuffer(str).substring(off, off + len));
       // System.out.println(str);
    }

    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
       /*for (char c:cbuf
             ) {
            System.out.print(c);
        }

        */
        System.out.print(cbuf);
    }

    public void close() throws IOException {
        fileWriter.close();
    }

    public static void main(String[] args) throws IOException {
/*FileConsoleWriter fileConsoleWriter = new  FileConsoleWriter("e:\\111.txt");
char[] chars = new char[] { '1', 'a', 'd' };
fileConsoleWriter.write(chars);
fileConsoleWriter.close();



FileWriter fileWriter1 = new FileWriter("e:\\111.txt");
        fileWriter1.write("WFWFWFWFWFW", 0, 3);
        fileWriter1.close();


 */

    }

}
