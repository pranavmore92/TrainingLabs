package more.pranav;

import java.util.Random;

public class JStatAnalysis {

    public static void main(String[] args) {
        int arraySize=1000000;
        Test[] tests = new Test[arraySize];

        int count = 0;
        Random random = new Random();

        while (true) {
            tests[random.nextInt(arraySize)] = new Test();
            if (count % arraySize == 0) {
                System.out.print(".");
            }
            count++;
        }
    }
}

/*
Use below GC options to analyze this program
-XX:+UseSerialGC
-XX:+UseParallelGC
-XX:+UseG1GC

https://docs.oracle.com/javase/8/docs/technotes/tools/windows/jstat.html
 */