package repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import domain.Item;


public class ItemMapperRepository {

    final DynamoDBMapper dynamoDBMapper;
    
    public ItemMapperRepository(final DynamoDBMapper dynamoDBMapper){
        this.dynamoDBMapper = dynamoDBMapper;
    }



    public void save(final Item item) {
        dynamoDBMapper.save(item);

    }

    public Item findById(final String id){
        return dynamoDBMapper.load(Item.class,id);
    }

    public void delete(final Item item){
        dynamoDBMapper.delete(item);
    }
}
