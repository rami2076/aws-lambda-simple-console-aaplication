import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.model.FunctionConfiguration;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import com.amazonaws.services.lambda.model.ListFunctionsResult;
import com.amazonaws.services.lambda.model.ServiceException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;

public class Functions {
  public static void main(String[] args) {

    // snippet-start:[lambda.java1.list.main]
    ListFunctionsResult functionResult = null;

    try {
      AWSLambda awsLambda =
          AWSLambdaClientBuilder.standard()
              .withCredentials(new ProfileCredentialsProvider())
              .withRegion(Regions.US_WEST_2)
              .build();

      functionResult = awsLambda.listFunctions();

      List<FunctionConfiguration> list = functionResult.getFunctions();

      for (Iterator iter = list.iterator(); iter.hasNext(); ) {
        FunctionConfiguration config = (FunctionConfiguration) iter.next();

        System.out.println("The function name is " + config.getFunctionName());
      }

    } catch (ServiceException e) {
      System.out.println(e);
    }
    // snippet-end:[lambda.java1.list.main]
  }
}
