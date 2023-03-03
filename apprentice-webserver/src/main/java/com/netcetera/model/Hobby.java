package com.netcetera.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Hobby {
    private String sportname;
    private boolean individualSport;
    private boolean teamSport;
}
