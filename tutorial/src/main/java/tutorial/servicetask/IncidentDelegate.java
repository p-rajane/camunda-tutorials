package tutorial.servicetask;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.runtime.Incident;
import org.springframework.stereotype.Component;

@Component("incidentDelegate")
public class IncidentDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		execution.createIncident(Incident.FAILED_JOB_HANDLER_TYPE, "Message");
		
	}

}
