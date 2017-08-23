package github.meifans.inTesting.base;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Set;

import lombok.extern.java.Log;

/**
 * Created by Meifans on 2017/8/22.
 */
@Log
public class NioScenario {

    private static final Charset UTF8 = Charset.forName("utf-8");

    public static void main(String[] args) {
        new NioScenario.ServerClient().start();

    }


    @Test
    public void test() throws IOException {
        new Client().request("127.0.0.1", 8080, "hello,master");
    }

    static class ServerClient {
        private static ServerSocketChannel serverChannel;

        static {
            try {
                serverChannel = ServerSocketChannel.open();
                serverChannel.socket().bind(new InetSocketAddress(8080));

                log.info("init Server Client");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        void start() {
            for (; ; ) {
                SocketChannel request = null;
                try {
                    request = serverChannel.accept();

                } catch (IOException e) {
                    e.printStackTrace();
                }

                log.info(doReceive(request));
            }
        }

        private String doReceive(SocketChannel channel) {
            ByteBuffer buffer =
                    ByteBuffer.allocate(1024);

            try {
                channel.read(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }

            buffer.flip();
            return UTF8.decode(buffer).toString();
        }
    }

    static class Client {

        private static SocketChannel channel;
        private static Selector selector;

        static {

            try {
                selector = Selector.open();
            } catch (IOException e) {
                log.warning("init selector error!");
            }

            try {
                channel = SocketChannel.open();
                channel.configureBlocking(false);
                channel.socket().setSoTimeout(5000);
                channel.register(selector,
                                 SelectionKey.OP_READ | SelectionKey.OP_WRITE | SelectionKey.OP_CONNECT);
            } catch (IOException e) {
                log.warning("init socketchannel error!");
            }
        }


        public void request(String host, int port, String message) throws IOException {
            channel.connect(new InetSocketAddress(host, port));

            while (selector.select() > 0) {
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                selectionKeys.forEach(s -> {
                    if (s.isWritable())
                        write(message, s);
                    if (s.isConnectable())
                        connect(s);
                });
            }
        }

        private void connect(SelectionKey key) {
            SocketChannel connector = (SocketChannel) key.channel();

            try {
                connector.finishConnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void write(String message, SelectionKey key) {
            SocketChannel writer = (SocketChannel) key.channel();

            try {
                writer.write(UTF8.encode(message));
            } catch (IOException e) {
                e.printStackTrace();
            }

            key.interestOps(SelectionKey.OP_READ);
        }

    }


}
