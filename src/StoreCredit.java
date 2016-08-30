import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class StoreCredit {

	public static void main(String[] args) {
		try {
			BufferedReader buff = new BufferedReader(new FileReader(args[0]));
			Integer n = Integer.valueOf(buff.readLine());
			Integer counter = 1;
			ArrayList<String> result = new ArrayList<String>();
			String ln;
			while ((ln = buff.readLine()) != null) {
				Integer ncred = Integer.valueOf(ln);
				Integer nitem = Integer.valueOf(buff.readLine());
				String[] stritems = buff.readLine().split(" ");
				ArrayList<Integer> items = new ArrayList<Integer>();
				for (int i = 0; i < stritems.length; i++) {
					items.add(Integer.valueOf(stritems[i]));
				}
				result.add(findPurchases(ncred, nitem, items, counter));
				counter++;
			}
			System.out.println(result);
			buff.close();
			BufferedWriter biff = new BufferedWriter(new FileWriter("StoreCredit.out", true));
			for (int i = 0; i < n; i++) {
				biff.write(result.get(i));
			}
			biff.close();
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}
	
	private static String findPurchases(Integer ncred, Integer nitems, ArrayList<Integer> items, Integer counter) {
		for (int i = 0; i < nitems; i++) {
			Integer base = items.get(i);
			for (int j = i + 1; j < nitems; j++) {
				if (base + items.get(j) == ncred) {
					return new String("Case #" + counter + ": " + (i+1) + " " + (j+1) + "\n");
				}
			}
		}
		return null;
	}

}
