package site.wtfu.framework.nio.single;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;


/**
 * @author mac
 */
public class Handler2 implements Runnable{
    final SocketChannel socket;
    final SelectionKey sk;

    ByteBuffer input = ByteBuffer.allocate(1024);
    ByteBuffer output = ByteBuffer.allocate(1024);

    static final int READING = 0 ,SENDING = 1;
    int state = READING;

    Handler2(Selector sel, SocketChannel c) throws IOException {
        socket = c;
        c.configureBlocking(false);

        // Optionally try first read now
        sk = socket.register(sel, 0);
        sk.attach(this);
        sk.interestOps(SelectionKey.OP_READ);
        sel.wakeup();
    }

    boolean inputIsComplete() { /* ... */ return false;}
    boolean outputIsComplete() { /* ... */ return false;}
    void process(){ /* ... */ }

    @Override
    public void run() {  // initial state is reader
        try{
            socket.read(input);
            if (inputIsComplete()){
                process();
                sk.attach(new Sender());
                sk.interestOps(SelectionKey.OP_WRITE);
                sk.selector().wakeup();
            }
        }catch (IOException ex) { /* ... */}
    }

    class Sender implements Runnable {

        @Override
        public void run() {
            try{
                socket.write(output);
                if(outputIsComplete()) sk.cancel();
            }catch (IOException ex) { /* ... */}
        }
    }
}
