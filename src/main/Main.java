package main;

import threads.WorkerThread;

public class Main
{
	public static void main(String[] args)
	{
		WorkerThread[] someThreads = 
		{
			  new WorkerThread("thread 1", 100)
			, new WorkerThread("thread 2", 500)
			, new WorkerThread("thread 3", 200)
			, new WorkerThread("thread 4", 700)
			, new WorkerThread("thread 5", 250)
		};
		
		for(int i = 0; i < someThreads.length; ++i)
			someThreads[i].start();
		
		System.out.println("I'm the main thread!");
	}
}
