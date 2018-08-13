package com.example.user.charlesschwabchallenge.utils;

public class QueryBuilder {


    public static String buildWithZip(String zipCode){

        String query = "select * from local.search where zip='";
        query = query + zipCode + "' and query='pizza'";
        return query;

    }

}
