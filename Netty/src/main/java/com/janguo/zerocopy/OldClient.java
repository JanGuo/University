package com.janguo.zerocopy;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.Socket;
import java.nio.Buffer;

public class OldClient {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 8899);

        String fileName = "/Users/janguo/Downloads/Liunx/jdk-8u251-linux-x64.tar.gz";
        InputStream inputStream = new FileInputStream(fileName);
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        byte[] buffer = new byte[4096];
        long readCount = 0;
        long total = 0;
        long startTime = System.currentTimeMillis();

        while ((readCount = inputStream.read(buffer))>0){
            total += readCount;
            dataOutputStream.write(buffer);
        }

        System.out.println("发送字节总说：" +total+"，耗时"+(System.currentTimeMillis()-startTime));

        inputStream.close();
        dataOutputStream.close();
        socket.close();

    }
}
