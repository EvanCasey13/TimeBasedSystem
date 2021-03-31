package sample;

import java.util.ArrayList;

import java.io.FileReader;

import java.io.FileWriter;

import java.io.ObjectInputStream;

import java.io.ObjectOutputStream;

import com.thoughtworks.xstream.XStream;

import com.thoughtworks.xstream.io.xml.DomDriver;

public class FacilityManager {

    //Array list of User object type called customers
    private ArrayList<User> customers = new ArrayList<>();

    //Array list of FacilityData object type called facilities
    private ArrayList<FacilityData> facilities = new ArrayList<>();

    //Array list of ReservationData object type reservations
    private ArrayList<ReservationData> reservations = new ArrayList<>();


    //Returns the amount of users in the arraylist
    public int numberOfUsers(int x) {
        int userAmount = 0;
        //For each User in customers arraylist add 1 to userAmount variable then return userAmount
        for (User user : customers) {
                userAmount = userAmount + 1;
            }
        return userAmount;
        }

        //Method to add a User object to customers Array list
    public boolean addUser(int user_id, String foreName, String surname, String role, int mobileNo, String email, String userType, String password) {
        /*Checks for double user making sure the new user_Id (index) is greater than or equal to the size of the customers arraylist preventing
          two users existing at the same index in the arraylist*/
        if (user_id >= customers.size()) {
            User user1 = new User(user_id, foreName, surname, role, mobileNo, email, userType, password);

            customers.add(user1);
            return true;
        } else {
            return false;
        }
    }

    //Method to add a FacilityData object to facilities Array list
    public boolean addFacility(int facilityId, String facilityName) {
        /*Checks for double facility making sure the new facilityId (index) is greater than or equal to the size of the facilities arraylist preventing
          two facilities existing at the same index in the arraylist*/
        if (facilityId >= facilities.size()) {
            FacilityData facility1 = new FacilityData(facilityId, facilityName);

            facilities.add(facility1);
            return true;
        } else {
            return false;
        }
    }

    //Method to add a ReservationData object to reservations ArrayList
    public boolean addReservation(int reservationId, int userId, int facilityId, String date, String duration, int mobileNumber, String reservationEmail) {
        /* Checks for double booking by making sure the new reservationId (index) is greater than or equal to the size of the reservations arraylist preventing
           double bookings eg two reservations existing at the same index in the arraylist*/
        if (reservationId >= reservations.size()) {
            ReservationData reservation1 = new ReservationData(reservationId, userId, facilityId, date, duration, mobileNumber, reservationEmail);
            reservations.add(reservation1);
            return true;
        } else {
            return false;
        }
    }

        //Method to delete a user at a index
        public boolean deleteUser ( int index){
            if (index >= 0 && customers.size() < index) {
                return false;
            } else {
                customers.remove(index);
                return true;
            }
        }


    //Method to delete a facility at a index if it exists
    public boolean deleteFacility(int index){
        if (index >= 0 && facilities.size() < index){
            return false;
        } else {
            facilities.remove(index);
            return true;
        }
    }

    //Method to delete a reservation at a index if it exists
    public boolean deleteReservation(int index){
        if (index >= 0 && reservations.size() < index){
            return false;
        } else{
            reservations.remove(index);
            return true;
        }
    }

    //Method to get a user by index if it exists
    public User getUser(int index){
        if (index >= 0 && index < customers.size()) {
            return customers.get(index);
        }
        return  null;
    }

    //Method to get a facility by index if it exists
    public FacilityData getFacility(int index){
        if (index >= 0 && index < facilities.size()){
            return facilities.get(index);
        }
        return null;
    }

    //Method to get reservation by index if it exists
    public ReservationData getReservation(int index) {
        if (index >= 0 && index < reservations.size()) {
            return reservations.get(index);
        }
        return null;
    }

    /*Method to update a user using user_Id(index of User objects in customers arraylist)
     * creates a new User object using a for-each loop and to set each object to the new values if the id entered exists as a user
     * in FXML Fields*/
    public boolean updateUser(int user_id, String foreName, String surname, String role, int mobileNo, String email, String userType, String password){
        User user = new User(user_id, foreName, surname, role, mobileNo, email, userType, password);
        int i=0;
        for (User userLoop : customers){
            if (userLoop.getUser_id() == user_id){
                customers.set(i,user);
                return true;
            }
            i++;//increment
        }
        return false; //id not found
    }

    /*Method to update a facility using facilityId(index of FacilityData objects in facilities arraylist)
     * creates a new FacilityData object using a for-each loop and increment to set each object to the new values if the id entered exists as a facility
     * in FXML Fields*/
    public boolean updateFacility(int facilityId, String facilityName){
        FacilityData facilityData = new FacilityData(facilityId, facilityName);
        int i=0;
        for (FacilityData facility : facilities){
            if (facility.getFacilityId() == facilityId){
                facilities.set(i,facilityData);
                return true;
            }
            i++;//increment
        }
        return false; //id not found
    }


        /*Method to update a reservation using reservationId(index of ReservationData objects in reservations arraylist)
        * creates a new ReservationData object using a for-each loop and to set each object to the new values if the id entered exists as a reservation
        * in FXML Fields*/
    public boolean updateReservation( int reservationId, int userId, int reservationFacilityId, String date, String duration, int mobileNumber, String reservationEmail){
        ReservationData reservationData = new ReservationData(reservationId,userId,reservationFacilityId,date, duration, mobileNumber, reservationEmail);
        int i=0;
        for (ReservationData reservation : reservations){
            if (reservation.getReservationId() == reservationId){
                reservations.set(i,reservationData);
                return true;
            }
            i++;//increment
        }
        return false; //id not found
    }

    //Method to save User objects to users.xml
    public void saveUsers() throws Exception {
        XStream xstream = new XStream(new DomDriver());

        ObjectOutputStream out = xstream.createObjectOutputStream

                (new FileWriter("users.xml"));

        out.writeObject(customers);

        out.close();
    }

    //Method to load User objects from users.xml
    public void loadUsers() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("users.xml"));
        customers = (ArrayList<User>) is.readObject();
        is.close();
    }

    //Method to save FacilityDate objects to facility.xml
    public void saveFacilities() throws Exception {
        XStream xstream = new XStream(new DomDriver());

        ObjectOutputStream out = xstream.createObjectOutputStream

                (new FileWriter("facility.xml"));

        out.writeObject(facilities);

        out.close();
    }

    //Method to load FacilityData objects from facility.xml
    public void loadFacilities() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("facility.xml"));
        facilities = (ArrayList<FacilityData>) is.readObject();
        is.close();
    }

    //Method to save ReservationDate objects to reservations.xml
    public void saveReservations() throws Exception {
        XStream xstream = new XStream(new DomDriver());

        ObjectOutputStream out = xstream.createObjectOutputStream

                (new FileWriter("reservations.xml"));

        out.writeObject(reservations);

        out.close();
    }

    //Method to load ReservationData objects from reservations.xml
    public void loadReservations() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("reservations.xml"));
        reservations = (ArrayList<ReservationData>) is.readObject();
        is.close();
    }


}
