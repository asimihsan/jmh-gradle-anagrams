# jmh-gradle-anagrams
Use JMH to benchmark an algorithm

```
git clone https://github.com/asimihsan/jmh-gradle-anagrams.git
cd jmh-gradle-anagrams
./gradlew benchmarks
java -jar build/libs/jmh-gradle-sample-0.0.1-benchmarks.jar
```

Adjust the value of `m` in `perf/java/sample/SampleBenchmark` line 23 (in the
inner Words class) to investigate value of `m` with respect to `n`.
