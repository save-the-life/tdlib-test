package com.slfoundation.tdlib_test.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    private String telegramId;

}
