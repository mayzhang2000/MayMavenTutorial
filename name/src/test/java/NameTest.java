import mockit.*;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.util.PDFTextStripper;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.*;

import java.io.IOException;
import java.net.URL;
import java.util.Date;

/**
 * Created by mayz985 on 9/1/15.
 */
public class NameTest {
    @Test
    public void testWholeName() {
        String wholeName = (new Name()).wholeName("may", "zhang");
        Assert.assertEquals(wholeName, "may, zhang", "Failed with wholeName");
        new NameTestUtil();
    }


    @Test
    public void testCreateEmptyPDF() {
        PDDocument doc = null;

        doc = new PDDocument();
        doc.addPage(new PDPage());
        try {
            doc.save("MayEmptyPDF.pdf");

            if(doc != null) {
                doc.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (COSVisitorException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSaveExistingPDF() {
        try {
            URL tfsURL = new URL("http://pqaltfsas300.corp.intuit.net/tfs/v1/filings/9d77192b-1e97-4f59-bd8a-f4796fb96463/documents/57bc83df-d2c2-4481-b857-a5672d1afc57");
            PDDocument doc = PDDocument.load(tfsURL);
            doc.save("MayTFSPDF.pdf");

            if(doc != null) {
                doc.close();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testExtractTextFromPDF() {
        try {
            File input = new File("MayTFSPDF.pdf");
            File output = new File("MayTxt.TXT");
            PDDocument pd = PDDocument.load(input);

            System.out.println(pd.getNumberOfPages());
            PDFTextStripper stripper = new PDFTextStripper();
            stripper.setStartPage(1);
            stripper.setEndPage(1);
            System.out.println(stripper.getText(pd));

            BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output)));
            stripper.writeText(pd, wr);

            if(pd != null) {
                pd.close();
            }
            wr.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPlayground() {
        try {
            File input = new File("MayTFSPDF.pdf");
            File output = new File("MayTxt.TXT");
            PDDocument pd = PDDocument.load(input);

            System.out.println(pd.getNumberOfPages());
            PDFTextStripper stripper = new PDFTextStripper();
            stripper.setStartPage(1);
            stripper.setEndPage(1);
            System.out.println(stripper.getText(pd));

            BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output)));
            stripper.writeText(pd, wr);

            if(pd != null) {
                pd.close();
            }
            wr.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Below are all examples of using JMockit
     */

    @Test
    public void testUsingMockExpectations(final @Mocked Date date) {
        final String mockedResult = "May's Date";
        new NonStrictExpectations() {{
            date.toString(); result = mockedResult;
        }};
        Name myName = new Name();
        String output = myName.processTime();
        Assert.assertEquals(mockedResult, output);
    }

    @Test
    public void testUsingMockStub() {
        final String mockedResult = "May's Date";
        new MockUp<Date>() {
            @Mock
            public String toString() {
                return mockedResult;
            }
        };
        Name myName = new Name();
        String output = myName.processTime();
        Assert.assertEquals(mockedResult, output);
    }

    @Test
    public void testMockConstructor() {
        new MockUp<Name>() {
            //Don't forget to use @Mock
            @Mock public void $init() { /* do nothing */ }
        };

        Name myName = new Name();
        System.out.println(myName.processTime());
    }

    @Test
    public void testMockConstructorWithParams() {
        new MockUp<Name>() {
            //Don't forget to use @Mock
            @Mock public void $init(String input) { /* do nothing */ }
        };

        Name myName = new Name("My input");
        System.out.println(myName.processTime());
    }

    @Test
    public void testMockInitializationBlock() {
        new MockUp<Name> () {
            @Mock
            public void $clinit() {
                System.out.println("In mocked initalization block.");
            }
        };
        Name myName = new Name("My input");
        System.out.println(myName.processTime());
    }

    /**
     * In state based mock:
     * If not Mocked method, use the real methods
     */
    @Test
    public void testMockUsingState() {

        new MockUp<Name> () {
            @Mock
            public String wholeName(String firstname, String lastname) {
                return "MockedWholeName";
            }
        };

        Name myName = new Name();
        System.out.println(myName.wholeName("first", "last"));
        System.out.println(myName.nickName("first", "last"));
    }

    /**
     * In behavior based mock:
     * If no expectations, all are mocked.
     */
    @Test
    public void testMockUsingBehavior(final @Mocked Name name) {
        new NonStrictExpectations() {

            {
            name.wholeName(anyString, anyString); result = "MockedWholeName";
        }
        };
        Name myName = new Name();
        System.out.println(myName.wholeName("first", "last"));
        System.out.println(myName.nickName("first", "last"));
    }

    @Test
    public void testMockPrivateMethodUsingBehavior() {
        new MockUp<Name>() {

            @Mock
            private String getBirthDate() {
                return "MockedBirthDate";
            }
        };
        Name myName = new Name();
        System.out.println(myName.processBirthDate());
    }

    @Test
    public void testMockPrivateMethodUsingExpectation() {
        final Name myName = new Name();
        new NonStrictExpectations(myName) {{

            Deencapsulation.invoke(myName, "getBirthDate"); result = "MockedBirthDate";
        }
        };

        System.out.println(myName.processBirthDate());
        System.out.println(myName.wholeName("first", "last"));
    }

    @Test
    public void testMockStaticUsingState()  {
        new MockUp<Name> () {
            @Mock
            public String getStaticYear() {
                return "Mocked 2015";
            }
        };


        System.out.println(Name.getStaticYear());
        System.out.println(new Name().wholeName("fi", "la"));
    }

    @Test
    public void testMockStaticUsingBehavior() {
        Name myName = new Name();
        new NonStrictExpectations(myName) {{
           Name.getStaticYear(); result = "Mocked 2015";
        }};

        System.out.println(Name.getStaticYear());
        System.out.println(new Name().wholeName("fi", "la"));

    }

    @Test
    public void testInvokePrivateMethod() {
        Name myName = new Name();
        Deencapsulation.invoke(myName, "getBirthDate");
    }

    @Test
    public void testMockExceptionUsingState () {
        new MockUp<Name> () {
            @Mock
            public String getCountry() throws IOException {
                throw new IOException();
            }
        };

        Name name = new Name();
        try {
            name.getCountry();
            System.out.println("failed");
        }catch (IOException e) {
            System.out.println("passed");
        }
    }

    @Test
    public void testMockExceptionUsingBehavior() throws Exception {
        final Name name = new Name();
        new NonStrictExpectations(name) {{
            name.getCountry(); result = new IOException();
        }};

        try {
            System.out.println(name.wholeName("f", "l"));
            name.getCountry();

            System.out.println("failed");
        }catch (IOException e) {
            System.out.println("passed");
        }
    }


    @Test
    public void testMockStaticUsingStateAndVerify(final @Mocked Name name)  {

        new NonStrictExpectations() {{
          Name.getStaticYear(); result = "Mocked";
        }
        };

        System.out.println(Name.getStaticYear());
        System.out.println(new Name().wholeName("fi", "la"));


        new Verifications() {{
            Name.getStaticYear(); times = 1;
        }
        };
    }

    @Test
    public void testMockInvokeRealMethod() {
        new MockUp<Name>() {
            @Mock
            private String getBirthDate(Invocation invocation) {
                System.out.println("Mocking is called.");
                return invocation.proceed();
            }
        };
        Name myName = new Name();
        System.out.println(myName.processBirthDate());

    }

    /**
     * Can mock Java JDK classes.
     */
    @Test
    public void mockMathRandom() {
        new MockUp<Math>() {
            @Mock
            @SuppressWarnings("unused")
            double random() {
                return 0D;
            }
        };
        Assert.assertEquals(0D, Math.random(), 0D);
    }

    @Test
    public void testCapture(final @Mocked Name name) {
        new NonStrictExpectations() {

            {
                name.wholeName(anyString, anyString); result = "MockedWholeName";
            }
        };
        Name myName = new Name();
        System.out.println(myName.wholeName("first", "last"));
        System.out.println(myName.nickName("first", "last"));

        new Verifications() {{
            String d, e;
            name.wholeName(d = withCapture(), e= withCapture());
            System.out.println("Captured: " + d + ";   Captured: " + e);
        }
        };

    }


}
