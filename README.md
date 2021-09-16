Benchmark for Sorting and Binary Searching algorithms
=================================

# Binary Searching 

O(1) < compare > O(log n)

|Benchmark|Mode|Cnt|Score|Error|Units|     
|---------|----|---|-----|-----|-----| 
|BenchmarkSearchingAlgorithms.testIterativeBenchMark|avgt|9|0.655 |±0.230|s/op|
|BenchmarkSearchingAlgorithms.testRecursiveBenchMark|avgt|9|0.692 |±0.248|s/op|

According to result, there is no big difference in executing for 100_000 size store 

# Sorting

O (N^2) < compare > O(N log(N))

|Benchmark|Mode|Cnt|Score|Error|Units|     
|---------|----|---|-----|-----|-----| 
|BenchmarkSortingAlgorithms.testInsertionSort|avgt|9|17.352|±3.276|s/op|
|BenchmarkSortingAlgorithms.testMergeSort|avgt|9|0.044|±0.003|s/op|

According to the result Merge Sort algorithm is much more effective.



