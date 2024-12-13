package oncall.model;

import java.util.Objects;
import oncall.exception.Exceptions;

public class Member {
    private final String name;

    public Member(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void validateName(String name) {
        if (name.length() > 5) {
            throw Exceptions.INPUT_FORMAT_EXCEPTION.getException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Member member)) {
            return false;
        }
        return Objects.equals(name, member.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
