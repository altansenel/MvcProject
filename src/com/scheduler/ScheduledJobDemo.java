package com.scheduler;

import java.io.Serializable;
import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;

import com.batch.AuthenticationUtil;

public class ScheduledJobDemo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private JobLauncher jobLauncher;

//	Will Spring know which bean should wire?
//	To fix it, you can use @Qualifier to auto wire a particular bean, for example,
//	@Autowired
//	@Qualifier("PersonBean1")
//	private Person person;
	
	@Autowired
	private Job helloWorldJob;

	@Autowired
	private Job xmlJob;

	@Autowired
	private AuthenticationUtil authenticationUtil;
	
	//@Scheduled(cron = "*/40 * * * * ?")
	public void demoServiceMethod() {
		try {
			authenticationUtil.configureAuthentication("ROLE_USER");
			
			String dateParam = new Date().toString();
			JobParameters param = new JobParametersBuilder().addString("date", dateParam).toJobParameters();

			System.out.println(dateParam);

			JobExecution execution = jobLauncher.run(xmlJob, param);
			System.out.println("Exit Status : " + execution.getStatus());

			authenticationUtil.clearAuthentication();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// @Scheduled(cron = "*/20 * * * * ?")
	// public void yeniBatchDemo() {
	//
	// try {
	// String dateParam = new Date().toString();
	// JobParameters param = new JobParametersBuilder().addString("date", dateParam).toJobParameters();
	//
	// System.out.println(dateParam);
	//
	// JobExecution execution = jobLauncher.run(helloWorldJob, param);
	// System.out.println("Exit Status : " + execution.getStatus());
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
}
