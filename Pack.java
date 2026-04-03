public class Pack implements Comparable<Pack>{

private int packID;
private String compName;
private String deliveryZone;
private Date deliveryDate;
private int weight;
private int volume;

//default values
public static final String DEFAULT_COMP_NAME="Default Company";
public static final String DEFAULT_DEVIVERY_ZONE= "A1";
//public static final Date DEFAULT_DEVIVERY_DATE= new Date(); DONT DO THIS 
public static final int DEFAULT_WEIGHT=1;
public static final int DEFAULT_VOLUME=1;
//public static final int DEFAULT_TIME_DEADLINE=9; this is for the spec class 
public static int nextID=1;

public static final int GET_TIME=17;
//constructors 
//default

public Pack(){
    setPackID();
    setCompName(DEFAULT_COMP_NAME);
    setDeliveryZone(DEFAULT_DEVIVERY_ZONE);
    setDeliveryDate(new Date());
    setWeight(DEFAULT_WEIGHT);
    setVolume(DEFAULT_VOLUME);
}
public Pack(String newCompName, String newDeliveryZone, Date newDeliveryDate, int newWeight, int newVolume ){
    setPackID();
    setCompName(newCompName);
    setDeliveryZone(newDeliveryZone);
    setDeliveryDate(newDeliveryDate);
    setWeight(newWeight);
    setVolume(newVolume);
}

//accessors

public int getPackID(){
    return packID;
}

public String getCompName(){
    return compName;
}

public String getDeleveryZone(){
    return deliveryZone;
}

public Date getDeliveryDate(){
    return new Date(deliveryDate);
}

public int getWeight(){
    return weight;
}
public int getVolume(){
    return volume;
}
public void setPackID(){
    packID= nextID++;// bc it says system generated 
}

public void setCompName(String newCompName){
    if(newCompName ==null){
        compName=DEFAULT_COMP_NAME;
    }
    else{
        compName= newCompName;
    }
}

public void setDeliveryZone(String newDeliveryZone){
    if(newDeliveryZone==null || !(newDeliveryZone.length()==2) ||
     !(Character.isLetter(newDeliveryZone.charAt(0))) || 
     !(Character.isDigit(newDeliveryZone.charAt(1)))){ // here we are using the char to make sure it is a letter or a digit based on the char tools thing 
        deliveryZone=DEFAULT_DEVIVERY_ZONE;
    }
    else{
        deliveryZone= newDeliveryZone;
    }
}

public void setDeliveryDate(Date newDeliveryDate){
    if(newDeliveryDate==null){
        deliveryDate = new Date();
    }
    else{
    deliveryDate= new Date(newDeliveryDate);
    }
}

public void setWeight(int newWeight){
    if(newWeight<=0){
        weight = DEFAULT_WEIGHT;
    }
    else{
        weight= newWeight;
    }
}
public void setVolume(int newVolume){
    if(newVolume > 0){
        volume = newVolume;
    }
    else{
        volume = DEFAULT_VOLUME;
    }
}
    public int compareTo(Pack other) {

        int zoneCompare = this.getDeleveryZone().compareTo(other.getDeleveryZone());
        if (zoneCompare != 0) {
            return zoneCompare;
        }

        return Integer.compare(other.getVolume(), this.getVolume());
}

public String toString(){
    return "ID:"+ getPackID()+ " Company:"+getCompName()+ " Zone:"+ getDeleveryZone()+ " Date:"+ getDeliveryDate()+" Weight:"+ getWeight()+ " Volume:"+getVolume();
}

public int getTime(){
	return GET_TIME;
}

}
