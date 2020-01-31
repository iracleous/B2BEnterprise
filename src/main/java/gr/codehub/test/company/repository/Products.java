package gr.codehub.test.company.repository;

import gr.codehub.test.company.model.Product;
import lombok.Data;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Data
public class Products {
    private List<Product> products;

    public Products()
    {
        products = new ArrayList<>();
    }

    public Products(String excelFileName) throws IOException {
        this();
        FileInputStream excelFile = new FileInputStream(new File(excelFileName));
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet datatypeSheet = workbook.getSheetAt(0);
        Iterator<Row> row = datatypeSheet.iterator();

        row.next(); //reads the headers
        while (row.hasNext()) {
            Row currentRow = row.next();
            Iterator<Cell> cellIterator = currentRow.iterator();

            Cell codeCell = cellIterator.next();
            Cell nameCell = cellIterator.next();
            Cell grossPriceCell = cellIterator.next();
            Cell quantityCell = cellIterator.next();

            	Product product =new 	Product(
                        (int) codeCell.getNumericCellValue()      ,
                        nameCell.getStringCellValue()  ,
                         grossPriceCell.getNumericCellValue(),
                        (int) quantityCell.getNumericCellValue()

                  );

            products.add(product);
        }
    }

    public Product getProductByCode(int code){
        return products
                 .stream()
                 .filter(product -> product.getCode()==code)
                 .findFirst()
                 .get();
    }

}
