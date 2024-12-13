package oncall.model;

import java.util.List;
import oncall.exception.Exceptions;

public class HolidayOncallMembers {
    private final List<Member> members;

    public HolidayOncallMembers(List<Member> members) {
        validateMembers(members);
        this.members = members.stream().map(member -> new Member(member.getName())).toList();
    }

    public int getMembersCount() {
        return this.members.size();
    }

    private void validateMembers(List<Member> members) {
        if (members.size() != members.stream().distinct().count()) {
            throw Exceptions.INPUT_FORMAT_EXCEPTION.getException();
        }
    }
}
