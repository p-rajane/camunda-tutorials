package tutorial.asysncbehaviour;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("asynchBehaviourImpl")
public class AsynchBehaviourImpl implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Exeucted async behaviour");
		execution.getVariable("age").toString();
		
	}
}
