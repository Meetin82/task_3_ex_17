package ru.vsu.cs.semenov_d_s.utils;

import ru.vsu.cs.semenov_d_s.MyQueue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.Queue;

public class Utils {

    public static String readTextFromFile(String fileName) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        try (Scanner scanner = new Scanner(new File(fileName), "UTF-8")) {
            while (scanner.hasNext()) {
                sb.append(scanner.nextLine());
            }
        }
        return sb.toString();
    }

    public static void writeTextToFile(String fileName, String text, String itemFormat)
            throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter(fileName)) {
            out.println(text);
        }
    }

    public static void writeTextToFile(String fileName, String text)
            throws FileNotFoundException {
        writeTextToFile(fileName, text, null);
    }

    public static String[] myQueueToArray(MyQueue<String> queue) throws Exception {
        String[] arr = new String[queue.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = queue.remove();
        }
        return arr;
    }

    public static String[] queueToArray(Queue<String> queue) throws Exception {
        String[] arr = new String[queue.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = queue.remove();
        }
        return arr;
    }

    public static String arrayToString(String[] arr) {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            text.append(arr[i]);
            if (i != arr.length - 1) {
                text.append(" ");
            }
        }
        return text.toString();
    }
}
