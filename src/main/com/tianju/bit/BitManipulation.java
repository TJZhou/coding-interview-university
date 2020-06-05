package com.tianju.bit;

/**
 * Tianju Zhou
 * Jun 4, 2020
 */
public class BitManipulation {

    public int setBit(int num, int pos) {
        int mask = 1 << pos;
        return num | mask;
    }

    public int clearBit(int num, int pos) {
        int mask = 1 << pos;
        return num & ~mask;
    }

    public int flipBit(int num, int pos) {
        int mask = 1 << pos;
        return num ^ mask;
    }

    public boolean isBitSet(int num, int pos) {
        int shifted = num >>> pos;
        return (shifted & 1) == 1;
    }

    public boolean isPowerOfTwo(int num) {
        // num = 0000 1000
        // num - 1 = 0000 0111
        return (num & num - 1) == 0;
    }


    public int countBits1(int num) {
        int count = 0;
        while(num != 0) {
            count += num & 1;
            num >>>= 1;
        }
        return count;
    }

    public int countBits2(int num) {
        int count = 0;
        while(num != 0) {
            count++;
            num &= (num - 1);
        }
        return count;
    }

    public int countBits3(int num) {
        num = num - ((num >>> 1) & 0x55555555);
        num = (num & 0x33333333) + ((num >>> 2) & 0x33333333);
        return (((num + (num >>> 4)) & 0x0F0F0F0F) * 0x01010101) >>> 24;
    }


    public int countDifferentBits(int num1, int num2) {
        int count = 0;
        while(num1 != 0 || num2 != 0) {
            count += (num1 & 1) ^ (num2 & 1);
            num1 >>>= 1;
            num2 >>>= 1;
        }
        return count;
    }

    public void swapBit(int num1, int num2) {
        // newNum1 = num1 ^ num2
        num1 ^= num2;
        // newNum2 = num2 ^ newNum1 = num2 ^ (num1 ^ num2) = num1
        num2 ^= num1;
        // newNum1 = newNum1 ^ newNum2 = (num1 ^ num2) ^ num1 = num2
        num1 ^= num2;
    }

    public int ABS(int num) {
        // according to two's complement
        // positive: for x ≥ 0 → x
        // negative: for x < 0 → NOT(x) + 1
        int bit31 = num >> 31;
        // if positive: bit31 = 0x00000000, num ^ bit31 = num, (num ^ bit31) - bit31 = num - 0 = num
        // if negative bit31 = 0xFFFFFFFF, num ^ bit31 = ~num, (num ^ bit31) - bit31 = ~num - 0xFFFFFFFF
        // which is ~num - (-1) = ~num + 1
        return (num ^ bit31) - bit31;
    }

    public int modifyBit(int num, int pos, int state) {
        // state == 0 clear bit. state == 1 set bit
        // state = 0000 0001, -state = 1111 1111
        // state = 0000 0000, -state = 0000 0000
        int mask = 1 << pos;
        return (num & ~mask) | (-state & mask);
    }
}
