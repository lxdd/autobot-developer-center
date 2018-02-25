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
