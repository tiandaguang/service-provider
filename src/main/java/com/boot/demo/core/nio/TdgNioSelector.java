package com.boot.demo.core.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @DATE 2019/11/19 17:30
 * @Description nio 选择器
 * @Author Tian Daguang
 **/
public class TdgNioSelector {


    public static void main(String[] args) {
//        ByteBuffer buffer = ByteBuffer.allocate(1024);
//        RandomAccessFile aFile = null;
//        try {
//            aFile = new RandomAccessFile("D:/nio.txt", "rw");
//
//            Channel channel = aFile.getChannel();
//            Selector selector = Selector.open();
//            SelectionKey key = channel.register(selector, SelectionKey.OP_READ);
//            while (true) {
//                int readyChannels = selector.select();
//                if (readyChannels == 0) continue;
//                Set selectedKeys = selector.selectedKeys();
//                Iterator keyIterator = selectedKeys.iterator();
//                while (keyIterator.hasNext()) {
//                    SelectionKey key = keyIterator.next();
//                    if (key.isAcceptable()) {
//                        // a connection was accepted by a ServerSocketChannel.
//                    } else if (key.isConnectable()) {
//                        // a connection was established with a remote server.
//                    } else if (key.isReadable()) {
//                        // a channel is ready for reading
//                    } else if (key.isWritable()) {
//                        // a channel is ready for writing
//                    }
//                    keyIterator.remove();
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.socket().bind(new InetSocketAddress(9999));
            String newData = "New String to write to file..." + System.currentTimeMillis();

            ByteBuffer buf = ByteBuffer.allocate(48);
            buf.clear();
            buf.put(newData.getBytes());

            buf.flip();

            while (buf.hasRemaining()) {
                socketChannel.write(buf);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

//        }
    }

}
