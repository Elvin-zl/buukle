# 布壳儿项目(二期)
>一期线上地址: [布壳儿](https://www.buukle.top/)
## 0. 背景
### 0.1 项目简介
````
布壳儿项目(以下简称"布壳儿")目前是一个在萌芽状态的,开源,免费,公益性质的java在线分享项目.
由@elvin(email: 18001268330@163.com)独立开发.目的是为java开发工程师提供一个小小的站
点.在布壳儿,java er们能分享交流自己的学习经验,技术心得.同时能有一个空间记录开发生活中发
生想要记录的事情的照片流.

````
### 0.2 本期开发需求要点
````
对一期技术升级:
    1. dubbo --> spring-cloud 添加restful接口支持;
    2. ssm   --> springBoot [2.0.5] + spring-data-mybatis 发布形式改为jar包部署发布;
对一期项目结构重构 : 
    1. 拆分buukle-common,buukle-consumer,buukle-provider,buukle-plugin,项目
    2. 重构项目子父结构 (优化资源包分布,项目结构,调用链路,以及安全模块的插件化)
    3. 添加接口验签,用户敏感接口验签逻辑
    
````

## 1. 技术选型
````
springBoot[2.0.5.RELEASE]  +spring-cloud + mybatis[1.3.1] 

````
## 2. 项目搭建
###2.1 项目结构:
buukle-all\
&nbsp;&nbsp;&nbsp;|---buukle-all\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|---------buukle-common\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|---------buukle-eureka\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|---------buukle-gateway\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|---------buukle-plugin\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|------buukle-plugin-mq\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|------buukle-plugin-security\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|---------buukle-provider\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|------buukle-provider-security\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|---------buukle-consumer\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|---------buukle-consumer-cms\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|---------buukle-consumer-portal\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|---------buukle-consumer-article\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|---------buukle-consumer-album\
&nbsp;&nbsp;&nbsp;|---buukle-generator-all\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|---------buukle-generator-entityToDataBase\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|---------buukle-generator-mybatisGUI\

###2.2 buukle 项目总工程
````
1. 此文件包含两个子文件，buukle-all文件是buukle项目主工程;buukle-generator-all 是buukle项目辅助工程,用于生成一些主工程中
用到的文件和代码.

````
###2.2.1 buukle-all 布壳儿项目主工程(pom)
````
1. 依赖spring-boot-parent ,为项目提供boot环境
2. 集中统一管理依赖版本
3. 按照2.中的版本号,集中依赖公用类库,为项目和子工程提供web环境

````
###2.2.1.1 buukle-common 工具包工程 (jar)
````
此工程主要为项目提供常规工具,例如 : 
1. baseRequest : 封装请求类,其实例包含两个部分,即 自定义类型requestHead 和 
   泛型类型(T)info参数对象,其主要用于在项目间沟通时,传递调用方基本信息和请求参数,baseResponse 则封装被调用方响应的基本信息和数据.
2. baseException 全局异常的自定义相关,用于项目工程自身之内,以及工程之间的异常处理和传递.
3. util子包下一些常规工具类,例如:
    <1> springContextUtil(继承ApplicationContextAware) 用于灵活处理spring容器级别的bean对象;
    <2> SpringEnvironmentUtil(继承EnvironmentAware) ,此对象维护了系统配置文件:application.properties
    或application.yml以及placeholder声明的一些配置文件,配置bean中的参数.作为properties中的key,value存储;
    (详细可看 EnvironmentAware/Environment 类源码) 用于灵活处理spring Environment对象中的参数;应用此对象
    可对apring环境变量(Environment)进行操作,从而达到一些不常用的目的.(比如,动态指定requestMapping的映射路径)
    <3> ThreadLocalUtil(继承ThreadLocal) 用于灵活处理线程级别的参数;
    <4> jedis子包下,利用模板模式封装spring-data-redis的api,更加方便的使用redis命令如RedisString等;
        其中也封装了jedis的一些功能工具模块,开发者可直接用工厂+ 模板类通过编写回调逻辑直接使用分布式锁等工具;
    ......
````
###2.2.1.2 buukle-eureka 程序注册监控管理中心 (executable jar)

````
此工程主要管理项目中所有的feign-Client服务状态 : 
    <1>  通过cloud集成提供的一些服务,监控和管理各个应用的活动和状态;
        
````
###2.2.1.3 buukle-gateway 网关服务(executable jar)

````
    <1> 为网站提供入口服务
    <2> 为网站访问提供监控服务
    <3> 为网站访问提供熔断服务
    <4> 为网站访问提供负载服务
        .....
````
###2.2.1.4 buukle-plugin 插件工程(pom)

####此工程主要管理项目中所有的插件工具,目前主要分为以下两个工程(可根据需求扩展)
####2.2.1.4.1 buukle-plugin-mq 消息插件

````
此工程负责提供相应的消息工具,例如 :
    <1> 单点退出时,发通知广播其他应用及时下线;
    <2> 接受第三方异步通知的消息内容,并做后续处理
````
####2.2.1.4.2 buukle-plugin-security 单点登陆&授权接入插件(jar)
````
此工程负责提供单点登录功能的接入 :
    <1> 该插件通过spring拦截器(inteceptor)实现,应用可通过配置相应的interceptor,传入指定的参数即可接入;
    <2> 传入参数可通过配置文件,也可在直接在代码中用@bean,或者直接new配置;

此工程负责提供认证授权功能 :
    <1> 该插件通过拦截请求,验证用户的cookie缓存的用户信息,并对uri作权限验证 
````
###2.2.1.5 buukle-provider 生产者父工程 (pom)

此工程负责管理所有的生产者服务工程

####2.2.1.5.2 buukle-provider-security 安全中心工程 (executable jar)
````
    1. 提供接口验签服务
    2. 此工程主要为项目提供单点登录数据处理服务
    3. 为应用,用户配置权限
    4. 为请求作认证授权
````

###2.2.1.6 buukle-consumer 消费者父工程 (pom)

此工程负责管理所有的生产者服务工程

####2.2.1.6.1 buukle-consumer-cms 内容管理系统(executable jar)
````
此工程主要为项目提供内容后台管理服务

    不同身份角色的用户,通过不同的菜单按钮实现文章的发布,流程的控制
    等功能,主要分为几个核心模块: 首页 | 文章管理 | 数据统计 | 系统设置 等;分别对应不同的功能和流程;
````
####2.2.1.6.2 buukle-consumer-portal 门户系统(executable jar)
````
 此工程主要为项目提供用户门户服务,未登录用户可通过门户完成 :
        
        1. 首页浏览推送轮播的文章推荐;
        2. 登录门进入门户.
````
####2.2.1.6.3 buukle-consumer-article 文章系统(executable jar)
````
 此工程主要为项目提供文章服务,用户可通过文章系统
 
    1. 应用左侧导航栏以及右侧最新top5挑选喜欢的文章进行浏览;
    2. 通过文章右上方的分享组件,对文章进行分享;
    2. 通过按钮对文章点赞;
    4. (登录后)通过文章下的留言板对问张金祥评论和回复;
    5. (登录后)文章作者可以对评论进项管理;
    6. 后台通过消息处理文章的访问数据等;
     
````
####2.2.1.6.4 buukle-consumer-album 相册系统(executable jar)
````
此工程主要为项目提供相册服务
    暂时只对管理员开放,普通用户无法上传,只能浏览;(考虑到人工审核成本比较大,自动审核风险比较大,暂时不作开放)
````
###2.2.2 buukle-generator-all 布壳儿项目辅助工程(pom)

此工程主要为主工程负责一些生成的服务

####2.2.2.1 buukle-generator-entityToDataBase(main)
````
此工程为主项目提供实体生成数据库的功能
````
####2.2.2.2 buukle-generator-mybatisGUI(main)
````    
此工程为主项目提供生成mybatis资源文件
````
