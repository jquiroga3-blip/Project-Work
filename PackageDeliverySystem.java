import java.util.*;
import java.io.*;
public class PackageDeliverySystem {
	public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter file name");
              // now the package collection class can be used to read the file and create package objects to store the package in the trucks
        String fileName= in.nextLine(); 
        FileWriter out2= new FileWriter("log.txt");
        BufferedWriter bf2= new BufferedWriter(out2);

        ArrayList<Pack> data = new ArrayList<>();
        ArrayList<Truck> trucksBeingUsed= new ArrayList<>();
        ArrayList<String> errors = new ArrayList<>();
            try {
                
                data = PackageCollection.readPackages(fileName,errors);
                
            }
            catch (IOException e) {
                bf2.write("File error: " + e.getMessage());
                bf2.newLine();
         } catch (Exception e) {
            bf2.write("Unexpected parsing error: " + e.getMessage());
            bf2.newLine();
        }
        if (data == null) {
         data = new ArrayList<>();
        }
        for (String err : errors) {
             bf2.write(err);
             bf2.newLine();
            }
        

        // now we must add the packs to the truck by looping 
        for(Pack packages: data){
             if(packages == null){
                bf2.write("Invalid package skipped from file");
                bf2.newLine();
                 continue;
             }
            boolean packagesAdded=false;  
            
                for(Truck trucks: trucksBeingUsed){
                    try{
                    if(trucks.addPackage(packages)){
                        packagesAdded=true;
                        break;
                        }  
                       
                    }catch (InvalidTruckException e) {
                        bf2.write("Truck rejected package ID " + packages.getPackID() + ": " + e.getMessage());
                       bf2.newLine();
                    }catch (Exception e) {
                        bf2.write("Unexpected truck error for package ID " + packages.getPackID());
                        bf2.newLine();
                    }
                }
 //here we are saying that if no packages can be added to the truck then we have to make a new truck and then
 //add the packages to the new truck 

                if(!packagesAdded){
                try{
                  Truck newTruck = new Truck(1);
                  
                    if(!newTruck.addPackage(packages)){
                        newTruck = new Truck(2); 
                        if(!newTruck.addPackage(packages)){
                            newTruck = new Truck(3); 
                            newTruck.addPackage(packages);
                            }
                        }
                   trucksBeingUsed.add(newTruck);
              } catch (InvalidTruckException e) {
                    bf2.write("Truck creation error for package " + packages.getPackID());
                    bf2.newLine();
                }catch (Exception e) {
                    bf2.write("Error on package " + packages.getPackID());
                    bf2.newLine();
                }           
                    }
        }
        //now we calculate the truck hours as said in the project and 
        //out put to the files it said to 
        //we add counters to make it easier to calculate the actual truckHours

        //so in one zome the truck can stop at only 5 companies and if it goes to another zone
        // then in the next zone it can only stop at 4 companies
            //so we want to sort them by zone and by volume 
        int totalTruckHours = 0;

        int small = 0;
        int medium = 0;
        int large = 0;

        for(Truck trucks: trucksBeingUsed){
            trucks.calculateHoursUsed();//from truck class
            int truckHours=trucks.getHoursUsed();
            if(trucks.getTruckType()==1){
                  small++;
                  totalTruckHours= totalTruckHours+ (1*truckHours);
            }
            else if(trucks.getTruckType()==2){
                  medium++;
                  totalTruckHours= totalTruckHours+ (2*truckHours);
            }
            else{
                  large++;
                  totalTruckHours= totalTruckHours+ (3*truckHours);
            }
        }

           System.out.println("Total Truck Hours: "+ totalTruckHours+ "\nSmall Trucks: "+ small+ "\nMedium Trucks: "+ medium+ "\nLarge Trucks: "+ large);

            //now we output it to the files
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
                bf1.flush();
                bf1.close();
            
                }
                    catch(IOException IOE){
                    System.out.println(IOE);
                    }
                    bf2.flush();
                     bf2.close();
 }
           
}



    