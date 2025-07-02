package org.apache.commons.lang3;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.UUID;

public class slice3_Conversion_hexDigitToBinary_2_0_Test {

    @Test
    public void testHexDigitToBinary_0() {
        boolean[] expected = { false, false, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('0'));
    }

    @Test
    public void testHexDigitToBinary_1() {
        boolean[] expected = { true, false, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('1'));
    }

    @Test
    public void testHexDigitToBinary_2() {
        boolean[] expected = { false, true, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('2'));
    }

    @Test
    public void testHexDigitToBinary_3() {
        boolean[] expected = { true, true, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('3'));
    }

    @Test
    public void testHexDigitToBinary_4() {
        boolean[] expected = { false, false, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('4'));
    }

    @Test
    public void testHexDigitToBinary_5() {
        boolean[] expected = { true, false, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('5'));
    }

    @Test
    public void testHexDigitToBinary_6() {
        boolean[] expected = { false, true, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('6'));
    }

    @Test
    public void testHexDigitToBinary_7() {
        boolean[] expected = { true, true, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('7'));
    }

    @Test
    public void testHexDigitToBinary_8() {
        boolean[] expected = { false, false, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('8'));
    }

    @Test
    public void testHexDigitToBinary_9() {
        boolean[] expected = { true, false, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('9'));
    }

    @Test
    public void testHexDigitToBinary_A() {
        boolean[] expected = { false, true, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('A'));
    }

    @Test
    public void testHexDigitToBinary_B() {
        boolean[] expected = { true, true, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('B'));
    }

    @Test
    public void testHexDigitToBinary_C() {
        boolean[] expected = { false, false, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('C'));
    }

    @Test
    public void testHexDigitToBinary_D() {
        boolean[] expected = { true, false, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('D'));
    }

    @Test
    public void testHexDigitToBinary_E() {
        boolean[] expected = { false, true, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('E'));
    }

    @Test
    public void testHexDigitToBinary_F() {
        boolean[] expected = { true, true, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('F'));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHexDigitToBinary_invalid() {
        Conversion.hexDigitToBinary('G');
    }
}



package org.apache.commons.lang3;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThrows;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.UUID;

public class slice14_Conversion_hexDigitToBinary_2_0_Test {

    @Test
    public void testHexDigitToBinary_0() {
        boolean[] expected = { false, false, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('0'));
    }

    @Test
    public void testHexDigitToBinary_1() {
        boolean[] expected = { true, false, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('1'));
    }

    @Test
    public void testHexDigitToBinary_2() {
        boolean[] expected = { false, true, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('2'));
    }

    @Test
    public void testHexDigitToBinary_3() {
        boolean[] expected = { true, true, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('3'));
    }

    @Test
    public void testHexDigitToBinary_4() {
        boolean[] expected = { false, false, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('4'));
    }

    @Test
    public void testHexDigitToBinary_5() {
        boolean[] expected = { true, false, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('5'));
    }

    @Test
    public void testHexDigitToBinary_6() {
        boolean[] expected = { false, true, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('6'));
    }

    @Test
    public void testHexDigitToBinary_7() {
        boolean[] expected = { true, true, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('7'));
    }

    @Test
    public void testHexDigitToBinary_8() {
        boolean[] expected = { false, false, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('8'));
    }

    @Test
    public void testHexDigitToBinary_9() {
        boolean[] expected = { true, false, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('9'));
    }

    @Test
    public void testHexDigitToBinary_A() {
        boolean[] expected = { false, true, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('A'));
    }

    @Test
    public void testHexDigitToBinary_B() {
        boolean[] expected = { true, true, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('B'));
    }

    @Test
    public void testHexDigitToBinary_C() {
        boolean[] expected = { false, false, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('C'));
    }

    @Test
    public void testHexDigitToBinary_D() {
        boolean[] expected = { true, false, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('D'));
    }

    @Test
    public void testHexDigitToBinary_E() {
        boolean[] expected = { false, true, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('E'));
    }

    @Test
    public void testHexDigitToBinary_F() {
        boolean[] expected = { true, true, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('F'));
    }

    @Test
    public void testHexDigitToBinary_invalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            Conversion.hexDigitToBinary('G');
        });
    }
}



package org.apache.commons.lang3;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThrows;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.UUID;

public class slice15_Conversion_hexDigitToBinary_2_0_Test {

    @Test
    public void testHexDigitToBinary_0() {
        boolean[] expected = { false, false, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('0'));
    }

    @Test
    public void testHexDigitToBinary_1() {
        boolean[] expected = { true, false, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('1'));
    }

    @Test
    public void testHexDigitToBinary_2() {
        boolean[] expected = { false, true, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('2'));
    }

