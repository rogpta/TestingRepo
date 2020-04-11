package service;

import model.ParkingLot;

import java.util.*;

public class ParkingService {
    private List<Integer> slots = new ArrayList<>();
    Set<ParkingLot> parked = new TreeSet<>();

    public void park(String regNo) {
        if (this.slots.isEmpty()) {
            System.out.println("Sorry, parking lot is full");
            return;
        }
        Integer slotNo = Collections.min(this.slots);
        this.slots.remove(slotNo);
        ParkingLot lot = new ParkingLot(slotNo, regNo);
        parked.add(lot);
        System.out.println("Allocated slot number: " + slotNo);
    }

    public void createParkingSlot(int noOfSlots) {
        for (int i=1 ; i<=noOfSlots ; ++i) {
            this.slots.add(i);
        }
        System.out.println("Created parking lot with "+noOfSlots+" slots");
    }

    public void leaveCar(String regNo, int time) {
        int freedSlot=0;
        boolean removedCar = false;
        for (ParkingLot lot: parked) {
            if(regNo.equals(lot.getRegNo())) {
                freedSlot = lot.getSlotNo();
                removedCar = parked.remove(lot);
                break;
            }
        }
        if (removedCar) {
            slots.add(freedSlot);
            System.out.println("Registration number " + regNo +
                    " with Slot Number" + freedSlot + "is free with Charge "+calculateCharge(time));
            return;
        }
        System.out.println("Registration number "+regNo+" not found");
    }

    public int calculateCharge(int hr) {
        if (hr <= 2) {
            return 10;
        } else {
            int time = hr-2;
            return 10*time + 10;
        }
    }

    public void getStatus() {
        System.out.println("Slot No.    Registration No.");
        for (ParkingLot lot: parked) {
            System.out.println(lot);
        }
    }
}
