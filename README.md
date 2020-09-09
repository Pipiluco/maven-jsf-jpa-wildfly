## Configurações para Datasource MySQL com Wildfly

- Criar o diretório no servidor Wildfly conforme mostrado abaixo
		<p>Exemplo: C:\Servidores web\wildfly-17.0.1.Final\modules\system\layers\base\com\mysql\main</p>
- Adcionar o .jar driver do MySQL na pasta 'main'
- Criar o arquivo module.xml na pasta main conforme abaixo
### module.xml
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


