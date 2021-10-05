package com.target.training.programs;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class SynchronizedDemo {

    @AllArgsConstructor
    static class FileProcessor {
        String filename;

        @SneakyThrows
        public void readAndStore(List<String> list) {
            try (FileReader reader = new FileReader(filename);
                 BufferedReader in = new BufferedReader(reader);) {
                String line;
                while ((line = in.readLine()) != null) {
                    synchronized (list) {
                        list.add(line);
                    }
                }
            }
        }
    }


    @SneakyThrows
    static void waitForThreadToFinish(Thread t){
        t.join();
    }

    @SneakyThrows
    public static void main(String[] args) {

        List<String> list = new ArrayList<>(1000);

        String[] filenames = {
                "f1.txt",
                "f2.txt",
                "f3.txt"
        };

        List<Thread> threads = new ArrayList<>();

        for (String filename : filenames) {
            Thread t = new Thread(() -> new FileProcessor(filename).readAndStore(list));
            t.start();
            threads.add(t);
        }

        // need to call .join() on each thread
        threads.forEach(SynchronizedDemo::waitForThreadToFinish);

        for(String line: list){
            System.out.println(line);
        }

    }
}
