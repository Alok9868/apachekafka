package com.example.apachekafka.kafka.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class User {

    private int id;
    private String firstName;
    private String lastName;

}
