package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.io.EOFException;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;         //Class used for the Date
import java.util.Objects;
import java.util.ResourceBundle;

public class TimeSystemController implements Initializable {

    /**
     * Declare Observable List used to Provide Selection options for the ChoiceBox.
     */
    ObservableList<String> bookingTimesList = FXCollections.observableArrayList("07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00");

    @FXML
    private DatePicker datePicker;
    @FXML
    private Label dateLabel;

    @FXML
    private ChoiceBox hourChoice; // =new ChoiceBox<String>(FXCollections.observableArrayList("07:00", "08:00", "09:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00"));

    //variable used to called methods from the FacilityManager class
    protected FacilityManager facility;

    //FXML Fields for a User
    @FXML
    private TextField txtUser_Id;

    @FXML
    private TextField txtForename;

    @FXML
    private TextField txtSurname;

    @FXML
    private TextField txtRole;

    @FXML
    private TextField txtMobileNo;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtUserType;

    @FXML
    private PasswordField txtPassword;

    //FXML Fields for a Facility

    @FXML
    private TextField txtFacilityId;

    @FXML
    private TextField txtFacilityName;

    //FXML Fields for a Reservation

    @FXML
    private TextField txtReservationId;

    @FXML
    private TextField txtUserId;

    @FXML
    private TextField txtReservationFacilityId;

    @FXML
    private TextField txtDate;

    @FXML
    private TextField txtDuration;

    @FXML
    private TextField txtMobileNumber;

    @FXML
    private TextField txtReservationEmail;

    //FXML Field for txtFeedback

    @FXML
    private TextArea txtFeedBack;

    //FXML Fields for Manager Login
    @FXML
    private TextField txtManagerName;

    @FXML
    private PasswordField txtManagerPassword;

    @FXML
    private Label txtManagerLoginFeedback;

    //Image
    @FXML private ImageView photo;


    //Manager Login
   @FXML
   private void handleManagerLogin(ActionEvent e){
       String managerName = "Evan";
       String managerPassword = "timeBasedSystem";

       String checkName, checkPassword;
       checkName = txtManagerName.getText();
       checkPassword = txtManagerPassword.getText();
       if (managerName.equals(checkName) && managerPassword.equals(checkPassword)){
        Main.set_pane(1);
        txtManagerLoginFeedback.setText("Successful Login");
        txtManagerLoginFeedback.setTextFill(Color.GREEN);
       } else {
           txtManagerLoginFeedback.setText("Incorrect details entered");
           txtManagerLoginFeedback.setTextFill(Color.RED);
       }

   }

    //Read a user at an index in customers ArrayList (For Managers to see only)
    public void handleReadUser(ActionEvent e) {
        try {
            txtFeedBack.setText("Getting Customer details");

            String uId = txtUser_Id.getText();

            int uId1 = Integer.parseInt(uId);

            User customerDetails = facility.getUser(uId1);

            if (customerDetails == null) {

                txtFeedBack.setText("Invalid Customer - Not Read");

            } else { //Setting the txtFields for the user
                txtUser_Id.setText(String.valueOf(customerDetails.getUser_id()));

                txtForename.setText(customerDetails.getForeName());

                txtSurname.setText(customerDetails.getSurname());

                txtRole.setText(customerDetails.getRole());

                txtMobileNo.setText(String.valueOf(customerDetails.getMobileNo()));

                txtEmail.setText(customerDetails.getEmail());

                txtUserType.setText(customerDetails.getUserType());
            }

        } catch (NumberFormatException ne) {
            System.out.println("NumberFormatException caught in handleReadUser - Please enter a numeric value for User Id");
        }
    }

    //Add a user in customers arraylist
    public void addUser(ActionEvent e) throws Exception {
        try {
            int userId = Integer.parseInt(txtUser_Id.getText());

            String forename = txtForename.getText();

            String surname = txtSurname.getText();

            String role = txtRole.getText();

            int mobileNo = Integer.parseInt(txtMobileNo.getText());

            String email = txtEmail.getText();

            String userType = txtUserType.getText();

            String password = txtPassword.getText();

            facility.addUser(userId, forename, surname, role, mobileNo, email, userType, password);

            txtFeedBack.setText("User Added");
        } catch (NumberFormatException ne) {
            System.out.println("NumberFormatException caught in add User - Please enter a numeric value for User Id & Mobile Number");
        }
    }

    //Save users to users.xml
    public void handleUserSave(ActionEvent e) throws Exception{
        facility.saveUsers();

        txtFeedBack.setText("User saved");
    }

    //Load users from users.xml
    public void handleUserLoad(ActionEvent e) throws Exception{
        facility.loadUsers();

        txtFeedBack.setText("Users loaded");
    }

    //Delete a user
    public void handleDeleteUser(ActionEvent e) throws Exception {
        try {
            int index = Integer.parseInt(txtUser_Id.getText());

            facility.deleteUser(index);

            txtFeedBack.setText("User Removed");
        } catch (IndexOutOfBoundsException ie) {
            System.out.println("IndexOutOfBoundsException caught in delete user - No users of that Id");
        }catch (NumberFormatException en){
            System.out.println("NumberFormatException caught in delete user - Please enter a numeric value in User Id");
        }
    }

