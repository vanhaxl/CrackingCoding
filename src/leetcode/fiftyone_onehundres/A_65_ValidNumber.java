package leetcode.fiftyone_onehundres;

public class A_65_ValidNumber {
    public static void main(String[] args) {
        String s = "53.5e93";
        System.out.println(isNumber(s));
    }

    public static boolean isNumber(String s) {
        s = s.trim();

        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        boolean numberAfterE = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                numberSeen = true;
                numberAfterE = true;
            } else if (c == '.') {
                if (eSeen || pointSeen) {// can't have 2 '.' or already e
                    return false;
                }
                pointSeen = true;
            } else if (c == 'e') {
                if (eSeen || !numberSeen) { // can't have 2 e, or not found any number yet
                    return false;
                }
                numberAfterE = false; // reset number after e
                eSeen = true; //
            } else if (c == '-' || c == '+') {
                if (i != 0 && s.charAt(i - 1) != 'e') { // sign + or - can only appear in 0 or after e
                    return false;
                }
            } else {
                return false;
            }
        }

        return numberSeen && numberAfterE;
    }
}
/*
All we need is to have a couple of flags so we can process the string in linear time:
We start with trimming.

If we see [0-9] we reset the number flags.
We can only see . if we didn't see e or ..
We can only see e if we didn't see e but we did see a number. We reset numberAfterE flag.
We can only see + and - in the beginning and after an e
any other character break the validation.
At the and it is only valid if there was at least 1 number and if we did see an e then a number after it as well.

So basically the number should match this regular expression:

[-+]?(([0-9]+(.[0-9]*)?)|.[0-9]+)(e[-+]?[0-9]+)?
 */
