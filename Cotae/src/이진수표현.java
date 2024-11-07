import java.io.*;

public class 이진수표현 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);
			int last = (1<<N)-1;
			boolean isOn = false;
			if (last == (M&last)) isOn = true;
			System.out.println("#" + t + " " + (isOn ? "ON":"OFF"));
		}
	}
}