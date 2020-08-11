package ru.schottkey.barberCrm.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class PhoneContact extends Contact {

    private String phoneNumber;

    private boolean canCall;

    private boolean canSms;

    private boolean canWhatsApp;

    @Override
    public String toString() {
        return "PhoneContact{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", canCall=" + canCall +
                ", canSms=" + canSms +
                ", canWhatsApp=" + canWhatsApp +
                ", comment='" + comment + '\'' +
                '}';
    }
}


