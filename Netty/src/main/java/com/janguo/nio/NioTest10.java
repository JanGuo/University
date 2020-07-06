package com.janguo.nio;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class NioTest10 {
    public static void main(String[] args) throws Exception{
        RandomAccessFile randomAccessFile = new RandomAccessFile("NioTest9.txt","rw");
        FileChannel accessFileChannel = randomAccessFile.getChannel();

        FileLock lock = accessFileChannel.lock(3,6,true);

        System.out.println("Valid: " + lock.isValid());
        System.out.println("Lock Type: " + lock.isShared());

        lock.close();
        randomAccessFile.close();
    }
}
