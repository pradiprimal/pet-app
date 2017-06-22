package com.generic.search.common;

import com.generic.search.entity.College;

import java.util.Map;

/**
 * Created by pradip on 6/22/17.
 * Email pradip@drac.com.np
 */
public abstract class SearchQueryBuilder {

    protected Map<String, String> searchQueryParameter;

    protected Class className;

    private int checkLoopIteration = 0;


    public String searchQuery() {
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT entity FROM ").append(this.className.getCanonicalName()).append(" entity WHERE ");
        for (Map.Entry entry : searchQueryParameter.entrySet()) {
            buildQuery(entry, builder);
        }
        this.checkLoopIteration = 0;
        return builder.toString();
    }

    public StringBuilder buildQuery(Map.Entry entry, StringBuilder query) {
        if (entry.getKey() != null && !entry.getKey().toString().isEmpty()) {
            if (entry.getValue() != null && !entry.getValue().toString().isEmpty()) {
                this.checkLoopIteration++;
                System.out.println(checkLoopIteration);
                if (this.checkLoopIteration > 1) {
                    query.append(" AND ");
                }
                query.append("entity.").append(entry.getKey()).append("='").append(entry.getValue()).append("'");
            }
        }
        return query;
    }

    public static void main(String[] args) throws NoSuchFieldException {
        Class aClass = College.class;
        System.out.println(aClass.getCanonicalName());

//        for(Field field:aClass.getDeclaredFields()){
//            System.out.println(field);
//        }
    }
}
