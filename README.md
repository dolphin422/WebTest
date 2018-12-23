# dolphin
Spring Boot Maven Web

---
## 项目说明
  SpringBoot项目,Maven构建,不断更新中

## 项目结构
	|--dolphin (pom-parent)
	    |--dolphin-web (war)
		|--dolphin-business (pom)
			|--dolphin-business-controller (jar)
			|--dolphin-business-service-api (jar)
			|--dolphin-business-service-impl (jar)
			|--dolphin-business-dao-api (jar)
			|--dolphin-business-dao-impl (jar)  
			|--dolphin-business-model (jar)
		|--dolphin-system (pom)
			|--dolphin-system-controller (jar)
			|--dolphin-system-service-api (jar)
			|--dolphin-system-service-impl (jar)
			|--dolphin-system-dao-api (jar)
			|--dolphin-system-dao-impl (jar)  
			|--dolphin-system-model (jar)
		|--dolphin-common (jar)
        
## 依赖关系
![项目依赖关系图](https://github.com/dolphin422/github_repository/blob/master/img-folder/dolphin/%E9%A1%B9%E7%9B%AE%E5%8C%85%E4%BE%9D%E8%B5%96%E5%85%B3%E7%B3%BB.png)
## 主要更新
- 1、2018.11.17：创建项目：Springboot2.1.0，JDK1.8，Maven构建，父子工程
- 2、2018.11.23：增加系统包(dolphin-system)简单代码（USER）
- 3、2018.11.26：增加数据源及逆向工程
- 4、2018.11.30：增加日志配置
- 5、2018.12.10：增加业务包(dolphin-business)简单代码(blog)
- 6、2018.12.13：增加自定义异常及状态码类、全局异常处理机制
- 7、2018.12.21：增加Swagger2 RestApi在线文档
- 8、2018.12.23：增加Xss过滤、Sql关键字校验、content-type类型限制




