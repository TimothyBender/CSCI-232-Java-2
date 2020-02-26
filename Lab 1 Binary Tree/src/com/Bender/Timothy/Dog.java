package com.Bender.Timothy;

@SuppressWarnings("ALL")
public class Dog implements Comparable {

    private String breed;
    private String color;
    private String name;

    public Dog(String b, String c, String n){
        this.breed = b;
        this.color = c;
        this.name = n;
    }

    public int compareTo(Object dog){
        //compare the breed, then the color then the name
        Dog otherDog = (Dog)dog;

        if (breed.compareTo(otherDog.breed) < 0)
        {
            return -1;
        }
        else if (breed.compareTo(otherDog.breed) == 0)
        {
            if (color.compareTo(otherDog.color) < 0)
            {
                return -1;
            }
            else if (color.compareTo(otherDog.color) == 0)
            {
                if (name.compareTo(otherDog.name) < 0)
                {
                    return -1;
                }
                else if (name.compareTo(otherDog.name) == 0)
                {
                    return 0;
                }
                else
                {
                    return 1;
                }
            } else
            {
                return 1;
            }

        }
        else
        {
            return 1;
        }
    }
    public String toString(){

        return this.name + " " + this.color + " " + this.breed;
    }
    public String getBreed(){return this.breed;}
    public String getColor(){return this.color;}
    public String getName(){return this.name;}
}