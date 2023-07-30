import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class PokemonGame {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //prompt
        System.out.println("Hello there pokemon trainer!");
        System.out.println("Want to catch pokemons now? .....");
        String answer = scan.nextLine();
        if (answer.equals("yes")) {
            System.out.println("Alright! let's proceed");
        } else {
            System.out.println("Alright then take care ciao!");
            return;
        }

        //Loading
        System.out.println("finding wild pokemons..");
        System.out.println(".....");
        System.out.println(".........");

        //My list of pokemons
        String[] pokemon = {"Rayquaza", "Charizard", "Squirtle", "Ivysaur", "Gyarados", "Eevee", "Pikachu", "Bulbasaur", "Charmander", "Mewtwo", "Snorlax"};
        //this is where I willl store the pokemons I've caught
        ArrayList<String> caughtPokemons = new ArrayList<>();
        // Remaining Pokemon to be caught
        List<String> remainingPokemons = new ArrayList<>(Arrays.asList(pokemon));

        //now we proceed to catching Pokémon!
        while (true) {
            int randomIndex = ThreadLocalRandom.current().nextInt(pokemon.length);
            String randomPokemon = pokemon[randomIndex];
            System.out.println("A Wild " + randomPokemon + " Appeared!");
            System.out.println("Do you want to catch this pokemon?");
            String answer2 = scan.nextLine();
            if (answer2.equals("yes")) {
                caughtPokemons.add(randomPokemon);
                System.out.println(randomPokemon + " Caught!");

                remainingPokemons.remove(randomPokemon);
                pokemon = remainingPokemons.toArray(new String[remainingPokemons.size()]);
                System.out.println("Remaining Pokemon:");
                for (String remainingPokemon : remainingPokemons) {
                    System.out.println(remainingPokemon);
                }
                System.out.println("Do you want to catch more?");
                String answer3 = scan.nextLine();
                if (!answer3.equals("yes")) {
                    break;
                }

            } else if (answer2.equals("no")) {
                System.out.println("Alright finding another pokemon");
            }
        }
        System.out.println("Here are the pokemons you've caught!" + caughtPokemons);

//        for (String pokemons : caughtPokemons) {
//            System.out.println("here are the Pokémons you've catched! " + pokemons.);
//        }

    }
}
