package troubleshoot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MakeThreads {

    public static void main(String[] args) {
        for (int loop = 0; loop < 3; loop++) {
            LoopingThread thread = new LoopingThread();
            thread.start();
        }
        System.out.println("Started looping threads... You must stop this process after test...");
    }

}

class LoopingThread extends Thread {
    @Override
    public void run() {
        int runCount = 100;
        while (true) {
            try {
                String string = new String("AAA");
                List<String> list = new ArrayList<>(runCount);
                for (int loop = 0; loop < runCount; loop++) {
                    list.add(string);
                }
                Map<String, Integer> map = new HashMap<>(runCount);
                for (int loop = 0; loop < runCount; loop++) {
                    map.put(string + loop, loop);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}