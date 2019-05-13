package me.mikedeakin.fluentsql;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SqlBuilderTest {

    @Test
    void shouldBuildSimpleSelectStatement() {
        assertThat(SqlBuilder
            .select("*")
            .from("table_name")
            .build()
        ).isEqualTo("SELECT * FROM table_name");
    }

    @Test
    void shouldBuildSelectStatementWithColumnNames() {
        assertThat(SqlBuilder
            .select("column1", "column2", "column3")
            .from("table_name")
            .build()
        ).isEqualTo("SELECT column1, column2, column3 FROM table_name");
    }

    @Test
    void shouldBuildSelectStatementWithWhereClause() {
        assertThat(SqlBuilder
            .select("column1", "column2")
            .from("table_name")
            .where("column1 > 6")
            .build()
        ).isEqualTo("SELECT column1, column2 FROM table_name WHERE column1 > 6");
    }

    @Test
    void shouldBuildSelectStatementWithAdditionalWhereClauses() {
        assertThat(SqlBuilder
            .select("column1", "column2")
            .from("table_name")
            .where("column1 > 6")
            .andWhere("column2 < 32")
            .andWhere("column2 > 0")
            .build()
        ).isEqualTo("SELECT column1, column2 FROM table_name WHERE column1 > 6 AND column2 < 32 AND column2 > 0");
    }

    @Test
    void shouldBuildSelectStatementWithInnerJoin() {
        assertThat(SqlBuilder
            .select("*")
            .from("some_table")
            .innerJoin("another_table")
            .on("some_table.col1 = another_table.col1")
            .build()
        ).isEqualTo("SELECT * FROM some_table INNER JOIN another_table ON some_table.col1 = another_table.col1");
    }
}
