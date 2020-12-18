# 一步一步構建 maven 專案
---
# 安裝Maven
``` bash
sudo apt install maven
```
# 環境變數檢查

## java -vetsion

```
java version "1.8.0_261"
Java(TM) SE Runtime Environment (build 1.8.0_261-b12)
Java HotSpot(TM) 64-Bit Server VM (build 25.261-b12, mixed mode)
```
## javac -version
```
javac 1.8.0_261
```

## mvn -v
```
Maven home: C:\Users\User\work\tool\apache-maven-3.6.3\bin\..
Java version: 1.8.0_261, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk1.8.0_261\jre
Default locale: zh_TW, platform encoding: MS950
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows" 
```


# Folder 結構
---
```
Hello
|------src
|------|------main
|------|------|------java
|------|------|------resources
|------|------test
|------|------|------java
|------|------|------resources
|------pom.xml

```

# Hello Project
___
## 先新增所需的檔案夾 Hello/src/java ...
___
## 在 Hello 根目錄新增 pom.xml 檔案
```xml 
<?xml version="1.0" ?>
<project xmlns="http://maven.apache.org/POM/4.0.0" 
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>tw.org.itri</groupId>
    <artifactId>Hello</artifactId>
    <version>0.0.1-SNAPSHOT</version>

    <name>Hello</name>

    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.0</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
    <properties>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
    </properties>
    </project>
```

## 如果使用的java是11以上，請在pom.xml內加入以下的程式碼
```xml
<properties>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
</properties>
```
___

## 在 src/main/java/tw/org/itri 目錄下新增文件 Hello.java
``` java
package tw.org.itri;

public class Hello {
    public String sayHello() {
        return "Hello " + getFriendName();
    }

    public String getFriendName() {
        return "John";
    }

    public static void main(String[] args) {
        Hello hello = new Hello();
        System.out.println(hello.sayHello());
    }
}
```

___
## 在 src/test/java/tw/org/itri 目錄下新增文件 HelloTest.java
```java
package tw.org.itri;

import org.junit.Test;
import static junit.framework.Assert.*;

public class HelloTest {
    @Test
    public void testSayHello() {
        Hello hello = new Hello();
        String results = hello.sayHello();
        assertEquals("Hello John", results);
    }

    @Test
    public void testGetFriendName() {
        Hello hello = new Hello();
        String results = hello.getFriendName();
        assertEquals("John", results);
    }
}
```

## 使用 mvn compile 測試
## 使用 mvn test 測試
## 使用 mvn package 測試

## 執行程式
``` sh
    mvn exec:java -Dexec.mainClass="tw.org.itri.Hello"
```
## 也可以帶參數跑

``` sh
    mvn exec:java -Dexec.mainClass="tw.org.itri.Hello" -Dexec.args="arg0 arg1 arg2"
```
<br />
<br />
<br />

# HelloFriend Project
___
## 在 HelloFriend 根目錄新增 pom.xml 檔案
```xml 
<?xml version="1.0" ?>
<project xmlns="http://maven.apache.org/POM/4.0.0" 
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>tw.org.itri</groupId>
    <artifactId>HelloFriend</artifactId>
    <version>0.0.1-SNAPSHOT</version>

    <name>HelloFriend</name>

    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.0</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>tw.org.itri</groupId>
            <artifactId>Hello</artifactId>
            <version>0.0.1-SNAPSHOT</version>
            <scope>compile</scope>
        </dependency>
    </dependencies>
    <properties>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
    </properties>
</project>
```
## 在 src/test/java/tw/org/itri 目錄下新增文件 HelloFriend.java
``` java
package tw.org.itri;

import tw.org.itri.Hello;

public class HelloFriend {
    public String sayHelloToFriend() {
        Hello hello = new Hello();
        String str = hello.sayHello() + this.sayMyName();
        return str;
    }

    public String sayMyName() {
        return ", I'm Austin";
    }
}
```

___
## 在 src/test/java/tw/org/itri 目錄下新增文件 HelloFriendTest.java
```java
package tw.org.itri;

import org.junit.Test;
import static junit.framework.Assert.*;
import tw.org.itri.Hello;

public class HelloFriendTest {
    @Test
    public void testSayHelloToFriend() {
        HelloFriend helloFriend = new HelloFriend();
        String results = helloFriend.sayHelloToFriend();
        assertEquals("Hello John, I'm Austin", results);
    }

    @Test
    public void testSayMyName() {
        HelloFriend helloFriend = new HelloFriend();
        String results = helloFriend.sayMyName();
        assertEquals(", I'm Austin", results);
    }
}
```
## 編譯程式-> 發生錯誤
## 至Hello Project 執行 mvn install
``` sh
cd ../Hello
mvn install
```
___
# Ecilpse 上開發設定
* 先清空m2資料的東西

* Maven setting
___
## 在 maven conf/settings.xml 內的 profiles 區塊內新增
```xml
    <profile>
      <id>jdk-1.8</id>

      <activation>
        <activeByDefault>true</activeByDefault>
        <jdk>1.8</jdk>
      </activation>

      <properties>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
        <maven.compiler.compilerVersion>1.8</maven.compiler.compilerVersion>
      </properties>
    </profile>

```

