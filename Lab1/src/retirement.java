import java.util.Scanner;

public class retirement {
	/*Written by Eric Krone and Daniel Caballero
	 * 
	 * A class with methods for calculating the future value of annuity and for 
	 * calculating how much money a user needs saved to retire and withdraw a fixed
	 * monthly income.
	 */
	
	int yearsToWork;
	double expectedROIWorking;
	int yearsToRetire;
	double expectedSSIincome; 
	double expectedROIRetired;
	double retirementSavings;
	double savingsPerMonth;
	double retiredMonthlyAllowance;
	
	public retirement(){
		/*
		 * No arg constructor, default all values to 0.
		 */
		yearsToWork = 0;
		expectedROIWorking = 0;
		yearsToRetire = 0;
		expectedROIRetired = 0;
		expectedSSIincome = 2642;
		retirementSavings = 0;
		savingsPerMonth = 0;
		retiredMonthlyAllowance = 0;
	}
	
	public void setYearsToWork(){
		/*
		 * Get the number of years to work from the user
		 */
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the number of years you wish to work: \n");
		this.yearsToWork = input.nextInt();
		
	}
	
	public void setExpectedROIWorking(){
		/*
		 * Get the interest rate while working from the user
		 */
		Scanner input = new Scanner(System.in);
		boolean validChoice = false;
		while (!validChoice){
			System.out.println("Please enter your expected ROI while you are slaving away: \n");
			double userROIWorking = input.nextDouble();
			if (userROIWorking >= 0 && userROIWorking <= .20){
				this.expectedROIWorking = userROIWorking;
				validChoice = true;
			}
			else{
				System.out.println("Unrealistic ROI parameter.");
			}
		}
	}
	
	public void setYearsToRetire(){
		/*
		 * Get the number of retirement years from the user
		 */
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter how many Golden Years you wish to have: \n");
		this.yearsToRetire = input.nextInt();
		
	}
	
	public void setExpectedSSIincome(){
		/*
		 * Get the expected SSI income from the user
		 */
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter your expected Social Secuity income: \n");
		this.expectedSSIincome = input.nextDouble();
		
	}
	
	public void setExpectedROIRetired(){
		/*
		 * Get the interest rate during retirement from the user
		 */
		Scanner input = new Scanner(System.in);
		boolean validChoice = false;
		while (!validChoice){
			System.out.println("Please enter your expected ROI during your Golden Years: \n");
			double userROIRetired = input.nextDouble();
			if (userROIRetired >= 0 && userROIRetired <= .03){
				this.expectedROIRetired = userROIRetired;
				validChoice = true;
			}
			else{
				System.out.println("Unrealistic ROI parameter.");
			}
		}
	}
	
	public void setRetiredMonthlyAllowance(){
		/*
		 * Get the monthly allowance from the user
		 */
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the amount you wish to withdraw during retirement: \n");
		this.retiredMonthlyAllowance = input.nextDouble();
		
	}
	
	public void setSavingsPerMonth(){
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter how much you wish save per month, while working: \n");
		this.savingsPerMonth = input.nextDouble();
	}
	
	public double calcAnnuityValue(){
		/*
		 * Calculate the future value of an annuity.
		 */
		double annuityValue = 
				this.savingsPerMonth*
				(1-
				Math.pow(1 + (this.expectedROIWorking/12), this.yearsToWork*12)
				)
				/(this.expectedROIWorking/12);
				System.out.println(-annuityValue);
		return -annuityValue;
	}
	
	public double calcSavingsNeeded(){
		/*
		 * Calculate how large of a lump sum we need to withdraw a known monthly allowance
		 * for a known number of years at a known interest rate.
		 */
		double savingsNeeded = 
				12*(this.retiredMonthlyAllowance - this.expectedSSIincome)*
				(1-Math.pow(1+this.expectedROIRetired/12, -this.yearsToRetire*12))/.02;
				System.out.println(savingsNeeded);
		return savingsNeeded;
				
	}
		
	public static void main(String args[]){
		/* Testing purposes only. Remove comment block to commence test.
		 * 
		retirement Test = new retirement();
		Test.savingsPerMonth = 554.13;
		Test.expectedROIWorking = .07;
		Test.yearsToWork = 40;
		System.out.println(Test.calcAnnuityValue());
		Test.retiredMonthlyAllowance = 10000;
		Test.expectedROIRetired = .02;
		Test.yearsToRetire = 20;
		System.out.println(Test.calcSavingsNeeded());
		
		*/
		retirement planner = new retirement();
		Scanner input = new Scanner(System.in);
		int choice = 0;
		System.out.println("Please select your option:\n 1:Calculate Future Annuity Value\n 2:Calculate required retirement sum\n");
		choice = input.nextInt();
		if (choice == 1){
			planner.setSavingsPerMonth();
			planner.setExpectedROIWorking();
			planner.setYearsToWork();
			planner.calcAnnuityValue();
		}
		else if (choice == 2){
			planner.setRetiredMonthlyAllowance();
			planner.setExpectedROIRetired();
			planner.setYearsToRetire();
			planner.setExpectedSSIincome();
			planner.calcSavingsNeeded();
		}
		
	}
	
}
