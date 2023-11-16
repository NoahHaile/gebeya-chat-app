/**
* Custom Exception handles an exception suited for file management which is IOExceptionn
* and write the message of the error to a file CUSTOM_LOG_FILE.
*
* @author  Kidus Berhanu
*/
package ChatExceptions;

import java.io.FileWriter;
import java.io.IOException;

public class CustomExceptionHandler {
    private FileWriter fileWriter;
    public void handleException(Throwable exception){
        try{
            if(exception instanceof IOException){
                fileWriter = new FileWriter("Custom_LOG_FILE");
                fileWriter.write("Custome exception: " + exception.getMessage());
                fileWriter.close();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
