package org.howard.edu.lsp.midterm.question3;

import java.util.HashMap;
import java.util.Map;

/**
 * Electronic voting machine.
 */
public class VotingMachine {
    private Map<String, Integer> votes;

    /**
     * Constructs a new VotingMachine
     */
    public VotingMachine() {
        this.votes = new HashMap<>();
    }

    /**
     * Adds a candidate 
     * @param candidate The name of the candidate to be added.
     */
    public void addCandidate(String candidate) {
        if (!votes.containsKey(candidate)) {
            votes.put(candidate, 0);
        }
    }

    /**
     * Casts a vote for a candidate
     * @param candidate The name of the candidate 
     * @return true if the vote was successfully cast, false if the candidate don't exist.
     */
    public boolean castVote(String candidate) {
        if (votes.containsKey(candidate)) {
            votes.put(candidate, votes.get(candidate) + 1);
            return true;
        }
        return false;
    }

    /**
     * winner calculator - highest vote count wins
     * @return The name of the winning candidate.
     */
    public String getWinner() {
        String winner = null;
        int maxVotes = 0;
        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }
        return winner + " WINS with " + maxVotes + " votes!!";
    }
}
