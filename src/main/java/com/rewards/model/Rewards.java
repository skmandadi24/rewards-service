package com.rewards.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import javax.persistence.Transient;

public class Rewards {

    @Getter
    @JsonInclude
    @Transient
    protected Long points;

}
