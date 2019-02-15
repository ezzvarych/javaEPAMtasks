package task3.controllers;

import jdk.nashorn.internal.ir.annotations.Ignore;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegexContainerTest {

    @Ignore
    @Test
    public void testNameRegex() {

        String pattern = RegexContainer.NAME_REGEXP;

        assertTrue("Eugene".matches(pattern));
        assertTrue("Eugene-Alex".matches(pattern));
        assertFalse("Eugene-".matches(pattern));
        assertFalse("Eugene-Alex-".matches(pattern));
        assertFalse("EugeneAlex".matches(pattern));
        assertFalse("-Eugene-Alex".matches(pattern));
        assertFalse("eugene-Alex".matches(pattern));
        assertFalse("eugene".matches(pattern));
        assertFalse("Eugene_Alex".matches(pattern));
    }

    @Test
    public void testNicknameRegex() {
        String pattern = RegexContainer.NICKNAME_REGEXP;

        assertTrue("ya_tvoi_otec1".matches(pattern));
        assertTrue("1qwert_1q_".matches(pattern));
        assertTrue("_YaTVOIot_ec1".matches(pattern));
        assertFalse("Ya-Tv1".matches(pattern));
        assertFalse("1.qwert.".matches(pattern));
        assertFalse("qwert,".matches(pattern));
        assertFalse("ya_tboi_?".matches(pattern));
        assertFalse("Я_твой1".matches(pattern));
    }

    @Test
    public void testMobilePhoneRegex() {
        String pattern = RegexContainer.MOBILE_PHONE_REGEXP;

        assertTrue("+380660757414".matches(pattern));
        assertFalse("+3 80660757414".matches(pattern));
        assertFalse("380660757414".matches(pattern));
    }
}