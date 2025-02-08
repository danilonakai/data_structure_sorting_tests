# Data Structure Sorting Test with Java

This project demonstrates the usage of different sorted data structures in Java, including `SortedArray`, `SortedLinkedList`, and the standard `ArrayList`. The goal of the project is to compare the performance and behavior of these data structures when it comes to sorting and insertion operations.

## Features
- **SortedArray**: A custom class that implements a sorted array using an `ArrayList`. It adds elements in sorted order and supports efficient element retrieval.
- **SortedLinkedList**: A custom implementation of a sorted linked list, where elements are inserted into their correct position to maintain order.
- **ArrayList**: A built-in Java `ArrayList` is used to test the performance of adding elements and sorting them after each insertion.
- **Insertion Sort**: A basic sorting algorithm used to sort a primitive array, demonstrating the manual sorting process.
- **Checksum Validation**: Each structure's integrity is verified by calculating a checksum (`ckSumSorted`) to ensure the list remains sorted after modifications.

## Parts of the Project

### Part A - Data Structure Operations
- Demonstrates the usage of the `SortedArray` and `SortedLinkedList` classes with both `String` and `Integer` types.
- Tests insertion and removal of elements from both data structures.
- Validates the correctness of the data structures using a checksum (`ckSumSorted`).
- Includes additional tests using `Integer` type to further explore the functionality of the data structures.

### Part B - Performance Testing
- **File Reading**: Reads a list of names from a file (`bnames.txt`) and inserts them into different data structures to measure performance.
- **Performance Benchmarking**: Compares the time it takes to build the sorted structures using:
  - `ArrayList` (sorting after each addition)
  - `SortedArray` (insertion at the correct index)
  - `SortedLinkedList` (insertion in sorted order)
  - A primitive array using the `iSort` algorithm.

## Example Output
![image](https://github.com/user-attachments/assets/b57e49c1-3634-4743-9132-0165853737af)

## Conclusion

### Performance Differences between SortedLinkedList and SortedArray

The core performance disparity between the `SortedLinkedList` and `SortedArray` lies in their structural differences and their corresponding time complexities for adding elements. The `SortedArray` uses an O(n^2) insertion approach when adding all elements, which results in relatively slower performance during the insertion phase. However, it performs better overall due to its more cache-efficient memory allocation strategy, where the array elements are stored sequentially in memory. This layout improves access speed and memory locality.

In contrast, the `SortedLinkedList` has a more complex structure, requiring additional memory for storing pointers to the next node. While it performs similarly to insertion sort by adding items in the correct order, this extra memory overhead and the more complex management of linked nodes results in a slower performance compared to `SortedArray`, especially when adding items. However, its performance is still acceptable in situations where insertion and deletion operations are frequent.

### Choosing between SortedLinkedList and SortedArray

The decision to use a `SortedLinkedList` over a `SortedArray` depends largely on the specific needs of the application. If the application requires frequent insertions and deletions of elements, the `SortedLinkedList` becomes the better choice due to its ability to easily modify elements without requiring the entire structure to be re-sorted. This makes it more suitable for dynamic or real-time applications.

However, if the application performs more frequent searches and requires efficient memory usage, the `SortedArray` is generally the more advantageous choice. Its compact structure and cache efficiency allow for faster search operations and lower memory consumption. The decision should also consider the data structure's ability to handle a particular type of operation more effectively, as well as the overall trade-offs between speed, memory usage, and complexity.

### Performance of ArrayList with Built-in Sorting

`ArrayList` uses Java's built-in sorting method, which is generally based on efficient sorting algorithms such as **Merge Sort** (or possibly Timsort, depending on the Java version). These algorithms have an average time complexity of O(n log n) and are highly optimized for large data sets. However, the testing results showed that sorting the `ArrayList` after each insertion was slower than using the `SortedLinkedList`, even though the built-in sorting method typically outperforms simpler algorithms like insertion sort in terms of time complexity.

The main reason for the slower performance with `ArrayList` is the repeated need to re-sort the entire array after each insertion. This means that every time an item is added, the entire collection is reordered, which is inefficient. On the other hand, the `SortedLinkedList` maintains its order as items are added, meaning no re-sorting is necessary.

### Time Complexity of iSort and Comparison with Built-in Sorting

The `iSort()` method, which is an implementation of insertion sort, has a time complexity of O(n^2), which is generally slower than built-in sorting methods like **Merge Sort** or **Timsort** (which have O(n log n) time complexity). However, in practice, `iSort()` was not orders of magnitude slower in the tests, which can be attributed to its incremental sorting approach. Unlike sorting the entire list after each insertion, `iSort()` sorts the elements as they are added, which can mitigate some of the inefficiency.

Despite the inherent limitations of insertion sort, the `SortedLinkedList` performs better than the `ArrayList`'s built-in sorting in this particular setup. This is because the `SortedLinkedList` avoids repeatedly sorting the entire collection and instead inserts each item into its correct position as it is added.

### Final Thoughts

Choosing between a `SortedLinkedList` and a `SortedArray` boils down to the specific requirements of the application in question. For scenarios where insertions and deletions are frequent and performance is heavily dependent on these operations, a `SortedLinkedList` may be more appropriate. However, for applications that require fast search operations or have constraints on memory usage, a `SortedArray` may be the better choice, thanks to its cache efficiency and better performance for lookups.

Additionally, it is important to consider the built-in sorting methods available in modern programming languages. In the case of Java's `ArrayList`, the built-in sorting algorithm (likely **Merge Sort** or **Timsort**) is highly optimized for large datasets, but may still be less efficient when it is repeatedly called after every insertion, as was the case in this test.

Ultimately, the selection of a data structure should be guided by the specific operations that will be most frequent in the target application and the trade-offs between time complexity, memory usage, and ease of implementation.

## Development Environment
- **Java Version**: 15 (Liberica JDK 15) or higher
- **IDE**: IntelliJ IDEA (Community Edition)

## How to Run
1. Clone the repository to your local machine.
2. Open the project in IntelliJ IDEA (Community Edition).
3. Ensure that you are using Java 15 (Liberica JDK 15) or higher.
4. Run the `Main.java` file to test the project in your machine.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