    //Update a user
    public void handleUpdateUser(ActionEvent e) throws Exception {
        try {

            int userId = Integer.parseInt(txtUser_Id.getText());

            String forename = txtForename.getText();

            String surname = txtSurname.getText();

            String role = txtRole.getText();

            int mobileNo = Integer.parseInt(txtMobileNo.getText());

            String email = txtEmail.getText();

            String userType = txtUserType.getText();

            String password = txtPassword.getText();

            facility.updateUser(userId, forename, surname, role, mobileNo, email, userType, password);

            txtFeedBack.setText("User Updated");
        } catch (NumberFormatException en) {
        System.out.println("NumberFormatException caught in handleUpdateUser - Please enter a numeric value for User Id");
        }
        }


    /**Facility Area**/
    //Read a facility at an index in facilities ArrayList (For Managers to see only)
    public void handleReadFacility(ActionEvent e) {
        try {
            txtFeedBack.setText("Getting Facility details");

            String fId = txtFacilityId.getText();

            int fId1 = Integer.parseInt(fId);

            FacilityData facilityDetails = facility.getFacility(fId1);

            if (facilityDetails == null) {

                txtFeedBack.setText("Invalid Facility - Not Read");

            } else { //Setting the txtFields for the facility

                txtFacilityId.setText(String.valueOf(facilityDetails.getFacilityId()));

                txtFacilityName.setText(facilityDetails.getFacilityName());

            }
        } catch (NumberFormatException ne) {
            System.out.println("NumberFormatException caught in handleReadFacility - Please enter a numeric value for Facility Id");
        }
    }

    //Add a facility in facilities arraylist
    public void addFacility(ActionEvent e) throws Exception {
        try {
            int facilityId = Integer.parseInt(txtFacilityId.getText());

            String facilityName = txtFacilityName.getText();


            facility.addFacility(facilityId, facilityName);

            txtFeedBack.setText("Facility Added");
        } catch (NumberFormatException ne) {
            System.out.println("NumberFormatException caught in addFacility - Enter a Facility Id");
        }
    }

    //Save users to facility.xml
    public void handleFacilitySave(ActionEvent e) throws Exception{
        facility.saveFacilities();

        txtFeedBack.setText("Facility saved");
    }

    //Load users from facility.xml
    public void handleFacilityLoad(ActionEvent e) throws Exception{
        facility.loadFacilities();

        txtFeedBack.setText("Facility loaded");
    }

    //Delete a facility
    public void handleDeleteFacility(ActionEvent e) throws Exception {
        try {
            int index = Integer.parseInt(txtFacilityId.getText());

            facility.deleteFacility(index);

            txtFeedBack.setText("Facility Removed");
        } catch (NumberFormatException ne) {
            System.out.println("NumberFormatException caught in delete Facility - Please enter a numeric value for Facility Id");
        } catch (IndexOutOfBoundsException ei){
            System.out.println("IndexOutOfBoundsException caught in delete Facility - Please enter a valid numeric value for Facility Id");
        }
    }

    //Update a facility
    public void handleUpdateFacility(ActionEvent e) throws Exception {
        try {
            int facilityId = Integer.parseInt(txtFacilityId.getText());

            String facilityName = txtFacilityName.getText();

            facility.updateFacility(facilityId, facilityName);

            txtFeedBack.setText("Facility Updated");
        } catch (NumberFormatException en) {
          System.out.println("NumberFormatException caught in updateFacility - Please enter a valid numeric value for Facility Id");
        }
    }

    /** Reservation area **/
    //Read a reservation at an index in reservations ArrayList (For Managers to see only)
    public void handleReadReservation(ActionEvent e) {
        try {
            txtFeedBack.setText("Getting Reservation details");

            String rId = txtReservationId.getText();

            int rId1 = Integer.parseInt(rId);

            ReservationData reservationDetails = facility.getReservation(rId1);

            if (reservationDetails == null) {

                txtFeedBack.setText("Invalid Reservation - Not Read");

            } else { //Setting the txtFields for the Reservation

                txtReservationId.setText(String.valueOf(reservationDetails.getReservationId()));

                txtUserId.setText(String.valueOf(reservationDetails.getUserId()));

                txtReservationFacilityId.setText(String.valueOf(reservationDetails.getReservationFacilityId()));

                txtDate.setText(reservationDetails.getDate());

                txtDuration.setText(reservationDetails.getDuration());

                txtMobileNumber.setText(String.valueOf(reservationDetails.getMobileNumber()));

                txtReservationEmail.setText(reservationDetails.getReservationEmail());
            }
        } catch (NumberFormatException ne) {
         System.out.println("Number Format Exception caught in handleReadReservation - Please enter a numeric value for reservationId");
        }
    }

