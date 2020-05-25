package domain;

import util.RandomBooleanGenerator;

public class RandomCreatorStrategy implements LadderCreatorStrategy {
    @Override
    public boolean generate() {
        return RandomBooleanGenerator.generate();
    }
}
