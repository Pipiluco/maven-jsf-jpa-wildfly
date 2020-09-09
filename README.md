## Configurações para Datasource MySQL com Wildfly
<ul>
	<li>Criar o diretório no servidor Wildfly conforme mostrado abaixo</li>
		<p>Exemplo: C:\Servidores web\wildfly-17.0.1.Final\modules\system\layers\base\com\mysql\main</p>
	<li>Adcionar o .jar driver do MySQL na pasta 'main'</li>
	<li>Criar o arquivo module.xml na pasta main conforme abaixo</li>
		'''
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
		'''
</ul>

