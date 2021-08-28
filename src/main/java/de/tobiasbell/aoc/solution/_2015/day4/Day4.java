package de.tobiasbell.aoc.solution._2015.day4;

import org.apache.commons.codec.digest.DigestUtils;

public class Day4 {
    public static int solve1(String key) {
        for (int i = 1; ; i++) {
            final String md5Hex = DigestUtils.md5Hex(key + i);
            if (startsWith5Zeroes(md5Hex)) {
                return i;
            }
        }
    }

    public static int solve2(String key) {
        for (int i = 1; ; i++) {
            final String md5Hex = DigestUtils.md5Hex(key + i);
            if (startsWith6Zeroes(md5Hex)) {
                return i;
            }
        }
    }

    private static boolean startsWith6Zeroes(String s) {
        return s.startsWith("000000");
    }


    private static boolean startsWith5Zeroes(String s) {
        return s.startsWith("00000");
    }
}
