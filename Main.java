package main;

import GameTheory.Strategies.*;
import GameTheory.Tournament;


import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
       
        Strategy PAPER = new AlwaysPaper();
        Strategy  ROCK = new AlwaysRock();
        Strategy  SCISSORS = new AlwaysScissors();

        // Create TitForTat strategy
        Strategy titForTat = new TitForTat();
        
        // Create TitForTatTat startefy
        Strategy titForTatTat = new TitForTatTat();
        
        // Create Grudger strategy
        Strategy grudger = new Grudger();
        
        // Create Simpleton startefy
        Strategy simpleton = new Simpleton();
        
        
        

        // Create a list of all strategies
        List<Strategy> allStrategies = new ArrayList<>(Arrays.asList(
                ROCK, PAPER, SCISSORS,
                titForTat, titForTatTat,
                grudger, simpleton
                
        ));

        // Create a Tournament for all strategies
        Tournament tournament = new Tournament(allStrategies);

        // Specify the number of rounds for each iteration
        int numRounds = 10;

        // Run the tournament for all strategies
        System.out.println("Results:");
        for (int iteration = 0; iteration < 5; iteration++) {
            

            // Execute the tournament rounds
            HashMap<Strategy, Integer> results = tournament.executeTournamentRounds(numRounds);

            System.out.println("Iteration " + iteration + " Results:");
            for (Map.Entry<Strategy, Integer> entry : results.entrySet()) {
                System.out.println(entry.getKey().getStrategyName() + ": " + entry.getValue() + " points");
                System.out.println(" Player 1 score is :" + entry.getKey().getPlayer1Score());
                System.out.println(" Player 2 score is :" + entry.getKey().getPlayer2Score());
                
            }
            System.out.println("-----------------------------------------------------------------------------------");
        }

        
    }

    
}