    //Add a reservation in reservations arraylist
    public void addReservation(ActionEvent e) throws Exception {
        try {
            int reservationId = Integer.parseInt(txtReservationId.getText());

            int userId = Integer.parseInt(txtUserId.getText());

            int reservationFacilityId = Integer.parseInt(txtReservationFacilityId.getText());

            String date = txtDate.getText();

            String duration = txtDuration.getText();

            int mobileNumber = Integer.parseInt(txtMobileNumber.getText());

            String reservationEmail = txtReservationEmail.getText();

            facility.addReservation(reservationId, userId, reservationFacilityId, date, duration, mobileNumber, reservationEmail);

            txtFeedBack.setText("Reservation Added");
        } catch (NumberFormatException en) {
            System.out.println("Number Format Exception caught in addReservation - Please enter numeric values for each ID & the mobile number");
        }
    }


    //Save users to reservations.xml
    public void handleReservationSave(ActionEvent e) throws Exception{
        facility.saveReservations();

        txtFeedBack.setText("Reservation saved");
    }

    //Load users from reservations.xml
    public void handleReservationLoad(ActionEvent e) throws Exception {
            facility.loadReservations();

            txtFeedBack.setText("Reservations loaded");

    }

    //Delete a reservation
    public void handleDeleteReservation(ActionEvent e) throws Exception {
        try {
            int index = Integer.parseInt(txtReservationId.getText());

            facility.deleteReservation(index);

            txtFeedBack.setText("Reservation Removed");
        } catch (IndexOutOfBoundsException ei) {
            System.out.println("IndexOutOfBounds Exception caught in handleDeleteReservation - No Reservations exist at that Id");
        } catch (NumberFormatException ni){
            System.out.println("NumberFormatException caught in handleDeleteReservation - Please enter a numeric value in reservationId to delete a reservation");
        }
    }

    //Update a reservation
    public void handleUpdateReservation(ActionEvent e) throws Exception {
        try {
            int reservationId = Integer.parseInt(txtReservationId.getText());

            int userId = Integer.parseInt(txtUserId.getText());

            int reservationFacilityId = Integer.parseInt(txtReservationFacilityId.getText());

            String date = txtDate.getText();

            String duration = txtDuration.getText();

            int mobileNumber = Integer.parseInt(txtMobileNumber.getText());

            String reservationEmail = txtReservationEmail.getText();

            if (facility.updateReservation(reservationId, userId, reservationFacilityId, date, duration, mobileNumber, reservationEmail)) {
                txtFeedBack.setText("Reservation Updated");
            } else {
                txtFeedBack.setText("Error: Product Id not found");
            }
        } catch (NumberFormatException en) {
            System.out.println("NumberFormatException caught in updateReservation - Please enter a valid numeric value for reservation Id");
        }
    }


    @FXML
    //Method used to select the date for a Reservation
    void selectDate(ActionEvent e){
        LocalDate date = datePicker.getValue();
        String time = hourChoice.getValue().toString();
        String dateDisplay = "" + date.getDayOfMonth() + "-" + date.getMonthValue() + "-" + date.getYear();
        //Takes the selection of the Strings dateDisplay & time and assigns them to the txtDate & txtDuration FXML Fields which will be assigned to the Strings date and duration variables of any reservationData object
        txtDate.setText(dateDisplay);
        txtDuration.setText(time);
        if(date != null && time != null){

            dateLabel.setTextFill(Color.BLACK);
            dateLabel.setText(dateDisplay + " "+ time);
        }
        else{
            dateLabel.setTextFill(Color.RED);
            dateLabel.setText("Date and Time not fully selected");
        }
    }

    //Handles changing to admin screen pane
    public void handleAdminBtn(ActionEvent e) throws Exception
    {
        Main.set_pane(1);
    }

    //Handles changing to the facility screen within the admin area
    public void handleAdminFacilityBtn(ActionEvent e) throws Exception
    {
            Main.set_pane(2);
        }

        //Handles going back to home area (user area)
        public void handleHomeBtn(ActionEvent e) throws Exception
        {
            Main.set_pane(0);
        }

        //List the amount of users on the system
        public void listNumberOfUsers() {
            try {
                int user_Id = Integer.parseInt(txtUser_Id.getText());
                String amount;
                amount = String.valueOf(facility.numberOfUsers(user_Id));

                txtFeedBack.setText("There is" + " " + amount + " " + "Users");
            } catch (NumberFormatException en) {
            System.out.println("NumberFormatException caught in listNumberOfUsers - Please enter a value in User Id");
            }
        }

        //List a user at a index in customers arraylist
        public void listOfUser() {
            try {
                int user_Id = Integer.parseInt(txtUser_Id.getText()); //Index in customers arraylist
                //Use user_Id(index) to get a user at a index and return its toString
                txtFeedBack.setText(facility.getUser(user_Id).toString());
            } catch (NumberFormatException en) {
            System.out.println("NumberFormatException caught in listOfUser - Please enter a value in User Id");
            }
        }

    @Override
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        facility = new FacilityManager();

        hourChoice.setItems(bookingTimesList); //use Observable list
        hourChoice.setValue("09:00");   // (optional -- set default/initial selection
        dateLabel.setText("Hello");
        
    }

}
