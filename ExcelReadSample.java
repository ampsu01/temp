import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelReadSample {

	/** * * @param file * @throws IOException */
	public List<Map<String, Object>> excelRead(File file) throws IOException {

		String[] keys = { "No", "Addr", "Jiga", "X", "Y" };

		Workbook w = null;
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();

		try {
			w = Workbook.getWorkbook(file);

			Sheet sheet = w.getSheet(0);

			Map<String, Object> map = null;

			for (int j = 0; j < sheet.getRows(); j++) {

				map = new HashMap<String, Object>();

				for (int i = 0; i < sheet.getColumns(); i++) {

					Cell cell = sheet.getCell(i, j);

					map.put(keys[i], cell.getContents());

				}
				data.add(map);
			}

		}

		catch (BiffException e) {
			e.printStackTrace();
		}

		return data;

	}

}
