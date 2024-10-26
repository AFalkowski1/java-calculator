package kalkulator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class CalculatorTest {

    // Testy dla dodawania
    @Test
    public void testAddOne() {
        Calculator sut = new Calculator();
        sut.add(1);
        Assertions.assertEquals(1, sut.getState(), "0 + 1 powinno być 1");
    }

    @Test
    public void testAddLargeNumbers() {
        Calculator sut = new Calculator();
        sut.setState(Integer.MAX_VALUE);
        sut.add(1);
        Assertions.assertEquals(Integer.MAX_VALUE + 1, sut.getState(), "Dodawanie dużej liczby powinno być poprawne.");
    }

    // Testy dla mnożenia
    @Test
    public void testMultOneByTwo() {
        Calculator sut = new Calculator();
        sut.setState(1);
        sut.mult(2);
        Assertions.assertEquals(2, sut.getState(), "1 * 2 powinno być 2");
    }

    @Test
    public void testMultiplyByZero() {
        Calculator sut = new Calculator();
        sut.setState(5);
        sut.mult(0);
        Assertions.assertEquals(0, sut.getState(), "Mnożenie przez 0 powinno dać 0.");
    }

    // Testy dla odejmowania
    @Test
    public void testSubtractPositiveValue() {
        Calculator sut = new Calculator();
        sut.setState(10);
        sut.subtract(4);
        Assertions.assertEquals(6, sut.getState(), "10 - 4 powinno być 6");
    }

    // Testy dla dzielenia
    @Test
    public void testDivideByNegativeValue() {
        Calculator sut = new Calculator();
        sut.setState(10);
        sut.divide(-2);
        Assertions.assertEquals(-5, sut.getState(), "10 / -2 powinno być -5");
    }

    @Test
    public void testDivideByZeroSetsErrorState() {
        Calculator sut = new Calculator();
        sut.setState(10);
        sut.divide(0);
        Assertions.assertTrue(sut.hasError(), "Oczekiwano stanu błędu po próbie dzielenia przez zero");
    }

    // Testy dla operacji pamięci
    @Test
    public void testStoreInMemory() {
        Calculator sut = new Calculator();
        sut.setState(42);
        sut.storeInMemory();
        sut.setState(0);
        sut.recallFromMemory();
        Assertions.assertEquals(42, sut.getState(), "Oczekiwano, że wartość z pamięci to 42.");
    }

    @Test
    public void testClearMemory() {
        Calculator sut = new Calculator();
        sut.setState(10);
        sut.storeInMemory();
        sut.clearMemory();
        Assertions.assertThrows(IllegalStateException.class, sut::recallFromMemory, "Oczekiwano wyjątku przy braku wartości w pamięci.");
    }

    @Test
    public void testRecallWithoutStoring() {
        Calculator sut = new Calculator();
        Assertions.assertThrows(IllegalStateException.class, sut::recallFromMemory, "Oczekiwano wyjątku przy przywoływaniu pustej pamięci.");
    }

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

    // Testy dla nowych operacji
    @Test
    public void testPower() {
        Calculator sut = new Calculator();
        sut.setState(2);
        sut.power(3);
        Assertions.assertEquals(8, sut.getState(), "2 do potęgi 3 powinno dać 8.");
    }

    @Test
    public void testSqrt() {
        Calculator sut = new Calculator();
        sut.setState(9);
        sut.sqrt();
        Assertions.assertEquals(3, sut.getState(), "Pierwiastek kwadratowy z 9 powinien dać 3.");
    }

    @Test
    public void testSqrtNegative() {
        Calculator sut = new Calculator();
        sut.setState(-1);
        sut.sqrt(); // Ustawia stan błędu
        Assertions.assertTrue(sut.hasError(), "Oczekiwano stanu błędu przy obliczaniu pierwiastka z liczby ujemnej.");
    }
}
