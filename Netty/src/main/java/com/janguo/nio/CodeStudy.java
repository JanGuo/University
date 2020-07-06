package com.janguo.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class CodeStudy {
    public static void main(String[] args) throws IOException {
        String inputFileName = "CodeStudy_in.txt";
        String outputFileName = "CodeStudy_out.txt";

        RandomAccessFile inputAccessFile = new RandomAccessFile(inputFileName, "r");
        RandomAccessFile outputAccessFile = new RandomAccessFile(outputFileName, "rw");
        long length = new File(inputFileName).length();

        FileChannel inputAccessFileChannel = inputAccessFile.getChannel();
        FileChannel outputAccessFileChannel = outputAccessFile.getChannel();

        MappedByteBuffer inputData = inputAccessFileChannel.map(FileChannel.MapMode.READ_ONLY, 0, length);

        Charset.availableCharsets().forEach((k,v)-> System.out.println(k+"---"+v));

        Charset charset = Charset.forName("ISO-8859-1");
        CharsetDecoder charsetDecoder = charset.newDecoder();
        CharBuffer decode = charsetDecoder.decode(inputData);
        System.out.println(decode);
        ByteBuffer byteBuffer = charset.encode(decode);

        outputAccessFileChannel.write(byteBuffer);

        inputAccessFile.close();
        outputAccessFile.close();
    }
}
