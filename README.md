# Java Benchmarks

## String Concatenation Benchmark

### Motivation
Just one point, I have to prove my decision by reference articles or spec papers.
Like according to Java Language Specification and so on, or accroding by Jh.Bloch and so on.
In some cases there don't have any information what I need. And I do my own experiment like this.

### Results of the Benchmark
```
Benchmark                               (randomWordLength)  Mode  Cnt    Score    Error  Units
StringBenchmark.apacheCommonsStringJoin                 10  avgt   10   69.927 ± 15.804  ns/op
StringBenchmark.apacheCommonsStringJoin                 20  avgt   10   60.087 ±  1.178  ns/op
StringBenchmark.apacheCommonsStringJoin                 50  avgt   10  161.179 ± 11.760  ns/op
StringBenchmark.primitiveConcatenation                  10  avgt   10   24.203 ±  0.211  ns/op
StringBenchmark.primitiveConcatenation                  20  avgt   10   25.040 ±  0.364  ns/op
StringBenchmark.primitiveConcatenation                  50  avgt   10   38.281 ±  0.895  ns/op
StringBenchmark.stringBuilder                           10  avgt   10   20.765 ±  0.271  ns/op
StringBenchmark.stringBuilder                           20  avgt   10   22.045 ±  0.611  ns/op
StringBenchmark.stringBuilder                           50  avgt   10   38.298 ±  1.023  ns/op
StringBenchmark.stringConcat                            10  avgt   10   64.063 ±  0.343  ns/op
StringBenchmark.stringConcat                            20  avgt   10   67.399 ±  0.763  ns/op
StringBenchmark.stringConcat                            50  avgt   10   76.619 ±  2.591  ns/op
StringBenchmark.stringFormat                            10  avgt   10  673.458 ± 26.151  ns/op
StringBenchmark.stringFormat                            20  avgt   10  711.718 ± 50.907  ns/op
StringBenchmark.stringFormat                            50  avgt   10  733.963 ± 29.483  ns/op
StringBenchmark.stringJoin                              10  avgt   10   92.567 ±  1.582  ns/op
StringBenchmark.stringJoin                              20  avgt   10  121.745 ±  5.397  ns/op
StringBenchmark.stringJoin                              50  avgt   10  182.598 ±  1.253  ns/op
```

### Environment

```
VM version: JDK 1.8.0_152, Java HotSpot(TM) 64-Bit Server VM, 25.152-b16
OS: Linux Ubuntu 19.10
CPU: Intel(R) Core(TM) i7-7700HQ CPU @ 2.80GHz 8 cores
RAM: 16Gb
```

### Conclusion

Dear Java Developers, please avoid using `String.format()` to concatenate a string.
