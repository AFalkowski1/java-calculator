package kalkulator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class CalculatorTest {

    // ... istniejące testy ...

    @Test
    public void testAddFromMemory() {
        Calculator sut = new Calculator();
        sut.setState(10);
        sut.storeInMemory(); // Zapisz 10 do pamięci
        sut.setState(5);
        sut.addFromMemory(); // Dodaj 10 z pamięci do 5
        Assertions.assertEquals(15, sut.getState(), "Oczekiwano, że wynik to 15 po dodaniu z pamięci");
    }

    @Test
    public void testSubtractFromMemory() {
        Calculator sut = new Calculator();
        sut.setState(20);
        sut.storeInMemory(); // Zapisz 20 do pamięci
        sut.setState(5);
        sut.subtractFromMemory(); // Odejmij 20 z pamięci od 5
        Assertions.assertEquals(-15, sut.getState(), "Oczekiwano, że wynik to -15 po odjęciu z pamięci");
    }

    @Test
    public void testMultWithMemory() {
        Calculator sut = new Calculator();
        sut.setState(3);
        sut.storeInMemory(); // Zapisz 3 do pamięci
        sut.setState(4);
        sut.multWithMemory(); // Pomnóż 4 przez 3 z pamięci
        Assertions.assertEquals(12, sut.getState(), "Oczekiwano, że wynik to 12 po mnożeniu z pamięci");
    }

    @Test
    public void testAddFromMemoryWhenEmpty() {
        Calculator sut = new Calculator();
        sut.setState(5);
        sut.addFromMemory(); // Nie ma wartości w pamięci
        Assertions.assertEquals(5, sut.getState(), "Oczekiwano, że wynik pozostanie 5, gdy pamięć jest pusta");
    }

    // ... inne testy ...
}
