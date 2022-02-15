import java.util.ArrayList;
import java.util.Random;


public class Main extends Thread {
    static ArrayList<Client> arrayList;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        arrayList = new ArrayList<>();
        createClients();
        processingClients();
        long end = System.currentTimeMillis();
        System.out.println("Time is: " + (end - start));
    }



    private static void processingClients() {
        int threats = arrayList.size() / 300;
        for (int i = 0; i < threats + 1; i++) {
            MyThread tr = new MyThread();
            tr.setName(String.valueOf(i));
            tr.start();
        }
    }

    private static void createClients() {
        for (int i = 0; i < 1000; i++) {
            Random random = new Random();
            Client client = new Client("name" + i, random.nextInt(40) + 18);
            arrayList.add(client);
        }
        System.out.println();
    }

    static class MyThread extends Thread{
        @Override
        public void run() {
            int threatNumber = Integer.parseInt(getName());
            Client copy;
            Client client;
            if (arrayList.size() / 300 == threatNumber) {
                for (int i = threatNumber * 300; i < arrayList.size(); i++) {
                    copy = arrayList.get(i);
                    if (copy != null) {
                        client = new Client(copy.getName(), copy.getAge());
                        client.setTurnover(copy.getTurnover() + 100);
                        client.setDebt((float) (copy.getDebt() + 1000.0));
                        arrayList.set(i, client);
                    }
                }
            } else {
                for (int i = threatNumber * 300; i < (threatNumber + 1) * 300; i++) {
                    copy = arrayList.get(i);
                    if (copy != null) {
                        client = new Client(copy.getName(), copy.getAge());
                        client.setTurnover(copy.getTurnover() + 100);
                        client.setDebt((float) (copy.getDebt() + 1000.0));
                        arrayList.set(i, client);
                    }
                }
            }
        }
    }
}
