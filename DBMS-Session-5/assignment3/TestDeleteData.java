package assignment3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestDeleteData {
	@Test
	public void test() {
		assertEquals(59, UpdateProductData.deleteData());
	}
}