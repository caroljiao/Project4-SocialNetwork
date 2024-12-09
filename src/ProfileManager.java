import ADTPackage.LinkedQueue;
import ADTPackage.LinkedStack;
import ADTPackage.UnsortedLinkedDictionary;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Set;

/**
 * ProfileManager class that manages a collection of profiles and provides
 * various methods to manipulate and interact with profiles in the social network.
 */
public class ProfileManager {
    private UnsortedLinkedDictionary<String, Profile> profileDictionary = new UnsortedLinkedDictionary<>();
    private Profile currentUser;

    /**
     * Adds a new profile to the profile manager.
     *
     * //@param profile the Profile to be added
     * @return true if the profile was successfully added, false if it already exists
     */
    //public Profile getCurrentUser() {
       // return this.currentUser;  // Assuming currentUser is a field of type Profile
    //}
    public Profile getCurrentUser() {
        return currentUser;
    }
    public void switchCurrentUserAuto(String userName) {
        Set<Profile> profiles = getProfiles();  // Get all profiles from the profile dictionary
        for (Profile profile : profiles) {
            if (profile.getName().equals(userName)) {
                currentUser = profile;
                break;
            }
        }
    }


    public Set<Profile> getProfiles() {
        Set<Profile> profiles = new HashSet<>();
        Iterator<String> iterator = profileDictionary.getKeyIterator(); // Get all profile names
        while (iterator.hasNext()) {
            String name = iterator.next();
            Profile profile = profileDictionary.getValue(name);
            if (profile != null) {
                profiles.add(profile);
            }
        }
        return profiles;
    }

    public boolean addProfile(Profile profile) {
        if (profileDictionary.getValue(profile.getName()) != null) {
            return false; // Profile already exists
        }
        profileDictionary.add(profile.getName(), profile);
        return true;
    }

    /**
     * Adds a friendship between two profiles based on their names.
     *
     * @param name1 the name of the first profile
     * @param name2 the name of the second profile
     * @return true if the friendship was successfully established, false if any profile does not exist
     */
    public boolean addFriend(String name1, String name2) {
        Profile profile1 = profileDictionary.getValue(name1);
        Profile profile2 = profileDictionary.getValue(name2);

        if (profile1 != null && profile2 != null) {
            return profile1.addFriend(profile2) && profile2.addFriend(profile1);
        }
        return false;
    }

    /**
     * Adds a friendship between two profiles and prints the result automatically.
     *
     * @param name1 the name of the first profile
     * @param name2 the name of the second profile
     */
    public void addFriendAuto(String name1, String name2) {
        if (addFriend(name1, name2)) {
            System.out.println(name1 + " and " + name2 + " are now friends.");
        } else {
            System.out.println("Failed to add friend between " + name1 + " and " + name2);
        }
    }

