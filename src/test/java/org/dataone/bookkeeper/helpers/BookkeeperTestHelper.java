package org.dataone.bookkeeper.helpers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.dropwizard.jackson.Jackson;
import org.dataone.bookkeeper.api.Feature;
import org.dataone.bookkeeper.api.Order;
import org.dataone.bookkeeper.api.OrderItem;
import org.dataone.bookkeeper.api.Product;
import org.dataone.bookkeeper.api.Quota;

import java.util.LinkedList;
import java.util.List;

public class BookkeeperTestHelper {

    /**
     * Create a test product
     * @param productId the product identifier
     * @return product a test product
     */
    public static Product createTestProduct(Integer productId) {

        Product product = new Product();
        product.setId(productId);
        product.setObject("product");
        product.setActive(true);
        product.setAmount(180000);
        product.setCaption("Small institutions or groups");
        product.setCreated(1559768309);
        product.setCurrency("USD");
        product.setDescription("Create multiple portals for your work and projects. " +
            "Help others understand and access your data.");
        product.setInterval("year");
        // product.setCreated(new Integer((int) Instant.now().getEpochSecond()));
        product.setName("Organization");
        product.setStatementDescriptor("DataONE Membership Plan - Organization");
        product.setType("service");
        product.setUnitLabel("membership");
        product.setUrl("https://dataone.org/memberships/organization");
        product.setMetadata(createTestMetadata());

        return product;
    }

    /**
     * Create a test metadata instance as a Jackson ObjectNode
     * @return metadata a metadata object
     */
    public static ObjectNode createTestMetadata() {
        ObjectMapper mapper = Jackson.newObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        ObjectNode metadata = mapper.createObjectNode();

        // Build up a feature list
        Feature feature1 = new Feature();
        Feature feature2 = new Feature();
        Feature feature3 = new Feature();
        Feature feature4 = new Feature();
        Feature feature5 = new Feature();
        Feature feature6 = new Feature();

        // Build a quota for feature 1
        Integer quota_id = 1;
        String quota_object = "quota";
        String quota_type = "portal";
        Double quota_soft_limit = 3.0;
        Double quota_hard_limit = 3.0;
        Double quota_total_usage = 0.0;
        String quota_unit = "portal";
        Integer quota_customer_id = null;
        String quota_subject = null;
        String quota_name = null;

        Quota quota = new Quota(quota_id, quota_object, quota_type,
            quota_soft_limit, quota_hard_limit, quota_total_usage, quota_unit,
            quota_customer_id, quota_subject, quota_name);

        feature1.setName("custom_portal");
        feature1.setLabel("Branded Portals");
        feature1.setDescription("Showcase your research, data, results, and usage metrics by building a custom web portal.");
        feature1.setQuota(quota);

        feature2.setName("custom_search_filters");
        feature2.setLabel("Custom Search Filters");
        feature2.setDescription("Create custom search filters in your portal to allow scientists to search your holdings using filters appropriate to your field of science.");

        feature3.setName("fair_data_assessment");
        feature3.setLabel("FAIR Data Assessments");
        feature3.setDescription("Access quality metric reports using the FAIR data suite of checks.");

        feature4.setName("custom_quality_metrics");
        feature4.setLabel("Custom Quality Metrics");
        feature4.setDescription("Create a suite of custom quality metadata checks specific to your datasets.");

        feature5.setName("aggregated_metrics");
        feature5.setLabel("Aggregated Metrics");
        feature5.setDescription("Access and share reports on aggregated usage metrics such as dataset views, data downloads, and dataset citations.");

        feature6.setName("dataone_voting_member");
        feature6.setLabel("DataONE Voting Member");
        feature6.setDescription("Vote on the direction and priorities at DataONE Community meetings.");

        // Add the feature list to the metadata object
        metadata.putArray("features")
            .add(mapper.convertValue(feature1, ObjectNode.class))
            .add(mapper.convertValue(feature2, ObjectNode.class))
            .add(mapper.convertValue(feature3, ObjectNode.class))
            .add(mapper.convertValue(feature4, ObjectNode.class))
            .add(mapper.convertValue(feature5, ObjectNode.class))
            .add(mapper.convertValue(feature6, ObjectNode.class));

        return metadata;
    }

    /**
     * Create a test order
     * @param orderId the order identifier
     * @return order the created order
     */
    public static Order createTestOrder(Integer orderId, Integer customerId,
                                        Integer chargeId, Integer invoiceId) {
        Order order = new Order();
        order.setId(orderId);
        order.setObject("order");
        order.setAmount(50000);
        order.setAmountReturned(0);
        order.setCharge(createTestCharge(chargeId, customerId, invoiceId, orderId));
        order.setCreated(1559768309);
        order.setCurrency("USD");
        order.setCustomer(customerId);
        order.setSubject("http://orcid.org/0000-0002-8121-2341");
        order.setEmail("cjones@nceas.ucsb.edu");
        order.setItems(createTestOrderItems());
        order.setMetadata(new ObjectMapper().createObjectNode());
        order.setName("DataONE Order # 1");
        order.setStatus("paid");
        order.setStatusTransitions(createTestStatusTransitions());
        order.setUpdated(1559768309);
        order.setSeriesId("1234567890");
        order.setStartDate(1559768309);
        order.setEndDate(1559768309);

        return order;
    }

    /**
     * Create a test charge object to represent the transaction for the order
     * @param chargeId the charge identifier
     * @param customerId the customer identifier
     * @param invoiceId the invoice identifier
     * @param orderId the order identifier
     * @return charge the charge associated with the order, invoice, and customer
     */
    public static ObjectNode createTestCharge(Integer chargeId, Integer customerId,
                                              Integer invoiceId, Integer orderId) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode charge = mapper.createObjectNode();
        charge.put("id", chargeId);
        charge.put("object", "charge");
        charge.put("amount", new Integer(50000).intValue());
        charge.put("amountRefunded", new Integer(0).intValue());
        charge.put("created", 1559768309);
        charge.put("currency", "USD");
        charge.put("customer", customerId);
        charge.put("description", "DataONE Order # 1");
        charge.put("invoice", invoiceId);
        charge.set("metadata", mapper.createObjectNode());
        charge.put("order", orderId);
        charge.put("paid", true);
        charge.put("statementDescriptor", "DataONE Order # 1");
        charge.put("status", "succeeded");

        return charge;
    }

    /**
     * Create a test order item list
     * @return orderItems the list of order items for the order
     */
    public static List<OrderItem> createTestOrderItems() {
        List<OrderItem> orderItems = new LinkedList<OrderItem>();
        OrderItem orderItem = new OrderItem();
        orderItem.setObject("order_item");
        orderItem.setAmount(50000);
        orderItem.setCurrency("USD");
        orderItem.setDescription("DataONE Individual Membership");
        orderItem.setParent(1000);
        orderItem.setQuantity(1);
        orderItem.setType("sku");

        orderItems.add(orderItem);
        return orderItems;
    }

    /**
     * Create a test status transitions object for an order
     * @return statusTransitions the status transitions object
     */
    public static ObjectNode createTestStatusTransitions() {
        ObjectMapper mapper = Jackson.newObjectMapper();
        ObjectNode statusTransitions = mapper.createObjectNode();
        statusTransitions.put("created", 1559768309);
        statusTransitions.put("paid", 1559768309);

        return statusTransitions;
    }
}
