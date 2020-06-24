package com.janguo.javabasic.concurrent.jucutils.aqs.example3;

public class Table {

    private String tableName;
    private long sourceRecordCount = 10;
    long targetCount;
    private String sourceColumnsSchema = "table:{name,column{name,type}}";
    public String targetColumnsSchema;

    public Table(String tableName, long targetCount) {
        this.tableName = tableName;
        this.targetCount = targetCount;
    }

    public String getTableName() {
        return tableName;
    }

    @Override
    public String toString() {
        return "Table{" +
                "tableName='" + tableName + '\'' +
                ", sourceRecordCount=" + sourceRecordCount +
                ", targetCount=" + targetCount +
                ", sourceColumnsSchema='" + sourceColumnsSchema + '\'' +
                ", targetColumnsSchema='" + targetColumnsSchema + '\'' +
                '}';
    }
}
