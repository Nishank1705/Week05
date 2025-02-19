import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.File;
import java.util.List;
import java.util.Map;

public class CsvToJson {
    public static void main(String[] args) {
        try {
            File csvFile = new File("N:\\Week5\\Day2\\com\\CSVtoJSON\\CSVFile01.csv");


            CsvSchema csvSchema = CsvSchema.emptySchema().withHeader();


            CsvMapper csvMapper = new CsvMapper();
            MappingIterator<Map<String, String>> iterator = csvMapper.readerFor(Map.class)
                    .with(csvSchema)
                    .readValues(csvFile);

            List<Map<String, String>> dataList = iterator.readAll();


            ObjectMapper jsonMapper = new ObjectMapper();
            String jsonOutput = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataList);


            System.out.println(jsonOutput);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}