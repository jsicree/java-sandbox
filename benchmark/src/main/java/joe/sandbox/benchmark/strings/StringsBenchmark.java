package joe.sandbox.benchmark.strings;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.annotations.Warmup;



public class StringsBenchmark {
	
	
	@State(Scope.Benchmark)
	public static class MyState {
		
		public String sourceString = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
		
		public int[] indexArray;

    	@Param({"5","10","15"})
    	public int wordSize;

		
		@Setup(Level.Trial)
		public void setup() {
			System.out.println("In Setup");
			
			Random r = new Random();
			indexArray = r.ints(sourceString.length(),0,sourceString.length()).toArray();
	    	
		}

	    @TearDown(Level.Trial)
	    public void teardown() {
	    	System.out.println("In TearDown");    	
	    }
			
	};
		
    @Benchmark
    @Fork(value = 5)
    @Warmup(iterations = 2)
    @Measurement(iterations = 10)
    @BenchmarkMode(Mode.AverageTime) @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public int StringAppendBenchmark(MyState state) {
    	String s = "";
    	for (int i = 0; i < state.wordSize; i++) {
    		s = s + state.sourceString.charAt(state.indexArray[i]);				
		}
    	
    	return s.length();
    }

    @Benchmark
    @Fork(value = 5)
    @Warmup(iterations = 2)
    @Measurement(iterations = 10)
    @BenchmarkMode(Mode.AverageTime) @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public int StringBufferBenchmark(MyState state) {
    	StringBuffer sbuff = new StringBuffer("");
    	for (int i = 0; i < state.wordSize; i++) {
    		sbuff.append(state.sourceString.charAt(state.indexArray[i]));				
		}
    	
    	return sbuff.length();
    }

}
