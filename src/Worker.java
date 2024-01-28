import java.util.concurrent.ThreadLocalRandom;

public class Worker {
    public String fName;
    public String lName;
    public String nc;
    public String email;
    public String password;
    private int money=   ThreadLocalRandom.current().nextInt(1000,20001);;
    public Worker(String FName, String LName, String Nc, String Email, String Password){
        fName=FName;
        lName=LName;
        nc=Nc;
        email=Email;
        password=Password;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
