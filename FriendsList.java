import java.io.*;
import java.util.*;

public class FriendsList {
    public FriendsList() {
        friendsListNames = new ArrayList<String>();
        friendsListIp = new ArrayList<String>();
    }
    private ArrayList<String> friendsListNames;
    private ArrayList<String> friendsListIp;
    public int max;

    public String getByIndex(int i){
        return friendsListIp.get(i-1);
    }
    public void displayList(File FriendsList) throws FileNotFoundException {
        updateFriends(FriendsList);
        int i = 1;
        for (String friendName : friendsListNames) {
            System.out.println(i++ + " " + friendName);
        } 
        max = i - 1;  
        System.out.println("INPUT INDEX: ");
    }
    public void friendRead(File FriendsList) throws FileNotFoundException {
        updateFriends(FriendsList);
        for (String friendName : friendsListNames) {
            System.out.println(friendName);
        }   
    }

    private void updateFriends(File FriendsList) throws FileNotFoundException {
        Scanner friendReader = new Scanner(FriendsList);
        friendsListNames.clear();
        friendsListIp.clear();
        int i = 0;
        while(friendReader.hasNextLine()) {
            String friend_Reader = friendReader.nextLine();
            if( i++ % 2 == 0 )
                friendsListNames.add(friend_Reader);
            else
                friendsListIp.add(friend_Reader);
            
        }
        friendReader.close();
    }

    public void friendWrite(String friendsName) throws IOException {
        File friendFile = new File("./friends.list");
        
        
        try {
            // Check if the file exists
            if (friendFile.exists()) {
                // If the file exists, use FileWriter with append mode
                FileWriter friendNameWriter = new FileWriter(friendFile, true);
                PrintWriter appendWriter = new PrintWriter(friendNameWriter);
                appendWriter.println(friendsName); // Append a new line of data
                appendWriter.close();
            } else {
                // If the file doesn't exist, create a new file
                friendFile.createNewFile();
                PrintWriter friendNameWriter = new PrintWriter(friendFile);
                friendNameWriter.write(friendsName);
                friendNameWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
