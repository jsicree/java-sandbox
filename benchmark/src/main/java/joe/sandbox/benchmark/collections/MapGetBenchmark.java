package joe.sandbox.benchmark.collections;

import java.util.HashMap;
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



public class MapGetBenchmark {
	
	
	@State(Scope.Benchmark)
	public static class MyState {
		
		public int[] indexArray;
    	public HashMap<String, String> hashMap = new HashMap<String, String>();

    	@Param({"250","500","1000"})
    	public int listSize;

		
		@Setup(Level.Trial)
		public void setup() {
			System.out.println("In Setup");
	    	hashMap.clear();

	    	Random r = new Random();
			indexArray = r.ints(listSize,0,listSize).toArray();
				    	
	    	for (int i = 1; i <= listSize; i++) {
				hashMap.put(("Element " + i),("Element " + i));				
			}
	    	
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
    @BenchmarkMode(Mode.AverageTime) @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void hashMapGetBenchmark(MyState state) {

    	for (int i = 0; i < 100; i++) {
    		state.hashMap.get("Element " + state.indexArray[i]);				
		}
    	
    }
    
    
}
