package leetcode.one00_one50;

public class A_134_GasStation {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

//        int[] gas = {2, 3, 4};
//        int[] cost = {3, 4, 3};

        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        if (len == 0) return -1;
        int total = 0, sum = 0;
        int result = 0;
        for (int i = 0; i < len; i++) {
            sum += gas[i] - cost[i];
            if (sum < 0) {
                total += sum;
                sum = 0;
                result = i + 1;
            }
        }
        total += sum;
        return total < 0 ? -1 : result;
    }
}

// y tuong bai nay la: tinh total tank neu sum< 0, save vao total, and possible result will be next index.
// calculate sum until finish array, it will have a remain or more lack, plus with total
//if total < 0, it mean not enough gas, no solution, return -1, else return result
