package com.example.learing.taskintake;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.task.launcher.TaskLaunchRequest;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Source.class)
public class TaskProcessor {
	
	@Autowired
	private Source source;
	
	public void publishRequest(String payload) {
		String mavenUrl = "maven://com.learning:spring-cloud-task:jar:0.0.1-SNAPSHOT";
		List<String> input = Arrays.asList(payload.split(","));
		TaskLaunchRequest req = new TaskLaunchRequest(mavenUrl, input, null, null, null);
		System.out.println("created launch req");
		GenericMessage<TaskLaunchRequest> message = new GenericMessage<TaskLaunchRequest>(req);
		source.output().send(message);
	}

}
