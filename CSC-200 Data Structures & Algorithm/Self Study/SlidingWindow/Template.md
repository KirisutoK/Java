# FIXED SLIDING WINDOW TEMPLATE

```java
public void FixedSlidingWindow (int[] arr) {
        int WindowSize = 3;
        int[] RandomNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        for (int i = 0; i < (RandomNumbers.length-WindowSize)+1; i++) { // + 1 because the required times the window must move is 5, not 4
            for (int j = i; j < i + WindowSize; j++) { // j + WindowSize so that Window will be able to move from 3 to j+(1) = 4. this mean i(1) < 4. i(2) < 5
                System.out.print(RandomNumbers[j] + " ");
            }
            System.out.println();
        }

        System.out.println("Numbers: " + Arrays.toString(RandomNumbers) + " \n");
    }
```

`i` is the right variable

`j` is the left variable

`k` is the Windowsize variable

The amount of iteration for `i` can be found by the equation `(length-WindowSize)+1`

The amount of iteration for `j` can be found by the equation `i+WindowSize`