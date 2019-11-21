package com.boot.demo.core.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @DATE 2019/11/21 11:59
 * @Description aio接收完毕回调
 * @Author Tian Daguang
 **/
public class AcceptCompletionHanlder implements CompletionHandler<AsynchronousSocketChannel, AsyncTimeServerHanlder> {

    @Override
    public void completed(AsynchronousSocketChannel result, AsyncTimeServerHanlder attachment) {
        attachment.serverSocketChannel.accept(attachment, this);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        result.read(buffer,buffer,new ReadCompletionHanlder(result));
    }

    @Override
    public void failed(Throwable exc, AsyncTimeServerHanlder attachment) {
        exc.printStackTrace();
        attachment.latch.countDown();
    }
}
