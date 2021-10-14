package model;

import controller.ScoreAlgoBase;

public class Baloon extends ScoreAlgoBase {

    @Override
    public int calculateScore(int taps, int multiplier) {
        return taps*multiplier -20;
    }
}
