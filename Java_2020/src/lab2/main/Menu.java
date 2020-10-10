package lab2.main;

import java.util.ArrayList;
import java.util.Scanner;

import lab2.animals.ColdBlooded;
import lab2.animals.Feathered;
import lab2.animals.Ungulates;
import lab2.animals.Waterfowl;

import lab2.aviaries.AquariumAviary;
import lab2.aviaries.Aviary;
import lab2.aviaries.InfraredLightedAviary;
import lab2.aviaries.MeshAviary;
import lab2.aviaries.OpenAirAviary;


public final class Menu {
	
	//Fields
	
	/**
	 * name - string variable to fill some fields.
	 * type - string variable to fill some fields.
	 * weight - float variable to fill some fields.
	 * age - integer variable to fill some fields.
	 * cmd - integer command for console to go thought menu.
	 * id - integer unique number.
	 */
	
	static private String name;
	static private String type;
	static private float weight;
	static private int age;
	
	private int cmd = -1;
	private int id = 0;
	private int moveTo = 0;
	
	//Methods
	
	/**
	 * NegIntException - exception for checking integer number bigger or equal 0.
	 */
	
	public class NegIntException extends Exception { 
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public NegIntException(String errorMessage) {
	        super(errorMessage);
	    }
	    
	}
	
	/**
	 * MaxIntException - exception for checking integer number bigger than something.
	 */
	
	public class MaxIntException extends Exception { 
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MaxIntException(String errorMessage) {
	        super(errorMessage);
	    }
	    
	}
	
	/**
	 * readPosInt - safety analog Scanner.nextInt() (checking 2 exceptions).
	 * @param scanner - object type Scanner from where you get integer number.
	 * @return Function returns positive or null integer number, which get from scanner or close program with exception.
	 */
	
	public int readPosInt(Scanner scanner) {
		  try {
			int num = scanner.nextInt();
			if (num < 0)
			{
				throw new NegIntException("Number shouldn't be less then null!");
			}
		    return num;
		  }
		  catch (java.util.InputMismatchException e) {
		    String token = scanner.next();
		    System.out.println("Exception: not int was readen - " + token + " !");
		    return 0;
		  }
		  catch (java.util.NoSuchElementException e) {
			System.out.println("Exception: no int nums ! ");
		    return 0;
		  }
		  catch (NegIntException e) {
				System.out.println("Exception: " + e.getMessage());
			    return 0;
			  }
	}
	
	/**
	 * readCmd -  function to read command from user.
	 * @param scanner - object type Scanner from where you get integer number.
	 * @param maxNumCmd - number of max command which can be readen.
	 * @return Function returns real command for menu.
	 */
	
