/**
 *
 *  @author Przybylski Jakub S24512
 *
 */

package zad4;


public class Writer implements Runnable {
    Author author;
    public Writer(Author autor) {
        this.author = autor;
    }

    @Override
    public void run() {
        while(true){
            String msg = author.getMsgFromQueue();
            System.out.println("Msg: " + msg);
        }
    }
}
