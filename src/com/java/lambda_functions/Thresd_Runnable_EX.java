package com.java.lambda_functions;

public class Thresd_Runnable_EX {

	public static void main(String[] args) {
		
		Thread t = new Thread( ()-> System.out.println("Hello..."));
		t.start();
		
		//--
		Runnable task = () -> {
		    String threadName = Thread.currentThread().getName();
		    System.out.println("Hello " + threadName);
		};														
		task.run();
		
		Thread thread = new Thread(task);
		thread.start();			

		//--
		Runnable r1 = ()-> System.out.println("Hello-111 ...");
		
		processRunnable(r1);
		
		processRunnable(()-> System.out.println("Hello-222 ..."));
		
		
	}
	
	static void processRunnable(Runnable r) {
		r.run();
	}

}
