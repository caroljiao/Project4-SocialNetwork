
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a user's profile in the social media network.
 */
public class Profile {
    private String name;
    private String status; // Status as a string (e.g., "Online", "Away")
    private String picture; // Optional profile picture (URL or description)
    private int age;
    private String gender; // Male/Female
    private String state; // e.g., WA, CA
    private List<Profile> friends;

    /**
     * Constructor for creating a Profile.
     *
     * @param name    The name of the profile.
     * @param status  The current status of the user.
     * @param picture (Optional) A picture for the profile.
     * @param age     The age of the user.
     * @param gender  The gender of the user.
     * @param state   The state where the user resides.
     */
    public Profile(String name, String status, String picture, int age, String gender, String state) {
        this.name = name;
        this.status = status;
        this.picture = picture;
        this.age = age;
        this.gender = gender;
        this.state = state;
        this.friends = new ArrayList<>();
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getPicture() { return picture; }
    public void setPicture(String picture) { this.picture = picture; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public List<Profile> getFriends() { return friends; }

    /**
     * Adds a friend to the profile's friend list.
     *
     * @param friend The friend profile to add.
     */
    public boolean addFriend(Profile friend) {
        if (!friends.contains(friend)) {
            friends.add(friend);
            return true;
        }
        return false;  // Friend already exists
    }

    /**
     * Removes a friend from the profile's friend list.
     *
     * @param friend The friend profile to remove.
     */
    public boolean removeFriend(Profile friend) {
        return friends.remove(friend);  // Returns true if removed, false if not found
    }

    /**
     * Prints all profile details, including friends.
     */
    public void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Status: " + status);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("State: " + state);
        System.out.println("Picture: " + (picture == null ? "No picture" : picture));
        System.out.print("Friends: ");
        if (friends.isEmpty()) {
            System.out.println("No friends.");
        } else {
            friends.forEach(friend -> System.out.print(friend.getName() + ", "));
            System.out.println();
        }
    }

    /**
     * Prints the list of friends of this profile.
     */
    public void printFriends() {
        if (friends.isEmpty()) {
            System.out.println("No friends.");
        } else {
            System.out.println("Friends of " + name + ":");
            friends.forEach(friend -> System.out.println(friend.getName()));
        }
    }

    /**
     * Lists the friends of the friends (i.e., friends' friends).
     */
    public void listFriendsOfFriends() {
        List<Profile> friendsOfFriends = new ArrayList<>();
        for (Profile friend : friends) {
            friendsOfFriends.addAll(friend.getFriends());
        }
        if (friendsOfFriends.isEmpty()) {
            System.out.println("No friends of friends found.");
        } else {
            System.out.println("Friends of " + name + "'s friends:");
            friendsOfFriends.forEach(friendOfFriend -> System.out.println(friendOfFriend.getName()));
        }
    }
}
