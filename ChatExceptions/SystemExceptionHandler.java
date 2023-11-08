package ChatExceptions;

import java.io.FileWriter;
import java.io.IOException;

public class SystemExceptionHandler {
//    public void handleException(Exception e) {
//        System.out.println("Custom Exception Handler => " + e.getMessage());
//    }
    private FileWriter fileWriter;
    public void handleException(Throwable exception){
        try{
            if(exception instanceof Exception){
                fileWriter = new FileWriter("System_LOG_FILE");
                fileWriter.write("System exception: " + exception.getMessage());
                fileWriter.close();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
