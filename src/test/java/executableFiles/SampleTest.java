package executableFiles;
import org.testng.annotations.Test;

public class SampleTest 
{
@Test(dataProvider = "readData", dataProviderClass = DataProvider.class)
public void sample(String username, String password)
{
System.out.println(username+"-----"+password);	
}
}
