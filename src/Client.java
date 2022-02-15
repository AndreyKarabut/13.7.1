public class Client {
    String name;
    int age;
    int turnover;
    double debt;

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public  int getTurnover() {
        return this.turnover;
    }

    public void setTurnover(int turnover) {
        this.turnover = turnover;
    }

    public double getDebt() {
        return this.debt;
    }

    public void setDebt(float debt) {
        this.debt = debt;
    }

    public Client(String name, int age) {
        this.name = name;
        this.age = age;
        this.turnover = 0;
        this.debt = 5000.0;
    }
}
