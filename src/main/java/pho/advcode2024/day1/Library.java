package pho.advcode2024.day1;

import java.util.ArrayList;
import java.util.List;

public class Library {

    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    private final List<String> input;

    private List<Integer> leftList = new ArrayList<>();
    private List<Integer> rightList = new ArrayList<>();

    public Library(List<String> input) {
        this.input = input;
        List<String[]> lists = extractMainList();

        leftList = extractSideList(lists, LEFT);
        rightList = extractSideList(lists, RIGHT);
    }

    public long distanceScore() {
        long differenceScore = 0;
        for (int i = 0; i < leftList.size(); i++) {
            IdPair idPair = new IdPair(leftList.get(i), rightList.get(i));
            differenceScore += idPair.difference();
        }

        return differenceScore;
    }

    public long similarityScore() {
        long similarities = 0;

        for(Integer leftNumber : leftList) {
            long occurrencies = rightList.stream().filter(leftNumber::equals).count();
            similarities += leftNumber * occurrencies;
        }

        return similarities;
    }

    private static List<Integer> extractSideList(List<String[]> lists, int side) {
        return lists.stream().map(ids -> Integer.parseInt(ids[side])).sorted().toList();
    }

    private List<String[]> extractMainList() {
        return input.stream().map(example -> example.split(" {3}")).toList();
    }

    private record IdPair(int id1, int id2) {
        public long difference() {
            return (id1 > id2) ? id1 - id2 : id2 - id1;
        }
    }
}