    @Test
    public void testHexDigitToBinary_3() {
        boolean[] expected = { true, true, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('3'));
    }

    @Test
    public void testHexDigitToBinary_4() {
        boolean[] expected = { false, false, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('4'));
    }

    @Test
    public void testHexDigitToBinary_5() {
        boolean[] expected = { true, false, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('5'));
    }

    @Test
    public void testHexDigitToBinary_6() {
        boolean[] expected = { false, true, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('6'));
    }

    @Test
    public void testHexDigitToBinary_7() {
        boolean[] expected = { true, true, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('7'));
    }

    @Test
    public void testHexDigitToBinary_8() {
        boolean[] expected = { false, false, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('8'));
    }

    @Test
    public void testHexDigitToBinary_9() {
        boolean[] expected = { true, false, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('9'));
    }

    @Test
    public void testHexDigitToBinary_A() {
        boolean[] expected = { false, true, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('A'));
    }

    @Test
    public void testHexDigitToBinary_B() {
        boolean[] expected = { true, true, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('B'));
    }

    @Test
    public void testHexDigitToBinary_C() {
        boolean[] expected = { false, false, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('C'));
    }

    @Test
    public void testHexDigitToBinary_D() {
        boolean[] expected = { true, false, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('D'));
    }

    @Test
    public void testHexDigitToBinary_E() {
        boolean[] expected = { false, true, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('E'));
    }

    @Test
    public void testHexDigitToBinary_F() {
        boolean[] expected = { true, true, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('F'));
    }

    @Test
    public void testHexDigitToBinary_invalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            Conversion.hexDigitToBinary('G');
        });
    }
}



package org.apache.commons.lang3;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.UUID;

public class slice2_Conversion_hexDigitToBinary_2_0_Test {

    @Test
    public void testHexDigitToBinary_0() {
        boolean[] expected = { false, false, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('0'));
    }

    @Test
    public void testHexDigitToBinary_1() {
        boolean[] expected = { true, false, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('1'));
    }

    @Test
    public void testHexDigitToBinary_2() {
        boolean[] expected = { false, true, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('2'));
    }

    @Test
    public void testHexDigitToBinary_3() {
        boolean[] expected = { true, true, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('3'));
    }

    @Test
    public void testHexDigitToBinary_4() {
        boolean[] expected = { false, false, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('4'));
    }

    @Test
    public void testHexDigitToBinary_5() {
        boolean[] expected = { true, false, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('5'));
    }

    @Test
    public void testHexDigitToBinary_6() {
        boolean[] expected = { false, true, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('6'));
    }

    @Test
    public void testHexDigitToBinary_7() {
        boolean[] expected = { true, true, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('7'));
    }

    @Test
    public void testHexDigitToBinary_8() {
        boolean[] expected = { false, false, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('8'));
    }

    @Test
    public void testHexDigitToBinary_9() {
        boolean[] expected = { true, false, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('9'));
    }

    @Test
    public void testHexDigitToBinary_A() {
        boolean[] expected = { false, true, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('A'));
    }

    @Test
    public void testHexDigitToBinary_B() {
        boolean[] expected = { true, true, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('B'));
    }

    @Test
    public void testHexDigitToBinary_C() {
        boolean[] expected = { false, false, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('C'));
    }

    @Test
    public void testHexDigitToBinary_D() {
        boolean[] expected = { true, false, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('D'));
    }

    @Test
    public void testHexDigitToBinary_E() {
        boolean[] expected = { false, true, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('E'));
    }

    @Test
    public void testHexDigitToBinary_F() {
        boolean[] expected = { true, true, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('F'));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHexDigitToBinary_invalid() {
        Conversion.hexDigitToBinary('G');
    }
}



package org.apache.commons.lang3;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThrows;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.UUID;

public class slice13_Conversion_hexDigitToBinary_2_0_Test {

    @Test
    public void testHexDigitToBinary_0() {
        boolean[] expected = { false, false, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('0'));
    }

    @Test
    public void testHexDigitToBinary_1() {
        boolean[] expected = { true, false, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('1'));
    }

    @Test
    public void testHexDigitToBinary_2() {
        boolean[] expected = { false, true, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('2'));
    }

    @Test
    public void testHexDigitToBinary_3() {
        boolean[] expected = { true, true, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('3'));
    }

    @Test
    public void testHexDigitToBinary_4() {
        boolean[] expected = { false, false, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('4'));
    }

    @Test
    public void testHexDigitToBinary_5() {
        boolean[] expected = { true, false, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('5'));
    }

    @Test
    public void testHexDigitToBinary_6() {
        boolean[] expected = { false, true, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('6'));
    }

    @Test
    public void testHexDigitToBinary_7() {
        boolean[] expected = { true, true, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('7'));
    }

