# springcloud
again
一个文件怎么添加 hystrix

1. 复制出一个生产者
2. 添加到eureka 
3. 在pom.xml中添加依赖 hystrix
4. 在启动类中添加注解 @EnableHystrix
5. 在controller 方法上添加 注解    @HystrixCommand(fallbackMethod = "getFallback")
6. 编写回调方法
