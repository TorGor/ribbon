package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

@SpringBootApplication
public class NetflexRibbonApplication {

	public static void main(String[] args) {
//		SpringApplication.run(NetflexRibbonApplication.class, args);
		ILoadBalancer lb = new BaseLoadBalancer();
		List<Server> serverList = new ArrayList<>();
		serverList.add(new Server("localhost",8080));
		serverList.add(new Server("localhost",8081));
		lb.addServers(serverList);
		
		for(int i=0;i<10;i++){
			Server server = lb.chooseServer(null);
			System.out.println(server);
		}
		
	}
}