    @Test
    public void testHexDigitToBinary_8() {
        boolean[] expected = { false, false, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('8'));
    }

    @Test
    public void testHexDigitToBinary_9() {
        boolean[] expected = { true, false, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('9'));
    }

    @Test
    public void testHexDigitToBinary_A() {
        boolean[] expected = { false, true, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('A'));
    }

    @Test
    public void testHexDigitToBinary_B() {
        boolean[] expected = { true, true, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('B'));
    }

    @Test
    public void testHexDigitToBinary_C() {
        boolean[] expected = { false, false, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('C'));
    }

    @Test
    public void testHexDigitToBinary_D() {
        boolean[] expected = { true, false, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('D'));
    }

    @Test
    public void testHexDigitToBinary_E() {
        boolean[] expected = { false, true, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('E'));
    }

    @Test
    public void testHexDigitToBinary_F() {
        boolean[] expected = { true, true, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('F'));
    }

    @Test
    public void testHexDigitToBinary_invalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            Conversion.hexDigitToBinary('G');
        });
    }
}



package org.apache.commons.lang3;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.UUID;

public class slice4_Conversion_hexDigitToBinary_2_0_Test {

    @Test
    public void testHexDigitToBinary_0() {
        boolean[] expected = { false, false, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('0'));
    }

    @Test
    public void testHexDigitToBinary_1() {
        boolean[] expected = { true, false, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('1'));
    }

    @Test
    public void testHexDigitToBinary_2() {
        boolean[] expected = { false, true, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('2'));
    }

    @Test
    public void testHexDigitToBinary_3() {
        boolean[] expected = { true, true, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('3'));
    }

    @Test
    public void testHexDigitToBinary_4() {
        boolean[] expected = { false, false, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('4'));
    }

    @Test
    public void testHexDigitToBinary_5() {
        boolean[] expected = { true, false, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('5'));
    }

    @Test
    public void testHexDigitToBinary_6() {
        boolean[] expected = { false, true, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('6'));
    }

    @Test
    public void testHexDigitToBinary_7() {
        boolean[] expected = { true, true, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('7'));
    }

    @Test
    public void testHexDigitToBinary_8() {
        boolean[] expected = { false, false, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('8'));
    }

    @Test
    public void testHexDigitToBinary_9() {
        boolean[] expected = { true, false, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('9'));
    }

    @Test
    public void testHexDigitToBinary_A() {
        boolean[] expected = { false, true, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('A'));
    }

    @Test
    public void testHexDigitToBinary_B() {
        boolean[] expected = { true, true, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('B'));
    }

    @Test
    public void testHexDigitToBinary_C() {
        boolean[] expected = { false, false, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('C'));
    }

    @Test
    public void testHexDigitToBinary_D() {
        boolean[] expected = { true, false, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('D'));
    }

    @Test
    public void testHexDigitToBinary_E() {
        boolean[] expected = { false, true, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('E'));
    }

    @Test
    public void testHexDigitToBinary_F() {
        boolean[] expected = { true, true, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('F'));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHexDigitToBinary_invalid() {
        Conversion.hexDigitToBinary('G');
    }
}



package org.apache.commons.lang3;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.UUID;

public class slice5_Conversion_hexDigitToBinary_2_0_Test {

    @Test
    public void testHexDigitToBinary_0() {
        boolean[] expected = { false, false, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('0'));
    }

    @Test
    public void testHexDigitToBinary_1() {
        boolean[] expected = { true, false, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('1'));
    }

    @Test
    public void testHexDigitToBinary_2() {
        boolean[] expected = { false, true, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('2'));
    }

    @Test
    public void testHexDigitToBinary_3() {
        boolean[] expected = { true, true, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('3'));
    }

    @Test
    public void testHexDigitToBinary_4() {
        boolean[] expected = { false, false, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('4'));
    }

    @Test
    public void testHexDigitToBinary_5() {
        boolean[] expected = { true, false, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('5'));
    }

    @Test
    public void testHexDigitToBinary_6() {
        boolean[] expected = { false, true, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('6'));
    }

    @Test
    public void testHexDigitToBinary_7() {
        boolean[] expected = { true, true, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('7'));
    }

    @Test
    public void testHexDigitToBinary_8() {
        boolean[] expected = { false, false, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('8'));
    }

    @Test
    public void testHexDigitToBinary_9() {
        boolean[] expected = { true, false, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('9'));
    }

    @Test
    public void testHexDigitToBinary_A() {
        boolean[] expected = { false, true, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('A'));
    }

    @Test
    public void testHexDigitToBinary_B() {
        boolean[] expected = { true, true, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('B'));
    }

