import java.util.*;
import java.io.*;
public class Truck{
    //attributes and constants 
    private int truckID;
    private int truckType; // this is what is needed to determine the following below

    private double currentWeight;// this depends on the packages added to the truck along with the volume
    private double currentVolume;
    private double maxWeight;
    private double maxVolume;//this and the max weight is determined by the truck used 
    private ArrayList<Pack> pack;
    private int hoursUsed;// this will get calculated and updated 
    private int companiesStoppedAt;
    
    private static final int smallTruck=1;
    private static final int medTruck=2;
    private static final int largeTruck=3;

    public static int nextID=1;

//constructors
public Truck (){
    setTruckID();
    setTruckType(smallTruck); //the default truck is small 

    currentWeight=0;
    currentVolume=0;
    
    setPack(new ArrayList<>());
    hoursUsed=0;
}
//non default constructor 
public Truck(int newTruckType){
    setTruckID();
    setTruckType(newTruckType);

    currentWeight=0;
    currentVolume=0;

    setPack(new ArrayList<>());
    hoursUsed=0;
}

//getters
public int getTruckID(){
    return truckID;
}

public double getCurrentWeight(){
    return currentWeight;
}

public double getCurrentVolume(){
    return currentVolume;
}

/*public double getMaxWeight(){  this might not be needed bc it is determined
    return maxWeight;               by the truck type. The setter will do this 
}

public double getMaxVolume(){
    return maxVolume;
}*/

public ArrayList<Pack> getPack(){
    return pack;
}

public int getHoursUsed(){
    return hoursUsed;
}

public int getTruckType(){
    return truckType;
}

//setters 
public void setTruckID(){
    truckID= nextID++;
}

public void setTruckType(int newTruckType){
    if(newTruckType==smallTruck){
        truckType=smallTruck;
        maxWeight=2000;
        maxVolume=1000;
    }
    else if (newTruckType == medTruck){
        truckType=medTruck;
        maxWeight=4000;
        maxVolume=2000;
    }
    else if(newTruckType==largeTruck){
        truckType=largeTruck;
        maxWeight=8000;
        maxVolume=4000;
    }
    else{
        truckType=smallTruck;
        maxWeight=2000;
        maxVolume=1000;
    }
 }

public void setPack(ArrayList<Pack> newPack){
    if(newPack==null){
        pack=new ArrayList<>();
    }
    else{
        pack=newPack;
    }
}


//methods needed 
public boolean addPackage (Pack newPack){
    if(newPack==null){
        return false;
    } 
    else if(newPack.getWeight()+currentWeight<=maxWeight && 
            newPack.getVolume()+currentVolume<=maxVolume){
        pack.add(newPack);
        currentWeight= currentWeight+ newPack.getWeight();
        currentVolume= currentVolume+ newPack.getVolume();
        return true;
    }
    else{
        return false;
    }
}

public int calculateHoursUsed(){
    if(pack.size()==0){
        hoursUsed=0;//no packs no hours 
        return 0;
    }
    //now we have to sort through the companies and the zones 
    ArrayList<String> zones= new ArrayList<>();// here we make a place to store the zones from the packages 
    ArrayList<ArrayList<String>> companiesInZone= new ArrayList<>();// this is a list in a list, so based on the zone, the companies are listed under (2-D Array)
    
    for(Pack p: pack){
        String zone= p.getDeliveryZone();
        String company= p.getCompName();
//remember we are using an array list so we can use those methods and such
        int index= zones.indexOf(zone);// this is to check if the zone is already listed 
        if(index==-1){
            zones.add(zone);// to add the zone not on the list to the list 
            ArrayList<String> newZoneList = new ArrayList<>(); 
            newZoneList.add(company);
            companiesInZone.add(newZoneList);   
        }
        else{// this is if the zone is already in the list sop we just add the company under that zone 
            ArrayList<String> currentZoneList= companiesInZone.get(index);
            if(!currentZoneList.contains(company)){// saying is the comp is not on their then add it 
                currentZoneList.add(company);
            }
        }
    }
    //now based on this we can do the hours used calculation 
    int hours=0;
    for(int i=0; i< zones.size(); i++){
        int numCompanies= companiesInZone.get(i).size();
        int stopsMade= 5-i;
        if(stopsMade < 1){
        stopsPerHour = 1;
        }
        int hoursForZone=0;
        while(numCompanies >0){
            numCompanies= numCompanies-stopsMade;
            hoursForZone++;
        }
        hours= hours+ hoursForZone;
    }    
    hoursUsed=hours;
    return hours;
}

public String toString(){
    return "Truck ID: "+ truckID + " Truck Type: "+ truckType + "\nCurrent Weight: "+ currentWeight + " Current Volume: "+ currentVolume + "\nHours Used: "+ hoursUsed;
}

}



