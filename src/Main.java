public class Main {
    public static void main(String[] args) {
        ProfileManager manager = new ProfileManager();

        // Initialize 18 profiles automatically
        initializeProfiles(manager);

        System.out.println("\n--- Starting Automatic Simulation ---");

        // Automated Simulation Process
        System.out.println("\n1. Viewing All Profiles:");
        manager.displayProfiles();

        System.out.println("\n2. Adding Friends (Multiple Friendships):");
        manager.addFriendAuto("Carol Jiao", "Elizabeth Hoyt");
        manager.addFriendAuto("Carol Jiao", "Frank Cook");
        manager.addFriendAuto("Carol Jiao", "Steven Slezak");
        manager.addFriendAuto("Carol Jiao", "Jason Bedford");

        System.out.println("\n3. Viewing Carol's Friend List:");
        manager.displayFriends("Carol Jiao");

        System.out.println("\n4. Viewing Friends of Carol's Friends:");
        manager.listAllFriendsOfFriendsAuto("Carol Jiao");

        System.out.println("\n5. Modifying Carol's Status:");
        manager.modifyProfileStatusAuto("Carol Jiao", "Available for Chat");

        System.out.println("\n6. Deleting Profile (Frank Cook):");
        manager.deleteProfileAuto("Frank Cook");

        System.out.println("\n7. Switching Current User to Elizabeth Hoyt:");
        manager.switchCurrentUserAuto("Elizabeth Hoyt");

        System.out.println("\n8. Adding Another Profile (John Doe):");
        manager.addNewProfileAuto("John Doe", "Active", null, 28, "Male", "CA");

        System.out.println("\n--- Simulation Complete ---");
    }

    /**
     * Initializes all 18 predefined profiles and their friendships.
     */
    private static void initializeProfiles(ProfileManager manager) {
        manager.addNewProfileAuto("Carol Jiao", "Online", null, 35, "Female", "WA");
        manager.addNewProfileAuto("Elizabeth Hoyt", "Away", null, 40, "Female", "CA");
        manager.addNewProfileAuto("Frank Cook", "Out-of-office", null, 38, "Male", "TX");
        manager.addNewProfileAuto("Steven Slezak", "In-meeting", null, 32, "Male", "MD");
        manager.addNewProfileAuto("Jason Bedford", "Online", null, 28, "Male", "WA");
        manager.addNewProfileAuto("Daisy Nuynue", "Online", null, 29, "Female", "CA");
        manager.addNewProfileAuto("Nathan Glespies", "In-meeting", null, 33, "Male", "TX");
        manager.addNewProfileAuto("Maxwell Berman", "Out-of-office", null, 30, "Male", "AL");
        manager.addNewProfileAuto("Sophie White", "Away", null, 27, "Female", "ID");
        manager.addNewProfileAuto("Anthoney McGilen", "In-meeting", null, 36, "Male", "CA");
        manager.addNewProfileAuto("Chaos Gao", "Online", null, 34, "Male", "WA");
        manager.addNewProfileAuto("Anue Kaka", "Away", null, 29, "Female", "TX");
        manager.addNewProfileAuto("Yuan Gao", "Out-of-office", null, 31, "Male", "MD");
        manager.addNewProfileAuto("Johnna Doge", "In-meeting", null, 26, "Female", "AL");
        manager.addNewProfileAuto("Shanron Li", "Online", null, 40, "Male", "CA");
        manager.addNewProfileAuto("Xiaojing Xu", "Away", null, 38, "Female", "WA");
        manager.addNewProfileAuto("Yuki Mila", "Online", null, 28, "Female", "TX");
        manager.addNewProfileAuto("Eileen Subramoney", "Out-of-office", null, 41, "Female", "ID");

        // Define friendships
        manager.addFriendAuto("Carol Jiao", "Elizabeth Hoyt");
        manager.addFriendAuto("Carol Jiao", "Frank Cook");
        manager.addFriendAuto("Carol Jiao", "Steven Slezak");
        manager.addFriendAuto("Carol Jiao", "Jason Bedford");
        manager.addFriendAuto("Elizabeth Hoyt", "Frank Cook");
        manager.addFriendAuto("Elizabeth Hoyt", "Johnna Doge");
        manager.addFriendAuto("Elizabeth Hoyt", "Shanron Li");
        manager.addFriendAuto("Elizabeth Hoyt", "Xiaojing Xu");
        manager.addFriendAuto("Frank Cook", "Jason Bedford");
        manager.addFriendAuto("Steven Slezak", "Daisy Nuynue");
        manager.addFriendAuto("Jason Bedford", "Nathan Glespies");
        manager.addFriendAuto("Maxwell Berman", "Sophie White");
        manager.addFriendAuto("Anthoney McGilen", "Chaos Gao");
        manager.addFriendAuto("Yuan Gao", "Anue Kaka");
        manager.addFriendAuto("Johnna Doge", "Shanron Li");
        manager.addFriendAuto("Xiaojing Xu", "Yuki Mila");
        manager.addFriendAuto("Eileen Subramoney", "Nathan Glespies");
    }
}
