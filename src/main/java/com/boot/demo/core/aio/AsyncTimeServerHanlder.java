package com.boot.demo.core.aio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * @DATE 2019/11/21 11:30
 * @Description 时间服务器同步
 * @Author Tian Daguang
 **/
@Slf4j
public class AsyncTimeServerHanlder implements Runnable {

    private int port;

    CountDownLatch latch;

    AsynchronousServerSocketChannel serverSocketChannel;

    public AsyncTimeServerHanlder(int port) {
        this.port = port;
        try {
            serverSocketChannel = AsynchronousServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(port));
            log.info("the time server is bind port:{}",port);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        latch = new CountDownLatch(1);
    }

    public void doAccept() {
        serverSocketChannel.accept(this,new AcceptCompletionHanlder());
    }
}
