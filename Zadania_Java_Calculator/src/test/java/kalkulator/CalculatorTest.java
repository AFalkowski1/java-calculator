package kalkulator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class CalculatorTest {

    @Test
    public void testAddOne() {
        Calculator sut = new Calculator();
        sut.add(1);
        Assertions.assertEquals(1, sut.getState(), "0 + 1 powinno być 1");
    }

    @Test
    public void testMultOneByTwo() {
        Calculator sut = new Calculator();
        sut.setState(1);
        sut.mult(2);
        Assertions.assertEquals(2, sut.getState(), "1 * 2 powinno być 2");
    }

    @Test
    public void testSubtractPositiveValue() {
        Calculator sut = new Calculator();
        sut.setState(10);
        sut.subtract(4);
        Assertions.assertEquals(6, sut.getState(), "10 - 4 powinno być 6");
    }

    @Test
    public void testDivideByNegativeValue() {
        Calculator sut = new Calculator();
        sut.setState(10);
        sut.divide(-2);
        Assertions.assertEquals(-5, sut.getState(), "10 / -2 powinno być -5");
    }

    @Test
    public void testStoreInMemory() {
        Calculator sut = new Calculator();
        sut.setState(42);
        sut.storeInMemory();
        sut.setState(0);
        sut.recallFromMemory();
        Assertions.assertEquals(42, sut.getState(), "Oczekiwano, że wartość z pamięci to 42");
    }

    @Test
    public void testClearMemory() {
        Calculator sut = new Calculator();
        sut.setState(10);
        sut.storeInMemory();
        sut.clearMemory();
        Assertions.assertThrows(IllegalStateException.class, sut::recallFromMemory, "Oczekiwano wyjątku przy braku wartości w pamięci");
    }

    @Test
    public void testRecallWithoutStoring() {
        Calculator sut = new Calculator();
        Assertions.assertThrows(IllegalStateException.class, sut::recallFromMemory, "Oczekiwano wyjątku przy przywoływaniu pustej pamięci");
    }

    // Testy dla obsługi błędów

    @Test
    public void testDivideByZeroSetsErrorState() {
        Calculator sut = new Calculator();
        sut.setState(10);
        sut.divide(0);
        Assertions.assertTrue(sut.hasError(), "Oczekiwano stanu błędu po próbie dzielenia przez zero");
    }

    @Test
    public void testAddWhileInErrorState() {
        Calculator sut = new Calculator();
        sut.setState(10);
        sut.divide(0); // Wprowadza stan błędu
        sut.add(5); // Próba dodania
        Assertions.assertEquals(10, sut.getState(), "Stan kalkulatora powinien pozostać niezmieniony w stanie błędu");
    }

    @Test
    public void testResetErrorState() {
        Calculator sut = new Calculator();
        sut.setState(10);
        sut.divide(0); // Wprowadza stan błędu
        sut.resetError(); // Resetuje stan błędu
        sut.add(5); // Teraz powinna działać
        Assertions.assertEquals(15, sut.getState(), "Po zresetowaniu błędu, wynik powinien zostać poprawnie obliczony");
    }
}
