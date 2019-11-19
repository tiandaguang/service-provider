package com.boot.demo.core.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @DATE 2019/11/19 14:15
 * @Description NIO学习
 * @Author Tian Daguang
 * <p>
 * 总结出使用Buffer一般遵循下面几个步骤：
 * <p>
 * 分配空间（ByteBuffer buf = ByteBuffer.allocate(1024); 还有一种allocateDirector后面再陈述）
 * <p>
 * 写入数据到Buffer(int bytesRead = fileChannel.read(buf);)
 * <p>
 * 调用filp()方法（ buf.flip();）
 * <p>
 * 从Buffer中读取数据（System.out.print((char)buf.get());）
 * <p>
 * 调用clear()方法或者compact()方法
 **/
public class TdgNio {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(102);
        RandomAccessFile aFile = null;
        RandomAccessFile bFile = null;
        try {
            aFile = new RandomAccessFile("D:/nio.txt", "rw");
            bFile = new RandomAccessFile("D:/aa.txt", "rw");

            FileChannel channel = aFile.getChannel();

            int read = channel.read(buffer);
            while (read != -1) {
                buffer.flip();
                if (buffer.hasRemaining()) {
                    bFile.write((char) buffer.get());
                }
                buffer.compact();
                read = channel.read(buffer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (!buffer.hasRemaining()) {
                    buffer = null;
                }
                if (aFile != null) {
                    aFile.close();
                }
                if (bFile != null) {
                    bFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
