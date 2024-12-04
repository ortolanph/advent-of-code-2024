package pho.advcode2024;

import pho.advcode2024.day03.CorruptedComputer;
import pho.advcode2024.engine.Challenge;

import java.io.IOException;

public class Answers {

    public static void main(String[] args) throws IOException {
        // Day 2
        Challenge challenge = new CorruptedComputer("inputs/day03.txt");

        long answerOne = challenge.answerOne();
        long answerTwo = challenge.answerTwo();

        System.out.printf("""
                Challenge %d - %s
                
                %s
                First part...: %d
                %s
                Second part..: %d
                
                ==============================
                """,
            challenge.getLabels().challengeNumber(),
            challenge.getLabels().challenge(),
            challenge.getLabels().part1(),
            answerOne,
            challenge.getLabels().part2(),
            answerTwo);
    }

}
