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
    private int alreadySent;
    public Author(String[] msgs) {
        alreadySent = 0;
        this.msgs = msgs;
        queue = new ArrayBlockingQueue<>(this.msgs.length);
    }
    @Override
    public void run() {
        for(String msg : msgs){
            queue.add(msg);
            alreadySent ++;
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
    public boolean isDone(){
        return alreadySent == msgs.length;
    }
}
