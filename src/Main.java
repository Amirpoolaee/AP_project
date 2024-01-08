import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static Manager manager=new Manager();
    public static ArrayList<Room> rooms=new ArrayList<>();
    public static ArrayList<Passenger> passengers=new ArrayList<>();
    static Font f1  = new Font(Font.SERIF, Font.PLAIN,  20);
    static SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd/HH:mm:ss");
    static Date date=new Date();
    static File Pfile;
    static File bankFile;
    static File roomFile;
    static File roomReservesFile;
    static File roomRequestFile;
//    public static void addPassenger(){
//
//    }
    public static void makeRoomRequestFile(){
        roomRequestFile = new File("RoomRequest.txt");
        try {
            roomRequestFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void makeRoomReserveFile(){
       roomReservesFile = new File("RoomReserve.txt");
        try {
            roomReservesFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void editRoomRequestFile(){

    }
    public static void makeRoomFile(){
        roomFile = new File("Rooms.txt");
        try {
            roomFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   public static Passenger passenger=new Passenger("amir","poolaee","2051267790","apiagg@gmail.com","apiagg83");
   public static Room room=new Room(2,100);
    public static void makeBankFile() {
        bankFile = new File("hotelMoney.txt");
        try {
            bankFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void editBankFile(int money){
        try {
            BufferedReader bufferedReader=new BufferedReader(new FileReader(bankFile));
            int Money=(int)bufferedReader.read();
            int finalMoney = Money + money;
            FileWriter fileWriter=new FileWriter(bankFile,false);
            fileWriter.write(finalMoney);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void makePFile() {
        Pfile = new File("passengers.txt");

        try {
            Pfile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(Pfile));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Passenger passenger = new Passenger(data[0], data[1], data[2], data[3], data[4]);
                passengers.add(passenger);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void editPFile(){
        try (PrintWriter pw = new PrintWriter(new FileWriter(Pfile, false))) { // False to overwrite the file
            for (Passenger entry : passengers) {
                pw.println(entry.fName + "," + entry.lName+","+entry.nc+","+entry.email+","+entry.password);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Menu() {
        JFrame menu = new JFrame("MENU");
        JLabel l = new JLabel("please select one of these blow: ");
        l.setFont(f1);
        JButton pass = new JButton("PASSENGER");
        JButton manager = new JButton("MANAGER");
        JButton worker = new JButton("WORKER");
        pass.setFont(f1);
        manager.setFont(f1);
        worker.setFont(f1);
        l.setBounds(250,150,300,30);
        pass.setBounds(300,300,200,50);
        manager.setBounds(300,400,200,50);
        worker.setBounds(300,500,200,50);
        pass.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            passenger();
            menu.dispose();
            }
        });
        manager.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                managerLogIn();
                menu.dispose();
            }
        });
        worker.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Worker();
                menu.dispose();
            }
        });
        menu.add(l);
        menu.add(pass);
        menu.add(manager);
        menu.add(worker);
        menu.setSize(800,800);
        menu.setLayout(null);
        menu.setVisible(true);
    }
    public static void Worker(){

    }
    public static void passenger(){
        JFrame pass=new JFrame("PASSENGER");
        JLabel l = new JLabel("please select one of these blow: ");
        JButton su=new JButton("SIGN UP");
        JButton li=new JButton("LOG IN");
        l.setFont(f1);
        su.setFont(f1);
        li.setFont(f1);
        l.setBounds(250,100,400,20);
        su.setBounds(200,400,300,50);
        li.setBounds(200,600,300,50);
        su.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sign_up();
                pass.dispose();
            }
        });
        li.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                log_in();
                pass.dispose();
            }
        });
        pass.add(l);
        pass.add(li);
        pass.add(su);
        pass.setSize(800,800);
        pass.setLayout(null);
        pass.setVisible(true);
    }
    public static void log_in(){
        JFrame li=new JFrame("LOG IN");
        JLabel l=new JLabel("welcome back!  please write your Email and password for log in: ");
        JLabel le=new JLabel("EMAIL: ");
        JLabel lp=new JLabel("PASSWORD: ");
        JTextField email=new JTextField();
        JPasswordField password=new JPasswordField();
        l.setBounds(100,100,500,30);
        le.setBounds(100,300,200,30);
        lp.setBounds(100,500,200,30);
        email.setBounds(200,300,300,30);
        password.setBounds(200,500,300,30);
        JButton ok=new JButton("SUBMIT");
        ok.setBounds(250,600,200,40);
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                passengerOption();
                li.dispose();
            }
        });
        li.add(ok);
        li.add(l);
        li.add(le);
        li.add(lp);
        li.add(email);
        li.add(password);
        li.setSize(800,800);
        li.setLayout(null);
        li.setVisible(true);
    }
    public static void sign_up(){
    JFrame su=new JFrame("SIGN UP");
    JLabel l=new JLabel("please fill these blow: ");
    JLabel lfName=new JLabel("FIRST NAME: ");
    JLabel llName=new JLabel("LAST NAME: ");
    JLabel lcm=new JLabel("NATIONAL COD: ");
    JLabel lemail=new JLabel("EMAIL: ");
    JLabel lpassword=new JLabel("PASSWORD: ");
    JTextField fName,lName,cm,email;
    fName=new JTextField();
    lName=new JTextField();
    cm=new JTextField();
    email=new JTextField();
    JPasswordField password=new JPasswordField();
    JButton ok=new JButton("SUBMIT");
    l.setBounds(300,100,400,30);
    lfName.setBounds(200,200,200,30);
    fName.setBounds(400,200,200,30);
    llName.setBounds(200,300,200,30);
    lName.setBounds(400,300,200,30);
    lcm.setBounds(200,400,200,30);
    cm.setBounds(400,400,200,30);
    lemail.setBounds(200,500,200,30);
    email.setBounds(400,500,200,30);
    lpassword.setBounds(200,600,200,30);
    password.setBounds(400,600,200,30);
    ok.setBounds(300,700,200,50);
    String fullname= fName.getText()+lName.getText();
    ok.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (nameValid(fullname)){
                int a=JOptionPane.showConfirmDialog(su,"your full name is already taken! do you want to log in? ");
                if(a==JOptionPane.YES_OPTION){
                  log_in();
                    su.dispose();
                    return;
                }else{
                    sign_up();
                    su.dispose();
                    return;
                }
            }
            else if(!Name.nameValid(fName.getText())){
                int a=JOptionPane.showConfirmDialog(su,"your first name is wrong! do you want to try again? ");
                if(a==JOptionPane.YES_OPTION){
                    sign_up();
                    su.dispose();
                    return;
                }else{
                    Menu();
                    su.dispose();
                    return;
                }
            }
            else if (!Name.nameValid(lName.getText())){
            int a=JOptionPane.showConfirmDialog(su,"your last name is wrong! do you want to try again? ");
            if(a==JOptionPane.YES_OPTION){
                sign_up();
                su.dispose();
                return;
            }else{
                Menu();
                su.dispose();
                return;
            }
        }
            else if (!NC.NCisvalid(cm.getText())){
            int a=JOptionPane.showConfirmDialog(su,"your national code is wrong! do you want to try again? ");
            if(a==JOptionPane.YES_OPTION){
                sign_up();
                su.dispose();
                return;
            }else{
                Menu();
                su.dispose();
                return;
            }
        }
            else if (!Email.isValid(email.getText())){
            int a=JOptionPane.showConfirmDialog(su,"your Email is wrong! do you want to try again? ");
            if(a==JOptionPane.YES_OPTION){
                sign_up();
                su.dispose();
                return;
            }else{
                Menu();
                su.dispose();
                return;
            }
        }
            else  if (Password.level(password.getText())<2){
            int a=JOptionPane.showConfirmDialog(su,"your password is not string enough! do you want to try again? ");
            if(a==JOptionPane.YES_OPTION){
                sign_up();
                su.dispose();
                return;
            }else{
                Menu();
                su.dispose();
                return;
            }
        }
            editPFile();
            String fname= fName.getText();
            String lname= lName.getText();
            String nc= cm.getText();
            String Email= email.getText();
            String pass= password.getText();
            Passenger passenger=new Passenger(fname,lname,nc,Email,pass);
            passengers.add(passenger);
            editPFile();
            String Fullname=fname+" "+lname;
            roomReserving(Fullname,nc);
            su.dispose();
        }
    });
        su.add(ok);
        su.add(l);
        su.add(lfName);
        su.add(llName);
        su.add(lcm);
        su.add(lemail);
        su.add(lpassword);
        su.add(email);
        su.add(password);
        su.add(cm);
        su.add(fName);
        su.add(lName);
        su.setSize(800,800);
        su.setLayout(null);
        su.setVisible(true);
    }
    public static void passengerOption(){

    }
    public static void roomReserving(String fullName,String nc){
    JFrame f=new JFrame("ROOMS");
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        for (Room room : rooms
        ) {
            if (!room.getBooked()) {
                JLabel label = new JLabel("ROOM NUMBER " + room.getNumber() + " WITH " + room.beds + " BEDS:    " + room.price + "$");
                JButton b=new JButton("BOOK");
                b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame frame=new JFrame();
                        JLabel l=new JLabel("the request has been sent. thanks for your patch patience!");
                        l.setBounds(200,200,500,200);

                        JButton ok=new JButton("OK");
                        ok.setBounds(200,500,200,80);
                        ok.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                System.exit(0);
                            }
                        });
                        frame.add(l);
                        frame.add(ok);
                        frame.setSize(800,800);
                        frame.setLayout(null);
                        String time=dateFormat.format(date);
                        frame.setVisible(true);
                        sendRequest(fullName,nc,room.getNumber(),time);
                        f.dispose();
                    }
                });
                p.add(label);
                p.add(b);

            }
        }
        JScrollPane scrollBar = new JScrollPane(p);
        f.add(scrollBar);
        f.setSize(800,800);
        f.setVisible(true);
    }
    public static void sendRequest(String fullName,String Pnc ,int roomNumber,String time){
    try {
        FileWriter fileWriter=new FileWriter(roomRequestFile);
        fileWriter.write(fullName+","+Pnc+","+roomNumber+","+time+"\n");
        fileWriter.close();
    }catch (IOException e){
        e.printStackTrace();
    }
    }
    public static void sendMoneyForHotel(){

    }
    public static Boolean nameValid(String name){
        Boolean eminem=false;
        for (Passenger i: passengers
        ) {
            String fullname =i.fName+i.lName;
            if (fullname.equals(name)){
                eminem=true;
            }
        }
        return eminem;
    }
    public static void managerLogIn(){
        JFrame f=new JFrame("Manager Log In");
//        JLabel l=new JLabel("welcome back MR.Poolaee! please write your Email and password for log in: ");
//        JLabel le=new JLabel("EMAIL: ");
//        JLabel lp=new JLabel("PASSWORD: ");
//        JTextField email=new JTextField();
//        JPasswordField password=new JPasswordField();
//        l.setBounds(100,100,500,30);
//        le.setBounds(100,300,200,30);
//        lp.setBounds(100,500,200,30);
//        email.setBounds(200,300,300,30);
//        password.setBounds(200,500,300,30);
        JButton ok=new JButton("SUBMIT");
        ok.setBounds(250,600,200,40);
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                if (!email.getText().equals(manager.getEmail())) {
//                    int a = JOptionPane.showConfirmDialog(f, "your Email is wrong! do you want to log in again? ");
//                    if (a == JOptionPane.YES_OPTION) {
//                        managerLogIn();
//                        f.dispose();
//                    }
//                    else {
//                        Menu();
//                        f.dispose();
//                    }
//                }
//               else if (!manager.getPassword().equals(password.getText())){
//                    int a = JOptionPane.showConfirmDialog(f, "your password is wrong! do you want to log in again? ");
//                    if (a == JOptionPane.YES_OPTION) {
//                        managerLogIn();
//                        f.dispose();
//                    }
//                    else {
//                        Menu();
//                        f.dispose();
//                    }
//                }
//               else {
                managerOption();
                f.dispose();
//            }
        }
        });
       f.add(ok);
