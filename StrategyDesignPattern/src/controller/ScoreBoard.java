package controller;

public class ScoreBoard {
    public ScoreAlgoBase algoBase;
    public void showScore(int taps, int multipliers){
        System.out.println(algoBase.calculateScore(taps,multipliers));
    }
}
