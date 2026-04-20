public class Truck{
    //attributes and constants 
    private int truckID;
    private double currentWeight;// this depends on the packages added to the truck along with the volume
    private double currentVolume;
    private double maxWeight;
    private double maxVolume;//this and the max weight is determined by the truck used 
    private Arraylist<Pack> pack;
    private int hoursUsed;// this will get calculated and updated 
    

    private static final int smallTruck=1;
    private static final int medTruck=2;
    private static final int largeTruck=3;

    public static int nextID=1;

    /*private static final int smallTruckVolumeLimit=1000;
    private static final int smallTruckWeightLimit=2000;
    private static final int mediumTruckVolumeLimit=2000;
    private static final int mediumTruckWeightLimit= 4000;
    private static final int largeTruckVolumeLimit=4000;
    private static final int largeTruckWeightLimit= 8000;
*/

//constructors
public Truck (){
    setTruckID();
    setCurrentWeight();
    setCurrentVolume();
    setMaxWeight();
    setMaxVolume();
    setPack(new ArrayList<>());
    //setHoursUsed();
}
//non default constructor 
public Truck(double newCurrentWeight, double newCurrentVolume, double newMaxWeight, double newMaxVolume){
    setTruckID();
    setCurrentWeight(newCurrentWeight);
    setCurrentVolume(newCurrentVolume);
    setMaxWeight(newMaxWeight);
    setMaxVolume(newMaxVolume);
    //setPack(new ArrayList<>());
    //setHoursUsed(newHoursUsed);
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

public double getMaxWeight(){
    return maxWeight;
}

public double getMaxVolume(){
    return maxVolume;
}

public ArraryList<Package> getPack(){
    return pack;
}

/*public int getHoursUsed(){
    return hoursUsed;
}
    */

//setters 
public void setTruckID(){
    truckID= nextID++;
}

/*public void setCurrentWeight(double newCurrentWeight){
    if(newCurrentWeight>=0){
        currentWeight=newCurrentWeight;
    }
    else{
        currentWeight=0;
    }
    }

public void setCurrentVolume(double newCurrentVolume){
    if(newCurrentVolume>=0){
        currentVolume=newCurrentVolume;
    }
    else{
        currentVolume=0;
    }
    }
*/
public void setMaxWeight(double newMaxWeight){
    if(newMaxWeight>=0){
        maxWeight=newMaxWeight;
    }
    else{//if the input is invalid, set the max weight to 0     
        maxWeight=0;//might have to add the condictions depending on what truck is used 
    }
}

public void setMaxVolume(double newMaxVolume){
    if(newMaxVolume>=0){
        maxVolume=newMaxVolume;
    }
    else{
        maxVolume=0;
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

public void setHoursUsed(int newHoursUsed){
    if(newHoursUsed>=0){
        hours=newHoursUsed;
    }
    else{
        hoursUsed=0;
    }
}

//methods needed 
public boolean addPackage (Package newPack){
    if(newPack==null){
        return false;
    } 
    else if()
    }
}

}
