import java.util.*;
import java.io.*;
//import java.lang.reflect.Array;
public class PackageDeliverySystem {
	public static void main(String[] args) throws IOException {
       Scanner in = new Scanner(System.in);
       System.out.println("Enter file name");
              // now the package collection class can be used to read the file and create package objects to store the package in the trucks
        String fileName= in.nextLine(); 

        ArrayList<Pack> data= PackageCollection.readPackages(fileName);
        ArrayList<Truck> trucksBeingUsed= new ArratList<>();

        // now we must add the packs to the truck by looping 
        for(Pack packages: data){
              if(()
        })


}