    @Test
    public void testHexDigitToBinary_C() {
        boolean[] expected = { false, false, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('C'));
    }

    @Test
    public void testHexDigitToBinary_D() {
        boolean[] expected = { true, false, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('D'));
    }

    @Test
    public void testHexDigitToBinary_E() {
        boolean[] expected = { false, true, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('E'));
    }

    @Test
    public void testHexDigitToBinary_F() {
        boolean[] expected = { true, true, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('F'));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHexDigitToBinary_invalid() {
        Conversion.hexDigitToBinary('G');
    }
}



package org.apache.commons.lang3;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.UUID;

public class slice12_Conversion_hexDigitToBinary_2_0_Test {

    @Test
    public void testHexDigitToBinary_0() {
        boolean[] expected = { false, false, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('0'));
    }

    @Test
    public void testHexDigitToBinary_1() {
        boolean[] expected = { true, false, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('1'));
    }

    @Test
    public void testHexDigitToBinary_2() {
        boolean[] expected = { false, true, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('2'));
    }

    @Test
    public void testHexDigitToBinary_3() {
        boolean[] expected = { true, true, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('3'));
    }

    @Test
    public void testHexDigitToBinary_4() {
        boolean[] expected = { false, false, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('4'));
    }

    @Test
    public void testHexDigitToBinary_5() {
        boolean[] expected = { true, false, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('5'));
    }

    @Test
    public void testHexDigitToBinary_6() {
        boolean[] expected = { false, true, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('6'));
    }

    @Test
    public void testHexDigitToBinary_7() {
        boolean[] expected = { true, true, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('7'));
    }

    @Test
    public void testHexDigitToBinary_8() {
        boolean[] expected = { false, false, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('8'));
    }

    @Test
    public void testHexDigitToBinary_9() {
        boolean[] expected = { true, false, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('9'));
    }

    @Test
    public void testHexDigitToBinary_A() {
        boolean[] expected = { false, true, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('A'));
    }

    @Test
    public void testHexDigitToBinary_B() {
        boolean[] expected = { true, true, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('B'));
    }

    @Test
    public void testHexDigitToBinary_C() {
        boolean[] expected = { false, false, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('C'));
    }

    @Test
    public void testHexDigitToBinary_D() {
        boolean[] expected = { true, false, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('D'));
    }

    @Test
    public void testHexDigitToBinary_E() {
        boolean[] expected = { false, true, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('E'));
    }

    @Test
    public void testHexDigitToBinary_F() {
        boolean[] expected = { true, true, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('F'));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHexDigitToBinary_invalid() {
        Conversion.hexDigitToBinary('G');
    }
}



package org.apache.commons.lang3;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.UUID;

public class slice9_Conversion_hexDigitToBinary_2_0_Test {

    @Test
    public void testHexDigitToBinary_0() {
        boolean[] expected = { false, false, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('0'));
    }

    @Test
    public void testHexDigitToBinary_1() {
        boolean[] expected = { true, false, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('1'));
    }

    @Test
    public void testHexDigitToBinary_2() {
        boolean[] expected = { false, true, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('2'));
    }

    @Test
    public void testHexDigitToBinary_3() {
        boolean[] expected = { true, true, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('3'));
    }

    @Test
    public void testHexDigitToBinary_4() {
        boolean[] expected = { false, false, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('4'));
    }

    @Test
    public void testHexDigitToBinary_5() {
        boolean[] expected = { true, false, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('5'));
    }

    @Test
    public void testHexDigitToBinary_6() {
        boolean[] expected = { false, true, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('6'));
    }

    @Test
    public void testHexDigitToBinary_7() {
        boolean[] expected = { true, true, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('7'));
    }

    @Test
    public void testHexDigitToBinary_8() {
        boolean[] expected = { false, false, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('8'));
    }

    @Test
    public void testHexDigitToBinary_9() {
        boolean[] expected = { true, false, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('9'));
    }

    @Test
    public void testHexDigitToBinary_A() {
        boolean[] expected = { false, true, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('A'));
    }

    @Test
    public void testHexDigitToBinary_B() {
        boolean[] expected = { true, true, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('B'));
    }

    @Test
    public void testHexDigitToBinary_C() {
        boolean[] expected = { false, false, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('C'));
    }

    @Test
    public void testHexDigitToBinary_D() {
        boolean[] expected = { true, false, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('D'));
    }

    @Test
    public void testHexDigitToBinary_E() {
        boolean[] expected = { false, true, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('E'));
    }

    @Test
    public void testHexDigitToBinary_F() {
        boolean[] expected = { true, true, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('F'));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHexDigitToBinary_invalid() {
        Conversion.hexDigitToBinary('G');
    }
}



package org.apache.commons.lang3;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.UUID;

public class slice8_Conversion_hexDigitToBinary_2_0_Test {

