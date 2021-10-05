package com.target.training.programs;


import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Slf4j
public class ReadFromFileUsingThreadDemo {

    static class FileProcessor {
        public void process(String filename, FileReader reader){
            try (BufferedReader in = new BufferedReader(reader)) {
                String line;
                while((line=in.readLine())!=null){
                    log.debug("Filename = {}, line = {}", filename, line.toUpperCase());
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    @SneakyThrows
    public static void main(String[] args) {
        String filename1 = "src/main/java/com/target/training/programs/EndlessLoop.java";
        String filename2 = "src/main/java/com/target/training/programs/LoggingDemo.java";
        String filename3 = "src/main/java/com/target/training/programs/ThreadDemo.java";


        Thread t1;
        Thread t2;
        Thread t3;
        try (FileReader file1 = new FileReader(filename1);
             FileReader file2 = new FileReader(filename2);
             FileReader file3 = new FileReader(filename3)) {

            FileProcessor fp = new FileProcessor();

            t1 = new Thread(() -> fp.process(filename1, file1));
            t2 = new Thread(() -> fp.process(filename2, file2));
            t3 = new Thread(() -> fp.process(filename3, file3));

            t1.start();
            t2.start();
            t3.start();


            t1.join();
            t2.join();
            t3.join();
        }

        log.debug("End of main()");
    }
}
