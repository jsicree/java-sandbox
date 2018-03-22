package joe.sandbox.benchmark.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
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



public class ListAddBenchmark {
	
	
	@State(Scope.Benchmark)
	public static class MyState {
		
		public int[] indexArray;
		public ArrayList<String> arrayList = new ArrayList<String>();
    	public LinkedList<String> linkedList = new LinkedList<String>();
    	public CopyOnWriteArrayList<String> cowArrayList = new CopyOnWriteArrayList<String>();
    	public Vector<String> vector = new Vector<String>();

//    	@Param({"250","500","1000"})
    	@Param({"250"})
    	public int listSize;

		
		@Setup(Level.Trial)
		public void setup() {
			System.out.println("In Setup");
			arrayList.clear();
	    	linkedList.clear();
	    	cowArrayList.clear();
	    	vector.clear();

	    	Random r = new Random();
			indexArray = r.ints(listSize,0,listSize).toArray();
	    	
		}

	    @TearDown(Level.Iteration)
	    public void teardown() {
	    	System.out.println("In TearDown");    	
			arrayList.clear();
	    	linkedList.clear();
	    	cowArrayList.clear();
	    	vector.clear();
	    }
			
	};
		
    @Benchmark
    @Fork(value = 3)
    @Warmup(iterations = 2)
    @Measurement(iterations = 10)
    @BenchmarkMode(Mode.AverageTime) @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void arrayListAddBenchmark(MyState state) {

    	for (int i = 1; i <= state.listSize; i++) {
			state.arrayList.add("Element " + i);				
		}
    	
    }

    @Benchmark
    @Fork(value = 3)
    @Warmup(iterations = 2)
    @Measurement(iterations = 10)
    @BenchmarkMode(Mode.AverageTime) @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void copyOnWriteArrayListAddBenchmark(MyState state) {

    	for (int i = 1; i <= state.listSize; i++) {
			state.cowArrayList.add("Element " + i);				
		}
    	
    }
    
    @Benchmark
    @Fork(value = 3)
    @Warmup(iterations = 2)
    @Measurement(iterations = 10)
    @BenchmarkMode(Mode.AverageTime) @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void linkedListAddBenchmark(MyState state) {
    	for (int i = 1; i <= state.listSize; i++) {
			state.linkedList.add("Element " + i);				
		}
    }

    @Benchmark
    @Fork(value = 3)
    @Warmup(iterations = 2)
    @Measurement(iterations = 10)
    @BenchmarkMode(Mode.AverageTime) @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void vectorIndexOfBenchmark(MyState state) {
    	for (int i = 1; i <= state.listSize; i++) {
			state.vector.add("Element " + i);				
		}
    }    
    
}