    @Test
    public void testHexDigitToBinary_0() {
        boolean[] expected = { false, false, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('0'));
    }

    @Test
    public void testHexDigitToBinary_1() {
        boolean[] expected = { true, false, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('1'));
    }

    @Test
    public void testHexDigitToBinary_2() {
        boolean[] expected = { false, true, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('2'));
    }

    @Test
    public void testHexDigitToBinary_3() {
        boolean[] expected = { true, true, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('3'));
    }

    @Test
    public void testHexDigitToBinary_4() {
        boolean[] expected = { false, false, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('4'));
    }

    @Test
    public void testHexDigitToBinary_5() {
        boolean[] expected = { true, false, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('5'));
    }

    @Test
    public void testHexDigitToBinary_6() {
        boolean[] expected = { false, true, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('6'));
    }

    @Test
    public void testHexDigitToBinary_7() {
        boolean[] expected = { true, true, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('7'));
    }

    @Test
    public void testHexDigitToBinary_8() {
        boolean[] expected = { false, false, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('8'));
    }

    @Test
    public void testHexDigitToBinary_9() {
        boolean[] expected = { true, false, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('9'));
    }

    @Test
    public void testHexDigitToBinary_A() {
        boolean[] expected = { false, true, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('A'));
    }

    @Test
    public void testHexDigitToBinary_B() {
        boolean[] expected = { true, true, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('B'));
    }

    @Test
    public void testHexDigitToBinary_C() {
        boolean[] expected = { false, false, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('C'));
    }

    @Test
    public void testHexDigitToBinary_D() {
        boolean[] expected = { true, false, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('D'));
    }

    @Test
    public void testHexDigitToBinary_E() {
        boolean[] expected = { false, true, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('E'));
    }

    @Test
    public void testHexDigitToBinary_F() {
        boolean[] expected = { true, true, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('F'));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHexDigitToBinary_invalid() {
        Conversion.hexDigitToBinary('G');
    }
}



package org.apache.commons.lang3;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.UUID;

public class slice1_Conversion_hexDigitToBinary_2_0_Test {

    @Test
    public void testHexDigitToBinary_0() {
        boolean[] expected = { false, false, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('0'));
    }

    @Test
    public void testHexDigitToBinary_1() {
        boolean[] expected = { true, false, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('1'));
    }

    @Test
    public void testHexDigitToBinary_2() {
        boolean[] expected = { false, true, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('2'));
    }

    @Test
    public void testHexDigitToBinary_3() {
        boolean[] expected = { true, true, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('3'));
    }

    @Test
    public void testHexDigitToBinary_4() {
        boolean[] expected = { false, false, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('4'));
    }

    @Test
    public void testHexDigitToBinary_5() {
        boolean[] expected = { true, false, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('5'));
    }

    @Test
    public void testHexDigitToBinary_6() {
        boolean[] expected = { false, true, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('6'));
    }

    @Test
    public void testHexDigitToBinary_7() {
        boolean[] expected = { true, true, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('7'));
    }

    @Test
    public void testHexDigitToBinary_8() {
        boolean[] expected = { false, false, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('8'));
    }

    @Test
    public void testHexDigitToBinary_9() {
        boolean[] expected = { true, false, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('9'));
    }

    @Test
    public void testHexDigitToBinary_A() {
        boolean[] expected = { false, true, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('A'));
    }

    @Test
    public void testHexDigitToBinary_B() {
        boolean[] expected = { true, true, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('B'));
    }

    @Test
    public void testHexDigitToBinary_C() {
        boolean[] expected = { false, false, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('C'));
    }

    @Test
    public void testHexDigitToBinary_D() {
        boolean[] expected = { true, false, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('D'));
    }

    @Test
    public void testHexDigitToBinary_E() {
        boolean[] expected = { false, true, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('E'));
    }

    @Test
    public void testHexDigitToBinary_F() {
        boolean[] expected = { true, true, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('F'));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHexDigitToBinary_invalid() {
        Conversion.hexDigitToBinary('G');
    }
}



package org.apache.commons.lang3;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThrows;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.UUID;

public class slice16_Conversion_hexDigitToBinary_2_0_Test {

    @Test
    public void testHexDigitToBinary_0() {
        boolean[] expected = { false, false, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('0'));
    }

    @Test
    public void testHexDigitToBinary_1() {
        boolean[] expected = { true, false, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('1'));
    }

    @Test
    public void testHexDigitToBinary_2() {
        boolean[] expected = { false, true, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('2'));
    }

    @Test
    public void testHexDigitToBinary_3() {
        boolean[] expected = { true, true, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('3'));
    }

