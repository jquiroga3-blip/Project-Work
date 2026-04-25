
import java.util.*;
import java.io.*;
public class PackageCollection {
	public static ArrayList<Pack> readPackages (String fileName) throws IOException{
	// we dont use this anymore because it is now a method not a main class because I want to use it in the 
	// package delivery system main class
		//Scanner in= new Scanner(System.in);
		//String fileInput = in.nextLine(); // this is the file the user enters
		//int numberOfRows=in.nextInt();// this is the number of rows user enters

		//Instead do this 
		File file = new File(fileName);
		Scanner readFile = new Scanner(file);// this will read the file the user entered 
		ArrayList<Pack> data= new ArrayList<>(); // creating the array where the packages/specpac will be stored

		//now we must add it to the Pack object while the file has more values
		while(readFile.hasNextLine()){
			// we put this inside the loop bc we want it for one line at a time not the whole thing 
			String stringFile= readFile.nextLine();// this will store the file contents into a string
			String [] stringData = stringFile.split(",");// this will split the file contents by the comma 

		//remember we need the date objects not string 
		String dateValues[]= stringData[3].split("/");
		int month = Integer.parseInt(dateValues[0]);
		int day= Integer.parseInt(dateValues[1]);
		int year= Integer.parseInt(dateValues[2]);

		Date date= new Date(month, day, year);

				if(stringData[0].equals("R")){
					data.add(new Pack( stringData[1], stringData[2], date,
						 Integer.parseInt(stringData[4]), Integer.parseInt(stringData[5])));// here we must change the last two things in the object to ints
					//slotsUsed++;
				}
				else{
					data.add(new SpecPack(stringData[1], stringData[2], date,
						 Integer.parseInt(stringData[4]), Integer.parseInt(stringData[5]), Integer.parseInt(stringData[6]) ));
					//slotsUsed++;
				}
				
			}
			return data;

			/*I might not need what is below anymore but will keep in case I DO 
// now i have to do this:Then process the array and output for each military hour of 
// the day (9 through 15) how many packages have a deadline of each hour.
//so i must loop though the Pack data 

		for(int hours=9; hours<= 17; hours++){// we use slotsused bc the data may have more than we need
			int countPackage= 0;

			for(int i=0; i<slotsUsed; i++){
				if(data[i].getTime()==hours){
					countPackage++;
				}
			}
			
			
		System.out.println("deadlineHour#"+ hours   +" packageCount="+ countPackage );
		
	}
}
	*/
}


}