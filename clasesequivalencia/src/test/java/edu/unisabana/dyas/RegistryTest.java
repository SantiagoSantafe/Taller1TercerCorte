package edu.unisabana.dyas.tdd.registry;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import java.util.HashSet;

public class RegistryTest {

    private Registry registry;

    @Before
    public void setUp() {
        registry = new Registry();
        Person persona1 = new Person("Dave", 104, 30, Gender.MALE, true);
    }

    @Test
    public void debeRegistrarValidezVotante() {
        Person validPerson = new Person("Alice", 101, 25, Gender.FEMALE, true);
        assertEquals(RegisterResult.VALID, registry.registerVoter(validPerson));
    }

    @Test
    public void noDebeRegistrarMuertos() {
        Person personaMuerta = new Person("Bob", 102, 70, Gender.MALE, false);
        assertEquals(RegisterResult.DEAD, registry.registerVoter(personaMuerta));
    }

    @Test
    public void noDebeRegistrarMenores() {
        Person menorEdad = new Person("Charlie", 103, 17, Gender.MALE, true);
        assertEquals(RegisterResult.UNDERAGE, registry.registerVoter(menorEdad));
    }

    @Test
    public void noDeberiaDuplicarRegistros() {
        Person personaDuplicada = new Person("Dave", 104, 30, Gender.MALE, true);
        registry.registerVoter(personaDuplicada);
        assertEquals(RegisterResult.DUPLICATED, registry.registerVoter(personaDuplicada));
    }

    @Test
    public void noDeberiaRegistrarConEdadInvalida() {
        Person edadInvalida = new Person("Eve", 105, -5, Gender.FEMALE, true);
        assertEquals(RegisterResult.INVALID_AGE, registry.registerVoter(edadInvalida));
    }
}
