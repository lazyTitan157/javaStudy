/*
 * javax.servlet.ServletContextListener인터페이스를 구현할 클래스 작성
 * web.xml에 그 클래스를 등록(패키지명까지) : jdbc.DBCPInitListener를 등록
 * 웹컨테이너를 구동하면 web.xml에 등록한 DBCPInitListener객체의 contextInitialized()메서드가 실행되면서
 *  커넥션풀을 초기화 한다.
 *   -loadJDBCDriver(), initConnectionPool()메서드가 poolConfig초기화 파라미터를 이용해서
 *    생성한 properties객체로부터 커넥션 풀을 생성하는데 필요한 값을 읽어온다.
 * 참고 : 서블릿3.0부터는 애노테이션을 이용해서 리스너 등록 가능
 * (어노테이션)WebListener //import javax.servlet.annotation.WebListener;   
 *  
 * ServletContextListener인터페이스는 웹 애플리케이션이 시작되거나 종료될 때 호출할 메서드를 정의한 인터페이스,
 * 아래 두개의 메서드를 정의하는 인터페이스 이다
 * public void contextInitialized(ServletContextEvent sce) : 웹어플리케이션 초기화시 호출
 * public void contextDestroyed(ServletContextEvent sce) : 웹애플리케이션 종료시 호출
 * 
 * web.xml에서 설정한 초기화 파라미터 값을 구하는데 servletContext의 메서드
 * String getInitParameter(String name)
 * java.util.Enumeration<String> getInitParameterNames()를 사용한다.
 * 
 * poolConfig 컨텍스트 초기화 파라미터를 이용해서 커넥션 풀을 초기화하는 코드
 */

package jdbc;

import java.io.IOException;
import java.io.StringReader;
import java.sql.DriverManager;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class DBCPInitListener implements ServletContextListener{
	
	@Override
	public void contextInitialized(ServletContextEvent sce){
		//서블릿초기화 파라미터 대신 poolConfig컨텍스트 초기화파라미터를 사용
		String poolConfig = sce.getServletContext().getInitParameter("poolConfig");
		Properties prop = new Properties();
		try{
			//load메서드는 키=값으로 구성된 문자열로부터 프로퍼티를 로딩한다.
			//poolconfig컨텍스트 초기화 파라미터가 키=값 형식이므로 
			//poolconfig초기화파라미터 설정 값을 property객체의 프로퍼티로 등록한다.
			prop.load(new StringReader(poolConfig));
		} catch(IOException e){
			throw new RuntimeException("config load fail",e);
		}
		loadJDBCDriver(prop);
		initConnectionPool(prop);
	}

	private void initConnectionPool(Properties prop) {
		// TODO Auto-generated method stub
		String driverClass = prop.getProperty("jdbcdriver");
		try{
			Class.forName(driverClass);
		} catch(ClassNotFoundException ex){
			throw new RuntimeException("fail to load JDBC Driver", ex);
		}
	}

	private void loadJDBCDriver(Properties prop) {
		// TODO Auto-generated method stub
		try{
			String jdbcUrl = prop.getProperty("jdbcUrl");
			String username = prop.getProperty("dbUser");
			String pw = prop.getProperty("dbPass");
			
			ConnectionFactory connFactory = new DriverManagerConnectionFactory(jdbcUrl, username, pw);
			PoolableConnectionFactory poolableConnFactory 
				= new PoolableConnectionFactory(connFactory, null);
			//poolableConnFactory.setValidationQuery("select 1");
			//커넥션 풀의 커넥션 검사 쿼리를 프로퍼티로 설정하도록 추가
			String validationQuery = prop.getProperty("validationQuery");
			if(validationQuery != null && !validationQuery.isEmpty()){
				poolableConnFactory.setValidationQuery(validationQuery);
			}
			GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
			poolConfig.setTimeBetweenEvictionRunsMillis(1000L*60L*5L);
			poolConfig.setTestWhileIdle(true);
			//최소 유휴 커넥션을 프로퍼티로 설정하도록 추가
			//poolConfig.setMinIdle(4); //기존
			int minIdle = getIntProperty(prop, "minIdle", 5);
			poolConfig.setMinIdle(minIdle);
			//최대 크기를 프로퍼티로 설정하도록 추가
			//poolConfig.setMaxIdle(50); //기존
			int maxTotal = getIntProperty(prop, "maxTotal", 50);
			poolConfig.setMaxTotal(maxTotal);
			
			GenericObjectPool<PoolableConnection> connectionPool =
					new GenericObjectPool<>(poolableConnFactory, poolConfig);
			poolableConnFactory.setPool(connectionPool);
			
			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			PoolingDriver driver = (PoolingDriver)DriverManager.getDriver("jdbc:apache:commons:dbcp:");
			String poolName = prop.getProperty("poolName");
			driver.registerPool(poolName, connectionPool);
		} catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	private int getIntProperty(Properties prop, String propName, int defaultValue) {
		// TODO Auto-generated method stub
		String value = prop.getProperty(propName);
		if(value == null) return defaultValue;
		return Integer.parseInt(value);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce){
		
	}
}