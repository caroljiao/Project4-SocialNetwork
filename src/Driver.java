import ADTPackage.LinkedQueue;
import ADTPackage.LinkedStack;
import ADTPackage.UnsortedLinkedDictionary;

public class Driver {
    public static void main(String[] args) {
        ProfileManager manager = new ProfileManager();

        // 1. Adding Profiles
        System.out.println("Adding profiles...");
        manager.addProfile(new Profile("Carol Jiao", "Online", null, 35, "Female", "WA"));
        manager.addProfile(new Profile("Elizabeth Hoyt", "Away", null, 30, "Female", "NY"));
        manager.addProfile(new Profile("John Smith", "Busy", null, 40, "Male", "CA"));
        manager.addProfile(new Profile("Mia Chen", "At Work", null, 29, "Female", "WA"));
        manager.addProfile(new Profile("Mark Miller", "In a Meeting", null, 33, "Male", "CA"));

        System.out.println("Profiles added successfully!");

        // 2. Display All Profiles
        System.out.println("\nAll Profiles in the System:");
        manager.displayProfiles();

        // 3. Adding Friendships
        System.out.println("\nAdding friendships...");
        manager.addFriend("Carol Jiao", "Elizabeth Hoyt");
        manager.addFriend("Elizabeth Hoyt", "John Smith");
        manager.addFriend("Mia Chen", "Mark Miller");

        System.out.println("Friendships added successfully!");

        // 4. Display Friend Lists
        System.out.println("\nFriend List for 'Elizabeth Hoyt':");
        manager.displayFriends("Elizabeth Hoyt");

        System.out.println("\nFriend List for 'Mia Chen':");
        manager.displayFriends("Mia Chen");

        // 5. Breadth-First Traversal (using LinkedQueue)
        System.out.println("\nBreadth-First Traversal starting from 'Elizabeth Hoyt':");
        manager.breadthFirstTraversal("Elizabeth Hoyt");

        // 6. Depth-First Traversal (using LinkedStack)
        System.out.println("\nDepth-First Traversal starting from 'Elizabeth Hoyt':");
        manager.depthFirstTraversal("Elizabeth Hoyt");

        // 7. Removing a Profile
        System.out.println("\nRemoving 'Mia Chen' from the system...");
        manager.deleteProfile("Mia Chen");
        System.out.println("Profile 'Mia Chen' removed successfully!");

        // 8. Display All Profiles Again
        System.out.println("\nUpdated Profiles in the System:");
        manager.displayProfiles();

        // 9. Display Friends of Friends
        System.out.println("\nFriends of 'Elizabeth Hoyt's friends:");
        manager.listAllFriendsOfFriends("Elizabeth Hoyt");

        // 10. Edge Cases
        System.out.println("\nTesting edge cases:");
        System.out.println("Trying to delete a non-existent profile 'Jane Doe':");
        if (!manager.deleteProfile("Jane Doe")) {
            System.out.println("Profile 'Jane Doe' not found.");
        }

        System.out.println("\nTrying to add a friendship with a non-existent profile:");
        if (!manager.addFriend("John Smith", "Jane Doe")) {
            System.out.println("Failed to add friendship. Ensure both profiles exist.");
        }
    }
}
