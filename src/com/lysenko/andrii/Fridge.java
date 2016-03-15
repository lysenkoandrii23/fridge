package com.lysenko.andrii;

public class Fridge {
    public int width;
    public int height;
    private int[][] fridge;

    public Fridge(int[][] state) {
        this.width = state[0].length;
        this.height = state.length;
        fridge = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                fridge[i][j] = state[i][j];
            }
        }
    }

    public Fridge clone() {
        Fridge newContainer = new Fridge(fridge);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                newContainer.fridge[i][j] = fridge[i][j];
            }
        }
        return newContainer;
    }

    public void move(int changeHeight, int changeWidth) {
        for (int i = 0; i < height; i++) {
            fridge[i][changeWidth - 1] *= -1;
        }
        for (int j = 0; j < width; j++) {
            fridge[changeHeight - 1][j] *= -1;
        }
        fridge[changeHeight - 1][changeWidth - 1] *= -1;
    }

    public boolean isReady() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (fridge[i][j] != -1) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                stringBuilder.append((fridge[i][j] > 0 ? "+" : ""));
                stringBuilder.append(fridge[i][j]);
                stringBuilder.append(" ");
            }
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}