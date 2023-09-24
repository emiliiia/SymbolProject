package org.symbolBackEnd.utils;
import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.Locale;

/*
  @author emilia
  @project SymbolProject
  @class QueryHelper
  @version 1.0.0
  @since 09.09.2023 - 14:50
*/

public class QueryHelper {
    private QueryHelper() {
        throw new UnsupportedOperationException();
    }

    public static Predicate ilike(Path<String> path, CriteriaBuilder criteriaBuilder, String value) {
        return criteriaBuilder.like(criteriaBuilder.lower(path), "%" + value.toLowerCase(Locale.ROOT) + "%");
    }


    public static Predicate full(Path<String> path, CriteriaBuilder criteriaBuilder, String value) {
        return new FullTextSearchPred((CriteriaBuilderImpl) criteriaBuilder, path.as(String.class), "to_tsquery('english','" + value + "')");
    }
}
