import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    /**
     *
     * @param args (unused)
     */
    public static void main(String[] args) {
        runPartA();
        runPartB();
    }
    /**
     * Validate that an array of Strings is sorted
     *
     * @param array array that might or might not be sorted
     * @return a 6 digit  checksum if sorted, -1 if not sorted.
     */
    public static int ckSumSorted(String[] array) {
        if (array.length == 0)
            return 1;
        int sum = 0;
        int i =0;
        String prev = array[0];
        for(String str: array) {
            if (str.compareTo(prev) < 0)
                return -1;
            i++;
            sum += str.hashCode() * i;
            prev = str;
        }
        return Math.abs(sum % 1000_000);
    }
    /**
     * Simple validation of data structures
     */
    public static void runPartA() {
        System.out.println("\n\nPart A --- \n");
        SortedLinkedList<String> linkedList = new SortedLinkedList<>();
        SortedArray<String> sortedArray = new SortedArray<>();
        String[] names = {"Bob", "Carol", "Aaron", "Alex", "Zaphod"};
        System.out.println("Initial Array = " + Arrays.toString(names));
        System.out.printf("Initial Array sorted = %,d\n", ckSumSorted(names));
        for (String name : names) {
            linkedList.add(name);
            sortedArray.add(name);
        }
        System.out.println("LinkedList: " + linkedList);
        String[] sl = {linkedList.get(0), linkedList.get(1), linkedList.get(2),
                linkedList.get(3), linkedList.get(4)};
        System.out.println(Arrays.toString(sl));
        System.out.printf("LinkedList ckSumSorted = %,d\n\n", ckSumSorted(sl));
        System.out.println("SortedArray: " + sortedArray);
        String[] sa = {sortedArray.get(0), sortedArray.get(1), sortedArray.get(2),
                sortedArray.get(3), sortedArray.get(4)};
        System.out.println(Arrays.toString(sa));
        System.out.printf("SortedArray ckSumSorted = %,d\n", ckSumSorted(sa));
        // Remove all names from linked list
        for (String name : names) {
            linkedList.remove(name);
        }
        linkedList.remove("Karen");
        System.out.println("LinkedList after removals: " + linkedList);



        // Additional data type test <Integer> for example
        System.out.println("\nTesting with Integer type:");

        SortedLinkedList<Integer> intLinkedList = new SortedLinkedList<>();
        Integer[] numbers = {5, 1, 3, 4, 2};

        System.out.println("Initial Integer Array = " + Arrays.toString(numbers));

        for (Integer num : numbers) {
            intLinkedList.add(num);
        }

        System.out.println("Integer LinkedList: " + intLinkedList);

        Integer[] il = {intLinkedList.get(0), intLinkedList.get(1), intLinkedList.get(2), intLinkedList.get(3), intLinkedList.get(4)};

        Integer[] removeNumbers = {1,3,4};

        for(Integer num : removeNumbers){
            intLinkedList.remove(num);
        }

        System.out.println("Integer LinkedList after removals: " + intLinkedList);
    }
    /**
     * Sorts the first n elements of the array using insertion sort.
     *
     * @param array The array to sort.
     * @param n The number of elements to sort from the start of the array.
     */
    public static void iSort(String[] array, int n) {
        if (n > array.length) {
            n = array.length; // Limit n to the size of the array
        }

        String unsortedValue;
        int scan;
        for (int index = 1; index < n; index++) {
            unsortedValue = array[index];
            scan = index;
            while (scan > 0 && array[scan - 1].compareTo(unsortedValue) > 0) {
                array[scan] = array[scan - 1];
                scan--;
            }
            array[scan] = unsortedValue;
        }
    }
    /**
     * Part B
     * Performance testing for ArrayList, LinkedList and SortedArray
     */
    public static void runPartB() {
        ArrayList<String> bnames = new ArrayList<>();
        long startTime;
        System.out.println("\n\nPart B --- \n");
        // read from file - do not change
        startTime = System.currentTimeMillis();
        try (Scanner scanner = new Scanner(new File("src/bnames.txt"))) {
            while (scanner.hasNextLine()) {
                bnames.add(scanner.nextLine().trim());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
            return;
        }
        long endTime = System.currentTimeMillis();
        String[] sa = new String[bnames.size()];
        for (int i = 0; i < bnames.size(); i++)
            sa[i] = bnames.get(i);
        System.out.printf("bnames.txt ckSumSorted = %,d\n", ckSumSorted(sa));
        System.out.printf("Read file bnames.txt: %,d items read in %,d ms\n\n", bnames.size(), (endTime - startTime));
        // ArrayList Add -
        ArrayList<String> sortedAL = new ArrayList<>();
        startTime = System.currentTimeMillis();
        for (String name : bnames) {
            sortedAL.add(name);
            // for this test we mimic the sorted Linked List insert
            // by sorting the array after each add operation.
            // Probably this isn't the best approach.
            sortedAL.sort((a, b) -> (a.compareTo(b)));
        }
        endTime = System.currentTimeMillis();
        System.out.printf("ArrayList added %,d items\n", sortedAL.size());
        for (int i = 0; i < sortedAL.size(); i++)
            sa[i] = sortedAL.get(i);
        System.out.printf("ArrayList ckSumSorted = %,d\n", ckSumSorted(sa));
        System.out.printf("Time to build sorted ArrayList, sort after each .add() %,d ms\n\n", endTime - startTime);
        /** Additional Tests go here **/

        // SortedArray Add - timing test
        SortedArray<String> sortedArray = new SortedArray<>();
        startTime = System.currentTimeMillis();

        for (String name : bnames) {
            sortedArray.add(name);
        }

        endTime = System.currentTimeMillis();

        System.out.printf("SortedArray added %,d items\n", sortedArray.size());

        for (int i = 0; i < sortedArray.size(); i++)
            sa[i] = sortedArray.get(i);

        System.out.printf("SortedArray ckSumSorted = %,d\n", ckSumSorted(sa));
        System.out.printf("Time to build SortedArray with sorted inserts %,d ms\n\n", endTime - startTime);

        // SortedLinkedList Add - timing test
        SortedLinkedList<String> sortedLinkedList = new SortedLinkedList<>();
        startTime = System.currentTimeMillis();

        for (String name : bnames) {
            sortedLinkedList.add(name);
        }

        endTime = System.currentTimeMillis();

        System.out.printf("SortedLinkedList added %,d items\n", sortedLinkedList.size());

        for (int i = 0; i < sortedLinkedList.size(); i++)
            sa[i] = sortedLinkedList.get(i);

        System.out.printf("SortedLinkedList ckSumSorted = %,d\n", ckSumSorted(sa));
        System.out.printf("Time to build SortedLinkedList with sorted inserts %,d ms\n\n", endTime - startTime);

        // Primitive Array using built in iSort
        String[] primitiveArray = new String[bnames.size()];
        int itemCount = 0;

        startTime = System.currentTimeMillis();

        for (String name : bnames) {
            primitiveArray[itemCount] = name;
            iSort(primitiveArray, itemCount + 1);
            itemCount++;
        }

        endTime = System.currentTimeMillis();

        System.out.printf("Primitive array added %,d items\n", primitiveArray.length);
        System.out.printf("Primitive array ckSumSorted = %,d\n", ckSumSorted(primitiveArray));
        System.out.printf("Time to add and sort primitive array using iSort: %,d ms\n\n", endTime - startTime);
    }
}