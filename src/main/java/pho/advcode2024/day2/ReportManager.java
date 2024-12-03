package pho.advcode2024.day2;

import java.util.List;

public class ReportManager {

    private final List<String> input;

    public ReportManager(List<String> input) {
        this.input = input;
    }

    public long countSafeReports() {


        return 0;
    }

    enum LevelsType {
        INCREASING,
        DECREASING
    }

    record Report(List<Integer> levels) {
        public boolean isSafe() {
            for(int i = 0; i < levels.size() - 1; i++) {

            }

            return true;
        }
    }

}
