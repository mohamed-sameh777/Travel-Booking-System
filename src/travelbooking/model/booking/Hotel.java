package travelbooking.model.booking;
import java.util.List;

public class Hotel {

    // Attributes
    private int roomID;
    private String name;
    private String location;
    private int availableRooms;
    private List<String> roomTypes;

    // Constructor
    public Hotel(int roomID, String name, String location, int availableRooms, List<String> roomTypes) {
        this.roomID = roomID;
        this.name = name;
        this.location = location;
        this.availableRooms = availableRooms;
        this.roomTypes = roomTypes;
    }

    // Methods (as defined in UML)

    public int seeAvailableRooms() {
        return availableRooms;
    }

    public List<String> seeRoomTypes() {
        return roomTypes;
    }

    public boolean makeReservation() {
        if (availableRooms > 0) {
            availableRooms--;
            return true;
        }
        return false;
    }

    public boolean payRoomFees() {
        // Payment logic handled elsewhere (Payment class)
        return true;
    }

    public void showHotels() {
        System.out.println("Hotel Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Available Rooms: " + availableRooms);
        System.out.println("Room Types: " + roomTypes);
    }

    // Getters and Setters (recommended for encapsulation)

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(int availableRooms) {
        this.availableRooms = availableRooms;
    }

    public List<String> getRoomTypes() {
        return roomTypes;
    }

    public void setRoomTypes(List<String> roomTypes) {
        this.roomTypes = roomTypes;
    }
}

