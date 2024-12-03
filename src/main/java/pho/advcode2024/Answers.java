package pho.advcode2024;

import pho.advcode2024.core.ContentLoader;
import pho.advcode2024.day1.Library;

import java.io.IOException;

public class Answers {

    public static void main(String[] args) throws IOException {
        // Day 1
        Library library = new Library(ContentLoader.load("inputs/day01.txt"));

        long libraryPart1 = library.distanceScore();
        long livraryPart2 = library.similarityScore();

        System.out.printf("""
            Challenge 1:
            
            First part...: %d
            Second part..: %d
            
            ==============================
            """, libraryPart1, livraryPart2);
    }

}
