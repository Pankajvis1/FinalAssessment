package utilities;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVUtil {

	public static Object[][] getLoginData(String filePath, String loginType) {

		List<Object[]> data = new ArrayList<>();

		try {
			CSVReader reader = new CSVReader(new FileReader(filePath));
			List<String[]> rows = reader.readAll();

			for (int i = 1; i < rows.size(); i++) {
				String username = rows.get(i)[0];
				String password = rows.get(i)[1];
				String type = rows.get(i)[2];

				if (type.equalsIgnoreCase(loginType)) {
					data.add(new Object[] { username, password });
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return data.toArray(new Object[0][]);
	}
}