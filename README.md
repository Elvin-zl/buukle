# 布壳儿(三期)
>二期线上地址: [布壳儿](http://www.buukle.top/)
## 0 背景
### 0.1 项目简介
````
布壳儿--由elvin(email: 18001268330@163.com)独立开发的开源项目.
目的是为java开发工程师提供一个站点.在布壳儿,我们能分享交流自己的学习经验,技术心得.

````
### 0.2 本期开发要点
````
对二期技术升级 :
    0. springboot 总包升级到最新发行版 [2.1.1.RELEASE];
    1. security系统改造,采用springboot 基于redis session共享;
    2. 登录逻辑统一处理,采用passport子域名+returnUrl处理;
    
对二期项目结构重构 : 
    1. 项目架构重新组织,增强了系统基础健壮能力;
    2. 添加新的文档目录,对文档规进行新一轮规范化,并梳理总结方法论;
    3. 重新设计数据库表结构,增加了权限系统的表复杂度,简化了权限系统操作难度.修复了bug;
    4. 考虑了用户行为等数据分析相关因素;
    5. 尝试加入了浅商业化交易设计.
````

## 1 技术选型
````
springBoot[2.1.1.RELEASE]  +spring-cloud + mybatis[1.3.1] 

````
## 2 项目架构

### 2.1 sms(security_manager_system) (alias : 天兵)
````
权限管理 : 
    用户角色管理,角色资源管理,统一登录认证,会话的统计与管理(如 : session 统计在线人数),数据隔离,等功能.
    待作逻辑 : 
        <1> 用户初始化,设置默认角色.
        <2> 应用初始化,自动为系统用户配置超管角色.
        <3> 菜单&组件,按钮初始化,自动为系统用户在该应用下的超管角色分配资源,自动更新在线相关用户的 session.
        <4> 更新在线用户session需要使用消息转异步操作,此时需要任务调度机制,以保证异步逻辑执行的可追溯性.
        <5> 第三方交互 : 被第三方应用调用认证校验,主动调用第三方所需认证凭证管理.
````
### 2.2 cms(content_manager_system) (alias : cms)
````
内容管理系统:
    运营人员使用,主要包括文章的审核,评论的审核,商品的审核,等.
````
### 2.3 dsc(data_search_center) (alias : 海浪)
````
数据检索中心:
    基于elsearch,为其他应用提供检索服务;
    记录用户的检索足迹;
````
### 2.4 srs(strategy_recommend_center) (alias : 神荐)
````
策略推荐中心:
    基于推荐模型和用户的行为,检索等足迹为用户计算推荐;
````
### 2.4 www 
````
门户:
    用户可以发布,浏览 -- 文章,评论;到达一定级别后也可以发布,下单商品.
````
### 2.5 pc(payment_center) (alias : 支付中心)
````
支付中心:
    处理用户发起的支付请求
````
### 2.6 tc(trade_center) (alias : 交易中心)
````
交易中心:
    记录用户的交易数据,轨迹等
````
### 2.7 wjs(worker_job_system) (alias : 任务系统)
````
任务系统:
    基于spring-quartz,zookeeper集成分布式任务调度中心
````
### 2.8 msgs(message_system) (alias : 百发触达)
````
触达系统:
    基于 redis/rabbitMQ 等消息中间件集成分布式消息管理中心
````
### 2.9 mis(monitor_system) (alias : 天眼)
````
监控系统:
    基于java-agent集成可配置的java探针应用,用于监控系统健康,关键接口调用和预警通知.
````
### 2.10 wfs(workflow_system) (alias : workflow)
````
工作流系统
````
### 2.11 regc(register_center) (alias : 注册中心)
````
注册中心:
    基于springboot集成euraka,监控各个应用的状态.
````
### 2.12 gates(gateway_system) (alias : 盖亚)
````
网关:
    基于springboot集成gateway,用于限流,熔断,降级等网关层操作.
````
## 3 基于frp穿透内网的部署方案

````
    拟采用 : 本地服务器集群 + 公网ip服务器 + frp接口代理 方案
````


