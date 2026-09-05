import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class RegexEngine {

    private static boolean debug;

    public static void printTransitionTable(String regex) {
        // print the transition table corresponding to the regex string
        // only if verbose mode is enabled
        if (debug) System.out.println("DEBUG: Printing transition table for regex '" + regex + "'");
    }

    public static boolean evaluateInputString(String regex, String inputString) {
        // takes a regular expression and a second input string to compare against it
        // prints
        if (debug) System.out.println("DEBUG: Comparing string '" + inputString + "' against regular expression '" + regex + "'");
        return false;
    }
    public static void main(String[] args) {
        
        // sets debug mode
        debug = Arrays.stream(args)
            .anyMatch(arg -> arg.equals("-d"));

        // sets verbose mode
        boolean verbose = Arrays.stream(args)
            .anyMatch(arg -> arg.equals("-v"));
        if (debug) System.out.println("DEBUG: Verbose mode: " + verbose);

        // parse the first input line, store as regex, then print transition table if verbose
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            if (debug) System.out.println("DEBUG: BufferedReader created");
            String regex = reader.readLine();
            
            if (verbose) printTransitionTable(regex);
            System.out.println("ready");

            // Parse/evaluate subsequent lines
            String inputString;
            while ((inputString = reader.readLine()) != null) {
                System.out.println(evaluateInputString(regex, inputString));
            }

        } catch (IOException e) {
            System.err.println("An error has occurred:" + e.getMessage());
        }

    }
}

class EpsilonNFA {
    private Set<State> states;
    private State startingState;
    private State acceptingState;

    public EpsilonNFA(Set<State> states, State startingState, Set<State> acceptingStates) {
        this.states = states;
        this.startingState = startingState;
        this.acceptingState = acceptingState;
    }

    public void addState(State newState) {

    }

}
class State {
    private Map<Character,Set<State>> transitions;
    private Set<State> epsilonTransitions;

    public State() {
        transitions = new HashMap<>();
        epsilonTransitions = new HashSet<>();
    }

    public void addTransition(Character transitionChar, Set<State> transitionStates) {
        transitions.put(transitionChar, transitionStates);
    }

    public Set<State> getTransitions(Character transitionChar) {
        return transitions.get(transitionChar);
    }

    public void addEpsilonTransition(State transitionState) {
        epsilonTransitions.add(transitionState);
    }

    public Set<State> getEpsilonTransitions() {
        return epsilonTransitions;
    }

}