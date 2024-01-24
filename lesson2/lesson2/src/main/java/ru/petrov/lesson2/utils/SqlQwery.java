package ru.petrov.lesson2.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "sql.qwery")
@Data
public class SqlQwery {

    private String findall;
    private String save;
    private String delete;
    private String getbyid;
    private String update;
}
