/**
 * 
 */
package kr.or.connect.boardserver;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author 2983r
 * DataSource에 대한 설정. @Configuration
 * Bean 자동 등록 등. @ComponentScan
 * (BookDao의 생성자에 DataSource 객체를 넘겨서 주입하는 과정+BookDao를 @Bean 애너테이션을 이용해서 등록하는 과정)
 * DB커넥션 정보 참조 @PropertySource, @Value
 */
@Configuration
@ComponentScan
@PropertySource("application.properties")
public class AppConfig {
	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.password}")
	private String password;
	
	/**
	 * DataSource를 생성하는 역할을 Spring에서 제공하는 ApplicationContext에 맡긴다: spring-context 의존성 추가(pom.xml)
	 * Spring의 ApplicationContext에서 관리할 대상 객체라는 것을 알리기 위해 @Configuration, @Bean 선언 추가
	 * 여기에서 선언된 객체는 ApplicationContext를 거쳐서 BookLauncher에서 참조
	 */
	public AppConfig() {
		// TODO Auto-generated constructor stub
	}
	
	@Bean
	public DataSource dataSource() {
 		BasicDataSource dataSource = new BasicDataSource();
 		dataSource.setDriverClassName(driverClassName); //"org.h2.Driver"
 		dataSource.setUrl(url); //"jdbc:h2:~/javaweb/db;AUTO_SERVER=TRUE;DB_CLOSE_ON_EXIT=FALSE;"
 		dataSource.setUsername(username); //"sa"
 		dataSource.setPassword(password); //"sa"
  		return dataSource;
 	}
	
	/**
	 * 통합 테스트에서 DB트랜잭션 롤백
	 * @return
	 */
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
}
