package more.pranav;

import org.openjdk.jol.vm.VM;
//import sun.misc.Unsafe;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MemoryAddressAnalysis {
    private static BufferedWriter bw;
    /*private static Unsafe unsafe;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);

            bw = new BufferedWriter(new FileWriter(new File("memory.csv")));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    public static void main(String[] args) throws IOException {
        bw = new BufferedWriter(new FileWriter(new File("memory.csv")));
        Object test;
        for (int i = 0; i < 6400; i++) {
            test = new Test();
            //long address = getAddress(test);
            long address = VM.current().addressOf(test);
            System.out.println(address);
            bw.write(address + System.lineSeparator());
        }
        bw.flush();
        bw.close();

    }

    /*public static long getAddress(Object o) {
        Object[] array = new Object[]{o};

        long baseOffset = unsafe.arrayBaseOffset(Object[].class);
        int addressSize = unsafe.addressSize();

        long objectAddress = 0;

        switch (addressSize) {
            case 4:
                objectAddress = unsafe.getInt(array, baseOffset);
                break;
            case 8:
                objectAddress = unsafe.getLong(array, baseOffset);
                break;
        }

        return objectAddress;
    }*/

}
