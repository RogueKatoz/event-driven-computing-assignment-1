import java.util.Arrays;

public class RegexEngine {

    public static void main(String[] args) {
        
        // sets debug mode
        boolean debug = Arrays.stream(args)
            .anyMatch(arg -> arg.equals("-d"));

        // sets verbose mode
        boolean verbose = Arrays.stream(args)
            .anyMatch(arg -> arg.equals("-v"));
        if (debug == true) System.out.println("Verbose mode: " + verbose);

    
        //todo: parse the first input line and store as regex

        //todo: parse/evaluate subsequent lines

    }
}