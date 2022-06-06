# dynamodb-example
 
           
### A Java project using DynamoDB ([aws sdk for java](https://docs.aws.amazon.com/pt_br/amazondynamodb/latest/developerguide/sdk-general-information-section.html))

    
> [Amazon DynamoDB](https://aws.amazon.com/dynamodb/) is a key-value NoSQL database. Its designed to run high-perfomance applications.

- The [object persistence interface](https://docs.aws.amazon.com/us_en/amazondynamodb/latest/developerguide/Programming.SDKs.Interfaces.Mapper.html) (DynamoDBMapper) was used to map the classes into tables and objects into table items, so that it's possible to interact only with these objects to perform database operations.
- There's also a [low level interface](https://docs.aws.amazon.com/us_en/amazondynamodb/latest/developerguide/Programming.SDKs.Interfaces.LowLevel.html) (AmazonDynamoDB) , which resembles the [DynamoDB API](https://docs.aws.amazon.com/us_en/amazondynamodb/latest/developerguide/HowItWorks.API.html).