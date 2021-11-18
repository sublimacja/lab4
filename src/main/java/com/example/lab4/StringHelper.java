package com.example.lab4;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@AllArgsConstructor

@JsonPropertyOrder({"upperCounter", "lowerCounter", "digitCounter", "specialCounter", "ownCombinationCounter"})
public class StringHelper {

    private String upperCounter;

    private String lowerCounter;

    private String digitCounter;

    private String specialCounter;

    private String ownCombinationCounter;
}
