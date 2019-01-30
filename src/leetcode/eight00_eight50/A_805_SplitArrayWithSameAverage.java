package leetcode.eight00_eight50;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Point {
    int x;
    int y;

    public Point() {
        x = 0;
        y = 0;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class A_805_SplitArrayWithSameAverage {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(splitArraySameAverage(nums));
    }

    public static boolean splitArraySameAverage(int[] A) {
        int N = A.length;
        int S = 0;
        for (int x : A) S += x;
        if (N == 1) return false;

        int g = gcd(S, N);
        Point mu = new Point(-(S / g), N / g);
        // A[i] -> fracAdd(A[i], mu)
        List<Point> A2 = new ArrayList();
        for (int x : A)
            A2.add(fracAdd(new Point(x, 1), mu));

        Set<Point> left = new HashSet();
        left.add(A2.get(0));
        for (int i = 1; i < N / 2; ++i) {
            Set<Point> left2 = new HashSet();
            Point z = A2.get(i);
            left2.add(z);
            for (Point p : left) {
                left2.add(p);
                left2.add(fracAdd(p, z));
            }
            left = left2;
        }

        if (left.contains(new Point(0, 1))) return true;

        Set<Point> right = new HashSet();
        right.add(A2.get(N - 1));
        for (int i = N / 2; i < N - 1; ++i) {
            Set<Point> right2 = new HashSet();
            Point z = A2.get(i);
            right2.add(z);
            for (Point p : right) {
                right2.add(p);
                right2.add(fracAdd(p, z));
            }
            right = right2;
        }

        if (right.contains(new Point(0, 1))) return true;

        Point sleft = new Point(0, 1);
        for (int i = 0; i < N / 2; ++i)
            sleft = fracAdd(sleft, A2.get(i));

        Point sright = new Point(0, 1);
        for (int i = N / 2; i < N; ++i)
            sright = fracAdd(sright, A2.get(i));

        for (Point ha : left) {
            Point ha2 = new Point(-ha.x, ha.y);
            if (right.contains(ha2) && (!ha.equals(sleft) || !ha2.equals(sright)))
                return true;
        }
        return false;
    }

    public static Point fracAdd(Point A, Point B) {
        int numer = A.x * B.y + B.x * A.y;
        int denom = A.y * B.y;
        int g = gcd(numer, denom);
        numer /= g;
        denom /= g;

        if (denom < 0) {
            numer *= -1;
            denom *= -1;
        }

        return new Point(numer, denom);
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}

/*
Example :
Input:
[1,2,3,4,5,6,7,8]
Output: true
Explanation: We can split the array into [1,4,5,8] and [2,3,6,7], and both of them have the average of 4.5

brute force:
split all possible, calculate average, compare

First, let's get a sense of the condition that average(B) = average(C), where B, C are defined in the problem statement.

Say A (the input array) has N elements which sum to S, and B (one of the splitting sets) has K elements which sum to X. Then the equation for average(B) = average(C) becomes \frac{X}{K} = \frac{S-X}{N-K}
K
X
​
 =
N−K
S−X
​
 . This reduces to X(N-K) = (S-X)KX(N−K)=(S−X)K which is \frac{X}{K} = \frac{S}{N}
K
X
​
 =
N
S
​
 . That is, average(B) = average(A).

Now, we could delete average(A) from each element A[i] without changing our choice for B. (A[i] -= mu, where mu = average(A)). This means we just want to choose a set B that sums to 0.

Trying all 2^N2
N
  sets is still too many choices, so we will create sets of sums left, right of the approximately 2^{N/2}2
N/2
  choices on the left and on the right separately. (That is, left is a set of sums of every powerset in the first half of A, and right is the set of sums of every powerset in the second half of A). Then, it is true if we find 00 in these powersets, or if two sums in different halves cancel out (-x in right for x in left), except for one minor detail below.

Care must be taken that we do not specify sets that would make the original B or C empty. If sleft = A[0] + A[1] + ... + A[N/2 - 1], and sright = A[N/2] + ... + A[N-1], (where A[i] was transformed to the new A[i] - average(A)) then we cannot choose both (sleft, sright). This is correct because if for example sleft was a sum reached by a strictly smaller powerset than {A[0], A[1], ..., A[N/2 - 1]}, then the difference between these sets would be non-empty and have sum 0.


 */
