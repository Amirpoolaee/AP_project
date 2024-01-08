import javax.swing.*;
import java.util.ArrayList;

public class ScrollBar extends JFrame {
    private ArrayList<Room> rooms = new ArrayList<>();

    public ScrollBar(ArrayList<Room> rooms) {
        this.rooms = rooms;
        setTitle("salam");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        for (Room room : rooms
        ) {
            if (!room.getBooked()) {
                JLabel label = new JLabel("ROOM NUMBER " + room.getNumber() + " WITH " + room.beds + " BEDS:    " + room.price + "$");
                p.add(label);
            }
        }
        JScrollPane scrollBar = new JScrollPane(p);
        add(scrollBar);
        setVisible(true);
    }
}
