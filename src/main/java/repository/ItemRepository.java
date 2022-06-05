package repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import domain.Item;


public class ItemRepository {
    
    DynamoDBMapper dynamoDBMapper;
    
    public ItemRepository(DynamoDBMapper dynamoDBMapper){
        this.dynamoDBMapper = dynamoDBMapper;
    }



    public void save(Item item) {
        dynamoDBMapper.save(item);

    }

    public Item findById(String id){
        return dynamoDBMapper.load(Item.class,id);
    }

    public void delete(Item item){
        dynamoDBMapper.delete(item);
    }
}
