package pho.advcode2024.day03;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class CorruptedComputerTest {

    private CorruptedComputer corruptedComputer;

    @Test
    void should_calculate_sum_multiplications() throws IOException {
        corruptedComputer = new CorruptedComputer("examples/day03a.txt");
        long actual = corruptedComputer.answerOne();
        long expected = 161;

        assertThat(actual, equalTo(expected));
    }

    @Test
    void should_calculate_sum_multiplications_with_do_and_dont() throws IOException {
        corruptedComputer = new CorruptedComputer("examples/day03b.txt");
        long actual = corruptedComputer.answerTwo();
        long expected = 48;

        assertThat(actual, equalTo(expected));
    }
}