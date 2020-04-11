
import service.ParkingService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        ParkingService parkingService = new ParkingService();
//        int slots = Integer.parseInt(args[0]);
//        String s1 = parkingService.createParkingSlot(slots);
//        System.out.println(s1);
//        System.out.println(parkingService.park(args[1]));
//        System.out.println(parkingService.park(args[2]));
//        parkingService.getStatus();


        File file = new File("/Users/roshangupta/Desktop/parkLot.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null){
            String[] operation = st.split(" ");

            switch (operation[0]) {
                case "create_parking_lot":
                    int slots = Integer.parseInt(operation[1]);
                    parkingService.createParkingSlot(slots);
                    break;
                case "park":
                    parkingService.park(operation[1]);
                    break;
                case "leave":
                    int time = Integer.parseInt(operation[2]);
                    parkingService.leaveCar(operation[1], time);
                    break;
                case "status":
                    parkingService.getStatus();
                    break;
            }
        }
    }

}
