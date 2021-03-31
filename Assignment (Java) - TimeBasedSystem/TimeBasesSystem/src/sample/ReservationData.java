package sample;

public class ReservationData {

    //Variables

    private int reservationId;

    private int userId;

    private int reservationFacilityId;

    private String date;

    private String duration;

    private int mobileNumber;

    private String reservationEmail;

    //Constructor with 5 parameters

    public ReservationData(int reservationId, int userId, int reservationFacilityId, String date, String duration, int mobileNumber, String reservationEmail) {
        this.reservationId = reservationId;
        this.userId = userId;
        this.reservationFacilityId = reservationFacilityId;
        this.date = date;
        this.duration = duration;
        this.mobileNumber = mobileNumber;
        this.reservationEmail = reservationEmail;
    }

    //Getters

    public int getReservationId() {
        return reservationId;
    }

    public int getUserId() {
        return userId;
    }

    public int getReservationFacilityId() {
        return reservationFacilityId;
    }

    public String getDate() {
        return date;
    }

    public String getDuration() { return duration; }

    public int getMobileNumber(){return mobileNumber;}

    public String getReservationEmail(){return reservationEmail;}

    //Setters

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setReservationFacilityId(int reservationFacilityId) {
        this.reservationFacilityId = reservationFacilityId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setMobileNumber(int mobileNumber){this.mobileNumber = mobileNumber; }

    public void setReservationEmail(String reservationEmail){this.reservationEmail = reservationEmail;}

    //toString for a reservation

    @Override
    public String toString() {
        return "ReservationData{" +
                "reservationId=" + reservationId +
                ", userId=" + userId +
                ", reservationFacilityId=" + reservationFacilityId +
                ", date=" + date +
                ", duration=" + duration +
                ", mobileNumber=" + mobileNumber +
                ", reservationEmail=" + reservationEmail +
                '}';
    }
}
