/**
 * Created by Kyle on 11/7/2015.
 */
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Lab6 {

    public static void main(String args[]) throws FileNotFoundException {
        String file, dir, loc;
        char type, command;
        BinarySearchTree<String> systemTree = new BinarySearchTree<String>();

        //File file1 = new File("../instr/lab6.dat");
        //Scanner fileIn = new Scanner(file1);

        Scanner fileIn = new Scanner(System.in);

        while(fileIn.hasNext()){

            String input = fileIn.nextLine();

            command = input.charAt(0);

            switch (command) {

                case 'c' : {
                    type = input.charAt(2);

                    if (type == 'd') {
                        //create directory
                        dir = input.substring(4);
                        systemTree.insertDir(dir);
                    }
                    else if (type == 'f'){
                        //create file in directory
                        String split[] = input.split(" ");
                        file = split[2];
                        loc = split[3];
                        systemTree.insertFile(loc, file);
                    }
                    else{
                        System.out.println("Incorrect input.");
                    }//end if
                    break;
                }//end case c

                case 's' : {
                    dir = input.substring(2);
                    systemTree.getFiles(dir);
                    System.out.println();
                    break;
                }//end case s

                case 't' : {
                    System.out.println("********");
                    System.out.print("Printing System:");
                    systemTree.traversePrint();
                    break;
                }//end case t

                default:{
                    System.out.println("Incorrect command input.");
                }//end default
            }//end switch
        }//end while
        fileIn.close();
    }//end main
}//end Lab6
