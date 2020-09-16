package JavaAlgorithms;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class EncryptionSolution {

    // Complete the encryption function below.
    static String encryption(String s) {
        //trim the string and remove spaces
        s=s.trim().replace(" ","");
        //store the space removed string in char array
        char[] message=s.toCharArray();
        //logic to find no of rows and columns in grid 
        Double rootOfLength=Math.sqrt(s.length());
        
        Double rows= Math.floor(rootOfLength);
        
        Double columns=(rows >= rootOfLength?rows:rows+1);
        if(rows.intValue()*columns.intValue()!=s.length())
        {
            rows=(rows.intValue()+1D);
        }
        int k=0;
        //new char array grid to store string letters
        Character[][] intermediateMessage=new Character[rows.intValue()]                         [columns.intValue()];
        //string to hold final encrypted message
        String finalMessage="";
        //logic to store letters in char grid
        for(int i=0;i<rows;i++)
        {   
            
            for(int j=0;j<columns;j++)
            {   
                try
                {
                    intermediateMessage[i][j]=message[k+j];
                }
                catch(ArrayIndexOutOfBoundsException e)
                {
                    intermediateMessage[i][j]=0;
                }
            }
            k=k+columns.intValue();

            
        } 

        //logic to create final encrypted message

        for(int i=0;i<columns;i++)
        {
            for(int j=0;j<rows;j++)
            {   
                if(intermediateMessage[j][i]==0) continue;
                finalMessage=finalMessage+intermediateMessage[j][i];
            }
            finalMessage=finalMessage+" ";
            
        }

        return finalMessage;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Jay\\Desktop\\Selenium and Drivers\\test test.txt"));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}


