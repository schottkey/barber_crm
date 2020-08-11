package ru.schottkey.barberCrm.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class InstagramContact extends Contact {
    private String nick;

    @Override
    public String toString() {
        return "InstagramContact{" +
                "nick='" + nick + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
