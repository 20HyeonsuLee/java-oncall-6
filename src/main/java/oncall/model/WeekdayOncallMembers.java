package oncall.model;

import java.util.List;
import oncall.exception.Exceptions;

public class WeekdayOncallMembers {
    private final List<Member> members;
    private int currentTurn = 0;

    public WeekdayOncallMembers(List<Member> members) {
        validateMembers(members);
        this.members = members.stream().map(member -> new Member(member.getName())).toList();
    }

    public int getMembersCount() {
        return this.members.size();
    }

    public Member getCurrentTurnMember() {
        return members.get(currentTurn);
    }

    public void swap() {
        Member currentTurnMember = members.get(currentTurn);
        Member nextTurnMember = members.get(currentTurn + 1);
        members.set(currentTurn, nextTurnMember);
        members.set(currentTurn + 1, currentTurnMember);
    }

    public void forwardTurn() {
        ++currentTurn;
    }

    private void validateMembers(List<Member> members) {
        if (members.size() != members.stream().distinct().count()) {
            throw Exceptions.INPUT_FORMAT_EXCEPTION.getException();
        }
    }
}
