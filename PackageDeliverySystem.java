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
            Collections.sort(data);
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

            boolean packagesAdded = false;

            for (Truck trucks : trucksBeingUsed) {
                try {
                    if (trucks.addPackage(packages)) {
                    packagesAdded = true;
                    break;
                    }
                } catch (InvalidTruckException e) {
                     bf2.write(e.getMessage());
                    bf2.newLine();
                 }
                }

            //here we are saying that if no packages can be added to the truck then we have to make a new truck and then
            //add the packages to the new truck

            if (!packagesAdded) {
                Truck newTruck;

                if (packages.getWeight() > 4000 || packages.getVolume() > 2000) {
                    newTruck = new Truck(3); // needs LARGE
                }
                else if (packages.getWeight() > 2000 || packages.getVolume() > 1000) {
                    newTruck = new Truck(2); // needs MEDIUM
                }
                else {
                    newTruck = new Truck(1); // SMALL is enough
                }

                try {
                    newTruck.addPackage(packages);
                    trucksBeingUsed.add(newTruck);
                } catch (InvalidTruckException e) {
                    bf2.write("Package too large for any truck: " + packages.getPackID());
                    bf2.newLine();
                }
            }
        }

        //now we calculate the truck hours as said in the project and 
        //out put to the files it said to 
        //we add counters to make it easier to calculate the actual truckHours

        //so in one zome the truck can stop at only 5 companies and if it goes to another zone
        // then in the next zone it can only stop at 4 companies

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