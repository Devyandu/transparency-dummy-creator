import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.Example;
import com.example.InNetwork;
import com.example.NegotiatedPrice;
import com.example.NegotiatedRates;
import com.example.NegotiatedPrice.NegotiatedType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import org.apache.commons.collections4.SetUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import entities.FlatEntity;

/**
 * Created by devyandu on 7/31/2021.
 */
public class Main {
    public static void main(String[] args) throws Exception{

        Writer csvwriter  = new FileWriter("out.csv");

        StatefulBeanToCsv<FlatEntity> sbc = new StatefulBeanToCsvBuilder<FlatEntity>(csvwriter)
       .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
       .build();

        File file = new File("Hello1.txt");

        // creates the file
        file.createNewFile();
        
        // creates a FileWriter Object
        FileWriter writer = new FileWriter(file);
        Example example =new Example();
        example.setReportingEntityName("DB Health Plan");
        example.setReportingEntityType("Group Plan");
        example.setPlanName("plan1");
        example.setPlanId("HIOS12345678901");
        example.setPlanIdType("HIOS");
        example.setLastUpdatedOn("2022-01-01");
        example.setPlanMarketType(Example.PlanMarketType.GROUP);
        ObjectMapper mapperObj = new ObjectMapper();
        //Write Plan
        String jsonString=mapperObj.writeValueAsString(example);
        writeToOutputAndPending(jsonString, writer);
        //Start of in-network array
        writer.write(",\n\"in_network\": \n[");
        
        //Now write a loop for in-network objects
        //Read the excel with billing codes
        FileInputStream fis=new FileInputStream(new File("/stuff/projects/mrg/dummycreator/src/main/resources/dummy-billing-codes.xls"));  
        //creating workbook instance that refers to .xls file  
        HSSFWorkbook wb=new HSSFWorkbook(fis);   
        //creating a Sheet object to retrieve the object  
        HSSFSheet sheet=wb.getSheetAt(0);
        boolean wroteInNetwork=false;
        for (Row myrow : sheet) {
            //Assume columns in this sequence 0-billing_code	1-name	2-billing_code_type 	3-billing_code_type_version 

            String billingCode=myrow.getCell(0).getStringCellValue();
           
            if (StringUtils.isNotBlank(billingCode))
            {
                InNetwork inNetwork = new InNetwork();
                inNetwork.setNegotiationArrangement(InNetwork.NegotiationArrangement.FFS);
                inNetwork.setBillingCode(billingCode);
                inNetwork.setName(myrow.getCell(1).getStringCellValue());
                inNetwork.setBillingCodeType(InNetwork.BillingCodeType.fromValue(myrow.getCell(2).getStringCellValue()));
                inNetwork.setBillingCodeTypeVersion(String.valueOf( myrow.getCell(3).getNumericCellValue()));
                String jsonStringInNetwork=mapperObj.writeValueAsString(inNetwork);
                if (wroteInNetwork)
                {

                    writer.write(",");
                }
                wroteInNetwork=true;
                writeToOutputAndPending(jsonStringInNetwork, writer);
                
                
                
                //Start of negotiated_rates array
                writer.write(",\n\"negotiated_rates\": \n[");
                //Now write all Negotiated rates objects
                int numberOfProvidersDesired=2;
                for (int nr=0;nr< numberOfProvidersDesired;nr++)
                {
                    NegotiatedRates negotiatedRates= new NegotiatedRates();
                    negotiatedRates.setTin(nr+"-111111");
                     Set<Double> providersSet= new HashSet<Double>();
                     for (int ps=0;ps<5;ps++)
                     {
                        providersSet.add(Double.valueOf(nr+1*ps+1));

                     }
                     
                    negotiatedRates.setProviders(providersSet);
                    negotiatedRates.setServiceCode("01");
                    NegotiatedPrice np=new NegotiatedPrice();
                    np.setExpirationDate("2022-01-01");
                    np.setNegotiatedRate(Double.valueOf(nr+1));
                    np.setNegotiatedType(NegotiatedType.FEE_SCHEDULE);
                    negotiatedRates.setNegotiatedPrice(np);
                    String jsonStringNR=mapperObj.writeValueAsString(negotiatedRates);
                    writer.write(jsonStringNR);
                    FlatEntity fe = FlatEntity.factory(example, inNetwork, negotiatedRates, np);
                    sbc.write(fe);
                     
                     if (nr< numberOfProvidersDesired-1){
                         writer.write(",");
                     }
                     writer.flush();
                }
                 //For negotiated_rates array and end of in-network  object
                writer.write("\n]\n}");
                

            }
            else{
                continue;
            }
           
        }
        csvwriter.close();


        

        writer.flush();
        writer.close();


        // Writes the content to the file
        //writer.write("This\n is\n an\n example\n");
        //writer.flush();
        //writer.close();

    }


    private static void writeToOutputAndPending(String jsonString,FileWriter writer) throws IOException {
    String writable = jsonString.substring(0,  jsonString.lastIndexOf("}"));      
   
    writer.write(writable);
    writer.flush();
}
}
