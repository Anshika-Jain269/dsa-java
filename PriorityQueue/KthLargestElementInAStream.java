
# Kth Largest Element in a Stream

## Approach

1. Use a **Min Heap (PriorityQueue)** to maintain the `k` largest elements.
2. Initialize the value of `k` in the constructor.
3. Traverse the initial array:
   - Add each element to the priority queue.
   - If the size of the queue exceeds `k`, remove the smallest element using `poll()`.
4. For every new value added through the `add()` method:
   - Insert the value into the priority queue.
   - If the queue size exceeds `k`, remove the smallest element.
   - Return `pq.peek()`, which represents the kth largest element.
5. Since the heap stores at most `k` elements, its top element is always the kth largest element in the stream.

## Java Code

```java
import java.util.PriorityQueue;

class KthLargest {
    int k;
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;

        for (int num : nums) {
            pq.add(num);

            if (pq.size() > k) {
                pq.poll();
            }
        }
    }

    public int add(int val) {
        pq.add(val);

        if (pq.size() > k) {
            pq.poll();
        }

        return pq.peek();
    }
}
```

## Complexity Analysis

Let:
- `n` = number of elements in the initial array.
- `k` = required position.

- **Constructor Time Complexity:** O(n log k) — Each element is inserted into a heap containing at most `k` elements.
- **Add Time Complexity:** O(log k) — Insertion and removal operations take O(log k).
- **Space Complexity:** O(k) — The priority queue stores at most `k` elements.

## Key Concepts

- Min Heap
- Priority Queue
- Kth Largest Element
- Stream Processing
