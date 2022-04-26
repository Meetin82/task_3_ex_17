package ru.vsu.cs.semenov_d_s;

import org.junit.Assert;
import org.junit.Test;

public class TestRearrangementOfWords {

    RearrangementOfWords rearrangementOfWords = new RearrangementOfWords();

    @Test
    public void testRearrangementOfWords1() throws Exception {
        String text = "Я опять на районе потерял себя в одном из дворов";

        String[] expectedResult = {"потерял", "дворов", "районе", "одном", "опять", "себя", "из", "на", "в", "Я"};

        String[] factualResultWithMyQueue = rearrangementOfWords.rearrangeWordsWithMyQueue(text);
        String[] factualResultWithQueue = rearrangementOfWords.rearrangeWordsWithQueue(text);

        Assert.assertArrayEquals(expectedResult, factualResultWithMyQueue);
        Assert.assertArrayEquals(expectedResult, factualResultWithQueue);
    }

    @Test
    public void testRearrangementOfWords2() throws Exception {
        String text = "Ты опять мне трезвонишь чтобы знать что я жив и здоров";

        String[] expectedResult = {"трезвонишь", "здоров", "знать", "чтобы", "опять", "жив", "что", "мне", "Ты", "и", "я"};

        String[] factualResultWithMyQueue = rearrangementOfWords.rearrangeWordsWithMyQueue(text);
        String[] factualResultWithQueue = rearrangementOfWords.rearrangeWordsWithQueue(text);

        Assert.assertArrayEquals(expectedResult, factualResultWithMyQueue);
        Assert.assertArrayEquals(expectedResult, factualResultWithQueue);
    }

    @Test
    public void testRearrangementOfWords3() throws Exception {
        String text = "А";

        String[] expectedResult = {"А"};

        String[] factualResultWithMyQueue = rearrangementOfWords.rearrangeWordsWithMyQueue(text);
        String[] factualResultWithQueue = rearrangementOfWords.rearrangeWordsWithQueue(text);

        Assert.assertArrayEquals(expectedResult, factualResultWithMyQueue);
        Assert.assertArrayEquals(expectedResult, factualResultWithQueue);
    }

    @Test
    public void testRearrangementOfWords4() throws Exception {
        String text = "";

        String[] expectedResult = {""};

        String[] factualResultWithMyQueue = rearrangementOfWords.rearrangeWordsWithMyQueue(text);
        String[] factualResultWithQueue = rearrangementOfWords.rearrangeWordsWithQueue(text);

        Assert.assertArrayEquals(expectedResult, factualResultWithMyQueue);
        Assert.assertArrayEquals(expectedResult, factualResultWithQueue);
    }

    @Test
    public void testRearrangementOfWords5() throws Exception {
        String text = "Теперь у нас каждый день как день рождения";

        String[] expectedResult = {"рождения", "каждый", "Теперь", "день", "день", "как", "нас", "у"};

        String[] factualResultWithMyQueue = rearrangementOfWords.rearrangeWordsWithMyQueue(text);
        String[] factualResultWithQueue = rearrangementOfWords.rearrangeWordsWithQueue(text);

        Assert.assertArrayEquals(expectedResult, factualResultWithMyQueue);
        Assert.assertArrayEquals(expectedResult, factualResultWithQueue);
    }
}
