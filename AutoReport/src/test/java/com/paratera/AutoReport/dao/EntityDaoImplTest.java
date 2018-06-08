package com.paratera.AutoReport.dao;

import javax.sql.DataSource;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


@ContextConfiguration(classes = { HibernateTestConfig.class })
public abstract class EntityDaoImplTest extends AbstractTransactionalTestNGSpringContextTests {

    @BeforeClass
    public void init() {

    }
	@Autowired
	DataSource dataSource;

	@BeforeMethod
	public void setUp() throws Exception {
		IDatabaseConnection dbConn = new DatabaseDataSourceConnection(
				dataSource);
		DatabaseConfig config = dbConn.getConfig();
		config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new HsqlDataTypeFactory());
		DatabaseOperation.CLEAN_INSERT.execute(dbConn, getDataSet());
	}
	
	protected abstract IDataSet getDataSet() throws Exception;

}