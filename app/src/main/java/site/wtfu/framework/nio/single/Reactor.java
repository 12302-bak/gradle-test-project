package site.wtfu.framework.nio.single;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author mac
 */
public class Reactor implements Runnable{

    final Selector selector;

    final ServerSocketChannel serverSocket;

    Reactor(int port) throws IOException {
        selector = Selector.open();
        serverSocket = ServerSocketChannel.open();
        serverSocket.socket().bind(new InetSocketAddress(port));
        serverSocket.configureBlocking(false);
        SelectionKey sk = serverSocket.register(selector, SelectionKey.OP_ACCEPT);
        sk.attach(new Acceptor());
    }

    /**
     * Alternatively, use explicit SPI provider:
     *      SelectorProvider p = SelectorProvider.provider();
     *      selector = p.openSelector();
     *      serverSocket = p.openServerSocketChannel();
     */

    @Override
    public void run() {  // normally in a new Thread
        try{
            while(!Thread.interrupted()){
                selector.select();
                Set<SelectionKey> selected = selector.selectedKeys();
                Iterator<SelectionKey> it = selected.iterator();
                while(it.hasNext()){
                    dispatch(it.next());
                }
                selected.clear();
            }
        }catch (IOException e){ /* ... */}
    }

    void dispatch(SelectionKey k){
        Runnable r = (Runnable) (k.attachment());
        if (r != null){
            r.run();
        }
    }


    class Acceptor implements Runnable {
        @Override
        public void run() {
            try{
                SocketChannel c = serverSocket.accept();
                if(c != null){
                    new Handler(selector, c);
                }
            }catch (IOException ex){ /* ... */ }
        }
    }
}