	public int readCmd(Scanner scanner, int maxNumCmd)
	{
		int cmd = -1;
		try {
		cmd = readPosInt(scanner);
		if (cmd > maxNumCmd)
		{
			throw new MaxIntException("Number shouldn't be less then" + maxNumCmd + " !");
		}
		}
		catch (MaxIntException e) {
			System.out.println("Exception: " + e.getMessage());
		    return 0;
		}
		catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		    return 0;
		}
		return cmd;
	}
	
	/**
	 * arrayView - function to output array.
	 * @param array - array with items.
	 */
	
	private void arrayView(ArrayList<? extends Aviary> array)
	{
		for(int i = 0; i < array.size(); i++)
		{
			System.out.print(i+ ") ");
			array.get(i).view();
		}
		System.out.println();
	}
	
	/**
	 * getFields - function to get some variables from user.
	 * @param scanner - object type Scanner from where you get integer number.
	 */
	
	private void getFields(Scanner scanner)
	{
		System.out.print("Write name: ");
		name = scanner.next();
		System.out.print("Write type(rank, class or something): ");
		type = scanner.next();
		System.out.print("Write weight: ");
		weight = scanner.nextFloat();
		System.out.print("Write age: ");
		age = readPosInt(scanner);	
	}
	
	/**
	 * getMoveCmd - function to get some variables from user for animal to move.
	 * @param scanner
	 */
	private void getMoveCmd(Scanner scanner)
	{
		System.out.print("Write number of aviary, from where you want to move: ");
		cmd = readCmd(scanner,100);
		System.out.print("Write id animal, which you want to move: ");
		id = readCmd(scanner,100);
		System.out.print("Write number of aviary, where you want to move: ");
		moveTo = readCmd(scanner,100);
	}
	
	/**
	 * clearConsole - function to clear console window.
	 */
	
	public final void clearConsole() 
	{
		try {
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		}
		catch (Exception e)
		{
			
		}
	}  
	
	
	/**
	 * run - start menu.
	 * @param arrayAquariumAviary - array with aquarium aviaries.
	 * @param arrayOpenAirAviary - array with open air aviaries.
	 * @param arrayMeshAviary - array with mesh aviaries.
	 * @param arrayInfraredLightedAviary - array with infrared lighted aviaries.
	 */
	public void run(ArrayList<AquariumAviary> arrayAquariumAviary,
					ArrayList<OpenAirAviary> arrayOpenAirAviary,
					ArrayList<MeshAviary> arrayMeshAviary,
					ArrayList<InfraredLightedAviary> arrayInfraredLightedAviary)
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome to ZOO!");
		while(true)
		{
		System.out.println();
		System.out.println("What you want to do?");
		System.out.println("1: Show aviaries");
		System.out.println("2: Create animal");
		System.out.println("3: Create aviary");
		System.out.println("4: Move animal");
		System.out.print("Your cmd: ");
		cmd = readCmd(scanner,4);
		switch (cmd) {
			case 1:
				clearConsole();
				System.out.println("AVIARIES LIST");
				System.out.println("What type of aviaries you want to look?");
				System.out.println("1: Aquarium");
				System.out.println("2: Open Air");
				System.out.println("3: Mesh");
				System.out.println("4: Infrared Lighted");
				System.out.println("5: All");
				System.out.print("Your cmd: ");
				cmd = readCmd(scanner,5);
				switch (cmd) {
					case 1:
						clearConsole();
						System.out.println("AVIARIES LIST");
						System.out.println("AQUARIUM: ");
						arrayView(arrayAquariumAviary);
						break;
					case 2:
						clearConsole();
						System.out.println("AVIARIES LIST");
						System.out.println("OPEN AIR: ");
						arrayView(arrayOpenAirAviary);
						break;
					case 3:
						clearConsole();
						System.out.println("AVIARIES LIST");
						System.out.println("MESH: ");
						arrayView(arrayMeshAviary);
						break;
					case 4:
						clearConsole();
						System.out.println("AVIARIES LIST");
						System.out.println("INFRARED LIGHTED: ");
						arrayView(arrayInfraredLightedAviary);
						break;
					case 5:
						clearConsole();
						System.out.println("AVIARIES LIST");
						System.out.println("AQUARIUM:");
						arrayView(arrayAquariumAviary);
						System.out.println();
						System.out.println("OPEN AIR:");
						arrayView(arrayOpenAirAviary);
						System.out.println();
						System.out.println("MESH:");
						arrayView(arrayMeshAviary);
						System.out.println();
						System.out.println("INFRARED LIGHTED:");
						arrayView(arrayInfraredLightedAviary);
						System.out.println();
						break;
					default:
						break;
				}
				break;
			case 2:
				clearConsole();
				System.out.println("CREATING ANIMAL");
				System.out.println("What type of animal you want to create?");
				System.out.println("1: Waterfowl");
				System.out.println("2: Ungulates");
				System.out.println("3: Feathered");
				System.out.println("4: Cold blooded");
				System.out.print("Your cmd: ");
				cmd = readCmd(scanner,4);
				switch(cmd) {
					case 1:
						System.out.println("CREATING ANIMAL");
						clearConsole();
						getFields(scanner);
						new Waterfowl(name,type,weight,age);
						break;
					case 2:
						System.out.println("CREATING ANIMAL");
						clearConsole();
						getFields(scanner);
						new Ungulates(name,type,weight,age);
						break;
					case 3:
						System.out.println("CREATING ANIMAL");
						clearConsole();
						getFields(scanner);
						new Feathered(name,type,weight,age);
						break;
					case 4:
						clearConsole();
						System.out.println("CREATING ANIMAL");
						getFields(scanner);
						new ColdBlooded(name,type,weight,age);
						break;
					default:
						break;
				}
				break;
			case 3:
				clearConsole();
				System.out.println("CREATING AVIARY");
				System.out.println("What type of aviary you want to create?");
				System.out.println("1: Aquarium");
				System.out.println("2: Open Air");
				System.out.println("3: Mesh");
				System.out.println("4: Infrared Lighted");
				System.out.print("Your cmd: ");
				cmd = readCmd(scanner,4);
				clearConsole();
				System.out.println("CREATING AVIARY");
				System.out.print("Write name: ");
				scanner.nextLine();
				name = scanner.nextLine();
				switch (cmd) {
					case 1:
						arrayAquariumAviary.add(new AquariumAviary(name));
						break;
					case 2:
						arrayOpenAirAviary.add(new OpenAirAviary(name));
						break;
					case 3:
						arrayMeshAviary.add(new MeshAviary(name));
						break;
					case 4:
						arrayInfraredLightedAviary.add(new InfraredLightedAviary(name));
						break;
				}
				break;
			case 4:
				System.out.println("From what type of aviary you want to move animal?");
				System.out.println("1: Aquarium");
				System.out.println("2: Open Air");
				System.out.println("3: Mesh");
				System.out.println("4: Infrared Lighted");
				System.out.print("Your cmd: ");
				cmd = readCmd(scanner,4);
				switch (cmd) {
				case 1:
					clearConsole();
					System.out.println("MOVE ANIMAL FROM WHERE");
					System.out.println("AQUARIUM: ");
					arrayView(arrayAquariumAviary);
					getMoveCmd(scanner);
					try {
						arrayAquariumAviary.get(cmd).getById(id).move(arrayAquariumAviary.get(moveTo));
					}
					catch (Exception e)
					{
						System.out.println("Exception: " + e.getMessage());
					}
					
					break;
				case 2:
					clearConsole();
					System.out.println("MOVE ANIMAL FROM WHERE");
					System.out.println("OPEN AIR: ");
					arrayView(arrayOpenAirAviary);
					getMoveCmd(scanner);
					try {
						arrayOpenAirAviary.get(cmd).getById(id).move(arrayOpenAirAviary.get(moveTo));
					}
					catch (Exception e)
					{
						System.out.println("Exception: " + e.getMessage());
					}
					break;
				case 3:
					clearConsole();
					System.out.println("MOVE ANIMAL FROM WHERE");
					System.out.println("MESH: ");
					arrayView(arrayMeshAviary);
					getMoveCmd(scanner);
					try {
						arrayMeshAviary.get(cmd).getById(id).move(arrayMeshAviary.get(moveTo));
					}
					catch (Exception e)
					{
						System.out.println("Exception: " + e.getMessage());
					}
					break;
				case 4:
					clearConsole();
					System.out.println("MOVE ANIMAL FROM WHERE");
					System.out.println("INFRARED LIGHTED: ");
					arrayView(arrayInfraredLightedAviary);
					getMoveCmd(scanner);
					try {
						arrayInfraredLightedAviary.get(cmd).getById(id).move(arrayInfraredLightedAviary.get(moveTo));
					}
					catch (Exception e)
					{
						System.out.println("Exception: " + e.getMessage());
					}
					break;
			default:
				break;
			}
				
		}
	}
	}
}