package lab2.aviaries;

import java.io.Serializable;
import java.util.ArrayList;

import lab2.animals.Animal;

/**
 * 
 * @author gusarov2906
 * Abstract class Animal - parent of classes "AquariumAviary", "OpenAirAviary", "MeshAviary" and "InfraredLightedAviary" 
 *
 */

public class Aviary  implements Serializable {
	
	//Fields
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * name - name of aviary in ZOO.
	 * array - arrays of animals which existed in ZOO in this aviary.
	 */
	
	protected String name;
	public ArrayList<Animal> array;
	
	//Constructors
	
	/**
	 *	Default constructor 
	 */
	
	public Aviary()
	{
		name = "NotDifinedRoom";
		array = new ArrayList<Animal>();
	}
	

	/**
	 *	Constructor with fields.
	 *	@param newName - name for aviary.
	 */
	
	public Aviary(String newName)
	{
		name = newName;
		array = new ArrayList<Animal>();
	}
	//Methods: usual
	
	/**
	 * view - function to output in console all fields of object.
	 */
	
	public void view()
	{
		System.out.println(name);
	}
	
	/**
	 * add - function to add new animal to aviary.
	 * @param animal - animal which need to move in aviary.
	 */
	
	public void add(Animal animal)
	{
		array.add(animal);
	}
	
	
	
	/**
	 * count - function to get how many animals live in this aviary.
	 * @return num of animals in this aviary.
	 */
	
	public int count()
	{
		return array.size();
	}
	
	// Methods: setters and getters
	
	/**
	 * setName - setter for field "name".
	 * @param newName - new name for aviary.
	 */
	
	public void setName(String newName)
	{
		name = newName;
	}
	
	/**
	 * getName - getter for filed "name".
	 * @return - returns field "name".
	 */
	
	public String getName()
	{
		return name;
	}
	
	
}
