package Lumiamuyu.utilTest;

import java.sql.ResultSet;

public interface RowMap<T> {
    public T RowMapping(ResultSet resultSet);
}
