package com.maks.JDBC.task2.repository;

import java.sql.SQLException;

public interface MainRepository<T> {
    T save(T object) throws SQLException;
}
