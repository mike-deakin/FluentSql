package io.mikedeakin.fluentsql.clauses;

public interface OnClause extends CanWhere, TerminatingClause {

    OnClause andOn(String predicate);
}