package com.tedu.sp07;
/**
 *    创建 RestTemplate 实例
* RestTemplate 是用来调用其他微服务的工具类，封装了远程调用代码，提供了一组用于远程调用的模板方法，
*     例如：getForObject()、postForObject() 等
 */
/**
 * @LoadBalanced 负载均衡注解，会对 RestTemplate 实例进行封装，创建动态代理对象，并切入（AOP）负载均衡代码，
 *    把请求分散分发到集群中的服务器
 */
/**
 * 启动断路器，断路器提供两个核心功能：
 *降级:超时、出错、不可到达时，对服务降级，返回错误信息或者是缓存数据
 *熔断:当服务压力过大，错误比例过多时，熔断所有请求，所有请求直接降级
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
//@EnableCircuitBreaker
//@EnableDiscoveryClient
//@SpringBootApplication
@SpringCloudApplication//注解代替三个注解
public class Sp07HystrixApplication {
	@LoadBalanced//负载均衡注解//创建 RestTemplate 实例，并存入 spring 容器
	@Bean
	public RestTemplate getRestTemplate() {
		SimpleClientHttpRequestFactory f = new SimpleClientHttpRequestFactory();
		f.setConnectTimeout(1000);
		f.setReadTimeout(1000);
		return new RestTemplate(f);
		
		//RestTemplate 中默认的 Factory 实例中，两个超时属性默认是 -1，
		//未启用超时，也不会触发重试
		//return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(Sp07HystrixApplication.class, args);
	}

}