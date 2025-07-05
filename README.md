# Algorithms 1 – Assignment 5

**Semester B • Second Year • B.Sc. in Computer Science**
**Instructor: Dr. Paul Avrahami**

---

## Overview

This assignment focuses on dynamic programming and graph algorithms.
You are required to implement:

1. **Longest Increasing Subsequence (LIS)** using both dynamic and recursive approaches
2. **Longest Path in a Directed Acyclic Graph (DAG)** using topological sorting

---

## Question 1 – Longest Increasing Subsequence (LIS)

Given an array `V` of length `n` containing natural numbers, find the length of the **longest strictly increasing subsequence** (not necessarily contiguous).

### A. Definition of Subproblem

Let `T[i]` be the length of the longest increasing subsequence that **ends** at index `i`.
We compute this for every index `i`, based on the maximum `T[j]` for `j < i` such that `V[j] < V[i]`.

### B. Recurrence Relation

```
T[0] = 1  
T[i] = 1 + max { T[j] | j < i && V[j] < V[i] }  
```

If no such `j` exists, then `T[i] = 1`.

### C. Dynamic Programming Algorithm (Bottom-Up)

```java
int[] dp = new int[n];
Arrays.fill(dp, 1);

for (int i = 0; i < n; i++) {
    for (int j = 0; j < i; j++) {
        if (V[j] < V[i]) {
            dp[i] = Math.max(dp[i], dp[j] + 1);
        }
    }
}
return Arrays.stream(dp).max().getAsInt();
```

### D. Recursive Algorithm (Top-Down with Memoization)

```java
int[] memo = new int[n];
Arrays.fill(memo, -1);

int lisRecursive(int i) {
    if (memo[i] != -1) return memo[i];
    int max = 1;
    for (int j = 0; j < i; j++) {
        if (V[j] < V[i]) {
            max = Math.max(max, lisRecursive(j) + 1);
        }
    }
    return memo[i] = max;
}
```

### Output Example:

```
The longest increasing sub sequence (recursive) --> 4
The longest increasing sub sequence (dynamic)  --> 4
```

### Time Complexity:

* Dynamic approach: `O(n^2)`
* Recursive with memoization: `O(n^2)` (each pair `i, j` computed once)
* Space: `O(n)`

---

## Question 2 – Longest Path in a DAG

Given a **directed acyclic graph (DAG)**, find the **longest path** (in terms of number of edges).
This must be done in `O(V + E)` time.

### A. Algorithm Overview

1. Perform **topological sort** on the DAG
2. Iterate over the sorted nodes and update distances using:

```
for (u : topSort)
    for (v : adj[u])
        if (delta[v] < delta[u] + 1)
            delta[v] = delta[u] + 1
            pi[v] = u
```

3. The maximum value in `delta[]` is the length of the longest path
4. The actual path is reconstructed via `pi[]`

### Java Example:

```java
Graph G = new Graph(6);
G.addEdge(0, 1);
G.addEdge(0, 2);
G.addEdge(1, 3);
G.addEdge(2, 3);
G.addEdge(3, 4);
G.addEdge(4, 5);
```

### Output Example:

```
Graph:
0 -> [1, 2]
1 -> [3]
2 -> [3]
3 -> [4]
4 -> [5]
5 -> []

Topo Sort: [0, 2, 1, 3, 4, 5]
The longest path: 4
Path: [0, 2, 3, 4, 5]
```

### Time Complexity:

* Topological Sort: `O(V + E)`
* Longest Path Distance Update: `O(V + E)`
* Path Reconstruction: `O(V)`
* **Total:** `O(V + E)`

---

## Author

| Name           | Contribution                                                                    |
| -------------- | ------------------------------------------------------------------------------- |
| Yakov Ben-Hamo | Full implementation, recursive + DP LIS, DAG longest path, testing and write-up |

---

## Notes

* The assignment demonstrates how structure (like topological order) allows for linear-time solutions to hard problems.
* Both questions reinforce understanding of subproblem decomposition and reuse in DP.
* The DAG problem uses topological properties to avoid recomputation and cycles, enabling optimal performance.
