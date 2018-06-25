package com.opipo.terraincognitaserver.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("CharacterGroup autogenerated")
public class CharacterGroupTest {

    private CharacterGroup characterGroup;

    @BeforeEach
    public void init() {
        characterGroup = new CharacterGroup();
    }

    @Test
    @DisplayName("The getter and the setter of name work well")
    public void nameAttributeTest() {
        String name = Integer.toString(1);
        characterGroup.setName(name);
        assertEquals(name, characterGroup.getName());
    }

    @Test
    @DisplayName("The getter and the setter of description work well")
    public void descriptionAttributeTest() {
        String description = Integer.toString(2);
        characterGroup.setDescription(description);
        assertEquals(description, characterGroup.getDescription());
    }

    @Test
    @DisplayName("The getter and the setter of characters work well")
    public void charactersAttributeTest() {
        Set<Character> characters = new HashSet<Character>();
        characterGroup.setCharacters(characters);
        assertEquals(characters, characterGroup.getCharacters());
    }

    @Test
    public void givenSameObjReturnThatTheyAreEquals() {
        CharacterGroup o1 = new CharacterGroup();
        CharacterGroup o2 = new CharacterGroup();
        assertEquals(o1, o2);
    }

    @Test
    public void givenSameObjReturnZero() {
        CharacterGroup o1 = new CharacterGroup();
        CharacterGroup o2 = new CharacterGroup();
        assertEquals(0, o1.compareTo(o2));
    }

    @Test
    public void givenObjectFromOtherClassReturnThatTheyArentEquals() {
        CharacterGroup o1 = new CharacterGroup();
        assertNotEquals(o1, new String());
    }

    @Test
    public void givenSameObjReturnSameHashCode() {
        CharacterGroup o1 = new CharacterGroup();
        CharacterGroup o2 = new CharacterGroup();
        assertEquals(o1.hashCode(), o2.hashCode());
    }

}