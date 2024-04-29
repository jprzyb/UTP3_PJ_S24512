/**
 *
 *  @author Przybylski Jakub S24512
 *
 */

package zad4;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Author implements Runnable {
    private final String[] msgs;
    private final BlockingQueue<String> queue;
    public Author(String[] xyz) {
        this.msgs = xyz;
        queue = new ArrayBlockingQueue<>(msgs.length);
    }
    @Override
    public void run() {
        for(String msg : msgs){
            queue.add(msg);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String getMsgFromQueue(){
        try {
            return queue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
