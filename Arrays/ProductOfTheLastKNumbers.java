
# Product of the Last K Numbers

## Approach

1. Use an `ArrayList` to store the numbers added to the data structure.
2. In the `add()` method, insert each new number into the list.
3. In the `getProduct(k)` method:
   - Initialize `product` to `1`.
   - Traverse the last `k` elements using the index `list.size() - k`.
   - Multiply each element with the current product.
4. Return the calculated product.

## Java Code

```java
import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {
    List<Integer> list = new ArrayList<>();

    public ProductOfNumbers() {
    }

    public void add(int num) {
        list.add(num);
    }

    public int getProduct(int k) {
        int product = 1;

        for (int i = list.size() - k; i < list.size(); i++) {
            product = list.get(i) * product;
        }

        return product;
    }
}
```

## Complexity Analysis

Let `k` be the number of elements whose product is required.

- **Add Time Complexity:** O(1) amortized — Adding an element to the ArrayList takes O(1) amortized time.
- **GetProduct Time Complexity:** O(k) — We traverse the last `k` elements.
- **Space Complexity:** O(n) — The ArrayList stores all added numbers.

## Key Concepts

- ArrayList
- Array Traversal
- Product Calculation
- Data Structure Design
