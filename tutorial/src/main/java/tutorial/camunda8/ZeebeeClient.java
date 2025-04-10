/*
 * package tutorial.camunda8;
 * 
 * import org.springframework.stereotype.Component;
 * 
 * import io.camunda.zeebe.client.api.response.ActivatedJob; import
 * io.camunda.zeebe.client.api.worker.JobClient; import
 * io.camunda.zeebe.spring.client.annotation.JobWorker;
 * 
 * @Component public class ZeebeeClient {
 * 
 * @JobWorker(type = "testWorkerType") public void test(final JobClient client,
 * ActivatedJob job) { System.out.println("here"); } }
 */