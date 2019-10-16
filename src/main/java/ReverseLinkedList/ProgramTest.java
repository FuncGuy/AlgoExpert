package ReverseLinkedList;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class ProgramTest {
    @Test
    public void TestCase1() {
        Program.LinkedList test = newLinkedList(new int[]{0});
        ArrayList<Integer> result = toArrayList(Program.reverseLinkedList(test));
        int[] expected = new int[]{0};
        assertTrue(arraysEqual(result, expected));
    }

    @Test
    public void TestCase2() {
        Program.LinkedList test = newLinkedList(new int[]{0, 1});
        ArrayList<Integer> result = toArrayList(Program.reverseLinkedList(test));
        int[] expected = new int[]{1, 0};
        assertTrue(arraysEqual(result, expected));
    }

    @Test
    public void TestCase3() {
        Program.LinkedList test = newLinkedList(new int[]{0, 1, 2});
        ArrayList<Integer> result = toArrayList(Program.reverseLinkedList(test));
        int[] expected = new int[]{2, 1, 0};
        assertTrue(arraysEqual(result, expected));
    }

    @Test
    public void TestCase4() {
        Program.LinkedList test = newLinkedList(new int[]{0, 1, 2, 3});
        ArrayList<Integer> result = toArrayList(Program.reverseLinkedList(test));
        int[] expected = new int[]{3, 2, 1, 0};
        assertTrue(arraysEqual(result, expected));
    }

    @Test
    public void TestCase5() {
        Program.LinkedList test = newLinkedList(new int[]{0, 1, 2, 3, 4});
        ArrayList<Integer> result = toArrayList(Program.reverseLinkedList(test));
        int[] expected = new int[]{4, 3, 2, 1, 0};
        assertTrue(arraysEqual(result, expected));
    }

    @Test
    public void TestCase6() {
        Program.LinkedList test = newLinkedList(new int[]{0, 1, 2, 3, 4, 5});
        ArrayList<Integer> result = toArrayList(Program.reverseLinkedList(test));
        int[] expected = new int[]{5, 4, 3, 2, 1, 0};
        assertTrue(arraysEqual(result, expected));
    }

    @Test
    public void TestCase7() {
        Program.LinkedList test = newLinkedList(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12});
        ArrayList<Integer> result = toArrayList(Program.reverseLinkedList(test));
        int[] expected = new int[]{12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        assertTrue(arraysEqual(result, expected));
    }

    public Program.LinkedList newLinkedList(int[] values) {
        Program.LinkedList ll = new Program.LinkedList(values[0]);
        Program.LinkedList current = ll;
        for (int i = 1; i < values.length; i++) {
            current.next = new Program.LinkedList(values[i]);
            current = current.next;
        }
        return ll;
    }

    public ArrayList<Integer> toArrayList(Program.LinkedList ll) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Program.LinkedList current = ll;
        while (current != null) {
            arr.add(current.value);
            current = current.next;
        }
        return arr;
    }

    public boolean arraysEqual(ArrayList<Integer> arr1, int[] arr2) {
        if (arr1.size() != arr2.length) return false;
        for (int i = 0; i < arr1.size(); i++) {
            if (arr1.get(i) != arr2[i]) return false;
        }
        return true;
    }
}
