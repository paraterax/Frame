/**
 * com.paratera.user.dao
 * HsqlDataTypeFactory.java
 * 
 * 2015年7月27日
 * 2015北京并行科技公司-版权所有
 * 
 */
package com.paratera.AutoReport.dao;

import java.sql.Types;

import org.dbunit.dataset.datatype.DataType;
import org.dbunit.dataset.datatype.DataTypeException;
import org.dbunit.dataset.datatype.DefaultDataTypeFactory;

/**
 * @author chenchao@paratera.com
 *
 */
public class HsqlDataTypeFactory extends DefaultDataTypeFactory {

    @Override
    public DataType createDataType(int sqlType, String sqlTypeName) throws DataTypeException {
        if (sqlType == Types.BOOLEAN) {
            return DataType.BOOLEAN;
        }

        return super.createDataType(sqlType, sqlTypeName);
    }
}