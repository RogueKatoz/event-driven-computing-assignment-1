import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;


public class RegexEngine {

    public static boolean debug;

    public static void printTransitionTable(String regex) {
        // print the transition table corresponding to the regex string
        // only if verbose mode is enabled
        if (debug == true) System.out.println("DEBUG: Printing transition table for regex: " + regex);
        return;
    }
    public static void main(String[] args) {
        
        // sets debug mode
        debug = Arrays.stream(args)
            .anyMatch(arg -> arg.equals("-d"));

        // sets verbose mode
        boolean verbose = Arrays.stream(args)
            .anyMatch(arg -> arg.equals("-v"));
        if (debug == true) System.out.println("DEBUG: Verbose mode: " + verbose);

    
        // parse the first input line and store as regex
        try (BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in))) {
            if (debug == true) System.out.println("DEBUG: BufferedReader created");
            String regex = inputReader.readLine();
            
            if (verbose == true) printTransitionTable(regex);
            System.out.println("ready");


        } catch (IOException e) {
            System.out.println("An error has occured:" + e.getMessage());
        }


        //todo: parse/evaluate subsequent lines

    }
}