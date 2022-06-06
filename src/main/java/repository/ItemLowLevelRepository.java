package repository;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.AttributeValueUpdate;
import domain.Item;

import java.util.HashMap;
import java.util.Map;

public class ItemLowLevelRepository {

    final AmazonDynamoDB amazonDynamoDB;
    final String tableName = "item";

    public ItemLowLevelRepository(final AmazonDynamoDB amazonDynamoDB){
        this.amazonDynamoDB=amazonDynamoDB;
    }

    public void save(final Item item){

        //Reflections API could help in this conversion (helpful if generalization is needed)
        Map<String, AttributeValue> attributesMap = new HashMap<>();

        attributesMap.put("id",new AttributeValue().withS(item.getId()));
        attributesMap.put("name",new AttributeValue().withS(item.getName()));
        attributesMap.put("price", new AttributeValue().withN(String.valueOf(item.getPrice())));


        amazonDynamoDB.putItem(tableName, attributesMap).getAttributes();
    }


    public Map<String, AttributeValue> findById(final String id){
        Map<String, AttributeValue> attributesMap = new HashMap<>();
        attributesMap.put("id",new AttributeValue().withS(id));


        return amazonDynamoDB.getItem(tableName,attributesMap).getItem();
    }


    public void update(final Item item){
        Map<String, AttributeValue> attributesMap = new HashMap<>();
        attributesMap.put("id",new AttributeValue().withS(item.getId()));

        Map<String, AttributeValueUpdate> attributesUpdateMap = new HashMap<>();
        attributesUpdateMap.put("name",
                new AttributeValueUpdate()
                        .withValue(new AttributeValue()
                                .withS(item.getName()))
                                .withAction("PUT"));

        attributesUpdateMap.put("price",
                new AttributeValueUpdate()
                        .withValue(new AttributeValue()
                                .withS(String.valueOf(item.getPrice())))
                        .withAction("PUT"));


        amazonDynamoDB.updateItem(tableName, attributesMap,attributesUpdateMap).getAttributes();
    }

    public void delete(final Item item){
        Map<String, AttributeValue> attributesMap = new HashMap<>();
        attributesMap.put("id",new AttributeValue().withS(item.getId()));


        amazonDynamoDB.deleteItem(tableName,attributesMap);
    }

}
