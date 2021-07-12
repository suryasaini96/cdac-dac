package tester;

import java.util.Scanner;
import static utils.IOUtils.storeProductDetails;
import static utils.CollectionUtils.*;

public class TestCollectionIO {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter file name to store sorted product details");
			storeProductDetails(populateMap(populateData()), sc.nextLine());
			System.out.println("products stored ....");

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("main over....");

	}

}
