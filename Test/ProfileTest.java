import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
//import models.Profile;
//import com.socialnetwork.models.Profile;
/**
 * Unit tests for the Profile class, which represents a user profile and its properties.
 */
class ProfileTest {

    private Profile profile;

    /**
     * Sets up a profile instance before each test case.
     * This method is annotated with @BeforeEach to ensure it's called before each test.
     */
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        profile = new Profile("Carol Jiao", "Online", null, 35, "Female", "WA");
    }

    /**
     * Tests the getName method of the Profile class.
     * Ensures that the name is returned correctly.
     */
    @org.junit.jupiter.api.Test
    void getName() {
        assertEquals("Carol Jiao", profile.getName());
    }

    /**
     * Tests the setName method of the Profile class.
     * Ensures that the name can be updated correctly.
     */
    @org.junit.jupiter.api.Test
    void setName() {
        profile.setName("Elizabeth Hoyt");
        assertEquals("Elizabeth Hoyt", profile.getName());
    }

    /**
     * Tests the getStatus method of the Profile class.
     * Ensures that the status is returned correctly.
     */
    @org.junit.jupiter.api.Test
    void getStatus() {
        assertEquals("Online", profile.getStatus());
    }

    /**
     * Tests the setStatus method of the Profile class.
     * Ensures that the status can be updated correctly.
     */
    @org.junit.jupiter.api.Test
    void setStatus() {
        profile.setStatus("Away");
        assertEquals("Away", profile.getStatus());
    }

    /**
     * Tests the getPicture method of the Profile class.
     * Ensures that the picture is null when not set.
     */
    @org.junit.jupiter.api.Test
    void getPicture() {
        assertNull(profile.getPicture()); // Assuming no picture set
    }

    /**
     * Tests the setPicture method of the Profile class.
     * Ensures that the profile picture can be set correctly.
     */
    @org.junit.jupiter.api.Test
    void setPicture() {
        // Assuming setPicture takes a String or Image object
        profile.setPicture("profile_pic.jpg");
        assertEquals("profile_pic.jpg", profile.getPicture());
    }

    /**
     * Tests the getAge method of the Profile class.
     * Ensures that the age is returned correctly.
     */
    @org.junit.jupiter.api.Test
    void getAge() {
        assertEquals(35, profile.getAge());
    }

    /**
     * Tests the setAge method of the Profile class.
     * Ensures that the age can be updated correctly.
     */
    @org.junit.jupiter.api.Test
    void setAge() {
        profile.setAge(30);
        assertEquals(30, profile.getAge());
    }

    /**
     * Tests the getGender method of the Profile class.
     * Ensures that the gender is returned correctly.
     */
    @org.junit.jupiter.api.Test
    void getGender() {
        assertEquals("Female", profile.getGender());
    }

    /**
     * Tests the setGender method of the Profile class.
     * Ensures that the gender can be updated correctly.
     */
    @org.junit.jupiter.api.Test
    void setGender() {
        profile.setGender("Male");
        assertEquals("Male", profile.getGender());
    }

    /**
     * Tests the getState method of the Profile class.
     * Ensures that the state is returned correctly.
     */
    @org.junit.jupiter.api.Test
    void getState() {
        assertEquals("WA", profile.getState());
    }

    /**
     * Tests the setState method of the Profile class.
     * Ensures that the state can be updated correctly.
     */
    @org.junit.jupiter.api.Test
    void setState() {
        profile.setState("CA");
        assertEquals("CA", profile.getState());
    }

    /**
     * Tests the getFriends method of the Profile class.
     * Ensures that the friends list is empty initially.
     */
    @org.junit.jupiter.api.Test
    void getFriends() {
        assertTrue(profile.getFriends().isEmpty()); // Assuming no friends added yet
    }

    /**
     * Tests the addFriend method of the Profile class.
     * Ensures that a friend can be added to the profile's friends list.
     */
    @org.junit.jupiter.api.Test
    void addFriend() {
        Profile friend = new Profile("Elizabeth Hoyt", "Away", null, 30, "Female", "NY");
        profile.addFriend(friend);
        assertTrue(profile.getFriends().contains(friend)); // Verify if friend was added
    }

    /**
     * Tests the removeFriend method of the Profile class.
     * Ensures that a friend can be removed from the profile's friends list.
     */
    @org.junit.jupiter.api.Test
    void removeFriend() {
        Profile friend = new Profile("Elizabeth Hoyt", "Away", null, 30, "Female", "NY");
        profile.addFriend(friend); // Add a friend first
        profile.removeFriend(friend);
        assertFalse(profile.getFriends().contains(friend)); // Verify if friend was removed
    }
}
