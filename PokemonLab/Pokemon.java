package PokemonLab;

public class Pokemon {
    private String name, type;
    private int level;
    
    // constructors
    public Pokemon(String name, String type, int level){
        this.name = name;
        this.type = type;
        this.level = level;
    }

    public Pokemon(String name, String type){
        this.name = name;
        this.type = type;
        level = 1;
    }

    // setters
    public void setName(String name){
        this.name = name;
    }
    public void setType(String type){
        this.type = type;
    }
    public void setLevel(int level){
        this.level = level;
    }

    // getters 

    public int getLevel(){
        return level;
    }
    public String getName(){
        return name;
    }
    public String getType(){
        return type;
    }

    // To String

    public String toString(){
        return "Pokemon name: " + name + " | Type: " + type + " | Level: " + level;
    }
}
