package com.boot.demo.core.aio;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @DATE 2019/11/21 11:39
 * @Description 处理器
 * @Author Tian Daguang
 **/
@Slf4j
public class ReadCompletionHanlder implements CompletionHandler<Integer, ByteBuffer> {

    private AsynchronousSocketChannel channel;

    public ReadCompletionHanlder(AsynchronousSocketChannel channel) {
        this.channel = channel;
    }

    @Override
    public void completed(Integer result, ByteBuffer attachment) {
        //反转  进入读模式
        attachment.flip();
        byte[] bt = new byte[attachment.remaining()];
        attachment.get(bt);

        try {
            String req = new String(bt, "UTF-8");
            log.info("ReadCompletionHanlder receive:{}", req);
            doWrite("server time".concat(String.valueOf(System.currentTimeMillis())));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void doWrite(String content) {

        if (StringUtils.isEmpty(content)) {
            return;
        }
        byte[] bt = content.getBytes();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(bt);
        buffer.flip();
        channel.write(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                //没有发送完继续发送
                if (attachment.hasRemaining()) {
                    channel.write(attachment, attachment, this);
                }
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        try {
            this.channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
