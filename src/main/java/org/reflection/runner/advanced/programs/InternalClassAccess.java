package org.reflection.runner.advanced.programs;

import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;

import sun.misc.Unsafe;

public class InternalClassAccess {

    public static void main(String[] args) {
    Unsafe unsafe = null;
    long allocatedMemoryAddress =0;

        try {

            /*
            * 1. get the hold on the unsafe Class
            * 2. we access the private final field ~ theUnsafe using that we create the constructor because of the class design.
            * 3. get the hold on the object
            *
            * */
            Class<?> clazz = Class.forName("sun.misc.Unsafe");
            Field field = clazz.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
            System.out.println("Acquired Unsafe instance: " + unsafe);


            /*
            * 4. convert String into byte[] for getting length of the String.
            * 5. now we have the length of the String so we need to free memory of that size
            */

            String message = "Hello World";
            byte[] messageBytes = message.getBytes(StandardCharsets.UTF_8);
            long messageLength = messageBytes.length;


            /*
            * 6. we got the free memory.
            *  */
            allocatedMemoryAddress = unsafe.allocateMemory(messageLength);
            System.out.println("Message : "+message+"\tAllocated : "+ messageLength +"\tbytes at address: 0x" + Long.toHexString(allocatedMemoryAddress));


            /*
            * 7. save the data in the memory
            *  */
            unsafe.copyMemory(messageBytes, unsafe.arrayBaseOffset(byte[].class),
                    null, allocatedMemoryAddress, messageLength);
            System.out.println("Copied '" + message + "' bytes to off-heap memory.");

            // Step 5: Read the bytes back from off-heap memory
            byte[] readBytes = new byte[(int) messageLength];
            unsafe.copyMemory(null, allocatedMemoryAddress,
                    readBytes, unsafe.arrayBaseOffset(byte[].class), messageLength);
            String readMessage = new String(readBytes, StandardCharsets.UTF_8);
            System.out.println("Read from off-heap memory: '" + readMessage + "'");

            System.out.println("Original and read messages match: " + message.equals(readMessage));

        } catch (ClassNotFoundException | NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
