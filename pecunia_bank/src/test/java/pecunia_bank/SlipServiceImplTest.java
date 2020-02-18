package pecunia_bank;
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.cg.pecunia_bank.service.SlipService;
import com.cg.pecunia_bank.service.SlipServiceImpl;
public class SlipServiceImplTest {
SlipService service=new SlipServiceImpl();
//Invalid Account Test
@Test
public void checkDebitUsingSlipTest()
{
	Assertions.assertTrue(service.debitUsingSlip("123456445823", 50000.00, LocalDate.now())=="Transaction Not Completed");
}
@Test
public void checkCreditUsingSlipTest()
{
	Assertions.assertTrue(service.creditUsingSlip("123456445823", 50000.00,LocalDate.now())=="Transaction Not Completed");
}

//Original Account Test
@Test
public void checkDebitUsingSlipTest2()
{
	Assertions.assertTrue(service.debitUsingSlip("328287420931", 70000.00, LocalDate.now()).contains("Completed"));
}
@Test
public void checkCreditUsingSlipTest2()
{
	Assertions.assertTrue(service.creditUsingSlip("328287420931", 70000.00, LocalDate.now()).contains("Completed"));
}

//Insufficient Balance Test
@Test
public void checkDebitUsingSlipTest3()
{
	Assertions.assertTrue(service.debitUsingSlip("328287420931", 500000.00,LocalDate.now())=="Transaction Not Completed");
}



}

