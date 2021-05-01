package troubleshoot;

import java.util.HashMap;

// -Xms128m -Xmx128m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=경로(파일명아님)
// /home/ubuntu/Documents/anal/heapdump
public class HoldMemoryOOM {

    private final static HashMap<String, String> leakMap = new HashMap<>();
    private final static String STORE_DATA = "STORE_DATA";
    private static final StringBuffer sb = new StringBuffer();

    public static void main(String[] args) {
        HoldMemoryOOM holdMemoryOOM = new HoldMemoryOOM();
        holdMemoryOOM.addObject(50000000);
        try {
            System.out.println("Holding memory. It will be stopped after 10 min.");
            Thread.sleep(60 * 1000 * 10); // 10 min
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addObject(int objectCount) {
        int mapSize = leakMap.size();
        int maxCount = mapSize + objectCount;
        for (int loop = mapSize; loop < maxCount; loop++) {
            leakMap.put(STORE_DATA + loop, STORE_DATA);
            sb.append(STORE_DATA);
        }
    }

}
