package pho.advcode2024.day01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LibraryTest {

    private Library library;

    @BeforeEach
    void setup() throws IOException {
        library = new Library("examples/day01.txt");
    }

    @Test
    void should_calculate_distance_score() {
        long actual = library.answerOne();
        long expected = 11;

        assertEquals(actual, expected);
    }


    @Test
    void should_calculate_similarity_score() {
        long actual = library.answerTwo();
        long expected = 31;

        assertEquals(actual, expected);
    }
}