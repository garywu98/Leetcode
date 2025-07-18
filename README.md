# Leetcode

### Concepts
If input array is sorted then
* Binary search
* Two pointers

If asked for all permutations/subsets then
* Backtracking

If given a tree then
* DFS
* BFS

If given a graph then
* DFS
* BFS

If given a linked list then
* Two pointers

If recursion is banned then
* Stack

If must solve in-place then
* Swap corresponding values
* Store one or more different values in the same pointer

If asked for maximum/minimum subarray/subset/options then
* Dynamic programming
* Sliding window

If asked for top/least K items then
* Heap
* QuickSelect

If asked for common strings then
* Map
* Trie

Else
* Map/Set for O(1) time & O(n) space
* Sort input for O(nlogn) time and O(1) space

# Patterns for Problem Solving

## Pattern: Two Pointers
**Description:** This method uses two pointers to traverse an array or a list from different ends or directions.  
**Usage:** It's particularly useful for ordered data structures, where we can make intelligent decisions based on the position of the pointers.  
**Problems:** 'Pair with Target Sum', 'Remove Duplicates', 'Squaring a Sorted Array'.  

## Pattern: Island (Matrix Traversal)
**Description:** It involves traversing a matrix to find 'islands' or contiguous groups of elements.  
**Usage:** It's generally used in grid-based problems, especially when we need to group connected elements together.  
**Problems:** 'Number of Islands', 'Max Area of Island', 'Flood Fill'.  
```
public int dfs(int[][] grid, int r, int c, int area)
{
    if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 1)
    {
        grid[r][c] = 0;
        area++;
        area = dfs(grid, r - 1, c, area);
        area = dfs(grid, r + 1, c, area);
        area = dfs(grid, r, c + 1, area);
        area = dfs(grid, r, c - 1, area);
    }

    return area;
}

public int maxAreaOfIsland(int[][] grid) {
    int maxArea = 0;
    for(int i = 0; i < grid.length; i++)
    {
        for(int j = 0; j < grid[i].length; j++)
        {
            if(grid[i][j] == 1)
            {
                maxArea = Math.max(dfs(grid, i, j, 0), maxArea);
            }
        }
    }

    return maxArea;
}
```

## Pattern: Fast & Slow Pointers
**Description:** In this method, two pointers move at different speeds in a data structure.  
**Usage:** It is commonly used to detect cycles in a structure, find middle elements, or to solve other specific problems related to linked lists.  
**Problems:** 'LinkedList Cycle', 'Middle of the LinkedList', 'Palindrome LinkedList'.  

## Pattern: Sliding Window
**Description:** This pattern involves creating a 'window' into the data structure and then moving that window around to gather specific information.  
**Usage:** Mostly used in array or list-based problems where you need to find a contiguous subset that fulfills certain conditions.  
**Problems:** 'Maximum Sum Subarray of Size K', 'Smallest Subarray with a given sum', 'Longest Substring with K Distinct Characters'.  

## Pattern: Merge Intervals
**Description:** This pattern involves merging overlapping intervals.  
**Usage:** Often used in problems involving time intervals, ranges, or sequences.  
**Problems:** 'Merge Intervals', 'Insert Interval', 'Intervals Intersection'.  

**Basic Implementation**
```
public int[][] merge(int[][] intervals) {
        int count = intervals.length;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        int[] prev = intervals[0];
        

        for(int i = 0; i < intervals.length; i++)
        {
            int[] currentInterval = intervals[i];

            // If the current interval start(Y) >= previous interval(X) [0,X],[Y,5] = [0,5]
            // Keep merged until intervals don't overlap
            if(currentInterval[0] <= prev[1])
            {
                prev[1] = Math.max(prev[1], currentInterval[1]);
            }
            else
            {
                merged.add(prev);
                prev = currentInterval;
            }
        }

        merged.add(prev);

        return merged.toArray(new int[merged.size()][]);
    }
```

## Pattern: Cyclic Sort
**Description:** This pattern involves sorting an array containing numbers in a given range.  
**Usage:** It's useful in situations where the data involves a finite range of natural numbers.  
**Problems:** 'Cyclic Sort', 'Find the Missing Number', 'Find all Duplicates'.  

## Pattern: In-place Reversal of a Linked List
**Description:** This pattern involves reversing elements of a linked list in-place.  
**Usage:** It's generally used when reversing a sequence without using extra space.  
**Problems:** 'Reverse a LinkedList', 'Reverse a Sub-list', 'Reverse Every K-element Sub-list'.  

## Pattern: Tree Breadth First Search
**Description:** This pattern involves level-by-level traversal of a tree.  
**Usage:** It's used when we need to traverse a tree or graph in a level-by-level (breadth-first) manner.  
**Problems:** 'Level Order Traversal', 'Reverse Level Order Traversal', 'Zigzag Traversal'.  

**Basic Implementation**
```
public void DFS(Node node)
{
  Queue<Node> q = new Queue<>();
  q.offer(node);

  while(!q.empty())
  {
    // All nodes in same level
    for(int i = 0; i < q.size(); q++)
    {
      // Process node
      Node current = q.poll();

      //Add children nodes to queue
      q.offer(current.left);
      q.offer(current.right);
    }
  }
}
```

## Pattern: Tree Depth First Search
**Description:** This pattern involves traversing a tree or graph depth-wise before visiting siblings or neighbors.  
**Usage:** It's used when you need to search deeper into a tree/graph first before going across.  
**Problems:** 'Binary Tree Path Sum', 'All Paths for a Sum', 'Count Paths for a Sum'.  

