package pho.advcode2024.day03;

import pho.advcode2024.engine.Challenge;
import pho.advcode2024.engine.ChallengeLabels;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CorruptedComputer extends Challenge {

    private static final Pattern MUL_FUNCTION_PATTERN = Pattern.compile("mul\\((\\d*),(\\d*)\\)");

    public CorruptedComputer(String fileName) throws IOException {
        super(fileName, new ChallengeLabels(
            3,
            "Mull it over",
            "Adding mul(x,y) results",
            "Adding mul(x,y) results with do() and don't"
        ));
    }

    @Override
    public long answerOne() {
        long productSum = 0;

        for (String line : getInput()) {
            Matcher operations = MUL_FUNCTION_PATTERN.matcher(line);

            while (operations.find()) {
                productSum += Long.parseLong(operations.group(1)) * Long.parseLong(operations.group(2));
            }
        }

        return productSum;
    }

    @Override
    public long answerTwo() {
        return 0;
    }
}
