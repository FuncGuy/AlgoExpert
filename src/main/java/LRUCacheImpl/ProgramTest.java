package LRUCacheImpl;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class ProgramTest {
    HashMap<String, Integer> letterMaps = new HashMap<>();
    String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};

    public ProgramTest() {
        letterMaps.put("a", 0);
        letterMaps.put("b", 1);
        letterMaps.put("c", 2);
        letterMaps.put("d", 3);
        letterMaps.put("e", 4);
        letterMaps.put("f", 5);
        letterMaps.put("g", 6);
        letterMaps.put("h", 7);
        letterMaps.put("i", 8);
        letterMaps.put("j", 9);
    }

    @Test
    public void TestCase1() {
        testLruOfSize(1);
    }

    @Test
    public void TestCase2() {
        testLruOfSize(2);
    }

    @Test
    public void TestCase3() {
        testLruOfSize(3);
    }

    @Test
    public void TestCase4() {
        testLruOfSize(4);
    }

    @Test
    public void TestCase5() {
        testLruOfSize(5);
    }

    @Test
    public void TestCase6() {
        testLruOfSize(6);
    }

    @Test
    public void TestCase7() {
        testLruOfSize(7);
    }

    @Test
    public void TestCase8() {
        testLruOfSize(8);
    }

    @Test
    public void TestCase9() {
        testLruOfSize(9);
    }

    @Test
    public void TestCase10() {
        testLruOfSize(10);
    }

    public void testLruOfSize(int lruSize) {
        /* Instantiate cache and insert first key. */
        Program.LRUCache lru = new Program.LRUCache(lruSize);
        Assert.assertTrue(lru.getValueFromKey("a").found == false);
        lru.insertKeyValuePair("a", 99);
        Assert.assertTrue(lru.getMostRecentKey() == "a");
        Assert.assertTrue(lru.getValueFromKey("a").value == 99);
        /* Add existing key when cache isn't full. */
        lru.insertKeyValuePair("a", 0);
        Assert.assertTrue(lru.getMostRecentKey() == "a");
        Assert.assertTrue(lru.getValueFromKey("a").value == 0);
        /* Add keys until cache reaches maximum capacity. */
        for (int i = 1; i < lruSize; i++) {
            String mostRecentLetter = letters[i - 1];
            Assert.assertTrue(lru.getMostRecentKey() == mostRecentLetter);
            /* Test key retrieval when cache isn't full. */
            for (int j = 0; j < i; j++) {
                String letter = letters[j];
                Assert.assertTrue(lru.getValueFromKey(letter).value == letterMaps.get(letter));
                Assert.assertTrue(lru.getMostRecentKey() == letter);
            }
            String currentLetter = letters[i];
            Assert.assertTrue(lru.getValueFromKey(currentLetter).found == false);
            lru.insertKeyValuePair(currentLetter, letterMaps.get(currentLetter));
            Assert.assertTrue(lru.getMostRecentKey() == currentLetter);
            Assert.assertTrue(lru.getValueFromKey(currentLetter).value == letterMaps.get(currentLetter));
        }
        /* Add keys now that cache is at maximum capacity. */
        for (int i = lruSize; i < letters.length; i++) {
            String mostRecentLetter = letters[i - 1];
            Assert.assertTrue(lru.getMostRecentKey() == mostRecentLetter);
            /* Test key retrieval when cache is full. */
            for (int j = i - lruSize; j < i; j++) {
                String letter = letters[j];
                Assert.assertTrue(lru.getValueFromKey(letter).value == letterMaps.get(letter));
                Assert.assertTrue(lru.getMostRecentKey() == letter);
            }
            String leastRecentLetter = letters[i - lruSize];
            String currentLetter = letters[i];
            Assert.assertTrue(lru.getValueFromKey(currentLetter).found == false);
            lru.insertKeyValuePair(currentLetter, letterMaps.get(currentLetter));
            Assert.assertTrue(lru.getMostRecentKey() == currentLetter);
            Assert.assertTrue(lru.getValueFromKey(currentLetter).value == letterMaps.get(currentLetter));
            Assert.assertTrue(lru.getValueFromKey(leastRecentLetter).found == false);
        }
        /* Add existing keys. */
        for (int i = letters.length - lruSize; i < letters.length; i++) {
            String currentLetter = letters[i];
            Assert.assertTrue(lru.getValueFromKey(currentLetter).value == letterMaps.get(currentLetter));
            lru.insertKeyValuePair(currentLetter, (letterMaps.get(currentLetter) + 1) * 100);
            Assert.assertTrue(
                    lru.getValueFromKey(currentLetter).value == (letterMaps.get(currentLetter) + 1) * 100);
        }
    }
}
