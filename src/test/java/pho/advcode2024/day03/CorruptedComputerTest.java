package pho.advcode2024.day03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class CorruptedComputerTest {

    private CorruptedComputer corruptedComputer;

    @BeforeEach
    void setup() throws IOException {
        corruptedComputer = new CorruptedComputer("examples/day03.txt");
    }

    @Test
    void should_calculate_sum_multiplications() {
        long actual = corruptedComputer.answerOne();
        long expected = 161;

        assertThat(actual, equalTo(expected));
    }

}