package pho.advcode2024.day03;

import pho.advcode2024.engine.Challenge;
import pho.advcode2024.engine.ChallengeLabels;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CorruptedComputer extends Challenge {

    private static final Pattern MUL_FUNCTION_PATTERN = Pattern.compile("mul\\((\\d*),(\\d*)\\)");
    private static final Pattern PARAMETER_PATTERN = Pattern.compile("(\\d+),(\\d+)");
    private static final Pattern CODE_PARSING_PATTERN = Pattern.compile("(?:do\\(\\)|don't\\(\\)|mul\\(\\d+,\\d+\\))");

    private static final String DO_COMMAND = "do";
    private static final String DONT_COMMAND = "don't";
    private static final String MUL_COMMAND = "mul";

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
        long productSum = 0;
        boolean sumAllowed = true;

        for (String line : getInput()) {
            Matcher operations = CODE_PARSING_PATTERN.matcher(line);

            while (operations.find()) {
                String operation = operations.group();

                System.out.println(operation);

                if (operation.startsWith(DO_COMMAND)) sumAllowed = true;
                if (operation.startsWith(DONT_COMMAND)) sumAllowed = false;

                if (operation.startsWith(MUL_COMMAND)) {
                    if(sumAllowed) {
                        Matcher parameters = PARAMETER_PATTERN.matcher(operation);

                        if(parameters.find()) productSum += Long.parseLong(parameters.group(1)) * Long.parseLong(parameters.group(2));
                    }
                }
            }
        }

        return productSum;
    }
}
