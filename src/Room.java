public class Room {
    private static int counter=1;
public int price;
    public int beds;
private int number;
private Boolean isBooked;
private Boolean isReservable=true;
public Room(int Beds,int Price){
    number=counter;
    counter++;
    beds=Beds;
    price=Price;
}

    public int getNumber() {
        return number;
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
