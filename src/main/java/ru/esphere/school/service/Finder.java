package ru.esphere.school.service;

import ru.esphere.school.data.Member;
import ru.esphere.school.data.MembersGroup;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Finder {
    /**
     * Поиск групп людей старше определенного возраста.
     *
     * @param groups    группы
     * @param targetAge возраст для поиска
     * @return список имен групп из списка групп старше возраста targetAge
     */
    public Set<String> findOldMembers(List<MembersGroup> groups, int targetAge) {
        Set<String> groupsNames = groups.stream().map(membersGroup -> membersGroup.getMembers()).flatMap(List::stream)
                .filter(member -> member.getAge() > targetAge).map(member -> member.getName()).collect(Collectors.toSet());
        return groupsNames;
    }
}
