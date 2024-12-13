package oncall.model;

import oncall.exception.Exceptions;

public class Staff {
    private final String name;

    public Staff(String name) {
        validateName(name);
        this.name = name;
    }

    public void validateName(String name) {
        if (name.length() > 5) {
            throw Exceptions.INPUT_FORMAT_EXCEPTION.getException();
        }
    }
}
