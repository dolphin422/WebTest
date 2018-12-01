# dolphin
Spring Boot Maven Web

---
## 项目说明
  简单的SpringBoot项目,Maven构建,不断丰富中

## 项目结构
	|--dolphin (pom-parent)
	    |--dolphin-web (war)
		|--dolphin-business (pom)
			|--dolphin-business-controller (jar)
			|--dolphin-business-service-api (jar)
			|--dolphin-business-service-impl (jar)
			|--dolphin-business-dao-api (jar)
			|--dolphin-business-dao-mysql(oracle) (jar)  
			|--dolphin-business-model (jar)
		|--dolphin-system (pom)
			|--dolphin-system-controller (jar)
			|--dolphin-system-service-api (jar)
			|--dolphin-system-service-impl (jar)
			|--dolphin-system-dao-api (jar)
			|--dolphin-system-dao-mysql(oracle) (jar)  
			|--dolphin-system-model (jar)
		|--dolphin-common (jar)
        

## 组件
组件名称 | 版本 
---- | ---- 
SpringBoot|2.1.0.RELEASE
JDK|1.8|
MySQL JDBC|5.1.30
Mybatis|1.3.1|
druid|1.1.10|
tk.mapper|2.0.2|
MybatisGenerator|1.3.5|




