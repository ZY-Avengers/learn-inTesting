//package github.meifans.inTesting.leetcode.abilitycode;
//
///**
// * @author pengfei.zhao
// */
//public class FindTheClosestPalindrome {
//    public String nearestPalindromic(String n) {
//        char[] chars = n.toCharArray();
//        int mid = n.length() / 2;
//        for (int i = 0; i < mid; i++) {
//            chars[n.length() - 1 - i] = chars[i];
//        }
//
//        int i = Integer.parseInt(new String(chars));
//        int base = Integer.parseInt(n);
//
//        int j, h;
//        if ((n.length() & 1) == 1) {
//            chars[mid] = Character.forDigit(chars[mid] - '0' + 1, 10);
//            j = Integer.parseInt(new String(chars));
//            chars[mid = ]
//        }
//
//    }
//}
