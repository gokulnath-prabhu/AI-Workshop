
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class LegacySystem {

    // Processes multiple products, logs failures, and returns only successfully
    // processed products
    private static List<Product> processMultipleProducts(List<Product> products) {
        List<Product> processedProducts = new java.util.ArrayList<>();
        for (Product product : products) {
            Product result = processSingleProduct(product);
            if (result != null) {
                processedProducts.add(result);
                System.out.println("SUCCESS: Processed product with ID: " + product.get("id"));
            } else {
                System.out.println("FAILURE: Could not process product with ID: "
                        + (product != null ? product.get("id") : "null"));
            }
        }
        System.out.println(
                "\nProcessed " + processedProducts.size() + " out of " + products.size() + " products successfully.");
        return processedProducts;
    }

    static class Product extends HashMap<String, Object> {
    }

    private static Map<String, Object> fetchProductDetailsFromSource(String productId) throws InterruptedException {
        System.out.println("  > Fetching details for product " + productId + "...");
        Thread.sleep(100); // Simulate network latency

        Map<String, Object> details = new HashMap<>();
        details.put("price", 99.99);
        details.put("stock", 150);
        details.put("category", "electronics");
        return details;
    }

    public static Product processSingleProduct(Product productData) {
        if (productData == null || !productData.containsKey("id") || !productData.containsKey("name")) {
            System.out.println("ERROR: Product data is missing 'id' or 'name'.");
            return null;
        }

        String productId = (String) productData.get("id");
        System.out.printf("\nProcessing product ID: %s (%s)\n", productId, productData.get("name"));

        try {

            Map<String, Object> additionalDetails = fetchProductDetailsFromSource(productId);
            productData.putAll(additionalDetails);

            double price = (double) productData.get("price");
            productData.put("tax_applied", price * 0.05);
            productData.put("is_available", (int) productData.get("stock") > 0);

            System.out.println("  > Saving processed data for product " + productId + " to the database.");
            System.out.println("  > Final record: " + productData);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("ERROR: Processing was interrupted for product " + productId);
            return null;
        }

        return productData;
    }

    public static void main(String[] args) {
        System.out.println("--- Legacy Product Processing System ---");

        Product productOne = new Product();
        productOne.put("id", "SKU123");
        productOne.put("name", "Wireless Mouse");

        Product productTwo = new Product();
        productTwo.put("id", "SKU456");
        productTwo.put("name", "USB-C Hub");

        java.util.List<Product> products = new java.util.ArrayList<>();
        products.add(productOne);
        products.add(productTwo);

        // Add a product missing 'id' to trigger the null case
        Product invalidProduct = new Product();
        invalidProduct.put("name", "Invalid Product");
        products.add(invalidProduct);

        processMultipleProducts(products);
    }
}