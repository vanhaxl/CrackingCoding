package leetcode.eight51_eight99;

public class A_874_WalkingRobotSimulation {
    static int x = 0;
    static int y = 0;

    public static void main(String[] args) {
        int[] commands = {4,-1,4,-2,4};
        int[][] obstacles = {{2, 4}};
        System.out.println(robotSim(commands, obstacles));
    }

    public static int robotSim(int[] commands, int[][] obstacles) {
        x = 0; y = 0;
        // 0: north; 1: east; 2: south; 3: west
        int curDirection = 0; //direction[currentDirection] //index

        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -2) { //turn left 90
                curDirection = curDirection == 0 ? 3 : curDirection - 1;
            } else if (commands[i] == -1) { //turn right 90
                curDirection = curDirection == 3 ? 0 : curDirection + 1;
            } else if (commands[i] >= 1 && commands[i] <= 9) { //move forward
                move(commands[i], curDirection, obstacles);
            }
        }
        return x*x + y *y;
    }

    public static void move(int command, int curDirection, int[][] obstacles) {
        if (curDirection == 0) { //north
            int startY = y;
            int endY = y + command;
            int minEndY = endY + 1; //tinh obstacle, phai lui lai, ko duoc toi obstacle
            for (int[] obstacle : obstacles) {
                if (obstacle[0] == x && obstacle[1] > startY && obstacle[1] <= endY) {
                    minEndY = Math.min(minEndY, obstacle[1]);
                }
            }
            minEndY--;
            y = minEndY;
        } else if (curDirection == 1) { //east, tang x
            int startX = x;
            int endX = x + command;
            int minEndX = endX + 1;
            for (int[] obstacle : obstacles) {
                if (obstacle[1] == y && obstacle[0] > startX && obstacle[0] <= endX) {
                    minEndX = Math.min(minEndX, obstacle[0]);
                }
            }
            minEndX--;
            x = minEndX;
        } else if (curDirection == 2) { // south , giam y
            int startY = y;
            int endY = y - command;
            int maxEndY = endY - 1;
            for (int[] obstacle : obstacles) {
                if (obstacle[0] == x && obstacle[1] < startY && obstacle[1] >= endY) {
                    maxEndY = Math.max(maxEndY, obstacle[1]);
                }
            }
            maxEndY++;
            y = maxEndY;
        } else if (curDirection == 3) { // west , giam x
            int startX = x;
            int endX = x - command;
            int maxEndX = endX - 1;
            for (int[] obstacle : obstacles) {
                if (obstacle[1] == y && obstacle[0] < startX && obstacle[0] >= endX) {
                    maxEndX = Math.max(maxEndX, obstacle[0]);
                }
            }
            maxEndX++;
            x = maxEndX;
        }
    }
}

/*
A robot on an infinite grid starts at point (0, 0) and faces north.
The robot can receive one of three possible types of commands:

-2: turn left 90 degrees
-1: turn right 90 degrees
1 <= x <= 9: move forward x units
Some of the grid squares are obstacles.

The i-th obstacle is at grid point (obstacles[i][0], obstacles[i][1])

If the robot would try to move onto them, the robot stays on the previous
grid square instead (but still continues following the rest of the route.)

Return the square of the maximum Euclidean distance that the robot will be from the origin.



Example 1:

Input: commands = [4,-1,3], obstacles = []
Output: 25
Explanation: robot will go to (3, 4)
Example 2:

Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
Output: 65
Explanation: robot will be stuck at (1, 4) before turning left and going to (1, 8)
 */