//       f.add(l);
//       f.add(le);
//       f.add(lp);
//       f.add(email);
//       f.add(password);
       f.setSize(800,800);
       f.setLayout(null);
       f.setVisible(true);
    }
    public static void managerOption(){
    JFrame f=new JFrame("MANAGER");
    JLabel l=new JLabel("Welcome Back Amir. What Do You Want To Do");
    JButton ps=new JButton("PAY SALARY");
    JButton nr=new JButton("NEW RESERVES");
    JButton or=new JButton("OLD RESERVES");
    JButton cr=new JButton("CREATE ROOM");
    JButton rr=new JButton("REMOVE ROOM");
    JButton er=new JButton("EDIT ROOM");
    l.setBounds(250,0,300,40);
    ps.setBounds(300,100,200,80);
    nr.setBounds(300,200,200,80);
    or.setBounds(300,300,200,80);
    cr.setBounds(300,400,200,80);
    rr.setBounds(300,500,200,80);
    er.setBounds(300,600,200,80);
    ps.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            paySalary();
            f.dispose();
        }
    });
    or.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            roomReserve();
            f.dispose();
        }
    });
    nr.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            roomRequestManager();
            f.dispose();
        }
    });
    cr.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            createRoom();
            f.dispose();
        }
    });
    rr.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