**Basic Implementation:**

***Preorder***
Root -> left -> right
```
public void preorder(Node node)
{
  if(node == null ) return;

  //PROCESS NODE
  preorder(node.left);
  preorder(node.right);
}
```
***Inorder***
Left -> root -> right
```
public void inorder(Node node)
{
  if(node == null ) return;

  inorder(node.left);
  //PROCESS NODE
  inorder(node.right);
}
```
***Postorder***
Right -> left -> root
```
public void postorder(Node node)
{
  if(node == null ) return;

  postorder(node.left);
  postorder(node.right);
  //PROCESS NODE
}
```

## Pattern: Two Heaps
**Description:** This pattern involves using two heaps to divide a set of numbers into two parts.   
**Usage:** It's useful when you need to find median numbers in a sequence, or other similar problems.  
**Problems:** 'Find the Median of a Number Stream', 'Sliding Window Median', 'Maximize Capital'.  

## Pattern: Subsets
**Description:** This pattern involves generating all subsets of a set.  
**Usage:** It's helpful for solving problems that require exploring all subsets of a given set.  
**Problems:** 'Subsets', 'Subsets With Duplicates', 'Permutations'.  

**Basic Implementation:**
```
public void recursiveSubset(int i, int[i] nums, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> subset)
{
    
      if (i == nums.length) {
          res.add(new ArrayList<>(subset));
          return;
      }

      // Include the current element
      subset.add(nums[i]);
      subsetRecur(i + 1, nums, res, subset);

      // Exclude the current element
      subset.remove(subset.size() - 1);
      subsetRecur(i + 1, nums, res, subset);
}
```

## Pattern: Modified Binary Search
**Description:** This is a tweaked version of the binary search algorithm.  
**Usage:** It's used when a simple binary search isn't sufficient, like finding a number in a bitonic array.  
**Problems:** 'Order-agnostic Binary Search', 'Ceiling of a Number', 'Next Letter'.  

## Pattern: Top 'K' Elements
**Description:** This pattern is used to find the top 'k' elements among a certain category.  
**Usage:** It's commonly used in problems involving sorting, searching, and in heap data structures.  
**Problems:** 'Top K Frequent Numbers', 'Kth Largest Number in a Stream', 'Top K Frequent Elements'.  

## Pattern: Bitwise XOR
**Description:** This pattern involves the use of Bitwise XOR to solve various array-based problems.  
**Usage:** It's used when we need to manipulate and compare bits directly.  
**Problems:** 'Single Number', 'Two Single Numbers', 'Complement of Base 10 Number'.  

## Pattern: Backtracking
**Description:** This pattern involves exploring all possible solutions and then backtracking to correct the course whenever you're on the wrong path.  
**Usage:** It's typically used for solving complex combinatorial problems, puzzles, and games.  
**Problems:** 'Sudoku Solver', 'N-Queens', 'Generate Parentheses'.  

## Pattern: 0/1 Knapsack (Dynamic Programming)
**Description:** This pattern deals with problems where items have different values and weights, and we need to determine the maximum value we can carry.  
**Usage:** It's typically used in optimization problems, especially those involving physical constraints.  
**Problems:** '0/1 Knapsack', 'Equal Subset Sum Partition', 'Subset Sum'.  

## Pattern: Topological Sort (Graph)
**Description:** This pattern involves sorting nodes in a directed graph in a specific order where the preceding node comes before the following node.  
**Usage:** It's used for scheduling problems and in scenarios where order needs to be imposed on how you process nodes.  
**Problems:** 'Task Scheduling Order', 'All Tasks Scheduling Orders', 'Alien Dictionary'.  

## Pattern: K-way Merge
**Description:** This pattern involves merging 'k' sorted lists.  
**Usage:** It's typically used in problems involving lists, where merging is required.  
**Problems:** 'Merge K Sorted Lists', 'Kth Smallest Number in M Sorted Lists', 'Smallest Number Range'.  

## Pattern: Monotonic Stack
**Description:** This pattern involves using a stack to maintain a monotonic (either entirely non-increasing or non-decreasing) order of elements.  
**Usage:** It's often used for solving problems where you need to find the next greater or smaller elements.  
**Problems:** 'Next Greater Element', 'Next Smaller Element', 'Largest Rectangle in Histogram'.  

## Pattern: Multi-threaded
**Description:** This pattern involves designing algorithms that can execute multiple threads in parallel.  
**Usage:** It's used in situations where a task can be divided into independent sub-tasks that can execute concurrently.  
**Problems:** 'Invert Binary Tree', 'Binary Search Tree Iterator', 'Same Tree'.  

## Pattern: Union Find
**Description:** Union Find, also known as Disjoint Set Union (DSU), is a data structure that keeps track of a partition of a set into disjoint subsets.  
**Usage:** This pattern is particularly useful for problems where we need to find whether 2 elements belong to the same group or need to solve connectivity-related problems in a graph or tree.  
**Problems:** 'Graph Redundant Connection', 'Number of Provinces', 'Is Graph Bipart'.  

# Other
### Unbounded Knapsack
### Fibonacci Numbers
### Palindromic Subsequence
### Longest Common Substring
### Trie Traversal
### Trial & Error
### Unique Paths
### LRU/LFU Cache
