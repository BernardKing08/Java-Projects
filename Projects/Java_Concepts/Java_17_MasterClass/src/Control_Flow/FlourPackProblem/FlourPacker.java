package Control_Flow.FlourPackProblem;

public class FlourPacker {
    public static boolean canPack(int bigCount, int smallCount, int goal) {
        
        if (bigCount < 0 || smallCount < 0 || goal < 0) {
            return false;
        }

        int totalKilos = bigCount * 5 + smallCount;
        if (totalKilos < goal) {
            return false;
        }

        int bigBagsToUse = Math.min(goal / 5, bigCount);

        int remainingGoal = goal - (bigBagsToUse * 5);

        return remainingGoal <= smallCount;
    }
}

