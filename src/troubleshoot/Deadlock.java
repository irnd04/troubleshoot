package troubleshoot;

public class Deadlock {

    static class Friend {
        private final String name;

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        // method syncronized는 method 전체를 syncronized(this) { }로 감싼 것과 같다.
        public synchronized void bow(Friend bower) {
            System.out.printf("%s: %s has bowed to me!\n", this.name, bower.getName());
            bower.bowBack(this);
        }

        public synchronized void bowBack(Friend bower) {
            System.out.printf("%s: %s has bowed back to me!\n", this.name, bower.getName());
        }

    }

    public static void main(String[] args) {
        final Friend alphonse = new Friend("Alphonse");
        final Friend gaston = new Friend("Gaston");

        new Thread(() -> alphonse.bow(gaston)).start();
        new Thread(() -> gaston.bow(alphonse)).start();

    }

}