    @Test
    public void testHexDigitToBinary_4() {
        boolean[] expected = { false, false, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('4'));
    }

    @Test
    public void testHexDigitToBinary_5() {
        boolean[] expected = { true, false, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('5'));
    }

    @Test
    public void testHexDigitToBinary_6() {
        boolean[] expected = { false, true, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('6'));
    }

    @Test
    public void testHexDigitToBinary_7() {
        boolean[] expected = { true, true, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('7'));
    }

    @Test
    public void testHexDigitToBinary_8() {
        boolean[] expected = { false, false, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('8'));
    }

    @Test
    public void testHexDigitToBinary_9() {
        boolean[] expected = { true, false, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('9'));
    }

    @Test
    public void testHexDigitToBinary_A() {
        boolean[] expected = { false, true, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('A'));
    }

    @Test
    public void testHexDigitToBinary_B() {
        boolean[] expected = { true, true, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('B'));
    }

    @Test
    public void testHexDigitToBinary_C() {
        boolean[] expected = { false, false, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('C'));
    }

    @Test
    public void testHexDigitToBinary_D() {
        boolean[] expected = { true, false, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('D'));
    }

    @Test
    public void testHexDigitToBinary_E() {
        boolean[] expected = { false, true, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('E'));
    }

    @Test
    public void testHexDigitToBinary_F() {
        boolean[] expected = { true, true, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('F'));
    }

    @Test
    public void testHexDigitToBinary_invalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            Conversion.hexDigitToBinary('G');
        });
    }
}



package org.apache.commons.lang3;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThrows;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.UUID;

public class slice17_Conversion_hexDigitToBinary_2_0_Test {

    @Test
    public void testHexDigitToBinary_0() {
        boolean[] expected = { false, false, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('0'));
    }

    @Test
    public void testHexDigitToBinary_1() {
        boolean[] expected = { true, false, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('1'));
    }

    @Test
    public void testHexDigitToBinary_2() {
        boolean[] expected = { false, true, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('2'));
    }

    @Test
    public void testHexDigitToBinary_3() {
        boolean[] expected = { true, true, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('3'));
    }

    @Test
    public void testHexDigitToBinary_4() {
        boolean[] expected = { false, false, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('4'));
    }

    @Test
    public void testHexDigitToBinary_5() {
        boolean[] expected = { true, false, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('5'));
    }

    @Test
    public void testHexDigitToBinary_6() {
        boolean[] expected = { false, true, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('6'));
    }

    @Test
    public void testHexDigitToBinary_7() {
        boolean[] expected = { true, true, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('7'));
    }

    @Test
    public void testHexDigitToBinary_8() {
        boolean[] expected = { false, false, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('8'));
    }

    @Test
    public void testHexDigitToBinary_9() {
        boolean[] expected = { true, false, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('9'));
    }

    @Test
    public void testHexDigitToBinary_A() {
        boolean[] expected = { false, true, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('A'));
    }

    @Test
    public void testHexDigitToBinary_B() {
        boolean[] expected = { true, true, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('B'));
    }

    @Test
    public void testHexDigitToBinary_C() {
        boolean[] expected = { false, false, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('C'));
    }

    @Test
    public void testHexDigitToBinary_D() {
        boolean[] expected = { true, false, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('D'));
    }

    @Test
    public void testHexDigitToBinary_E() {
        boolean[] expected = { false, true, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('E'));
    }

    @Test
    public void testHexDigitToBinary_F() {
        boolean[] expected = { true, true, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('F'));
    }

    @Test
    public void testHexDigitToBinary_invalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            Conversion.hexDigitToBinary('G');
        });
    }
}



package org.apache.commons.lang3;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.UUID;

public class slice0_Conversion_hexDigitToBinary_2_0_Test {

    @Test
    public void testHexDigitToBinary_0() {
        boolean[] expected = { false, false, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('0'));
    }

    @Test
    public void testHexDigitToBinary_1() {
        boolean[] expected = { true, false, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('1'));
    }

    @Test
    public void testHexDigitToBinary_2() {
        boolean[] expected = { false, true, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('2'));
    }

    @Test
    public void testHexDigitToBinary_3() {
        boolean[] expected = { true, true, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('3'));
    }

    @Test
    public void testHexDigitToBinary_4() {
        boolean[] expected = { false, false, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('4'));
    }

    @Test
    public void testHexDigitToBinary_5() {
        boolean[] expected = { true, false, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('5'));
    }

    @Test
    public void testHexDigitToBinary_6() {
        boolean[] expected = { false, true, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('6'));
    }

    @Test
    public void testHexDigitToBinary_7() {
        boolean[] expected = { true, true, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('7'));
    }

