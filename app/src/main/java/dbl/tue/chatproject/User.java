package dbl.tue.chatproject;

/**
 * dbl.tue.chatproject.User class
 */
public class User {

    int userID;
    String firstName;
    String lastName;
    String facebook_Usertoken;
    int facebook_UserID;
    String profilePictureURL;
    String bio;


    public int getUserID() {
        return userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFacebook_Usertoken() {
        return facebook_Usertoken;
    }

    public void setFacebook_Usertoken(String facebook_Usertoken) {
        this.facebook_Usertoken = facebook_Usertoken;
    }

    public int getFacebook_UserID() {
        return facebook_UserID;
    }

    public void setFacebook_UserID(int facebook_UserID) {
        this.facebook_UserID = facebook_UserID;
    }

    public String getProfilePictureURL() {
        return profilePictureURL;
    }

    public void setProfilePictureURL(String profilePictureURL) {
        this.profilePictureURL = profilePictureURL;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }





}