//          removeRoom();
            JFrame fr=new JFrame("ROOMS");
            JPanel p = new JPanel();
            p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
            for (Room i:rooms
                 ) {
                if (!i.getReservable()||i.getBooked()){
                    JLabel label=new JLabel("ROOM NUMBER "+room.getNumber()+" WITH "+room.beds+" BEDS:    "+room.price+"$");
                    JButton b=new JButton("REMOVE");
                    b.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            rooms.remove(i);
                            p.add(label);
                            p.add(b);
                        }
                    });
                }
            }
            JScrollPane scrollBar = new JScrollPane(p);
            fr.add(scrollBar);
            fr.setSize(800,800);
            fr.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            fr.setLayout(null);
            fr.setVisible(true);
            f.dispose();
        }});
    er.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            editRoom();
        }
    });
    f.add(l);
    f.add(er);
    f.add(cr);
    f.add(or);
    f.add(nr);
    f.add(ps);
    f.add(rr);
    f.setSize(800,800);
    f.setLayout(null);
    f.setVisible(true);
    }
    public static void paySalary(){

    }
    public static void roomReserve(){

    }
    public static void roomRequestManager(){

    }
    public static void createRoom(){
    JFrame f=new JFrame("CREATING ROOM");
    JLabel lb=new JLabel("Beds: ");
    JLabel lp=new JLabel("Price: ");
    JTextField beds=new JTextField();
    JTextField price=new JTextField();
    JButton ok=new JButton("SUBMIT");
    lb.setBounds(100,200,200,50);
    lp.setBounds(100,400,200,50);
    beds.setBounds(300,200,200,25);
    price.setBounds(300,400,200,25);
    ok.setBounds(300,600,200,50);
    ok.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!number.numberValid(beds.getText())){
                int a=JOptionPane.showConfirmDialog(f,"your bed number is word! do you want to create the room again? ");
                if(a==JOptionPane.YES_OPTION){
                   createRoom();
                    f.dispose();
                    return;
                }else{
                  managerOption();
                    f.dispose();
                    return;
                }
            }
