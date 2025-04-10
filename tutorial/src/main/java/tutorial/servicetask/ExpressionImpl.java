package tutorial.servicetask;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

@Component("expressionImpl")
public class ExpressionImpl {

	public void executeExpression(DelegateExecution execution) {
		System.out.println("Executed using Expression.");
	}
}
