# benchmark
Sample benchmarks using the Java Microbenchmark Harness (JMH).

The class `joe.sandbox.benchmark.collections.ListBenchmark` tests `ArrayList.indexOf(item)`, `CopyOnWriteArrayList.indexOf(item)`, `LinkedList.indexOf(item)` and `Vector.indexOf(item)` using collections of various sizes. Sample results can be seen in the chart below for 100 random lookups in 250, 500 and 1000 element collections:

![](https://github.com/jsicree/java-sandbox/blob/master/benchmark/docs/ListBenchmark_Sample_Results.png)

The class `joe.sandbox.benchmark.strings.StringsBenchmark` tests the Java String + operator versus the StringBuffer.append() method in the creation of 5, 10 and 15 character Strings one character at a time. Sample results can be seen in the chart below:

![](https://github.com/jsicree/java-sandbox/blob/master/benchmark/docs/StringsBenchmark_Sample_Results.png)

## Running the Benchmarks
To run the benchmarks, build the benchmark project using maven:  
```
maven clean install
```
This will create a benchmarks.jar in the /target/ directory. To run a specific benchmark, specify the benchmark class name in the command line:  
```
$ java -jar target/benchmarks.jar joe.sandbox.benchmark.collections.ListBenchmark
```
Once the benchmark completes, a summary of the results will be produced:  
```
# Run complete. Total time: 00:12:24
  
Benchmark                                           (listSize)  Mode  Cnt  Score   Error  Units
ListBenchmark.arrayListIndexOfBenchmark                    250  avgt   50  0.044 ± 0.001  ms/op
ListBenchmark.arrayListIndexOfBenchmark                    500  avgt   50  0.106 ± 0.003  ms/op
ListBenchmark.arrayListIndexOfBenchmark                   1000  avgt   50  0.239 ± 0.015  ms/op
ListBenchmark.copyOnWriteArrayListIndexOfBenchmark         250  avgt   50  0.043 ± 0.003  ms/op
ListBenchmark.copyOnWriteArrayListIndexOfBenchmark         500  avgt   50  0.107 ± 0.005  ms/op
ListBenchmark.copyOnWriteArrayListIndexOfBenchmark        1000  avgt   50  0.285 ± 0.028  ms/op
ListBenchmark.linkedListIndexOfBenchmark                   250  avgt   50  0.058 ± 0.003  ms/op
ListBenchmark.linkedListIndexOfBenchmark                   500  avgt   50  0.131 ± 0.007  ms/op
ListBenchmark.linkedListIndexOfBenchmark                  1000  avgt   50  0.310 ± 0.020  ms/op
ListBenchmark.vectorIndexOfBenchmark                       250  avgt   50  0.040 ± 0.001  ms/op
ListBenchmark.vectorIndexOfBenchmark                       500  avgt   50  0.100 ± 0.005  ms/op
ListBenchmark.vectorIndexOfBenchmark                      1000  avgt   50  0.215 ± 0.010  ms/op
```
