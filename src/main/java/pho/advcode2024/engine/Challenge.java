package pho.advcode2024.engine;

import lombok.Getter;
import pho.advcode2024.core.ContentLoader;

import java.io.IOException;
import java.util.List;

@Getter
public abstract class Challenge {

    private final List<String> input;
    private final ChallengeLabels labels;

    public Challenge(String fileName, ChallengeLabels labels) throws IOException {
        this.input = ContentLoader.load(fileName);
        this.labels = labels;
    }

    public abstract long answerOne();

    public abstract long answerTwo();
}
