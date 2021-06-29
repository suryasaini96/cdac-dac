package tester;

import static utils.IOUtils.restoreProductDetails;

import java.util.Scanner;

public class RestoreProducts {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter file name");
			restoreProductDetails(sc.nextLine()).forEach((k, v) -> System.out.println(v));
			System.out.println("de-ser over....");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
