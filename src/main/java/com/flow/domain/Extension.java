package com.flow.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Extension {
    private Long extensionId;
    private String name;
    private int type;
    private boolean isBlock;
}