//          else if ((int)beds.getText()>5){
//
//            }

            int Beds=3;
            int cost = 1000;
             JFrame frame=new JFrame("cost");
            JLabel label=new JLabel("it cost "+cost+ "$. are you sure about creating this room? ");
            JButton ok=new JButton("SURE");
            JButton no=new JButton("NO");
            label.setBounds(200,300,200,50);
            ok.setBounds(100,400,200,50);
            no.setBounds(400,400,200,50);
            ok.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Room r=new Room(Beds,200);
                    r.setBooked(false);
                    r.setReservable(true);
                    rooms.add(r);
                    editRoomFile();
                }
            });
            frame.add(label);
            frame.add(ok);
            frame.add(no);
            frame.setSize(800,800);
            frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            frame.setLayout(null);
            frame.setVisible(true);
            f.dispose();
        }
    });
    f.add(lb);
    f.add(lp);
    f.add(beds);
    f.add(ok);
    f.add(price);
    f.setSize(800,800);
    f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    f.setLayout(null);
    f.setVisible(true);
    }
    public static void editRoom(){

    }
    public static void editRoomFile(){
        try (PrintWriter pw = new PrintWriter(new FileWriter(roomFile, false))) { // False to overwrite the file
            for (Room entry : rooms) {
                pw.println(entry.getNumber()+ "," + entry.price+","+entry.beds+","+entry.getBooked()+","+entry.getReservable());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        room.setBooked(false);
        rooms.add(room);
        passengers.add(passenger);
        makeRoomReserveFile();
        makePFile();
        makeBankFile();
        makeRoomFile();
        makeRoomRequestFile();
//        sign_up();
        Menu();
        editPFile();
        editRoomFile();

    }
}