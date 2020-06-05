package com.tianju.bit;

import com.tianju.tree.BST;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tianju Zhou
 * Jun 4, 2020
 */
public class BitManipulationTest {

    @Test
    public void negativeNumberTest() {
        int a1 = 4;
        // divided by 2
        Assertions.assertEquals(a1 >> 1, 2);
        // multiplied by 2
        Assertions.assertEquals(a1 << 1, 8);


        // 2's complement:
        // 3 = 00...0011
        // -3 = 11..1100 + 1 = 11..1101
        // b1 >>> 1 = 01..1110 (shift without sign become a positive integer)
        // b1 >> 1 = 11..1110 (shift with sign still negative)
        // 2 = 00..0010
        // -2 = 11..1101 + 1 = 11..1110
        // that's why b1 >> 1 == -2
        int b1 = -3;
        // shift without sign new b1 = 0b1111111111111111111111111111110
        Assertions.assertEquals(b1 >>> 1, 0x7FFFFFFE);
        // shift with sign
        Assertions.assertEquals(b1 >> 1, -2);
        Assertions.assertEquals(b1 << 1, -6);

        int c1 = -4;
        Assertions.assertEquals(c1 >> 1, -2);
        Assertions.assertEquals(c1 << 1, -8);
    }

    @Test
    public void bitManipulationTest() {
        BitManipulation bitManipulation = new BitManipulation();
        Assertions.assertEquals(bitManipulation.setBit(0b00001000, 2), 12);
        Assertions.assertEquals(bitManipulation.clearBit(0b00001000, 3), 0);
        Assertions.assertEquals(bitManipulation.flipBit(0b00001000, 2), 12);
        Assertions.assertEquals(bitManipulation.flipBit(0b00001000, 3), 0);
        Assertions.assertTrue(bitManipulation.isBitSet(0b00001000, 3));
        Assertions.assertFalse(bitManipulation.isBitSet(0b00001000, 2));
        Assertions.assertTrue(bitManipulation.isPowerOfTwo(0b00001000));
        Assertions.assertFalse(bitManipulation.isPowerOfTwo(0b00001100));
        Assertions.assertEquals(bitManipulation.countBits1(0b00001100), 2);
        Assertions.assertEquals(bitManipulation.countBits2(0b00001100), 2);
        Assertions.assertEquals(bitManipulation.countBits3(0b00001100), 2);
        Assertions.assertEquals(bitManipulation.countDifferentBits(-0b00001000, -0b01110000), 3);
        Assertions.assertEquals(bitManipulation.countDifferentBits(0b00001000, 0b0001111), 3);
        Assertions.assertEquals(bitManipulation.ABS(-15), 15);
        Assertions.assertEquals(bitManipulation.ABS(-15), 15);
        Assertions.assertEquals(bitManipulation.modifyBit(0b00001000, 3, 0), bitManipulation.clearBit(0b00001000, 3));
        Assertions.assertEquals(bitManipulation.modifyBit(0b00001000, 2, 1), bitManipulation.setBit(0b00001000, 2));
    }
}
