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
        ArrayList<Truck> trucksBeingUsed= new ArrayList<>();

        // now we must add the packs to the truck by looping 
        for(Pack packages: data){
            boolean packagesAdded=false;
              for(Truck trucks: trucksBeingUsed){
                  if(trucks.addPackage(packages)){
                        packagesAdded=true;
                  }     
              }
            //here we are saying that if no packages can be added
            //to the truck then we have to make a new truck and then
            //add the packages to the new truck 
              if(!packagesAdded){
                  Truck newTruck= new Truck();
                  newTruck.addPackage(packages);
                  trucksBeingUsed.add(newTruck);
              }

        }
        //now we calculate the truck hours as said in the project and 
        //out put to the files it said to 
        //we add counters to make it easier to calculate the actual truckHours
         int totalTruckHours = 0;

        int small = 0;
        int medium = 0;
        int large = 0;

        for(Truck trucks: trucksBeingUsed){
            trucks.calculateHoursUsed();//from truck class
            int truckHours=trucks.getHoursUsed();
            if(trucks.getTruckType==1){
                  small++;
                  totalTruckHours= totalTruckHours+ (1*truckHours);
            }
            else if(trucks.getTruckType==2){
                  medium++;
                  totalTruckHours= totalTruckHours+ (2*truckHours);
            }
            else{
                  large++;
                  totalTruckHours= totalTruckHours+ (3*truckHours);
            }
        }

            System.out.println("Total Truck Hours: "+ totalTruckHours+ "\nSmall Trucks: "+ small+ "\nMedium Trucks: "+ medium+ "\nLarge Trucks: "+ large);
//now we output it 
try{
    FileWriter out1= new FileWriter("deliveries.txt");
    BufferedWriter bf1= new BufferedWriter(out1);
    for(Truck trucks: trucksBeingUsed){
      bf1.write(trucks.toString());
      bf1.newLine();

      for(Pack packages: trucks.getPack()){
            bf1.write(packages.toString());
            bf1.newLine();
      }
    }
}
 catch(IOException IOE){
    System.out.println(IOE);
 }

 try{
      FileWriter out2= new FileWriter("log.txt");
    BufferedWriter bf2= new BufferedWriter(out2);
 }
      catch(IOException IOE){
      System.out.println(IOE);
      }
 }
}


    