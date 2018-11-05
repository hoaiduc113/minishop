package com.hoaiduc.core.constant;

import java.util.Map;

public class CoreConstant
{
    public static final String LINK="http://localhost:8080/ajax/api/";
    public static final int MAXIEM=4;
    public static final double MAXPAGINATION=4;
    public static final String SORT_ASC="1";
    public static final String SORT_DESC="2";
    public static final int MAXRESULT=1;
    public static Object[] buildNameQuery(Map<String,Object> property)
    {
        //namequery is the query sql
        //the first position  is the name coloum in table sql
        //the second user transmission
        StringBuilder nameQuery=new StringBuilder();
        if(property!=null && property.size()>0)
        {
            String[] params=new String[property.size()];
            Object[] values=new Object[property.size()];
            int i=0;
            for(Map.Entry item:property.entrySet())
            {
                params[i]=(String) item.getKey();
                values[i]=item.getValue();
                i++;
            }
            for(int i1=0;i1<params.length;i1++)
            {
                nameQuery.append(" and ").append(" LOWER("+params[i1]+") LIKE '%' || :"+params[i1]+" || '%'");

            }
            return new Object[]{nameQuery,params,values};
        }
        return new Object[]{nameQuery.toString()};

    }
}
