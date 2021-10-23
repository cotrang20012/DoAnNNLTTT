import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import vehiclestore.*;
public class MAIN {

	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out),true,"UTF-8"));
		menu.DefaultData();
		menu.Run(sc);
		sc.close();
	}

}
