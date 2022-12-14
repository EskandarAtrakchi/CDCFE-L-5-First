import java.util.Scanner;// Scanner class from Java utilities library
	public class ATMTest 
	{// start class
		    static Scanner input = new Scanner (System.in);
		    static String customersNames[]=
		    	{"Ali","Alex","Mia","Jenny","Joy"};// The names of the customers 
		    static int customersPins[]= 
		    	{1111,2222,3333,4444,5555};// The Pins of the Customers 
		    static int customersBalances[]=
		    	{111,222,333,444,555};// The customers balances 
		    static int overDraft[]=
		    	{0,0,0,0,0};// overDraft is zero so the Customer's account won't be minus 
		    static String struserInput;
		    static int index;
		    static int counter=3;// maximum Number of attempts 
		    static int userPin;
		    static int customerWithdraw;
		    static int customerDeposit;
		    static int Exit;
		    //struserInput=input.next(); i will use this to take the input as a string 
	            //inputValidation();//check the validation of an input 
		    //customerWithdraw = Integer.parseInt(struserInput);//parse String into integer
		    //-----------------------------------------------------------------------------------
		    public static void main(String[] args) 
		    {//Start main
		    	PrintCustomersAccounts();// print the customers account method 
		    	login();// log-in method 
		    		}//End main
		    //-----------------------------------------------------------------------------------
			public static void PrintCustomersAccounts() 
			{//start method
				System.out.println("--------------------"
						+ "--------------------------------");// just printing the line 
				System.out.println("\t\tESKANDARS'S BANK");// declare the name of the bank
				//Drawing a line to separate the names from the bank's name 
				System.out.println("---------------------"
						+ "-------------------------------\n");
				System.out.println("\tNames\t\tPins\t\tBalances");// print the headings of the fields 
				System.out.println("---------------------------"
						+ "--------------------------\n");//Drawing a line to separate the headings
				   for(int i=0;i<5;i++)
				   {//start for loop to show all users info
				    	  System.out.println
				    	  ("\t"+customersNames[i]+"\t\t"+customersPins[i]+"\t\t"+customersBalances[i]);
				      }//end for loop
				   System.out.println("-------------------------------"
				      		+ "-----------------------\n");//Drawing a line
				      }//End method
			//------------------------------------------------------------------------------------
				public static void login() 
				{//Start log-in method for correct and incorrect Pin
				System.out.println("Please enter your Pin");// Asking the customer to enter their Pin
				struserInput=input.next();//take in user input as a string
				inputValidation();//check the validation of the user's input 
				userPin = Integer.parseInt(struserInput);//parse String into integer
				//scenario number 1 (correct Pin)
						for(int i=0;i<customersNames.length;i++) 
						{//start for loop for correct pins 
							if(userPin == customersPins[i]) 
							{//start if statement
								index=i;//hold users 
								selectionMenu();// Get the customer to the selection menu 
								}//end if
						}//end for
						//Scenario number 2 (Incorrect Pin)
						for(int i=0;i<customersNames.length;i++) 
						{//for loop for incorrect pin
							if(userPin != customersPins[i]) 
							{//start if statement for incorrect Pin 
								System.out.println("INVALID PIN");//Printing the line if the customer get to enter wrong Pin
								attemptsMethod();//Count an attempt 
								login();//get the customer to try to log-in again since it is not their third attempt
								}//end if	
						}//end for
				}//End method login
			//---------------------------------------------------------------------------------------
				public static void attemptsMethod() 
				{//start attempts method
				counter --;//counter starts from 3 and count downwards in minus 
				//to show the customer how many attempts left 
				System.out.println("\nYou have---"+ counter+"---attempts left\n");
				if(counter==0) 
				{//start if statement when the customer fails to enter their pin on the third attempt 
					System.out.println("ATTENTION, YOUR CARD IS BLOCKED");//after 3 wrong attempts 
					System.exit(0);//get the customer to exit because of 3 fail attempts 
					}//end if statement 
				else 
				{// start else 
					login();//to get the user to the login method since the counter is not zero yet
				}//end else statement
			}//end method
			//----------------------------------------------------------------------------------------
			public static void selectionMenu() 
			{//start selectionMenu method
				while(true) 
				{//start while loop for the user to choose an option
					//customer can select one of those
				System.out.println("\n------------------------------------"
						+ "------------------\nSelect number 1 for bank Statement"
						+ "\nSelect number 2 to withdraw\n"
						+ "Select number 3 to Deposit\nSelect number 4 to Exit this ATM");
				struserInput=input.next();//take in user input as a string
				inputValidation();//check if the user input is valid
				int option = Integer.parseInt(struserInput);//parse String into integer
					switch(option) 
					{//start switch statement
					case 1:statementMethod();break;
					case 2:withdrawMethod();break;
					case 3:depositMethod();break;
					case 4:Exit();break;
					//in-case there was invalid input the user should retry again through the selection menu
					default:
						//to show the customer the input is invalid
						System.out.println("Incorrect selection");
					selectionMenu();//to get the customer to the selection menu again 
					}//end switch statement
				}//end while loop
			}//end method
			//-------------------------------------------------------------------------------------------
			public static void statementMethod() 
			{//start statementMethod
				System.out.println("\t\tName\t\tPin\t\tBalance\n");
				System.out.println("---------------------------------------------------------");
				System.out.println("\t\t"+customersNames[index]+
						"\t\t"+customersPins[index]+"\t\t$"+customersBalances[index]);//to print the customers info
				System.out.println("---------------------------------------------------------");
				//to inform the customer about the bank statement
				System.out.println("\n\t\tThis is your Bank Statement\n");
				//notify the customer that his card still active 
				System.out.println("\tYou still can select from the menu down below\n");
				selectionMenu();//get the customer to selection Menu in-case for any other process 
			}//end method
			//-------------------------------------------------------------------------------------------
			public static void withdrawMethod() 
			{//start withdraw method
				System.out.println("How much to withdraw");//ask the customer how much they they want to withdraw 
				struserInput=input.next();//take in user input as a string
				inputValidation();//check if the user input is valid
				customerWithdraw = Integer.parseInt(struserInput);//parse String into integer
				 if (customerWithdraw<=customersBalances[index]&& 
					customerWithdraw - customersBalances[index]<= overDraft[index]) 
				 {//start if statement
					//update user account balance after the withdrawal
					 customersBalances[index]=customersBalances[index]-customerWithdraw;
				 System.out.println("Your new balance is now: "+ customersBalances[index]);//inform the customer the new balance
				 System.out.println("Your card is still active in the ATM\n"
				 		+ "Please select from the menu down below\n");//notify the customer that his card still active
				 selectionMenu();//get the customer to selection Menu in-case for any other process 
				 }//end if statement
				 else 
				 {//start else for another Scenario 
					 System.out.println("No enough funds");//if the customer withdraws more than the OverDraft
					 selectionMenu();//then direct the customer to the selection menu for selections
				 }//end else statement
			}//end method
			//--------------------------------------------------------------------------------------------
			public static void depositMethod() 
			{//start deposit Method
				System.out.println("How much you want to deposit");//ask the customer how much they want to deposit 
				struserInput=input.next();//take in user input as a string
				inputValidation();//check if the user input is valid
				customerDeposit = Integer.parseInt(struserInput);//parse String into integer
				//update user account balance after depositing
				customersBalances[index]= customersBalances[index]+customerDeposit;
				System.out.println("\nPlease take your reciept\n");
				//print the updating balance for the customer so they know 
				System.out.println("\nYour new balance is now: "+ customersBalances[index]);
				System.out.println("Your card is still active in the ATM\n"
				 		+ "Please select from the menu down below\n");//notify the customer that his card still active
				selectionMenu();//get the customer back to choose from the selection menu 
			}//end method
			//---------------------------------------------------------------------------------------------
			public static void Exit() 
			{// start method 
				System.out.println("\n\t\t\tPlease take your card");
			System.out.println("\n---------------------------"
				+ "Have a nice day---------------------------\n");//print good bye line
			System.exit(0);//get the system to exit 
			}//end method
			//---------------------------------------------------------------------------------------------
			public static void inputValidation() {//start errorTypeInputCheck
				while(!struserInput.matches("\\d+")) 
				{//start while loop for not numbers input 
					System.out.println("\nNot allowed, "
							+ "numbers only!\n");//print this line when the customer does not enter numbers only
					struserInput=input.next();//take in user input as a string
					}//end while loop	
			}//end method
		}//end class 
