import java.util.ArrayList;
import java.util.Random;


public class Main extends Thread{
    static ArrayList<Client> arrayList;
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        arrayList = new ArrayList<>();
        createClients();
        processingClients();
        long end = System.currentTimeMillis();
        System.out.println("Time is: " + (end-start));
    }

    @Override
    public void run(){

    }

    private static void processingClients() {

    }

    private static void createClients() {
        for (int i = 0; i < 1000; i++) {
            Random random = new Random();
            Client client = new Client("name"+i,random.nextInt(40)+18);
            arrayList.add(client);
        }
        System.out.println();
    }
}
