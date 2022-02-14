public class Client {
    static String name;
    static int age;
    static int turnover;
    static double debt;

    public static String getName() {
        return name;
    }

    public static int getAge() {
        return age;
    }

    public static int getTurnover() {
        return turnover;
    }

    public static void setTurnover(int turnover) {
        Client.turnover = turnover;
    }

    public static double getDebt() {
        return debt;
    }

    public static void setDebt(float debt) {
        Client.debt = debt;
    }

    public Client(String name, int age) {
        this.name = name;
        this.age = age;
        this.turnover = 0;
        this.debt = 5000.0;
    }
}
