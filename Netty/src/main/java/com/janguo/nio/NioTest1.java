package com.janguo.nio;

import java.nio.IntBuffer;
import java.security.SecureRandom;

public class NioTest1 {
    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(10);

        System.out.println("capacity: " + intBuffer.capacity());
        for (int i = 0; i < intBuffer.capacity()-5; i++) {
            int randomNumber = new SecureRandom().nextInt(20);
            intBuffer.put(randomNumber);
        }

        System.out.println("Before slip Limit: " + intBuffer.limit());
        System.out.println("Before slip Position: " + intBuffer.position());
        intBuffer.flip();
        System.out.println("After slip limit: " + intBuffer.limit());
        System.out.println("After slip Position: " + intBuffer.position());

        System.out.println("Enter While: " );
        while (intBuffer.hasRemaining()){
            System.out.println("Position: " +intBuffer.position() );
            System.out.println("Limit: " + intBuffer.limit());
            System.out.println("Capacity: " +intBuffer.capacity() );

            System.out.println(intBuffer.get());
        }
    }


}