    @Test
    public void testHexDigitToBinary_8() {
        boolean[] expected = { false, false, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('8'));
    }

    @Test
    public void testHexDigitToBinary_9() {
        boolean[] expected = { true, false, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('9'));
    }

    @Test
    public void testHexDigitToBinary_a() {
        boolean[] expected = { false, true, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('a'));
    }

    @Test
    public void testHexDigitToBinary_A() {
        boolean[] expected = { false, true, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('A'));
    }

    @Test
    public void testHexDigitToBinary_b() {
        boolean[] expected = { true, true, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('b'));
    }

    @Test
    public void testHexDigitToBinary_B() {
        boolean[] expected = { true, true, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('B'));
    }

    @Test
    public void testHexDigitToBinary_c() {
        boolean[] expected = { false, false, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('c'));
    }

    @Test
    public void testHexDigitToBinary_C() {
        boolean[] expected = { false, false, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('C'));
    }

    @Test
    public void testHexDigitToBinary_d() {
        boolean[] expected = { true, false, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('d'));
    }
}



package org.apache.commons.lang3;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.UUID;

public class slice11_Conversion_hexDigitToBinary_2_0_Test {

    @Test
    public void testHexDigitToBinary_0() {
        boolean[] expected = { false, false, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('0'));
    }

    @Test
    public void testHexDigitToBinary_1() {
        boolean[] expected = { true, false, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('1'));
    }

    @Test
    public void testHexDigitToBinary_2() {
        boolean[] expected = { false, true, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('2'));
    }

    @Test
    public void testHexDigitToBinary_3() {
        boolean[] expected = { true, true, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('3'));
    }

    @Test
    public void testHexDigitToBinary_4() {
        boolean[] expected = { false, false, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('4'));
    }

    @Test
    public void testHexDigitToBinary_5() {
        boolean[] expected = { true, false, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('5'));
    }

    @Test
    public void testHexDigitToBinary_6() {
        boolean[] expected = { false, true, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('6'));
    }

    @Test
    public void testHexDigitToBinary_7() {
        boolean[] expected = { true, true, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('7'));
    }

    @Test
    public void testHexDigitToBinary_8() {
        boolean[] expected = { false, false, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('8'));
    }

    @Test
    public void testHexDigitToBinary_9() {
        boolean[] expected = { true, false, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('9'));
    }

    @Test
    public void testHexDigitToBinary_A() {
        boolean[] expected = { false, true, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('A'));
    }

    @Test
    public void testHexDigitToBinary_B() {
        boolean[] expected = { true, true, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('B'));
    }

    @Test
    public void testHexDigitToBinary_C() {
        boolean[] expected = { false, false, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('C'));
    }

    @Test
    public void testHexDigitToBinary_D() {
        boolean[] expected = { true, false, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('D'));
    }

    @Test
    public void testHexDigitToBinary_E() {
        boolean[] expected = { false, true, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('E'));
    }

    @Test
    public void testHexDigitToBinary_F() {
        boolean[] expected = { true, true, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('F'));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHexDigitToBinary_invalid() {
        Conversion.hexDigitToBinary('G');
    }
}



package org.apache.commons.lang3;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.UUID;

public class slice6_Conversion_hexDigitToBinary_2_0_Test {

    @Test
    public void testHexDigitToBinary_0() {
        boolean[] expected = { false, false, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('0'));
    }

    @Test
    public void testHexDigitToBinary_1() {
        boolean[] expected = { true, false, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('1'));
    }

    @Test
    public void testHexDigitToBinary_2() {
        boolean[] expected = { false, true, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('2'));
    }

    @Test
    public void testHexDigitToBinary_3() {
        boolean[] expected = { true, true, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('3'));
    }

    @Test
    public void testHexDigitToBinary_4() {
        boolean[] expected = { false, false, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('4'));
    }

    @Test
    public void testHexDigitToBinary_5() {
        boolean[] expected = { true, false, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('5'));
    }

    @Test
    public void testHexDigitToBinary_6() {
        boolean[] expected = { false, true, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('6'));
    }

    @Test
    public void testHexDigitToBinary_7() {
        boolean[] expected = { true, true, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('7'));
    }

    @Test
    public void testHexDigitToBinary_8() {
        boolean[] expected = { false, false, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('8'));
    }

    @Test
    public void testHexDigitToBinary_9() {
        boolean[] expected = { true, false, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('9'));
    }

    @Test
    public void testHexDigitToBinary_A() {
        boolean[] expected = { false, true, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('A'));
    }

    @Test
    public void testHexDigitToBinary_B() {
        boolean[] expected = { true, true, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('B'));
    }

    @Test
    public void testHexDigitToBinary_C() {
        boolean[] expected = { false, false, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('C'));
    }

