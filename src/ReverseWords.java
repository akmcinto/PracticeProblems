import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class ReverseWords {

	public static void main(String[] args) {
		try {
			BufferedReader buff = new BufferedReader(new FileReader(args[0]));
			Integer n = Integer.valueOf(buff.readLine());
			Integer counter = 1;
			ArrayList<String[]> result = new ArrayList<String[]>();
			String ln;
			while ((ln = buff.readLine()) != null) {
				String[] strs = ln.split(" ");
				String[] lnres = new String[strs.length];
				for (int i = 0; i < strs.length; i++) {
					lnres[i] = strs[strs.length - i - 1];
				}
				result.add(lnres);
				counter++;
			}
			System.out.println(result);
			buff.close();
			BufferedWriter biff = new BufferedWriter(new FileWriter("ReverseWords.out", false));
			for (int i = 0; i < n; i++) {
				String prstr = "Case #" + (i+1) + ": ";
				for (int j = 0; j < result.get(i).length; j++) {
					prstr += result.get(i)[j] + " ";
				}
				biff.write(prstr + "\n");
			}
			biff.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
