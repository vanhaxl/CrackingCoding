package van.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ThreadExample {
    public static int count = 0;
    public static  void main(String[] args) throws ExecutionException, InterruptedException {
        List<CompletableFuture<Void>> list = new ArrayList<>();
        for(int i = 0; i< 200; i++) {
            list.add(printOut());
        }

        for(CompletableFuture<Void> x: list){
            if(!x.isDone()){
                x.get();
            }
        }


    }

    public static CompletableFuture<Void> printOut() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() ->{
            System.out.println("I am Van Ha Nguyen" + ++count);
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        });
        return future;
        //future.get();
    }
}
