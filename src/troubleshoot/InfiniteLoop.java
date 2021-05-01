package troubleshoot;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InfiniteLoop {

    public static void main(String[] args) {
        Random random = new Random();
        List<String> dummyList = new ArrayList<>();
        while (true) {
            for (int loop = 0; loop < 1000; loop++) {
                String temp = "ABCDEFG";
                dummyList.add(temp);
            }
            if (random.nextInt(100000000) == 1) break;
        }
    }

}
