import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RegexEngine_Test {

    // ---------------------
    // | STATE CLASS TESTS |
    // ---------------------

    @Test 
    public void retrieveStateId() {
        // create a state and successfully retrieve its ID.
        State q0 = new State(0);
        
        assertEquals(0, q0.getId());
    }

    @Test
    public void retrieveStateTransition() {
        // create two states with a transition between them and successfully retrieve that transition

        State q0 = new State(0);
        State q1 = new State(1);

        q0.addTransition('a', Set.of(q1));

        assertEquals(true, q0.getTransitions('a').contains(q1));
    }

    @Test
    public void retrieveMultipleStateTransitions() {
        // create three states and retrieve both transitions with the same character
        State q0 = new State(0);
        State q1 = new State(1);
        State q2 = new State(2);

        q0.addTransition('a', Set.of(q1, q2));

        assertEquals(true, q0.getTransitions('a').containsAll(Set.of(q1, q2)));
    }

    @Test
    public void retrieveEpsilonStateTransition() {
        // create two States with an epsilon transition between them and successfully retrieve that transition

        State q0 = new State(0);
        State q1 = new State(1);

        q0.addEpsilonTransition(q1);

        assertEquals(true, q0.getEpsilonTransitions().contains(q1));
    }

    @Test
    public void retrieveMultipleEpsilonStateTransitions() {
        // create three states and successfully retrieve both epsilon transitions
        State q0 = new State(0);
        State q1 = new State(1);
        State q2 = new State(2);

        q0.addEpsilonTransition(q1);
        q0.addEpsilonTransition(q2);

        assertEquals(true, q0.getEpsilonTransitions().containsAll(Set.of(q1,q2)));
    }

    @Test 
    public void getInvalidStateTransition() {
        // create state and attempt to make transition that does not exist. Should return empty set.
        State q0 = new State(0);
        q0.addTransition('a', Set.of(q0));

        assertTrue(q0.getTransitions('b').isEmpty());
    }

}
