package sample;

public class FacilityData {

    //Variables

    private int facilityId;

    private String facilityName;

    //Constructor with 2 parameters

    public FacilityData(int facilityId, String facilityName) {
        this.facilityId = facilityId;
        this.facilityName = facilityName;
    }

    //Getters

    public int getFacilityId() {
        return facilityId;
    }

    public String getFacilityName() {
        return facilityName;
    }

    //Setters

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    //toString for a facility

    @Override
    public String toString() {
        return "FacilityData{" +
                "facilityId=" + facilityId +
                ", facilityName='" + facilityName + '\'' +
                '}';
    }
}
