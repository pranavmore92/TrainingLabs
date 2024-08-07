package more.pranav;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

public class GarbageCollector {

    public static void main(String[] args) {
        List<GarbageCollectorMXBean> list = ManagementFactory.getGarbageCollectorMXBeans();

        for (GarbageCollectorMXBean bean : list) {
            System.out.println("Name : " + bean.getName());
            System.out.println("No of Collections : " + bean.getCollectionCount());
            System.out.println("Collection Time : " + bean.getCollectionTime() + "ms");

            System.out.println("Pool Names");

            for (String name : bean.getMemoryPoolNames()) {
                System.out.println("\t" + name);
            }
            System.out.println();
        }
    }
}
