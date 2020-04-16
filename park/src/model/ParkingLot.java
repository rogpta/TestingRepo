package model;

public class ParkingLot implements Comparable<ParkingLot> {
    private Integer slotNo;
    private String regNo;

    public ParkingLot() {
    }

    public ParkingLot(Integer slotNo, String regNo) {
        this.slotNo = slotNo;
        this.regNo = regNo;
    }

    public Integer getSlotNo() {
        return slotNo;
    }

    public void setSlotNo(Integer slotNo) {
        this.slotNo = slotNo;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    @Override
    public int compareTo(ParkingLot o) {
        return slotNo - o.getSlotNo();
    }

    @Override
    public String toString() {
        return slotNo +"    "+regNo;
    }
}
