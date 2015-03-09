package sample;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.List;

public class SampleBenchmark {
    @State(Scope.Thread)
    public static class Words {
        private final String letters = "abcdefghijklmnopqrstuvwxyz";
        private final List<String> words = new ArrayList<>();
        private final int m = 10;
        public Words() {
            for (int i = 0; i < 100000; i++) {
                final StringBuilder output = new StringBuilder();
                for (int j = 0; j < m; j++) {
                    char c = letters.charAt(ThreadLocalRandom.current().nextInt(letters.length()));
                    output.append(c);
                }
                words.add(output.toString());
            }
        }
        public List<String> getWords(int limit) {
            return words.subList(0, limit);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.SampleTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Measurement(iterations=10)
    @Warmup(iterations=10)
    @Fork(2)
    public boolean measure_100(Words w) {
        return HasAnagrams.hasAnagrams(w.getWords(100));
    }

    @Benchmark
    @BenchmarkMode(Mode.SampleTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Measurement(iterations=10)
    @Warmup(iterations=10)
    @Fork(2)
    public boolean measure_1000(Words w) {
        return HasAnagrams.hasAnagrams(w.getWords(1000));
    }

    @Benchmark
    @BenchmarkMode(Mode.SampleTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Measurement(iterations=10)
    @Warmup(iterations=10)
    @Fork(2)
    public boolean measure_10000(Words w) {
        return HasAnagrams.hasAnagrams(w.getWords(10000));
    }

    @Benchmark
    @BenchmarkMode(Mode.SampleTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Measurement(iterations=10)
    @Warmup(iterations=10)
    @Fork(2)
    public boolean measure_100000(Words w) {
        return HasAnagrams.hasAnagrams(w.getWords(100000));
    }
}