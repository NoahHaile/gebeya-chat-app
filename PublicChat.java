import java.io.*;
import java.util.*;

public class PublicChat {
    public PublicChat() {
        publicChatHistory = new ArrayList<>();
    }
    private ArrayList<String> publicChatHistory;

    public void publicRead(File privateMessage) throws FileNotFoundException {
        updatePublicChat(privateMessage);
        for (String chat : publicChatHistory) {
            System.out.println(chat);
        }
        
    }

    private void updatePublicChat(File privateMessage) throws FileNotFoundException {
        try{
        Scanner public_Read = new Scanner(privateMessage);
        publicChatHistory.clear();
        while(public_Read.hasNextLine()) {
            String publicInput = public_Read.nextLine();
            publicChatHistory.add(publicInput);
            
        }
        public_Read.close();
        }
        catch(Exception e){
            System.out.println("NO PUBLIC CHATS");
        }
    }

    public void publicWrite(String privateMessage, String name) throws IOException {
        File publicFile = new File("./Eurakarte.log");
        try {
            // Check if the file exists
            if (publicFile.exists()) {
                // If the file exists, use FileWriter with append mode
                FileWriter publicMessageWriter = new FileWriter(publicFile, true);
                PrintWriter appendWriter = new PrintWriter(publicMessageWriter);
                appendWriter.println("<" + name + "> " + privateMessage + "\n"); // Append a new line of data
                appendWriter.close();
            } else {
                // If the file doesn't exist, create a new file
                publicFile.createNewFile();
                PrintWriter publicMessageWriter = new PrintWriter(publicFile);
                publicMessageWriter.write("<" + name + "> " + privateMessage + "\n");
                publicMessageWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
