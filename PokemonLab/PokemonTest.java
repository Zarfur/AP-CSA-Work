package PokemonLab;

// Sorry Ms. Qiu! 
// "submited late" due to issues with codeHS (codeHS not saving!)
public class PokemonTest {
    public static void main(String[] args){
        Pokemon p1 = new Pokemon("Pikachu", "Electric", 14);
        Pokemon p2 = new Pokemon("Charmander", "fire");

        System.out.println(p1);
        System.out.println(p2);

        System.out.println("Name of p1: "+ p1.getName());
        p2.setLevel(7);
        System.out.println("Updated p1: " + p2);
    }

}
