package com.app.Entities;

import java.io.Serializable;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
public class CustomStringIdGeneratorF implements IdentifierGenerator {

    private static final String PREFIX = "F";
    private static int sequence = 1;

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        String uniqueId = String.format("%03d", sequence++);
        return PREFIX + uniqueId;
    }
}








