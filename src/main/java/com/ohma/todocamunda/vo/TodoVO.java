package com.ohma.todocamunda.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TodoVO {
    private Long id;
    private String title;
    private String description;
    private Timestamp createDateTime;
    private Timestamp startDateTime;
}
