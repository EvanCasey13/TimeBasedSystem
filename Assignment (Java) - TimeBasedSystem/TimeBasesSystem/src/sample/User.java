package sample;

public class User {

    //Variables
    private int user_id;

    private String foreName;

    private String surname;

    private String role;

    private int mobileNo;

    private String email;

    private String userType;

    private String password;

    //Default Constructor with 8 parameters
    public User(int user_id, String foreName, String surname, String role, int mobileNo, String email, String userType, String password) {
        this.user_id = user_id;
        this.foreName = foreName;
        this.surname = surname;
        this.role = role;
        this.mobileNo = mobileNo;
        this.email = email;
        this.userType = userType;
        this.password = password;
    }

    //Getters
    public int getUser_id() {
        return user_id;
    }

    public String getForeName() {
        return foreName;
    }

    public String getSurname() {
        return surname;
    }

    public String getRole() {
        return role;
    }

    public int getMobileNo() {
        return mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public String getUserType() {
        return userType;
    }

    public String getPassword() {
        return password;
    }

    //Setters
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setForeName(String foreName) {
        this.foreName = foreName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setMobileNo(int mobileNo) {
        this.mobileNo = mobileNo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //toString for a user object

    @Override
    public String toString() {
        return "User :" +
                "user_id=" + user_id +
                ", foreName='" + foreName + '\'' +
                ", surname='" + surname + '\'' +
                ", role='" + role + '\'' +
                ", mobileNo=" + mobileNo +
                ", email='" + email + '\'' +
                ", userType='" + userType + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
