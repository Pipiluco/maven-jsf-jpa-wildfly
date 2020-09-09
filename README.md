## Configurações para Datasource MySQL com Wildfly

- Criar o diretório no servidor Wildfly conforme mostrado abaixo
	\wildfly-17.0.1.Final\modules\system\layers\base\com\mysql\main
- Adcionar o .jar driver do MySQL na pasta 'main'
- Criar o arquivo module.xml na pasta main conforme abaixo
	#### module.xml
	~~~xml
	<?xml version="1.0" encoding="UTF-8"?>
	<module xmlns="urn:jboss:module:1.1" name="com.mysql">
		<resources>
			<resource-root path="mysql-connector-java-5.1.47.jar"/>
		</resources>
				 
		<dependencies>
			<module name="javax.api"/>
			<module name="javax.transaction.api"/>
		</dependencies>
	</module>
	~~~
- Dentro da pasta 'main' ficará da seguinte forma:
	#### module.xml
	#### mysql-connector-java-5.1.47.jar

### Próximo passo é criar o datasource e o driver no arquivo standalone.xml
- Caminho do arquivo standalone.xml no servidor Wildfly:
	\wildfly-17.0.1.Final\standalone\configuration

- Inserir o código abaixo dentro da tag datasources
	~~~xml
	<datasource jta="true" jndi-name="java:jboss/datasources/MySQLDS" pool-name="MySQLDS" enabled="true" use-java-context="true" use-ccm="true">
		<!-- Endereço da nossa base de dados -->
		<connection-url>jdbc:mysql://localhost:3306/nome da base?createDatabaseIfNotExist=true</connection-url>
		<driver>mysql</driver>
		<transaction-isolation>TRANSACTION_READ_COMMITTED</transaction-isolation>
		<pool>
			<min-pool-size>10</min-pool-size>
			<max-pool-size>100</max-pool-size>
			<prefill>true</prefill>
		</pool>
		<security>
			<user-name>usuário do banco</user-name>
			<password>senha do banco</password>
		</security>
		<statement>
			<prepared-statement-cache-size>32</prepared-statement-cache-size>
			<share-prepared-statements>true</share-prepared-statements>
		</statement>
	</datasource>
	~~~

- Inserir o código abaixo dentro da tag drivers
	~~~xml
	<driver name="mysql" module="com.mysql">
		<xa-datasource-class>com.mysql.jdbc.jdbc2.optional.MysqlXADataSource</xa-datasource-class>
	</driver>
	~~~

### Próximo passo é adicionar o datasource na tag jta-data-source do arquivo persistence.xml do projeto Java
- Exemplo:
	~~~xml
	<jta-data-source>java:jboss/datasources/MySQLDS</jta-data-source>
	~~~


