`Spring Cloud Config`为服务端和客户端提供了分布式系统的外部化配置支持。配置服务器为各应用的所有环境提供了一个中心化的外部配置。它实现了对服务端和客户端对Spring Environment和PropertySource抽象的映射，所以它除了适用于Spring构建的应用程序，也可以在任何其他语言运行的应用程序中使用。作为一个应用可以通过部署管道来进行测试或者投入生产，我们可以分别为这些环境创建配置，并且在需要迁移环境的时候获取对应环境的配置来运行。

配置服务器默认采用git来存储配置信息，这样就有助于对环境配置进行版本管理，并且可以通过git客户端工具来方便的管理和访问配置内容。当然他也提供本地化文件系统的存储方式，下面从这两方面介绍如何使用分布式配置来存储微服务应用多环境的配置内容。

### 构建Config Server
通过Spring Cloud构建一个Config Server，非常简单，只需要三步：
* pom.xml中引入spring-cloud-config-server依赖，完整依赖配置如下：
```
<parent>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-parent</artifactId>
	<version>1.3.5.RELEASE</version>
	<relativePath/> <!-- lookup parent from repository -->
</parent>

<dependencies>

	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-test</artifactId>
		<scope>test</scope>
	</dependency>

	<dependency>
		<groupId>org.springframework.cloud</groupId>
		<artifactId>spring-cloud-config-server</artifactId>
	</dependency>

</dependencies>

<dependencyManagement>
	<dependencies>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-dependencies</artifactId>
			<version>Brixton.RELEASE</version>
			<type>pom</type>
			<scope>import</scope>
		</dependency>
	</dependencies>
</dependencyManagement>

```
* 创建Spring Boot的程序主类，并添加`@EnableConfigServer`注解，开启Config Server
```
@EnableConfigServer
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class).web(true).run(args);
	}

}

```
* application.properties中配置服务信息以及git信息，例如：
```
spring.application.name=config-server
server.port=7001

# git管理配置
spring.cloud.config.server.git.uri=http://git.oschina.net/didispace/SpringBoot-Learning/
spring.cloud.config.server.git.searchPaths=Chapter9-1-4/config-repo
spring.cloud.config.server.git.username=username
spring.cloud.config.server.git.password=password

```

* spring.cloud.config.server.git.uri：配置git仓库位置
* spring.cloud.config.server.git.searchPaths：配置仓库路径下的相对搜索位置，可以配置多个
* spring.cloud.config.server.git.username：访问git仓库的用户名
* spring.cloud.config.server.git.password：访问git仓库的用户密码



