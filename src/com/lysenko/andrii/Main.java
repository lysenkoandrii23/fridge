package com.lysenko.andrii;

public class Main {
    public static long iterations = 0;
    public static int maxNode;

    public static void main(String[] args) {
        Fridge fridge = new Fridge(new int[][]{{1,-1,-1,-1},
                                               {1,-1,-1,-1},
                                               {-1,-1,-1,-1},
                                               {-1,-1,-1,-1}});
        maxNode = fridge.height * fridge.width;

        System.out.println("First state was:");
        System.out.println(fridge.toString());

        long start = System.currentTimeMillis();

        if (!solveFridge(fridge, 0, 1, 1)) {
            System.out.println("Solution not found");
        }
        System.out.println("Total iterations were: " + iterations + ", time " + (System.currentTimeMillis()-start)/1000. + " sec");
    }

    public static boolean solveFridge(Fridge fridge, int startNode, int currentDepth, int maxDepth) {
        iterations++;
        if (currentDepth >= 1 & currentDepth <= maxNode) {
            for (int node = startNode + 1; node <= maxNode; node++) {
                Fridge changeFridge = fridge.clone();
                int changeWidth = (node - 1) % fridge.width + 1;
                int changeHeight = (node - 1) / fridge.width + 1;

                changeFridge.move(changeHeight, changeWidth);
                if (solveFridge(changeFridge, node, currentDepth - 1, maxDepth)) {
                    System.out.println("State after moving node (" + changeHeight + "," + changeWidth + ")");
                    System.out.println(changeFridge.toString());
                    return true;
                }
            }
            if (currentDepth == maxDepth) {
                System.out.println("End of calculations with depth " + currentDepth +
                        " , total iterations were " + iterations + System.lineSeparator());
                return solveFridge(fridge, startNode, currentDepth + 1, maxDepth + 1);
            }
        }
        return fridge.isReady();
    }
}