# MakeFriends Project
___
## 在 src/test/java/tw/org/itri 目錄下新增文件 MakeFriends.java
```java
package tw.org.itri;

public class MakeFriends {

	public String makeFriends() {
		HelloFriend friend = new HelloFriend();
		friend.sayHelloToFriend();
		String str = friend.sayHelloToFriend() + sayNiceToMeetYou();
		return str;
	}

	public String sayNiceToMeetYou() {
        return ". Nice to meet you!";
	}

	public static void main(String[] args) {
        MakeFriends makeFriends = new MakeFriends();
        System.out.println(makeFriends.makeFriends());
    }

}

```

## 在 src/test/java/tw/org/itri 目錄下新增文件 MakeFriendsTest.java
```java
package tw.org.itri;
import org.junit.Test;
import static junit.framework.Assert.*;

public class MakeFriendsTest {

    @Test
    public void testMakeFriends() {
        MakeFriends makeFriends = new MakeFriends();
        String results = makeFriends.makeFriends();
        assertEquals("Hello John, I'm Austin. Nice to meet you!", results);
    }

    @Test
    public void testSayNiceToMeetYou() {
        MakeFriends makeFriends = new MakeFriends();
        String results = makeFriends.sayNiceToMeetYou();
        assertEquals(". Nice to meet you!", results);
    }
}
```

## 在 pom.xml 內新增

``` xml
	<dependencies>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.0</version>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>tw.org.itri</groupId>
			<artifactId>HelloFriend</artifactId>
			<version>0.0.1-SNAPSHOT</version>
			<type>jar</type>
			<scope>compile</scope>
		</dependency>
	</dependencies>
```
---
# 可以嘗試
* build project from cmd

* import existing maven project
---


# Hello Project - 依賴的傳遞性
___
## 在 Hello/pom.xml 內新增
#### 可以看到之後的 HelloFriend && MakeFriends 都有依賴 
```		
        <!-- https://mvnrepository.com/artifact/org.springframework/spring-core -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-core</artifactId>
			<version>5.2.5.RELEASE</version>
		</dependency>
        <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>8.0.19</version>
		</dependency>

```
# 配置聚合 Parent Project
___
## 創建一個 pom 的 Maven Project
```xml
    <!-- 配置聚合 -->
	<modules>
		<module>../Hello</module>
		<module>../HelloFriend</module>
		<module>../MakeFriends</module>
	</modules>

```

# Web101 Project
___
## Fix eclipse web project issue
-> 只建立了 web app 就宣稱自己是 web project

-> 記得打勾 generate web.xml deployment descriptor

* 會在 WEB-INF 內新增 web.xml

* 在新增資料夾下新增 index.jsp 測試用

## 在 web101/pom.xml 內新增
*	注意到! 依賴範圍是 provided

``` xml
	<dependencies>
		<!-- https://mvnrepository.com/artifact/javax.servlet.jsp/javax.servlet.jsp-api -->
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>servlet-api</artifactId>
			<version>2.5</version>
			<scope>provided</scope>
		</dependency>
		<dependency>
			<groupId>javax.servlet.jsp</groupId>
			<artifactId>javax.servlet.jsp-api</artifactId>
			<version>2.3.1</version>
			<scope>provided</scope>
		</dependency>

	</dependencies>
```

## 測試 jsp libary
```
	${pageContext.request.contextPath}
```

> 自動化部屬
```xml
	<build>
		<finalName>Web101</finalName>
		<plugins>
			<plugin>
				<groupId>org.codehaus.cargo</groupId>
				<artifactId>cargo-maven2-plugin</artifactId>
				<version>1.7.6</version>
				<configuration>
					<container>
						<containerId>tomcat9x</containerId>
						<home>D:\program\apache-tomcat-9.0.34</home>
					</container>
					<configuration>
						<type>existing</type>
						<home>D:\program\apache-tomcat-9.0.34</home>
					</configuration>
				</configuration>
				<executions>
					<execution>
						<id>cargo-run</id>
						<phase>install</phase>
						<goals>
							<goal>run</goal>
						</goals>
					</execution>
				</executions>
			</plugin>
		</plugins>
	</build>
```


# 先至 https://start.spring.io 測試一下

* Download data from web

* wget -O demmo.zip https://www.dropbox.com/s/qa5lg6ppqqbtp40/demo.zip?dl=0

</br>
</br>
# Spring101
----
# 安裝 eclipse spring ide plugin
# 撰寫 Controller

## 配置 jsp 目錄
---
```
在src/main/下
新增webapp/WEB-INF/jsp目錄
在src/main/webapp/WEB-INF/jsp目錄下
新增hello.jsp

```

## 配置 application.properties
```
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp
```

## 增加 pom.xml 依賴

``` xml
<dependency>
  <groupId>org.apache.tomcat.embed</groupId>
  <artifactId>tomcat-embed-jasper</artifactId>
</dependency>


```
