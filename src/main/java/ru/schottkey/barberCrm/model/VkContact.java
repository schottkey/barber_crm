package ru.schottkey.barberCrm.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class VkContact extends Contact {
    private String address;

    @Override
    public String toString() {
        return "VkContact{" +
                "address='" + address + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
