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


#TODO
1、文档与服务多对多，文章接口改造；
2、ADC过滤器
3、演示




