package van.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ThreadExample2 {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		printOut();
	}

	public static void printOut() throws ExecutionException, InterruptedException {
		System.out.println("van");
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			System.out.println("I am Van Ha Nguyen");
		});

		future.get();
	}
}
