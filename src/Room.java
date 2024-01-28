public class Room {
    private static int counter=1;
public int price;
    public int beds;
private int number;
public Boolean isBooked;
public Boolean isReservable=true;
public Room(int Beds,int Price){
    number=counter;
    counter++;
    beds=Beds;
    price=Price;
}

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Boolean getBooked() {
        return isBooked;
    }

    public void setBooked(Boolean booked) {
        isBooked = booked;
    }

    public Boolean getReservable() {
        return isReservable;
    }

    public void setReservable(Boolean reservable) {
        isReservable = reservable;
    }
}
