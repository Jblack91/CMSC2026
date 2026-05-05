/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Circus
 * Due:5/4/2026
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Julian Black
*/
package BobsCircus;
import java.util.ArrayList;
import java.util.List;

public class Circus {
    private List<Animal> animals;
    private List<Person> persons;
    private List<Building> buildings;

    public Circus() {
        animals = new ArrayList<>();
        persons = new ArrayList<>();
        buildings = new ArrayList<>();
    }
    
    public List<Animal> getAnimals()
    {
    	return animals;
    }
    
    public List<Person> getPersons()
    {
    	return persons;
    }
    
    public List<Building> getBuildings()
    {
    	return buildings;
    }


    public void addBuilding(Building building)
    {
    	buildings.add(building);
    }

    public void displayAllBuildings()
    {
    	for (Building b : buildings)
    	{
    		System.out.println(b);
    	}
    }

    public void addPerson(Person person)
    {
    	persons.add(person);
    }

    public void displayAllPersons()
    {
    	for (Person p : persons)
    	{
    		System.out.println(p);
    	}
    }

    public void addAnimal(Animal animal)
    {
    	animals.add(animal);
    }

    public void displayAllAnimals()
    {
    	for (Animal a : animals)
    	{
    		System.out.println(a);
    	}
    }

    public void sortAnimalsByAge()
    {
    	for (int i = 0; i < animals.size() - 1; i++) 
    	{
    		int min = i;
    		for (int j = i + 1; j < animals.size(); j++) 
    		{
    		    if (animals.get(j).getAge() < animals.get(min).getAge()) 
    		    {
    		        min = j;
    		    }
    		}
    		
    		Animal temp = animals.get(i);
    		animals.set(i, animals.get(min));
    		animals.set(min, temp);
    	}
    }
    
    public void sortAnimalsByName()
    {
    	for (int i = 0; i < animals.size() - 1; i++) 
    	{
    		int min = i;
    		for (int j = i + 1; j < animals.size(); j++) 
    		{
    		    if (animals.get(j).getName().compareToIgnoreCase(animals.get(min).getName()) < 0) 
    		    {
    		        min = j;
    		    }
    		}
    		
    		Animal temp = animals.get(i);
    		animals.set(i, animals.get(min));
    		animals.set(min, temp);
    	}
    }
    
    public Animal searchAnimalByName(String name)
    {
    	for (int i = 0; i < animals.size(); i++)
    	{
    		if(animals.get(i).getName().equalsIgnoreCase(name))
    		{
    			return animals.get(i);
    		}
    	}
    	return null;
    }

  

}