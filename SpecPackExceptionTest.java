import java.util.Scanner;
public class SpecPackExceptionTest {
	public static void main(String[] args) throws InvalidSpecPackException {
		Scanner keyboard = new Scanner(System.in);

		int testNum= keyboard.nextInt();
		if (testNum==1) { // Test Case 1 - non-default constructor
			SpecPack sp1=new SpecPack();
			boolean instantiateOK=false; 
			System.out.println("TESTING NON-DEFAULT CONSTRUCTOR");			
			do {
				int time = keyboard.nextInt();
				try {
					sp1=new SpecPack("Orange Inc.","C3",new Date(3,16,2007),8,7,time);
					instantiateOK=true;
					System.out.println("NON-DEFAULT CONSTRUCTOR OK");
				}
				catch (InvalidSpecPackException ispe){
					System.out.println(ispe.getMessage() + " try again.");
				}
			} while (!instantiateOK);
		}
		if (testNum==2) { // Test Case 2 - mutator
			SpecPack sp2 = new SpecPack("HAL Industries","A1",new Date(7,6,2020),1,30,12);
			boolean mutatorOK=false; 	
			System.out.println("TESTING MUTATOR");
			do {
				int time = keyboard.nextInt();
				try {
					sp2.setTime(time);
					mutatorOK=true;
					System.out.println("MUTATOR OK");
				}
				catch (InvalidSpecPackException ispe){
					System.out.println(ispe.getMessage() + " try again." );
				}
			}
			while (!mutatorOK);
		}
	}
}
