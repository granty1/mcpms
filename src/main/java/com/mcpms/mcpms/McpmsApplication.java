package com.mcpms.mcpms;

import com.mcpms.mcpms.warning.DailyWarning;
import com.mcpms.mcpms.warning.Timer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
@MapperScan(value = {"com.mcpms.mcpms.system.mapper.**","com.mcpms.mcpms.newplan.mapper.**"})
@EnableTransactionManagement
public class McpmsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(McpmsApplication.class, args);
		//doCheckingWarning(run);
	}

	/*private static void doCheckingWarning(ConfigurableApplicationContext run){
		DailyWarning bean = run.getBean(DailyWarning.class);
		Timer timer = new Timer(bean);
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(timer);
	}*/
}

