package tutorial;

import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.assertThat;
import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.runtimeService;

import java.util.HashMap;

import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.extension.junit5.test.ProcessEngineExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import tutorial.servicetask.ExpressionImpl;

@ExtendWith(ProcessEngineExtension.class)
public class TestClass {

	@Mock
	ExpressionImpl expressionImpl;
	
	//@Test
	@Deployment(resources = "bpm/ServiceTask.bpmn")
	void flowTest() {
		ProcessInstance processInstance = runtimeService().startProcessInstanceByKey("MainProcess", new HashMap<>());
		assertThat(processInstance).isEnded();
	}
}
