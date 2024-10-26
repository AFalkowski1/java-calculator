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
            error = true;
        } else {
            if (!error) {
                state /= value;
            }
        }
    }

    public void storeInMemory() {
        if (!error) {
            memory = state;
        }
    }

    public void recallFromMemory() {
        if (memory != null) {
            state = memory;
        } else {
            throw new IllegalStateException("Brak wartości w pamięci");
        }
    }

    public void clearMemory() {
        memory = null;
    }
}
