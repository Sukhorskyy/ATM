package atm;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ATMTest {
    private static Scanner sc = new Scanner(System.in);
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    ATM atm;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @BeforeEach
    void setUp() {
        atm = new ATM();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testATMException() {
        try {
            atm.process(126);
            fail("Exception does not work" );
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    void testATM() {
        atm.process(125);
        assertEquals("expected 1 with amount of 5\n" +
                "expected 0 with amount of 10\n" +
                "expected 6 with amount of 20".replace("\n", ""),
                outputStreamCaptor.toString().trim().replaceAll("\r", ""));
    }
}