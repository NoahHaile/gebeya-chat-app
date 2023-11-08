import java.io.*;
import java.util.*;

public class PrivateChat {
    public PrivateChat() {
        privateChatHistory = new ArrayList<>();
    }
    private ArrayList<String> privateChatHistory;
    public void privateRead(File privateMessage1, File privateMessage2) throws FileNotFoundException {
        updatePrivateChat(privateMessage1, privateMessage2);
        for (String chat : privateChatHistory) {
            System.out.println(chat);
        }
    }

    private void updatePrivateChat(File privateMessage1, File privateMessage2) throws FileNotFoundException{
        try{
            Scanner private_Read1 = new Scanner(privateMessage1);
            while(private_Read1.hasNextLine()) {
                String privateInput = private_Read1.nextLine();
                privateChatHistory.add(privateInput);
            }
            private_Read1.close();
        }
        catch(Exception e){
            ;
        }
        try{
        
            Scanner private_Read2 = new Scanner(privateMessage2);
            while(private_Read2.hasNextLine()) {
                String privateInput = private_Read2.nextLine();
                privateChatHistory.add(privateInput);
            }
            private_Read2.close();
        }
        catch(Exception e){
            ;
        }
    }

    public void privateWrite(String privateMessage, String ip1, String ip2, String name) throws IOException {
        
        File privateFile1 = new File("./Donut["+ip1+ip2+"].log");
        File privateFile2 = new File("./Donut["+ip2+ip1+"].log");
        try {
            // Check if the file exists
            if (privateFile1.exists()) {
                // If the file exists, use FileWriter with append mode
                FileWriter publicMessageWriter = new FileWriter(privateFile1, true);
                PrintWriter appendWriter = new PrintWriter(publicMessageWriter);
                appendWriter.println("<" + name + "> " + privateMessage + "\n"); // Append a new line of data
                appendWriter.close();
            } else if(privateFile2.exists()) {
                // If the file exists, use FileWriter with append mode
                FileWriter publicMessageWriter = new FileWriter(privateFile2, true);
                PrintWriter appendWriter = new PrintWriter(publicMessageWriter);
                appendWriter.println("<" + name + "> " + privateMessage + "\n"); // Append a new line of data
                appendWriter.close();
            } 
            else {
                // If the file doesn't exist, create a new file
                privateFile1.createNewFile();
                PrintWriter publicMessageWriter = new PrintWriter(privateFile1);
                publicMessageWriter.write("<" + name + ">" + privateMessage + "\n");
                publicMessageWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
