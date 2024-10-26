package kalkulator;

public class Calculator {
    private int state = 0;
    private Integer memory = null;
    private boolean error = false; // Wskaźnik błędu

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        this.error = false; // Resetujemy stan błędu przy ręcznym ustawieniu
    }

    public boolean hasError() {
        return error;
    }

    public void resetError() {
        error = false;
    }

    public void add(int value) {
        if (!error) {
            state += value;
        }
    }

    public void mult(int value) {
        if (!error) {
            state *= value;
        }
    }

    public void subtract(int value) {
        if (!error) {
            state -= value;
        }
    }

    public void divide(int value) {
        if (value == 0) {
            error = true; // Ustawiamy stan błędu
        } else {
            if (!error) {
                state /= value;
            }
        }
    }

    public void storeInMemory() {
        if (!error) {
            memory = state; // Zapisuje aktualny stan do pamięci
        }
    }

    public void recallFromMemory() {
        if (memory != null) {
            state = memory; // Przywraca wartość z pamięci
        } else {
            throw new IllegalStateException("Brak wartości w pamięci");
        }
    }

    public void clearMemory() {
        memory = null; // Czyści pamięć
    }

    // Nowe metody do operacji na pamięci
    public void addFromMemory() {
        if (memory != null && !error) {
            state += memory; // Dodaje wartość z pamięci do aktualnego stanu
        }
    }

    public void subtractFromMemory() {
        if (memory != null && !error) {
            state -= memory; // Odejmuje wartość z pamięci od aktualnego stanu
        }
    }

    public void multWithMemory() {
        if (memory != null && !error) {
            state *= memory; // Mnoży aktualny stan przez wartość z pamięci
        }
    }

    // Nowe operacje
    public void power(int exponent) {
        if (!error) {
            state = (int) Math.pow(state, exponent);
        }
    }

    public void sqrt() {
        if (state < 0) {
            error = true; // Ustawiamy stan błędu
        } else if (!error) {
            state = (int) Math.sqrt(state);
        }
    }
}
