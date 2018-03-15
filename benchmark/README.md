### benchmark
Sample benchmarks using the Java Microbenchmark Harness (JMH).

The class `joe.sandbox.benchmark.CollectionsBenchmark` tests `HashMap.get(key)`, `ArrayList.indexOf(item)` and `LinkedList.indexOf(item)` using collections of various sizes. Sample results can be seen in the chart below for performing 100 lookups in 250, 500, 750 and 1000 element collections:

![](https://github.com/jsicree/java-sandbox/blob/master/benchmark/docs/CollectionsBenchmark_Sample_Results.png)
