package pho.advcode2024.day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReportManagerTest {

    private ReportManager reportManager;

    @BeforeEach
    void setup() throws IOException {
        reportManager = new ReportManager("examples/day02.txt");
    }

    @Test
    void should_check_pair_none() {
        CheckedPair actual = reportManager.checkPair(4, 4);
        CheckedPair expected = new CheckedPair(4, 4, LevelDirection.NONE, 0);

        assertThat(actual, equalTo(expected));
    }

    @Test
    void should_check_pair_decreasing() {
        CheckedPair actual = reportManager.checkPair(4, 1);
        CheckedPair expected = new CheckedPair(4, 1, LevelDirection.DECREASING, 3);

        assertThat(actual, equalTo(expected));
    }


    @Test
    void should_check_pair_increasing() {
        CheckedPair actual = reportManager.checkPair(1, 4);
        CheckedPair expected = new CheckedPair(1, 4, LevelDirection.INCREASING, 3);

        assertThat(actual, equalTo(expected));
    }

    @Test
    void should_return_safe_report_decreasing() {
        assertTrue(reportManager.isSafe(List.of(7, 6, 4, 2, 1)));
    }

    @Test
    void should_return_safe_report_increasing() {
        assertTrue(reportManager.isSafe(List.of(1, 3, 6, 7, 9)));
    }

    @Test
    void should_return_unsafe_report() {
        assertFalse(reportManager.isSafe(List.of(1, 2, 7, 8, 9)));
    }

    @Test
    void should_return_unsafe_report_increase_decrease() {
        assertFalse(reportManager.isSafe(List.of(1, 3, 2, 4, 5)));
    }

    @Test
    void should_return_unsafe_report_same_items() {
        assertFalse(reportManager.isSafe(List.of(8, 6, 4, 4, 1)));
    }

    @Test
    void should_count_safe_reports() {
        long actual = reportManager.answerOne();
        long expected = 2;

        assertThat(actual, equalTo(expected));
    }

}