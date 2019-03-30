package main;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.*;

import javax.imageio.ImageIO;

import commands.*;
import core.Command;
import core.CommandManager;
import core.Response;
import threads.WorkerThread;

public class Main
{
	/*
	// Variable arg definitions to make roles readable
	public static String[] List() 
	{ 
		return new String[] { }; 
	}
	public static String[] List(String ... strings) 
	{ 
		return strings; 
	}
	*/
	private static Integer num = 0;
	public static void main(String[] args) throws IOException
	{
		
		for(int i = 0; i < 10; ++i)
		{
			WorkerThread thread = new WorkerThread();
			thread.start();
		}
	}
}




/*
import threads.WorkerThread;

public class WorkerThread_Main
{
	public static void main(String[] args)
	{
		WorkerThread[] someThreads = 
		{
			  new WorkerThread("1", 100)
			, new WorkerThread("2", 500)
			, new WorkerThread("3", 200)
			, new WorkerThread("4", 700)
			, new WorkerThread("5", 250)
		};
		
		for(int i = 0; i < someThreads.length; ++i)
			someThreads[i].start();
		
		System.out.println("I'm the main thread!");
	}
}
*/
