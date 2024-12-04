package pho.advcode2024.day01;

import pho.advcode2024.engine.Challenge;
import pho.advcode2024.engine.ChallengeLabels;

import java.io.IOException;
import java.util.List;

public class Library extends Challenge {

    public static final int LEFT = 0;
    public static final int RIGHT = 1;

    private final List<Integer> leftList;
    private final List<Integer> rightList;

    public Library(String fileName) throws IOException {
        super(fileName, new ChallengeLabels(
            1,
            "Library Lists",
            "Distance Score",
            "Similarity Score"
        ));

        List<String[]> lists = extractMainList();

        leftList = extractSideList(lists, LEFT);
        rightList = extractSideList(lists, RIGHT);
    }

    @Override
    public long answerOne() {
        long differenceScore = 0;
        for (int i = 0; i < leftList.size(); i++) {
            IdPair idPair = new IdPair(leftList.get(i), rightList.get(i));
            differenceScore += idPair.difference();
        }

        return differenceScore;
    }

    @Override
    public long answerTwo() {
        long similarities = 0;

        for (Integer leftNumber : leftList) {
            long occurrencies = rightList.stream().filter(leftNumber::equals).count();
            similarities += leftNumber * occurrencies;
        }

        return similarities;
    }

    private static List<Integer> extractSideList(List<String[]> lists, int side) {
        return lists.stream().map(ids -> Integer.parseInt(ids[side])).sorted().toList();
    }

    private List<String[]> extractMainList() {
        return getInput().stream().map(example -> example.split(" {3}")).toList();
    }

    private record IdPair(int id1, int id2) {
        public long difference() {
            return (id1 > id2) ? id1 - id2 : id2 - id1;
        }
    }
}
