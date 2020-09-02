package art.aukhatov.string;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@Fork(value = 1, jvmArgsAppend = {"-Xms128m", "-Xmx128m"})
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 5, time = 1)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@State(Scope.Benchmark)
public class StringBenchmark {

    @Benchmark
    public String primitiveConcatenation(Dictionary dictionary, Blackhole bh) {
        String message = "Hello " + dictionary.word + dictionary.word;
        bh.consume(message);
        return message;
    }

    @Benchmark
    public String stringConcat(Dictionary dictionary, Blackhole bh) {
        String message = "Hello ".concat(dictionary.word).concat(dictionary.word);
        bh.consume(message);
        return message;
    }

    @Benchmark
    public String stringFormat(Dictionary dictionary, Blackhole bh) {
        String pattern = "Hello %s %s";
        String message = String.format(pattern, dictionary.word, dictionary.word);
        bh.consume(message);
        return message;
    }

    @Benchmark
    public String stringBuilder(Dictionary dictionary, Blackhole bh) {
        StringBuilder builder = new StringBuilder();
        String message = builder
                .append("Hello")
                .append(dictionary.word)
                .append(dictionary.word)
                .toString();
        bh.consume(message);
        return message;
    }

    @Benchmark
    public String stringJoin(Dictionary dictionary, Blackhole bh) {
        String message = String.join("Hello", dictionary.word, dictionary.word);
        bh.consume(message);
        return message;
    }

    @Benchmark
    public String apacheCommonsStringJoin(Dictionary dictionary, Blackhole bh) {
        String message = StringUtils.join("Hello", dictionary.word, dictionary.word);
        bh.consume(message);
        return message;
    }

    @State(Scope.Thread)
    public static class Dictionary {

        String word;

        @Param({"10", "20", "50"})
        int randomWordLength;

        @Setup
        public void setUp() {
            String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            word = RandomStringUtils.random(randomWordLength, characters);
        }
    }
}
