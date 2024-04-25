//package edu.unisabana.dyas.tdd.registry;
package edu.unisabana.dyas;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import edu.unisabana.dyas.tdd.registry.Gender;
import edu.unisabana.dyas.tdd.registry.Person;
import edu.unisabana.dyas.tdd.registry.RegisterResult;
import edu.unisabana.dyas.tdd.registry.Registry;

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
        System.out.println("Test 2 completado ---------------------------------------------------------------------------------");
    }

    @Test
    public void noDebeRegistrarMuertos() {
        Person personaMuerta = new Person("Bob", 102, 70, Gender.MALE, false);
        assertEquals(RegisterResult.DEAD, registry.registerVoter(personaMuerta));
        System.out.println("Test 3 completado ---------------------------------------------------------------------------------");
    }

    @Test
    public void noDebeRegistrarMenores() {
        Person menorEdad = new Person("Charlie", 103, 17, Gender.MALE, true);
        assertEquals(RegisterResult.UNDERAGE, registry.registerVoter(menorEdad));
        System.out.println("Test 4 completado ---------------------------------------------------------------------------------");
    }

    @Test
    public void noDeberiaDuplicarRegistros() {
        Person personaDuplicada = new Person("Dave", 104, 30, Gender.MALE, true);
        registry.registerVoter(personaDuplicada);
        assertEquals(RegisterResult.DUPLICATED, registry.registerVoter(personaDuplicada));
        System.out.println("Test 5 completado ---------------------------------------------------------------------------------");
    }

    @Test
    public void noDeberiaRegistrarConEdadInvalida() {
        Person edadInvalida = new Person("Eve", 105, -5, Gender.FEMALE, true);
        assertEquals(RegisterResult.INVALID_AGE, registry.registerVoter(edadInvalida));
        System.out.println("Test 6 completado ---------------------------------------------------------------------------------");
    }

    @Test
    public void noDeberiaRegistrarPersonasVacias() {
        assertEquals(RegisterResult.INVALID_DATA, registry.registerVoter(new Person()));
        System.out.println("Test 7 completado ---------------------------------------------------------------------------------");
    }

    @Test
    public void noDeberiaRegistrarNombresInvalidos() {
        Person nombreExtraño = new Person("4843348983", 504, 32, Gender.FEMALE, true);
        assertEquals(RegisterResult.INVALID_DATA, registry.registerVoter(nombreExtraño));
        System.out.println("Test 8 completado ---------------------------------------------------------------------------------");
    }
}