    /**
     * Displays the details of all profiles.
     */
    public void displayProfiles() {
        Iterator<String> iterator = profileDictionary.getKeyIterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            Profile profile = profileDictionary.getValue(name);
            if (profile != null) {
                profile.printDetails();
            }
        }
    }

    /**
     * Displays the friends of a given profile.
     *
     * @param name the name of the profile whose friends are to be displayed
     */
    public void displayFriends(String name) {
        Profile profile = profileDictionary.getValue(name);
        if (profile != null) {
            profile.printFriends();
        } else {
            System.out.println("Profile not found.");
        }
    }

    /**
     * Lists all friends of friends automatically for a given profile.
     *
     * @param name the name of the profile whose friends of friends are to be listed
     */
    public void listAllFriendsOfFriendsAuto(String name) {
        Profile profile = profileDictionary.getValue(name);
        if (profile != null) {
            System.out.println("Friends of Friends of " + name + ":");

            Set<Profile> friendsOfFriends = new HashSet<>();

            // Iterate over the friends of the profile
            for (Profile friend : profile.getFriends()) {
                // Add the friends of the friends (avoid adding the original profile itself)
                for (Profile friendOfFriend : friend.getFriends()) {
                    if (!friendOfFriend.equals(profile) && !profile.getFriends().contains(friendOfFriend)) {
                        friendsOfFriends.add(friendOfFriend);
                    }
                }
            }

            // Print the friends of friends
            for (Profile friendOfFriend : friendsOfFriends) {
                System.out.println(friendOfFriend.getName() + " (" + friendOfFriend.getStatus() + ")");
            }

        } else {
            System.out.println("Profile not found.");
        }
    }

    /**
     * Modifies the status of a profile automatically.
     *
     * @param name the name of the profile whose status is to be updated
     * @param newStatus the new status to be set
     */
    public void modifyProfileStatusAuto(String name, String newStatus) {
        Profile profile = profileDictionary.getValue(name);
        if (profile != null) {
            profile.setStatus(newStatus); // Assuming Profile has a setStatus method
            System.out.println(name + "'s status has been updated to: " + newStatus);
        } else {
            System.out.println("Profile not found.");
        }
    }

    /**
     * Deletes a profile automatically.
     *
     * @param name the name of the profile to be deleted
     */
    public void deleteProfileAuto(String name) {
        Profile profile = profileDictionary.getValue(name);
        if (profile != null) {
            profileDictionary.remove(name); // Assuming UnsortedLinkedDictionary has a remove method
            System.out.println(name + " has been deleted.");
        } else {
            System.out.println("Profile not found.");
        }
    }
    /**
     * Switches the current user to the profile with the specified name.
     *
     * @param name the name of the profile to switch to
     */

    /**
     * Adds a new profile with the specified details to the ProfileManager.
     *
     * @param name the name of the new profile
     * @param email the email of the new profile
     * @param phoneNumber the phone number of the new profile
     * @param age the age of the new profile
     * @param status the status of the new profile
     * @param password the password of the new profile
     */
    public void addNewProfileAuto(String name, String email, String phoneNumber, int age, String status, String password) {
        // Create a new Profile object with the given parameters
        Profile newProfile = new Profile(name, email, phoneNumber, age, status, password);

        // Add the new profile to the profile dictionary
        if (addProfile(newProfile)) {
            System.out.println("New profile for " + name + " has been added.");
        } else {
            System.out.println("Failed to add new profile for " + name + ". Profile may already exist.");
        }
    }
    /**
     * Deletes a profile by its name from the ProfileManager.
     *
     * @param name the name of the profile to delete
     * @return
     */
    public boolean deleteProfile(String name) {
        Profile profile = profileDictionary.getValue(name);
        if (profile != null) {
            profileDictionary.remove(name);  // Assuming the UnsortedLinkedDictionary has a remove method
            System.out.println(name + " has been deleted.");
        } else {
            System.out.println("Profile not found.");
        }
        return false;
    }
    /**
     * Lists all friends of friends for a given profile.
     *
     * @param name the name of the profile whose friends of friends to display
     */
    public void listAllFriendsOfFriends(String name) {
        Profile profile = profileDictionary.getValue(name);
        if (profile != null) {
            System.out.println("Friends of Friends of " + name + ":");

            Set<Profile> friendsOfFriends = new HashSet<>();

            // Iterate over the friends of the profile
            for (Profile friend : profile.getFriends()) {
                // Add the friends of the friends (avoid adding the original profile itself)
                for (Profile friendOfFriend : friend.getFriends()) {
                    if (!friendOfFriend.equals(profile) && !profile.getFriends().contains(friendOfFriend)) {
                        friendsOfFriends.add(friendOfFriend);
                    }
                }
            }

            // Print the friends of friends
            if (friendsOfFriends.isEmpty()) {
                System.out.println("No friends of friends found.");
            } else {
                for (Profile friendOfFriend : friendsOfFriends) {
                    System.out.println(friendOfFriend.getName() + " (" + friendOfFriend.getStatus() + ")");
                }
            }

        } else {
            System.out.println("Profile not found.");
        }
    }
    /**
     * Performs a breadth-first traversal starting from the given profile.
     *
     * @param startName the name of the profile to start the traversal from
     */
    public void breadthFirstTraversal(String startName) {
        Profile startProfile = profileDictionary.getValue(startName);
        if (startProfile == null) {
            System.out.println("Profile not found.");
            return;
        }

        LinkedQueue<Profile> queue = new LinkedQueue<>();
        Set<Profile> visited = new HashSet<>();
        queue.enqueue(startProfile);
        visited.add(startProfile);

        while (!queue.isEmpty()) {
            Profile current = queue.dequeue();
            System.out.println(current.getName() + " -> " + current.getStatus());

            for (Profile friend : current.getFriends()) {
                if (!visited.contains(friend)) {
                    queue.enqueue(friend);
                    visited.add(friend);
                }
            }
        }
    }

    /**
     * Performs a depth-first traversal starting from the given profile.
     *
     * @param startName the name of the profile to start the traversal from
     */
    public void depthFirstTraversal(String startName) {
        Profile startProfile = profileDictionary.getValue(startName);
        if (startProfile == null) {
            System.out.println("Profile not found.");
            return;
        }

        LinkedStack<Profile> stack = new LinkedStack<>();
        Set<Profile> visited = new HashSet<>();
        stack.push(startProfile);
        visited.add(startProfile);

        while (!stack.isEmpty()) {
            Profile current = stack.pop();
            System.out.println(current.getName() + " -> " + current.getStatus());

            for (Profile friend : current.getFriends()) {
                if (!visited.contains(friend)) {
                    stack.push(friend);
                    visited.add(friend);
                }
            }
        }
    }
}
