import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;


public class Main extends Thread {
    static ArrayList<Client> arrayList;
    static private AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        arrayList = new ArrayList<>();
        createClients();
        processingClients();
        Thread.sleep(500);
        System.out.println(arrayList.get(999).getDebt());
    }


    private static void processingClients() {
        int threats = arrayList.size() / 300;
        for (int i = 0; i < threats + 1; i++) {
            MyThread tr = new MyThread();
            tr.start();
        }
    }

    private static void createClients() {
        for (int i = 0; i < 1000; i++) {
            Random random = new Random();
            Client client = new Client("name" + i, random.nextInt(40) + 18);
            arrayList.add(client);
        }
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            Client copy;
            int i = count.getAndIncrement();
            while (i < arrayList.size()) {
                copy = arrayList.get(i);
                changeClient(copy, i);
                System.out.println("Client " + i + " changed");
                i = count.getAndIncrement();
            }
        }
    }

    private static void changeClient(Client copy, int i) {
        Client client = new Client(copy.getName(), copy.getAge());
        client.setTurnover(copy.getTurnover() + 100);
        client.setDebt((float) (copy.getDebt() + 1000.0));
        arrayList.set(i, client);
    }
}