    @Test
    public void testHexDigitToBinary_D() {
        boolean[] expected = { true, false, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('D'));
    }

    @Test
    public void testHexDigitToBinary_E() {
        boolean[] expected = { false, true, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('E'));
    }

    @Test
    public void testHexDigitToBinary_F() {
        boolean[] expected = { true, true, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('F'));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHexDigitToBinary_invalid() {
        Conversion.hexDigitToBinary('G');
    }
}



package org.apache.commons.lang3;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.UUID;

public class slice7_Conversion_hexDigitToBinary_2_0_Test {

    @Test
    public void testHexDigitToBinary_0() {
        boolean[] expected = { false, false, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('0'));
    }

    @Test
    public void testHexDigitToBinary_1() {
        boolean[] expected = { true, false, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('1'));
    }

    @Test
    public void testHexDigitToBinary_2() {
        boolean[] expected = { false, true, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('2'));
    }

    @Test
    public void testHexDigitToBinary_3() {
        boolean[] expected = { true, true, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('3'));
    }

    @Test
    public void testHexDigitToBinary_4() {
        boolean[] expected = { false, false, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('4'));
    }

    @Test
    public void testHexDigitToBinary_5() {
        boolean[] expected = { true, false, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('5'));
    }

    @Test
    public void testHexDigitToBinary_6() {
        boolean[] expected = { false, true, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('6'));
    }

    @Test
    public void testHexDigitToBinary_7() {
        boolean[] expected = { true, true, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('7'));
    }

    @Test
    public void testHexDigitToBinary_8() {
        boolean[] expected = { false, false, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('8'));
    }

    @Test
    public void testHexDigitToBinary_9() {
        boolean[] expected = { true, false, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('9'));
    }

    @Test
    public void testHexDigitToBinary_A() {
        boolean[] expected = { false, true, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('A'));
    }

    @Test
    public void testHexDigitToBinary_B() {
        boolean[] expected = { true, true, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('B'));
    }

    @Test
    public void testHexDigitToBinary_C() {
        boolean[] expected = { false, false, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('C'));
    }

    @Test
    public void testHexDigitToBinary_D() {
        boolean[] expected = { true, false, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('D'));
    }

    @Test
    public void testHexDigitToBinary_E() {
        boolean[] expected = { false, true, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('E'));
    }

    @Test
    public void testHexDigitToBinary_F() {
        boolean[] expected = { true, true, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('F'));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHexDigitToBinary_invalid() {
        Conversion.hexDigitToBinary('G');
    }
}



package org.apache.commons.lang3;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.UUID;

public class slice10_Conversion_hexDigitToBinary_2_0_Test {

    @Test
    public void testHexDigitToBinary_0() {
        boolean[] expected = { false, false, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('0'));
    }

    @Test
    public void testHexDigitToBinary_1() {
        boolean[] expected = { true, false, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('1'));
    }

    @Test
    public void testHexDigitToBinary_2() {
        boolean[] expected = { false, true, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('2'));
    }

    @Test
    public void testHexDigitToBinary_3() {
        boolean[] expected = { true, true, false, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('3'));
    }

    @Test
    public void testHexDigitToBinary_4() {
        boolean[] expected = { false, false, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('4'));
    }

    @Test
    public void testHexDigitToBinary_5() {
        boolean[] expected = { true, false, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('5'));
    }

    @Test
    public void testHexDigitToBinary_6() {
        boolean[] expected = { false, true, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('6'));
    }

    @Test
    public void testHexDigitToBinary_7() {
        boolean[] expected = { true, true, true, false };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('7'));
    }

    @Test
    public void testHexDigitToBinary_8() {
        boolean[] expected = { false, false, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('8'));
    }

    @Test
    public void testHexDigitToBinary_9() {
        boolean[] expected = { true, false, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('9'));
    }

    @Test
    public void testHexDigitToBinary_A() {
        boolean[] expected = { false, true, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('A'));
    }

    @Test
    public void testHexDigitToBinary_B() {
        boolean[] expected = { true, true, false, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('B'));
    }

    @Test
    public void testHexDigitToBinary_C() {
        boolean[] expected = { false, false, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('C'));
    }

    @Test
    public void testHexDigitToBinary_D() {
        boolean[] expected = { true, false, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('D'));
    }

    @Test
    public void testHexDigitToBinary_E() {
        boolean[] expected = { false, true, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('E'));
    }

    @Test
    public void testHexDigitToBinary_F() {
        boolean[] expected = { true, true, true, true };
        assertArrayEquals(expected, Conversion.hexDigitToBinary('F'));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHexDigitToBinary_invalid() {
        Conversion.hexDigitToBinary('G');
    }
}



