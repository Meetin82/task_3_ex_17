package ru.vsu.cs.semenov_d_s;

import ru.vsu.cs.semenov_d_s.utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RearrangementOfWords {

    public String[] rearrangeWordsWithMyQueue(String text) throws Exception {
        String[] arr = splitWordsIntoArray(text);

        List<String> list = new ArrayList<>(Arrays.asList(arr));

        MyQueue<String> myQueue = new MyQueue<>();

        int sizeLesserWord = list.get(0).length();
        int indexLesserWord = 0;

        while (list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).length() >= sizeLesserWord) {
                    sizeLesserWord = list.get(i).length();
                    indexLesserWord = i;
                }
            }
            myQueue.add(list.get(indexLesserWord));
            list.remove(indexLesserWord);
            if (list.size() > 0) {
                sizeLesserWord = list.get(0).length();
            }
        }
        return Utils.myQueueToArray(myQueue);
    }

    public String[] rearrangeWordsWithQueue(String text) throws Exception {
        String[] arr = splitWordsIntoArray(text);

        List<String> list = new ArrayList<>(Arrays.asList(arr));

        Queue<String> queue = new LinkedList<>();

        int sizeLesserWord = list.get(0).length();
        int indexLesserWord = 0;

        while (list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).length() >= sizeLesserWord) {
                    sizeLesserWord = list.get(i).length();
                    indexLesserWord = i;
                }
            }
            queue.add(list.get(indexLesserWord));
            list.remove(indexLesserWord);
            if (list.size() > 0) {
                sizeLesserWord = list.get(0).length();
            }
        }
        return Utils.queueToArray(queue);
    }

    private String[] splitWordsIntoArray(String text) {
        return text.split("[^A-Za-zА-Яа-я0-9]");
    }
}
