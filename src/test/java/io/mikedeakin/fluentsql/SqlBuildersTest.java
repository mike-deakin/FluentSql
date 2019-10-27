package io.mikedeakin.fluentsql;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SqlBuildersTest {

    @Test
    void shouldCreateSelectBuilder() {
        assertThat(SqlBuilders.select("column1", "column2"))
            .isEqualTo(SelectBuilder.select("column1", "column2"));
    }
}