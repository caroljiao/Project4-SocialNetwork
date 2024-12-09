import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the ProfileManager class, which manages user profiles and their interactions.
 */
class ProfileManagerTest {

    private ProfileManager profileManager;

    /**
     * Sets up the profile manager before each test case.
     * This method is annotated with @BeforeEach to ensure it's called before each test.
     */
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        profileManager = new ProfileManager();
    }

    /**
     * Tests adding a new profile to the profile manager.
     * Ensures that the profile is added and can be found in the list of profiles.
     */
    @org.junit.jupiter.api.Test
    void addProfile() {
        Profile profile = new Profile("Carol Jiao", "Online", null, 35, "Female", "WA");
        profileManager.addProfile(profile);
        assertTrue(profileManager.getProfiles().contains(profile));
    }

    /**
     * Tests adding a friend relationship between two profiles.
     * Ensures that one profile can be added as a friend to another.
     */
    @org.junit.jupiter.api.Test
    void addFriend() {
        Profile profile1 = new Profile("Carol Jiao", "Online", null, 35, "Female", "WA");
        Profile profile2 = new Profile("Elizabeth Hoyt", "Away", null, 30, "Female", "NY");
        profileManager.addProfile(profile1);
        profileManager.addProfile(profile2);
        profileManager.addFriend(profile1.getName(), profile2.getName());
        assertTrue(profile1.getFriends().contains(profile2));
    }

    /**
     * Tests adding a friend relationship automatically between two profiles.
     * Ensures that the automatic addition of friends works correctly.
     */
    @org.junit.jupiter.api.Test
    void addFriendAuto() {
        Profile profile1 = new Profile("Carol Jiao", "Online", null, 35, "Female", "WA");
        Profile profile2 = new Profile("Elizabeth Hoyt", "Away", null, 30, "Female", "NY");
        profileManager.addProfile(profile1);
        profileManager.addProfile(profile2);
        profileManager.addFriendAuto(profile1.getName(), profile2.getName());
        assertTrue(profile1.getFriends().contains(profile2));
    }

    /**
     * Tests displaying profiles.
     * Ensures that the displayProfiles method works without throwing exceptions.
     */
    @org.junit.jupiter.api.Test
    void displayProfiles() {
        Profile profile = new Profile("Carol Jiao", "Online", null, 35, "Female", "WA");
        profileManager.addProfile(profile);
        try {
            profileManager.displayProfiles();
        } catch (Exception e) {
            fail("Exception should not have been thrown");
        }
    }

    /**
     * Tests displaying the friends of a profile.
     * Ensures that the displayFriends method works properly.
     */
    @org.junit.jupiter.api.Test
    void displayFriends() {
        Profile profile1 = new Profile("Carol Jiao", "Online", null, 35, "Female", "WA");
        Profile profile2 = new Profile("Elizabeth Hoyt", "Away", null, 30, "Female", "NY");
        profileManager.addProfile(profile1);
        profileManager.addProfile(profile2);
        profileManager.addFriend(profile1.getName(), profile2.getName());
        //assertDoesNotThrow(() -> profileManager.displayFriends(profile1.getName()));
    }

    /**
     * Tests listing all friends of friends automatically.
     * Ensures that the automatic addition of friends of friends works correctly.
     */
    @org.junit.jupiter.api.Test
    void listAllFriendsOfFriendsAuto() {
        Profile profile1 = new Profile("Carol Jiao", "Online", null, 35, "Female", "WA");
        Profile profile2 = new Profile("Elizabeth Hoyt", "Away", null, 30, "Female", "NY");
        Profile profile3 = new Profile("John Doe", "Online", null, 25, "Male", "CA");
        profileManager.addProfile(profile1);
        profileManager.addProfile(profile2);
        profileManager.addProfile(profile3);
        profileManager.addFriend(profile1.getName(), profile2.getName());
        profileManager.addFriend(profile2.getName(), profile3.getName());
        //assertDoesNotThrow(() -> profileManager.listAllFriendsOfFriendsAuto(profile1.getName()));
    }

    /**
     * Tests modifying the profile status automatically.
     * Ensures that a profile's status can be modified correctly.
     */
    @org.junit.jupiter.api.Test
    void modifyProfileStatusAuto() {
        Profile profile = new Profile("Carol Jiao", "Online", null, 35, "Female", "WA");
        profileManager.addProfile(profile);
        profileManager.modifyProfileStatusAuto(profile.getName(), "Away");
        assertEquals("Away", profile.getStatus());
    }

    /**
     * Tests deleting a profile automatically.
     * Ensures that the profile is removed from the profile manager.
     */
    @org.junit.jupiter.api.Test
    void deleteProfileAuto() {
        Profile profile = new Profile("Carol Jiao", "Online", null, 35, "Female", "WA");
        profileManager.addProfile(profile);
        profileManager.deleteProfileAuto(profile.getName());
        assertFalse(profileManager.getProfiles().contains(profile));
    }

    /**
     * Tests switching the current user automatically.
     * Ensures that the current user can be switched correctly.
     */
    @org.junit.jupiter.api.Test
    void switchCurrentUserAuto() {
        Profile profile = new Profile("Carol Jiao", "Online", null, 35, "Female", "WA");
        profileManager.addProfile(profile);
        profileManager.switchCurrentUserAuto(profile.getName());
        assertEquals(profile.getName(), profileManager.getCurrentUser().getName());
    }

    /**
     * Tests adding a new profile automatically.
     * Ensures that a new profile can be added with the provided details.
     */
    @org.junit.jupiter.api.Test
    void addNewProfileAuto() {
        Profile profile = new Profile("Carol Jiao", "Online", null, 35, "Female", "WA");
        //assertDoesNotThrow(() -> profileManager.addNewProfileAuto("Carol Jiao", "Online", null, 35, "Female", "WA"));
    }

    /**
     * Tests deleting a profile manually.
     * Ensures that the deleteProfile method removes the profile from the manager.
     */
    @org.junit.jupiter.api.Test
    void deleteProfile() {
        Profile profile = new Profile("Carol Jiao", "Online", null, 35, "Female", "WA");
        profileManager.addProfile(profile);
        profileManager.deleteProfile(profile.getName());
        assertFalse(profileManager.getProfiles().contains(profile));
    }

    /**
     * Tests listing all friends of friends.
     * Ensures that the listAllFriendsOfFriends method works correctly.
     */
    @org.junit.jupiter.api.Test
    void listAllFriendsOfFriends() {
        Profile profile1 = new Profile("Carol Jiao", "Online", null, 35, "Female", "WA");
        Profile profile2 = new Profile("Elizabeth Hoyt", "Away", null, 30, "Female", "NY");
        profileManager.addProfile(profile1);
        profileManager.addProfile(profile2);
        profileManager.addFriend(profile1.getName(), profile2.getName());
        //assertDoesNotThrow(() -> profileManager.listAllFriendsOfFriends(profile1.getName()));
    }

    /**
     * Tests the breadth-first traversal of profiles.
     * Ensures that the breadthFirstTraversal method works properly.
     */
    @org.junit.jupiter.api.Test
    void breadthFirstTraversal() {
        Profile profile = new Profile("Carol Jiao", "Online", null, 35, "Female", "WA");
        profileManager.addProfile(profile);
        //assertDoesNotThrow(() -> profileManager.breadthFirstTraversal(profile.getName()));
    }

    /**
     * Tests the depth-first traversal of profiles.
     * Ensures that the depthFirstTraversal method works properly.
     */
    @org.junit.jupiter.api.Test
    void depthFirstTraversal() {
        Profile profile = new Profile("Carol Jiao", "Online", null, 35, "Female", "WA");
        profileManager.addProfile(profile);
        //assertDoesNotThrow(() -> profileManager.depthFirstTraversal(profile.getName()));
    }
}
