package com.javarush.task.task25.task2503;

import java.util.LinkedList;
import java.util.List;

public enum Column implements Columnable {
    Customer("Customer"),
    BankName("Bank Name"),
    AccountNumber("Account Number"),
    Amount("Available Amount");

    private String columnName;

    private static int[] realOrder;

    Column(String columnName) {
        this.columnName = columnName;
    }

    /**
     * Задает новый порядок отображения колонок, который хранится в массиве realOrder.
     * realOrder[индекс в энуме] = порядок отображения; -1, если колонка не отображается.
     *
     * @param newOrder новая последовательность колонок, в которой они будут отображаться в таблице
     * @throws IllegalArgumentException при дубликате колонки
     */
    public static void configureColumns(Column... newOrder) {
        realOrder = new int[values().length];
        for (Column column : values()) {
            realOrder[column.ordinal()] = -1;
            boolean isFound = false;

            for (int i = 0; i < newOrder.length; i++) {
                if (column == newOrder[i]) {
                    if (isFound) {
                        throw new IllegalArgumentException("Column '" + column.columnName + "' is already configured.");
                    }
                    realOrder[column.ordinal()] = i;
                    isFound = true;
                }
            }
        }
    }

    /**
     * Вычисляет и возвращает список отображаемых колонок в сконфигурированом порядке (см. метод configureColumns)
     * Используется поле realOrder.
     *
     * @return список колонок
     */
    public static List<Column> getVisibleColumns() {
        List<Column> result = new LinkedList<>();
        for (int i = 0; i < values().length; i++) {
            for (int j = 0; j < realOrder.length; j++) {
                if (realOrder[j] == i) {
                  result.add(values()[j]);
                  //  Column column = values()[j];
                    //result.add(new Column(values()[j].toString()));
                }
            }
        }
      //  System.out.println(result.toString());
        return result;
    }

    @Override
    public String getColumnName() {
        return columnName;
    }

    @Override
    public boolean isShown() {
if (realOrder[this.ordinal()] >= 0){
    return true;
}
else {
    return false;
}

        //Метод Column.isShown должен возвращать true, если колонка видимая, иначе false.

    }

    @Override
    public void hide() {
        for (int i = 0; i < realOrder.length; i++) {

            if (realOrder[i] > realOrder[this.ordinal()]){
                realOrder[i] = realOrder[i] - 1;
            }
        }
        realOrder[this.ordinal()] = -1;
    }
}
