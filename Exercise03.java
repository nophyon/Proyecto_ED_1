/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sheet03;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author Mati
 */
public class Exercise03 {
    
    
    /*
    
    if file not exists
        ask for initial word
        create file store word
    
    if file exists
        show last word
      do
        ask for a word starting with the last letter of the last word
      while bad introduced
    
        when correct store and exit
    
    */
    
    public static void main (String [] args){
        
        Scanner stdin = new Scanner (System.in);
        File file = null;
        Exercise03 ex3 = new Exercise03 ();
        ObjectOutputStream output = null;
        ObjectInputStream input = null;
        String var, word=null;
        boolean bol=true;
        
        file = new File("G:\\Daw 1º\\Programación\\Unit 10\\Unit10\\src\\Sheet01\\Exercise3file.txt");
        
        if(file.exists()==false){
            System.out.print("¿Palabra Inicial? ");
            var = stdin.next();
            try{
            output = new ObjectOutputStream(new FileOutputStream("G:\\Daw 1º\\Programación\\Unit 10\\Unit10\\src\\Sheet01\\Exercise3file.txt"));
            output.writeUTF (var);
            output.close();
            }catch(FileNotFoundException e){
                System.out.println("File Not Found");
            }catch(IOException e){
                
            }finally{
                
            }
            
        }else{
            
            try{
                 input = new ObjectInputStream(new FileInputStream("G:\\Daw 1º\\Programación\\Unit 10\\Unit10\\src\\Sheet01\\Exercise3file.txt"));
                 word = input.readUTF();
                 input.close();
            }catch(FileNotFoundException e){
                 System.out.println("File Not Found");
            }catch(EOFException e){
                
            }catch(IOException e){    
                
            }finally{
                
            }
            
            do{
            System.out.println(word);
            System.out.print("Dame una palabra que empiece por "+word.charAt(word.length()-1)+": ");
            var = stdin.next();
            
            if(var.charAt(0)==word.charAt(word.length()-1)){
                System.out.println("Palabra correcta, guardada");
                
                    try{
                         output = new ObjectOutputStream(new FileOutputStream("G:\\Daw 1º\\Programación\\Unit 10\\Unit10\\src\\Sheet01\\Exercise3file.txt"));
                         output.writeUTF (var);
                         output.close();
                        }catch(FileNotFoundException e){
                            System.out.println("File Not Found");
                        }catch(IOException e){
                
                        }finally{
                
                        }
                
                bol=false;
            }
            else{
                System.out.println("Error, elige otra palabra.");
            }
         
            
            }while(bol==true);
        }
        
         
        
    }
}
