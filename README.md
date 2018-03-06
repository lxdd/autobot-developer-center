# autobot-developer-center
汽车人开发者中心

autobot ： 8403
autobot-res : 8400
api-gateway : 8401
config-server: 8402
eureka-service：8404

#生成非对称秘钥
$ keytool -genkeypair -alias mytestkey -keyalg RSA \
  -dname "CN=Web Server,OU=Unit,O=Organization,L=City,S=State,C=US" \
  -keypass changeme -keystore server.jks -storepass letmein

#config-server 自查路径
http://localhost:8402/autobot-res/dev/master
#config 加密、解密
curl -u user:37cc5635-559b-4e6f-b633-7e932b813f73  http://localhost:8402/encrypt -d lxdyun
curl -u user:37cc5635-559b-4e6f-b633-7e932b813f73 localhost:8402/decrypt -d AQA7cWTu/90Vev/6hg/bifObcROIfDKyxcPvdPqVXH4y2VAv4js0zZIW6OMMJ/wUOATlpwDJ+4NG+0OAPWAaWSSg/YWYqdi1eV+3MoeYx3jVSUxBpjRX1yyd590D+JuyBVNiVFmMc5kRCbw2AviMX0cpRYGCEfXcKsvoICjmb2iUo9RMcvrEcgEpoEu2sLy4uGzfPWSxmO06Y/CF2ds+9Vk9/HxtWYiHmsYq9skY1FserOeJRUvS25s1DyKKTr63zOc7MF1hHb46A4YY0eJdbZ+l4Dh6Vx0hL3gqHutPxK3JWBwBjvJGXr5gj8d2HaV/34ytpo3J+s9HbqDWwegEftLUYBPPdoRb39tVIr44I58M3nzQ/iz7UOI7sCCAIGcdp1U=

#微服务刷新
curl -X POST http://localhost:8400/refresh


#swagger 
http://localhost:8400/swagger-ui.html



#网关zuul  
类似于面向对象设计模式中的Facade模式， 它的存在就像是整个微服务架构系统的门面一样，所有的外部客户端访问都需要经过它来进行调度和过滤。
它除了要实现请求路由、 负载均衡、 校验过滤等功能之外， 还需要更多能力， 比如与服务治理框架的结合、 请求转发时的熔断机制、 服务的聚合等一系列高级功能。将自身注册为Eureka服务治理下的应用， 同时从Eureka中获得了所有其他微服务的实例信息。 这样的设计非常巧妙地将服务治理体系中维护的实例信息利用起来， 使得将维护服务实例的工作交给了服务治理框架自动完成， 不再需要人工介入。
1、用户登录状态token
2、签名校验的机制（为了防止客户端在发起请求时被篡改等安全方面的考虑）



开发里程碑
汽车人开发者中心开发规划
发起人：伟峰、红敏
开发：周勇、李晓东
一、一期开发计划 （--20180308）
1、前端项目搭建 （周勇）-- 100%
2、后端项目搭建、后端架构方案图（李晓东））-- 100%
    Spring Cloud体系 + 适配业务的ADC服务
3、项目界面交互终版 （周勇）-- 100%
  （ 项目管理、目录管理、文档管理、文档模板管理）
4、 markdown效果交互接入 （周勇）-- 80%
5、项目界面前端开发 （周勇）-- 90%
6、项目后端接口开发 （李晓东）-- 90%
7、ADC项目前后端联调（周勇、李晓东 暂未联调 0%
8、接口鉴权过滤器开发 （李晓东） -- 0%
9、Node中间层开发(GraphQL) （周勇）-- 50%
10、站点首页优化（周勇）   -- 40%
11、原有服务HTTP改造 demo 开发 -- 0%
12、对外开放服务接口 demo 开发--0%
13、全文索引服务（伟峰）--80%

演示
1、一期项目演示 (周勇、李晓东)-- 0302 待演示
2、原有服务HTTP改造 ，接入ADC 方案演示 （李晓东） -- 0302
3、对外开放服务接口，接入ADC方案演示 （李晓东） -- 0302

二、二期开发计划 （20180312-）
1、前端APP接入授权管理界面交互 （周勇）--
2、后端 授权管理接口 （李晓东）
3、后端网关 过滤路由 过滤器逻辑开发 （李晓东）
4、登录、注册 接UPM、SSO （周勇、李晓东）
5、调用次数限流 等 （李晓东）

#TODO
1、文档与服务多对多，文章接口改造；
2、ADC过滤器签名验证逻辑（OK）
3、过滤器取 APP 信息加入签名验证 并出签名文档。
4、ADC后端目录接口编辑 
5、发布正式环境
6、暴露一个对外的HTTP服务接口 对外校验里多个method，用于查找资源表信息（拿VIN码反查或者bcar中造个例子） 
7、对外hTTP接口method重定向







