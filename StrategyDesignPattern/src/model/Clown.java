package model;

import controller.ScoreAlgoBase;

public class Clown extends ScoreAlgoBase {

    @Override
    public int calculateScore(int taps, int multiplier) {
        return taps*multiplier - 30;
    }
}
