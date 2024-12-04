package pho.advcode2024.day02;

import pho.advcode2024.engine.Challenge;
import pho.advcode2024.engine.ChallengeLabels;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class ReportManager extends Challenge {

    private static final Integer ALLOWED_DIFFERENCE = 3;

    public ReportManager(String fileName) throws IOException {
        super(fileName, new ChallengeLabels(
            2,
            "Report Manager",
            "Safe Reports",
            "Safe Reports with Dampener"
        ));
    }

    @Override
    public long answerOne() {
        return getInput()
            .stream()
            .map(line -> line.split(" "))
            .map(convertToIntList())
            .map(this::isSafe)
            .filter(x -> x)
            .count();
    }

    @Override
    public long answerTwo() {
        return 0;
    }

    protected boolean isSafe(List<Integer> report) {
        CheckedPair oldCheckedPair = new CheckedPair(0, 0, LevelDirection.UNKNOWN, 0);

        for (int i = 0; i < report.size() - 1; i++) {
            CheckedPair checkedPair = checkPair(report.get(i), report.get(i + 1));

            if (checkedPair.direction().equals(LevelDirection.NONE)) return false;
            if (checkedPair.difference() > ALLOWED_DIFFERENCE) return false;
            if (!oldCheckedPair.direction().equals(LevelDirection.UNKNOWN)
                && !checkedPair.direction().equals(oldCheckedPair.direction())) return false;

            oldCheckedPair = checkedPair;
        }

        return true;
    }

    protected CheckedPair checkPair(int levelId1, int levelId2) {
        int difference = (levelId1 > levelId2) ? levelId1 - levelId2 : levelId2 - levelId1;

        if (difference == 0) return new CheckedPair(levelId1, levelId2, LevelDirection.NONE, difference);
        LevelDirection direction = (levelId1 > levelId2) ? LevelDirection.DECREASING : LevelDirection.INCREASING;

        return new CheckedPair(levelId1, levelId2, direction, difference);
    }

    protected Function<String[], List<Integer>> convertToIntList() {
        return items -> Arrays.stream(items).map(Integer::parseInt).toList();
    }
}
